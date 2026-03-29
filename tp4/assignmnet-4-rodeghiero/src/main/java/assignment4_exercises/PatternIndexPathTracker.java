package assignment4_exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Lightweight runtime tracker for PatternIndex path instrumentation.
 */
public final class PatternIndexPathTracker {

    public static final class Invocation {
        private final String subject;
        private final String pattern;
        private final int result;
        private final List<String> path;

        Invocation(String subject, String pattern, int result, List<String> path) {
            this.subject = subject;
            this.pattern = pattern;
            this.result = result;
            this.path = path;
        }

        public String getSubject() {
            return subject;
        }

        public String getPattern() {
            return pattern;
        }

        public int getResult() {
            return result;
        }

        public List<String> getPath() {
            return path;
        }
    }

    private static boolean enabled = true;
    private static final List<Invocation> INVOCATIONS = new ArrayList<Invocation>();
    private static final ThreadLocal<List<String>> CURRENT_PATH = new ThreadLocal<List<String>>();
    private static final ThreadLocal<String> CURRENT_SUBJECT = new ThreadLocal<String>();
    private static final ThreadLocal<String> CURRENT_PATTERN = new ThreadLocal<String>();

    private PatternIndexPathTracker() {
    }

    public static synchronized void setEnabled(boolean value) {
        enabled = value;
    }

    public static synchronized void reset() {
        INVOCATIONS.clear();
        CURRENT_PATH.remove();
        CURRENT_SUBJECT.remove();
        CURRENT_PATTERN.remove();
    }

    public static void startInvocation(String subject, String pattern) {
        if (!enabled) {
            return;
        }
        CURRENT_SUBJECT.set(subject);
        CURRENT_PATTERN.set(pattern);
        CURRENT_PATH.set(new ArrayList<String>());
    }

    public static void hit(String nodeId) {
        if (!enabled) {
            return;
        }
        List<String> path = CURRENT_PATH.get();
        if (path != null) {
            path.add(nodeId);
        }
    }

    public static void endInvocation(int result) {
        if (!enabled) {
            return;
        }
        List<String> path = CURRENT_PATH.get();
        if (path == null) {
            return;
        }
        String subject = CURRENT_SUBJECT.get();
        String pattern = CURRENT_PATTERN.get();
        List<String> snapshot = Collections.unmodifiableList(new ArrayList<String>(path));
        synchronized (PatternIndexPathTracker.class) {
            INVOCATIONS.add(new Invocation(subject, pattern, result, snapshot));
        }
        CURRENT_PATH.remove();
        CURRENT_SUBJECT.remove();
        CURRENT_PATTERN.remove();
    }

    public static synchronized List<Invocation> getInvocations() {
        return Collections.unmodifiableList(new ArrayList<Invocation>(INVOCATIONS));
    }
}

