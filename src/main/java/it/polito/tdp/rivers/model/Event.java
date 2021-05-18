package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event implements Comparable<Event>{
	
	public enum EventType {
		AUMENTO_BACINO,
		DIMINUZIONE_BACINO,
		TRACIMAZIONE,
		BACINO_SECCO
	}
	
	private LocalDate time ;
	private EventType type ;

	@Override
	public int compareTo(Event other) {
		return this.time.compareTo(other.time);
	}

	public Event(LocalDate time, EventType type) {
		super();
		this.time = time;
		this.type = type;
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Event [time=" + time + ", type=" + type + "]";
	}

}
