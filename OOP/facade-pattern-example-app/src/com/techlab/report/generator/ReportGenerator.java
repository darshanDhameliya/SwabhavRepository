package com.techlab.report.generator;

import com.techlab.report.Report;
import com.techlab.report.ReportType;
import com.techlab.report.writer.ReportWriter;

public class ReportGenerator {

	private static ReportWriter writer = new ReportWriter();

	public static void generateReport(ReportType type, String location) {

		Report report = new Report();

		report.setHeader("");
		report.setFooter("");

		report.setData("");

		switch (type) {
		case HTML:
			writer.writeHtmlReport(report, location);
			break;

		case PDF:
			writer.writePdfReport(report, location);
			break;
		}
	}
}
