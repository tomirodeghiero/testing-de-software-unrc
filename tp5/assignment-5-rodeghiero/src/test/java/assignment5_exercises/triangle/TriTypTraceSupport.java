package assignment5_exercises.triangle;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

final class TriTypTraceSupport {

    private TriTypTraceSupport() {
        // Utility class
    }

    static Trace run(int s1, int s2, int s3) {
        Map<String, PredicateEval> predicates = new LinkedHashMap<String, PredicateEval>();

        boolean p1c1 = s1 <= 0;
        boolean p1c2 = s2 <= 0;
        boolean p1c3 = s3 <= 0;
        boolean p1 = p1c1 || p1c2 || p1c3;
        predicates.put("P1", eval(
            clause("c1", p1c1),
            clause("c2", p1c2),
            clause("c3", p1c3),
            p1
        ));
        if (p1) {
            return done(s1, s2, s3, 4, predicates);
        }

        int triOut = 0;

        boolean p2 = s1 == s2;
        predicates.put("P2", eval(clause("c", p2), p2));
        if (p2) {
            triOut += 1;
        }

        boolean p3 = s1 == s3;
        predicates.put("P3", eval(clause("c", p3), p3));
        if (p3) {
            triOut += 2;
        }

        boolean p4 = s2 == s3;
        predicates.put("P4", eval(clause("c", p4), p4));
        if (p4) {
            triOut += 3;
        }

        boolean p5 = triOut == 0;
        predicates.put("P5", eval(clause("c", p5), p5));
        if (p5) {
            boolean p6d1 = s1 + s2 <= s3;
            boolean p6d2 = s2 + s3 <= s1;
            boolean p6d3 = s1 + s3 <= s2;
            boolean p6 = p6d1 || p6d2 || p6d3;
            predicates.put("P6", eval(
                clause("d1", p6d1),
                clause("d2", p6d2),
                clause("d3", p6d3),
                p6
            ));

            triOut = p6 ? 4 : 1;
            return done(s1, s2, s3, triOut, predicates);
        }

        boolean p7 = triOut > 3;
        predicates.put("P7", eval(clause("c", p7), p7));
        if (p7) {
            triOut = 3;
            return done(s1, s2, s3, triOut, predicates);
        }

        boolean p8e1 = triOut == 1;
        boolean p8e2 = s1 + s2 > s3;
        boolean p8 = p8e1 && p8e2;
        predicates.put("P8", eval(
            clause("e1", p8e1),
            clause("e2", p8e2),
            p8
        ));
        if (p8) {
            triOut = 2;
            return done(s1, s2, s3, triOut, predicates);
        }

        boolean p9f1 = triOut == 2;
        boolean p9f2 = s1 + s3 > s2;
        boolean p9 = p9f1 && p9f2;
        predicates.put("P9", eval(
            clause("f1", p9f1),
            clause("f2", p9f2),
            p9
        ));
        if (p9) {
            triOut = 2;
            return done(s1, s2, s3, triOut, predicates);
        }

        boolean p10g1 = triOut == 3;
        boolean p10g2 = s2 + s3 > s1;
        boolean p10 = p10g1 && p10g2;
        predicates.put("P10", eval(
            clause("g1", p10g1),
            clause("g2", p10g2),
            p10
        ));

        triOut = p10 ? 2 : 4;
        return done(s1, s2, s3, triOut, predicates);
    }

    private static Trace done(int s1, int s2, int s3, int tracedOutput, Map<String, PredicateEval> predicates) {
        int realOutput = TriTyp.triang(s1, s2, s3);
        assertEquals(realOutput, tracedOutput);
        return new Trace(realOutput, predicates);
    }

    private static Map.Entry<String, Boolean> clause(String name, boolean value) {
        return new java.util.AbstractMap.SimpleEntry<String, Boolean>(name, value);
    }

    private static PredicateEval eval(Map.Entry<String, Boolean> c1, boolean predicate) {
        Map<String, Boolean> clauses = new LinkedHashMap<String, Boolean>();
        clauses.put(c1.getKey(), c1.getValue());
        return new PredicateEval(clauses, predicate);
    }

    private static PredicateEval eval(Map.Entry<String, Boolean> c1, Map.Entry<String, Boolean> c2, boolean predicate) {
        Map<String, Boolean> clauses = new LinkedHashMap<String, Boolean>();
        clauses.put(c1.getKey(), c1.getValue());
        clauses.put(c2.getKey(), c2.getValue());
        return new PredicateEval(clauses, predicate);
    }

    private static PredicateEval eval(
        Map.Entry<String, Boolean> c1,
        Map.Entry<String, Boolean> c2,
        Map.Entry<String, Boolean> c3,
        boolean predicate
    ) {
        Map<String, Boolean> clauses = new LinkedHashMap<String, Boolean>();
        clauses.put(c1.getKey(), c1.getValue());
        clauses.put(c2.getKey(), c2.getValue());
        clauses.put(c3.getKey(), c3.getValue());
        return new PredicateEval(clauses, predicate);
    }

    static final class Trace {
        final int output;
        final Map<String, PredicateEval> predicates;

        Trace(int output, Map<String, PredicateEval> predicates) {
            this.output = output;
            this.predicates = predicates;
        }
    }

    static final class PredicateEval {
        final Map<String, Boolean> clauses;
        final boolean predicate;

        PredicateEval(Map<String, Boolean> clauses, boolean predicate) {
            this.clauses = clauses;
            this.predicate = predicate;
        }
    }
}
