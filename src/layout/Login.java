package layout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.Sdata;

public class Login extends Layout {

	public Login(Stage primaryStage) {
		super(primaryStage);
	}



	VBox vbox;
    Media dwbh=null;
    MediaPlayer mp=null;
    TextField eid;
    PasswordField pwd;
    BorderPane root;
 
	
	@Override
	public void applyTo(BorderPane bp) {
		root=bp;
		Button btn = new Button();
        btn.setText("Login");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            	login(primaryStage,eid.getText(),pwd.getText());
                
            }
        });
        
        
        vbox = new VBox();
        StackPane sp = new StackPane();
        int random = (int)(Math.random()*10);
        Image img = new Image(getClass().getResourceAsStream("/face"+random+".png"),200,200,true,true);
        ImageView iv = new ImageView(img);
        iv.setOpacity(0.2);
        iv.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				if(event.getClickCount()==4 && dwbh==null){
					dwbh = new Media(getClass().getResource("/dwbh.mp3").toString());
					mp = new MediaPlayer(dwbh);
					mp.seek(mp.getStartTime());
					mp.play();
				}else if(mp!=null && event.getClickCount()==2){
					if(mp.getStatus()==Status.PAUSED){
						mp.play();
					}else{
						mp.pause();
					}
				}
			}
        	
        });
        
        
        vbox.getChildren().add(iv);
        vbox.setAlignment(Pos.CENTER);
        
        
        vbox.getChildren().add(new VBox(){{setMinHeight(10);}});
        
        Text eidlabel = new Text("Employee ID:");
        vbox.getChildren().add(eidlabel);
        eid = new TextField();
        eid.setMaxWidth(160);
        
        vbox.getChildren().add(eid);
        
        Text pwdlabel = new Text("Password:");
        vbox.getChildren().add(pwdlabel);
        pwd = new PasswordField();
        pwd.setMaxWidth(160);
        pwd.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode()==KeyCode.ENTER){
					login(primaryStage,eid.getText(),pwd.getText());
				}
				
			}
        	
        });
        vbox.getChildren().add(pwd);
        
        vbox.getChildren().add(btn);
        vbox.getChildren().add(new VBox(){{setMinHeight(100);}});
        vbox.setSpacing(6);
        
        
        BorderPane titlebp=new BorderPane();
        VBox top = new VBox();
        top.setAlignment(Pos.CENTER);
        Text title = new Text("SimplePMS");
        title.setFont(new Font("Courier New Bold",50));
        top.setPadding(new Insets(50,0,0,0));
        Text loc = new Text("Property Management Software");
        loc.setFont(new Font("Courier New Italic",20));
        top.getChildren().add(title);
        top.getChildren().add(loc);
        titlebp.setTop(top);
        
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        
        sp.setPadding(new Insets(50, 0, 0, 0));
        sp.getChildren().add(vbox);
        root.setCenter(sp);
        
            
       
        StackPane sp2 = new StackPane(titlebp,root);
        
                 

                
        Scene scene = new Scene(sp2);
        titlebp.setStyle("-fx-background-color: #8eb1d5;");
        primaryStage.setScene(scene);	
       // primaryStage.setFullScreen(true);
        //primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setHeight(450);
        primaryStage.setWidth(400);
        primaryStage.setTitle("SimplePMS");
		
	}
	
	
	 private void login(Stage primaryStage, String EID, String pwd){
	    	//if(sql.Login.correct(EID, pwd)){
	    		Sdata.setUser(EID);
	    		root.getChildren().clear();
	    		primaryStage.setFullScreen(true);
	    		Home home= new Home(primaryStage);
	    		LayoutManager.applyLayout(home, root);
	    		
	    	//}
	    }

}
