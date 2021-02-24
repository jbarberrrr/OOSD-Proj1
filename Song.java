package ProjPackage;

public class Song {
	
	private int track_id;
	private String artist_name;
	private String genre;
	private String track_title;
	private String album_title;
	private int year_created;
	private int artist_longitude;
	
	//track_id,artist_name,genre,track_title, album_title,year_created,artist_longitude
	
	// default constructor
	public Song() {
		track_id = -1;
		artist_name = "not set";
		genre = "not set";
		track_title = "not set";
		album_title = "not set";
		year_created = -1;
		artist_longitude = -1;
	}
	
	// constructor to create new song
	public Song(int ti, String an, String g, String tt, String at, int yc, int al) {
		track_id = ti;
		artist_name = an;
		genre = g;
		track_title = tt;
		album_title = at;
		year_created = yc;
		artist_longitude = al;
	}
	
	// getters and setters
	public int getTrackID() {
		return track_id;
	}
	public void setTrackID(int ti) {
		track_id = ti;
	}
	public String getArtistName() {
		return artist_name;
	}
	public void setArtistName(String an) {
		artist_name = an;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String g) {
		genre = g;
	}
	public String getTrackTitle() {
		return track_title;
	}
	public void setTrackTitle(String tt) {
		track_title = tt;
	}
	public String getAlbumTitle() {
		return album_title;
	}
	public void setAlbumTitle(String at) {
		album_title = at;
	}
	public int getYearCreated() {
		return year_created;
	}
	public void setYearCreated(int yc) {
		year_created = yc;
	}
	public int getArtistLongitude() {
		return artist_longitude;
	}
	public void setArtistLongitude(int al) {
		artist_longitude = al;
	}
	
	// string representation of this Student
	public String toString () {
		return track_id + " " + artist_name + " " + genre + " " + track_title + " " + album_title + " " + year_created + " " + artist_longitude;
	}
}