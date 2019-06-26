package com.techlab.report;

public class Report {
	private String header;
	private String data;
	private String footer;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		System.out.println("Setting report header");
		this.header = header;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		System.out.println("Setting report data");
		this.data = data;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		System.out.println("Setting report footer");
		this.footer = footer;
	}
}
