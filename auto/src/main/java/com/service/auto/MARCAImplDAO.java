package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class MARCAImplDAO {
	
//adaugarea unei noi inregistrari 
	public  void addMarca(MARCA m) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(m);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Eroare la aduagarea datelor in tabela MARCA");
		}
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
	
	//afisarea tuturor inregistrarilor din tabel
	public Collection<MARCA> getAllMarca() {
		Session session = null;
		List<MARCA> marca = new ArrayList<MARCA>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		}catch(Exception e){
		System.out.println("Eroare la crearea sesiei: " + e);
		}
			try{ 
			marca = session.createCriteria(MARCA.class).list();
		} catch (Throwable e) {
			System.err.println("Eroare la afisarea tuturor marcilor ");
			e.printStackTrace();
		}finally{
			if(session != null && session.isOpen()){
				session.close();
						}
		}
		return marca;
	}
	
	 public void deleteMarca(Integer id){
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      MARCA m = (MARCA) session.get(MARCA.class, id);
		      session.delete(m);
		      session.getTransaction().commit();
		    }catch(IllegalArgumentException e1){
		    	System.out.println("Nu exista asa inregistrare  in tabela MARCA ! ");
		    }
		    catch (Exception e) { 
		    	System.out.println("Eroare la \"stergerea datelor din tabela MARCA\"");
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		  }
	
	 
	 //aflu ID dupa den_marca
	 public MARCA getIdByDenumire(String den){
		    Session session = null;
		    MARCA m = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();	      
		      Criteria criteria = session.createCriteria(MARCA.class)
	                    .add(Restrictions.eq("den_marca", new String(den)));
		    m = (MARCA) criteria.uniqueResult();
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
	 
	 public void updateMarca(Integer id, String m) throws SQLException {

			Session session = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				//if(session.get(MARCA.class, id) != null)
				MARCA n = (MARCA) session.get(MARCA.class, id);
				n.setDen_marca(m);
					session.update(n);
				
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Eroare la schimbarea datelor in tabela MARCA" );
				
			} finally {
				if (session != null && session.isOpen()) {

					session.close();
				}
			}
		}

}
