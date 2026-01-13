package model;

public class SponsorGeschenk {
    private int id;
    private int tributeId;
    private String itemName;
    private int value;
    private int day;

    public SponsorGeschenk() {}

    public SponsorGeschenk(int id, int tributeId, String itemName, int value, int day) {
        this.id = id;
        this.tributeId = tributeId;
        this.itemName = itemName;
        this.value = value;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int gettributeId() {
        return tributeId;
    }

    public void settributeId(int tributeId) {
        this.tributeId = tributeId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
