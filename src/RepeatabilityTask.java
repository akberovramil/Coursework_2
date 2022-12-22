public enum RepeatabilityTask {
ONE_TIME("Повторяемость - однократная"),
    DAY("Повторяемть - каждый день"),
    WEEK("Повторяемость - каждую неделю"),
    MONTH("Повторяемость - каждый месяц"),
    YEAR("Повторяемомть - каждый год");


    private String description;

    RepeatabilityTask(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  description;
    }


}
