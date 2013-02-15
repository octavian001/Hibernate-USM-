package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class PIESEImplDAO {
	// adaugarea unei noi inregistrari
	public boolean addPiese(PIESE m) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(m);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Eroare la aduagarea datelor in tabela PIESE");
		}
		if (session != null && session.isOpen()) {
			session.close();
		}
		return false;
	}

	// afisarea tuturor inregistrarilor din tabel
	public Collection<PIESE> getAllPIESE() {
		Session session = null;
		List<PIESE> piese = new ArrayList<PIESE>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		} catch (Exception e) {
			System.out.println("Eroare la crearea sesiei: " + e);
		}
		try {
			piese = session.createCriteria(PIESE.class).list();
		} catch (Throwable e) {
			System.err.println("Eroare la afisarea tuturor marcilor ");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return piese;
	}

	public boolean deletePiese(Integer id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			PIESE m = (PIESE) session.get(PIESE.class, id);
			session.delete(m);
			session.getTransaction().commit();
			return true;
		} catch (IllegalArgumentException e1) {
			System.out
					.println("Nu exista asa inregistrare  in tabela PIESE ! ");
		} catch (Exception e) {
			System.out
					.println("Eroare la \"stergerea datelor din tabela PIESE\"");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return false;
	}

	// aflu ID dupa den_marca
	public PIESE getIdByDenumire(String den) {
		Session session = null;
		PIESE m = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(PIESE.class).add(
					Restrictions.eq("denumire", new String(den)));
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

	public boolean updatePiese(int id, String d, int p,int c)
			throws SQLException {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			// if(session.get(PIESE.class, id) != null)
			PIESE n = (PIESE) session.get(PIESE.class, id);
			n.setDenumire(d);
			n.setPret(p);
			n.setCantitate(c);
			session.update(n);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Eroare la schimbarea datelor in tabela PIESE");

		} finally {
			if (session != null && session.isOpen()) {

				session.close();
			}
		}
		return false;
	}

	/* Search Methods */

	public Collection<PIESE> searchByDenumire(String den) {
		Session session = null;
		List<PIESE> m = new ArrayList<PIESE>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(PIESE.class);
			m = criteria.add(Restrictions.ilike("denumire", "%" + den + "%"))
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

	public Collection<PIESE> searchByCantitate(int cant) {
		Session session = null;
		List<PIESE> m = new ArrayList<PIESE>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			m = session.createQuery("from PIESE where cantitate like :cant")
					.setString("cant", "%" + cant + "%").list();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nu ati selectat cimpul",
					" Eroare", JOptionPane.OK_OPTION);
		} finally {
			if (session.isOpen() && session != null)
				session.close();
		}
		return m;
	}

	public Collection<PIESE> searchByPret(int p) {
		Session session = null;
		List<PIESE> m = new ArrayList<PIESE>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			m = session.createQuery("from PIESE where pret like :p")
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
