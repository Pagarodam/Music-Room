package management.classes;
/**
 * Class to define the bookings of a music room
 */
public class Booking {
    private String date;
    private String group;

    /**
     * Constructor whith parameters
     * @param date A String whith a date of the booking
     * @param group A String whith the name of the band and his components
     */
    public Booking(String date, String group) {
        this.date = date;
        this.group = group;
    }

    /**
     * Method to see the date, name of the group, users and instruments
     * @return An String with the date of the booking, name of the group and his components
     */
    @Override
    public String toString() {
        return date + "¬"  + group;
    }
}
