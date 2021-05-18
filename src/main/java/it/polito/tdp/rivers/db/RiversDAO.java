package it.polito.tdp.rivers.db;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import it.polito.tdp.rivers.model.DayFlows;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.RiverData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RiversDAO {

	public List<River> getAllRivers() {
		
		final String sql = "SELECT id, name FROM river";

		List<River> rivers = new LinkedList<River>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				rivers.add(new River(res.getInt("id"), res.getString("name")));
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return rivers;
	}
	
	public RiverData getRiverData(int riverId) {
		
		final String sql = "SELECT river, MIN(day) as min, MAX(day) as max, COUNT(*) as count, AVG(flow) as avg "
				+ "FROM flow "
				+ "WHERE river = ?";

		RiverData data = null;

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, riverId);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				data = new RiverData(res.getInt("river"), res.getDate("min").toLocalDate(), res.getDate("max").toLocalDate(), res.getInt("count"), res.getFloat("avg"));
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return data;
	}
	
	public List<DayFlows> getRiverInsOuts(int riverId, float fOut) {
		
		final String sql = "SELECT flow "
				+ "FROM flow "
				+ "WHERE river = ?";

		List<DayFlows> list = new ArrayList<DayFlows>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, riverId);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				if ((new Random().nextInt(20))==0) { //nel 5% dei casi fOut è 10*fOut -> faccio random 
													 //tra 0 e 19, ogni numero esce con 5% di probabilità
													 //testo se è uguale a 0 per esempio
					float fOutAumentato = 10*fOut;
					DayFlows flows = new DayFlows(res.getFloat("flow"), fOutAumentato);
					list.add(flows);
				} 
				else {									
				DayFlows flows = new DayFlows(res.getFloat("flow"), fOut);
				list.add(flows);
				}
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return list;
	}
}
