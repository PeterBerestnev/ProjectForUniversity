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
        signUpButton.setOnAction(event ->{
            signUpNewUser();

        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String firstName =signUpName.getText();
        String lastName =signUpLastName.getText();
        String userName = signUpLogin.getText();
        String password = signUpPassword.getText();
        String gender = "";
        if(signUpCheckBoxMale.isSelected())
            gender="Male";
        else
            gender="Female";
        User user = new User(firstName,lastName,userName,password,gender );
        dbHandler.signUpUser(user);
    }

}

