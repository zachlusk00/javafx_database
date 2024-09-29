package dtcc.itn261.final_project;

import java.sql.*;

public class InformationFormDatabase {

    // database method, parameters are for data fields from form
    public void Database(String name, String email, Long phoneNumber, String address, String city, String State, int Zip) {

        // try to establish connection with database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata", "root", "Password01")) {
            // select statement to insert fields into the database users table
            String selectSQL = "INSERT INTO users (userName, userEmail, userPhoneNumber, addressStreet, addressCity, addressState, addressZip) VALUES\n" +
                    "(\"" + name + "\",\"" + email + "\",\"" + phoneNumber + "\",\"" + address + "\",\"" + city + "\",\"" + State + "\",\"" + Zip + "\");";

            // prepares the statement
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            // executes the statement
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
