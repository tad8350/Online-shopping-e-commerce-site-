/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author projna
 */
class TrackOrder extends JFrame
{
    JLabel TrackOrderLabel,TrackOrderLabel2,ShoppersstopPicture;
    JButton SubmitButton;
    JTextField EmailAddressField,OrderNumberField;
    public TrackOrder()
    {
        setLayout(null);
        setTitle("Truck Order");
        setSize(600,1200);
        setLocation(350,0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ImageIcon ShoppersstopPictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/shoppersstopLogo/shoppersstop.PNG"));
        ShoppersstopPicture=new JLabel(ShoppersstopPictureIcon);
        
        ShoppersstopPicture.setBounds(-420,-200,1430,500);
        ShoppersstopPicture.setBackground(Color.BLUE);
        add(ShoppersstopPicture);
        
        TrackOrderLabel=new JLabel("TRACK ORDER");
        TrackOrderLabel.setBounds(220,150,250,35);
        TrackOrderLabel.setBackground(Color.white);
        TrackOrderLabel.setForeground(Color.BLACK);
        TrackOrderLabel.setFont(new Font("monospaced", Font.BOLD,25));
	add(TrackOrderLabel);
        
        
        TrackOrderLabel2=new JLabel("To track your order, please enter your Order Number");
        TrackOrderLabel2.setBounds(100,205,500,35);
        TrackOrderLabel2.setBackground(Color.white);
        TrackOrderLabel2.setForeground(Color.BLACK);
        TrackOrderLabel2.setFont(new Font("monospaced", Font.PLAIN,14));
	add(TrackOrderLabel2);
        
        EmailAddressField=new JTextField("Email Address");
        EmailAddressField.setBounds(150,250,300,35);
        EmailAddressField.setBackground(Color.white);
        EmailAddressField.setForeground(Color.lightGray);
        EmailAddressField.setFont(new Font("monospaced", Font.BOLD,12));
	add(EmailAddressField);
        
        OrderNumberField=new JTextField("Enter Order Number");
        OrderNumberField.setBounds(150,295,300,35);
        OrderNumberField.setBackground(Color.white);
        OrderNumberField.setForeground(Color.lightGray);
        OrderNumberField.setFont(new Font("monospaced", Font.BOLD,12));
	add(OrderNumberField);
        
        SubmitButton=new JButton("Submit");
        SubmitButton.setBounds(150,340,300,35);
        SubmitButton.setBackground(Color.red);
        SubmitButton.setForeground(Color.white);
        SubmitButton.setFont(new Font("monospaced", Font.BOLD,16));
	add(SubmitButton);
        
   


        
       
        
        

        
    }
}