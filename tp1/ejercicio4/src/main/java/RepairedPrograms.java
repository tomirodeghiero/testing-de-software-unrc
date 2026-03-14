public final class RepairedPrograms {
    private RepairedPrograms() {
    }

    public static int findLast(int[] x, int y) {
        // Ahora tambien se revisa la posicion 0.
        for (int i = x.length - 1; i >= 0; i--) {
            if (x[i] == y) {
                return i;
            }
        }
        return -1;
    }

    public static int lastZero(int[] x) {
        // Se recorre desde el final para devolver el ultimo cero.
        for (int i = x.length - 1; i >= 0; i--) {
            if (x[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int countPositive(int[] x) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            // Solo cuentan los mayores que 0.
            if (x[i] > 0) {
                count++;
            }
        }
        return count;
    }

    public static int oddOrPos(int[] x) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            // Asi tambien se cuentan los impares negativos.
            if (x[i] % 2 != 0 || x[i] > 0) {
                count++;
            }
        }
        return count;
    }
}
