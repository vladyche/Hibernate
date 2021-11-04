package com.hibernate.learn;

import com.hibernate.learn.entity.Link;
import com.hibernate.learn.entity.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadMain {
    public static void main(String[] args){
        //session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Menu.class)
                .addAnnotatedClass(Link.class)
                .buildSessionFactory();

        //session
        Session session = sessionFactory.getCurrentSession();

        try{
            //begin transaction
            session.beginTransaction();

            //read links for menu with id=1
            Menu menu = session.get(Menu.class, 1L);
            System.out.println(menu.getLinks());

            //read menu with id=2
            Menu menu2 = session.get(Menu.class, 2L);
            System.out.println(menu2);

            //commit the transaction
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
