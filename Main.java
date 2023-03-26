package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import application.Server;
import application.Main.fileIO;




public class Main extends Application {
	
	Button exitB, homeB, homeB2, homeB3, homeB4, homeB5, homeB6, homeB7, homeB8,homeB9, Nbutton, N2button, N3button, Mbutton, M2button, M3button, Lbutton, L2button, L3button, subB;
	Scene Home, NY, NY2, NY3, MI, MI2, MI3, LA, LA2, LA3;
	Label Fname, viewCnum, Mname, Email, Salary, DOB, Label;
	public JTextField fnameField, CnumeField, MnameField, emailField, salaryField, dobField;
	public JButton SaveButton, CancelButton;

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("AirBnB.com");
		
		
// LOGO ONLY FOR HOMEPAGE
		Image logo = new Image("file:ProjPics/logo.jpg");
		ImageView viewlogo = new ImageView(logo);
		viewlogo.setFitHeight(70);
		viewlogo.setFitWidth(120);
		viewlogo.setImage(logo);
		
		HBox logo1 =  new HBox(0);
		logo1.getChildren().addAll(viewlogo);
		logo1.setPrefSize(400, 800);
			

//==============================================================================================================================================================		

//INPUT BUTTONS FOR NY HOUSE 1
		
	
		
		
		// Radio Buttons for Available Date Picking
		RadioButton r1 = new RadioButton("04/24/2021");
		r1.setTextFill(Color.WHITE);
		RadioButton r2 = new RadioButton("05/21/2021");
		r2.setTextFill(Color.WHITE);
		RadioButton r3 = new RadioButton("06/02/2021");
		r3.setTextFill(Color.WHITE);
		
		// Group All Toggle Buttons together
		ToggleGroup t = new ToggleGroup(); 
		r1.setToggleGroup(t);
		r2.setToggleGroup(t);
		r3.setToggleGroup(t);
		
	
		
		// Fill-in Portion
	       Label Fname = new Label ("Full Name");
	       Fname.setTextFill(Color.WHITE);
	       TextField Fname1 = new TextField();
	       Fname1.setPrefWidth(80);
	       Fname1.setMaxWidth(150);
	       Fname1.setPromptText("Full Name");
	       HBox TF = new HBox(10);
	       TF.getChildren().addAll(Fname, Fname1);
	       
	       Label Cnume = new Label ("Card Number / EXP Date / CVV");
	       Cnume.setTextFill(Color.WHITE);
	       TextField viewCnum = new TextField();
	       viewCnum.setMaxWidth(150);
	       viewCnum.setPrefWidth(80);
	       viewCnum.setMaxWidth(150);
	       viewCnum.setTranslateX(0);
	       viewCnum.setPromptText("Card Number / EXP Date / CVV");
	       Cnume.setTranslateX(0);
	       
	       Label Rent = new Label ("Number of Days to rent");
	       Rent.setTextFill(Color.WHITE);
	       TextField Rent1 = new TextField();
	       Rent1.setMaxWidth(150);
	       Rent1.setPrefWidth(80);
	       Rent1.setMaxWidth(150);
	       Rent1.setTranslateX(0);
	       Rent1.setPromptText("Number of days to rent");
	       Rent.setTranslateX(0);
	      
	       
	       
	      
	     //submit button
			subB = new Button();
			subB.setText(" Submit ");   
			subB.setPrefHeight(50);
			subB.setPrefWidth(90);
	        subB.setOnAction(new EventHandler<ActionEvent>() 
	        
	        
	        {
	            @Override public void handle(ActionEvent e)
	            {
	    	        if (Fname1.getText().isEmpty())
	    	        {
	    	        	Fname1.setPromptText("MUST ENTER NAME. ");
	    	        }
	    	        if (viewCnum.getText().isEmpty())
	    	        {
	    	        	viewCnum.setPromptText("MUST ENTER CARD INFO. ");
	    	        }
	    	        if (Rent1.getText().isEmpty())
	    	        {
	    	        	Rent1.setPromptText("MUST ENTER DAYS ");
	    	        }
	    	        else
	    	        {
	    	      
	   	        	
	    	        	Platform.runLater(new Runnable() 
	   				 {
	   				        public void run() 
	   				        {
	   				        	String rs=null;
	   				            SocketUtils su = new SocketUtils();
	   				            
	   				            if (su.socketConnect() == true) //this always seems to be false for whatever reason
	   				            {
	   				            	String strDouble = String.format("%.2f");
	   				            	String msg = "Transaction>AirBNB#001" + "," + strDouble;
	               	                su.sendMessage(msg);				            	
	               	                String ackOrNack = su.recvMessage();
	               	                
	               	                
	               	                msg = "quit";
	               	                su.sendMessage(msg);
	               	                rs = su.recvMessage();
	               	                
	               	                
	               	                //
	               	                // close the socket connection
	               	                //
	               	                su.closeSocket();
	               	                
	               	                // 
	               	                // write to transaction log
	               	                //
	               	                msg = "CLIENT : Transaction>kiosk#001" + "," + "," + strDouble;
	               	               FileIO trans = new FileIO();
	               	                trans.wrTransactionData(msg);
	               	                
	         
	               	                
	               	                
	               	                TextInputControl ta2 = null;
	   								if (ackOrNack.startsWith("ACK") == true)
	               	                {
	               	                	ta2.setText("Success, message was received!");
	               	                }
	               	                else
	               	                {
	               	                   ta2.setText("RECV : " + ackOrNack);
	               	                   ta2.appendText(rs);
	               	                }
	   				            }
	   				            else
	   				            {
	   				            	// 
	               	                // write to transaction log
	               	                //
	   				            	String strDouble = String.format("%.2f");
	               	                String msg = "CLIENT NETWORK ERROR : Transaction>kiosk#001" + "," + strDouble;
	               	                
	               	                FileIO trans = new FileIO();
	               	                trans.wrTransactionData(msg);
	               	                
	               	                
	   				            	Alert alert = new Alert(Alert.AlertType.ERROR);
	   						        alert.setTitle("--- Network Communications Error ---");
	   						        alert.setHeaderText("Unable to talk to Socket Server!");
	   						          
	   						        alert.showAndWait();
	   				            }
	   				        }
	   				    });	
	    	        }
	            }
	        });

			subB.setTranslateX(0);
			subB.setTranslateY(0);
			subB.setPrefHeight(50);
			subB.setPrefWidth(90);

			
//==============================================================================================================================================================		
			
			
			//INPUT BUTTONS FOR NY HOUSE 2
			
			
			// Radio Buttons for Available Date Picking
			RadioButton rr1 = new RadioButton("06/27/2021");
			rr1.setTextFill(Color.WHITE);
			RadioButton rr2 = new RadioButton("07/21/2021");
			rr2.setTextFill(Color.WHITE);
			RadioButton rr3 = new RadioButton("08/02/2021");
			rr3.setTextFill(Color.WHITE);
			
			// Group All Toggle Buttons together
			ToggleGroup tt = new ToggleGroup(); 
			rr1.setToggleGroup(tt);
			rr2.setToggleGroup(tt);
			rr3.setToggleGroup(tt);
			
		
			
			// Fill-in Portion
		       Label FnameB = new Label ("Full Name");
		       FnameB.setFont(Font.font(18));
		       FnameB.setTextFill(Color.WHITE);
		       TextField Fname1B = new TextField();
		       Fname1B.setPrefWidth(80);
		       Fname1B.setMaxWidth(150);
		       Fname1B.setPromptText("Full Name");
		      
		      
		       
		       Label Cnume1 = new Label ("Card Number / EXP Date / CVV");
		       Cnume1.setTextFill(Color.WHITE);
		       TextField viewCnum1 = new TextField();
		       viewCnum1.setMaxWidth(150);
		       viewCnum1.setPrefWidth(80);
		       viewCnum1.setMaxWidth(150);
		       viewCnum1.setTranslateX(0);
		       viewCnum1.setPromptText("Card Number / EXP Date / CVV");
		       Cnume1.setTranslateX(0);
		       
		       Label RentB = new Label ("Number of Days to rent");
		       RentB.setTextFill(Color.WHITE);
		       TextField Rent1B = new TextField();
		       Rent1B.setMaxWidth(150);
		       Rent1B.setPrefWidth(80);
		       Rent1B.setMaxWidth(150);
		       Rent1B.setTranslateX(0);
		       Rent1B.setPromptText("Number of days to rent");
		       RentB.setTranslateX(0);
		      
		     
		       
		      
		     //submit button
				Button subB2 = new Button();

				
				subB2.setText(" Submit ");   
				subB2.setPrefHeight(50);
				subB2.setPrefWidth(90);
		        subB2.setOnAction(new EventHandler<ActionEvent>()
		        {
		            @Override public void handle(ActionEvent e)
		            {
		    	        if (Fname1B.getText().isEmpty())
		    	        {
		    	        	Fname1B.setPromptText("MUST ENTER NAME. ");
		    	        }
		    	        if (viewCnum1.getText().isEmpty())
		    	        {
		    	        	viewCnum1.setPromptText("MUST ENTER CARD INFO. ");
		    	        }
		    	        if (Rent1B.getText().isEmpty())
		    	        {
		    	        	Rent1B.setPromptText("MUST ENTER DAYS ");
		    	        }
		    	        else
		    	        {
		    	        	
		    	 	    	        	
		    	 	    	        	
		 
		   	        	
		    	        	Platform.runLater(new Runnable() 
		   				 {
		   				        public void run() 
		   				        {
		   							double total=0.0;
		   							int    numOfItems=0;
		   				        	
		   				        	String rs=null;
		   				            SocketUtils su = new SocketUtils();
		   				            
		   				            if (su.socketConnect() == true) //this always seems to be false for whatever reason
		   				            {
		   				            	String strDouble = String.format("%.2f", total);
		   				            	String msg = "Transaction>kiosk#001" + "," + numOfItems + "," + strDouble;
		               	                su.sendMessage(msg);				            	
		               	                String ackOrNack = su.recvMessage();
		               	                String name = Fname1B.getText().toString();
		               	                String cc = viewCnum1.getText().toString();
		               	                String date = Rent1B.getText().toString();
		               	                su.sendMessage(name);
		               	                su.sendMessage(cc);
		               	                su.sendMessage(date);
		               	                
		               	                
		               	                msg = "quit";
		               	                su.sendMessage(msg);
		               	                rs = su.recvMessage();
		               	                
		               	                
		               	                //
		               	                // close the socket connection
		               	                //
		               	                su.closeSocket();
		               	                
		               	                // 
		               	                // write to transaction log
		               	                //
		               	                msg = "CLIENT : Transaction>kiosk#001" + "," + numOfItems + "," + strDouble;
		               	                FileIO trans = new FileIO();
		               	                trans.wrTransactionData(msg);
		               	                
		               	                
		               	                // initialize variables back to zero
		               	                total=0.0;
		               	                numOfItems=0;        
		               	                
		               	             Fname1B.setText("");
		               	             viewCnum1.setText("");
		               	             Rent1B.setText("");
		               	                
		               	                if (ackOrNack.startsWith("") == true)
		               	                {
		               	                	Fname1B.setText("Recieved");
		               	                	viewCnum1.setText("Recieved");
		               	                	Rent1B.setText("Recieved");
		               	                }
		               	                else
		               	                {
		               	                	Fname1B.setText("Name: " + ackOrNack);
		               	                	viewCnum1.setText("Credit Card Number: " + ackOrNack);
		               	                	RentB.setText("Days: " + ackOrNack);
		               	                	Fname1B.appendText(rs);
		               	                }
		   				            }
		   				            else
		   				            {
		   				            	// 
		               	                // write to transaction log
		               	                //
		   				            	String strDouble = String.format("%.2f", total);
		               	                String msg = "CLIENT NETWORK ERROR : Transaction> AirBNB #001" + "," + numOfItems + "," + strDouble;
		               	                
		               	                FileIO trans = new FileIO();
		               	                trans.wrTransactionData(msg);
		               	                
		               	                
		   				            	Alert alert = new Alert(Alert.AlertType.ERROR);
		   						        alert.setTitle("--- Network Communications Error ---");
		   						        alert.setHeaderText("Unable to talk to Socket Server!");
		   						          
		   						        alert.showAndWait();
		   				            }
		   				        }
		   				    });

		    	        }
		            }
		        });
		        

				subB2.setTranslateX(0);
				subB2.setTranslateY(0);
				subB2.setPrefHeight(50);
				subB2.setPrefWidth(90);
				
				// VBOX WIT ALL THE FIELDS FOR THE FINAL VBOX AT THE END OF CODE
				VBox All1 = new VBox(18);
				All1.getChildren().addAll(FnameB, Fname1B, Cnume1, viewCnum1, RentB, Rent1B, subB2); 



				
//==============================================================================================================================================================		

				//INPUT BUTTONS FOR MI HOUSE 1
				
				
				// Radio Buttons for Available Date Picking
				RadioButton fl1 = new RadioButton("08/21/2021");
				fl1.setTextFill(Color.WHITE);
				RadioButton fl2 = new RadioButton("07/18/2021");
				fl2.setTextFill(Color.WHITE);
				RadioButton fl3 = new RadioButton("05/08/2021");
				fl3.setTextFill(Color.WHITE);
				
				// Group All Toggle Buttons together
				ToggleGroup flo = new ToggleGroup(); 
				fl1.setToggleGroup(flo);
				fl2.setToggleGroup(flo);
				fl3.setToggleGroup(flo);
				
			
				
				// Fill-in Portion
			       Label FnameC = new Label ("Full Name");
			       FnameC.setFont(Font.font(18));
			       FnameC.setTextFill(Color.WHITE);
			       TextField Fname1C = new TextField();
			       Fname1C.setPrefWidth(80);
			       Fname1C.setMaxWidth(150);
			       Fname1C.setPromptText("Full Name");
			      
			      
			       
			       Label Cnume1C = new Label ("Card Number / EXP Date / CVV");
			       Cnume1C.setTextFill(Color.WHITE);
			       TextField viewCnum1C = new TextField();
			       viewCnum1C.setMaxWidth(150);
			       viewCnum1C.setPrefWidth(80);
			       viewCnum1C.setMaxWidth(150);
			       viewCnum1C.setTranslateX(0);
			       viewCnum1C.setPromptText("Card Number / EXP Date / CVV");
			       Cnume1C.setTranslateX(0);
			       
			       Label RentC = new Label ("Number of Days to rent");
			       RentC.setTextFill(Color.WHITE);
			       TextField Rent1C = new TextField();
			       Rent1C.setMaxWidth(150);
			       Rent1C.setPrefWidth(80);
			       Rent1C.setMaxWidth(150);
			       Rent1C.setTranslateX(0);
			       Rent1C.setPromptText("Number of days to rent");
			       RentC.setTranslateX(0);
			      
			     
			       
			      
			     //submit button
					Button subB3 = new Button();
					subB3.setText(" Submit ");   
					subB3.setPrefHeight(50);
					subB3.setPrefWidth(90);
			        subB3.setOnAction(new EventHandler<ActionEvent>() 
			        
			        
			        {
			            @Override public void handle(ActionEvent e)
			            {
			    	        if (Fname1C.getText().isEmpty())
			    	        {
			    	        	Fname1C.setPromptText("MUST ENTER NAME. ");
			    	        }
			    	        if (viewCnum1C.getText().isEmpty())
			    	        {
			    	        	viewCnum1C.setPromptText("MUST ENTER CARD INFO. ");
			    	        }
			    	        if (Rent1C.getText().isEmpty())
			    	        {
			    	        	Rent1C.setPromptText("MUST ENTER DAYS ");
			    	        }
			    	        else
			    	        {
			    	        	
			    	 	    	        	
			    	 	    	        	
			 
			   	        	
			    	        	Platform.runLater(new Runnable() 
				   				 {
				   				        public void run() 
				   				        {
				   							double total=0.0;
				   							int    numOfItems=0;
				   				        	
				   				        	String rs=null;
				   				            SocketUtils su = new SocketUtils();
				   				            
				   				            if (su.socketConnect() == true) //this always seems to be false for whatever reason
				   				            {
				   				            	String strDouble = String.format("%.2f", total);
				   				            	String msg = "Transaction>kiosk#001" + "," + numOfItems + "," + strDouble;
				               	                su.sendMessage(msg);				            	
				               	                String ackOrNack = su.recvMessage();
				               	                String name = Fname1C.getText().toString();
				               	                String cc = viewCnum1.getText().toString();
				               	                String date = Rent1C.getText().toString();
				               	                su.sendMessage(name);
				               	                su.sendMessage(cc);
				               	                su.sendMessage(date);
				               	                
				               	                
				               	                msg = "quit";
				               	                su.sendMessage(msg);
				               	                rs = su.recvMessage();
				               	                
				               	                
				               	                //
				               	                // close the socket connection
				               	                //
				               	                su.closeSocket();
				               	                
				               	                // 
				               	                // write to transaction log
				               	                //
				               	                msg = "CLIENT : Transaction>kiosk#001" + "," + numOfItems + "," + strDouble;
				               	                FileIO trans = new FileIO();
				               	                trans.wrTransactionData(msg);
				               	                
				               	                
				               	                // initialize variables back to zero
				               	                total=0.0;
				               	                numOfItems=0;        
				               	                
				               	             Fname1C.setText("");
				               	             viewCnum1.setText("");
				               	             Rent1C.setText("");
				               	                
				               	                if (ackOrNack.startsWith("") == true)
				               	                {
				               	                	Fname1C.setText("Recieved");
				               	                	viewCnum1.setText("Recieved");
				               	                	Rent1C.setText("Recieved");
				               	                }
				               	                else
				               	                {
				               	                	Fname1C.setText("Name: " + ackOrNack);
				               	                	viewCnum1.setText("Credit Card Number: " + ackOrNack);
				               	                	RentB.setText("Days: " + ackOrNack);
				               	                	Fname1C.appendText(rs);
				               	                }
				   				            }
				   				            else
				   				            {
				   				            	// 
				               	                // write to transaction log
				               	                //
				   				            	String strDouble = String.format("%.2f", total);
				               	                String msg = "CLIENT NETWORK ERROR : Transaction> AirBNB #001" + "," + numOfItems + "," + strDouble;
				               	                
				               	                FileIO trans = new FileIO();
				               	                trans.wrTransactionData(msg);
				               	                
				               	                
				   				            	Alert alert = new Alert(Alert.AlertType.ERROR);
				   						        alert.setTitle("--- Network Communications Error ---");
				   						        alert.setHeaderText("Unable to talk to Socket Server!");
				   						          
				   						        alert.showAndWait();
				   				            }
				   				        }
				   				    });
			    	        }
			            }
			        });

					subB3.setTranslateX(0);
					subB3.setTranslateY(0);
					subB3.setPrefHeight(50);
					subB3.setPrefWidth(90);
					
					// VBOX WIT ALL THE FIELDS FOR THE FINAL VBOX AT THE END OF CODE
					VBox All2 = new VBox(18);
					All2.getChildren().addAll(FnameC, Fname1C, Cnume1C, viewCnum1C, RentC, Rent1C, subB3);
					

//==============================================================================================================================================================		

					//INPUT BUTTONS FOR MI HOUSE 2
					
					
					// Radio Buttons for Available Date Picking
					RadioButton fl4 = new RadioButton("08/21/2021");
					fl4.setTextFill(Color.WHITE);
					RadioButton fl5 = new RadioButton("07/18/2021");
					fl5.setTextFill(Color.WHITE);
					RadioButton fl6 = new RadioButton("05/08/2021");
					fl6.setTextFill(Color.WHITE);
					
					// Group All Toggle Buttons together
					ToggleGroup flo2 = new ToggleGroup(); 
					fl4.setToggleGroup(flo2);
					fl5.setToggleGroup(flo2);
					fl6.setToggleGroup(flo2);
					
				
					
					// Fill-in Portion
				       Label FnameD = new Label ("Full Name");
				       FnameD.setFont(Font.font(18));
				       FnameD.setTextFill(Color.WHITE);
				       TextField Fname1D = new TextField();
				       Fname1D.setPrefWidth(80);
				       Fname1D.setMaxWidth(150);
				       Fname1D.setPromptText("Full Name");
				      
				      
				       
				       Label Cnume1D = new Label ("Card Number / EXP Date / CVV");
				       Cnume1D.setTextFill(Color.WHITE);
				       TextField viewCnum1D = new TextField();
				       viewCnum1D.setMaxWidth(150);
				       viewCnum1D.setPrefWidth(80);
				       viewCnum1D.setMaxWidth(150);
				       viewCnum1D.setTranslateX(0);
				       viewCnum1D.setPromptText("Card Number / EXP Date / CVV");
				       Cnume1D.setTranslateX(0);
				       
				       Label RentD = new Label ("Number of Days to rent");
				       RentD.setTextFill(Color.WHITE);
				       TextField Rent1D = new TextField();
				       Rent1D.setMaxWidth(150);
				       Rent1D.setPrefWidth(80);
				       Rent1D.setMaxWidth(150);
				       Rent1D.setTranslateX(0);
				       Rent1D.setPromptText("Number of days to rent");
				       RentD.setTranslateX(0);
				      
				     
				       
				      
				     //submit button
						Button subB4 = new Button();
						subB4.setText(" Submit ");   
						subB4.setPrefHeight(50);
						subB4.setPrefWidth(90);
				        subB4.setOnAction(new EventHandler<ActionEvent>() 
				        
				        
				        {
				            @Override public void handle(ActionEvent e)
				            {
				    	        if (Fname1D.getText().isEmpty())
				    	        {
				    	        	Fname1D.setPromptText("MUST ENTER NAME. ");
				    	        }
				    	        if (viewCnum1D.getText().isEmpty())
				    	        {
				    	        	viewCnum1D.setPromptText("MUST ENTER CARD INFO. ");
				    	        }
				    	        if (Rent1D.getText().isEmpty())
				    	        {
				    	        	Rent1D.setPromptText("MUST ENTER DAYS ");
				    	        }
				    	        else
				    	        {
				    	        	
				    	 	    	        	
				    	 	    	        	
				 
				   	        	
				    	           	Platform.runLater(new Runnable() 
				   				    {
				   				        public void run() 
				   				        {
				   				        	String rs=null;
				   				            Server su = new Server(null, rs);
				   				            
				   				            if (su.socketConnect() == true) //this always seems to be false for whatever reason
				   				            {
				   				            	String strDouble = String.format("%.2f");
				   				            	String msg = "Transaction>kiosk#0500000" + "," + "1" + "," + strDouble;
				               	                su.sendMessage(msg);				            	
				               	                String ackOrNack = su.recvMessage();
				               	                
				               	                
				               	                msg = "quit";
				               	                su.sendMessage(msg);
				               	                rs = su.recvMessage();
				               	                
				               	                
				               	                //
				               	                // close the socket connection
				               	                //
				               	                su.closeSocket();
				               	                
				               	                
				               	              
				               	                
				               	                ta.setText("");
				               	                ta2.setText("");
				               	                
				               	                if (ackOrNack.startsWith("ACK") == true)
				               	                {
				               	                	ta2.setText("Success!    Message was received and processed by the Socket Server!");
				               	                }
				               	                else
				               	                {
				               	                   ta2.setText("RECV : " + ackOrNack);
				               	                   ta2.appendText(rs);
				               	                }
				   				            }
				   				            else
				   				            {
				   				            	Alert alert = new Alert(Alert.AlertType.ERROR);
				   						        alert.setTitle("--- Network Communications Error ---");
				   						        alert.setHeaderText("Unable to talk to Socket Server!");
				   						          
				   						        alert.showAndWait();
				   				            }
				   				        }
				   				    });	
				    	        }
				            }
				        });

						subB4.setTranslateX(0);
						subB4.setTranslateY(0);
						subB4.setPrefHeight(50);
						subB4.setPrefWidth(90);
						
						// VBOX WIT ALL THE FIELDS FOR THE FINAL VBOX AT THE END OF CODE
						VBox All3 = new VBox(18);
						All3.getChildren().addAll(FnameD, Fname1D, Cnume1D, viewCnum1D, RentD, Rent1D, subB4);
					
					
					
//==============================================================================================================================================================		

						
						//INPUT BUTTONS FOR LA HOUSE 1
						
						
						// Radio Buttons for Available Date Picking
						RadioButton ca1 = new RadioButton("09/21/2021");
						ca1.setTextFill(Color.WHITE);
						RadioButton ca2 = new RadioButton("10/18/2021");
						ca2.setTextFill(Color.WHITE);
						RadioButton ca3 = new RadioButton("11/08/2021");
						ca3.setTextFill(Color.WHITE);
						
						// Group All Toggle Buttons together
						ToggleGroup cal = new ToggleGroup(); 
						ca1.setToggleGroup(cal);
						ca2.setToggleGroup(cal);
						ca3.setToggleGroup(cal);
						
					
						
						// Fill-in Portion
					       Label FnameE = new Label ("Full Name");
					       FnameE.setFont(Font.font(18));
					       FnameE.setTextFill(Color.WHITE);
					       TextField Fname1E = new TextField();
					       Fname1E.setPrefWidth(80);
					       Fname1E.setMaxWidth(150);
					       Fname1E.setPromptText("Full Name");
					      
					      
					       
					       Label Cnume1E = new Label ("Card Number / EXP Date / CVV");
					       Cnume1E.setTextFill(Color.WHITE);
					       TextField viewCnum1E = new TextField();
					       viewCnum1E.setMaxWidth(150);
					       viewCnum1E.setPrefWidth(80);
					       viewCnum1E.setMaxWidth(150);
					       viewCnum1E.setTranslateX(0);
					       viewCnum1E.setPromptText("Card Number / EXP Date / CVV");
					       Cnume1E.setTranslateX(0);
					       
					       Label RentE = new Label ("Number of Days to rent");
					       RentE.setTextFill(Color.WHITE);
					       TextField Rent1E = new TextField();
					       Rent1E.setMaxWidth(150);
					       Rent1E.setPrefWidth(80);
					       Rent1E.setMaxWidth(150);
					       Rent1E.setTranslateX(0);
					       Rent1E.setPromptText("Number of days to rent");
					       RentE.setTranslateX(0);
					      
					     
					       
					      
					     //submit button
							Button subB5 = new Button();
							subB5.setText(" Submit ");   
							subB5.setPrefHeight(50);
							subB5.setPrefWidth(90);
					        subB5.setOnAction(new EventHandler<ActionEvent>() 
					        
					        
					        {
					            @Override public void handle(ActionEvent e)
					            {
					    	        if (Fname1E.getText().isEmpty())
					    	        {
					    	        	Fname1E.setPromptText("MUST ENTER NAME. ");
					    	        }
					    	        if (viewCnum1E.getText().isEmpty())
					    	        {
					    	        	viewCnum1E.setPromptText("MUST ENTER CARD INFO. ");
					    	        }
					    	        if (Rent1E.getText().isEmpty())
					    	        {
					    	        	Rent1E.setPromptText("MUST ENTER DAYS ");
					    	        }
					    	        else
					    	        {
					    	        	
					    	 	    	        	
					    	 	    	        	
					 
					   	        	
					    	           	Platform.runLater(new Runnable() 
					   				    {
					   				        public void run() 
					   				        {
					   				        	String rs=null;
					   				            Server su = new Server(null, rs);
					   				            
					   				            if (su.socketConnect() == true) //this always seems to be false for whatever reason
					   				            {
					   				            	String strDouble = String.format("%.2f");
					   				            	String msg = "Transaction>kiosk#0500000" + "," + "1" + "," + strDouble;
					               	                su.sendMessage(msg);				            	
					               	                String ackOrNack = su.recvMessage();
					               	                
					               	                
					               	                msg = "quit";
					               	                su.sendMessage(msg);
					               	                rs = su.recvMessage();
					               	                
					               	                
					               	                //
					               	                // close the socket connection
					               	                //
					               	                su.closeSocket();
					               	                
					               	                
					               	              
					               	                
					               	                ta.setText("");
					               	                ta2.setText("");
					               	                
					               	                if (ackOrNack.startsWith("ACK") == true)
					               	                {
					               	                	ta2.setText("Success!    Message was received and processed by the Socket Server!");
					               	                }
					               	                else
					               	                {
					               	                   ta2.setText("RECV : " + ackOrNack);
					               	                   ta2.appendText(rs);
					               	                }
					   				            }
					   				            else
					   				            {
					   				            	Alert alert = new Alert(Alert.AlertType.ERROR);
					   						        alert.setTitle("--- Network Communications Error ---");
					   						        alert.setHeaderText("Unable to talk to Socket Server!");
					   						          
					   						        alert.showAndWait();
					   				            }
					   				        }
					   				    });	
					    	        }
					            }
					        });

							subB5.setTranslateX(0);
							subB5.setTranslateY(0);
							subB5.setPrefHeight(50);
							subB5.setPrefWidth(90);
							
							// VBOX WIT ALL THE FIELDS FOR THE FINAL VBOX AT THE END OF CODE
							VBox All4 = new VBox(18);
							All4.getChildren().addAll(FnameE, Fname1E, Cnume1E, viewCnum1E, RentE, Rent1E, subB5);						
						
						
						
//==============================================================================================================================================================		
						
							//INPUT BUTTONS FOR LA HOUSE 2
							
							
							// Radio Buttons for Available Date Picking
							RadioButton ca4 = new RadioButton("04/21/2021");
							ca4.setTextFill(Color.WHITE);
							RadioButton ca5 = new RadioButton("05/08/2021");
							ca5.setTextFill(Color.WHITE);
							RadioButton ca6 = new RadioButton("06/28/2021");
							ca6.setTextFill(Color.WHITE);
							
							// Group All Toggle Buttons together
							ToggleGroup cal2 = new ToggleGroup(); 
							ca4.setToggleGroup(cal2);
							ca5.setToggleGroup(cal2);
							ca6.setToggleGroup(cal2);
							
						
							
							// Fill-in Portion
						       Label FnameF = new Label ("Full Name");
						       FnameF.setFont(Font.font(18));
						       FnameF.setTextFill(Color.WHITE);
						       TextField Fname1F = new TextField();
						       Fname1F.setPrefWidth(80);
						       Fname1F.setMaxWidth(150);
						       Fname1F.setPromptText("Full Name");
						      
						      
						       
						       Label Cnume1F = new Label ("Card Number / EXP Date / CVV");
						       Cnume1F.setTextFill(Color.WHITE);
						       TextField viewCnum1F = new TextField();
						       viewCnum1F.setMaxWidth(150);
						       viewCnum1F.setPrefWidth(80);
						       viewCnum1F.setMaxWidth(150);
						       viewCnum1F.setTranslateX(0);
						       viewCnum1F.setPromptText("Card Number / EXP Date / CVV");
						       Cnume1F.setTranslateX(0);
						       
						       Label RentF = new Label ("Number of Days to rent");
						       RentF.setTextFill(Color.WHITE);
						       TextField Rent1F = new TextField();
						       Rent1F.setMaxWidth(150);
						       Rent1F.setPrefWidth(80);
						       Rent1F.setMaxWidth(150);
						       Rent1F.setTranslateX(0);
						       Rent1F.setPromptText("Number of days to rent");
						       RentF.setTranslateX(0);
						      
						     
						       
						      
						     //submit button
								Button subB6 = new Button();
								subB6.setText(" Submit ");   
								subB6.setPrefHeight(50);
								subB6.setPrefWidth(90);
						        subB6.setOnAction(new EventHandler<ActionEvent>() 
						        
						        
						        {
						            @Override public void handle(ActionEvent e)
						            {
						    	        if (Fname1F.getText().isEmpty())
						    	        {
						    	        	Fname1F.setPromptText("MUST ENTER NAME. ");
						    	        }
						    	        if (viewCnum1F.getText().isEmpty())
						    	        {
						    	        	viewCnum1F.setPromptText("MUST ENTER CARD INFO. ");
						    	        }
						    	        if (Rent1F.getText().isEmpty())
						    	        {
						    	        	Rent1F.setPromptText("MUST ENTER DAYS ");
						    	        }
						    	        else
						    	        {
						    	        	
						    	 	    	        	
						    	 	    	        	
						 
						   	        	
						    	           	Platform.runLater(new Runnable() 
						   				    {
						   				        public void run() 
						   				        {
						   				        	String rs=null;
						   				            Server su = new Server(null, rs);
						   				            
						   				            if (su.socketConnect() == true) //this always seems to be false for whatever reason
						   				            {
						   				            	String strDouble = String.format("%.2f");
						   				            	String msg = "Transaction>kiosk#0500000" + "," + "1" + "," + strDouble;
						               	                su.sendMessage(msg);				            	
						               	                String ackOrNack = su.recvMessage();
						               	                
						               	                
						               	                msg = "quit";
						               	                su.sendMessage(msg);
						               	                rs = su.recvMessage();
						               	                
						               	                
						               	                //
						               	                // close the socket connection
						               	                //
						               	                su.closeSocket();
						               	                
						               	                
						               	              
						               	                
						               	                ta.setText("");
						               	                ta2.setText("");
						               	                
						               	                if (ackOrNack.startsWith("ACK") == true)
						               	                {
						               	                	ta2.setText("Success!    Message was received and processed by the Socket Server!");
						               	                }
						               	                else
						               	                {
						               	                   ta2.setText("RECV : " + ackOrNack);
						               	                   ta2.appendText(rs);
						               	                }
						   				            }
						   				            else
						   				            {
						   				            	Alert alert = new Alert(Alert.AlertType.ERROR);
						   						        alert.setTitle("--- Network Communications Error ---");
						   						        alert.setHeaderText("Unable to talk to Socket Server!");
						   						          
						   						        alert.showAndWait();
						   				            }
						   				        }
						   				    });	
						    	        }
						            }
						        });

								subB6.setTranslateX(0);
								subB6.setTranslateY(0);
								subB6.setPrefHeight(50);
								subB6.setPrefWidth(90);
								
								// VBOX WIT ALL THE FIELDS FOR THE FINAL VBOX AT THE END OF CODE
								VBox All5 = new VBox(18);
								All5.getChildren().addAll(FnameF, Fname1F, Cnume1F, viewCnum1F, RentF, Rent1F, subB6);	
								
							
//==============================================================================================================================================================		

	// Help Button for Main Page
	
								 Button help = new Button("Help");
								    help.setFont(new Font("Courier", 12));
							        help.setOnAction(new EventHandler<ActionEvent>() 
							        {
							            @Override public void handle(ActionEvent e)
							            { 	
							            	Platform.runLater(new Runnable()
							            	{		
							            		public void run()
							            		{
							            			Alert alert = new Alert(Alert.AlertType.INFORMATION);
							            			alert.setTitle("AIRBNB HELP WINDOW");
							            			alert.setHeaderText("HOW TO USE APPLICATION");
							            			alert.setHeight(400);
							            			alert.setWidth(900);
							            			alert.setResizable(true);
							            			
							            			String h = "TO USE THIS APPLICATION SELECT A CITY YOU WISH TO TRAVEL TO \r \n" +
							            					   "THEN SELECT THE AVAILABLE HOMES \r \n" +
							            					    "ENTER THE INFORMATION REQUESTED AND CLICK SUBMIT \r \n" +
							            					   "TO EXIT, CLICK EXIT OTHERWISE KEEP BROWSING! \r \n";
							            			
							            			alert.setContentText(h);
							            			alert.showAndWait();
							            		}
							            	});
							            	
							            }
							        });

							        help.setPrefHeight(50);
									help.setPrefWidth(90);
								
									help.setStyle("-fx-background-color: #FFFF00 ");
								
								
//==============================================================================================================================================================		

						
						
	// ALL EXIT BUTTONS THUS FAR
				
		// Exit Button Code 1
		exitB = new Button();
		exitB.setText(" Exit ");
		exitB.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override public void handle(ActionEvent e)
            { 	
            	Platform.runLater(new Runnable()
            		{
            			public void run()
            			{
            				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            				
            				alert.setTitle("EXIT CONFIRMATION");
            				alert.setHeaderText("Confirm Exit");
            				alert.setContentText("Are you sure you want to exit from the program?");
            				
            				Optional<ButtonType> result = alert.showAndWait();  
            				
            				if (result.get() == ButtonType.OK)
            				{
            					System.exit(0);
            				}
            				
            				else
            				{
            		
            						
            				}
            		
            		}
            	});
            }
            	
            
        });
		
		exitB.setTranslateX(0);
		exitB.setTranslateY(0);
		exitB.setPrefHeight(50);
		exitB.setPrefWidth(90);
		
		
		
		// Exit button exitB2
		Button exitB2 = new Button();
		exitB2.setText(" Exit ");
		exitB2.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override public void handle(ActionEvent e)
            { 	
            	Platform.runLater(new Runnable()
            		{
            			public void run()
            			{
            				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            				
            				alert.setTitle("EXIT CONFIRMATION");
            				alert.setHeaderText("Confirm Exit");
            				alert.setContentText("Are you sure you want to exit from the program?");
            				
            				Optional<ButtonType> result = alert.showAndWait();  
            				
            				if (result.get() == ButtonType.OK)
            				{
            					System.exit(0);
            				}
            				
            				else
            				{
            		
            						
            				}
            		
            		}
            	});
            }
            	
            
        });
		
		exitB2.setTranslateX(0);
		exitB2.setTranslateY(0);
		exitB2.setPrefHeight(50);
		exitB2.setPrefWidth(90);
		
		
		// Exit Button exitB3
		Button exitB3 = new Button();
		exitB3.setText(" Exit ");
		exitB3.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override public void handle(ActionEvent e)
            { 	
            	Platform.runLater(new Runnable()
            		{
            			public void run()
            			{
            				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            				
            				alert.setTitle("EXIT CONFIRMATION");
            				alert.setHeaderText("Confirm Exit");
            				alert.setContentText("Are you sure you want to exit from the program?");
            				
            				Optional<ButtonType> result = alert.showAndWait();  
            				
            				if (result.get() == ButtonType.OK)
            				{
            					System.exit(0);
            				}
            				
            				else
            				{
            		
            						
            				}
            		
            		}
            	});
            }
            	
            
        });
		exitB3.setTranslateX(0);
		exitB3.setTranslateY(0);
		exitB3.setPrefHeight(50);
		exitB3.setPrefWidth(90);
		
		
		
		// Exit Button exitB4
				Button exitB4 = new Button();
				exitB4.setText(" Exit ");
				exitB4.setOnAction(new EventHandler<ActionEvent>() 
		        {
		            @Override public void handle(ActionEvent e)
		            { 	
		            	Platform.runLater(new Runnable()
		            		{
		            			public void run()
		            			{
		            				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		            				
		            				alert.setTitle("EXIT CONFIRMATION");
		            				alert.setHeaderText("Confirm Exit");
		            				alert.setContentText("Are you sure you want to exit from the program?");
		            				
		            				Optional<ButtonType> result = alert.showAndWait();  
		            				
		            				if (result.get() == ButtonType.OK)
		            				{
		            					System.exit(0);
		            				}
		            				
		            				else
		            				{
		            		
		            						
		            				}
		            		
		            		}
		            	});
		            }
		            	
		            
		        });
				exitB4.setTranslateX(0);
				exitB4.setTranslateY(0);
				exitB4.setPrefHeight(50);
				exitB4.setPrefWidth(90);
				
				
				// Exit Button exitB5
				Button exitB5 = new Button();
				exitB5.setText(" Exit ");
				exitB5.setOnAction(new EventHandler<ActionEvent>() 
		        {
		            @Override public void handle(ActionEvent e)
		            { 	
		            	Platform.runLater(new Runnable()
		            		{
		            			public void run()
		            			{
		            				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		            				
		            				alert.setTitle("EXIT CONFIRMATION");
		            				alert.setHeaderText("Confirm Exit");
		            				alert.setContentText("Are you sure you want to exit from the program?");
		            				
		            				Optional<ButtonType> result = alert.showAndWait();  
		            				
		            				if (result.get() == ButtonType.OK)
		            				{
		            					System.exit(0);
		            				}
		            				
		            				else
		            				{
		            		
		            						
		            				}
		            		
		            		}
		            	});
		            }
		            	
		            
		        });
				exitB5.setTranslateX(0);
				exitB5.setTranslateY(0);
				exitB5.setPrefHeight(50);
				exitB5.setPrefWidth(90);
				
				
				
				// Exit Button exitB6
				Button exitB6 = new Button();
				exitB6.setText(" Exit ");
				exitB6.setOnAction(new EventHandler<ActionEvent>() 
		        {
		            @Override public void handle(ActionEvent e)
		            { 	
		            	Platform.runLater(new Runnable()
		            		{
		            			public void run()
		            			{
		            				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		            				
		            				alert.setTitle("EXIT CONFIRMATION");
		            				alert.setHeaderText("Confirm Exit");
		            				alert.setContentText("Are you sure you want to exit from the program?");
		            				
		            				Optional<ButtonType> result = alert.showAndWait();  
		            				
		            				if (result.get() == ButtonType.OK)
		            				{
		            					System.exit(0);
		            				}
		            				
		            				else
		            				{
		            		
		            						
		            				}
		            		
		            		}
		            	});
		            }
		            	
		            
		        });
				exitB6.setTranslateX(0);
				exitB6.setTranslateY(0);
				exitB6.setPrefHeight(50);
				exitB6.setPrefWidth(90);
				
				
				// Exit Button exitB7
				Button exitB7 = new Button();
				exitB7.setText(" Exit ");
				exitB7.setOnAction(new EventHandler<ActionEvent>() 
		        {
		            @Override public void handle(ActionEvent e)
		            { 	
		            	Platform.runLater(new Runnable()
		            		{
		            			public void run()
		            			{
		            				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		            				
		            				alert.setTitle("EXIT CONFIRMATION");
		            				alert.setHeaderText("Confirm Exit");
		            				alert.setContentText("Are you sure you want to exit from the program?");
		            				
		            				Optional<ButtonType> result = alert.showAndWait();  
		            				
		            				if (result.get() == ButtonType.OK)
		            				{
		            					System.exit(0);
		            				}
		            				
		            				else
		            				{
		            		
		            						
		            				}
		            		
		            		}
		            	});
		            }
		            	
		            
		        });
				exitB7.setTranslateX(0);
				exitB7.setTranslateY(0);
				exitB7.setPrefHeight(50);
				exitB7.setPrefWidth(90);
				
//==============================================================================================================================================================		

		// Code for NY House option 1 and its pictures
		Image NHouse1 = new Image("file:ProjPics/NYHome1.jpg" ); // Takes you to iMages of ny property
		ImageView viewNHouse1 = new ImageView(NHouse1);
		viewNHouse1.setFitHeight(200);
		viewNHouse1.setFitWidth(250);
		viewNHouse1.setImage(NHouse1);
		N2button = new Button("128 Greene Ave", viewNHouse1);
		N2button.setOnAction(e -> primaryStage.setScene(NY2)); 
		N2button.setStyle("-fx-background-color: #008B8B ");
		
		
		
		
		
		Image Nroom1 = new Image("file:ProjPics/NYroom1A.jpg" ); // NY HOUSE 1 , ROOM 1 IMG
		ImageView viewNroom1 = new ImageView(Nroom1);
		viewNroom1.setFitHeight(200);
		viewNroom1.setFitWidth(250);
		viewNroom1.setImage(Nroom1);
		
		Image Nroom2 = new Image("file:ProjPics/NYroom1B.jpg" );// NY HOUSE 1 , ROOM 2 IMG
		ImageView viewNRoom2 = new ImageView(Nroom2);
		viewNRoom2.setFitHeight(200);
		viewNRoom2.setFitWidth(250);
		viewNRoom2.setImage(Nroom2);
		
		Image Nroom3 = new Image("file:ProjPics/NYroom1C.jpg" );// NY HOUSE 1 , ROOM 2 IMG
		ImageView viewNRoom3 = new ImageView(Nroom2);
		viewNRoom3.setFitHeight(200);
		viewNRoom3.setFitWidth(250);
		viewNRoom3.setImage(Nroom3);
		
		homeB3 = new Button();
		homeB3.setText(" Home ");
		homeB3.setOnAction(e -> primaryStage.setScene(Home)); // Takes you to Home Page with the cities
		
		HBox Nrooms = new HBox(8);
		Nrooms.getChildren().addAll(viewNroom1, viewNRoom2, viewNRoom3);	
		
		
		
		
		
		// Code for NY House option 2 and its pictures
		Image NHouse2 = new Image("file:ProjPics/NYHome2.jpg" ); // Takes you to iMages of ny property
		ImageView viewNHouse2 = new ImageView(NHouse2);
		viewNHouse2.setFitHeight(200);
		viewNHouse2.setFitWidth(250);
		viewNHouse2.setImage(NHouse2);
		N3button = new Button("420 E 40th St", viewNHouse2);
		N3button.setOnAction(e -> primaryStage.setScene(NY3)); 
		N3button.setStyle("-fx-background-color: #008B8B ");
		
		
		Image N2room1 = new Image("file:ProjPics/NYroom2A.jpg" ); // NY HOUSE 2 , ROOM 1 IMG
		ImageView viewN2room1 = new ImageView(N2room1);
		viewN2room1.setFitHeight(200);
		viewN2room1.setFitWidth(250);
		viewN2room1.setImage(N2room1);
		
		Image N2room2 = new Image("file:ProjPics/NYroom2B.jpg" );// NY HOUSE 2 , ROOM 2 IMG
		ImageView viewN2Room2 = new ImageView(N2room2);
		viewN2Room2.setFitHeight(200);
		viewN2Room2.setFitWidth(250);
		viewN2Room2.setImage(N2room2);
		
		Image N2room3 = new Image("file:ProjPics/NYroom2C.jpg" );// NY HOUSE 2 , ROOM 3 IMG
		ImageView viewN2Room3 = new ImageView(N2room2);
		viewN2Room3.setFitHeight(200);
		viewN2Room3.setFitWidth(250);
		viewN2Room3.setImage(N2room3);
		
		
		
		HBox N2rooms = new HBox(8);
		N2rooms.getChildren().addAll(viewN2room1, viewN2Room2, viewN2Room3);	
		
//==============================================================================================================================================================

		// Code for MI House option 2 and its pictures
				Image MHouse1 = new Image("file:ProjPics/MIHome1.jpg" ); // Takes you to iMages of ny property
				ImageView viewMHouse1 = new ImageView(MHouse1);
				viewMHouse1.setFitHeight(200);
				viewMHouse1.setFitWidth(250);
				viewMHouse1.setImage(MHouse1);
				M2button = new Button("885 NE 76th St", viewMHouse1);
				M2button.setOnAction(e -> primaryStage.setScene(MI2)); 
				M2button.setStyle("-fx-background-color: #FFDEAD ");
				
				Image Mroom1 = new Image("file:ProjPics/MIroom1A.jpg" ); // MI HOUSE 1 , ROOM 1 IMG
				ImageView viewMroom1 = new ImageView(Mroom1);
				viewMroom1.setFitHeight(200);
				viewMroom1.setFitWidth(250);
				viewMroom1.setImage(Mroom1);
				
				Image Mroom2 = new Image("file:ProjPics/MIroom1B.jpg" ); // MI HOUSE 1 , ROOM 2 IMG
				ImageView viewMroom2 = new ImageView(Mroom2);
				viewMroom2.setFitHeight(200);
				viewMroom2.setFitWidth(250);
				viewMroom2.setImage(Mroom2);
				
				Image Mroom3 = new Image("file:ProjPics/MIroom1C.jpg" ); // MI HOUSE 1 , ROOM 3 IMG
				ImageView viewMroom3 = new ImageView(Mroom3);
				viewMroom3.setFitHeight(200);
				viewMroom3.setFitWidth(250);
				viewMroom3.setImage(Mroom3);
				
				
				
				HBox Mrooms = new HBox(8);
				Mrooms.getChildren().addAll(viewMroom1, viewMroom2, viewMroom3);	
				
				
				// CODE FOR MI HOUSE OPTIONS 2
		
				Image MHouse2 = new Image("file:ProjPics/MIHome2.jpg" ); // Takes you to iMages of ny property
				ImageView viewMHouse2 = new ImageView(MHouse2);
				viewMHouse2.setFitHeight(200);
				viewMHouse2.setFitWidth(250);
				viewMHouse2.setImage(MHouse2);
				M3button = new Button("805 NE 56th St", viewMHouse2);
				M3button.setOnAction(e -> primaryStage.setScene(MI3)); 
				M3button.setStyle("-fx-background-color: #FFDEAD ");
				
				Image M2room1 = new Image("file:ProjPics/MIroom2A.jpg" ); // MI HOUSE 1 , ROOM 1 IMG
				ImageView viewM2room1 = new ImageView(M2room1);
				viewM2room1.setFitHeight(200);
				viewM2room1.setFitWidth(250);
				viewM2room1.setImage(M2room1);
				
				Image M2room2 = new Image("file:ProjPics/MIroom2B.jpg" ); // MI HOUSE 1 , ROOM 2 IMG
				ImageView viewM2room2 = new ImageView(M2room2);
				viewM2room2.setFitHeight(200);
				viewM2room2.setFitWidth(250);
				viewM2room2.setImage(M2room2);
				
				Image M2room3 = new Image("file:ProjPics/MIroom2C.jpg" ); // MI HOUSE 1 , ROOM 3 IMG
				ImageView viewM2room3 = new ImageView(M2room3);
				viewM2room3.setFitHeight(200);
				viewM2room3.setFitWidth(250);
				viewM2room3.setImage(M2room3);
				
				
				
				HBox M2rooms = new HBox(8);
				M2rooms.getChildren().addAll(viewM2room1, viewM2room2, viewM2room3);	
		
//==============================================================================================================================================================

				// Code for LA House option 1 and its pictures
				Image LHouse1 = new Image("file:ProjPics/LHome1.jpg" ); // Takes you to iMages of LA property
				ImageView viewLHouse1 = new ImageView(LHouse1);
				viewLHouse1.setFitHeight(200);
				viewLHouse1.setFitWidth(250);
				viewLHouse1.setImage(LHouse1);
				L2button = new Button("6447 Weidlake Dr", viewLHouse1);
				L2button.setOnAction(e -> primaryStage.setScene(LA2)); 
				L2button.setStyle("-fx-background-color: #D8BFD8 ");
				
				Image Lroom1 = new Image("file:ProjPics/LAroom1A.jpg" ); // LA HOUSE 1 , ROOM 1 IMG
				ImageView viewLroom1 = new ImageView(Lroom1);
				viewLroom1.setFitHeight(200);
				viewLroom1.setFitWidth(250);
				viewLroom1.setImage(Lroom1);
				
				Image Lroom2 = new Image("file:ProjPics/LAroom1B.jpg" ); // LA HOUSE 1 , ROOM 2 IMG
				ImageView viewLroom2 = new ImageView(Lroom2);
				viewLroom2.setFitHeight(200);
				viewLroom2.setFitWidth(250);
				viewLroom2.setImage(Lroom2);
				
				Image Lroom3 = new Image("file:ProjPics/LAroom1C.jpg" ); // LA HOUSE 1 , ROOM 3 IMG
				ImageView viewLroom3 = new ImageView(Lroom3);
				viewLroom3.setFitHeight(200);
				viewLroom3.setFitWidth(250);
				viewLroom3.setImage(Lroom3);
				
				HBox Lrooms = new HBox(8);
				Lrooms.getChildren().addAll(viewLroom1, viewLroom2, viewLroom3);				
				
				
				
				
				// Code for LA House option 2 and its pictures
				Image LHouse2 = new Image("file:ProjPics/LHome2.jpg" ); // Takes you to iMages of LA property
				ImageView viewLHouse2 = new ImageView(LHouse2);
				viewLHouse2.setFitHeight(200);
				viewLHouse2.setFitWidth(250);
				viewLHouse2.setImage(LHouse2);
				L3button = new Button("6447 Rodeo Dr", viewLHouse2);
				L3button.setOnAction(e -> primaryStage.setScene(LA3)); 
				L3button.setStyle("-fx-background-color: #D8BFD8 ");
				
				Image L2room1 = new Image("file:ProjPics/LAroom2A.jpg" ); // LA HOUSE 2 , ROOM 1 IMG
				ImageView viewL2room1 = new ImageView(L2room1);
				viewL2room1.setFitHeight(200);
				viewL2room1.setFitWidth(250);
				viewL2room1.setImage(L2room1);
				
				Image L2room2 = new Image("file:ProjPics/LAroom2B.jpg" ); // LA HOUSE 2 , ROOM 2 IMG
				ImageView viewL2room2 = new ImageView(L2room2);
				viewL2room2.setFitHeight(200);
				viewL2room2.setFitWidth(250);
				viewL2room2.setImage(L2room2);
				
				Image L2room3 = new Image("file:ProjPics/LAroom2C.jpg" ); // LA HOUSE 2 , ROOM 3 IMG
				ImageView viewL2room3 = new ImageView(L2room3);
				viewL2room3.setFitHeight(200);
				viewL2room3.setFitWidth(250);
				viewL2room3.setImage(L2room3);
				
				
				
				HBox L2rooms = new HBox(8);
				L2rooms.getChildren().addAll(viewL2room1, viewL2room2, viewL2room3);		
				
//==============================================================================================================================================================
		
		// All home buttons for all pages created thus far
		homeB = new Button();
		homeB.setText(" Home ");
		homeB.setOnAction(e -> primaryStage.setScene(Home)); // Takes you to Home Page with the cities
		
		homeB2 = new Button();
		homeB2.setText(" Home ");
		homeB2.setOnAction(e -> primaryStage.setScene(Home)); // Takes you to Home Page with the cities
		
		homeB3 = new Button();
		homeB3.setText(" Home ");
		homeB3.setOnAction(e -> primaryStage.setScene(Home)); // Takes you to Home Page with the cities
		
		homeB4 = new Button();
		homeB4.setText(" Home ");
		homeB4.setOnAction(e -> primaryStage.setScene(Home)); // Takes you to Home Page with the cities

		homeB5 = new Button();
		homeB5.setText(" Home ");
		homeB5.setOnAction(e -> primaryStage.setScene(Home)); // Takes you to Home Page with the cities

		homeB6 = new Button();
		homeB6.setText(" Home ");
		homeB6.setOnAction(e -> primaryStage.setScene(Home)); // Takes you to Home Page with the cities

		homeB7 = new Button();
		homeB7.setText(" Home ");
		homeB7.setOnAction(e -> primaryStage.setScene(Home)); // Takes you to Home Page with the cities

		homeB8 = new Button();
		homeB8.setText(" Home ");
		homeB8.setOnAction(e -> primaryStage.setScene(Home)); // Takes you to Home Page with the cities
		
		homeB9 = new Button();
		homeB9.setText(" Home ");
		homeB9.setOnAction(e -> primaryStage.setScene(Home)); // Takes you to Home Page with the cities

		
		
		
		
		
		// Home image of NYC
		Image NYC = new Image("file:ProjPics/NYC.jpg");
		ImageView viewNYC = new ImageView(NYC);
		viewNYC.setFitWidth(300);
        viewNYC.setFitHeight(200);
        viewNYC.setPreserveRatio(true);
		Nbutton = new Button("New York City, NY",viewNYC);
		Nbutton.setOnAction(e -> primaryStage.setScene(NY)); // Takes you to NY page
		Nbutton.setTranslateX(0); //Button Location
		Nbutton.setTranslateY(0);
		Nbutton.setStyle("-fx-background-color: #87CEFA ");
		
		
		// Home image of MIA
		Image MIA = new Image("file:ProjPics/MIA.jpg");
		ImageView viewMIA = new ImageView(MIA);
		viewMIA.setFitWidth(300);
        viewMIA.setFitHeight(200);
        viewMIA.setPreserveRatio(true);
		Mbutton = new Button("Miami, FL",viewMIA);
		Mbutton.setOnAction(e -> primaryStage.setScene(MI)); // Takes you to MIAMI page
		Mbutton.setTranslateX(0); //Button Location
		Mbutton.setTranslateY(0);
		Mbutton.setStyle("-fx-background-color: #FFB6C1 ");
		

		
		// Home image of MIA
		Image LOS = new Image("file:ProjPics/LOS.jpg");
		ImageView viewLOS = new ImageView(LOS);
		viewLOS.setFitWidth(300);
		viewLOS.setFitHeight(200);
		viewLOS.setPreserveRatio(true);
		Lbutton = new Button("Los Angeles, CA",viewLOS);
		Lbutton.setOnAction(e -> primaryStage.setScene(LA)); // Takes you to LOS ANGELES page
		Lbutton.setTranslateX(0); //Button Location
		Lbutton.setTranslateY(0);
		Lbutton.setStyle("-fx-background-color: #DDA0DD ");
		
		
		// VBox for all 3 Cities
		VBox CT = new VBox(8);
		CT.getChildren().addAll(Nbutton, Mbutton, Lbutton);
		CT.setPrefSize(400, 800);
		CT.setPadding(new Insets(10,40,40,120));
		
//=======================================================================================================================================================		
	
		// PAGE LABELS
		
		Label Where = new Label("Where do you want to go?"); 
		Where.setTextFill(Color.WHITE);
		Where.setFont(Font.font(28));
		
		Label Fillout = new Label("New York Properties");
		Fillout.setTextFill(Color.WHITE);
		Fillout.setFont(Font.font(28));
		
		Label Fillout2 = new Label("Miami Properties");
		Fillout2.setTextFill(Color.DARKCYAN);
		Fillout2.setFont(Font.font("",FontWeight.SEMI_BOLD, 28));
		
		Label Fillout3 = new Label("Los Angeles Properties");
		Fillout3.setTextFill(Color.ANTIQUEWHITE);
		Fillout3.setFont(Font.font("",FontWeight.SEMI_BOLD, 28));
		
		
//=======================================================================================================================================================		
		
		HBox bu = new HBox(4);
		bu.setPadding(new Insets(10,10,10,10));
		bu.getChildren().addAll(exitB, help);		
		
		
		// VBOX FOR HOME PAGE WITH THE CITIES (HOME PAGE)
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(10,40,40,40));
		layout.getChildren().addAll(logo1, Where, bu, CT);
		Home =  new Scene(layout, 800, 800);
			
//=======================================================================================================================================================		
		
		
		
		
		// VBOX FOR NY HOME OPTIONS PAGE	
		VBox layout2 = new VBox(10);
		layout2.setPadding(new Insets(80, 80, 80, 80));
		layout2.getChildren().addAll(homeB, Fillout, N2button, N3button);
		NY =  new Scene(layout2, 800,800, Color.BLACK);
		
		
		
		// VBOX FOR NY HOME 1 PAGE LAYOUT
		VBox layout3 = new VBox(10);
		layout3.setPadding(new Insets(30, 30, 30, 30));
		layout3.setPrefSize(400, 800);
		layout3.getChildren().addAll( homeB2, Nrooms, r1, r2, r3, Fname, Fname1, Cnume, viewCnum, Rent, Rent1, subB, exitB2);
		NY2 =  new Scene(layout3, 800,800, Color.BLACK);
		
		// VBOX FOR NY HOME 2 PAGE LAYOUT
		VBox layout4 = new VBox(10);
		layout4.setPadding(new Insets(30, 30, 30, 30));
		layout4.setPrefSize(400, 800);
		layout4.getChildren().addAll(homeB3, N2rooms, rr1, rr2, rr3, All1, exitB3 );
		NY3 =  new Scene(layout4, 800,800, Color.BLACK);
				
		
//=======================================================================================================================================================		
		
		// VBOX FOR MIA HOME OPTIONS PAGE	
				
		VBox layout5 = new VBox(10);
		layout5.setPadding(new Insets(80, 80, 80, 80));
		layout5.getChildren().addAll(homeB4, Fillout2, M2button, M3button);
		MI =  new Scene(layout5, 800,800, Color.BLACK);
		
		
	
		
		// VBOX FOR MIA HOME OPTION 1
		VBox layout6 = new VBox(10);
		layout6.setPadding(new Insets(15, 15, 15, 15));
		layout6.getChildren().addAll( homeB5, Mrooms, fl1, fl2, fl3, All2, exitB4);
		MI2 =  new Scene(layout6, 800,800, Color.BLACK);
		
		// VBOX FOR MIA HOME OPTION 2
		VBox layout7 = new VBox(10);
		layout7.setPadding(new Insets(15, 60, 60, 15));
		layout7.getChildren().addAll(homeB6, M2rooms, fl4, fl5, fl6, All3, exitB5);
		MI3 =  new Scene(layout7, 800,800, Color.BLACK);
		
		
//=======================================================================================================================================================		
		
		
		// VBOX FOR LA HOME OPTIONS PAGE	
		
				VBox layout8 = new VBox(10);
				layout8.setPadding(new Insets(80, 80, 80, 80));
				layout8.getChildren().addAll(homeB7,Fillout3, L2button, L3button);
				LA =  new Scene(layout8, 800,800, Color.BLACK);
				
				
			
				
				// VBOX FOR LA HOME OPTION 1
				VBox layout9 = new VBox(10);
				layout9.setPadding(new Insets(15, 15, 15, 15));
				layout9.getChildren().addAll( homeB8, Lrooms, ca1, ca2, ca3, All4, exitB6);
				LA2 =  new Scene(layout9, 800,800, Color.BLACK);
				
				// VBOX FOR LA HOME OPTION 2
				VBox layout10 = new VBox(10);
				layout10.setPadding(new Insets(15, 60, 60, 15));
				layout10.getChildren().addAll(homeB9, L2rooms, ca4, ca5, ca6, All5, exitB7);
				LA3 =  new Scene(layout10, 800,800, Color.BLACK);
		
		
//=======================================================================================================================================================				
		
		// Background images set for each page
		Image image = new Image ("file:ProjPics/Background.jpg");
		Image image2 = new Image ("file:ProjPics/Background 3.jpg");
		Image image3 = new Image ("file:ProjPics/BgMI.jpg");
		Image image4 = new Image ("file:ProjPics/BgLA.jpg");
		
		
		layout.setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT, // Background for homepage with all citites
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
		
		layout2.setBackground(new Background(new BackgroundImage(image2,BackgroundRepeat.REPEAT, // Background for NY page with home options
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
		
		layout3.setBackground(new Background(new BackgroundImage(image2,BackgroundRepeat.REPEAT, // Background for NY Home 1
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
		
		layout4.setBackground(new Background(new BackgroundImage(image2,BackgroundRepeat.REPEAT, // Background for NY Home 2
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
		
		
		
		layout5.setBackground(new Background(new BackgroundImage(image3,BackgroundRepeat.REPEAT, // Background for MI page with home options
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
		
		layout6.setBackground(new Background(new BackgroundImage(image3,BackgroundRepeat.REPEAT, // Background for MI Home 1
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
		
		layout7.setBackground(new Background(new BackgroundImage(image3,BackgroundRepeat.REPEAT, // Background for MI Home 2
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
		
		
		
		layout8.setBackground(new Background(new BackgroundImage(image4,BackgroundRepeat.REPEAT, // Background for LA page with home options
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
		
		layout9.setBackground(new Background(new BackgroundImage(image4,BackgroundRepeat.REPEAT, // Background for LA HOME 1
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
		layout10.setBackground(new Background(new BackgroundImage(image4,BackgroundRepeat.REPEAT, // Background for LA Home 2
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
		
		
		
//vbox.setBorder(new Border(new BorderStroke(Color.WHITE,BorderStrokeStyle.SOLID,
          // null,new BorderWidths(3))));
		 
		primaryStage.setScene(Home);
		primaryStage.show();
		
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}


