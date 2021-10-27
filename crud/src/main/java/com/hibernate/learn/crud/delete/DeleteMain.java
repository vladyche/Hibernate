package com.hibernate.learn.crud.delete;

import com.hibernate.learn.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMain {
    public static void main(String[] args){
        //session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        //session
        Session session = sessionFactory.getCurrentSession();

        try{
            //begin transaction
            session.beginTransaction();

            //delete
            User user = session.get(User.class, 1L);
            session.delete(user);

            //commit the transaction
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //close session
            session.close();

            //close factory session
            sessionFactory.close();
        }
    }
}
