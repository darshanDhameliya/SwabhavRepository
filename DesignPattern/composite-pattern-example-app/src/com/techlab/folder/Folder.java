package com.techlab.folder;

import java.util.ArrayList;

import com.techlab.idirectory.component.IDirectoryComponent;

public class Folder implements IDirectoryComponent {
	private String name;
	private ArrayList<IDirectoryComponent> childrens = new ArrayList<IDirectoryComponent>();
	private String space="\t";
	private static boolean displayMainFolderName=true;
	
	public Folder(String name) {
		this.name = name;
	}

	public void addChildren(IDirectoryComponent children) {
		children.setSpace(this.getSpace()+"\t");
		childrens.add(children);
	}

	private String getSpace()
	{
		return space;
	}
	@Override
	public void display() {
		if (displayMainFolderName) {
			System.out.println(this.getDetail());
			displayMainFolderName=false;
		}
		for (IDirectoryComponent children : childrens) {
			System.out.println(space+children.getDetail());
			children.display();
		}
	}

	@Override
	public String getDetail() {
		return this.name;
	}

	@Override
	public void setSpace(String space) {
		this.space=space;
	}

}
