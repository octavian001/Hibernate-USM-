package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class MECANICImplDAO {
	
	public  void addMecanic(MECANIC m) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(m);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Eroare la aduagarea datelor in tabela MECANIC");
		}
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
	
	//afisarea tuturor inregistrarilor din tabel
	public Collection<MECANIC> getAllMecanic() {
		Session session = null;
		List<MECANIC> m = new ArrayList<MECANIC>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		}catch(Exception e){
		System.out.println("Eroare la crearea sesiei: " + e);
		}
			try{ 
			m = session.createCriteria(MECANIC.class).list();
		} catch (Throwable e) {
			System.err.println("Eroare la afisarea tuturor mecanicilor");
						}finally{
			if(session != null && session.isOpen()){
				session.close();
						}
		}
		return m;
	}
	
	 public void deleteMecanic(Integer id){
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      MECANIC m = (MECANIC) session.get(MECANIC.class, id);
		      session.delete(m);
		      session.getTransaction().commit();
		    }catch(IllegalArgumentException e1){
		    	System.out.println("Nu exista asa inregistrare  in tabela MECANIC  ! ");
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
	 public MECANIC getIdByDenumire(String den){
		    Session session = null;
		    MECANIC m = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();	      
		      Criteria criteria = session.createCriteria(MECANIC.class)
	                    .add(Restrictions.eq("nume",new String(den)));
		    m = (MECANIC) criteria.uniqueResult();
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
	 
	 public void updateMecanic(Integer id, String m,String m1,Integer t,String e, String a) throws SQLException {

			Session session = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				
				MECANIC n = (MECANIC) session.get(MECANIC.class, id);
				n.setNume(m);
				n.setPrenume(m1);
				n.setTelefon(t);
				n.setEmail(e);
				n.setAdresa(a);
					session.update(n);
				session.getTransaction().commit();
			} catch (Exception e1) {
				System.out.println("Eroare la schimbarea datelor in tabela MECANIC" );
				
				
			} finally {
				if (session != null && session.isOpen()) {

					session.close();
				}
			}
		}


}
