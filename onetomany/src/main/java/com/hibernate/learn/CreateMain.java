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

        Menu menu = new Menu();
        menu.setName("New Menu");

        Link link = new Link();
        link.setText("News");
        link.setHref("news");

        try{
            session.beginTransaction();

            //create new menu
            session.save(menu);

            //add link for menu with id=1
            Menu m = session.get(Menu.class, 1L);
            link.setMenu(m);
            session.save(link);

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
