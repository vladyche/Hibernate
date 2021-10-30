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

            //read
            User user = session.get(User.class, 1L);

            //get User
            System.out.println(user);

            //get User links
            System.out.println(user.getUserLink());

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
