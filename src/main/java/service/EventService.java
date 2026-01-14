package service;
import model.*;
import java.util.*;
import java.util.stream.Collectors;
import java.io.PrintWriter;
import java.util.Map;
import java.util.LinkedHashMap;

public class EventService {

    public int calculateComputedPoints(Ereignis e) {
        int points = e.getPoints();
        int day = e.getDay();

        // The switch now uses the EventTyp enum directly
        return switch (e.getType()) {
            case FOUND_SUPPLIES -> points + (2 * day);
            case INJURED -> points - day;
            case ATTACK -> (points * 2) + day;
            case HELPED_ALLY -> points + 5;
            case SPONSORED -> points + 10;
        };
    }

    public List<Map.Entry<Tribut, Integer>> calculateTopTributes(List<Tribut> tributes, List<Ereignis> events, List<SponsorGeschenk> gifts) {
        Map<Integer, Integer> scores = new HashMap<>();

        for (Tribut t : tributes) {
            scores.put(t.getId(), 0);
        }

        for (Ereignis e : events) {
            int currentScore = scores.getOrDefault(e.getTributeId(), 0);
            scores.put(e.getTributeId(), currentScore + calculateComputedPoints(e));
        }

        for (SponsorGeschenk g : gifts) {
            int currentScore = scores.getOrDefault(g.gettributeId(), 0);
            scores.put(g.gettributeId(), currentScore + g.getValue());
        }

        List<Map.Entry<Tribut, Integer>> ranking = new ArrayList<>();
        for (Tribut t : tributes) {
            ranking.add(new AbstractMap.SimpleEntry<>(t, scores.get(t.getId())));
        }

        ranking.sort((a, b) -> {
            int scoreCompare = b.getValue().compareTo(a.getValue());
            if (scoreCompare == 0) {
                return a.getKey().getName().compareTo(b.getKey().getName());
            }
            return scoreCompare;
        });

        return ranking.stream().limit(5).collect(Collectors.toList());
    }

    public void generateArenaReport(List<Ereignis> events, String fileName) throws Exception {
        // Updated Map to use EventTyp as the Key instead of String
        Map<EventTyp, Integer> counts = new LinkedHashMap<>();

        // Initialize with Enum values
        for (EventTyp type : EventTyp.values()) {
            counts.put(type, 0);
        }

        for (Ereignis e : events) {
            EventTyp type = e.getType();
            counts.put(type, counts.get(type) + 1);
        }

        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Map.Entry<EventTyp, Integer> entry : counts.entrySet()) {
                writer.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
}
