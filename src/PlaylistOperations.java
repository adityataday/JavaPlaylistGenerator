/**
 * Name: Aditya Mayur Taday
 * ID: 109550833
 * <p>
 * This is the driver class of the program where a menu is presented to the user
 * and the user can carry out different functions for the playlist.
 */

import javafx.embed.swing.JFXPanel;

import java.util.Scanner;


public class PlaylistOperations {
    public static void main(String[] args) {
        JFXPanel fxPanel = new JFXPanel();
        Scanner userInput = new Scanner(System.in);
        String choice = new String();
        int position;

        SongRecord song;
        Playlist playlist = new Playlist();

        do {
            try {
                System.out.printf("Main Menu:\n\n");
                System.out.printf("A) Add Song\n");
                System.out.printf("G) Get Song\n");
                System.out.printf("R) Remove Song\n");
                System.out.printf("P) Print All Songs\n");
                System.out.printf("B) Print Songs By Artist\n");
                System.out.printf("S) Size\n");
                System.out.printf("L) Play Song\n");
                System.out.printf("Q) Quit\n\n");

                System.out.printf("Select an Operation: ");
                choice = userInput.nextLine();

                if (choice.equalsIgnoreCase("A")) {
                    song = new SongRecord();
                    System.out.printf("Enter Song Title: ");
                    song.setTitle(userInput.nextLine());

                    System.out.printf("Enter the song Artist: ");
                    song.setArtist(userInput.nextLine());

                    System.out.printf("Enter the song length (minutes): ");
                    song.setSongLengthMin(userInput.nextInt());

                    System.out.printf("Enter the song length (seconds): ");
                    song.setSongLengthSec(userInput.nextInt());

                    System.out.printf("Enter the position: ");
                    playlist.addSong(song, userInput.nextInt());

                    System.out.printf("Song Added: %s by %s\n", song.getTitle(), song.getArtist());

                    userInput.nextLine();

                } else if (choice.equalsIgnoreCase("S")) {
                    System.out.printf("There are %d song(s) in the current playlist.", playlist.size());

                } else if (choice.equalsIgnoreCase("G")) {
                    System.out.printf("Enter the position: ");
                    position = userInput.nextInt();
                    System.out.printf("Song#\tTitle\t\tArtist\t\tLength\n");
                    System.out.printf("----\t-----\t\t------\t\t------\n");
                    System.out.printf("%s\n", playlist.getSong(position).toString());
                    userInput.nextLine();

                } else if (choice.equalsIgnoreCase("R")) {
                    System.out.printf("Enter the position: ");
                    position = userInput.nextInt();
                    System.out.printf("Song Removed: %s by %s\n", playlist.getSong(position).getTitle(), playlist.getSong(position).getArtist());
                    playlist.removeSong(position);
                    userInput.nextLine();

                } else if (choice.equalsIgnoreCase("P")) {
                    playlist.printAllSongs();

                } else if (choice.equalsIgnoreCase("B")) {
                    String artistName;
                    System.out.printf("Enter the Artist name: ");
                    artistName = userInput.nextLine();
                    playlist.getSongsByArtist(playlist, artistName).printAllSongs();
                } else if (choice.equalsIgnoreCase("L")) {
                    playlist.playSong();
                }

                System.out.println();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                userInput.nextLine();
                System.out.println();
            }

        } while (!choice.equalsIgnoreCase("Q"));

        System.exit(0);
    }
}
