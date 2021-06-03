package com.seabattle.seabattle.DAO;

import com.seabattle.seabattle.model.Profile;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class ProfileDao {
    private Logger logger;

    public Profile findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Profile.class, id);
    }

    public void saveProfile(Profile profile) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(profile);
        tx1.commit();
        session.close();
    }

    public void update(Profile profile) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(profile);
        tx1.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Profile profile = (Profile) session.load(Profile.class, id);
        if(profile != null) {
            session.delete(profile);
        }

        tx1.commit();
        session.close();
    }

    public List<Profile> findAll() {
        List<Profile> profiles = (List<Profile>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Profile").list();
        return profiles;
    }

    public Profile findByUsers_Id(int user_id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "from Profile where user_id = " + "'" + user_id + "'";
        Query query = session.createQuery(hql);
        List<Profile> profileList = query.list();
        session.close();
        return profileList.get(0);
    }

}
