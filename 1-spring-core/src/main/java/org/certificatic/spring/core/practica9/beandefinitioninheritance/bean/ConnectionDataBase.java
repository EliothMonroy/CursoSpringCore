package org.certificatic.spring.core.practica9.beandefinitioninheritance.bean;

import lombok.Data;

@Data
public class ConnectionDataBase {
	private String database;
	private String user;
	private String password;
	private boolean debugMode = false;

	public void connect() {
		String msg = String.format("> Connecting to: %s:%s:%s**** [%s]",
				database, user,
				password.substring(0, password.length() / 4),
				Integer.toHexString(super.hashCode()));

		System.out.println(msg);
	}

	public void disconnect() {
		String msg = String.format("> Disconnect from: %s:%s [%s]",
				database, user,
				Integer.toHexString(super.hashCode()));

		System.out.println(msg);
	}

	public void showInfo() {
		String msg = String.format("> Connected to: %s:%s [%s], DEBUG_MODE: %s",
				database, user,
				Integer.toHexString(super.hashCode()), debugMode);

		System.out.println(msg);
	}
}
