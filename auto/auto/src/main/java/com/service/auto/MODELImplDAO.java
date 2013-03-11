package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class MODELImplDAO {
	// adaugarea unei noi inregistrari
	public boolean addModel(MODEL m) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(m);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Nu poate fi adaugata  inregistrarea sau exista asa inregistrare",
							" Eroare", JOptionPane.OK_OPTION);
		}
		if (session != null && session.isOpen()) {
			session.close();
		}
		return false;
	}

	// afisarea tuturor inregistrarilor din tabel
	public Collection<MODEL> getAllModel() {
		Session session = null;
		List<MODEL> m = new ArrayList<MODEL>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		} catch (Exception e) {
			System.out.println("Eroare la crearea sesiei: " + e);
		}
		try {
			m = session.createCriteria(MODEL.class).list();
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,
					"Eroare la afisarea datelor, incercati mai tirziu",
					" Eroare", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return m;
	}

	public boolean deleteMODEL(Integer id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			MODEL m = (MODEL) session.get(MODEL.class, id);
			session.delete(m);
			session.getTransaction().commit();
			return true;
		} catch (IllegalArgumentException e1) {
			JOptionPane.showMessageDialog(null, "Nu exista asa inregistrare",
					" Eroare", JOptionPane.OK_OPTION);
		} catch (Exception e) {
			System.out.println("Eroare la \"stergerea inregistrarii\"");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return false;
	}

	// aflu ID dupa den_marca
	public MODEL getIdByDenumire(String den) {
		Session session = null;
		MODEL m = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(MODEL.class).add(
					Restrictions.eq("den_model", new String(den)));
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

	public boolean updateModel(Integer id, String m, MARCA idm)
			throws SQLException {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// if(session.get(MARCA.class, id) != null)
			MODEL n = (MODEL) session.get(MODEL.class, id);
			n.setDen_model(m);
			n.setMarca(idm);
			session.update(n);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Eroare la schimbarea datelor in tabela MODEL");
			JOptionPane.showMessageDialog(null,
					"Eroare la schimbarea datelor in tabela", " Eroare",
					JOptionPane.OK_OPTION);

		} finally {
			if (session != null && session.isOpen()) {

				session.close();
			}
		}
		return false;
	}

	/*Search Methods*/
	public List<MODEL> searchByDen_model(String den) {
		Session session = null;
		List<MODEL> m = new ArrayList<MODEL>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(MODEL.class);
			m = criteria.add(Restrictions.ilike("den_model", "%" + den + "%"))
					.list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Eroare la cautarea datelor",
					" Eroare", JOptionPane.OK_OPTION);
		} finally {
			if (session.isOpen() && session != null)
				session.close();
		}
		return m;
	}
	
	public List<MODEL> searchByFkMarca(String den,List<MODEL> model) {
		Session session = null;
		MODEL m1 = new MODEL();
		List<MODEL> m = new ArrayList<MODEL>();
		try {
		
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
		   
			//model.get();
			
			m = session.createQuery("from MODEL where id_marca like :den")
					.setString("den", "%" + den + "%").list();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Eroare", " Eroare",
					JOptionPane.OK_OPTION);
		} finally {
			if (session.isOpen() && session != null)
				session.close();
		}
		return m;
	}
}
