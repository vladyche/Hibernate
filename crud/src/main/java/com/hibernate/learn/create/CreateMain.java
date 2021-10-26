package com.hibernate.learn.create;

public class CreateMain {
    public static void main(String[] args){
        //session factory
        //session
        //prepare object for save

        try{
            //start transaction
            //save object
            //commit the transaction
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //close session
            //close factory session
        }
    }
}
