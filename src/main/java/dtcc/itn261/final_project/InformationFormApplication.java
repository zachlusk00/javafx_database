/* =============================================================
Author : Zachary Lusk
Class : ITN261
Class Section : 201
Date : 04/12/2024
Assignment : final project
Notes : This program is for the final project module for programming II. This program utilizes a project from module11
this project connects to a database that I created called userdata. After a user enters all of the information in the form
application and clicks submit, the program will connect to the database, and enter the information from the form fields into the
users table in the database.

This program has data validation so that the phone number, and zip code fields must contain numbers, and that the state field
must only be 2 characters. All fields must be filled out properly for the data to be submitted to the database. If it is not filled
out then an error will occur.

This program also utilizes a progress bar to indicate how much of the data is complete when filling out the form, this is not
a project requirement, but was a fun challenge to do.

================================================================
Code Adapted From:
https://stackoverflow.com/questions/15727434/java-string-limit used this to validate the state field string to allow only
2 letter
https://www.geeksforgeeks.org/java-program-to-insert-details-in-a-table-using-jdbc/# used this for help on inserting data
into a table for a database
================================================================ */


package dtcc.itn261.final_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class InformationFormApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // initializes fxmlLoader
        FXMLLoader fxmlLoader = new FXMLLoader(InformationFormApplication.class.getResource("form-view.fxml"));
        // creates new scene
        Scene scene = new Scene(fxmlLoader.load(), 465, 440);
        // sets title
        stage.setTitle("Data Entry Form");
        // sets scene
        stage.setScene(scene);
        // shows scene
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}