package com.example.hasphase1ui.widgets;

import com.example.hasphase1ui.files.Order;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class OrderWidget extends HBox {
    public OrderWidget(Order order){
        CenteredLabel orderInfo = new CenteredLabel(
                order.getOrderNumber()
                +"  :  "
                +order.getCustomer().getUsername()
                +"  "
                +order.getPaymentMethod()
                +"  "
                +order.getOrderTotal()
        );
        this.getChildren().add(orderInfo);
        this.setAlignment(Pos.CENTER);
    }
}
