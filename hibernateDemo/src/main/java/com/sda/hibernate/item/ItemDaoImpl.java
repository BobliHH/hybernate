package com.sda.hibernate.item;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ItemDaoImpl implements ItemDao {

    private Session currentSession;
    private Transaction currentTransaction;

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public ItemDaoImpl() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void saveItem(Item item) {
        getCurrentSession().save(item);

    }

    public List<Item> findAllItems() {
        List<Item> items = (List<Item>) getCurrentSession().createQuery("from Item").list();
        return items;
    }

    public Item findItemByID(Long itemID) {
        Item item = (Item) getCurrentSession().get(Item.class, itemID);
        return item;
    }

    public void updateItem(Item item) {
        getCurrentSession().update(item);

    }

    public void deleteItem(Item item) {
        getCurrentSession().delete(item);

    }

    public void deleteAllItems() {
        List<Item> items = findAllItems();
        for (Item item : items) {
            deleteItem(item);
        }

    }
}
