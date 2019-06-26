package com.techlab.icrudable.test;

import com.techlab.icrudable.DepartmentDB;
import com.techlab.icrudable.EmployeeDB;
import com.techlab.icrudable.Icrudable;
import com.techlab.icrudable.LocationDB;

public class IcrudableTest {

	public static void main(String args[])
	{
		doDBOperation(new EmployeeDB());
		doDBOperation(new DepartmentDB());
		doDBOperation(new LocationDB());
		
	}
	public static void doDBOperation(Icrudable x)
	{
		x.create();
		x.read();
		x.update();
		x.delete();
	}
}
