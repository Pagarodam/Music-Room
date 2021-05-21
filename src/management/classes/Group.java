package management.classes;
/**
 * Class to define the groups
 */
public class Group {
    private String name;
    private String users;

    /**
     * Constructor whith parameters
     * @param name A String whith a name of the Band
     * @param users A String whith the name of the user and his instruments
     */
    public Group(String name, String users) {
        this.name = name;
        this.users = users;
    }

    /**
     * Method to see the name of the group, users and instruments
     * @return An String with the name of the group and his components
     */
    @Override
    public String toString() {
        return name + "-->"  + users;
    }
}
