package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Animations.Shake;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button authSigninButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    void initialize() {
      /*  assert login_field != null : "fx:id=\"login_field\" was not injected: check your FXML file 'sample.fxml'.";
        assert password_field != null : "fx:id=\"password_field\" was not injected: check your FXML file 'sample.fxml'.";
        assert authSinginButton != null : "fx:id=\"authSigninButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert loginSignUpButton != null : "fx:id=\"loginSignUpButton\" was not injected: check your FXML file 'sample.fxml'.";
    */
        loginSignUpButton.setOnAction(event -> {
            openNewScene ("/sample/signUp.fxml");
        });
        authSigninButton.setOnAction(event -> {
           String loginText = login_field.getText().trim();
           String loginPassword = password_field.getText().trim();
           if(!loginText.equals("")&&!loginPassword.equals("")){
               loginUser(loginText,loginPassword);
           }
           else
               System.out.println("Login or password is incorrect!");
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);
        int counter = 0;
        while(true){
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter++;
        }
        if(counter>=1)
        {
            openNewScene("/sample/app.fxml");
            System.out.println("Success!");
        }
        else{
            Shake userLoginAnim = new Shake(login_field);
            Shake userPassAnim = new Shake(password_field);
            userLoginAnim.plaiAnim();
            userPassAnim.plaiAnim();
        }
    }
    public void openNewScene (String window){
            loginSignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(window));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
    }
}
