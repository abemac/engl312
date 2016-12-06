package layout;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.Sdata;

public class Home extends Layout {

	private TextField searchBar;
	private Button searchBtn;
	private BorderPane bp;
	public Home(Stage primaryStage) {
		super(primaryStage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyTo(BorderPane bp) {
		this.bp=bp;
		VBox center = new VBox();
		
		VBox search = new VBox();
		search.setAlignment(Pos.CENTER);
		searchBar = new TextField();
		
		
		searchBar.setMaxWidth(400);
		searchBar.setMinWidth(400);
		
		
		
		Image img = new Image(getClass().getResourceAsStream("/hotel.png"),512,225,true,true);
        ImageView iv = new ImageView(img);
		search.getChildren().add(iv);
		
		VBox spacer = new VBox();
		spacer.setMaxHeight(1);
		spacer.setMinHeight(1);
		search.getChildren().add(spacer);
		Font searchBarFont = Font.font("Courier New Bold",25);
		
		searchBar.setFont(searchBarFont);
		String styleBlack = "-fx-alignment: center;-fx-text-inner-color: black;";
		String styleGray= "-fx-alignment: center;-fx-text-inner-color: lightgray;";
		searchBar.setStyle(styleGray);
		searchBar.setText("Tell me what to do");
		
		
		searchBar.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(!searchBar.isFocused()){
					if(searchBar.getText().trim().equals("")){
						searchBar.setText("Tell me what to do");
						searchBar.setStyle(styleGray);
					}
					
					
					
				}else if(searchBar.getText().trim().equals("Tell me what to do")){
					searchBar.setText("");
					searchBar.setStyle(styleBlack);
				}
				
			}
		});
		
		searchBar.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode()==KeyCode.ENTER){
					handleUsrInput(searchBar.getText());
				}
				
			}
			
		});
		search.getChildren().add(searchBar);
		
		searchBtn=new Button("Go");
		search.getChildren().add(searchBtn);
		
		searchBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				handleUsrInput(searchBar.getText());
				
			}
		});
		search.setSpacing(15);
		search.setMaxWidth(1000);
		
		center.getChildren().add(search);
		
		center.setAlignment(Pos.CENTER);
		center.setPadding(new Insets(0,0,0,0));
		bp.setCenter(center);
		searchBtn.requestFocus();	 
		
//		
//		VBox top = new VBox();
//        top.setAlignment(Pos.TOP_CENTER);
//        Text title = new Text("Simple PMS");
//        title.setFont(new Font("Courier New Bold",50));
//        top.setPadding(new Insets(50,0,0,0));
//        Text loc = new Text("Property Management Software");
//        loc.setFont(new Font("Courier New Italic",20));
//        top.getChildren().add(title);
//        top.getChildren().add(loc);
//        bp.setTop(top);
//        
        
		
		
	}
	
	
	private void handleUsrInput(String input){
		if(input.toUpperCase().trim().equals("CHECK IN") || aliasOf(input,Sdata.CHECK_IN)){
			bp.getChildren().clear();
    		primaryStage.setFullScreen(true);
    		CheckIn ci= new CheckIn(primaryStage);
    		LayoutManager.applyLayout(ci, bp);
		}
		else if(input.toUpperCase().trim().equals("CHECK OUT") || aliasOf(input,Sdata.CHECK_OUT)){
			
		}else if(input.toUpperCase().trim().equals("ADD CUSTOMER") || aliasOf(input,Sdata.ADD_CUSTOMER)){
			
		}else if(input.toUpperCase().trim().equals("WAKE UP CALL") || aliasOf(input,Sdata.WAKE_UP_CALL)){
			
		}else if(input.toUpperCase().trim().equals("ROOM SERVICE") || aliasOf(input,Sdata.ROOM_SERVICE)){
			
		}else if(input.toUpperCase().trim().equals("EMAIL") || aliasOf(input,Sdata.EMAIL)){
			
		}else if(input.toUpperCase().trim().equals("TENDS") || aliasOf(input,Sdata.TRENDS)){
			
		}else if(input.toUpperCase().trim().equals("MONEY") || aliasOf(input,Sdata.MONEY)){
			
		}else if(input.toUpperCase().trim().equals("BREAKFAST") || aliasOf(input,Sdata.BREAKFAST)){
			
		}else if(input.toUpperCase().trim().equals("RESERVATION") || aliasOf(input,Sdata.RESERVATION)){
			
		}
	}
	
	private boolean aliasOf(String input,int cmdIndex){
		return Sdata.aliases.get(cmdIndex).contains(input);
	}

}
