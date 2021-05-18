package it.polito.tdp.rivers.model;

import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	RiversDAO dao;

	public Model() {
		this.dao = new RiversDAO();
	}
	
	public List<River> getAllRivers() {
		return dao.getAllRivers();
	}
	
	public RiverData getRiverData(int riverId) {
		return dao.getRiverData(riverId);
	}
	
	public List<DayFlows> getRiverInsOuts(int riverId, float fOut) {
		return dao.getRiverInsOuts(riverId, fOut);
	}
	
}
