package proj1;

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
		
		/*
		// test creating roster from scratch
		Student s1 = new Student();
//		System.out.println(s1);
		Student s2 = new Student("audrey","123",3.2);
//		System.out.println(s2);
		Roster myClass = new Roster();
		System.out.println(myClass);
		myClass.addStudent(s1);
		myClass.addStudent(s2);
		
		Instructor i1 = new Instructor();
		Instructor i2 = new Instructor("mark","987","m@uca.edu");
		myClass.addInstructor(i1);
		myClass.addInstructor(i2);		
		
		System.out.println(myClass);
		System.out.println();
		System.out.println();
		System.out.println();
		*/

		
		
		
		
		/*
		// test creating roster from textfile
		Student s4 = new Student("audrey","123",3.2);
//		System.out.println(s2);
		Roster csci3381 = new Roster("CSCI3381","./classroster/data.txt");
		System.out.println("\ntest reading text file");
		System.out.println(csci3381);
		csci3381.addStudent(s4);
		
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
