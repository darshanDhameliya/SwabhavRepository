package com.techlab.folder.test;

import com.techlab.file.File;
import com.techlab.folder.Folder;

public class FolderTest {

	public static void main(String args[]) {
		Folder movie = new Folder("Movie");
		Folder hindi = new Folder("Hindi");
		Folder english = new Folder("English");
		Folder marvel = new Folder("Marvel");
		Folder avengers = new Folder("Avengers");
		Folder ironman = new Folder("Iron man");

		File avengersOne = new File("Avengers 1", "mp4", 2);
		File avengersTwo = new File("Avengers 2", "mp4", 2);
		File avengersTree = new File("Avengers 3", "mp4", 2);
		File ironmanOne = new File("Iron man 1", "mp4", 2);
		File ironmanTwo = new File("Iron man 2", "mp4", 2);
		File ironmanTree = new File("Iron man 3", "mp4", 2);
		File batman = new File("Bat man", "mp4", 1);
		File heraferi = new File("Hera Feri", "mp4", 1);
		File kala = new File("Kala", "mp4", 1);

		movie.addChildren(hindi);
		movie.addChildren(english);
		movie.addChildren(kala);
		hindi.addChildren(heraferi);
		english.addChildren(batman);
		english.addChildren(marvel);
		marvel.addChildren(avengers);
		marvel.addChildren(ironman);
		avengers.addChildren(avengersOne);
		avengers.addChildren(avengersTwo);
		avengers.addChildren(avengersTree);
		ironman.addChildren(ironmanOne);
		ironman.addChildren(ironmanTwo);
		ironman.addChildren(ironmanTree);
		movie.display();
	}
}
