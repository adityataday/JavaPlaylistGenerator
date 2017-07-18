/**
 * Name: Aditya Mayur Taday
 * ID: 109550833
 * <p>
 * In this class a playlist is created using an array of different song record objects in it.
 * The Maximum number of songs in the playlist is set to 50 by default any numbers exceeding
 * or lower than 1 throw an exception. It carries out basic playlist functions such as
 * add, remove and play the music.
 */

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Playlist {

    static final int MAX_SONGS = 50;
    private int listSize;       // This is the variable that is used to maintain the size of the playlist
    SongRecord[] songs;

    /**
     * This is the constructor for this class
     */
    public Playlist() {
        songs = new SongRecord[MAX_SONGS];
        listSize = 0;
    }

    public int size() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    /**
     * This method add songs to playlist at a user provided position.
     *
     * @param song
     * @param position
     * @throws FullPlaylistExeception when the playlist is full, i.e. when it has 50 songs.
     */
    public void addSong(SongRecord song, int position) throws FullPlaylistExeception {
        if (size() == MAX_SONGS) {
            throw new FullPlaylistExeception("Playlist is full!");
        }
        if (position > 50 || position < 1) {
            throw new IllegalArgumentException("Invalid position!");
        }
        if (size() + 1 < position) {
            throw new IllegalArgumentException("Invalid position");
        } else {
            for (int i = listSize; i >= position; i--) {
                songs[i] = songs[i - 1];
            }
            songs[position - 1] = song;
        }

        listSize++;
    }

    /**
     * This is the method that removed the song from the playlist at a user provided position.
     *
     * @param position
     */
    public void removeSong(int position) {
        if (position > 50 || position < 1) {
            throw new IllegalArgumentException("Invalid position!");
        }
        if (position == size()) {
            songs[size() - 1] = null;
        } else {
            for (int i = position - 1; i <= listSize; i++) {
                songs[i] = songs[i + 1];
            }
        }
        listSize--;
    }

    /**
     * This is the method that provides a song details at a user specified position.
     *
     * @param position
     * @return The song details at the user specified position.
     */
    public SongRecord getSong(int position) {
        if (size() == 0) {
            throw new IllegalArgumentException("There are currently no songs in the playlist");
        }
        if (position > size() || position < 1) {
            throw new IllegalArgumentException("Invalid position!");
        }
        return songs[position - 1];
    }

    /**
     * In this method the user passes a playlist and it returns all songs by a particular artist.
     *
     * @param originalList
     * @param artist
     * @return a new playlist with a particular artist.
     */
    public static Playlist getSongsByArtist(Playlist originalList, String artist) {
        Playlist newPlaylist = new Playlist();
        int counter = 0;
        for (int i = 0; i < originalList.size(); i++) {
            if (originalList.songs[i].getArtist().equals(artist)) {
                newPlaylist.songs[counter] = originalList.songs[i];
                newPlaylist.listSize++;
                counter++;
            }
        }

        return newPlaylist;
    }

    /**
     * EXTRA CREDIT
     * This is the method where the playlist songs start to be played.
     * LIMITATIONS: It can only work with .mp3 file format. All songs in the playlist start to play at the same time
     * because there is no tread which hold the functioning of the method while one song is being played.
     */
    public void playSong() {
        if (size() == 0)
            throw new IllegalArgumentException("There are currently no songs in the playlist");
        String titleName;
        for (int i = 0; i < size(); i++) {
            titleName = songs[i].getTitle() + ".mp3";
            try {
                Media hit = new Media(new File(titleName).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(hit);
                mediaPlayer.play();
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }

    /**
     * This is the method where it prints all the songs.
     */

    public void printAllSongs() {
        System.out.printf("%-20s%-20s%-20s%12s\n", "Song#", "Title", "Artist", "Length");
        System.out.printf("----------------------------------------------------------------------------\n");
        for (int i = 0; i < listSize; i++) {
            System.out.printf("%3d\t\t\t\t%s\n", i + 1, songs[i].toString());
        }
    }

    /**
     * This is the method that clones a particular playlist.
     *
     * @return new playlist that is cloned.
     */
    public Object clone() {
        Playlist clone = new Playlist();
        clone.setListSize(listSize);
        for (int i = 0; i < size(); i++) {
            clone.songs[i] = (SongRecord) songs[i].clone();
        }
        return clone;
    }

    /**
     * This is the method that checks if a particular playlist matches another playlist.
     *
     * @param obj is a generic object which gets casted to Playlist object.
     * @return true of false after validating the statement.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Playlist) {
            for (int i = 0; i < size(); i++)
                if (((Playlist) obj).getSong(i).equals(songs[i]))
                    return false;
            return true;
        } else return false;
    }


}
