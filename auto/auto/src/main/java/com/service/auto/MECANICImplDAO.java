package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class MECANICImplDAO {

	public boolean addMecanic(MECANIC m) {
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
							"Nu ati introdus corect datele sau exista deja asa inregistrari in tabel",
							" Eroare", JOptionPane.OK_OPTION);
			System.out.println("Eroare la aduagarea datelor in tabela MECANIC");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return false;
	}

	// afisarea tuturor inregistrarilor din tabel
	public Collection<MECANIC> getAllMecanic() {
		Session session = null;
		List<MECANIC> m = new ArrayList<MECANIC>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		} catch (Exception e) {
			System.out.println("Eroare la crearea sesiei: " + e);
		}
		try {
			m = session.createCriteria(MECANIC.class).list();
		} catch (Throwable e) {
			System.err.println("Eroare la afisarea tuturor mecanicilor");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return m;
	}

	public boolean deleteMecanic(Integer id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			MECANIC m = (MECANIC) session.get(MECANIC.class, id);
			session.delete(m);
			session.getTransaction().commit();
			return true;
		} catch (IllegalArgumentException e1) {
			JOptionPane.showMessageDialog(null,
					"Nu exista asa inregistrare in tabel", " Eroare",
					JOptionPane.OK_OPTION);
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
	public MECANIC getIdByDenumire(String den) {
		Session session = null;
		MECANIC m = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(MECANIC.class).add(
					Restrictions.eq("nume", new String(den)));
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

	public MECANIC getRowById(Integer id) {
		Session session = null;
		MECANIC m = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			m = (MECANIC) session.get(MECANIC.class, id);
		} catch (Exception e) {
			System.out.println("Eroare la : getRowById");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return m;
	}

	public boolean updateMecanic(Integer id, String m, String m1, String c,
			Integer t, String e, String a) throws SQLException {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			MECANIC n = (MECANIC) session.get(MECANIC.class, id);
			n.setNume(m);
			n.setPrenume(m1);
			n.setCnm(c);
			n.setTelefon(t);
			n.setEmail(e);
			n.setAdresa(a);
			session.update(n);
			session.getTransaction().commit();

			return true;
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null,
					"Nu ati introdus corect datele", " Eroare",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {

				session.close();
			}
		}
		return false;
	}

	/* Metode de cautare dupa un anumit cimp din tabela */

	// cauta rezultate dupa cimpul Nume
	public Collection<MECANIC> searchByNume(String nume) {
		Session session = null;
		List<MECANIC> m = new ArrayList<MECANIC>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(MECANIC.class);
			m = criteria.add(Restrictions.ilike("nume", "%" + nume + "%"))
					.list();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Eroare", " Eroare",
					JOptionPane.OK_OPTION);
		} finally {
			if (session.isOpen() && session != null)
				session.close();
		}

		return m;
	}

	// cauta rezultate dupa cimpul Prenume
	public Collection<MECANIC> searchByPrenume(String prenume) {
		Session session = null;
		List<MECANIC> m = new ArrayList<MECANIC>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(MECANIC.class);
			m = criteria
					.add(Restrictions.ilike("prenume", "%" + prenume + "%"))
					.list();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nu ati selectat rindul",
					" Eroare", JOptionPane.OK_OPTION);
		} finally {
			if (session.isOpen() && session != null)
				session.close();
		}

		return m;
	}

	// cauta rezultate dupa cimpul Cnm
	public Collection<MECANIC> searchByCnm(String cnm) {
		Session session = null;
		List<MECANIC> m = new ArrayList<MECANIC>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(MECANIC.class);
			m = criteria.add(Restrictions.ilike("cnm", "%" + cnm + "%")).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Eroare", " Eroare",
					JOptionPane.OK_OPTION);
		} finally {
			if (session.isOpen() && session != null)
				session.close();
		}

		return m;
	}

	public Collection<MECANIC> searchByTelefon(int tel) {
		Session session = null;
		List<MECANIC> m = new ArrayList<MECANIC>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			m = session.createQuery("from MECANIC where telefon like :tel")
					.setString("tel", "%" + tel + "%").list();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Eroare", " Eroare",
					JOptionPane.OK_OPTION);
		} finally {
			if (session.isOpen() && session != null)
				session.close();
		}
		return m;
	}

	public Collection<MECANIC> searchByEmail(String email) {
		Session session = null;
		List<MECANIC> m = new ArrayList<MECANIC>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(MECANIC.class);
			m = criteria.add(Restrictions.ilike("email", "%" + email + "%"))
					.list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Eroare", " Eroare",
					JOptionPane.OK_OPTION);
		} finally {
			if (session.isOpen() && session != null)
				session.close();
		}
		return m;
	}

	public Collection<MECANIC> searchByAdresa(String adr) {
		Session session = null;
		List<MECANIC> m = new ArrayList<MECANIC>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(MECANIC.class);
			m = criteria.add(Restrictions.ilike("adresa", "%" + adr + "%"))
					.list();
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
