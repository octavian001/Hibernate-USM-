package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class OPERATIEImplDAO {

	// extrag toate operatiile dupa ID_BON, pentru a putea incarca in tabela
	// principala toate operatiile pentru un anumit ID_BON
	public ArrayList<OPERATIE> getAllOperFK(int i) {
		ArrayList<OPERATIE> results = null;
		Session session = null;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			org.hibernate.Query query = session.createQuery("SELECT "
					+ " o FROM OPERATIE o  JOIN o.bon b WHERE b.id_bon = :t ");
			query.setParameter("t", i);
			results = (ArrayList<OPERATIE>) query.list();

		} catch (Exception ex) {
		}
		if (session != null && session.isOpen()) {
			session.close();
		}
		return results;
	}

	// adaugarea unei noi inregistrari
	public boolean addOperatie(OPERATIE m) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(m);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out
					.println("Eroare la aduagarea datelor in tabela OPERATIE");
		}
		if (session != null && session.isOpen()) {
			session.close();
		}
		return false;
	}

	// afisarea tuturor inregistrarilor din tabel
	public Collection<OPERATIE> getAllOperatie() {
		Session session = null;
		List<OPERATIE> oper = new ArrayList<OPERATIE>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		} catch (Exception e) {
			System.out.println("Eroare la crearea sesiei: " + e);
		}
		try {
			oper = session.createCriteria(OPERATIE.class).list();
		} catch (Throwable e) {
			System.err.println("Eroare la afisarea tuturor operatiilor ");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return oper;
	}

	public boolean deleteOperatie(Integer id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			OPERATIE m = (OPERATIE) session.get(OPERATIE.class, id);
			session.delete(m);
			session.getTransaction().commit();
			return true;
		} catch (IllegalArgumentException e1) {
			System.out
					.println("Nu exista asa inregistrare  in tabela OPERATIE ! ");
		} catch (Exception e) {
			System.out
					.println("Eroare la \"stergerea datelor din tabela OPERATIE\"");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return false;
	}

	// aflu ID dupa den_marca
	public OPERATIE getIdByDenumire(String den) {
		Session session = null;
		OPERATIE m = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(OPERATIE.class).add(
					Restrictions.eq("den_oper", new String(den)));
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

	public boolean updateOperatie(Integer id, String d, Integer p)
			throws SQLException {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// if(session.get(MARCA.class, id) != null)
			OPERATIE n = (OPERATIE) session.get(OPERATIE.class, id);
			n.setDen_oper(d);
			n.setPret_oper(p);
			session.update(n);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out
					.println("Eroare la schimbarea datelor in tabela OPERATIE");

		} finally {
			if (session != null && session.isOpen()) {

				session.close();
			}
			return false;
		}
	}

	/* Search Methods */
	public Collection<OPERATIE> searchByDenumire(String den) {
		Session session = null;
		List<OPERATIE> m = new ArrayList<OPERATIE>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(OPERATIE.class);
			m = criteria.add(Restrictions.ilike("den_oper", "%" + den + "%"))
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

	public Collection<OPERATIE> searchByPret(int p) {
		Session session = null;
		List<OPERATIE> m = new ArrayList<OPERATIE>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			m = session.createQuery("from OPERATIE where pret_oper like :p")
					.setString("p", "%" + p + "%").list();
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
