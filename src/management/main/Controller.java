package management.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import management.classes.Booking;
import management.classes.FileManager;
import management.classes.Group;
import management.classes.User;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Class to control and initialize all the parameters
 * @author patrickGalanRodriguez
 * @version 2.0
 */
public class Controller implements Initializable {
    @FXML
    private AnchorPane tbControlPanel;

    //----------------------------------- List View Users
    @FXML
    private ListView lvMusicians;
    @FXML
    private ComboBox<User> cbSelectMusician;
    @FXML
    private Button btAddMusician;

    //------------------------------------ List View Bands
    @FXML
    private ListView lvGroups;
    @FXML
    private TextField tfBandName;
    @FXML
    private Button btAddBand;

    //------------------------------------ List view Bookings
    @FXML
    private ListView lvBookings;
    @FXML
    private DatePicker calendar;

    //------------------------------------ Other Buttons
    @FXML
    private Button btDelete;

    //----------------------------------- Observable Lists
    @FXML
    private ObservableList<User> users;

    @FXML
    private ObservableList<Group> groups;

    @FXML
    private ObservableList<Booking> bookings;

    FileManager f;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //------------------------------------------------------------Combo box musicians
        User patrick = new User("Patrick", "Guitar");
        User grillo = new User("Grillo", "Bass");
        User rafa = new User("Rafa", "Singer");
        User alberto = new User("Alberto", "Singer");
        User ivan = new User("Ivan", "Drums");
        User fonsy = new User("Fonsy", "Guitar");
        User copete = new User("Copete", "Drums");
        User carlos = new User("Carlos", "Bass");
        User adolfo = new User("Adolfo", "Guitar");
        User jose = new User("Jose", "Guitar");

        cbSelectMusician.getItems().addAll(patrick, grillo, rafa, alberto,
                ivan, fonsy, copete, carlos, adolfo, jose);

        //------------------------------------------------------------- Observable´s List

        f = new FileManager();
        f.saveFile(f.readFile());
        f.saveBookings(f.readBookings());
        users = FXCollections.observableArrayList();
        groups = FXCollections.observableArrayList(f.readFile());
        lvGroups.setItems(groups);
        bookings = FXCollections.observableArrayList(f.readBookings());
        lvBookings.setItems(bookings);
    }

    //------------------------------------------- Select from comboBox
    @FXML
    private void select(MouseEvent mouseEvent) {
        Group g = (Group) this.lvGroups.getSelectionModel().getSelectedItem();

        if(g != null){
            this.tfBandName.getText();
            this.cbSelectMusician.getSelectionModel().getSelectedItem();
        }
    }

    //--------------------------------------------- Add methods
    public void btAddMusician(ActionEvent actionEvent) {
        String name = this.cbSelectMusician.getSelectionModel().getSelectedItem().getName();
        String instrument = this.cbSelectMusician.getSelectionModel().getSelectedItem().getInstrument();

        User u = new User(name,instrument);

        if(!this.users.contains(u)){
            this.users.add(u);
            lvMusicians.setItems(users);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Already exists");
            alert.showAndWait();
        }
    }

    public void addBand(ActionEvent actionEvent) {
        String bandName = tfBandName.getText();
        String members = "";

        for (int i = 0; i < users.size(); i++) {
            members += String.valueOf(users.toArray()[i]) + " ";
        }

        Group g = new Group(bandName,members);

        if(!this.groups.contains(g)){
            this.groups.add(g);
            lvGroups.setItems(groups);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Already exists");
            alert.showAndWait();
        }
        users.clear();
        f.saveFile(groups);
    }

    public void addBooking(ActionEvent actionEvent) {
        LocalDate date = calendar.getValue();
        String selectedGroup = lvGroups.getSelectionModel().getSelectedItem().toString();

        Booking b = new Booking(date.toString(), selectedGroup);

        if(!this.bookings.contains(b)){
            this.bookings.add(b);
            lvBookings.setItems(bookings);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Already exists");
            alert.showAndWait();
        }
        f.saveBookings(bookings);
    }
    //-------------------------------------------------- Delete methods
    public void deleteBooking(ActionEvent actionEvent) {
        int position = lvBookings.getSelectionModel().getSelectedIndex();
        bookings.remove(position);
        f.saveBookings(bookings);
    }

    public void deleteBand(ActionEvent actionEvent) {
        int position = lvGroups.getSelectionModel().getSelectedIndex();
        groups.remove(position);
        f.saveFile(groups);
    }
}
