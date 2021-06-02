package com.seabattle.seabattle.DAO;


import com.seabattle.seabattle.model.Friends;
import com.seabattle.seabattle.model.Games;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class FriendsDao {

    private Logger logger;

    public Friends findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Friends.class, id);
    }

    public void saveFriends(Friends friends) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(friends);
        tx1.commit();
        session.close();
    }

    public void update(Friends friends) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(friends);
        tx1.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Friends friends = (Friends) session.load(Friends.class, id);
        if(friends != null) {
            session.delete(friends);
        }
        tx1.commit();
        session.close();
    }

    public List<Friends> findAll() {
        List<Friends> friends = (List<Friends>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Friends").list();
        return friends;
    }
}
