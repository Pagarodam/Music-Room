package management.classes;

import java.util.Arrays;
import java.util.List;

public class Group {
    private String name;
    private String users;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
            this.users = users;
    }

    public Group(String name, String users) {
        this.name = name;
        this.users = users;
    }

    @Override
    public String toString() {
        return name + "  -->  "  + users;
    }
}
