package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import model.Contact;
import model.ContactManager;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuControllerGUI {
	
	@FXML
    private TableView<Contact> tvContactList;

    @FXML
    private TableColumn<Contact, String> tcID;

    @FXML
    private TableColumn<Contact, String> tcNAME;

    @FXML
    private TableColumn<Contact, String> tcEMAIL;
    
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private Pane mainPane;
    
    private ObservableList<Contact> list;
    
    private ContactManager contactManager;
    
    private int ID;

    
    public MenuControllerGUI() {
		contactManager = new ContactManager();
		ID = 2;
	}

	@FXML
    public void showForm1(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Formulary-1.fxml"));
    	fxmlloader.setController(this);
    	Parent form1 = fxmlloader.load();
    	mainPane.getChildren().setAll(form1);
    }

    @FXML
    public void showForm2(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("ContactManagerTable.fxml"));
    	fxmlloader.setController(this);
    	Parent form2 = fxmlloader.load();
    	mainPane.getChildren().setAll(form2);
    	
    	initializeTableView();
    }
    
    @FXML
    public void addContact(ActionEvent event) {

    	String name = txtName.getText(); 
    	String email = txtEmail.getText();
    	String id = "0";
    	id+=ID;
    	
    	Contact newContact = new Contact(id, name, email);
    	
    	if(contactManager.addNewContact(newContact) == true) {
    		
    		JOptionPane.showMessageDialog(null, "Se ha añadido correctamente el contacto");
    		
    	} else {
    		JOptionPane.showMessageDialog(null, "No se ha podido añadir el contacto");
    	}
    	
    	ID++;
    	
    }
    
    private void initializeTableView() {
    	list = FXCollections.observableArrayList(contactManager.getContactList());
    	
    	tvContactList.setItems(list);
    	tcID.setCellValueFactory(new PropertyValueFactory<Contact,String>("id"));
    	tcNAME.setCellValueFactory(new PropertyValueFactory<Contact,String>("name"));
    	tcEMAIL.setCellValueFactory(new PropertyValueFactory<Contact,String>("enail"));
    }
    
    
}

