module com.brh.aufbauprojekt.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires jbcrypt;


    opens com.brh.aufbauprojekt.demo2 to javafx.fxml;
    exports com.brh.aufbauprojekt.demo2;
}