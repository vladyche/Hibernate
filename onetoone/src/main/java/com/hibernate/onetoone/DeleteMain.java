package com.hibernate.onetoone;

import com.hibernate.onetoone.entity.User;
import com.hibernate.onetoone.entity.UserLink;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMain {
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
            session.beginTransaction();

            //delete record with id=1
            User user = session.get(User.class, 1L);
            session.delete(user);

            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }

    }
}
