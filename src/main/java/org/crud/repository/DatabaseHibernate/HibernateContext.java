package org.crud.repository.DatabaseHibernate;

import org.crud.model.Specialty;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateContext {
    private static SessionFactory sessionFactory;
    private static HibernateContext hibernateContext;
    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    private HibernateContext(){

    }
    public static HibernateContext getHibernateContext(){
        if(hibernateContext==null){
            hibernateContext = new HibernateContext();
        }
        return hibernateContext;
    }
    public SessionFactory getSession(){
        return sessionFactory;
    }
}
