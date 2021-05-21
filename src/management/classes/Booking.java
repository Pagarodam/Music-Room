package management.classes;
/**
 * Class to define the bookings of a music room
 * @param date A String whith a date of the book
 * @param gruop A String whith the name of the group whith his members and instruments
 */
public class Booking {
    private String date;
    private String group;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Booking(String date, String group) {
        this.date = date;
        this.group = group;
    }

    @Override
    public String toString() {
        return date + "¬"  + group;
    }
}
