package ProjPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

public class Playlist {
	private int size;
	private static final int DEFAULT_SIZE = 10;
	private Song[] songs;
	private String playlistName;
	private String fileName;
	
	// default constructor
	public Playlist() {
		size = 0;
		songs = new Song[DEFAULT_SIZE];
		playlistName = "a playlist";
		fileName = null;
	}
	
	// constructor with given playlist name and input file
	public Playlist(String pn, String fn) {
		this();
		playlistName = pn;
		fileName = fn;
		readFile();
	}
	
	// method that adds the input song to the playlist array
	public void addSong(Song s) {
		if (size >= songs.length)
			doubleArray();
		songs[size] = s;
		size++;
	}
	
	// method that removes a song from the playlist with the track title
	public void removeSong (String track_title) {
		for(int i = 0; i < size; i++) {
			if (songs[i].getTrackTitle().equals(track_title)) {
				songs[i] = songs[size-1];
				size--;
			}
		}
	}
	
	// method that accepts one input and returns a song
	public String searchSong (String track_title) {
		for(int i = 0; i < size; i++) {
			if (songs[i].getTrackTitle().equals(track_title)) {
				System.out.println(songs[i]);
			}
		}
		return "nothing found.";
	}
	
	// method that accepts one input and returns up to 4 songs
	public String searchGenre (String genre) {
		int count = 0;
		for(int i = 0; i < size; i++) {
			if (songs[i].getGenre().equals(genre)) {
				System.out.println(songs[i]);
				count++;
				if(count == 4)
					break;
			}
		}
		return "nothing found.";
	}
	
	// method that accepts multiple inputs and returns multiples songs
	public String searchSongs (String tt1, String tt2, String tt3) {
		for(int i = 0; i < size; i++) {
			if (songs[i].getTrackTitle().equals(tt1)) {
				System.out.println(songs[i]);
			}
			if (songs[i].getTrackTitle().equals(tt2)) {
				System.out.println(songs[i]);
			}
			if (songs[i].getTrackTitle().equals(tt3)) {
				System.out.println(songs[i]);
			}
		}
		return "nothing found.";
	}
	
	// method that accepts multiple inputs and returns a specific song
	public String searchSpecificSong (String an, String g, String tt) {
		for(int i = 0; i < size; i++) {
			if (songs[i].getArtistName().equals(an) && songs[i].getGenre().equals(g) && songs[i].getTrackTitle().equals(tt)) {
				System.out.println(songs[i]);
			}
		}
		return "nothing found.";
	}
	
	// private method used to double the size of the array when needed
	private void doubleArray () {
		Song[] newSongs = new Song[songs.length*2];
		for (int i = 0; i < size; i++) {
			newSongs[i] = songs[i];
		}		
		songs = newSongs;
	}
	
	// returns a string representation of this playlist
	public String toString() {
		String toReturn = playlistName+"\n";
		for (int i = 0; i < size; i++)
			toReturn += "Song: "+ songs[i].toString() +"\n";
		return toReturn;
	}
	
	// getters and setters
	public void setplaylistName(String pn) {
		playlistName = pn;
	}
	public String getplaylistName() {
		return playlistName;
	}

	// file reader
	private void readFile () {
		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);
			String line = null;
			while ((line = lineReader.readLine())!=null) {
				int track_id = lineReader.read();
				String artist_name = lineReader.readLine();
				String genre = lineReader.readLine();
				String track_title = lineReader.readLine();
				String album_title = lineReader.readLine();
				int year_created = lineReader.read();
				int artist_longitude = lineReader.read();
				addSong(new Song(track_id, artist_name, genre, track_title, album_title, year_created, artist_longitude));
			}
		} catch (Exception e) {
			System.err.println("there was a problem with the file reader, try different read type.");
			try {
				lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
				String line = null;
				while ((line = lineReader.readLine())!=null) {
					int track_id = lineReader.read();
					String artist_name = lineReader.readLine();
					String genre = lineReader.readLine();
					String track_title = lineReader.readLine();
					String album_title = lineReader.readLine();
					int year_created = lineReader.read();
					int artist_longitude = lineReader.read();
					addSong(new Song(track_id, artist_name, genre, track_title, album_title, year_created, artist_longitude));				}
			} catch (Exception e2) {
				System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
			} finally {
				if (lineReader != null)
					try {
						lineReader.close();
					} catch (IOException e2) {
						System.err.println("could not close BufferedReader");
					}
			}			
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
	}
	
	// overloaded method: this calls doWrite with file used to read data
	// use this for saving data between runs
	public void writeFile () {
		doWrite(fileName);
	}

	// overloaded method: this calls doWrite with different file name 
	// use this for testing write
	public void writeFile(String altFileName) {
		doWrite(altFileName);		
	}
	
	// this method writes all of the data in the playlist array to a file
	private void doWrite(String fn) {
		try
		{
			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);			
			
			for (int i = 0; i < size; i++) {
				Song song = songs[i];
				myOutfile.write ("song: ");
				//myOutfile.write (s.getName()+"\n");
				//myOutfile.write (person.getId()+"\n");
				//myOutfile.write (((Student) person).getGpa()+"\n");
			}
			myOutfile.flush();
			myOutfile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}
}

/*
private ArrayList<String> list =new ArrayList<String>(); 
private Iterator itr=list.iterator();
while(itr.hasNext()){
	System.out.println((String)itr.next());
}
System.out.println();

//Traversing list through Iterator with Generics
private Iterator<String> itr2=list.iterator();
while(itr.hasNext()){
	System.out.println(itr2.next());
}*/

