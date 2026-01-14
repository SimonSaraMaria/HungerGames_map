package model;

public class Ereignis {
    private int id;
    private int tributeId;

    private EventTyp type; //matches type in events.json

    private int points;
    private int day;

    public Ereignis() {}

    public Ereignis(int id, int tributeId, EventTyp type, int points, int day) {
        this.id = id;
        this.tributeId = tributeId;
        this.type = type;
        this.points = points;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTributeId() {
        return tributeId;
    }

    public void setTributeId(int tributeId) {
        this.tributeId = tributeId;
    }

    public EventTyp getType() {
        return type;
    }

    public void setType(EventTyp type) {
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
