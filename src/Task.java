import java.security.KeyStore;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Task {
    private static String heading;
    private static String description;
    private static LocalDate timeOfTask;
    TypeOfTask typeOfTask;
   public RepeatabilityTask repeatabilityTask;
    private static int id;
    private static int count;
    public static  Map<Integer, Task> tasks1 = new HashMap<>();



    public Task(String heading, String description, LocalDate timeOfTask, TypeOfTask typeOfTask, RepeatabilityTask repeatabilityTask) {
        if (heading == null || heading.isEmpty() || heading.isBlank()) {
            throw new RuntimeException("Не указан заголовок задачи");
        } else {
            this.heading = heading;
        }
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new RuntimeException("Не указано описание задачи");
        } else {
            this.description = description;
        }

        this.timeOfTask = timeOfTask;
        this.typeOfTask = typeOfTask;
        if (repeatabilityTask == null) {
            throw new RuntimeException("Не указан тип повторяемости");
        } else {
            this.repeatabilityTask = repeatabilityTask;
        }
        id = ++count;
    }


    public static void displayDayTasks(LocalDate randomDate, Map<Integer, Task> taskss ) {
        Map<Integer, Task>dayMap = new HashMap<>();
        Map<Integer, Task>ggMap = new HashMap<>();




        for (Map.Entry<Integer, Task> newMap: tasks1.entrySet()) {
            if (newMap.getValue().timeOfTask.equals(randomDate)) {
                dayMap.put(newMap.getKey(), newMap.getValue());
                //System.out.println(tasks1);
                if (newMap.getValue().repeatabilityTask.equals(RepeatabilityTask.DAY)) {
                    newMap.getValue().setTimeOfTask(newMap.getValue().getNextRepeatablyForDay());
                }
                if (newMap.getValue().repeatabilityTask.equals(RepeatabilityTask.WEEK)) {
                    newMap.getValue().setTimeOfTask(newMap.getValue().getNextRepeatablyForWeek());
                }
                if (newMap.getValue().repeatabilityTask.equals(RepeatabilityTask.MONTH)) {
                    newMap.getValue().setTimeOfTask(newMap.getValue().getNextRepeatablyForMonth());
                }
                if (newMap.getValue().repeatabilityTask.equals(RepeatabilityTask.YEAR)) {
                    newMap.getValue().setTimeOfTask(newMap.getValue().getNextRepeatablyForYear());
                }
            }
            System.out.println(tasks1.toString());
        }

    }
    public static void deleteTask(Scanner scanner) {
        System.out.println("Введите ID задачи: ");
        Task.count = scanner.nextInt();
        for (Map.Entry<Integer, Task> idMap : tasks1.entrySet()) {
            if (idMap.getKey().equals(getCount())) {
                tasks1.remove(idMap.getKey(), idMap.getValue());
                break;
            }

        }
    }

    public  void defineDate(Task task) {
        while (task.repeatabilityTask == repeatabilityTask.DAY) {
            task.timeOfTask.plusDays(1);
            System.out.println("Следующая дата выполнения - " + task.timeOfTask);
        }
        while (task.repeatabilityTask == repeatabilityTask.WEEK) {
            task.timeOfTask.plusWeeks(1);
            System.out.println("Следующая дата выполнения - " + task.timeOfTask);
        }
        while (task.repeatabilityTask == repeatabilityTask.MONTH) {
            task.timeOfTask.plusMonths(1);
            System.out.println("Следующая дата выполнения - " + task.timeOfTask);
        }
        while (task.repeatabilityTask == repeatabilityTask.YEAR) {
            task.timeOfTask.plusYears(1);
            System.out.println("Следующая дата выполнения - " + task.timeOfTask);
        }
        if (task.repeatabilityTask == repeatabilityTask.DAY) {
            task.timeOfTask.plusDays(1);
            System.out.println("Следующая дата выполнения - " + task.timeOfTask);
        }
    }
    public static void inputTask(Scanner scanner) {
        TypeOfTask typeOfTask = null;
        RepeatabilityTask repeatabilityTask = null;
        System.out.println("Введите название задачи: ");
        String headin = scanner.next();
        System.out.println("Введите описание задачи: ");
        String description = scanner.next();
        System.out.print("Введите дату задачи: ");
       LocalDate timeOfTask = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.print("Задача личная или рабочая? Введите 1, если личная, а 2, если рабочая ");
        int typeOf = scanner.nextInt();
        if (typeOf == 1) {
            typeOfTask = TypeOfTask.PERSONAL;
        } else if (typeOf == 2) {
            typeOfTask = TypeOfTask.WORK;
        } else {
            throw new RuntimeException("Введено неверное число");
        }
        System.out.println("Введите повторяемость. 1 - если ежедневная, 2 - раз в неделю, 3 - каждый месяц, 4 - раз в год, 5 - только один раз ");
        int repeat = scanner.nextInt();
        if (repeat == 1) {
            repeatabilityTask = RepeatabilityTask.DAY;
        } else if (repeat == 2) {
            repeatabilityTask = RepeatabilityTask.WEEK;
        } else if (repeat == 3) {
            repeatabilityTask = RepeatabilityTask.MONTH;
        } else if (repeat == 4) {
            repeatabilityTask = RepeatabilityTask.YEAR;
        } else if (repeat == 5) {
            repeatabilityTask = RepeatabilityTask.ONE_TIME;
        }else {
            throw new RuntimeException("Введено неверное число");
        }
        Task newTask = new Task(headin, description, timeOfTask, typeOfTask, repeatabilityTask);
        tasks1.put(newTask.getId(),  newTask);
        System.out.println(tasks1);
    }

    public static void getData(Scanner scanner) {
        System.out.println("Введите дату");
        LocalDate time = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        Task.displayDayTasks(time, tasks1);
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTimeOfTask() {
        return timeOfTask;
    }

    public void setTimeOfTask(LocalDate timeOfTask) {
        this.timeOfTask = timeOfTask;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }

    public RepeatabilityTask getRepeatabilityTask() {
        return repeatabilityTask;
    }

    public LocalDate getNextRepeatablyForDay() {
        return timeOfTask.plusDays(1);

    }
    public LocalDate getNextRepeatablyForWeek() {
        return timeOfTask.plusWeeks(1);
    }
    public LocalDate getNextRepeatablyForMonth() {
        return timeOfTask.plusMonths(1);
    }
    public LocalDate getNextRepeatablyForYear() {
        return timeOfTask.plusYears(1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return typeOfTask == task.typeOfTask && repeatabilityTask == task.repeatabilityTask;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfTask, repeatabilityTask);
    }

    @Override
    public String toString() {
        return "Задача " + heading + ", " +
                " описание - " +  description + ", " +
                " время " + timeOfTask + ", " +  typeOfTask.toString() +  ", " +  repeatabilityTask.toString() +
                ", id " + id + "";
    }

}
