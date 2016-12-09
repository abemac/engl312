package layout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.print.attribute.standard.NumberOfDocuments;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

public class CheckIn extends Layout {
	private BorderPane bp;
	
	private Customer selectedCustomer;
	private int roomNum;
	private int numNights;
	private boolean sl=false;
	public CheckIn(Stage primaryStage) {
		super(primaryStage);
	}
	public CheckIn(Stage primaryStage,boolean sl) {
		super(primaryStage);
		this.sl=sl;
	}

	@Override
	public void applyTo(BorderPane bp) {
		this.bp = bp;
		
		HBox container= new HBox();
		container.setAlignment(Pos.CENTER);
		container.setSpacing(25);
		container.setPadding(new Insets(0, 0, 15, 0));
        
        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        Text label = new Text("Check In");
        label.setFont(new Font("Courier New Bold Italic",40));
        center.getChildren().add(label);
        
        int random = (int)(Math.random()*10);
        Image img = new Image(getClass().getResourceAsStream("/face"+random+".png"),200,200,true,true);
        ImageView iv = new ImageView(img);
        center.getChildren().add(iv);
        
        Text choose = new Text("Choose Customer");
        choose.setFont(new Font("Courier New",20));
        center.getChildren().add(choose);
        
        VBox left = new VBox();
        left.setSpacing(15);
        
        ComboBox<Customer> customers = new ComboBox<Customer>();
        for(Customer c : util.Sdata.customers){
        	if(!c.isCheckedIn())
        		customers.getItems().add(c);
        }
        if(sl){
        	customers.setValue(customers.getItems().get(customers.getItems().size()-1));
        }
        left.getChildren().add(customers);
        container.getChildren().add(left);
        
        VBox right = new VBox();
        right.setSpacing(15);
        
        Button newCust = new Button("Add New Customer");
        newCust.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				bp.getChildren().clear();
				NewCust2 nc = new NewCust2(primaryStage);
				LayoutManager.applyLayout(nc, bp);
				
			}
		});
        
        right.getChildren().add(newCust);
        container.getChildren().add(right);
        center.getChildren().add(container);
        
        Button next = new Button("Next ▶");
        next.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				selectedCustomer = customers.getValue();
				if(selectedCustomer!=null){
					for(int i =center.getChildren().size()-1;i>=2;i--){
						center.getChildren().remove(i);
					}
					
					if(selectedCustomer.getReservationStart().equals("none")){//no reservation
						Text nores = new Text(selectedCustomer.getName() + " does not have a reservation.");
						nores.setFont(new Font("Courier New Bold",20));
						center.getChildren().add(nores);
						
						Text chooseRoom = new Text("Choose Room:");
				        chooseRoom.setFont(new Font("Courier New",20));
				        center.getChildren().add(chooseRoom);
						
						ComboBox<Integer> room = new ComboBox<Integer>();
						for(int i =1;i<=300;i+=1){
							if(util.Sdata.roomsTaken[i]==false){
								room.getItems().add(i);
							}
						}
						center.getChildren().add(room);
						Button next2 = new Button("Next ▶");
						next2.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								if(room.getValue()!=null){
									roomNum = room.getValue();
									center.getChildren().remove(center.getChildren().size()-1);
									center.getChildren().remove(center.getChildren().size()-1);
									center.getChildren().remove(center.getChildren().size()-1);
									center.getChildren().remove(center.getChildren().size()-1);
									
									
									Text chooseStayTime = new Text(selectedCustomer.getName() + " checking in");
									chooseStayTime.setFont(new Font("Courier New Bold",20));
									center.getChildren().add(chooseStayTime);
									
									Text nights = new Text("Nights to stay:");
									nights.setFont(new Font("Courier New",20));
							        center.getChildren().add(nights);
									
									ComboBox<Integer> nightsnum = new ComboBox<Integer>();
										
									boolean booked=false;
									for(int j=1;j<366 && booked==false;j++){
										 nightsnum.getItems().add(j);//add checking for reservations*******************************
										 
									}
									
									center.getChildren().add(nightsnum);
									
									Button next3 = new Button("Next ▶");
									next3.setOnAction(new EventHandler<ActionEvent>() {
										
										@Override
										public void handle(ActionEvent event) {
											if(nightsnum.getValue()!=null){
												numNights=nightsnum.getValue();
												center.getChildren().remove(center.getChildren().size()-1);
												center.getChildren().remove(center.getChildren().size()-1);
												center.getChildren().remove(center.getChildren().size()-1);
												center.getChildren().remove(center.getChildren().size()-1);
												
												
												
												Text custS = new Text("Customer Name: "+selectedCustomer.getName());
												custS.setFont(new Font("Courier New Bold",40));
												Text roomN = new Text("Room Number: "+roomNum);
												roomN.setFont(new Font("Courier New Bold",40));
												Text nightsts = new Text("Staying for "+numNights+" nights");
												nightsts.setFont(new Font("Courier New Bold",40));
												center.getChildren().addAll(custS,roomN,nightsts);
												Button checkIn = new Button("Check In");
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
												checkIn.setOnAction(new EventHandler<ActionEvent>() {

													@Override
													public void handle(ActionEvent event) {
														center.getChildren().remove(center.getChildren().size()-1);
														center.getChildren().remove(center.getChildren().size()-1);
														center.getChildren().remove(center.getChildren().size()-1);
														center.getChildren().remove(center.getChildren().size()-1);
														
														//add reservation to the customer
														DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
														DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
														
														
														
														
														Date d = new Date();
														//System.out.println(df2.format(d));
														selectedCustomer.setReservationStart((df2.format(d)));
														//System.out.println(selectedCustomer.reservationStart);
														
														LocalDate ld = LocalDate.parse(df.format(d));
														ld=ld.plusDays(numNights);
														Date d2 = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
														selectedCustomer.setReservationEnd(df2.format(d2));
														//System.out.println(selectedCustomer.reservationEnd);
														
														selectedCustomer.setRoomNumber(roomNum);
														selectedCustomer.setCheckedIn(true);
														selectedCustomer.setNumDays(numNights);
														util.Sdata.roomsTaken[roomNum]=true;
														
														Text t = new Text(selectedCustomer.getName() +" is now checked in!");
														t.setFont(new Font("Courier New Bold", 50) );
														//t.setWrappingWidth(primaryStage.getWidth());														
														center.getChildren().add(t);
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
													
												buttons.getChildren().add(checkIn);
											}
											
										}
									});
									center.getChildren().add(next3);
								}
								
							}
						});
						center.getChildren().add(next2);
					}else{//has reservation
						Text res = new Text(selectedCustomer.getName() + " has a reservation.");
						res.setFont(new Font("Courier New Bold",35));
						center.getChildren().add(res);
						
						Text room = new Text("Room No. "+selectedCustomer.getRoomNumber());
						room.setFont(new Font("Courier New Bold",20));
						center.getChildren().add(room);
						
						Text nightsts = new Text("Staying from "+selectedCustomer.getReservationStart()+" to "+selectedCustomer.getReservationEnd());
						nightsts.setFont(new Font("Courier New Bold",20));
						center.getChildren().add(nightsts);
						
						Text num = new Text(selectedCustomer.getNumDays()+" nights total");
						num.setFont(new Font("Courier New Bold",20));
						center.getChildren().add(num);
						
						
						Button checkIn = new Button("Check in");
						
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
						buttons.getChildren().add(checkIn);
						checkIn.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								center.getChildren().remove(center.getChildren().size()-1);
								center.getChildren().remove(center.getChildren().size()-1);
								center.getChildren().remove(center.getChildren().size()-1);
								center.getChildren().remove(center.getChildren().size()-1);
								center.getChildren().remove(center.getChildren().size()-1);
								selectedCustomer.setCheckedIn(true);
								util.Sdata.roomsTaken[selectedCustomer.getRoomNumber()]=true;
								
								Text t = new Text(selectedCustomer.getName() +" is now checked in!");
								t.setFont(new Font("Courier New Bold", 50) );
								//t.setWrappingWidth(primaryStage.getWidth());														
								center.getChildren().add(t);
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
				}
			}
		});
        
        
        center.getChildren().add(next);
        VBox spacer = new VBox();
        spacer.setMinHeight(50);
        center.getChildren().add(spacer);
       
        
        
        
       
        
        center.setSpacing(10);
        
        
        
        bp.setCenter(center);
        
        
        
	}

}
