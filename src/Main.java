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
                System.out.print("�������� ����� ����: ");
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
                    System.out.println("�������� ����� ���� �� ������!");
                }
            }
        }
    }



    private static void printMenu() {
        System.out.println(
                " 1. �������� ������ 2. ������� ������ 3. �������� ������ �� ��������� ���� 0. ����� "
        );
    }















    }

