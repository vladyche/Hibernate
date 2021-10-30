package com.hibernate.onetoone;

import com.hibernate.onetoone.entity.User;
import com.hibernate.onetoone.entity.UserLink;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateMain {
    public static void main(String[] args) {
        //session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserLink.class)
                .buildSessionFactory();

        //session
        Session session = sessionFactory.getCurrentSession();

        try{
            //start session
            session.beginTransaction();

            //update user with id=1
            User user = session.get(User.class, 1L);
            user.setFirstName("NewFirstName");
            user.setLastName("NewLastName");

            //update youtube link for user with id=1
            UserLink userLink = user.getUserLink();
            userLink.setYouTube("youtube.com/new");

            //commit session
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //close session and session factory
            session.close();
            sessionFactory.close();
        }
    }
}
