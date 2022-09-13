import java.io.File;
import java.util.Scanner;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.layout.*;
import javafx.scene.control.*;
public class scanTextfile 
{
    public static void main (String[] args) throws Exception

    {
       
        File f = new File("C:\\semester 2\\java2\\Project\\Code\\print.txt");
        Scanner scan = new Scanner(f);
        System.out.println("You ordered :");
        while (scan.hasNextLine())
        {
            String data = scan.nextLine();
            System.out.println(data);
          
        }
      
        scan.close();
        
    }
    
}