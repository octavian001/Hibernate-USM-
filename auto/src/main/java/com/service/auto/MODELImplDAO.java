package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class MODELImplDAO {
	//adaugarea unei noi inregistrari 
		public  void addModel(MODEL m) {
			Session session = null;

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.save(m);
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Eroare la aduagarea datelor in tabela MODEL");
			}
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
		//afisarea tuturor inregistrarilor din tabel
		public Collection<MODEL> getAllModel() {
			Session session = null;
			List<MODEL> m = new ArrayList<MODEL>();
			try {
				session = HibernateUtil.getSessionFactory().openSession();
			}catch(Exception e){
			System.out.println("Eroare la crearea sesiei: " + e);
			}
				try{ 
				m = session.createCriteria(MODEL.class).list();
			} catch (Throwable e) {
				System.err.println("Eroare la afisarea tuturor modelelor");
							}finally{
				if(session != null && session.isOpen()){
					session.close();
							}
			}
			return m;
		}
		
		 public void deleteMODEL(Integer id){
			    Session session = null;
			    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
			      MODEL m = (MODEL) session.get(MODEL.class, id);
			      session.delete(m);
			      session.getTransaction().commit();
			    }catch(IllegalArgumentException e1){
			    	System.out.println("Nu exista asa inregistrare  in tabela MODEL  ! ");
			    }
			    catch (Exception e) { 
			    	System.out.println("Eroare la \"stergerea inregistrarii\"");
			    } finally {
			      if (session != null && session.isOpen()) {
			        session.close();
			      }
			    }
			  }
		
		 
		 //aflu ID dupa den_marca
		 public MODEL getIdByDenumire(String den){
			    Session session = null;
			    MODEL m = null;
			    try {
			      session = HibernateUtil.getSessionFactory().openSession();	      
			      Criteria criteria = session.createCriteria(MODEL.class)
		                    .add(Restrictions.eq("den_model", new String(den)));
			    m = (MODEL) criteria.uniqueResult();
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
		 
		 public void updateModel(Integer id, String m, MARCA idm) throws SQLException {

				Session session = null;
				try {
					session = HibernateUtil.getSessionFactory().openSession();
					session.beginTransaction();
					//if(session.get(MARCA.class, id) != null)
					MODEL n = (MODEL) session.get(MODEL.class, id);
					n.setDen_model(m);
					n.setMarca(idm);
						session.update(n);
					session.getTransaction().commit();
				} catch (Exception e) {
					System.out.println("Eroare la schimbarea datelor in tabela MODEL" );
					
					
				} finally {
					if (session != null && session.isOpen()) {

						session.close();
					}
				}
			}


}
