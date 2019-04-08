/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 *
 * @author user
 */
class login extends JFrame
{
    JButton login,signin,forgotpassword,donthaveanaccount;
    JTextField username;
    JPasswordField emailpassword;
    Label SIGNINlabel,haveanaccountlabel;
    JLabel ShoppersstopPicture,passwordLabel,userlabel;
    //JPasswordField password;
    static String USerIdHere=null;
    static boolean flag=false;
    
    public login()
    {
        
        setLayout(null);
        setTitle("Login Frame");
        setSize(600,1200);
        setLocation(350,0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //addWindowListener(new windowsensor());
        
        ImageIcon ShoppersstopPictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/shoppersstopLogo/shoppersstop.PNG"));
        ShoppersstopPicture=new JLabel(ShoppersstopPictureIcon);
        
        ShoppersstopPicture.setBounds(-425,-200,1430,500);
        ShoppersstopPicture.setBackground(Color.BLUE);
        add(ShoppersstopPicture);
        
        username=new JTextField("         Enter your Username");
        username.setBounds(150,200,300,35);
        username.setBackground(Color.white);
        username.setForeground(Color.red);
        username.setFont(new Font("monospaced", Font.BOLD, 12));
        add(username);
        
        userlabel=new JLabel(" user");
        userlabel.setBounds(450, 200, 160, 35);
        userlabel.setBackground(Color.WHITE);
        userlabel.setForeground(Color.black);
        userlabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(userlabel);
        
        emailpassword=new JPasswordField();
        emailpassword.setBounds(150,245,300,35);
        emailpassword.setBackground(Color.white);
        emailpassword.setForeground(Color.red);
        emailpassword.setFont(new Font("monospaced", Font.BOLD, 12));
        add(emailpassword);
        
        passwordLabel=new JLabel(" Password");
        passwordLabel.setBounds(450, 245, 160, 35);
        passwordLabel.setBackground(Color.WHITE);
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(passwordLabel);
        
        SIGNINlabel=new Label("SIGN IN");
        SIGNINlabel.setBounds(250,110,85,25);
        SIGNINlabel.setBackground(Color.white);
        SIGNINlabel.setForeground(Color.BLACK);
        SIGNINlabel.setFont(new Font("monospaced", Font.BOLD, 19));
	add(SIGNINlabel);
        
        haveanaccountlabel=new Label("HAVE AN ACCOUNT? SIGN IN");
        haveanaccountlabel.setBounds(200,150,180,20);
        haveanaccountlabel.setBackground(Color.white);
        haveanaccountlabel.setForeground(Color.BLACK);
        haveanaccountlabel.setFont(new Font("monospaced", Font.PLAIN, 12));
	add(haveanaccountlabel);
  
        /*password=new JPasswordField("");
        password.setBounds(70,800,150,25);
        password.setForeground(Color.red);

        add(password);*/

        login=new JButton("LOGIN");
        login.setBounds(150,290,300,35);
        login.setBackground(Color.RED);
        login.setForeground(Color.white);
        login.setFont(new Font("monospaced", Font.BOLD, 14));
        add(login);
        login.addActionListener(new LoginAction());
        
        forgotpassword=new JButton("Forgot Password?");
        forgotpassword.setBounds(200,335,200,35);
        forgotpassword.setBackground(Color.white);
        forgotpassword.setForeground(Color.black);
        forgotpassword.setFont(new Font("monospaced", Font.PLAIN, 14));
        add(forgotpassword);
        forgotpassword.addActionListener(new LoginSign());
        donthaveanaccount=new JButton("DON'T HAVE AN ACCOUNT?SIGN UP");
        donthaveanaccount.setBounds(140,455,330,35);
        donthaveanaccount.setBackground(Color.darkGray);
        donthaveanaccount.setForeground(Color.WHITE);
        donthaveanaccount.setFont(new Font("SERIF", Font.BOLD, 16));
        add(donthaveanaccount);
        donthaveanaccount.addActionListener(new ForgetAction());
                
        }
        class LoginSign implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
              if(e.getSource()==forgotpassword)
              {
                  forgotyourpassword pass=new forgotyourpassword();
                  setVisible(false);
                  pass.setVisible(true);
              }
            }
        }
        class LoginAction implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
              if(e.getSource()==login)
              {
                  
                  String user,password;
                  user="SELECT `UserName` FROM `person";
                  ResultSet rsuser,rspassword;
                  DBConnector com=new DBConnector();
                  rsuser=com.setData(user);
                  if(username.getText().equals("         Enter your Username") || username.getText().equals(null))
                  {
                      userlabel.setText("UserName required");
                      userlabel.setForeground(Color.red);
                  }
                  else{
                  try {
                      while(rsuser.next())
                      {
                          if(emailpassword.getText().equals("         Enter your password") || emailpassword.getText().equals(null))
                          {
                              passwordLabel.setText("Password Required");
                                passwordLabel.setForeground(Color.red);
                          }
                          if(username.getText().equals(rsuser.getString("UserName")))
                          {
                              password="SELECT Password FROM `person` WHERE UserName='"+username.getText()+"'";
                              rspassword=com.setData(password);
                              while(rspassword.next())
                              {
                              if(emailpassword.getText().equals(rspassword.getString("Password")))
                              {
                                  
                                  userlabel.setText("Matched");
                                  userlabel.setForeground(Color.GREEN);
                                  flag=true;
                                  USerIdHere=rsuser.getString("UserName");
                                  setVisible(false);
                                  LogOutFrame a=new LogOutFrame();
                                  MyFrame d=new MyFrame();
                              }
                              else
                              {  
                                userlabel.setText("Matched");
                                userlabel.setForeground(Color.GREEN);
                                passwordLabel.setText("Wrong Password");
                                passwordLabel.setForeground(Color.red);
                              }
                              
                              
                          }
                         break;
                              
                          }
                          else
                          {
                              userlabel.setText("UserName don't match");
                              userlabel.setForeground(Color.red);
                          }
                      }
                  } catch (SQLException ex) {
                      System.out.println("Error is:"+ex);
                  }
                  
                  
              }
              }
            }
        }
        class ForgetAction implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
              if(e.getSource()==donthaveanaccount)
              {
                  SignUp up=new SignUp();
                  setVisible(false);
                  up.setVisible(true);
              }
            }
        }
        
}
