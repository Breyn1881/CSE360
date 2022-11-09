import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class login extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage LogInStage) throws Exception {
		Group rootLog = new Group();
		Scene logScene = new Scene(rootLog);
		
		Image asuLogo = new Image("asulogo.png");
		
		GridPane gridPaneLogIn = new GridPane();
		gridPaneLogIn.setStyle("-fx-background-color: WHITE;");
		gridPaneLogIn.setPrefWidth(600);
		gridPaneLogIn.setPrefHeight(300);
		gridPaneLogIn.getColumnConstraints().add(new ColumnConstraints(50));
		gridPaneLogIn.getRowConstraints().add(new RowConstraints(50));
		
		Text asuId = new Text();
		Text warningId = new Text();
		asuId.setText("ASURITE ID: ");
		asuId.setFont(Font.font("Impact", 20));
		warningId.setText("Please Enter Your ASURITE ID");
		warningId.setFont(Font.font("Impact", 20));

		
		TextField logInIdText = new TextField();
		
		
		Button logInButton = new Button("Log In");
		
		logInButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				String text = "";
				boolean numbersOnly;
				if (logInIdText.getText().isEmpty() == false) {
					text = logInIdText.getText();
					numbersOnly = text.chars().allMatch(Character::isDigit);
					if (numbersOnly == true)
					{
						if (text.length() < 10) {
							warningId.setText("             Not Enough Digits            ");
						}
						if (text.length() > 10) {
							warningId.setText("             Too Many Digits              ");
						}
						if (text.length() == 9) {
							warningId.setText("             Logging In ...              ");
						}
					}
					else if (numbersOnly == false) {
						warningId.setText("       Please Enter Only Digits    ");
					}
				}
				else
				{
					warningId.setText("Please Enter Your ASURITE ID");
				}
				
				
			}
		});
		
		gridPaneLogIn.add(asuId, 1, 1);
		gridPaneLogIn.add(warningId, 2, 0);
		gridPaneLogIn.add(logInIdText, 2, 1);
		gridPaneLogIn.add(logInButton, 3, 1);
		
		rootLog.getChildren().addAll(gridPaneLogIn);
		LogInStage.getIcons().add(asuLogo);
		LogInStage.setResizable(false);
		LogInStage.setFullScreen(false);
		LogInStage.setWidth(500);
		LogInStage.setHeight(200);
		LogInStage.setY(400);
		LogInStage.setX(650);
		
		LogInStage.setTitle("Log In");
		
		LogInStage.setScene(logScene);
		LogInStage.show();
	}
	
}
