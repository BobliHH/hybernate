package com.sda.hibernate.item;

import com.sda.hibernate.Car;

import java.util.List;

public interface ItemDao {
    public void saveItem(Item item);
    public List<Item> findAllItems();
    public Item findItemByID(Long itemID);
    public void updateItem(Item item);
    public void deleteItem(Item item);
    public void deleteAllItems();
}
