package com.techlab.file.operation.example;

import java.io.File;

public class FileOperationTest {
	public static void main(String args[]) {
		FileOperation fileOperat=new FileOperation();
		File file = new File("E:\\fileOperation");
		
		fileOperat.createFile(file);
		fileOperat.writeFile(file, "hello");
		fileOperat.readFile(file);
		fileOperat.appendFile(file," sir");
		fileOperat.readFile(file);
	}

}
