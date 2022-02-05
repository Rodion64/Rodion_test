package ru.mirea.rodion.tasks5;

import ru.mirea.rodion.tasks5.Safe;
import ru.mirea.rodion.tasks5.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static ru.mirea.rodion.tasks5.ItemList.createItemDatabase;

public class ItemService {

    private final Safe safe;
    private final List<Item> items;
    private final Scanner scanner;

    {
        safe = new Safe();
        items = createItemDatabase();
        scanner = new Scanner(System.in);
    }

    public void printItemList() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public List<Item> sortByPrice() {
        return items.stream()
                .sorted((o1, o2) -> o2.getPrice() - o1.getPrice())
                .collect(Collectors.toList());
    }

    public void printSortedListByPrice(List<Item> sortedListByPrice) {
        sortedListByPrice.forEach(System.out::println);
    }

    public int findMinVolumeFromItemList() {
        return items.stream()
                .sorted((o1, o2) -> o1.getVolume() - o2.getVolume())
                .collect(Collectors.toList()).get(0).getVolume();
    }

    public List<Item> putItemInTheSafeWithMaxPrice(List<Item> sortedList, int volume) {
        List<Item> resultList = new ArrayList<>();
        safe.setVolume(volume);

        for (int i = 0; i < sortedList.size(); i++) {
            int sumVolume = sortedList.get(i).getVolume() * sortedList.get(i).getNumber();
            if (safe.getVolume() >= sumVolume) {
                resultList.add(new Item(sortedList.get(i).getName(), sortedList.get(i).getNumber(),
                        sortedList.get(i).getVolume(), sortedList.get(i).getPrice()));
                safe.setVolume(safe.getVolume() - sumVolume);
            } else {
                int newNumber = safe.getVolume() / sortedList.get(i).getVolume();
                if (newNumber > 0) {
                    resultList.add(new Item(sortedList.get(i).getName(), newNumber,
                            sortedList.get(i).getVolume(), sortedList.get(i).getPrice()));
                    break;
                }
            }
        }
        return resultList;
    }

    public void printItemInTheSafeWithMaxPrice(List<Item> resultList) {
        resultList.forEach(System.out::println);
    }
}