package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

public class AUTOImplDAO {
	
	//adaugarea unei noi inregistrari 
	public  boolean addAuto(AUTO m) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(m);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Eroare la aduagarea datelor in tabela Auto");
		}
		if (session != null && session.isOpen()) {
			session.close();
		}
		return false;
	}
	
	//afisarea tuturor inregistrarilor din tabel
	public Collection<AUTO> getAllAuto() {
		Session session = null;
		List<AUTO> m = new ArrayList<AUTO>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		}catch(Exception e){
		System.out.println("Eroare la crearea sesiei: " + e);
		}
			try{ 
			m = session.createCriteria(AUTO.class).list();
		} catch (Throwable e) {
			System.err.println("Eroare la afisarea tuturor modelelor");
						}finally{
			if(session != null && session.isOpen()){
				session.close();
						}
		}
		return m;
	}
	
	 public boolean deleteAuto(Integer id){
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      AUTO m = (AUTO) session.get(AUTO.class, id);
		      session.delete(m);
		      session.getTransaction().commit();
		      return true;
		    }catch(IllegalArgumentException e1){
		    	System.out.println("Nu exista asa inregistrare  in tabela AUTO  ! ");
		    }
		    catch (Exception e) { 
		    	System.out.println("Eroare la \"stergerea inregistrarii\"");
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return false;
		  }
	
	
	 public boolean updateModel(Integer id, int an, int nr,int serie, MARCA idm,PROPRIETAR idp) throws SQLException {

			Session session = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				//if(session.get(MARCA.class, id) != null)
				AUTO n = (AUTO) session.get(AUTO.class, id);
				n.setAn_fabr(an);
				n.setNr_inmatr(nr);
				n.setSerie_motor(serie);
				n.setId_marca(idm);
				n.setId_proprietar(idp);
					session.update(n);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Eroare la schimbarea datelor in tabela AUTO" );
				
				
			} finally {
				if (session != null && session.isOpen()) {

					session.close();
				}
			}
			return false;
		}



}
