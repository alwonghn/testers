/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.mssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.HeroDTO;
import model.HeroSearchDTO;
import dao.DAOException;
import dao.HeroDAO;


/**
 *
 * @author a
 */
public class HeroDAOImpl implements HeroDAO {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/sample";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";

	public void deleteHero(HeroDTO hero) throws DAOException {
		String deleteSql = "DELETE FROM heros WHERE name='"
				+ hero.getName().trim() + "';";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing delete: " + deleteSql);
			int rows = st.executeUpdate(deleteSql);
			st.close();
		} catch (Exception e) {
			String error = "Error deleting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	public ArrayList<HeroDTO> findAllHero() throws DAOException {
		ArrayList<HeroDTO> items = new ArrayList<HeroDTO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String selectSql = "SELECT * FROM heros;";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing select: " + selectSql);
			ResultSet rs = st.executeQuery(selectSql);
			while (rs.next()) {
				HeroDTO oneHero = new HeroDTO();
				oneHero.setName(rs.getString("name"));
				oneHero.setDescription(rs.getString("description"));
				oneHero.setPlay(rs.getString("play"));
				items.add(oneHero);
			}
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
		return items;
	}

	public HeroDTO findHero(String heroName) throws DAOException {
		String selectSql = "SELECT * FROM heros WHERE name='" + heroName.trim()
				+ "';";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HeroDTO oneHero = new HeroDTO();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing select: " + selectSql);
			ResultSet rs = st.executeQuery(selectSql);
			while (rs.next()) {
				oneHero.setName(rs.getString("name"));
				oneHero.setDescription(rs.getString("description"));
				oneHero.setPlay(rs.getString("play"));
			}
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
		System.out.println(oneHero.toString());
		return oneHero;
	}

	public void insertHero(HeroDTO hero) throws DAOException {
		String insertSql = "INSERT INTO heros VALUES('" + hero.getName()
				+ "', '" + hero.getDescription() + "', '" + hero.getPlay()
				+ "');";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing insert: " + insertSql);
			int res = st.executeUpdate(insertSql);
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	public void updateHero(HeroDTO hero) throws DAOException {
		String updateSql = "UPDATE heros SET description = '"
				+ hero.getDescription() + "', play = '" + hero.getPlay()
				+ "' WHERE name='" + hero.getName() + "';";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing update: " + updateSql);
			int res = st.executeUpdate(updateSql);
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}

	}

	public ArrayList<HeroDTO> findHeroByCriteria(HeroSearchDTO so)
			throws DAOException {
		ArrayList<HeroDTO> list = new ArrayList<HeroDTO>();
		String selectSql = null;
		if (so.getDescription().trim().equalsIgnoreCase("")) {

			selectSql = "SELECT * FROM heros WHERE name LIKE '"
					+ so.getName().trim() + "%';";
		} else {
			if (so.getName().trim().equalsIgnoreCase("")) {
				selectSql = "SELECT * FROM heros WHERE description LIKE '"
						+ so.getDescription().trim() + "%';";
			} else {
				selectSql = "SELECT * FROM heros WHERE name LIKE '"
						+ so.getName().trim() + "%' AND description LIKE '"
						+ so.getDescription() + "%';";
			}
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Executing select: " + selectSql);
			ResultSet rs = st.executeQuery(selectSql);
			while (rs.next()) {
				HeroDTO oneHero = new HeroDTO();
				oneHero.setName(rs.getString("name"));
				oneHero.setDescription(rs.getString("description"));
				oneHero.setPlay(rs.getString("play"));
				System.out.println(oneHero.toString());
				list.add(oneHero);
			}
			st.close();
		} catch (Exception e) {
			String error = "Error selecting users. Nested Exception is: " + e;
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, error);
			throw new DAOException(error);
		} finally {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
			}
		}

		return list;
	}
}