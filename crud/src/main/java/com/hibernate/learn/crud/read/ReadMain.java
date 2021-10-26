package com.hibernate.learn.crud.read;

import com.hibernate.learn.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadMain {
    public static void main(String[] args){
        //session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        //session
        Session session = sessionFactory.getCurrentSession();

        try{
            //start transaction
            session.beginTransaction();

            //read object with id=1
            User user = session.get(User.class, 1L);
            System.out.println(user);

            //commit the transaction
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //close session
            session.close();

            //close factory
            sessionFactory.close();
        }
    }
}
