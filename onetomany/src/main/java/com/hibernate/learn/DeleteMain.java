package com.hibernate.learn;

import com.hibernate.learn.entity.Link;
import com.hibernate.learn.entity.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteMain {
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

            //DELETE Menu with id=1
            Menu menu = session.get(Menu.class, 1L);

            //Assign null for links with menu id=1
            List<Link> links = menu.getLinks();
            for(Link link : links){
                link.setMenu(null);
            }

            //delete Menu with id=1
            session.delete(menu);

            //DELETE Link with id=1
            Link link = session.get(Link.class, 1L);
            session.delete(link);

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
