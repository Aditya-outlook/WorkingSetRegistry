/**
 * 
 */
package com.nsn.wsr.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nsn.wsr.NE;
import com.nsn.wsr.Scope;

/**
 * @author akadiyal
 * 
 */
public class DBHandler {

	private static Connection connection = null;

	private static Connection createConnection() throws SQLException {
		try {
			return DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/ood", "postgres",
					"sairam");
			/*
			 * if (conn != null) {
			 * System.out.println("You may take control your database now!");
			 * return conn; } else {
			 * System.out.println("Failed to make connection!"); return null; }
			 */
		} catch (SQLException e) {
			System.err.println("Connection Failed! Check output console");
			e.printStackTrace();
			throw e;
		}
	}

	private static Connection getConnection() throws SQLException {
		if (null == connection) {
			connection = createConnection();
		}
		return connection;
	}

	public static Boolean persistNE(NE newNE) {
		return null;
	}

	public static Boolean updatePersistedNE(NE updatedNE) {
		return null;
	}

	public static Boolean persistNEs(List<NE> newNEs) {
		return null;

	}

	public static Boolean persistScope(Scope newScope) {
		return null;

	}

	public static Boolean persistScopes(List<Scope> newScopes) {
		return null;

	}

	public static Boolean updatePersistedScope(Scope updatedScope) {
		return null;
	}

	public static List<NE> getAllNEs() {
		List<NE> nes = new ArrayList<NE>();
		try {
			String query = "SELECT * FROM nedata";
			ResultSet rs = getConnection().createStatement()
					.executeQuery(query);

			while (rs.next()) {
				NE ne = new NE(rs.getString("id"));
				ne.setType(rs.getString(NE.idCol));
				ne.setParentID(rs.getString(NE.parentIDCol));
				ne.setLatitude(rs.getString(NE.latitudeCol));
				ne.setLongitude(rs.getString(NE.longitudeCol));
				ne.setSwVersion(rs.getString(NE.swVersionCol));
				ne.setTechnology(rs.getString(NE.technologyCol));
				ne.setPresentationName(rs.getString(NE.presentationNameCol));
				nes.add(ne);
			}
		} catch (SQLException e) {
			System.err.println("Something wrong with the DB.");
			e.printStackTrace();
		}
		return nes;
	}

	/**
	 * @param args
	 */
	public static void main(String[] argv) {
		Iterator<NE> nes = getAllNEs().iterator();
		while (nes.hasNext()) {
			nes.next().consoleLogNE();
		}
	}
}
