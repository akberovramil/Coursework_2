public enum TypeOfTask {
    PERSONAL("Личная задача"),
    WORK("Рабочая задача");

    private String description;

    TypeOfTask(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  description;
    }
}
