module dtcc.itn261.final_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens dtcc.itn261.final_project to javafx.fxml;
    exports dtcc.itn261.final_project;
}