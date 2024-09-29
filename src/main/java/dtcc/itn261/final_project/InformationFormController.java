package dtcc.itn261.final_project;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;

public class InformationFormController {
    public Label title;
    public Label name_label;
    public Label email_field;
    public Label phone_label;
    public Label address_label;
    public Label city_label;
    public Label state_label;
    public Label zipcode_label;
    public Button submit_button;
    public TextField zip_input;
    public TextField state_input;
    public TextField city_input;
    public TextField address_input;
    public TextField phone_input;
    public TextField email_input;
    public TextField name_input;
    public ProgressBar progress_bar;
    public Label output_label;
    private int count;

    // method action event for submit button
    public void submitButton() {

        // sets the count based on how many text fields are filled out when submit button is hit
        setCount();
        // if the count is less than 7, then form is not complete
        if (count < 7) {
            output_label.setTextFill(Paint.valueOf("RED"));
            output_label.setText("Error: The form is not complete.");
        }

        // if name is not empty check next text field
        if (!name_input.getText().isEmpty()) {
            // if email is not empty check next text field
            if (!email_input.getText().isEmpty()) {
                // if phone number is not empty check next text field
                if (!phone_input.getText().isEmpty()) {
                    // try statement to check if phone number is a long and not string
                    try {
                        // attempted to parseLong the phone number text field
                        Long newPhone = Long.parseLong(phone_input.getText());
                        // if address is not empty check next field
                        if (!address_input.getText().isEmpty()) {
                            // if city is not empty check next field
                            if (!city_input.getText().isEmpty()) {
                                // if state is not empty check next field
                                if (!state_input.getText().isEmpty()) {

                                    // condition to check if state input is 2 letters
                                    // if it is greater than 2, throw an error, saying more than 2 letters
                                    if (state_input.getText().length() > 2) {
                                        throw new Exception("state error");
                                    }

                                    // if zip code is not empty check next field
                                    if (!zip_input.getText().isEmpty()) {

                                        // try method to try to see if zipcode is an integer and not a string
                                        try {
                                            // attempts to parseInt the zip_input text field
                                            int newZip = Integer.parseInt(zip_input.getText());

                                            // if zip code is larger than 5 digits, throw zip max value exception
                                            if (newZip > 99999) {
                                                throw new Exception("zip error max value");
                                            }



                                            InformationFormDatabase informationFormDatabase = new InformationFormDatabase();
                                            // calls the database method, passes all data fields from form, so database entry can be added
                                            informationFormDatabase.Database(name_input.getText(), email_input.getText(), newPhone, address_input.getText(), city_input.getText(), state_input.getText(), newZip);

                                            // clears fields for next submission
                                            name_input.clear();
                                            email_input.clear();
                                            phone_input.clear();
                                            address_input.clear();
                                            city_input.clear();
                                            state_input.clear();
                                            zip_input.clear();

                                            // successful submit message
                                            output_label.setTextFill(Paint.valueOf("BLACK"));
                                            output_label.setText("Thank you " + name_input.getText() + ", for registering.");

                                        }
                                        // catch for if zip code is not an integer
                                        catch (NumberFormatException e) {
                                            System.out.println("Zip Error: " + e.getMessage());
                                            output_label.setTextFill(Paint.valueOf("RED"));
                                            output_label.setText("Zip Error: " + e.getMessage());
                                        }
                                        // catch for if zip code is larger than 5 digits
                                        catch (Exception e) {
                                            System.out.println("Zip Error: Max Value Exceeded");
                                            System.out.println(e.getMessage());
                                            output_label.setTextFill(Paint.valueOf("RED"));
                                            output_label.setText("Zip Error: Max Value Exceeded");
                                        }
                                    }
                                }
                            }
                        }
                    // catch for if phone number is not an integer (long)
                    } catch (NumberFormatException e) {
                        System.out.println("Phone Error: " + e.getMessage());
                        output_label.setTextFill(Paint.valueOf("RED"));
                        output_label.setText("Phone Error: " + e.getMessage());

                    // catch for if state is greater than 2 letters
                    } catch (Exception e) {
                        output_label.setTextFill(Paint.valueOf("RED"));
                        output_label.setText("State Error: More than 2 characters.");
                        System.out.println("State Error: More than 2 characters.");
                    }
                }
            }
        }
    }

    // method sets count based on how many text fields are filled out
    public void setCount() {
        // count initializer
        count = 0;
        // if text field is not empty then add 1 to count
        if (!name_input.getText().isEmpty()) {
            count++;
        }
        if (!email_input.getText().isEmpty()) {
            count++;
        }
        if (!phone_input.getText().isEmpty()) {
            count++;
        }
        if (!address_input.getText().isEmpty()) {
            count++;
        }
        if (!city_input.getText().isEmpty()) {
            count++;
        }
        if (!state_input.getText().isEmpty()) {
            count++;
        }
        if (!zip_input.getText().isEmpty()) {
            count++;
        }
    }
    // method sets the progress bar based on count
    public void setProgress_bar() {
        if (count == 1) {
            progress_bar.setProgress(0.14);
        }
        else if (count == 2) {
            progress_bar.setProgress(0.28);
        }
        else if (count == 3) {
            progress_bar.setProgress(0.42);
        }
        else if (count == 4) {
            progress_bar.setProgress(0.56);
        }
        else if (count == 5) {
            progress_bar.setProgress(0.70);
        }
        else if (count == 6) {
            progress_bar.setProgress(0.84);
        }
        else if (count == 7) {
            progress_bar.setProgress(1);
        }
        else {
            progress_bar.setProgress(0);
        }
    }

    // methods for keystrokes detected in text fields
    // event method for name text field, calls count and progressbar methods
    public void name_entered(KeyEvent keyEvent) {
        setCount();
        setProgress_bar();
    }

    // event method for email text field, calls count and progressbar methods
    public void email_entered(KeyEvent keyEvent) {
        setCount();
        setProgress_bar();
    }

    // event method for phone number text field, calls count and progressbar methods
    public void phone_entered(KeyEvent keyEvent) {
        setCount();
        setProgress_bar();
    }

    // event method for street address text field, calls count and progressbar methods
    public void address_entered(KeyEvent keyEvent) {
        setCount();
        setProgress_bar();
    }

    // event method for city text field, calls count and progressbar methods
    public void city_entered(KeyEvent keyEvent) {
        setCount();
        setProgress_bar();
    }

    // event method for state text field, calls count and progressbar methods
    public void state_entered(KeyEvent keyEvent) {
        setCount();
        setProgress_bar();
    }

    // event method for zipcode text field, calls count and progressbar methods
    public void zip_entered(KeyEvent keyEvent) {
        setCount();
        setProgress_bar();
    }
}