package com.service.auto;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.objectweb.asm.attrs.Annotation;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
    static {
      try {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
      } catch (Throwable ex) {
   
        System.err.println("Eroare la crearea sessiei :      " + ex);
        throw new ExceptionInInitializerError(ex);
      }
    }

    public static SessionFactory getSessionFactory() {
      return sessionFactory;
    }

}
