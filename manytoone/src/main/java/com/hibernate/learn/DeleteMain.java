package com.hibernate.learn;

import com.hibernate.learn.entity.Category;
import com.hibernate.learn.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMain {
    public static void main(String[] args){
        //session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Post.class)
                .buildSessionFactory();

        //session
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            //get post with id=1
            Post post = session.get(Post.class, 1L);

            //delete post with id=1
            session.delete(post);

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //close
            session.close();
            sessionFactory.close();
        }
    }
}
