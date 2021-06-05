package com.seabattle.DAO;

import com.seabattle.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserDao {
    private String encoder(String str) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        return passwordEncoder.encode(str);
    }

    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public boolean findByLoginUser(User user) {

        String hql = "from User where login = " + "'" + user.getLogin() + "'";
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(hql);
        List<User> userList = query.list();

        if(userList.isEmpty()) {
            return true;
        }
        return false;
    }

    public User saveUser(User user) {
        Session sessionUser = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = sessionUser.beginTransaction();
        if(findByLoginUser(user)) {
            user.setPassword(encoder(user.getPassword()));
            sessionUser.save(user);
            tx1.commit();
            sessionUser.close();
            return user;
        } else {
            sessionUser.close();
            return null;
        }
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        user.setPassword(encoder(user.getPassword()));
        session.update(user);
        tx1.commit();
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

    public int findIdByLogin(String login) {
        String hql = "from User where login = " + "'" + login + "'";
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<User> userList = query.list();
        session.close();
        return userList.get(0).getId();
    }
}
