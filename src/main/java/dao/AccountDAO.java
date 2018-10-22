package dao;

import entities.Account;

import java.util.List;

public interface AccountDAO {
    void add(Account account);

    Account getById(Long id);

    List<Account> getAll();

    void update(Account account);

    void delete(Account account);
}
