package services;

import dao.AccountDAO;
import entities.Account;
import org.hibernate.query.Query;
import org.hibernate.Session;
import utils.SessionUtil;

import java.util.List;

public class AccountService extends SessionUtil implements AccountDAO {
    @Override
    public void add(Account account) {
        Session session = openTransactionSession();
        session.save(account);
        closeTransactionSession();
    }

    @Override
    public Account getById(Long id) {
        Session session = openTransactionSession();
        String sql = "select * from account where id=:id";
        Query query = session.createNativeQuery(sql).addEntity(Account.class);
        query.setParameter("id", id);
        Account account = (Account) query.getSingleResult();
        closeTransactionSession();
        return account;
    }

    @Override
    public Account getByEmail(String email) {
        Session session = openTransactionSession();
        String sql = "select * from account where email=:email";
        Query query = session.createNativeQuery(sql).addEntity(Account.class);
        query.setParameter("email", email);
        Account account = (Account) query.getSingleResult();
        closeTransactionSession();
        return account;
    }

    @Override
    public List<Account> getAll() {
        Session session = openTransactionSession();
        String sql = "select * from account";
        Query query = session.createNativeQuery(sql).addEntity(Account.class);
        List<Account> accounts = query.list();
        closeTransactionSession();
        return accounts;
    }

    @Override
    public void update(Account account) {
        Session session = openTransactionSession();
        session.update(account);
        closeTransactionSession();
    }

    @Override
    public void delete(Account account) {
        Session session = openTransactionSession();
        session.delete(account);
        closeTransactionSession();
    }
}
