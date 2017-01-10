package com.zyt.tx.frameutils.eventBus.FragmentListDemo;

import java.util.List;

/**
 * Created by MJS on 2017/1/10.
 */

public class Event {

    public static class ItemListEvent{
        private List<Item> items;

        public ItemListEvent(List<Item> items) {
            this.items = items;
        }

        public List<Item> getItems() {
            return items;
        }
    }
}
