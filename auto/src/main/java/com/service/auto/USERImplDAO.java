package com.service.auto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class USERImplDAO {
	
	public String MD5(String md5){
	  try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(md5.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    }
	    return null;
	}
	

	public ArrayList<USERS> getAllUser() {
			Session session = null;
			ArrayList<USERS> user = new ArrayList<USERS>();
			try {
				session = HibernateUtil.getSessionFactory().openSession();
			} catch (Exception e) {
				System.out.println("Eroare la crearea sesiei: " + e);
			}
			try {
				user = (ArrayList<USERS>) session.createCriteria(USERS.class).list();
			} catch (Throwable e) {
				System.err.println("Eroare la afisarea tuturor operatiilor ");
				e.printStackTrace();
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return user;
		}
	
	public ArrayList<USERS> getUserByNameAndPass(String user, String password){
		Session session = null;
		ArrayList<USERS> results = null;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();	
		try{
				org.hibernate.Query query =  session.createQuery("SELECT " +
				" u FROM USERS u WHERE u.user = :users AND u.password = :pass ");
		query.setParameter("users", user);
		query.setParameter("pass", password);
		results = (ArrayList<USERS>) query.list();
		}catch(Exception e) {}
		finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return results;
	}
	
	
	// adaugarea unei noi inregistrari
		public boolean addUser(USERS m) {
			Session session = null;

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.save(m);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Eroare la adaugarea unui nou USER");
			}
			if (session != null && session.isOpen()) {
				session.close();
			}
			return false;
		}

		
		public boolean deleteUser(Integer id) {
			Session session = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				USERS m = (USERS) session.get(USERS.class, id);
				session.delete(m);
				session.getTransaction().commit();
				return true;
			} catch (IllegalArgumentException e1) {
				System.out
						.println("Nu exista asa inregistrare  in tabela USERS ! ");
			} catch (Exception e) {
				System.out
						.println("Eroare la \"stergerea datelor din tabela USERS\"");
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return false;
		}
		
		public boolean updateUser(int id, String user, String pass,String role)
				throws SQLException {

			Session session = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				// if(session.get(PIESE.class, id) != null)
				USERS n = (USERS) session.get(USERS.class, id);
				n.setUser(user);
				n.setPassword(pass);
				n.setRole(role);
				session.update(n);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Eroare la schimbarea datelor in tabela USERS");

			} finally {
				if (session != null && session.isOpen()) {

					session.close();
				}
			}
			return false;
		}

		public Collection<USERS> searchByUsername(String den) {
			Session session = null;
			List<USERS> m = new ArrayList<USERS>();

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				Criteria criteria = session.createCriteria(USERS.class);
				m = criteria.add(Restrictions.ilike("user", "%" + den + "%"))
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

		public Collection<USERS> searchByRole(String den) {
			Session session = null;
			List<USERS> m = new ArrayList<USERS>();

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				Criteria criteria = session.createCriteria(USERS.class);
				m = criteria.add(Restrictions.ilike("role", "%" + den + "%"))
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
