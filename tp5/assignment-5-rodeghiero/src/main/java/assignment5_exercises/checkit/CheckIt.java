package assignment5_exercises.checkit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CheckIt {

    private CheckIt() {
        // Utility class
    }

    // Predicado original del enunciado: p = a && (b || c)
    public static boolean checkIt(boolean a, boolean b, boolean c) {
        return a && (b || c);
    }

    // Version expandida: cada if usa exactamente una variable booleana.
    // Ademas registra nodos recorridos para analizar cobertura estructural.
    public static ExecutionTrace checkItExpand(boolean a, boolean b, boolean c) {
        List<String> nodes = new ArrayList<String>();
        nodes.add("START");

        boolean result;
        nodes.add("A");
        if (a) {
            nodes.add("B");
            if (b) {
                nodes.add("TRUE");
                result = true;
            } else {
                nodes.add("C");
                if (c) {
                    nodes.add("TRUE");
                    result = true;
                } else {
                    nodes.add("FALSE");
                    result = false;
                }
            }
        } else {
            nodes.add("FALSE");
            result = false;
        }

        nodes.add("END");
        return new ExecutionTrace(result, nodes);
    }

    public static final class ExecutionTrace {
        private final boolean result;
        private final List<String> nodes;

        ExecutionTrace(boolean result, List<String> nodes) {
            this.result = result;
            this.nodes = Collections.unmodifiableList(new ArrayList<String>(nodes));
        }

        public boolean isTruePredicate() {
            return result;
        }

        public List<String> getNodes() {
            return nodes;
        }

        public List<String> getEdges() {
            List<String> edges = new ArrayList<String>();
            for (int i = 0; i < nodes.size() - 1; i++) {
                edges.add(nodes.get(i) + "->" + nodes.get(i + 1));
            }
            return edges;
        }
    }
}
