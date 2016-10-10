package layout;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Home extends Layout {

	private TextField searchBar;
	private ListView<String> list;
	ObservableList<String> items;
	public Home(Stage primaryStage) {
		super(primaryStage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyTo(BorderPane bp) {
		VBox center = new VBox();
		
		VBox search = new VBox();
		search.setAlignment(Pos.CENTER);
		searchBar = new TextField();
		
		searchBar.setMaxWidth(400);
		searchBar.setMinWidth(400);
		
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
		
		searchBar.setOnKeyTyped(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode()==KeyCode.ENTER){
					list.getItems().remove(list.getItems().size()-1);
					list.getItems().add(searchBar.getText());
					list.getItems().add("");
					if(list.getItems().size()<7){
						list.setMaxHeight(list.getItems().size()*25);
					}else {
						list.setMaxHeight(7*25);
					}
					
					searchBar.clear();
					
				}else{
					list.getItems().remove(list.getItems().size()-1);
					list.getItems().add(searchBar.getText()+event.getCharacter());

					//System.out.println(list.getItems().get(list.getItems().size()-1));
				}
				
			}
			
		});
		searchBar.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode()==KeyCode.ENTER){
					list.getItems().remove(list.getItems().size()-1);
					list.getItems().add(searchBar.getText());
					list.getItems().add("");
					if(list.getItems().size()<7){
						list.setMaxHeight(list.getItems().size()*25);
					}else {
						list.setMaxHeight(7*25);
					}
					
					searchBar.clear();
					
				}else{
					list.getItems().remove(list.getItems().size()-1);
					list.getItems().add(searchBar.getText()+event.getCharacter());

					//System.out.println(list.getItems().get(list.getItems().size()-1));
				}
				
			}
			
		});
		search.getChildren().add(searchBar);
		
		//Button searchBtn=new Button("Go");
		//search.getChildren().add(searchBtn);
		
		list = new ListView<String>();
		items = FXCollections.observableArrayList();
		items.add("Check in");
		list.setMaxWidth(250);
		list.setMaxHeight(50);
		list.setItems(items);
		list.setId("lv");
		//list.getStylesheets().add(getClass().getResource("/styles/home/list-view.css").toString());
		
		search.getChildren().add(list);
		search.setSpacing(15);
		search.setMaxWidth(1000);
		
		center.getChildren().add(search);
		
		center.setAlignment(Pos.CENTER);
		bp.setCenter(center);
		//searchBtn.requestFocus();	 
		
		
	}

}
