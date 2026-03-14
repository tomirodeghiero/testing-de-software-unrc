import java.util.Arrays;

public final class Exercise3Runner {
    private Exercise3Runner() {
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        String mode = args[0];
        String target = args[1];

        if (!mode.equals("faulty") && !mode.equals("fixed")) {
            printUsage();
            return;
        }

        if (target.equals("all")) {
            runFindLast(mode);
            runLastZero(mode);
            runCountPositive(mode);
            runOddOrPos(mode);
            return;
        }

        switch (target) {
            case "findLast":
                runFindLast(mode);
                break;
            case "lastZero":
                runLastZero(mode);
                break;
            case "countPositive":
                runCountPositive(mode);
                break;
            case "oddOrPos":
                runOddOrPos(mode);
                break;
            default:
                printUsage();
                break;
        }
    }

    private static void runFindLast(String mode) {
        System.out.println("=== findLast (" + mode + ") ===");
        System.out.println("b) No se puede evitar ejecutar el defecto con entradas validas.");

        int[] cArray = {5, 2, 3};
        int cExpected = 1;
        int cActual = callFindLast(mode, cArray, 2);
        printResult("c", "x=" + Arrays.toString(cArray) + ", y=2", cExpected, cActual);

        int[] dArray = {2, 3, 5};
        int dExpected = 0;
        int dActual = callFindLast(mode, dArray, 2);
        printResult("d", "x=" + Arrays.toString(dArray) + ", y=2", dExpected, dActual);
        System.out.println();
    }

    private static void runLastZero(String mode) {
        System.out.println("=== lastZero (" + mode + ") ===");
        System.out.println("b) No se puede evitar ejecutar el defecto con arreglos no nulos.");

        int[] cArray = {1, 0, 2};
        int cExpected = 1;
        int cActual = callLastZero(mode, cArray);
        printResult("c", "x=" + Arrays.toString(cArray), cExpected, cActual);

        int[] dArray = {0, 1, 0};
        int dExpected = 2;
        int dActual = callLastZero(mode, dArray);
        printResult("d", "x=" + Arrays.toString(dArray), dExpected, dActual);
        System.out.println();
    }

    private static void runCountPositive(String mode) {
        System.out.println("=== countPositive (" + mode + ") ===");

        int[] bArray = {};
        int bExpected = 0;
        int bActual = callCountPositive(mode, bArray);
        printResult("b", "x=" + Arrays.toString(bArray), bExpected, bActual);

        int[] cArray = {-4, 2, 2};
        int cExpected = 2;
        int cActual = callCountPositive(mode, cArray);
        printResult("c", "x=" + Arrays.toString(cArray), cExpected, cActual);

        int[] dArray = {-4, 2, 0, 2};
        int dExpected = 2;
        int dActual = callCountPositive(mode, dArray);
        printResult("d", "x=" + Arrays.toString(dArray), dExpected, dActual);
        System.out.println();
    }

    private static void runOddOrPos(String mode) {
        System.out.println("=== oddOrPos (" + mode + ") ===");

        int[] bArray = {};
        int bExpected = 0;
        int bActual = callOddOrPos(mode, bArray);
        printResult("b", "x=" + Arrays.toString(bArray), bExpected, bActual);

        int[] cArray = {2, 4, -2};
        int cExpected = 2;
        int cActual = callOddOrPos(mode, cArray);
        printResult("c", "x=" + Arrays.toString(cArray), cExpected, cActual);

        int[] dArray = {-3, -2, 0, 1, 4};
        int dExpected = 3;
        int dActual = callOddOrPos(mode, dArray);
        printResult("d", "x=" + Arrays.toString(dArray), dExpected, dActual);
        System.out.println();
    }

    private static int callFindLast(String mode, int[] x, int y) {
        if (mode.equals("faulty")) {
            return DefectivePrograms.findLast(x, y);
        }
        return FixedPrograms.findLast(x, y);
    }

    private static int callLastZero(String mode, int[] x) {
        if (mode.equals("faulty")) {
            return DefectivePrograms.lastZero(x);
        }
        return FixedPrograms.lastZero(x);
    }

    private static int callCountPositive(String mode, int[] x) {
        if (mode.equals("faulty")) {
            return DefectivePrograms.countPositive(x);
        }
        return FixedPrograms.countPositive(x);
    }

    private static int callOddOrPos(String mode, int[] x) {
        if (mode.equals("faulty")) {
            return DefectivePrograms.oddOrPos(x);
        }
        return FixedPrograms.oddOrPos(x);
    }

    private static void printResult(String label, String input, int expected, int actual) {
        String status = expected == actual ? "OK" : "FALLA";
        System.out.println(
            label + ") " + input + " -> esperado=" + expected + ", actual=" + actual + " [" + status + "]"
        );
    }

    private static void printUsage() {
        System.out.println("Uso: java Exercise3Runner <faulty|fixed> <all|findLast|lastZero|countPositive|oddOrPos>");
    }
}
