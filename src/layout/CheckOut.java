package layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.Customer;

public class CheckOut extends Layout{

	public CheckOut(Stage primaryStage) {
		super(primaryStage);
		// TODO Auto-generated constructor stub
	}
	
	private Customer selectedCustomer;

	@Override
	public void applyTo(BorderPane bp) {
		
		VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        center.setSpacing(10);
        
        Text label = new Text("Check Out");
        label.setFont(new Font("Courier New Bold Italic",40));
        center.getChildren().add(label);
        
        int random = (int)(Math.random()*10);
        Image img = new Image(getClass().getResourceAsStream("/face"+random+".png"),200,200,true,true);
        ImageView iv = new ImageView(img);
        center.getChildren().add(iv);
        
        bp.setCenter(center);
        
        Text cust = new Text("Choose customer to check out");
        cust.setFont(new Font("Courier New",25));
        center.getChildren().add(cust);
        
        ComboBox<Customer> custs = new ComboBox<Customer>();
        for(Customer c  : util.Sdata.customers){
        	if(c.isCheckedIn()){
        		custs.getItems().add(c);
        	}
        }
        
        center.getChildren().add(custs);
        HBox buttons=new HBox(25);
		buttons.setAlignment(Pos.CENTER);
		Button cancel = new Button("Cancel");
		buttons.getChildren().add(cancel);
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				bp.getChildren().clear();
				Home h = new Home(primaryStage);
				LayoutManager.applyLayout(h, bp);
				
			}
		});
		center.getChildren().add(buttons);
        Button checkOut = new Button("Check Out");
    	checkOut.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(custs.getValue()==null){return;}
				selectedCustomer=custs.getValue();
				center.getChildren().remove(center.getChildren().size()-1);
				center.getChildren().remove(center.getChildren().size()-1);
				center.getChildren().remove(center.getChildren().size()-1);
				
				
				Text checkedOut = new Text (selectedCustomer.getName() + " is now checked out.");
				checkedOut.setFont(new Font("Courier New Bold",40));
				center.getChildren().add(checkedOut);
				
				selectedCustomer.setCheckedIn(false);
				selectedCustomer.setReservationEnd("none");
				selectedCustomer.setReservationStart("none");
				
				Button ok = new Button("Ok");
				ok.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						bp.getChildren().clear();
						Home h = new Home(primaryStage);
						LayoutManager.applyLayout(h, bp);
						
					}
				});
				center.getChildren().add(ok);
			}
		});
    	buttons.getChildren().add(checkOut);
    	

        
	}
	
	
	
	
	

}
