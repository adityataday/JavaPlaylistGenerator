/**
 * Name: Aditya Mayur Taday
 * ID: 109550833
 * <p>
 * In this class the parameters of the song records are being used to create the object.
 * Each song record has 4 parameters.
 */

public class SongRecord {

    private String title;
    private String artist;
    private int songLengthMin;
    private int songLengthSec;

    /**
     * This is the default constructor
     */
    public SongRecord() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongLengthMin() {
        return songLengthMin;
    }

    public void setSongLengthMin(int songLengthMin) {
        if (songLengthMin < 0)
            throw new IllegalArgumentException("Invalid input: The number cannot be less than 0 or negative");
        this.songLengthMin = songLengthMin;
    }

    public int getSongLengthSec() {
        return songLengthSec;
    }

    public void setSongLengthSec(int songLengthSec) {
        if (songLengthSec < 0 || songLengthSec > 59)
            throw new IllegalArgumentException("Invalid input: The number cannot be less than 0 or more than 59");
        this.songLengthSec = songLengthSec;
    }

    /**
     * This is the method that checks if a particular song record match another song record
     *
     * @param song is a song record type object that is being passed in the method for validation.
     * @return true of false after validating the statement
     */
    public boolean equals(SongRecord song) {
        return (song.getTitle().equals(this.title) &&
                song.getArtist().equals(this.artist)
                && song.getSongLengthMin() == this.songLengthMin &&
                song.getSongLengthSec() == this.songLengthSec);
    }

    /**
     * This is the method that clones a particular song record.
     *
     * @return new song record that is cloned.
     */
    public Object clone() {
        SongRecord clone = new SongRecord();
        try {
            clone = (SongRecord) super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return clone;
    }

    /**
     * This is the toString() Method that prints details of a particular song record
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("%-25s%-25s%5d:%02d", title, artist, songLengthMin, songLengthSec);
    }
}
