package ru.mirea.rodion.tasks5;


import ru.mirea.rodion.tasks5.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemList {

    public static List<Item> createItemDatabase() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Tv", 2, 100, 1));
        items.add(new Item("Smartphone", 1, 50, 2));
        items.add(new Item("Gold  ring", 1, 200, 3));
        items.add(new Item("Money", 5, 2000, 4));
        items.add(new Item("Honey", 1, 20, 5));
        return items;
    }
}