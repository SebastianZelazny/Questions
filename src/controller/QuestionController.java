package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import database.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.QuestionModel;

public class QuestionController {
	private int licznik;
	
	Random generator;
	
	public int getLicznik() {
		return licznik;
	}

	public void setLicznik(int licznik) {
		this.licznik = licznik;
	}
	private DbConnect dbcon;
	
	private String trueask;
	private int number_true;
	private int number_false;
	
	LoginController lc = new LoginController();
    @FXML
    private Label LblTitle;

    @FXML
    private Label LblLicznik;

    @FXML
    private Label LblQuestion;
    @FXML
    private Label LblFirstInfo;
    @FXML
    private Button BtnNext;
    @FXML
    private ToggleGroup TGQuestion;
    @FXML
    private RadioButton RBQuest2;

    @FXML
    private RadioButton RBQuest3;

    @FXML
    private RadioButton RBQuest1;

    @FXML
    private RadioButton RBQuest4;
    @FXML
    private Button BtnScoo;
    @FXML
    private Button BtnStart;
    @FXML
    private GridPane GPScoore;

    @FXML
    private Label LblNameSurname;

    @FXML
    private Label LblTrueQuest;
    @FXML
    private Button BtnClose;
    @FXML
    private Label LbFalseQuest;

    @FXML
    private Label LblWynik;

    @FXML
    private Label LblWynikStat;

    public void initialize()
    {
    	dbcon = new DbConnect();
    	LblQuestion.setVisible(false);
    	
    	GPScoore.setVisible(false);
    	RBQuest1.setVisible(false);
    	RBQuest2.setVisible(false);
    	RBQuest3.setVisible(false);
    	RBQuest4.setVisible(false);
    	BtnClose.setVisible(false);
    	BtnNext.setVisible(false);
    	BtnScoo.setVisible(false);
    	LblLicznik.setVisible(false);
    	LblFirstInfo.setVisible(false);
    	
    	
    }
    
    String db="pustedb",java="pustejava",python="pustepython",Frontend="pusteFrontend",Spring="pusteSpring";
    int id_p=1;
    ObservableList<QuestionModel> pytania;
    
    @FXML
    void Start(MouseEvent event) {
    	
    	pytania = FXCollections.observableArrayList();
    	BtnStart.setVisible(false);
    	Connection con;
    	ResultSet rs;
    	
    	
		
		
    	if(lc.categoryDb==true)
    	{
    		db = "b";
    	}
    	if(lc.categoryFE==true)
    	{
    		Frontend = "FE";
    	}
    	if(lc.categoryJava==true)
    	{
    		java = "J";
    	}
    	if(lc.categoryPython==true)
    	{
    		python= "P";
    	}
    	if(lc.categorySpring==true)
    	{
    		Spring="S";
    	}
		try {		
			//System.out.println(db);
			//System.out.println(python);
			//System.out.println(Frontend);
			//System.out.println(java);
			//System.out.println(Spring);
			
			//generator = new Random();
			//id_p = generator.nextInt(99);
			//System.out.println(id_p);
			String GetQuest = "Select * from questions where (Kat = '"+db+"' or Kat = '"+Frontend+"' or Kat = '"+java+"' or Kat = '"+db+"' or Kat = '"+python+"' or Kat = '"+Spring+"') order by rand() limit 1;";
			con = dbcon.Connection();
			rs = con.createStatement().executeQuery(GetQuest);
			String sprawdzenie = null;
			
			while(rs.next())
			{
				sprawdzenie = rs.getString(1);
				System.out.println(sprawdzenie);
				if(sprawdzenie!=null)
				{
					LblQuestion.setVisible(true);
			    	
			    	RBQuest1.setVisible(true);
			    	RBQuest2.setVisible(true);
			    	RBQuest3.setVisible(true);
			    	RBQuest4.setVisible(true);
			    	
			    	BtnNext.setVisible(true);
			    	
			    	LblLicznik.setVisible(true);
			    	
					System.out.println("Numer pytania: "+rs.getString(1));
					LblQuestion.setText(rs.getString(2));
					RBQuest1.setText(rs.getString(3));
					RBQuest2.setText(rs.getString(4));
					RBQuest3.setText(rs.getString(5));
					RBQuest4.setText(rs.getString(6));
					trueask = rs.getString(7);
					
					licznik++;
					LblLicznik.setText("Liczba pytañ "+licznik+"/"+lc.questionNumber);
				}
			}
			
			if(sprawdzenie==null)
			{
				BtnClose.setVisible(true);
				BtnClose.setLayoutX(250);
				LblTitle.setText("Brak pytan z tego zakresu");
				
			}
			
			RBQuest1.setSelected(true);
			if(licznik>=lc.questionNumber)
			{
				BtnNext.setDisable(true);
				BtnScoo.setVisible(true);
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @FXML
    void NextQuest(MouseEvent event) {
    	check();
    	//PreparedStatement preparedStmt = null;
    	Connection con;
    	
		try {
			ResultSet rs = null;
			String GetQuest = "Select * from questions where (Kat = '"+db+"' or Kat = '"+Frontend+"' or Kat = '"+java+"' or Kat = '"+db+"' or Kat = '"+python+"' or Kat = '"+Spring+"') order by rand() limit 1;";
			con = dbcon.Connection();
			rs = con.createStatement().executeQuery(GetQuest);
			while(rs.next())
			{
				System.out.println("Numer pytania: "+rs.getString(1));
				LblQuestion.setText(rs.getString(2));
				RBQuest1.setText(rs.getString(3));
				RBQuest2.setText(rs.getString(4));
				RBQuest3.setText(rs.getString(5));
				RBQuest4.setText(rs.getString(6));
				trueask = rs.getString(7);
				licznik++;
			}
			if(licznik>=lc.questionNumber)
			{
				BtnNext.setDisable(true);
				BtnScoo.setVisible(true);
				
			}
			RBQuest1.setSelected(true);
			
			LblLicznik.setText("Liczba pytañ "+licznik+"/"+lc.questionNumber);	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(licznik);
    }
    
    @FXML
    void Scoore(MouseEvent event) throws ClassNotFoundException, SQLException {
    	check();
    	double wynik = 0;
    	wynik = (number_true*100)/(number_true+number_false);
    	double wynik_stat = 0;
    	
    	Connection con = dbcon.Connection();
    	PreparedStatement preparedStmt=null;
    	String InsertScoore= "Insert into scoore (ID_Us,wynik) values (?,?)";
    	preparedStmt = con.prepareStatement(InsertScoore);
    	preparedStmt.setInt(1, lc.ID_U);
    	preparedStmt.setString(2,String.valueOf(wynik));
    	preparedStmt.execute();
   
    	
    	ResultSet rs = null;
    	String GetAllScoore = "Select wynik from scoore where ID_Us = "+lc.ID_U;
    	rs = con.createStatement().executeQuery(GetAllScoore);
    	int i=1;
    	while(rs.next())
    	{
    		String wynik_tmp = rs.getString(1);
    		wynik_stat+=Double.valueOf(wynik_tmp);
    		i++;
    	}
    	wynik_stat= wynik_stat/i;
    	
    	
     	GPScoore.setVisible(true);
    	RBQuest1.setVisible(false);
    	RBQuest2.setVisible(false);
    	RBQuest3.setVisible(false);
    	RBQuest4.setVisible(false);
    	BtnNext.setVisible(false);
    	LblQuestion.setVisible(false);
    	LblLicznik.setVisible(false);
    	
    	LblNameSurname.setText(lc.getName()+" "+lc.getSurname());
    	LblTrueQuest.setText(String.valueOf(number_true));
    	LbFalseQuest.setText(String.valueOf(number_false));
    	LblWynik.setText(String.valueOf(wynik)+"%");
    	LblWynikStat.setText(String.valueOf(Math.round(wynik_stat))+"%");
    	
    	BtnScoo.setDisable(true);
    	BtnClose.setVisible(true);
    }
    @FXML
    void Close(MouseEvent event) {
    	System.exit(1);
    }
    
    public void check()
    {
    	if(RBQuest1.isSelected())
    	{
    		if(RBQuest1.getText().equals(trueask))
    		{
    			
    			number_true++;
    			System.out.println("Liczba prawid³owych: "+number_true);
    		}
    		else
    		{
    			number_false++;
    			System.out.println("Liczba nieprawid³owych: "+number_false);
    		}
    	}
    	else if(RBQuest2.isSelected())
    	{
    		if(RBQuest2.getText().equals(trueask))
    		{
    			
    			number_true++;
    			System.out.println("Liczba prawid³owych: "+number_true);
    		}
    		else
    		{
    			number_false++;
    			System.out.println("Liczba nieprawid³owych: "+number_false);
    		}
    	}
    	else if(RBQuest3.isSelected())
    	{
    		if(RBQuest3.getText().equals(trueask))
    		{
    			
    			number_true++;
    			System.out.println("Liczba prawid³owych: "+number_true);
    		}
    		else
    		{
    			number_false++;
    			System.out.println("Liczba nieprawid³owych: "+number_false);
    		}
    	}
    	else if(RBQuest4.isSelected())
    	{
    		if(RBQuest4.getText().equals(trueask))
    		{
    			
    			number_true++;
    			System.out.println("Liczba prawid³owych: "+number_true);
    		}
    		else
    		{
    			number_false++;
    			System.out.println("Liczba nieprawid³owych: "+number_false);
    		}
    	}
    }
    
    
   

   
}
