package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpName;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpLogin;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    private Button BackButton1;

    @FXML
    void initialize(){
        DatabaseHandler dbHandler = new DatabaseHandler();
        signUpButton.setOnAction(event ->{
            dbHandler.signUpUser(signUpName.getText(),signUpLastName.getText(),signUpLogin.getText(),signUpPassword.getText(),"Male");
        });
    }

}

