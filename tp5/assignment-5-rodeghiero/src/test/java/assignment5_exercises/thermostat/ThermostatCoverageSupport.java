package assignment5_exercises.thermostat;

final class ThermostatCoverageSupport {
    private static final int PROGRAMMED_TEMP = 69;
    private static final int THRESHOLD_DIFF = 5;
    private static final int MIN_LAG = 10;

    private ThermostatCoverageSupport() {
        // Utility class
    }

    static ExecutionResult runCase(boolean targetA, boolean targetB, boolean targetC, boolean targetD) {
        Thermostat thermostat = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, PROGRAMMED_TEMP);
        thermostat.setPeriod(Period.MORNING);
        thermostat.setDay(DayType.WEEKDAY);

        int curTemp = targetA ? 60 : 66;
        int overTemp = targetC ? curTemp + 6 : curTemp + 5;
        int timeSinceLastRun = targetD ? 11 : 10;

        thermostat.setCurrentTemp(curTemp);
        thermostat.setThresholdDiff(THRESHOLD_DIFF);
        thermostat.setOverride(targetB);
        thermostat.setOverTemp(overTemp);
        thermostat.setMinLag(MIN_LAG);
        thermostat.setTimeSinceLastRun(timeSinceLastRun);

        boolean returned = thermostat.turnHeaterOn(settings);

        boolean a = curTemp < PROGRAMMED_TEMP - THRESHOLD_DIFF;
        boolean b = targetB;
        boolean c = curTemp < overTemp - THRESHOLD_DIFF;
        boolean d = timeSinceLastRun > MIN_LAG;
        boolean predicate = ((a || (b && c)) && d);

        return new ExecutionResult(returned, thermostat.getHeaterOn(), a, b, c, d, predicate);
    }

    static final class ExecutionResult {
        final boolean returned;
        final boolean heaterOn;
        final boolean a;
        final boolean b;
        final boolean c;
        final boolean d;
        final boolean predicate;

        ExecutionResult(boolean returned, boolean heaterOn, boolean a, boolean b, boolean c, boolean d, boolean predicate) {
            this.returned = returned;
            this.heaterOn = heaterOn;
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.predicate = predicate;
        }
    }
}
