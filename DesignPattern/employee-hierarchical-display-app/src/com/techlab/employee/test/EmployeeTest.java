package com.techlab.employee.test;
import com.techlab.data.loaded.DiskLoaded;
import com.techlab.data.loaded.URLLoaded;
import com.techlab.data.parse.DataParse;
import com.techlab.employee.hierarchy.builder.EmployeeHierarchyBuilder;

public class EmployeeTest {

	public static void main(String args[]) {
		// String urlPath="https://swabhav-tech.firebaseapp.com/emp.txt ";
		// DataParse dataParse=new DataParse(new URLLoaded(),urlPath);
		
		String diskPath = "employeeData\\dataFile.txt";
		DataParse dataParse = new DataParse(new DiskLoaded(), diskPath);

		EmployeeHierarchyBuilder employeeHierarchyBuilder = new EmployeeHierarchyBuilder(dataParse.getData());
		employeeHierarchyBuilder.genrateHierarchy();
		employeeHierarchyBuilder.displayEmployeeHierarchy();
	}
}
