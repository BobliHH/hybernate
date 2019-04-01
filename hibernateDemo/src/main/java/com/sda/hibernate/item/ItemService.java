package com.sda.hibernate.item;

import java.util.List;

public class ItemService {
    ItemDaoImpl itemDao;

    public ItemService() {
        this.itemDao = new ItemDaoImpl();
    }

    public void saveItem(Item item) {
        itemDao.openCurrentSessionWithTransaction();
        itemDao.saveItem(item);
        itemDao.closeCurrentSessionWithTransaction();
    }

    public List<Item> findAllItems() {
        itemDao.openCurrentSession();
        List<Item> items = itemDao.findAllItems();
        itemDao.closeCurrentSession();
        return items;

    }

    public Item findItemByID(Long itemID) {
        itemDao.openCurrentSession();
        Item item = itemDao.findItemByID(itemID);
        itemDao.closeCurrentSession();
        return item;

    }

    public void updateItem(Item item) {
        itemDao.openCurrentSessionWithTransaction();
        itemDao.updateItem(item);
        itemDao.closeCurrentSessionWithTransaction();
    }

    public void deleteItem(Item item) {
        itemDao.openCurrentSessionWithTransaction();
        itemDao.deleteItem(item);
        itemDao.closeCurrentSessionWithTransaction();
    }

    public void deleteAllItems() {
        itemDao.openCurrentSessionWithTransaction();
        itemDao.deleteAllItems();
        itemDao.closeCurrentSessionWithTransaction();

    }
}
