package com.hibernate.learn.crud.create;

import com.hibernate.learn.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMain {
    public static void main(String[] args){
        //session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        //session
        Session session = sessionFactory.getCurrentSession();

        //prepare object for save
        User user = new User();
        user.setFirstName("Anakin");
        user.setLastName("Skywalker");

        try{
            //start transaction
            session.beginTransaction();

            //save object
            session.save(user);

            //commit the transaction
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //close session
            session.close();

            //close factory session
            sessionFactory.close();
        }
    }
}
