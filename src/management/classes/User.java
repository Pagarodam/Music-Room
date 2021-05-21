package management.classes;

import java.util.Objects;

public class User {
    private String name;
    private String Instrument;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstrument() {
        return Instrument;
    }

    public void setInstrument(String instrument) {
        Instrument = instrument;
    }


    public User(String name, String instrument) {
        this.name = name;
        Instrument = instrument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && Instrument.equals(user.Instrument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Instrument);
    }

    @Override
    public String toString() {
        return  name + " ; " + Instrument + ", ";
    }
}
