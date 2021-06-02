package com.seabattle.seabattle.DAO;

import com.seabattle.seabattle.model.User;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class UserDao {

    private Logger logger;

    private String encoder(String str) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        return passwordEncoder.encode(str);
    }

    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public void saveUser(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        user.setPassword(encoder(user.getPassword()));
        session.save(user);
        tx1.commit();
        logger.info("Пользователь добавлен");
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        user.setPassword(encoder(user.getPassword()));
        session.update(user);
        tx1.commit();
        logger.info("Пользователь обновлён");
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        User user = (User) session.load(User.class, id);
        if(user != null) {
            session.delete(user);
        }

        tx1.commit();
        session.close();
    }

    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}
