package ProjPackage;

//Joshua Barber
//OOSD in Java
//Project 1

import java.util.Random;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		// creates a pre-filled song
		System.out.println("s1:");
		Song s1 = new Song(1,"Luke Combs","Country","Beautiful Crazy","idk",0,0);
		System.out.println(s1);
		
		// creates a null song with default constructor then adds some data to it
		System.out.println("\ns2: (nothing added)");
		Song s2 = new Song();
		System.out.println(s2);
		s2.setTrackID(3);
		s2.setArtistName("Luke Bryan");
		s2.setTrackTitle("Play It Again");
		s2.setGenre("Country");
		System.out.println("s2: (after edit)");
		System.out.println(s2);
		System.out.println();
	
		// creates a playlist object and adds the 2 songs from above
		Playlist Country = new Playlist();
		Country.setplaylistName("Country");
		System.out.println("Before adding songs:\n" + Country);
		Country.addSong(s1);
		Country.addSong(s2);
		System.out.println("After adding songs:\n" + Country);	
		
		// removes song and displays updated playlist
		Country.removeSong("Beautiful Crazy");
		System.out.println("After removing songs:\n" + Country);	
		
		// testing the search song method (single input/single outputs)
		Country.searchSong("Play It Again");
		
		// testing multiple title seach (multiple input/multiple outputs)
		System.out.println("\nSearch for multiple songs from Country");
		Country.searchSongs("TestDummy1", "TestDummy3", "RandomTitleThatsNotInPlaylist");
		
		// testing song seach with extra inputs (multiple input/single outputs)
		System.out.println("\nSearch for a specific song from Country");
		Country.searchSpecificSong("Luke Bryan", "Country", "Play It Again");
		
		// testing genre seach (single input/multiple outputs)
		Song s4 = new Song(-1,"-1","Pop","TestDummy1","idk",0,0);
		Song s5 = new Song(-1,"-1","Pop","TestDummy2","idk",0,0);
		Song s6 = new Song(-1,"-1","Pop","TestDummy3","idk",0,0);
		Song s7 = new Song(-1,"-1","Pop","TestDummy4","idk",0,0);
		Country.addSong(s4);
		Country.addSong(s5);
		Country.addSong(s6);
		Country.addSong(s7);
		System.out.println("\n");
		System.out.println(Country);
		System.out.println("Search for 'Pop' Genre from Country");
		Country.searchGenre("Pop");
		
		// test creating playlist from textfile
		Playlist TextFile = new Playlist("TEXTFILE","./ProjPackage/finalTracks.csv");
		// line below prints the whole finalTracks.csv so I leave it commented out
		// System.out.println(TextFile);
		// TextFile.addSong(s1);
		
		// adds new song to TextFile and searches for it, returning it
		//Song s3 = new Song(1,"Riley Green","Country","Georgia Time","idk",0,0);
		//TextFile.addSong(s3);
		//TextFile.searchSong("Georgia Time");
		
		//System.out.println("\n idk ");
		//System.out.println(Country);		
		//Country.writeFile("./ProjPackage/Country.txt");
	}
}