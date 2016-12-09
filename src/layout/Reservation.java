package layout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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

public class Reservation extends Layout {
	
	private Customer selectedCustomer;
	private int roomNum,numNights;
	private boolean sl =false;
	public Reservation(Stage primaryStage) {
		super(primaryStage);
		// TODO Auto-generated constructor stub
	}
	public Reservation(Stage primaryStage,boolean sl) {
		super(primaryStage);
		this.sl=sl;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void applyTo(BorderPane bp) {
		HBox container= new HBox();
		container.setAlignment(Pos.CENTER);
		container.setSpacing(25);
		container.setPadding(new Insets(0, 0, 15, 0));
        
        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        Text label = new Text("Make a Reservation");
        label.setFont(new Font("Courier New Bold",40));
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
				NewCust3 nc = new NewCust3(primaryStage);
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
					
					
						Text nores = new Text( "Creating reservation for "+selectedCustomer.getName());
						nores.setFont(new Font("Courier New Bold",20));
						center.getChildren().add(nores);
						
						Text chooseRoom = new Text("Choose Room:");
				        chooseRoom.setFont(new Font("Courier New",20));
				        center.getChildren().add(chooseRoom);
						
						ComboBox<Integer> room = new ComboBox<Integer>();
						for(int i =1;i<=300;i+=1){
							room.getItems().add(i);//something to check for conflicts*******************
							
						}
						center.getChildren().add(room);
						Button nextb2 = new Button("Next ▶");
						center.getChildren().add(nextb2);
						Button next2 = new Button("Next ▶");
						nextb2.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								if(room.getValue()!=null){
									roomNum = room.getValue();
									center.getChildren().remove(center.getChildren().size()-1);
									center.getChildren().remove(center.getChildren().size()-1);
									center.getChildren().remove(center.getChildren().size()-1);
									center.getChildren().remove(center.getChildren().size()-1);
									
									Text chooseStart = new Text("Choose Starting Date");
									chooseStart.setFont(new Font("Courier New",25));
									center.getChildren().add(chooseStart);
									
									ComboBox<String> cb = new ComboBox<String>();
									DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
									DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
								
									Date d = new Date();
								//	System.out.println(selectedCustomer.reservationStart);
									
									LocalDate ld = LocalDate.parse(df.format(d));
									
									for(int i=0;i<=365*5;i++){
										Date d2 = Date.from(ld.plusDays(i).atStartOfDay(ZoneId.systemDefault()).toInstant());
										cb.getItems().add(df.format(d2));
									}
									center.getChildren().add(cb);
									
									
									
									
									
									next2.setOnAction(new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent event) {
											if(cb.getValue()!=null){
												LocalDate ld = LocalDate.parse(cb.getValue());
												Date d2 = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
												selectedCustomer.setReservationStart(df2.format(d2));
												
												System.out.println(selectedCustomer.getReservationStart());
												
												center.getChildren().remove(center.getChildren().size()-1);
												center.getChildren().remove(center.getChildren().size()-1);
												center.getChildren().remove(center.getChildren().size()-1);
												
												
												
												Text chooseStayTime = new Text(selectedCustomer.getName() + "'s Reservation");
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
															Text startDate = new Text("Starting on "+ df2.format(d2));
															startDate.setFont(new Font("Courier New Bold",40));
															Text nightsts = new Text("Staying for "+numNights+" nights");
															nightsts.setFont(new Font("Courier New Bold",40));
															center.getChildren().addAll(custS,roomN,startDate,nightsts);
															HBox buttons=new HBox(25);
															buttons.setAlignment(Pos.CENTER);
															Button cancel = new Button("Cancel");
															buttons.getChildren().add(cancel);
															cancel.setOnAction(new EventHandler<ActionEvent>() {
																
																@Override
																public void handle(ActionEvent event) {
																	bp.getChildren().clear();
																	selectedCustomer.setReservationStart("none");
																	Home h = new Home(primaryStage);
																	LayoutManager.applyLayout(h, bp);
																	
																}
															});
															center.getChildren().add(buttons);
															Button checkIn = new Button("Make Reservation");
															checkIn.setOnAction(new EventHandler<ActionEvent>() {

																@Override
																public void handle(ActionEvent event) {
																	center.getChildren().remove(center.getChildren().size()-1);
																	center.getChildren().remove(center.getChildren().size()-1);
																	center.getChildren().remove(center.getChildren().size()-1);
																	center.getChildren().remove(center.getChildren().size()-1);
																	center.getChildren().remove(center.getChildren().size()-1);
																	
																	//add reservation to the customer
																	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
																	DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
																	
																	
																	
																	
																	Date d = d2;
																	//System.out.println(df2.format(d));
																	selectedCustomer.setReservationStart(df2.format(d));
																	System.out.println(selectedCustomer.getReservationStart());
																	
																	LocalDate ld = LocalDate.parse(df.format(d));
																	ld=ld.plusDays(numNights);
																	Date d2 = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
																	selectedCustomer.setReservationEnd(df2.format(d2));
																	System.out.println(selectedCustomer.getReservationEnd());
																	selectedCustomer.setNumDays(numNights);
																	selectedCustomer.setRoomNumber(roomNum);
																	//selectedCustomer.checkedIn=true;
																	
																	util.Sdata.roomsTaken[roomNum]=true;
																	
																	Text t = new Text(selectedCustomer.getName() +" now has a reservation!");
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
								}
								
							}
						});
						
						
						
						
						
						
					
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
