package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class PROPRIETARImplDAO {
	
	public  void addProprietar(PROPRIETAR m) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(m);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Eroare la aduagarea datelor in tabela PROPRIETAR");
		}
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
	
	//afisarea tuturor inregistrarilor din tabel
	public Collection<PROPRIETAR> getAllProprietar() {
		Session session = null;
		List<PROPRIETAR> m = new ArrayList<PROPRIETAR>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		}catch(Exception e){
		System.out.println("Eroare la crearea sesiei: " + e);
		}
			try{ 
			m = session.createCriteria(PROPRIETAR.class).list();
		} catch (Throwable e) {
			System.err.println("Eroare la afisarea tuturor proprietarilor");
						}finally{
			if(session != null && session.isOpen()){
				session.close();
						}
		}
		return m;
	}
	
	 public void deleteProprietar(Integer id){
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      PROPRIETAR m = (PROPRIETAR) session.get(PROPRIETAR.class, id);
		      session.delete(m);
		      session.getTransaction().commit();
		    }catch(IllegalArgumentException e1){
		    	System.out.println("Nu exista asa inregistrare  in tabela PROPRIETAR  ! ");
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
	 public PROPRIETAR getIdByDenumire(String den){
		    Session session = null;
		    PROPRIETAR m = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();	      
		      Criteria criteria = session.createCriteria(PROPRIETAR.class)
	                    .add(Restrictions.eq("nume", new String(den)));
		    m = (PROPRIETAR) criteria.uniqueResult();
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
	 
	 public void updateProprietar(Integer id, String m,Integer t) throws SQLException {

			Session session = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				
				PROPRIETAR n = (PROPRIETAR) session.get(PROPRIETAR.class, id);
				n.setNume(m);
				n.setTelefon(t);
					session.update(n);
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Eroare la schimbarea datelor in tabela PROPRIETAR" );
				
				
			} finally {
				if (session != null && session.isOpen()) {

					session.close();
				}
			}
		}

}
