package assignment4_exercises;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PatternIndexInstrumentationCoverageTest {

    private static final class CaseRow {
        private final String subject;
        private final String pattern;
        private final int expected;

        private CaseRow(String subject, String pattern, int expected) {
            this.subject = subject;
            this.pattern = pattern;
            this.expected = expected;
        }
    }

    private static final List<CaseRow> TABLE_CASES = Arrays.asList(
        new CaseRow("a", "bc", -1),
        new CaseRow("ab", "a", 0),
        new CaseRow("ab", "ab", 0),
        new CaseRow("ab", "ac", -1),
        new CaseRow("ab", "b", 1),
        new CaseRow("ab", "c", -1),
        new CaseRow("abc", "abc", 0),
        new CaseRow("abc", "abd", -1),
        new CaseRow("abc", "ba", -1),
        new CaseRow("abc", "bc", 1)
    );

    // CFG nodes used by PatternIndex instrumentation:
    // S, W, I, M, FT, IFM, MIS, FI, FF, INC, R
    private static final List<String[]> GRAPH_EDGES = Arrays.asList(
        new String[] {"S", "W"},
        new String[] {"W", "I"},
        new String[] {"W", "R"},
        new String[] {"I", "M"},
        new String[] {"I", "INC"},
        new String[] {"M", "FT"},
        new String[] {"M", "FF"},
        new String[] {"FT", "IFM"},
        new String[] {"IFM", "MIS"},
        new String[] {"IFM", "FI"},
        new String[] {"FI", "FT"},
        new String[] {"FI", "FF"},
        new String[] {"MIS", "INC"},
        new String[] {"FF", "INC"},
        new String[] {"INC", "W"}
    );

    @BeforeClass
    public static void beforeAll() {
        PatternIndexPathTracker.setEnabled(true);
        PatternIndexPathTracker.reset();
    }

    @Test
    public void tableDrivenCases() {
        for (CaseRow row : TABLE_CASES) {
            int actual = PatternIndex.patternIndex(row.subject, row.pattern);
            assertEquals(
                "subject=" + row.subject + ", pattern=" + row.pattern,
                row.expected,
                actual
            );
        }
    }

    @AfterClass
    public static void afterAll() throws IOException {
        List<PatternIndexPathTracker.Invocation> invocations = PatternIndexPathTracker.getInvocations();

        List<String> edgeRequirements = edgeRequirementIds();
        Set<String> coveredEdges = coveredEdges(invocations);

        List<List<String>> primePathRequirements = primePathsFromGraph();
        Set<String> coveredPrimePaths = coveredPrimePaths(invocations, primePathRequirements);

        StringBuilder report = new StringBuilder();
        report.append("=== PatternIndex Path Execution Report ===\n");
        report.append("Invocations: ").append(invocations.size()).append("\n\n");

        int index = 1;
        for (PatternIndexPathTracker.Invocation inv : invocations) {
            report.append(index++)
                .append(") subject=\"").append(inv.getSubject())
                .append("\", pattern=\"").append(inv.getPattern())
                .append("\", output=").append(inv.getResult())
                .append("\n");
            report.append("   path: ").append(String.join("->", inv.getPath())).append("\n");
        }

        report.append("\n=== Edge Coverage (CFG) ===\n");
        report.append("covered: ").append(coveredEdges.size())
            .append(" / ").append(edgeRequirements.size()).append("\n");
        report.append("covered edges: ").append(joinSorted(coveredEdges)).append("\n");
        Set<String> missingEdges = new LinkedHashSet<String>(edgeRequirements);
        missingEdges.removeAll(coveredEdges);
        report.append("missing edges: ").append(joinSorted(missingEdges)).append("\n");

        report.append("\n=== Prime Path Coverage (CFG) ===\n");
        report.append("prime path requirements: ").append(primePathRequirements.size()).append("\n");
        report.append("covered prime paths: ").append(coveredPrimePaths.size())
            .append(" / ").append(primePathRequirements.size()).append("\n");

        List<String> missingPrimePathIds = new ArrayList<String>();
        for (List<String> req : primePathRequirements) {
            String id = pathId(req);
            if (!coveredPrimePaths.contains(id)) {
                missingPrimePathIds.add(id);
            }
        }
        Collections.sort(missingPrimePathIds);
        report.append("missing prime paths: ").append(joinSorted(new LinkedHashSet<String>(missingPrimePathIds))).append("\n");

        report.append("\n=== Prime Path Requirements ===\n");
        int reqIndex = 1;
        for (List<String> req : primePathRequirements) {
            String reqId = pathId(req);
            report.append(reqIndex++)
                .append(". ")
                .append(reqId)
                .append(" -> ")
                .append(coveredPrimePaths.contains(reqId) ? "COVERED" : "MISSING")
                .append("\n");
        }

        String output = report.toString();
        System.out.println(output);

        Files.createDirectories(Paths.get("target"));
        Files.write(
            Paths.get("target/patternindex-path-report.txt"),
            output.getBytes(StandardCharsets.UTF_8)
        );
    }

    private static List<String> edgeRequirementIds() {
        List<String> ids = new ArrayList<String>();
        for (String[] edge : GRAPH_EDGES) {
            ids.add(edge[0] + "->" + edge[1]);
        }
        Collections.sort(ids);
        return ids;
    }

    private static Set<String> coveredEdges(List<PatternIndexPathTracker.Invocation> invocations) {
        Set<String> covered = new LinkedHashSet<String>();
        for (PatternIndexPathTracker.Invocation inv : invocations) {
            List<String> path = inv.getPath();
            for (int i = 0; i < path.size() - 1; i++) {
                covered.add(path.get(i) + "->" + path.get(i + 1));
            }
        }
        return covered;
    }

    private static Set<String> coveredPrimePaths(
        List<PatternIndexPathTracker.Invocation> invocations,
        List<List<String>> requirements
    ) {
        Set<String> covered = new LinkedHashSet<String>();
        for (List<String> req : requirements) {
            for (PatternIndexPathTracker.Invocation inv : invocations) {
                if (containsSubPath(inv.getPath(), req)) {
                    covered.add(pathId(req));
                    break;
                }
            }
        }
        return covered;
    }

    private static boolean containsSubPath(List<String> path, List<String> subPath) {
        if (subPath.size() > path.size()) {
            return false;
        }
        for (int i = 0; i <= path.size() - subPath.size(); i++) {
            boolean match = true;
            for (int j = 0; j < subPath.size(); j++) {
                if (!path.get(i + j).equals(subPath.get(j))) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    private static String pathId(List<String> path) {
        return "[" + String.join("->", path) + "]";
    }

    private static String joinSorted(Set<String> values) {
        List<String> sorted = new ArrayList<String>(values);
        Collections.sort(sorted);
        return sorted.toString();
    }

    private static List<List<String>> primePathsFromGraph() {
        Set<String> nodes = new LinkedHashSet<String>();
        Map<String, List<String>> adj = new HashMap<String, List<String>>();
        for (String[] edge : GRAPH_EDGES) {
            nodes.add(edge[0]);
            nodes.add(edge[1]);
            if (!adj.containsKey(edge[0])) {
                adj.put(edge[0], new ArrayList<String>());
            }
            adj.get(edge[0]).add(edge[1]);
        }
        for (String node : nodes) {
            if (!adj.containsKey(node)) {
                adj.put(node, new ArrayList<String>());
            }
        }

        Set<List<String>> simplePaths = new LinkedHashSet<List<String>>();
        for (String start : nodes) {
            dfsSimplePaths(start, new ArrayList<String>(Arrays.asList(start)), adj, simplePaths);
        }

        List<List<String>> allSimple = new ArrayList<List<String>>(simplePaths);
        List<List<String>> prime = new ArrayList<List<String>>();
        for (List<String> candidate : allSimple) {
            boolean subpathOfLarger = false;
            for (List<String> other : allSimple) {
                if (other.size() > candidate.size() && isSubPath(candidate, other)) {
                    subpathOfLarger = true;
                    break;
                }
            }
            if (!subpathOfLarger) {
                prime.add(candidate);
            }
        }

        Collections.sort(prime, (a, b) -> pathId(a).compareTo(pathId(b)));
        return prime;
    }

    private static void dfsSimplePaths(
        String start,
        List<String> path,
        Map<String, List<String>> adj,
        Set<List<String>> out
    ) {
        out.add(new ArrayList<String>(path));

        String last = path.get(path.size() - 1);
        for (String next : adj.get(last)) {
            if (next.equals(start) && !path.subList(1, path.size()).contains(start)) {
                List<String> cycle = new ArrayList<String>(path);
                cycle.add(next);
                out.add(cycle);
            }
            if (!path.contains(next)) {
                List<String> extended = new ArrayList<String>(path);
                extended.add(next);
                dfsSimplePaths(start, extended, adj, out);
            }
        }
    }

    private static boolean isSubPath(List<String> a, List<String> b) {
        if (a.size() > b.size()) {
            return false;
        }
        for (int i = 0; i <= b.size() - a.size(); i++) {
            boolean matches = true;
            for (int j = 0; j < a.size(); j++) {
                if (!a.get(j).equals(b.get(i + j))) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                return true;
            }
        }
        return false;
    }
}

