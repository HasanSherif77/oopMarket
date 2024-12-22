module com.example.hasphase1ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens com.example.hasphase1ui to javafx.fxml;
    exports com.example.hasphase1ui;
    exports com.example.hasphase1ui.widgets;
    opens com.example.hasphase1ui.widgets to javafx.fxml;
    exports com.example.hasphase1ui.Pages;
    opens com.example.hasphase1ui.Pages to javafx.fxml;
    exports com.example.hasphase1ui.Pages.LoginPages;
    opens com.example.hasphase1ui.Pages.LoginPages to javafx.fxml;
    exports com.example.hasphase1ui.Pages.CategoriesProducts;
    opens com.example.hasphase1ui.Pages.CategoriesProducts to javafx.fxml;
    exports com.example.hasphase1ui.Pages.CartOrders;
    opens com.example.hasphase1ui.Pages.CartOrders to javafx.fxml;


    exports com.example.hasphase1ui.Pages.CRUD.Product;
    opens com.example.hasphase1ui.Pages.CRUD.Product to javafx.fxml;
    exports com.example.hasphase1ui.Pages.CRUD.Category;
    opens com.example.hasphase1ui.Pages.CRUD.Category to javafx.fxml;
}