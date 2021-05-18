package it.polito.tdp.rivers.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();
		List<DayFlows> list = model.getRiverInsOuts(1, 50);
		for (DayFlows df : list) {
			System.out.println(df);
		}
		

	}

}
