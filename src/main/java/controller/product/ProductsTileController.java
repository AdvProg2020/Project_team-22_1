package main.java.controller.product;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.java.controller.Core;
import main.java.model.product.Product;



public class ProductsTileController {

    @FXML
    private VBox vbox;
    @FXML
    private Label categoryLabel;

    @FXML
    private Label infoLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Button discount;

    Product product ;
    Core core ;

    @FXML
    private void initialize(){
        initTile() ;
    }

    public ProductsTileController(Product product) {
        this.product = product ;
        this.core = new Core() ;
    }

    private void initTile() {

        infoLabel.setText( product.getName() + "  " + product.getBrand() );
        if ( product.getCategoryName() != null) {
            categoryLabel.setText( categoryLabel.getText() + product.getCategoryName());
        }
        if( product.getCategoryName() != null &&  product.getCategory() !=null){
            if( product.getCategory().getProperties() != null &&  product.getCategory().getProperties().size() >0 ){
                categoryLabel.setText( categoryLabel.getText() + " - " ) ;
                for( String key : product.getCategory().getProperties().values()){
                    categoryLabel.setText( categoryLabel.getText() + "," + key ) ;
                }
            }
        }
        if( product.getNumberOfProduct() > 0) {

            priceLabel.setText( product.getPrice() + " تومان");
            priceLabel.setStyle( "-fx-text-fill: #0a0a0a") ;
            discount.setVisible(false);
        }else{
            priceLabel.setText( "ناموجود است ");
            priceLabel.setStyle( "-fx-text-fill: #8a8888");
            discount.setVisible(false);
        }
    }



}
