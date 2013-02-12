package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

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
	
	 
	 public PROPRIETAR getIdByNume(String den){
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
	 
	 public void updateProprietar(Integer id, String m,String p,String c,Integer t, String a) throws SQLException {

			Session session = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				
				PROPRIETAR n = (PROPRIETAR) session.get(PROPRIETAR.class, id);
				n.setNume(m);
				n.setPrenume(p);
				n.setCnp(c);
				n.setTelefon(t);
				n.setAdresa(a);
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
	 
	 public Collection<PROPRIETAR> searchByNume(String nume) {
			Session session = null;
			List<PROPRIETAR> m = new ArrayList<PROPRIETAR>();

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				Criteria criteria = session.createCriteria(PROPRIETAR.class);
				m = criteria.add(Restrictions.ilike("nume", "%" + nume + "%"))
						.list();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Eroare", " Eroare",
						JOptionPane.OK_OPTION);
			}finally{
				if(session.isOpen() && session != null)
					session.close();
			}

			return m;
		}
     
	 public Collection<PROPRIETAR> searchByPrenume(String prenume) {
			Session session = null;
			List<PROPRIETAR> m = new ArrayList<PROPRIETAR>();

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				Criteria criteria = session.createCriteria(PROPRIETAR.class);
				m = criteria.add(Restrictions.ilike("prenume", "%" + prenume + "%"))
						.list();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Eroare", " Eroare",
						JOptionPane.OK_OPTION);
			}finally{
				if(session.isOpen() && session != null)
					session.close();
			}

			return m;
		}
	 
	 public Collection<PROPRIETAR> searchByTelefon(Integer tel) {
			Session session = null;
			List<PROPRIETAR> m = new ArrayList<PROPRIETAR>();

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				Criteria criteria = session.createCriteria(PROPRIETAR.class);
				m = criteria.add(Restrictions.ilike("telefon", "%" + tel + "%"))
						.list();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Eroare", " Eroare",
						JOptionPane.OK_OPTION);
			}finally{
				if(session.isOpen() && session != null)
					session.close();
			}

			return m;
		}
	 
	 public Collection<PROPRIETAR> searchByAdresa(String adresa) {
			Session session = null;
			List<PROPRIETAR> m = new ArrayList<PROPRIETAR>();

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				Criteria criteria = session.createCriteria(PROPRIETAR.class);
				m = criteria.add(Restrictions.ilike("adresa", "%" + adresa + "%"))
						.list();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Eroare", " Eroare",
						JOptionPane.OK_OPTION);
			}finally{
				if(session.isOpen() && session != null)
					session.close();
			}

			return m;
		}
	 
	 public Collection<PROPRIETAR> searchByCnp(String cnp) {
			Session session = null;
			List<PROPRIETAR> m = new ArrayList<PROPRIETAR>();

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				Criteria criteria = session.createCriteria(PROPRIETAR.class);
				m = criteria.add(Restrictions.ilike("cnp", "%" + cnp + "%"))
						.list();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Eroare", " Eroare",
						JOptionPane.OK_OPTION);
			}finally{
				if(session.isOpen() && session != null)
					session.close();
			}

			return m;
		}
	 

}
