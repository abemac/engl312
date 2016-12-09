package layout;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.Customer;

public class ViewCusts extends Layout{

	public ViewCusts(Stage primaryStage) {
		super(primaryStage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyTo(BorderPane bp) {
		// TODO Auto-generated method stub
		final Text label = new Text("Customers");
        label.setFont(new Font("Courier New Bold", 40));
        final TableView<Customer> table = new TableView<Customer>();
        table.setMaxWidth(900);
        table.setEditable(true);
 
        TableColumn nameCol = new TableColumn("Name");
        TableColumn checkedIn = new TableColumn("Checked In");
        TableColumn emailCol = new TableColumn("Email");
        TableColumn room = new TableColumn("Room No.");
        TableColumn res = new TableColumn("Reservation");
        TableColumn info = new TableColumn("Additional Info");
        
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        checkedIn.setCellValueFactory(new PropertyValueFactory<>("checkedIn"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        room.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        res.setCellValueFactory(new PropertyValueFactory<>("res"));
        info.setCellValueFactory(new PropertyValueFactory<>("addInfo"));
        	
        
        table.getColumns().addAll(nameCol,checkedIn,emailCol,room,res,info);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        ObservableList<Customer> data = FXCollections.observableArrayList();
        for(Customer c: util.Sdata.customers){
        	data.add(c);
        	System.out.println(c.getName());
        }
        table.setItems(data);
        
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        Button ok = new Button("Ok");
		ok.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				bp.getChildren().clear();
	    		Home h= new Home(primaryStage);
	    		LayoutManager.applyLayout(h, bp);
				
			}
		});
		
        vbox.getChildren().addAll(label, table,ok);
        
        bp.setCenter(vbox);
	}

}
