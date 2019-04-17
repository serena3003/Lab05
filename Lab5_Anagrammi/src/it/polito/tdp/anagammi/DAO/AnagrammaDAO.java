package it.polito.tdp.anagammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	public boolean isCorrect(String s) {
		
		final String sql = "SELECT nome FROM parola " + 
				"WHERE nome = ? ";
		
		String res = null;
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, s);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				res = rs.getString("nome");
			}

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		if (res==null) {
			return false;
		}
		else return true;
	}
}
