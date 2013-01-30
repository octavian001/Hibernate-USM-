package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class OPERATIEImplDAO {
	
	//adaugarea unei noi inregistrari 
		public  void addOperatie(OPERATIE m) {
			Session session = null;

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.save(m);
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Eroare la aduagarea datelor in tabela OPERATIE");
			}
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
		//afisarea tuturor inregistrarilor din tabel
		public Collection<OPERATIE> getAllOperatie() {
			Session session = null;
			List<OPERATIE> oper = new ArrayList<OPERATIE>();
			try {
				session = HibernateUtil.getSessionFactory().openSession();
			}catch(Exception e){
			System.out.println("Eroare la crearea sesiei: " + e);
			}
				try{ 
				oper = session.createCriteria(OPERATIE.class).list();
			} catch (Throwable e) {
				System.err.println("Eroare la afisarea tuturor operatiilor ");
				e.printStackTrace();
			}finally{
				if(session != null && session.isOpen()){
					session.close();
							}
			}
			return oper;
		}
		
		 public void deleteOperatie(Integer id){
			    Session session = null;
			    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
			      OPERATIE m = (OPERATIE) session.get(OPERATIE.class, id);
			      session.delete(m);
			      session.getTransaction().commit();
			    }catch(IllegalArgumentException e1){
			    	System.out.println("Nu exista asa inregistrare  in tabela OPERATIE ! ");
			    }
			    catch (Exception e) { 
			    	System.out.println("Eroare la \"stergerea datelor din tabela OPERATIE\"");
			    } finally {
			      if (session != null && session.isOpen()) {
			        session.close();
			      }
			    }
			  }
		
		 //aflu ID dupa den_marca
		 public OPERATIE getIdByDenumire(String den){
			    Session session = null;
			    OPERATIE m = null;
			    try {
			      session = HibernateUtil.getSessionFactory().openSession();	      
			      Criteria criteria = session.createCriteria(OPERATIE.class)
		                    .add(Restrictions.eq("den_oper", new String(den)));
			    m = (OPERATIE) criteria.uniqueResult();
	          System.out.println();
			    } catch (Exception e) {
	                e.printStackTrace();
			    } finally {
			      if (session != null && session.isOpen()) {
			        session.close();
			      }
			    }
			    return m;
			  }
		 
		 public void updateOperatie(Integer id, String d, Integer p) throws SQLException {

				Session session = null;
				try {
					session = HibernateUtil.getSessionFactory().openSession();
					session.beginTransaction();
					//if(session.get(MARCA.class, id) != null)
					OPERATIE n = (OPERATIE) session.get(OPERATIE.class, id);
					n.setDen_oper(d);
					n.setPret_oper(p);
						session.update(n);
					
					session.getTransaction().commit();
				} catch (Exception e) {
					System.out.println("Eroare la schimbarea datelor in tabela OPERATIE" );
					
				} finally {
					if (session != null && session.isOpen()) {

						session.close();
					}
				}
			}

}
