package com.hibernate.learn;

import com.hibernate.learn.entity.Category;
import com.hibernate.learn.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMain {
    public static void main(String[] args){
        //session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Post.class)
                .buildSessionFactory();

        //session
        Session session = sessionFactory.getCurrentSession();

        Post post = new Post();
        post.setTitle("Next Post");

        try{
            session.beginTransaction();

            //get category with id=1
            Category category = session.get(Category.class, 1L);

            //assign category with id=1 for new post
            post.setCategory(category);

            //save new post
            session.save(post);

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
