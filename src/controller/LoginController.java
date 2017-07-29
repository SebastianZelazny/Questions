package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.BreakIterator;
import java.text.spi.BreakIteratorProvider;

import javax.swing.JOptionPane;

import database.DbConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	public static Integer questionNumber = 0;
	DbConnect db = new DbConnect();
	public static int ID_U = 0;
	private static String Name = null;
	private static String Surname = null;
	public static Boolean categoryJava = false;
	public static Boolean categoryDb = false;
	public static Boolean categoryPython = false;
	public static Boolean categoryFE = false;
	public static Boolean categorySpring = false;
	Boolean categoryControl = false;
	
    @FXML
    private TextField nameField;

    @FXML
    private TextField lastField;

    @FXML
    private TextField questNum;

    @FXML
    private Button loginBtn;

    @FXML
    private Button newUserBtn;

    @FXML
    private CheckBox cat1Box;

    @FXML
    private CheckBox cat2Box;

    @FXML
    private CheckBox cat3Box;

    @FXML
    private CheckBox cat4Box;

    @FXML
    private CheckBox cat5Box;

    public static String getName() {
		return Name;
	}

	public static void setName(String name) {
		Name = name;
	}

	public static String getSurname() {
		return Surname;
	}

	public static void setSurname(String surname) {
		Surname = surname;
	}

	@FXML
    void cat1Select(ActionEvent event) {

    }

    @FXML
    void cat2Select(ActionEvent event) {

    }

    @FXML
    void cat3Select(ActionEvent event) {

    }

    @FXML
    void cat4Select(ActionEvent event) {

    }

    @FXML
    void cat5Select(ActionEvent event) {

    }

    @FXML
    void createUser(ActionEvent event) {

    }

    @FXML
    void loginToDb(ActionEvent event) throws  SQLException, IOException {
    	//System.out.println("login check");
    	String logowanie = "";
    	Connection conn;
		try {
			conn = db.Connection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from user where name = '"+nameField.getText()+"' and surname = '"+lastField.getText()+"';");
			while (rs.next()) {
				ID_U = rs.getInt(1);
				logowanie = rs.getString("name");
				setName(logowanie);
				setSurname(rs.getString(3));
				//System.out.println(getName());
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	if (!logowanie.isEmpty()) {
    		//System.out.println("w ifie");
    		try
    		{
    		questionNumber = Integer.valueOf(questNum.getText());
    		}
    		catch (NumberFormatException e) {
    			
    			
			}
    		while (true) {
				if ((questionNumber > 0 & questionNumber < 99)) {
					//System.out.println("check1");
		    		//System.out.println("category control status "+categoryControl.toString());
					if (cat1Box.isSelected()) {
						categoryDb = true;
						//System.out.println(categoryDb);
					}
					if (cat2Box.isSelected()) {
						categoryPython = true;
					}
					if (cat3Box.isSelected()) {
						categoryFE = true;
					}
					if (cat4Box.isSelected()) {
						categoryJava = true;
					}
					if (cat5Box.isSelected()) {
						categorySpring = true;
					}
					categoryControl = categoryJava | categoryDb | categoryPython | categoryFE | categorySpring;
					//System.out.println("category control status "+categoryControl.toString());
		    		if (categoryControl == true) {
		    			//System.out.println("wybï¿½r");
		    			Stage stageTable = new Stage();
		    			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/view/QuestionsView.fxml"));
		    	        Scene sceneTable = new Scene(root);
		    	        stageTable.setScene(sceneTable);
		    	        stageTable.setTitle("Questions Page");
		    	        stageTable.show();
		    			break;
		    		} else {
		    			JOptionPane.showMessageDialog(null, "Wybierz przynajmniej jedna kategorie½");
		    			break;
		    		}
					
				} else {
					JOptionPane.showMessageDialog(null, "Podana liczba jest z poza zakresu lub podano litere");
					break;
				} 
			}
    		
    		
			
    		
    		
    	} else {
    		nameField.setText(null);
    		lastField.setText(null);
    		questNum.setText(null);
    		JOptionPane.showMessageDialog(null, "Zle dane logowania");
    	}
    	
    	
    }


}

