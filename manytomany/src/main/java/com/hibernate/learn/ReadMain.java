package com.hibernate.learn;

import com.hibernate.learn.entity.Post;
import com.hibernate.learn.entity.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadMain {
    public static void main(String[] args){
        //session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Tag.class)
                .buildSessionFactory();

        //session
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            //tags for post with id=1
            Post post = session.get(Post.class, 1L);
            System.out.println(post.getTags());

            //posts for tag with id=1
            Tag tag = session.get(Tag.class, 1L);
            System.out.println(tag.getPosts());

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
