package com.nttdata.NttDataSpring.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Building implements Serializable {

	/** SERIAL */
	private static final long serialVersionUID = 1L;

	/** Número de vecinos */
	private List<Person> neighbours;

	public Building() {
		this.neighbours = new ArrayList<Person>();
	}

	/**
	 * @return the neighbours
	 */
	public List<Person> getNeighbours() {
		return neighbours;
	}

	/**
	 * @param neighbours the neighbours to set
	 */
	public void setNeighbours(List<Person> neighbours) {
		this.neighbours = neighbours;
	}

	@Override
	public String toString() {
		return "Building [neighbours=" + neighbours + "]";
	}

}
