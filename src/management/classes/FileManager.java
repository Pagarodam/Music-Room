package management.classes;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;


public class FileManager {

    public List<Group> readFile(){
        try{
            return Files.lines(Paths.get("groups.txt"))
                    .map(line -> new Group(line.split("-->")[0], line.split("-->")[1]))
                    .collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    public void saveFile(List<Group> groups){
        try(PrintWriter pw = new PrintWriter("groups.txt")){
            groups.stream().forEach(f-> pw.println(f.toString()));
        } catch (Exception e) { }
    }

    //------------------------------------------ Load and save Bookings
    public List<Booking> readBookings(){
        try{
            return Files.lines(Paths.get("bookings.txt"))
                    .map(line -> new Booking(line.split("¬")[0], line.split("¬")[1]))
                    .collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    public void saveBookings(List<Booking> bookings){
        try(PrintWriter pw = new PrintWriter("bookings.txt")){
            bookings.stream().forEach(f-> pw.println(f.toString()));
        } catch (Exception e) { }
    }
}
