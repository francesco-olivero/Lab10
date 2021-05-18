package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class RiverData {
	int riverId;
	LocalDate minDate;
	LocalDate maxDate;
	int rilevazioni;
	float flussoMedio;
	
	public RiverData(int riverId, LocalDate minDate, LocalDate maxDate, int rilevazioni, float flussoMedio) {
		this.riverId = riverId;
		this.minDate = minDate;
		this.maxDate = maxDate;
		this.rilevazioni = rilevazioni;
		this.flussoMedio = flussoMedio;
	}

	public int getRiverId() {
		return riverId;
	}

	public void setRiverId(int riverId) {
		this.riverId = riverId;
	}

	public LocalDate getMinDate() {
		return minDate;
	}

	public void setMinDate(LocalDate minDate) {
		this.minDate = minDate;
	}

	public LocalDate getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(LocalDate maxDate) {
		this.maxDate = maxDate;
	}

	public int getRilevazioni() {
		return rilevazioni;
	}

	public void setRilevazioni(int rilevazioni) {
		this.rilevazioni = rilevazioni;
	}

	public float getFlussoMedio() {
		return flussoMedio;
	}

	public void setFlussoMedio(float flussoMedio) {
		this.flussoMedio = flussoMedio;
	}
	
	
}
