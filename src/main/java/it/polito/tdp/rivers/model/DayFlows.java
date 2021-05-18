package it.polito.tdp.rivers.model;

public class DayFlows {
	
	float inFlow;
	float outFlow;
	
	public DayFlows(float inFlow, float outFlow) {
		super();
		this.inFlow = inFlow;
		this.outFlow = outFlow;
	}

	public float getInFlow() {
		return inFlow;
	}

	public void setInFlow(float inFlow) {
		this.inFlow = inFlow;
	}

	public float getOutFlow() {
		return outFlow;
	}

	public void setOutFlow(float outFlow) {
		this.outFlow = outFlow;
	}

	@Override
	public String toString() {
		return "DayFlows [inFlow=" + inFlow + ", outFlow=" + outFlow + "]";
	}
	
	

}
