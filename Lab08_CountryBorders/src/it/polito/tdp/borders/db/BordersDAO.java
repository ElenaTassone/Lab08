package it.polito.tdp.borders.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.Country;

public class BordersDAO {

	public List<Country> loadAllCountries() {

		List<Country> paesi = new ArrayList<Country>();
		String sql = "SELECT ccode,StateAbb,StateNme " + "FROM country " + "ORDER BY StateAbb ";

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				//System.out.format("%d %s %s\n", rs.getInt("ccode"), rs.getString("StateAbb"), rs.getString("StateNme"));
				paesi.add(new Country(rs.getInt("ccode"), rs.getString("StateAbb"), rs.getString("StateNme")));
			}

			conn.close();
			return paesi ; 

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- loadAllCountries");
			throw new RuntimeException("Database Error");
		}
	}

	public List<Border> getCountryPairs(int anno) {
		
		List<Border> confini = new ArrayList<Border>();		
		String sql = "SELECT dyad,state1ab,state2ab,year " + "FROM contiguity " + "WHERE conttype=1 AND year <= ? ";
		
		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, anno);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
//				System.out.format("%s %s\n", rs.getString("state1ab"),rs.getString("state2ab"));
				confini.add(new Border(rs.getInt("dyad"),
										new Country(rs.getString("state1ab")),
										new Country(rs.getString("state2ab")),
										rs.getInt("year"))) ;
			}

			conn.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- loadAllCountries");
			throw new RuntimeException("Database Error");
		}
		return confini;
	}
}
