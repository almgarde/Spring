package com.nttdata.NttDataSpring.persistence;

import java.io.Serializable;

public class Person implements Serializable {

	/** SERIAL */
	private static final long serialVersionUID = 1L;

	/** Nombre de la persona */
	private String name;

	/** Apellido de la Persona */
	private String surName;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surName=" + surName + "]";
	}

}
