package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

public class BONImplDAO {
	
	//adaugarea unei noi inregistrari 
		public  boolean addBon(BON m) {
			Session session = null;

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.save(m);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Eroare la aduagarea datelor in tabela BON");
			}
			if (session != null && session.isOpen()) {
				session.close();
			}
			return false;
		}
		
		//afisarea tuturor inregistrarilor din tabel
		public Collection<BON> getAllBon() {
			Session session = null;
			List<BON> m = new ArrayList<BON>();
			try {
				session = HibernateUtil.getSessionFactory().openSession();
			}catch(Exception e){
			System.out.println("Eroare la crearea sesiei: " + e);
			}
				try{ 
				m = session.createCriteria(BON.class).list();
			} catch (Throwable e) {
				System.err.println("Eroare la afisarea tuturor datelor");
							}finally{
				if(session != null && session.isOpen()){
					session.close();
							}
			}
			return m;
		}
		
		 public boolean deleteBon(Integer id){
			    Session session = null;
			    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
			      BON m = (BON) session.get(BON.class, id);
			      session.delete(m);
			      session.getTransaction().commit();
			      return true;
			    }catch(IllegalArgumentException e1){
			    	System.out.println("Nu exista asa inregistrare  in tabela BON  ! ");
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
		
		 public boolean updateBon(Integer id, String data_bon, int pret_total,AUTO ida,
				 MECANIC idm,PROPRIETAR idp,Set<PIESE> piese,Set<OPERATIE> oper) throws SQLException {

				Session session = null;
				try {
					session = HibernateUtil.getSessionFactory().openSession();
					session.beginTransaction();
					//if(session.get(MARCA.class, id) != null)
				 BON n = (BON) session.get(BON.class, id);
				n.setId_bon(id);
				n.setData_bon(data_bon);
				n.setPret_total(pret_total);
				n.setId_auto(ida);
				n.setId_mecanic(idm);
				n.setId_proprietar(idp);
				n.setPiese(piese);
				n.setOper(oper);
				 session.update(n);
					session.getTransaction().commit();
					return true;
				} catch (Exception e) {
					System.out.println("Eroare la schimbarea datelor in tabela BON" );
					
					
				} finally {
					if (session != null && session.isOpen()) {

						session.close();
					}
				}
				return false;
			}

}
