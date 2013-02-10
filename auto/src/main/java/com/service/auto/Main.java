package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.security.auth.login.Configuration;
import javax.swing.SwingUtilities;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Collection;

import com.service.auto.Interface.MainFrame;


		
		public class Main {

			public static void main(String a[]) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new MainFrame();
					}
				});
				/*
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
			Iterator	iterator = session.createSQLQuery("SELECT `COLUMN_NAME`" +
"FROM `INFORMATION_SCHEMA`.`COLUMNS`" + 
"WHERE `TABLE_SCHEMA`='octavian_service'" +
   " AND `TABLE_NAME`='MECANIC';").list().iterator();
				while(iterator.hasNext()) 
				System.out.println(iterator.next());
				
				*/
			/*	java.util.ArrayList<MECANIC> m = (ArrayList<MECANIC>) Factory.getInstance().getMecanicDAO().searchByNume("nu");
			    Iterator iterator = m.iterator();
			while(iterator.hasNext()){
				MECANIC mec = (MECANIC) iterator.next();
				System.out.println(mec.getNume()+","+mec.getPrenume() );
			}*/
				
			}
		}				
	
		/*
		MARCA m1 = new MARCA("Audi");
		
		MARCAImplDAO m2 = new MARCAImplDAO();
		m2.addMarca(m1);
		
		MARCA marca = Factory.getInstance().getMarcaDAO().getIdByDenumire("Audi");
		 
		
		MODEL m  = new MODEL("Carina", marca);
		
		MODELImplDAO model = new MODELImplDAO();
		model.addModel(m);
		
		/* java.util.Collection<OPERATIE> marca = Factory.getInstance().getOperatieDAO().getAllOperatie();
		    Iterator iterator = marca.iterator();
		while(iterator.hasNext()){
			OPERATIE m = (OPERATIE) iterator.next();
			System.out.println(m.getDen_oper()+","+m.getPret_oper() );
		}
		
		//OPERATIEImplDAO m = new OPERATIEImplDAO();
//		m.addOperatie(new OPERATIE("oper",2321));
	  /*  OPERATIE i =	m.getIdByDenumire("oper");
		System.out.print(i.getId_oper());
		
		m.deleteOperatie(9); */
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
	
