package dao;

import entities.Item;

import java.util.List;

public interface ItemDAO {
    void add(Item item);

    Item getById(Long id);

    List<Item> getAll();

    void update(Item item);

    void delete(Item item);
}
