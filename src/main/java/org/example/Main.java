package org.example;

import model.Tribut;
import model.Ereignis;
import model.SponsorGeschenk;
import org.example.HungerGamesRepository;
import service.TributeService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            HungerGamesRepository repo = new HungerGamesRepository();
            TributeService tributeService = new TributeService();
            Scanner scanner = new Scanner(System.in);

            // Task 1: Load data from JSON files
            List<Tribut> tributes = repo.readTributes("tributes.json");
            List<Ereignis> events = repo.readEvents("events.json");
            List<SponsorGeschenk> gifts = repo.readGifts("gifts.json");

            boolean running = true;
            while (running) {
                System.out.println("\n--- Hunger Games Menu ---");
                System.out.println("1. Task 1: Show Counts and All Tributes");
                System.out.println("2. Task 2: Filter by District and Status");
                System.out.println("3. Task 3: Sort tributes by skill level");
                System.out.println("4. Task 4: Saving sorted tributes to file");
                System.out.println("0. Exit");
                System.out.print("Choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Tributes loaded: " + tributes.size());
                        System.out.println("Events loaded: " + events.size());
                        System.out.println("Gifts loaded: " + gifts.size());
                        for (Tribut t : tributes) {
                            System.out.println(t); // Uses Tribut.toString() format [cite: 46]
                        }
                    }
                    case 2 -> {
                        System.out.print("Input district: ");
                        int districtInput = scanner.nextInt();

                        List<Tribut> filtered = tributeService.filterAliveByDistrict(tributes, districtInput);

                        for (Tribut t : filtered) {
                            System.out.println(t);
                        }
                    }

                    case 3 -> {
                        System.out.print("Sorted tributes: ");
                        List<Tribut> sorted = tributeService.getSortedTributes(tributes);

                        for (Tribut t : sorted) {
                            System.out.println(t);
                        }
                    }

                    case 4 -> {
                        System.out.print("Saving sorted tributes: ");
                        try{
                            List<Tribut> sorted = tributeService.getSortedTributes(tributes);
                            tributeService.saveTributesToFile(sorted, "tributes_sorted.txt");
                            System.out.println("Successfully saved sorted tributes!");
                        } catch (IOException e) {
                            System.err.println(e);
                        }
                    }

                    case 0 -> {
                        running = false;
                        System.out.println("Exiting...");
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}