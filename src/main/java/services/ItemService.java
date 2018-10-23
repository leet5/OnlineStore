package services;

import dao.ItemDAO;
import entities.Item;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.SessionUtil;

import java.util.List;

public class ItemService extends SessionUtil implements ItemDAO {
    @Override
    public void add(Item item) {
        Session session = openTransactionSession();
        session.save(item);
        closeTransactionSession();
    }

    @Override
    public Item getById(Long id) {
        Session session = openTransactionSession();
        String sql = "SELECT * FROM item WHERE id=:id";
        Query query = session.createNativeQuery(sql).addEntity(Item.class);
        query.setParameter("id", id);
        Item item = (Item) query.getSingleResult();
        closeTransactionSession();
        return item;
    }

    @Override
    public List<Item> getAll() {
        Session session = openTransactionSession();
        String sql = "SELECT * FROM item";
        Query query = session.createNativeQuery(sql).addEntity(Item.class);
        List<Item> items = query.list();
        closeTransactionSession();
        return items;
    }

    @Override
    public void update(Item item) {
        Session session = openTransactionSession();
        session.update(item);
        closeTransactionSession();
    }

    @Override
    public void delete(Item item) {
        Session session = openTransactionSession();
        session.delete(item);
        closeTransactionSession();
    }
}
