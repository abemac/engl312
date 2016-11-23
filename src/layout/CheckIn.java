package layout;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckIn extends Layout {
	private BorderPane bp;
	public CheckIn(Stage primaryStage) {
		super(primaryStage);
	}

	@Override
	public void applyTo(BorderPane bp) {
		this.bp = bp;
		VBox top = new VBox();
        top.setAlignment(Pos.TOP_CENTER);
        Text title = new Text("Simple PMS");
        title.setFont(new Font("Courier New Bold",50));
        top.setPadding(new Insets(50,0,0,0));
        Text loc = new Text("Property Management Software");
        loc.setFont(new Font("Courier New Italic",20));
        top.getChildren().add(title);
        top.getChildren().add(loc);
        bp.setTop(top);
        
        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        Text label = new Text("Check In");
        label.setFont(new Font("Courier New Bold Italic",40));
        center.getChildren().add(label);
        
        Image img = new Image(getClass().getResourceAsStream("/stock_smiley-6.png"),200,200,true,true);
        ImageView iv = new ImageView(img);
        center.getChildren().add(iv);
        
        Text choose = new Text("Choose Customer:");
        choose.setFont(new Font("Courier New",20));
        center.getChildren().add(choose);
        
        ComboBox<String> customers = new ComboBox<String>();
        customers.setItems(FXCollections.observableArrayList("Bob Rice","Foulack Ruacien","Brad Smith"));
        center.getChildren().add(customers);
//        customers.setMinHeight(40);
//        customers.setMaxHeight(40);
//        customers.setCellFactory(
//                new Callback<ListView<String>, ListCell<String>>() {
//                    @Override
//                    public ListCell<String> call(ListView<String> param) {
//                        final ListCell<String> cell = new ListCell<String>() {
//                            @Override
//                            public void updateItem(String item,
//                                    boolean empty) {
//                                super.updateItem(item, empty);
//                                if (item != null) {
//                                    setText(item);
//                                    setFont(this.getFont().font(this.getFont().getName(), 40)); //set your desired size
//                                } else {
//                                    setText(null);
//                                }
//                            }
//                        };
//                        return cell;
//                    }
//
//                });

        Text or = new Text("Or:");
        or.setFont(new Font("Courier New",20));
        center.getChildren().add(or);
        
        Button newCust = new Button("Add New Customer");
        newCust.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
        center.getChildren().add(newCust);
        
        
        
        Button next = new Button("Next ▶");
        next.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
        center.getChildren().add(next);
        
        center.setSpacing(10);
        
        
        bp.setCenter(center);
        
        
        
	}

}
