package org.example;
import model.*;
import org.example.HungerGamesRepository;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            HungerGamesRepository repo = new HungerGamesRepository();

            // Load all data
            List<Tribut> tributes = repo.readTributes("tributes.json");
            List<Ereignis> events = repo.readEvents("events.json");
            List<SponsorGeschenk> gifts = repo.readGifts("gifts.json");

            // Required Console Output
            System.out.println("Tributes loaded: " + tributes.size());
            System.out.println("Events loaded: " + events.size());
            System.out.println("Gifts loaded: " + gifts.size());

            // Print each Tribut in one line
            // Format: id name | D<district> | status | skill=<skillLevel>
            for (Tribut t : tributes) {
                System.out.println(t);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}