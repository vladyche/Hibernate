package com.hibernate.onetoone;

import com.hibernate.onetoone.entity.User;
import com.hibernate.onetoone.entity.UserLink;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMain {
    public static void main(String[] args){
        //session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserLink.class)
                .buildSessionFactory();

        //session
        Session session = sessionFactory.getCurrentSession();

        //prepare objects
        UserLink userLink = new UserLink();
        userLink.setGitHub("github.com/github");
        userLink.setLinkedIn("linkedin.com/linkedin");
        userLink.setYouTube("youtube.com/youtube");

        User user = new User();
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setUserLink(userLink);

        try{
            //begin transaction
            session.beginTransaction();

            //save object
            session.save(user);

            //commit the transaction
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
