package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class MARCAImplDAO {

	// adaugarea unei noi inregistrari
	public boolean addMarca(MARCA m) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(m);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Eroare la aduagarea datelor in tabela MARCA");
		}
		if (session != null && session.isOpen()) {
			session.close();
		}
		return false;
	}

	// afisarea tuturor inregistrarilor din tabel
	public Collection<MARCA> getAllMarca() {
		Session session = null;
		List<MARCA> marca = new ArrayList<MARCA>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		} catch (Exception e) {
			System.out.println("Eroare la crearea sesiei: " + e);
		}
		try {
			marca = session.createCriteria(MARCA.class).list();
		} catch (Throwable e) {
			System.err.println("Eroare la afisarea tuturor marcilor ");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return marca;
	}

	public boolean deleteMarca(Integer id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			MARCA m = (MARCA) session.get(MARCA.class, id);
			session.delete(m);
			session.getTransaction().commit();
			return true;
		} catch (IllegalArgumentException e1) {
			System.out
					.println("Nu exista asa inregistrare  in tabela MARCA ! ");
		} catch (Exception e) {
			System.out
					.println("Eroare la \"stergerea datelor din tabela MARCA\"");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return false;
	}

	// aflu ID dupa den_marca
	public MARCA getIdByDenumire(String den) {
		Session session = null;
		MARCA m = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(MARCA.class).add(
					Restrictions.eq("den_marca", new String(den)));
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

	public boolean updateMarca(Integer id, String m) throws SQLException {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// if(session.get(MARCA.class, id) != null)
			MARCA n = (MARCA) session.get(MARCA.class, id);
			n.setDen_marca(m);
			session.update(n);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Eroare la schimbarea datelor in tabela MARCA");

		} finally {
			if (session != null && session.isOpen()) {

				session.close();
			}
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<MARCA> searchByDen_marca(String den) {
		Session session = null;
		List<MARCA> m = new ArrayList<MARCA>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(MARCA.class);
			m = criteria.add(Restrictions.ilike("den_marca", "%" + den + "%"))
					.list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nu ati selectat cimpul",
					" Eroare", JOptionPane.OK_OPTION);
		} finally {
			if (session.isOpen() && session != null)
				session.close();
		}
		return m;
	}

}
