package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {

		//System.out.println("klik");
		Parent parent = (Parent)FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
		//System.out.println("klik3");
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Login page");
        stage.show();
	}
	public static void main(String[] args) throws Exception {
		//System.out.println("klik2");
	    launch(args);
	}
}
