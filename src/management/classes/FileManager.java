package management.classes;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to manage the files to save and load
 */
public class FileManager {
    /**
     * Method to load groups
     * @return A list with all groups from a file
     */
    public List<Group> readFile(){
        try{
            return Files.lines(Paths.get("groups.txt"))
                    .map(line -> new Group(line.split("-->")[0], line.split("-->")[1]))
                    .collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    /**
     * Method to save groups
     * @param groups A list with all groups to save
     */
    public void saveFile(List<Group> groups){
        try(PrintWriter pw = new PrintWriter("groups.txt")){
            groups.stream().forEach(f-> pw.println(f.toString()));
        } catch (Exception e) { }
    }

    /**
     * Method to load bookings
     * @return A list with all bookings from a file
     */
    public List<Booking> readBookings(){
        try{
            return Files.lines(Paths.get("bookings.txt"))
                    .map(line -> new Booking(line.split("¬")[0], line.split("¬")[1]))
                    .collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }
    /**
     * Method to save bookings
     * @param bookings A list with all bookings to save
     */
    public void saveBookings(List<Booking> bookings){
        try(PrintWriter pw = new PrintWriter("bookings.txt")){
            bookings.stream().forEach(f-> pw.println(f.toString()));
        } catch (Exception e) { }
    }
}
