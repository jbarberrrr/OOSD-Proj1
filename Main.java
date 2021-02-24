package ProjPackage;

//Joshua Barber
//OOSD in Java
//Project 1

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//track_id,artist_name,genre,track_title, album_title,year_created,artist_longitude
		
		Song s1 = new Song(1,"Luke Combs","Country","Beautiful Crazy","idk",0,0);
		s1.toString();
		System.out.println(s1);
		Song s2 = new Song();
		System.out.println(s2);
		s2.setTrackID(3);
		s2.setArtistName("Luke Bryan");
		s2.setGenre("Country");
		System.out.println(s2);
		System.out.println();
	
		// test creating playlist from scratch
		Playlist Country = new Playlist();
		System.out.println(Country);
		Country.addSong(s1);
		Country.addSong(s2);
		System.out.println(Country);	
		
		/*
		// test creating playlist from textfile
		Playlist TextFile = new Playlist("TEXTFILE","./classroster/data.txt");
		System.out.println("\ntest reading text file");
		System.out.println(TextFile);
		//TextFile.addStudent(s4);	
		
		
		Instructor i4 = new Instructor("mark","987","m@uca.edu");
		csci3381.addInstructor(i4);		
		
		System.out.println("\ntest combined data from file and data added manually");
		System.out.println(csci3381);		
		csci3381.writeFile("./classroster/dataWriteTest.txt");
		
		Roster testWrite = new Roster("Test Write","./classroster/dataWriteTest.txt");
		System.out.println("\ntest reading just created file");
		System.out.println(testWrite);
		*/
	}

}