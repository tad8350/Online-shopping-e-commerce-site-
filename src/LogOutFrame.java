/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author user
 */
public class LogOutFrame extends JFrame {
     JButton LogOut;
     JLabel UserName,UserEmail,Type;
     static String UserDetails,Firstname,lastname,email,personTypeid=null,persontype;
    
    public LogOutFrame()
    {
        setLayout(null);
        setTitle("userfile");
        setSize(220,300);
        
        setLocation(1138,130);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        UserDetails=login.USerIdHere;
        System.out.println(UserDetails);
        String Rs="SELECT * FROM `person` WHERE `UserName`='"+UserDetails+"'";
        ResultSet Rsuser,rsType;
        DBConnector com=new DBConnector();
        Rsuser=com.setData(Rs);
        try{while(Rsuser.next())
        {
            Firstname=Rsuser.getString("FirstName");
            lastname=Rsuser.getString("LastName");
            email=Rsuser.getString("EmailAddress");
            personTypeid=Rsuser.getString("PersonTypeId");
            
            
        }
        }catch (SQLException ex) {
                      System.out.println("Error is:"+ex);}
        String Rstype="SELECT `PersonType` FROM `persontype` WHERE `PersonTypeId`='"+personTypeid+"'"; 

        rsType=com.setData(Rstype);
        try{while(rsType.next())
        {
            persontype=rsType.getString("PersonType");
            
        }
        }catch (SQLException ex) {
                      System.out.println("Error is:"+ex);}
        
        UserName=new JLabel(" Hello "+Firstname+" "+lastname);
        UserName.setBounds(0,0,210,55);
        UserName.setBackground(Color.white);
        UserName.setForeground(Color.black);
        UserName.setFont(new Font("monospaced", Font.BOLD, 14));
        add(UserName);
        UserEmail=new JLabel(email);
        UserEmail.setBounds(0,55,210,55);
        UserEmail.setBackground(Color.white);
        UserEmail.setForeground(Color.black);
        UserEmail.setFont(new Font("monospaced", Font.BOLD, 14));
        add(UserEmail);
        Type=new JLabel(persontype);
        Type.setBounds(0,110,210,55);
        Type.setBackground(Color.white);
        Type.setForeground(Color.black);
        Type.setFont(new Font("monospaced", Font.BOLD, 14));
        add(Type);
        
        

        LogOut=new JButton("LOGOUT");
        LogOut.setBounds(0,165,210,55);
        LogOut.setBackground(Color.RED);
        LogOut.setForeground(Color.WHITE);
        LogOut.setFont(new Font("monospaced", Font.BOLD, 14));
        add(LogOut);
        LogOut.addActionListener(new handler());
        
    }
    class handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            login.flag=false;
            proccedtokart.Counter=0;
            login a=new login();
            setVisible(false);
            
        }
    }
    
}
