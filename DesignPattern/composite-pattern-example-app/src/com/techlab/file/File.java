package com.techlab.file;

import com.techlab.idirectory.component.IDirectoryComponent;

public class File implements IDirectoryComponent {
	private String name;
	private String extension;
	private int size;

	public File(String name, String extension, int size) {

		this.name = name;
		this.extension = extension;
		this.size = size;
	}

	@Override
	public String getDetail() {
		return this.name + "." + this.extension + "   size:" + this.size;
	}

	@Override
	public void display() {
	}

	@Override
	public void setSpace(String space) {
		// TODO Auto-generated method stub
		
	}
}
