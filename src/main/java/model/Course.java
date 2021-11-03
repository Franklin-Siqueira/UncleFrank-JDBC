package model;

public class Course {
    private int id;
    private String name;
    private int duration_hours;

    public Course(int id, String name, int duration_hours) {
        this.id = id;
        this.name = name;
        this.duration_hours = duration_hours;
    }

    public Course(String name, int duration_hours) {
        this.name = name;
        this.duration_hours = duration_hours;
    }

    public Course() { }

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

    public int getDurationHours() {
        return duration_hours;
    }

    public void setDurationHours(int age) {
        this.duration_hours = duration_hours;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("model.Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", duration_hours=").append(duration_hours);
        sb.append('}');
        return sb.toString();
    }
}
