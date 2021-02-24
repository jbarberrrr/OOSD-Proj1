package ProjPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


public class Playlist {
	private int size;
	private static final int DEFAULT_SIZE = 10;
	private Song[] songs;
	//private Student[] students;
	//private Instructor[] instructors;
	private String playlistName;
	private String fileName;
	
	public Playlist() {
		// default constructor
		size = 0;
		songs = new Song[DEFAULT_SIZE];
		playlistName = "a playlist";
		fileName = null;
	}
	public Playlist(String pn, String fn) {
		// constructor with given course name and input file
		this();
		playlistName = pn;
		fileName = fn;
		readFile();
	}	
	public void addSong(Song s) {
		// method that adds the input Student to the people array
		if (size >= songs.length)
			doubleArray();
		songs[size] = s;
		size++;
	}	
	public void addPersonFromKeyboard () {
		// method that prompts the user to enter either a student or instructor
		// then the user inputs the appropriate information for that person type
		// finally adds the new person to the array
		
		// complete for homework #2  
		
	}
	public void removePerson (String id) {
		// method that removes the Person from the array with the input id
		
		// complete for homework #2  
		
	}
	private void doubleArray () {
		// private method used to double the size of the array when needed
		Song[] newSongs = new Song[songs.length*2];
		for (int i = 0; i < size; i++) {
			newSongs[i] = songs[i];
		}		
		songs = newSongs;
	}
	
	public String toString() {
		// returns a string representation of this roster
		String toReturn = playlistName+"\n";
		for (int i = 0; i < size; i++)
			toReturn += "Song:  "+ songs[i] +"\n";
		return toReturn;
	}

	
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
	} // end of readFile method	
	
	/*
	public void writeFile () {
		// overloaded method: this calls doWrite with file used to read data
		// use this for saving data between runs
		doWrite(fileName);
	} // end of writeFile method

	public void writeFile(String altFileName) {
		// overloaded method: this calls doWrite with different file name 
		// use this for testing write
		doWrite(altFileName);		
	}// end of writeFile method
	
	
	private void doWrite(String fn) {
		// this method writes all of the data in the persons array to a file
		try
		{

			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);			
			
			for (int i = 0; i < size; i++) {
				Person person = people[i];
				if (person instanceof Student) {
					myOutfile.write ("student\n");
					myOutfile.write (person.getName()+"\n");
					myOutfile.write (person.getId()+"\n");
					myOutfile.write (((Student) person).getGpa()+"\n");
				}
				else if (person instanceof Instructor) {
					myOutfile.write ("instructor\n");
					myOutfile.write (person.getName()+"\n");
					myOutfile.write (person.getId()+"\n");
					myOutfile.write (((Instructor) person).getEmail()+"\n");
				}	
				else {
					System.err.println("error in array, instance type not found");
				}
			}
			myOutfile.flush();
			myOutfile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}	*/
}

