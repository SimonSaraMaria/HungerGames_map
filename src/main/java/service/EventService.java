package service;
import model.Ereignis;

public class EventService {
    public int calculateComputedPoints(Ereignis e) {
        int points = e.getPoints();
        int day = e.getDay();

        return switch (e.getType()) {
            case "FOUND_SUPPLIES" -> points + (2 * day);
            case "INJURED" -> points - day;
            case "ATTACK" -> (points * 2) + day;
            case "HELPED_ALLY" -> points + 5;
            case "SPONSORED" -> points + 10;
            default -> points;
        };
    }
}
