package ProjPackage;

//Joshua Barber
//OOSD in Java
//Project 1

import java.util.Random;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		//track_id,artist_name,genre,track_title, album_title,year_created,artist_longitude
		
		// creates a song
		Song s1 = new Song(1,"Luke Combs","Country","Beautiful Crazy","idk",0,0);
		System.out.println(s1);
		
		// creates a song with default constructor then adds some data
		Song s2 = new Song();
		System.out.println(s2);
		s2.setTrackID(3);
		s2.setArtistName("Luke Bryan");
		s2.setGenre("Country");
		System.out.println(s2);
		System.out.println();
	
		// creates a playlist object and adds the 2 songs from above
		Playlist Country = new Playlist();
		Country.setplaylistName("Country");
		System.out.println("Before adding songs:\n" + Country);
		Country.addSong(s1);
		Country.addSong(s2);
		System.out.println("After adding songs:\n" + Country);	
		
		// test creating playlist from textfile
		Playlist TextFile = new Playlist("TEXTFILE","./ProjPackage/finalTracks.csv");
		System.out.println("\ntest reading text file");
		// line below writes all of them, takes up entire console so I keep it commented
		//System.out.println(TextFile);
		//TextFile.addSong(s3);	
		
		/*
		Instructor i4 = new Instructor("mark","987","m@uca.edu");
		csci3381.addInstructor(i4);		
		
		System.out.println("\ntest combined data from file and data added manually");
		System.out.println(csci3381);		
		csci3381.writeFile("./classroster/dataWriteTest.txt");
		*/
		
		//Country.writeFile("./classroster/dataWriteTest.txt");
		
		//Playlist testWrite = new Playlist("Test Write","./classroster/dataWriteTest.txt");
		//System.out.println("\ntest reading just created file");
		//System.out.println(testWrite);
		
	}

}