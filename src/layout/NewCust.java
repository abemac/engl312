package layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.Customer;

public class NewCust extends Layout{

	public NewCust(Stage primaryStage) {
		super(primaryStage);
		// TODO Auto-generated constructor stub
	}
	private String custName,custEmail,addInfo;

	@Override
	public void applyTo(BorderPane bp) {
		VBox center = new VBox(10);
		center.setAlignment(Pos.CENTER);
		
		Text title = new Text("Add new customer");
		title.setFont(new Font("Courier New Bold",30));
		bp.setCenter(center);
		center.getChildren().add(title);
		int random = (int)(Math.random()*10);
	    Image img = new Image(getClass().getResourceAsStream("/face"+random+".png"),200,200,true,true);
	    ImageView iv = new ImageView(img);
	    center.getChildren().add(iv);
		Text dir = new Text("Enter customer name:");
		dir.setFont(new Font("Courier New",20));
		center.getChildren().add(dir);
		
		TextField name = new TextField();
		name.setEditable(true);
		center.getChildren().add(name);
		name.setMaxWidth(200);
		
		Button next = new Button("Next ▶");
		center.getChildren().add(next);
		
		next.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				custName=name.getText().trim();
				center.getChildren().remove(center.getChildren().size()-1);
				center.getChildren().remove(center.getChildren().size()-1);
				center.getChildren().remove(center.getChildren().size()-1);
				Text dir = new Text("Enter customer email:");
				dir.setFont(new Font("Courier New",20));
				center.getChildren().add(dir);
				
				TextField email = new TextField();
				email.setEditable(true);
				center.getChildren().add(email);
				email.setMaxWidth(200);
				
				Button next2 = new Button("Next ▶");
				center.getChildren().add(next2);
				next2.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						
						custEmail=email.getText().trim();
						center.getChildren().remove(center.getChildren().size()-1);
						center.getChildren().remove(center.getChildren().size()-1);
						center.getChildren().remove(center.getChildren().size()-1);
						Text dir = new Text("Enter customer additional info:");
						dir.setFont(new Font("Courier New",20));
						center.getChildren().add(dir);
						
						TextArea info = new TextArea();
						info.setEditable(true);
						center.getChildren().add(info);
						info.setMaxSize(300, 250);
						info.setWrapText(true);
						
						Button next3 = new Button("Next ▶");
						center.getChildren().add(next3);
						next3.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								addInfo=info.getText();
								center.getChildren().remove(center.getChildren().size()-1);
								center.getChildren().remove(center.getChildren().size()-1);
								center.getChildren().remove(center.getChildren().size()-1);
								util.Sdata.customers.add(new Customer(custName){{setEmail(custEmail);setAddInfo(NewCust.this.addInfo);}});
								Text done = new Text(custName+" succesfully added!");
								done.setFont(new Font("Courier New Bold",40));
								center.getChildren().add(done);
								Button ok = new Button("Ok");
								ok.setOnAction(new EventHandler<ActionEvent>() {
									
									@Override
									public void handle(ActionEvent event) {
										bp.getChildren().clear();
							    		Home h= new Home(primaryStage);
							    		LayoutManager.applyLayout(h, bp);
										
									}
								});
								center.getChildren().add(ok);
								
							}
						});
					}
				});
				
			}
		});
	}

}
