/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class UserFrame extends JFrame
{
    
    JButton Signup,SIGNIN;
    JTextField Name,username,password,Email;
    JPasswordField newpassword;
    
    public UserFrame()
    {
        
        setLayout(null);
        setTitle("userfile");
        setSize(220,150);
        setLocation(1138,130);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
        SIGNIN=new JButton("SIGN IN");
        SIGNIN.setBounds(0,0,210,55);
        SIGNIN.setBackground(Color.white);
        SIGNIN.setForeground(Color.black);
        add(SIGNIN);

        Signup=new JButton("SIGN UP");
        Signup.setBounds(0,55,210,55);
        Signup.setBackground(Color.white);
        Signup.setForeground(Color.red);
        add(Signup);
        Signup.addActionListener(new ActionSign());
        SIGNIN.addActionListener(new ActionSign());
        
                
                
        }
    class ActionSign implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==Signup)
                {
                    SignUp up=new SignUp();
                    setVisible(false);
                    up.setVisible(true);
                }
                if(e.getSource()==SIGNIN)
                {
                    login up=new login();
                    setVisible(false);
                    up.setVisible(true);
                }
            }
        }
}
