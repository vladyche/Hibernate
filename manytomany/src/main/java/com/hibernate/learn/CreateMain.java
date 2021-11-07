package com.hibernate.learn;

import com.hibernate.learn.entity.Post;
import com.hibernate.learn.entity.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMain {
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

            //get tags with id=1 and id=2
            Tag tag1 = session.get(Tag.class, 1L);
            Tag tag2 = session.get(Tag.class, 2L);

            //get post with id=2
            Post post = session.get(Post.class, 2L);

            //add tags for post with id=2
            post.addTag(tag1);
            post.addTag(tag2);

            //save post
            session.save(post);

            Post post4 = session.get(Post.class, 4L);
            tag1.addPost(post4);

            //save tag
            session.save(tag1);

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
