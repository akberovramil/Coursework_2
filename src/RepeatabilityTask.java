public enum RepeatabilityTask {
ONE_TIME("������������� - �����������"),
    DAY("����������� - ������ ����"),
    WEEK("������������� - ������ ������"),
    MONTH("������������� - ������ �����"),
    YEAR("������������� - ������ ���");


    private String description;

    RepeatabilityTask(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  description;
    }


}
