package com.service.auto;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.service.auto.HibernateUtil;

public class Main {

	public static void main(String a[]) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			
			MECANIC mec = new MECANIC( "ALBU", "ION", 123456, "qq@yahoo.com", "str. Pacii");
			
			PROPRIETAR propr = new PROPRIETAR("ANDREI", 9876543);
			
			MODEL model = new  MODEL("Logan");
			
			MARCA marca = new MARCA("Dacia", model);
			
			
			
			AUTO auto = new AUTO(231, 9542, 2003, marca, propr);
			
			Set<OPERATIE> oper = new HashSet<OPERATIE>();
			oper.add(new OPERATIE( "den_operatie", 1000));
			BON bon = new BON("03.01.2013", mec, propr, auto, 22222, oper);
			
			session.save(bon);
						transaction.commit();
			
		}catch(HibernateException e){
			transaction.rollback();
			System.out.println("Eroare : " + e.getMessage());
			
		}finally{
			if(session.isOpen() && session != null)
				session.close();
		}

	}
}
