package com.Static;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Configuration cf=new Configuration().configure();
    private static SessionFactory sf=cf.buildSessionFactory();
    
    //��������session
    public static Session getSession(){
        return sf.openSession();
    }
    
    //�ر�Session
    
    public static void CloseSession(){
        getSession().close();
    }
}
