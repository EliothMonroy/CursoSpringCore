package org.certificatic.practica1.interfaces.livingbeing.api.impl;

import org.certificatic.practica1.interfaces.livingbeing.api.BugEater;

public class VenusFlyTrap extends Plant implements BugEater {

	// Implementar
	public VenusFlyTrap() {
		this.setSubType("venus fly trap");
	}

	public void born() {
		System.out.println("born like a " + this.getType() + " (" + this.getSubType() + ")");
	}

	public void grow() {
		System.out.println("grow like a " + this.getType() + " (" + this.getSubType() + ")");
	}

	public void breed() {
		System.out.println("breed like a " + this.getType() + " (" + this.getSubType() + ")");
	}

	public void die() {
		System.out.println("die like a " + this.getType() + " (" + this.getSubType() + ")");
	}

	public void eatBug() {
		System.out.println("eating bug like a " + this.getType() + " (" + this.getSubType() + ")");
	}

}
