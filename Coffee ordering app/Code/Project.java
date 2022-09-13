import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.io.PrintWriter;




 
public class Project extends Application 
{
    public void start (Stage stage) 
    {
        final int PANEWIDTH = 500;
        final int PANEHEIGHT = 500;
        
        Pane pane = new Pane();
        
        Button proceed = new Button ("Proceed");
        ComboBox <String> combobox = new ComboBox<>();
        
        ArrayList <String> addresses = new ArrayList<>();
        addresses.add("Sheridan college");
        addresses.add("Rabba");
        
        combobox.getItems().addAll(addresses);
        combobox.setOnAction(e-> {
            String selection = combobox.getValue();
            if ((selection == addresses.get(0)) || selection == addresses.get(1)){
                proceed.setOnAction( e1-> {
                start2(stage);});
            }
            else
            {
                proceed.setOnAction(null);
            }
        });
        
        
        Label label1 = new Label("Cups and Mugs");
        Label label2 = new Label("Select address");
        Label label3 = new Label ();
        label1.setFont(new Font ("Arial",30));
        label2.setFont(new Font ("Arial",20));
        
        Scene scene = new Scene (pane, PANEWIDTH, PANEHEIGHT);
        Image logo = new Image ("file:C:/semester 2/java2/Project/Code/image/FreeVector-Coffee-Cup-Logo-Template.jpg");
        ImageView coffeeLogo = new ImageView();
        coffeeLogo.setImage (logo);
        coffeeLogo.setFitWidth (PANEWIDTH/2);
        coffeeLogo.setFitHeight (PANEHEIGHT/2);
        coffeeLogo.setSmooth(true);
        coffeeLogo.setLayoutX (125);
        label1.setLayoutX(140);
        label1.setLayoutY(260);
        label2.setLayoutX(180);
        label2.setLayoutY(310);
        combobox.setLayoutX(180);
        combobox.setLayoutY(350);
        proceed.setLayoutX(220);
        proceed.setLayoutY(450);
        
        pane.getChildren ().addAll(coffeeLogo,label1,combobox,label2,proceed,label3);
        
        stage.setScene(scene);
        stage.setTitle("Project");
       
        stage.setX(200);
        stage.setY(100);
        stage.show();
        
    }
    
    public void start2 (Stage stage) 
    {
        final int PANEWIDTH = 500;
        final int PANEHEIGHT = 500;
        
        Pane pane = new Pane();
        
        Label label1 = new Label("Select what you want to have");
        label1.setFont(new Font ("Arial",30));
        Button back = new Button ("Back");
        Button coffees = new Button ("Coffee");
        Button cold_drink = new Button ("Cold Drink");
        Button cookies = new Button ("Cookies");
        Button sandwich = new Button ("Sandwiches");
        
        back.setOnAction( e-> {
            start(stage);
        });
        coffees.setOnAction( e1 -> {
            start3(stage);
        });
        cold_drink.setOnAction( e2 -> {
            start5(stage);
        });
        cookies.setOnAction ( e3 -> {
            start6(stage);
        });
        sandwich.setOnAction( e4 -> {
            start7(stage);
        });
        label1.setLayoutX (70);
        label1.setLayoutY (60);
        
        coffees.setPrefWidth(100);
        coffees.setLayoutX (120);
        coffees.setLayoutY (140);
        
        cold_drink.setPrefWidth(100);
        cold_drink.setLayoutX (300);
        cold_drink.setLayoutY (140);
        
        cookies.setPrefWidth(100);
        cookies.setLayoutX (120);
        cookies.setLayoutY (240);
        
        sandwich.setPrefWidth(100);
        sandwich.setLayoutX (300);
        sandwich.setLayoutY (240);
      
        
        pane.getChildren().addAll(back,label1,coffees,cold_drink,cookies,sandwich);
        Scene scene = new Scene (pane, PANEWIDTH, PANEHEIGHT);
        stage.setScene(scene);
        stage.setTitle("Project");
        stage.show();
    }
    public void start3 (Stage stage)
    {
        try
        {
            final int PANEWIDTH = 500;
            final int PANEHEIGHT = 500;
            
            coffeelist original = new coffeelist ("Original coffee", 3.0,2.0,1.0);
            coffeelist dark = new coffeelist ("Dark coffee", 4.0, 3.0,2.0);
            
            File f = new File ("C:\\semester 2\\java2\\Project\\Code\\print.txt");
           
            PrintWriter writer = new PrintWriter ("print.txt");
            
            ComboBox<String> c = new ComboBox<>();
            Label label1 = new Label("Select your coffee");
            label1.setFont(new Font ("Arial",30));
            RadioButton box1  = new RadioButton ();
            RadioButton box2  = new RadioButton ();
            RadioButton box3  = new RadioButton ();
            
            ToggleGroup radioGroup = new ToggleGroup();
            box1.setToggleGroup(radioGroup);
            box2.setToggleGroup(radioGroup);
            box3.setToggleGroup(radioGroup);
            Button proceed = new Button ("Proceed to checkout");
            
            HashMap<String, coffeelist> list = new HashMap<>();
            list.put(original.name, original);
            list.put(dark.name, dark);
            
            
          
            Pane pane = new Pane();
            
          
            Button back = new Button ("Back");
            back.setOnAction (e-> {
                start2(stage);
            });
            
            c.getItems().addAll(list.keySet());
            
            c.setOnAction( e1 -> {
                String selection = c.getValue();
                box1.setText("Large Price" + " " + String.valueOf(list.get(selection).Largeprice));
                box2.setText("Medium Price" + " " + String.valueOf(list.get(selection).Mediumprice));
                box3.setText("Small Price" + " " + String.valueOf(list.get(selection).smallprice));
                proceed.setOnAction (e2 -> {
                    
                    writer.println(selection);
                    writer.println(radioGroup.getSelectedToggle().toString());
                    start4(stage);
                    writer.close();
                });
            });
            proceed.setLayoutX(170);
            proceed.setLayoutY(350);
            label1.setLayoutX (130);
            label1.setLayoutY (80);
            c.setLayoutX(150);
            c.setLayoutY(140);
            box1.setLayoutX(150);
            box2.setLayoutX(150);
            box3.setLayoutX(150);
            box1.setLayoutY(190);
            box2.setLayoutY(220);
            box3.setLayoutY(250);
           
            pane.getChildren().addAll(back, c,label1,proceed,box1,box2,box3);
          
            Scene scene = new Scene (pane, PANEWIDTH, PANEHEIGHT);
            stage.setScene(scene);
            stage.setTitle("Project");
            stage.show(); 
        }
        catch (Exception  e)
        {
            e.printStackTrace();
        }
    }
    public void start4(Stage stage) 
    {
        try
        {
            final int PANEWIDTH = 500;
            final int PANEHEIGHT = 500;
            Pane pane = new Pane();
            Label l2 = new Label ("Thank you for order");
            Button close = new Button("Close");
            
            l2.setFont(new Font ("Arial",30));
            l2.setLayoutX(120);
            l2.setLayoutY(100);
            close.setLayoutX(210);
            close.setLayoutY(200);
            close.setOnAction(e -> {
                stage.close();
            });
            
            pane.getChildren().addAll(l2,close);
            Scene scene = new Scene (pane,PANEWIDTH,PANEHEIGHT);
            
            stage.setScene(scene);
            stage.setTitle("Project");
            stage.show();
      
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    public void start5 (Stage stage)
    {
        try 
        {
            final int PANEWIDTH = 500;
            final int PANEHEIGHT = 500;
            
            ColdDrink coke = new ColdDrink ("Coke", 1.50);
            ColdDrink pepsi = new ColdDrink ("pepsi", 1.50);
            
            File f = new File ("C:\\semester 2\\java2\\Project\\Code\\print.txt");
            PrintWriter writer = new PrintWriter ("print.txt");
            
            Pane pane = new Pane();
            
            ComboBox<String> c = new ComboBox<>();
            Label l1 = new Label ();
            Label l2 = new Label("Select your Drink");
            l2.setFont(new Font ("Arial",30));
            Button proceed = new Button ("Proceed to checkout");
            
            HashMap<String, ColdDrink> list = new HashMap<>();
            list.put(coke.name, coke);
            list.put(pepsi.name, pepsi);
            
            c.getItems().addAll(list.keySet());
            c.setOnAction( e1 -> {
                String selection = c.getValue();
                l1.setText("Price" + " " + String.valueOf(list.get(selection).price));
                proceed.setOnAction (e2 -> {
                    writer.println(selection);
                    writer.println(l1.getText());
                    start4(stage);
                    writer.close();
                });
            });
            
            Button back = new Button ("Back");
            back.setOnAction (e-> {
                start2(stage);
            });
            
            c.setLayoutX(200);
            c.setLayoutY(150);
            l2.setLayoutX (130);
            l2.setLayoutY (80);
            l1.setLayoutX(200);
            l1.setLayoutY(200);
            proceed.setLayoutX(170);
            proceed.setLayoutY(350);
            
            pane.getChildren().addAll(c,l1,proceed,back,l2);
            Scene scene = new Scene (pane,PANEWIDTH,PANEHEIGHT);
            
            stage.setScene(scene);
            stage.setTitle("Project");
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    public void start6 (Stage stage)
    {
        try 
        {
            final int PANEWIDTH = 500;
            final int PANEHEIGHT = 500;
            
            Cookies chocolate = new  Cookies ("Chocolate chip ", 1.69);
            Cookies Cdonut = new Cookies ("Chocolate donut", 1.77);
            
            File f = new File ("C:\\semester 2\\java2\\Project\\Code\\print.txt");
            PrintWriter writer = new PrintWriter ("print.txt");
            
            Pane pane = new Pane();
            
            ComboBox<String> c = new ComboBox<>();
            Label l1 = new Label ();
            Label l2 = new Label("Select your Cookie");
            l2.setFont(new Font ("Arial",30));
            Button proceed = new Button ("Proceed to checkout");
            
            HashMap<String, Cookies> list = new HashMap<>();
            
            list.put(chocolate.name, chocolate);
            list.put(Cdonut.name, Cdonut);
            c.getItems().addAll(list.keySet());
            c.setOnAction( e1 -> {
                String selection = c.getValue();
                l1.setText("Price" + " " + String.valueOf(list.get(selection).price));
                proceed.setOnAction (e2 -> {
                    writer.println(selection);
                    writer.println(l1.getText());
                    start4(stage);
                    writer.close();
                });
            });
             
            Button back = new Button ("Back");
            back.setOnAction (e-> {
                start2(stage);
            });
            c.setLayoutX(170);
            c.setLayoutY(150);
            l1.setLayoutX(170);
            l1.setLayoutY(200);
            proceed.setLayoutX(170);
            proceed.setLayoutY(350);
            l2.setLayoutX (130);
            l2.setLayoutY (80);
            
            pane.getChildren().addAll(c,l1,proceed,back,l2);
            Scene scene = new Scene (pane,PANEWIDTH,PANEHEIGHT);
            
            stage.setScene(scene);
            stage.setTitle("Project");
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void start7 (Stage stage)
    {
        try 
        {
            final int PANEWIDTH = 500;
            final int PANEHEIGHT = 500;
            
            Sandwich grilledCheese = new   Sandwich ("Grilled chesse ", 4.50);
            Sandwich chickenSandwich = new Sandwich ("Chicken Sandwich ", 6.50);
            
            File f = new File ("C:\\semester 2\\java2\\Project\\Code\\print.txt");
            PrintWriter writer = new PrintWriter ("print.txt");
            
            Pane pane = new Pane();
            ComboBox<String> c = new ComboBox<>();
            Label l1 = new Label ();
            Label l2 = new Label("Select your Sandwich");
            l2.setFont(new Font ("Arial",30));
            Button proceed = new Button ("Proceed to checkout");
            
            HashMap<String, Sandwich> list = new HashMap<>();
            list.put(grilledCheese.name, grilledCheese);
            list.put(chickenSandwich.name, chickenSandwich);
            
            c.getItems().addAll(list.keySet());
            c.setOnAction( e1 -> {
                String selection = c.getValue();
                l1.setText("Price" + " " + String.valueOf(list.get(selection).price));
                proceed.setOnAction (e2 -> {
                    writer.println(selection);
                    writer.println(l1.getText());
                    start4(stage);
                    writer.close();
                });
            });
            
            Button back = new Button ("Back");
            back.setOnAction (e-> {
                start2(stage);
            });
            
            c.setLayoutX(170);
            c.setLayoutY(150);
            l1.setLayoutX(170);
            l1.setLayoutY(200);
            proceed.setLayoutX(170);
            proceed.setLayoutY(350);
            l2.setLayoutX (130);
            l2.setLayoutY (80);
            
            pane.getChildren().addAll(c,l1,proceed,back,l2);
            Scene scene = new Scene (pane,PANEWIDTH,PANEHEIGHT);
            
            stage.setScene(scene);
            stage.setTitle("Project");
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    

        
    
}
class coffeelist 
{
    String name;
    double Largeprice;
    double Mediumprice;
    double smallprice;
    public coffeelist(String name, double Largeprice, double Mediumprice, double smallprice)
    {
        this.name=name;
       
        this.Largeprice=Largeprice;
        this.Mediumprice=Mediumprice;
        this.smallprice=smallprice;
    }
    
}

class ColdDrink 
{
    String name;
    double price;
    public ColdDrink (String name, double price)
    {
        this.name=name;
        this.price=price;
    }
}
class Cookies
{
    String name;
    double price;
    public Cookies (String name, double price)
    {
        this.name= name;
        this.price = price;
    }
}
class Sandwich
{
    String name;
    double price;
    public Sandwich (String name, double price)
    {
        this.name = name;
        this.price=price;
    }
}


