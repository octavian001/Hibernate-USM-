package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class PIESEImplDAO {
	//adaugarea unei noi inregistrari 
		public  void addPiese(PIESE m) {
			Session session = null;

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.save(m);
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Eroare la aduagarea datelor in tabela PIESE");
			}
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
		//afisarea tuturor inregistrarilor din tabel
		public Collection<PIESE> getAllPIESE() {
			Session session = null;
			List<PIESE> piese = new ArrayList<PIESE>();
			try {
				session = HibernateUtil.getSessionFactory().openSession();
			}catch(Exception e){
			System.out.println("Eroare la crearea sesiei: " + e);
			}
				try{ 
				piese = session.createCriteria(PIESE.class).list();
			} catch (Throwable e) {
				System.err.println("Eroare la afisarea tuturor marcilor ");
				e.printStackTrace();
			}finally{
				if(session != null && session.isOpen()){
					session.close();
							}
			}
			return piese;
		}
		
		 public void deletePiese(Integer id){
			    Session session = null;
			    try {
			      session = HibernateUtil.getSessionFactory().openSession();
			      session.beginTransaction();
			      PIESE m = (PIESE) session.get(PIESE.class, id);
			      session.delete(m);
			      session.getTransaction().commit();
			    }catch(IllegalArgumentException e1){
			    	System.out.println("Nu exista asa inregistrare  in tabela PIESE ! ");
			    }
			    catch (Exception e) { 
			    	System.out.println("Eroare la \"stergerea datelor din tabela PIESE\"");
			    } finally {
			      if (session != null && session.isOpen()) {
			        session.close();
			      }
			    }
			  }
		
		 
		 //aflu ID dupa den_marca
		 public PIESE getIdByDenumire(String den){
			    Session session = null;
			    PIESE m = null;
			    try {
			      session = HibernateUtil.getSessionFactory().openSession();	      
			      Criteria criteria = session.createCriteria(PIESE.class)
		                    .add(Restrictions.eq("denumire", new String(den)));
			    m = (PIESE) criteria.uniqueResult();
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
		 
		 public void updateMarca(Integer id, String d,Integer p,Integer c) throws SQLException {

				Session session = null;
				try {
					session = HibernateUtil.getSessionFactory().openSession();
					session.beginTransaction();
					//if(session.get(MARCA.class, id) != null)
					PIESE n = (PIESE) session.get(PIESE.class, id);
					n.setDenumire(d);
					n.setPret(p);
					n.setCantitate(c);
						session.update(n);
					
					session.getTransaction().commit();
				} catch (Exception e) {
					System.out.println("Eroare la schimbarea datelor in tabela PIESE" );
					
				} finally {
					if (session != null && session.isOpen()) {

						session.close();
					}
				}
			}
}
