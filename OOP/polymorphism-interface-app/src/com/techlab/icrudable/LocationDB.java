package com.techlab.icrudable;

public class LocationDB implements Icrudable{
	@Override
	public void create() {
		System.out.println("location create");
	}

	@Override
	public void read() {
		System.out.println("location read");
	}

	@Override
	public void update() {
		System.out.println("location update");
	}

	@Override
	public void delete() {
		System.out.println("location delete");
	}

}
