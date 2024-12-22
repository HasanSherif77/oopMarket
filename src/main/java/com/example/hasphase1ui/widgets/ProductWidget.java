package com.example.hasphase1ui.widgets;

import com.example.hasphase1ui.files.Customer;
import com.example.hasphase1ui.files.Product;
import com.example.hasphase1ui.files.User;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class ProductWidget extends HBox {
    public ProductWidget(Product product){

        CenteredLabel productInfo = new CenteredLabel(product.getName()+"  :  "+product.getCategory().getCategoryName());
        this.getChildren().add(productInfo);
        this.setAlignment(Pos.CENTER);
    }
}
