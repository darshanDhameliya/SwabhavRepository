package com.techlab.control;

import com.techlab.ihtml.element.IHtmlElement;

public class Control implements IHtmlElement {
	private String text;
	private String tagName;
	private String inputType;
	private String htmlTag;

	public Control(String text) {
		this.text = text;
	}

	public Control(String text, String tagName, String inputType) {
		this.text = text;
		this.tagName = tagName;
		this.inputType = inputType;
	}

	@Override
	public String parseToHtml() {
		htmlTag = "";
		if (tagName == null && inputType == null) {
			System.out.println("\t"+text);
			return text + "<br>";
		}

		htmlTag = this.text + " : <" + tagName + " type=" + this.inputType + "/><br>";
		System.out.println("\t"+htmlTag);
		return htmlTag;

	}

}
