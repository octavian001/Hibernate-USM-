package com.service.auto;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Collection;

public class Main {

	public static void main(String a[]) {
		
		 java.util.Collection<PROPRIETAR> marca = Factory.getInstance().getProprietarDAO().getAllProprietar();
		    Iterator iterator = marca.iterator();
		while(iterator.hasNext()){
			PROPRIETAR m = (PROPRIETAR) iterator.next();
			System.out.println(m.getNume()+","+m.getTelefon());
		}
		
		MECANICImplDAO m = new MECANICImplDAO();
		m.addMecanic(new MECANIC("ALBU", "ION",23, "asd", "saew"));
	    MECANIC i =	m.getIdByDenumire("ALBU");
		System.out.print(i.getId_mecanic());
		/*PROPRIETARImplDAO m = new PROPRIETARImplDAO();
		PROPRIETAR i = m.getIdByDenumire("ANDREI");
		System.out.print(i.getId_proprietar());*/
	//	m.addProprietar(new PROPRIETAR("ANDREI", 22356));
		/*try {
			m.updateProprietar(17, "Ion",22356);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	
	/*	
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			
			MODEL m = new MODEL("Logan");
			session.save(m);
			MARCA marca = new MARCA();
			marca.setDen_marca("DACIA");
			marca.setModel(m);
			session.save(marca);
			
			MECANIC mec = new MECANIC( "ALBU", "ION", 123456, "qq@yahoo.com", "str. Pacii");

			PROPRIETAR propr = new PROPRIETAR("ANDREI", 9876543);

			

        	PIESE p = new PIESE( "bujie", 260, 250);
			
			
			Set<PIESE> piesa = new HashSet<PIESE>();
			piesa.add(p);

			AUTO auto = new AUTO(231, 9542, 2003, marca, propr);

			Set<OPERATIE> oper = new HashSet<OPERATIE>();
			oper.add(new OPERATIE( "den_operatie", 1000));
			BON bon = new BON("03.01.2013", mec, propr, auto, 22222, oper, piesa);

			session.save(bon);

			
		*/	
			/*
			PROPRIETAR id = new PROPRIETAR();
			id.setNume("dgdfg");
			id.setTelefon(22356);
			
			MARCA marca = new MARCA();
			marca.setDen_marca("Audi");
			session.save(marca);
			
			 session = HibernateUtil.getSessionFactory().openSession();	      
		      Criteria criteria = session.createCriteria(MARCA.class)
	                    .add(Restrictions.eq("den_marca", new String("Audi")));
		   MARCA b = (MARCA) criteria.uniqueResult();
			
			AUTO auto = new AUTO();
			auto.setAn_fabr(1111);
			auto.setNr_inmatr(23441);
			auto.setSerie_motor(21312312);
			auto.setId_marca(b);
			auto.setId_proprietar(id);
			session.save(auto);
			*/
	/*		transaction.commit();
			
		}catch(HibernateException e){
			transaction.rollback();
			System.out.println("Eroare : " + e.getMessage());
			
		}finally{
			if(session.isOpen() && session != null)
				session.close();
		}

	}
	*/
	}
}
