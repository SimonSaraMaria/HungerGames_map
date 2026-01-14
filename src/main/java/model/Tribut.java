package model;

public class Tribut {
    private int id;
    private String name;
    private int district;

    private Status status; //JSON field "ALIVE" OR "DEAD"

    private int skillLevel;

    public Tribut() {}

    public Tribut(int id, String name, int district, Status status, int skillLevel) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.status = status;
        this.skillLevel = skillLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getdistrict() {
        return district;
    }

    public void setdistrict(int district) {
        this.district = district;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }


    @Override
    public String toString() {
        return "Tribut{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", district=" + district +
                ", status='" + status + '\'' +
                ", skillLevel=" + skillLevel +
                '}';
    }
}
