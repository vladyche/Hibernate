package com.hibernate.learn;

import com.hibernate.learn.entity.Link;
import com.hibernate.learn.entity.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateMain {
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
            session.beginTransaction();

            //UPDATE Menu with id=1
            Menu menu = session.get(Menu.class, 2L);
            menu.setName("NewMenu");

            //UPDATE Link with id=1
            Link link = session.get(Link.class, 1L);

            //UPDATE text for link with id=1
            link.setText("NewMenu");

            //Assign menu with id=2 for link with id=1
            link.setMenu(menu);

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //close session and factory
            session.close();
            sessionFactory.close();
        }

    }
}
