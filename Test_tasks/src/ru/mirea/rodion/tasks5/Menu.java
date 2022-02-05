package ru.mirea.rodion.tasks5;

import ru.mirea.rodion.tasks5.ItemService;

import java.util.Scanner;

public class Menu {
    private final String startMessage =
            "\n1. Получить спиоск предметов\n" +
                    "2. Сортировать предметы по цене\n" +
                    "3. Положите предметы с максимальной ценой в сейф\n" +
                    "4. Выход\n";

    private final Scanner scanner;
    private final ItemService service;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.service = new ItemService();
    }

    public void mainMenu() {
        int choice;
        int volume;
        while (true) {
            choice = getAnswerFromMenu(startMessage, 4);
            switch (choice) {
                case 1:
                    service.printItemList();
                    break;
                case 2:
                    service.printSortedListByPrice(service.sortByPrice());
                    break;
                case 3:
                    setAModelOfTheSafe();
                    service.printItemInTheSafeWithMaxPrice(service.putItemInTheSafeWithMaxPrice
                            (service.sortByPrice(), getVolumeFromConsole()));
                    break;
                case 4:
                    return;
            }
        }
    }

    private boolean isNumber1(String str) {
        if (str.isEmpty()) {//  if (str == null || str.isEmpty())
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void errorMenu(String errorMessage) {
        System.out.println(errorMessage);
        scanner.nextLine();
    }

    private void setAModelOfTheSafe() {
        System.out.println("Введите модель сейфа: ");
        String model = scanner.nextLine();
    }

    private int getAnswerFromMenu(String message, int menuSize) {
        String answer;
        int result;
        while (true) {
            System.out.println(message);
            if (scanner.hasNextLine()) {
                answer = scanner.nextLine();
                if (isNumber1(answer)) {
                    result = Integer.parseInt(answer);
                    if (result <= menuSize && result > 0) {
                        return result;
                    } else {
                        errorMenu("Пожалуйста, введите цифры от 1 до "
                                + menuSize + "\nнажмите любую клавишу чтобы продолжить");
                    }
                } else {
                    errorMenu("Пожалуйста, вводите только цифры "
                            + "\nнажмите любую клавишу чтобы продолжить");
                }
            }
        }
    }

    private int getVolumeFromConsole() {
        int volumeInt;
        String volumeStr;
        while (true) {
            System.out.println("Введите объем сейфа: ");
            volumeStr = scanner.nextLine();
            if (isNumber1(volumeStr)) {
                volumeInt = Integer.parseInt(volumeStr);

                if (volumeInt >= service.findMinVolumeFromItemList() && volumeInt > 0) {
                    return volumeInt;
                } else {
                    errorMenu("Введите объем сейфа более " +
                            +service.findMinVolumeFromItemList()
                            + "\n нажмите любую клавишу чтобы продолжить");
                }
            } else {
                errorMenu("Пожалуйста, вводите только цифры .\n Введите объем сейфа более " +
                        +service.findMinVolumeFromItemList()
                        + "\n нажмите любую клавишу чтобы продолжить");
            }
        }
    }
}