package com.zyt.tx.frameutils.eventBus.FragmentListDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJS on 2017/1/9.
 */

public class Item {
    public String id;
    public String content;

    public static List<Item> ITEMS = new ArrayList<>();

    static {
        addItem(new Item("1","item 1"));
        addItem(new Item("2","item 2"));
        addItem(new Item("3","item 3"));
        addItem(new Item("4","item 4"));
        addItem(new Item("5","item 5"));
        addItem(new Item("6","item 6"));

    }

    public static void addItem(Item item) {
        ITEMS.add(item);
    }

    public Item(String id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
