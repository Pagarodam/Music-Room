package management.classes;
import java.util.Objects;
/**
 * Class to define the users
 */
public class User {
    private String name;
    private String instrument;

    /**
    * Returns the user's name
    * @return User's name
    */
    public String getName() {
        return name;
    }

    /**
     * Returns the instruments type
     * @return instruments type
     */
    public String getInstrument() {
        return instrument;
    }

    /**
    * Constructor whith parameters
    * @param name A String whith a name of the users
    * @param instrument A String whith the name of the type of instrument of and user
    */
    public User(String name, String instrument) {
        this.name = name;
        this.instrument = instrument;
    }

    /**
     * Method to compare objects
     * @return An boolean that indicates if are equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && instrument.equals(user.instrument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, instrument);
    }

    /**
     * Method to see the name and instrument of the user
     * @return An String with the name and instrument
     */
    @Override
    public String toString() {
        return  name + " ; " + instrument + ", ";
    }
}
