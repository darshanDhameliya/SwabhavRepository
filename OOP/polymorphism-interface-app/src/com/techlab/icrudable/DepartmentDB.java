package com.techlab.icrudable;

public class DepartmentDB implements Icrudable{

	@Override
	public void create() {
		System.out.println("department create");
	}

	@Override
	public void read() {
		System.out.println("department read");
	}

	@Override
	public void update() {
		System.out.println("department update");
	}

	@Override
	public void delete() {
		System.out.println("department delete");
	}

}
