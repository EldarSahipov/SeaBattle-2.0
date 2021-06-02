package com.seabattle.seabattle.DAO;

import com.seabattle.seabattle.model.Games;
import com.seabattle.seabattle.model.Profile;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class GamesDao {

    private Logger logger;

    public Games findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Games.class, id);
    }

    public void saveGames(Games games) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(games);
        tx1.commit();
        session.close();
    }

    public void update(Games games) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(games);
        tx1.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Games games = (Games) session.load(Games.class, id);
        if(games != null) {
            session.delete(games);
        }
        tx1.commit();
        session.close();
    }

    public List<Games> findAll() {
        List<Games> games = (List<Games>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Games").list();
        return games;
    }
}
