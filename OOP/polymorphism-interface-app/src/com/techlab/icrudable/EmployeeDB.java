package com.techlab.icrudable;

public class EmployeeDB implements Icrudable{
	@Override
	public void create() {
		System.out.println("employee create");
	}

	@Override
	public void read() {
		System.out.println("employee read");
	}

	@Override
	public void update() {
		System.out.println("employee update");
	}

	@Override
	public void delete() {
		System.out.println("employee delete");
	}
}
