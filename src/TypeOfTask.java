public enum TypeOfTask {
    PERSONAL("������ ������"),
    WORK("������� ������");

    private String description;

    TypeOfTask(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  description;
    }
}
