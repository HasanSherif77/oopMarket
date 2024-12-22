package com.example.hasphase1ui.Pages.CartOrders;


import com.example.hasphase1ui.Pages.CategoriesProducts.CategoriesPage;
import com.example.hasphase1ui.files.*;
import com.example.hasphase1ui.widgets.ConfirmButton;
import com.example.hasphase1ui.widgets.PagesBackground;
import com.example.hasphase1ui.widgets.Toolbar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CartPage {

    private Customer customer;
    private VBox mainLayout;
    private VBox productSection;
    private ToggleGroup paymentGroup;
    private Stage stage;
    private Label totalTextLabel;

    public CartPage(Customer customer, Stage stage) {
        this.customer = customer;
        this.mainLayout = new VBox(10);
        this.paymentGroup = new ToggleGroup();
        this.stage = stage;
        this.productSection = new VBox(10);
    }

    public VBox getRoot() {
        mainLayout.setAlignment(Pos.TOP_CENTER);

        Toolbar toolbar = new Toolbar(stage,customer);

        ConfirmButton backButton = new ConfirmButton("Go Back");
        toolbar.getChildren().addFirst(backButton);
        backButton.setOnAction(e->{
            CategoriesPage categoriesPage = new CategoriesPage(stage,customer);
            stage.getScene().setRoot(categoriesPage.getRoot());
        });

        Label cartTitle = new Label("Your Cart");
        cartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        cartTitle.setStyle("-fx-text-fill: #000000;");
        cartTitle.setPadding(new Insets(10, 0, 10, 0));

        productSection.setAlignment(Pos.CENTER);
        productSection.setPadding(new Insets(10, 0, 10, 0));

        ScrollPane scrollPane = new ScrollPane(productSection);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setStyle("-fx-background-color: #FFFFFF;");
        scrollPane.setMaxWidth(600);
        scrollPane.setPrefWidth(600);

        VBox totalCheckoutBox = new VBox(20);
        totalCheckoutBox.setAlignment(Pos.CENTER);
        totalCheckoutBox.setPadding(new Insets(0, 20, 10, 20));

        totalTextLabel = new Label();
        totalTextLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        totalTextLabel.setStyle("-fx-text-fill: #000000;");

        Button checkoutButton = createButton("Checkout", "green", "#FFFFFF", 14);
        checkoutButton.setPrefSize(120, 40);
        checkoutButton.setOnAction(event -> handleCheckout());

        totalCheckoutBox.getChildren().addAll(totalTextLabel, checkoutButton);

        HBox paymentOptionsBox = new HBox(20);
        paymentOptionsBox.setAlignment(Pos.CENTER);
        paymentOptionsBox.setPadding(new Insets(5, 20, 10, 20));

        RadioButton cashOnDelivery = new RadioButton("Cash on Delivery");
        cashOnDelivery.setToggleGroup(paymentGroup);

        RadioButton balancePayment = new RadioButton("Balance");
        balancePayment.setToggleGroup(paymentGroup);

        paymentOptionsBox.getChildren().addAll(cashOnDelivery, balancePayment);

        mainLayout.getChildren().addAll(toolbar, cartTitle, scrollPane, totalCheckoutBox, paymentOptionsBox);

        refreshProductSection();
        mainLayout.setBackground(PagesBackground.getBackground());
        return  mainLayout;
    }

    private void refreshProductSection() {
        productSection.getChildren().clear();

        if (customer.getCart().getCartProducts().isEmpty()) {
            mainLayout.getChildren().clear();

            Toolbar toolbar = new Toolbar(stage,customer);

            ConfirmButton backButton = new ConfirmButton("Go Back");
            toolbar.getChildren().addFirst(backButton);
            backButton.setOnAction(e->{
                CategoriesPage categoriesPage = new CategoriesPage(stage,customer);
                stage.getScene().setRoot(categoriesPage.getRoot());
            });

            Label cartTitle = new Label("Your Cart");
            cartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 25));
            cartTitle.setStyle("-fx-text-fill: #000000;");
            cartTitle.setPadding(new Insets(10, 0, 10, 0));

            Label emptyCartMessage = new Label("The cart is empty");
            emptyCartMessage.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            emptyCartMessage.setStyle("-fx-text-fill: #FF0000;");
            emptyCartMessage.setPadding(new Insets(150, 0, 0, 0));

            VBox emptyCartLayout = new VBox(20, toolbar, cartTitle, emptyCartMessage);
            emptyCartLayout.setAlignment(Pos.CENTER);
            emptyCartLayout.setStyle("-fx-background-color: transparent;");
            mainLayout.getChildren().addAll(emptyCartLayout);
        } else {
            for (Product product : customer.getCart().getCartProducts()) {
                productSection.getChildren().add(createProduct(product));
            }

            totalTextLabel.setText(String.format("Total: %.2f EGP", customer.getCart().getTotalPrice()));
        }
    }

    private HBox createProduct(Product product) {
        Image image = new Image(getClass().getResourceAsStream(product.getProductImageUrl()));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);

        VBox details = new VBox(5);
        details.setPrefWidth(300);
        Label productName = new Label(product.getName());
        productName.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        productName.setStyle("-fx-text-fill: #424242;");

        Label productPrice = new Label(product.getPrice() + " EGP");
        productPrice.setStyle("-fx-text-fill: green; -fx-font-size: 12px;");

        details.getChildren().addAll(productName, productPrice);

        Button removeButton = createButton("Remove", "green", "#FFFFFF", 12);
        removeButton.setOnAction(event -> {
            customer.getCart().getCartProducts().remove(product);
            refreshProductSection();
        });

        HBox productBox = new HBox(20, imageView, details, removeButton);
        productBox.setPadding(new Insets(10));
        productBox.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #E0E0E0; -fx-border-radius: 10px;");
        productBox.setAlignment(Pos.CENTER_LEFT);

        return productBox;
    }

    private void handleCheckout() {
        Cart cart = customer.getCart();
        double totalPrice = cart.getTotalPrice();

        if (totalPrice == 0) {
            showAlert(Alert.AlertType.ERROR, "Cart is Empty", "Your cart is empty. Please add products before checking out.");
            return;
        }

        RadioButton selectedPaymentMethod = (RadioButton) paymentGroup.getSelectedToggle();
        if (selectedPaymentMethod == null) {
            showAlert(Alert.AlertType.WARNING, "No Payment Method", "Please select a payment method before proceeding.");
            return;
        }

        String paymentMethod = selectedPaymentMethod.getText();

        if (paymentMethod.equals("Cash on Delivery")) {
            Order order = new Order(customer, PaymentMethod.CashOnDelivery,cart.getTotalPrice());
            customer.placeOrder(order);
            showAlert(Alert.AlertType.INFORMATION, "Order Placed", "Your order has been placed successfully! Please pay " + totalPrice + " EGP on delivery.");
        } else if (paymentMethod.equals("Balance")) {
            if (customer.getBalance() >= totalPrice) {
                customer.setBalance(customer.getBalance() - totalPrice);
                Order order = new Order(customer, PaymentMethod.Balance,cart.getTotalPrice());
                customer.placeOrder(order);
                showAlert(Alert.AlertType.INFORMATION, "Order Placed", "Your order has been placed successfully! " + totalPrice + " EGP has been deducted from your balance.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Insufficient Balance", "You do not have enough balance. Please add funds to proceed.");
                return;
            }
        }

        cart.getCartProducts().clear();
        refreshProductSection();
    }

    private Button createButton(String text, String bgColor, String textColor, int fontSize) {
        Button button = new Button(text);
        button.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: %s; -fx-font-size: %dpx; -fx-background-radius: 15px;", bgColor, textColor, fontSize));
        return button;
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
