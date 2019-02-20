/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icusystem;
import java.sql.*;
import javax.swing.JOptionPane;
public class ICUsystem {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getconnection();
        firstScreen form = new firstScreen();
        form.setVisible(true);
        mainMenu main = new mainMenu();
        
        try{
        for (int i=0;i<=100;i++){
        Thread.sleep(30);
        form.percent.setText(Integer.toString(i)+"%");
        if(i == 57){Thread.sleep(500);}
        if (i == 100){
        form.setVisible(false);
        main.setVisible(true);
        }
        }
        }
        catch(Exception e)
        {}                
             
    }
    
    public static Connection getconnection(){
     
        try{           
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lnh?autoReconnect=true&useSSL=false","root","12345678");
            return conn;
        }
        catch(SQLException e){
             JOptionPane.showMessageDialog(null,e);
        return null;
        }
    }
}