import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            Task.inputTask(scanner);
                            break;
                        case 2:
                            Task.deleteTask(scanner);
                            break;
                        case 3:
                            Task.getData(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }



    private static void printMenu() {
        System.out.println(
                " 1. Добавить задачу 2. Удалить задачу 3. Получить задачу на указанный день 0. Выход "
        );
    }















    }

