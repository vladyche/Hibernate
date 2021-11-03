package com.hibernate.learn;

import com.hibernate.learn.entity.Link;
import com.hibernate.learn.entity.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMain {
    public static void main(String[] args){
        //session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Menu.class)
                .addAnnotatedClass(Link.class)
                .buildSessionFactory();

        //session
        Session session = sessionFactory.getCurrentSession();

        //prepare objects
        Menu menu = new Menu();
        menu.setName("Top Menu");

        Link link1 = new Link();
        link1.setText("About");
        link1.setHref("about");
        link1.setMenu(menu);

        Link link2 = new Link();
        link2.setText("Contacts");
        link2.setHref("contacts");
        link2.setMenu(menu);

        try{
            session.beginTransaction();

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
