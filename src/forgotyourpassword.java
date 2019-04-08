/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author user
 */
public class forgotyourpassword extends JFrame
{
    
    JLabel forgotyourpassword,enteryouremailaddresslabel,sendinglink,ShoppersstopPicture;
    JTextField enteryouremailaddress;
    JButton sendemail,donthaveanaccount;
    public forgotyourpassword()
            {
        setLayout(null);
        setTitle("FORGOTPASSWORD Frame");
        setSize(600,1200);
        setLocation(350,0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ImageIcon ShoppersstopPictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/shoppersstopLogo/shoppersstop.PNG"));
        ShoppersstopPicture=new JLabel(ShoppersstopPictureIcon);
        
        ShoppersstopPicture.setBounds(-425,-200,1430,500);
        ShoppersstopPicture.setBackground(Color.BLUE);
        add(ShoppersstopPicture);
        
                      
        forgotyourpassword=new JLabel("     FORGOT YOUR PASSWORD");
        forgotyourpassword.setBounds(150,110,300,25);
        forgotyourpassword.setBackground(Color.white);
        forgotyourpassword.setForeground(Color.BLACK);
        forgotyourpassword.setFont(new Font("monospaced", Font.BOLD, 16));
	add(forgotyourpassword);
        
        enteryouremailaddresslabel=new JLabel("     Enter your email address");
        enteryouremailaddresslabel.setBounds(180,155,230,25);
        enteryouremailaddresslabel.setBackground(Color.white);
        enteryouremailaddresslabel.setForeground(Color.red);
        enteryouremailaddresslabel.setFont(new Font("monospaced", Font.BOLD, 12));
	add(enteryouremailaddresslabel);
        
        sendinglink=new JLabel("We will send you a link to reset your password");
        sendinglink.setBounds(135,180,330,25);
        sendinglink.setBackground(Color.white);
        sendinglink.setForeground(Color.red);
        sendinglink.setFont(new Font("monospaced", Font.BOLD, 12));
	add(sendinglink);
        
        enteryouremailaddress=new JTextField("         Enter your email address");
        enteryouremailaddress.setBounds(150,230,300,35);
        enteryouremailaddress.setBackground(Color.white);
        enteryouremailaddress.setForeground(Color.lightGray);
        enteryouremailaddress.setFont(new Font("monospaced", Font.BOLD, 12));
        add(enteryouremailaddress);
        
        sendemail=new JButton("SEND EMAIL");
        sendemail.setBounds(150,290,300,35);
        sendemail.setBackground(Color.RED);
        sendemail.setForeground(Color.WHITE);
        sendemail.setFont(new Font("ARIAL", Font.BOLD, 14));
        add(sendemail);
        
        donthaveanaccount=new JButton("DON'T HAVE AN ACCOUNT?SIGN UP");
        donthaveanaccount.setBounds(140,455,330,35);
        donthaveanaccount.setBackground(Color.darkGray);
        donthaveanaccount.setForeground(Color.WHITE);
        donthaveanaccount.setFont(new Font("SERIF", Font.BOLD, 16));
        add(donthaveanaccount);
        donthaveanaccount.addActionListener(new ForgetAction());
                
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
