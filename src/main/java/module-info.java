module com.brh.aufbauprojekt.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires jbcrypt;
    requires java.desktop;


    opens com.brh.aufbauprojekt.demo2 to javafx.fxml;
    exports com.brh.aufbauprojekt.demo2;
}