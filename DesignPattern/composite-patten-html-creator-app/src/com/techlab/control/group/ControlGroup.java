package com.techlab.control.group;

import java.util.ArrayList;

import com.techlab.ihtml.element.IHtmlElement;

public class ControlGroup implements IHtmlElement {
	private String name;
	private String htmlString;
	private ArrayList<IHtmlElement> children = new ArrayList<IHtmlElement>();
	private ControlGroup controlGroup;
	private String space="";

	public ControlGroup(String name) {
		this.name = name;
	}

	public void addChildren(IHtmlElement child) {
		if (child instanceof ControlGroup) {
			controlGroup=(ControlGroup)child;
			controlGroup.setSpace(this.space+"\t");
		}
		children.add(child);
	}

	private void setSpace(String space)
	{
		this.space=space;
	}
	@Override
	public String parseToHtml() {
		htmlString = "<" + this.name + ">";
		System.out.println(space+"<" + this.name + ">");
		for (IHtmlElement child : children) {
			htmlString = htmlString + child.parseToHtml();
		}
		htmlString = htmlString + "</" + this.name + ">";
		System.out.println(space+"</" + this.name + ">");
		return htmlString;
	}
}
