package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            loginSignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Sample/signUp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
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

    }
}
