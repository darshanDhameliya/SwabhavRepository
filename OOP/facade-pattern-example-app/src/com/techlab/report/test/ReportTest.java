package com.techlab.report.test;

import com.techlab.report.ReportType;
import com.techlab.report.generator.ReportGenerator;

public class ReportTest {

	public static void main(String args[])
	{
		ReportGenerator reportGenerator=new ReportGenerator();
		reportGenerator.generateReport(ReportType.HTML, "");
		reportGenerator.generateReport(ReportType.PDF, "");
	}
}
