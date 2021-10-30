package com.hibernate.onetoone;

import com.hibernate.onetoone.entity.User;
import com.hibernate.onetoone.entity.UserLink;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadMain {
    public static void main(String[] args){
        //session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserLink.class)
                .buildSessionFactory();

        //session
        Session session = sessionFactory.getCurrentSession();

        try{
            //start transaction
            session.beginTransaction();

            //read User from user
            User user = session.get(User.class, 1L);

            //get User
            System.out.println("User from user: " + user);

            //get User links
            System.out.println("UserLink from user: " + user.getUserLink());

            //get UserLink
            UserLink userLink = session.get(UserLink.class, 1L);

            //get UserLink
            System.out.println("UserLink from user_link: " + userLink);

            //get User
            System.out.println("User from user_link: " + userLink.getUser());

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
