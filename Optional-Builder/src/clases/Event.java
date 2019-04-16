package clases;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Event {

    private int id;
    private String name;
    private Location location;

    public Event(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + Optional.ofNullable(this.location).orElse(new Location(-1,"",new City(-1,""))) +
                '}'; // ??? preguntar esto
    }
}
