/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Projna
 */
public class Payment extends JFrame
{
    JLabel ShoppersstopPicture,Payment,PaymentQuote,AgreeMent,UserName,UserNameBESIDE,UserID,UserIDBESIDE,UserEmail,UserEmailBESIDE,Totallabel,Total,selectionlabel;
    JRadioButton CARD,BKash,OnDelivery,ROCKET;
    ButtonGroup group1;
    JButton PaymentButton;
    JTextField RadioButtonSelection;
    Double total;
    public Payment(Double to)
    {   
        total=to;
        setLayout(null);
        setTitle("SIGNUP Frame");
        setSize(800,600);
        setLocation(260,70);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ImageIcon ShoppersstopPictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/shoppersstopLogo/shoppersstop.PNG"));
        ShoppersstopPicture=new JLabel(ShoppersstopPictureIcon);
        
        ShoppersstopPicture.setBounds(-315,-200,1430,500);
        ShoppersstopPicture.setBackground(Color.BLUE);
        add(ShoppersstopPicture);
        
          
        Payment=new JLabel("PAYMENT");
        Payment.setBounds(360,110,80,25);
        Payment.setBackground(Color.white);
        Payment.setForeground(Color.RED);
        Payment.setFont(new Font("monospaced", Font.BOLD, 19));
	add(Payment);
        
        PaymentQuote=new JLabel("NOW PAYMENT IS IN YOUR FINGURE TIPS");
        PaymentQuote.setBounds(300,145,300,25);
        PaymentQuote.setBackground(Color.white);
        PaymentQuote.setForeground(Color.BLACK);
        PaymentQuote.setFont(new Font("SERIF", Font.PLAIN, 10));
	add(PaymentQuote);
        
        UserID=new JLabel("USER ID");
        UserID.setBounds(300,180,100,25);
        UserID.setBackground(Color.white);
        UserID.setForeground(Color.BLACK);
        UserID.setFont(new Font("SERIF", Font.BOLD, 11));
	add(UserID);
        
        UserIDBESIDE=new JLabel(":  "+LogOutFrame.UserDetails);
        UserIDBESIDE.setBounds(430,180,100,25);
        UserIDBESIDE.setBackground(Color.white);
        UserIDBESIDE.setForeground(Color.RED);
        UserIDBESIDE.setFont(new Font("MONOSPACED", Font.PLAIN, 12));
	add(UserIDBESIDE);
        
        UserName=new JLabel("USER NAME");
        UserName.setBounds(300,215,100,25);
        UserName.setBackground(Color.white);
        UserName.setForeground(Color.BLACK);
        UserName.setFont(new Font("SERIF", Font.BOLD, 11));
	add(UserName);
        
        UserNameBESIDE=new JLabel(": "+LogOutFrame.Firstname+" "+LogOutFrame.lastname);
        UserNameBESIDE.setBounds(430,215,200,25);
        UserNameBESIDE.setBackground(Color.white);
        UserNameBESIDE.setForeground(Color.RED);
        UserNameBESIDE.setFont(new Font("MONOSPACED", Font.PLAIN, 12));
	add(UserNameBESIDE);
        
        UserEmail=new JLabel("EMAIL ADDRESS");
        UserEmail.setBounds(300,250,100,25);
        UserEmail.setBackground(Color.white);
        UserEmail.setForeground(Color.BLACK);
        UserEmail.setFont(new Font("SERIF", Font.BOLD, 11));
	add(UserEmail);
        
        UserEmailBESIDE=new JLabel(": "+LogOutFrame.email);
        UserEmailBESIDE.setBounds(430,250,200,25);
        UserEmailBESIDE.setBackground(Color.white);
        UserEmailBESIDE.setForeground(Color.RED);
        UserEmailBESIDE.setFont(new Font("MONOSPACED", Font.BOLD, 12));
	add(UserEmailBESIDE);
        
        Totallabel=new JLabel("GRAND TOTAL");
        Totallabel.setBounds(300,285,100,25);
        Totallabel.setBackground(Color.white);
        Totallabel.setForeground(Color.BLACK);
        Totallabel.setFont(new Font("SERIF", Font.BOLD, 11));
	add(Totallabel);
        
        Total=new JLabel(":  "+Double.toString(total));
        Total.setBounds(430,285,200,25);
        Total.setBackground(Color.white);
        Total.setForeground(Color.red);
        Total.setFont(new Font("SERIF", Font.BOLD, 11));
	add(Total);
        
        
        CARD=new JRadioButton("CARD",false);
        CARD.setBounds(200, 330, 100, 20);
        CARD.setFont(new Font("monospaced", Font.PLAIN, 12));
        CARD.setForeground(Color.black);
        BKash=new JRadioButton("BKash",false);
        BKash.setBounds(320, 330, 100, 20);
        BKash.setFont(new Font("monospaced", Font.PLAIN, 12));
        BKash.setForeground(Color.black);
        OnDelivery=new JRadioButton("On Delivery",false);
        OnDelivery.setBounds(440, 330, 120, 20);
        OnDelivery.setFont(new Font("monospaced", Font.PLAIN, 12));
        OnDelivery.setForeground(Color.black);
        ROCKET=new JRadioButton("ROCKET",false);
        ROCKET.setBounds(560, 330, 100, 20);
        ROCKET.setFont(new Font("monospaced", Font.PLAIN, 12));
        ROCKET.setForeground(Color.BLACK);
        add(CARD);
        add(BKash);
        add(OnDelivery);
        add(ROCKET);
        group1=new ButtonGroup();
        group1.add(CARD);
        group1.add(BKash);
        group1.add(OnDelivery);
        group1.add(ROCKET);
        
        RadioButtonSelection=new JTextField("");
        RadioButtonSelection.setBounds(300,420,200,25);
        RadioButtonSelection.setBackground(Color.white);
        RadioButtonSelection.setForeground(Color.RED);
        RadioButtonSelection.setFont(new Font("MONOSPACED", Font.BOLD, 12));
        
	add(RadioButtonSelection);
        
        
        selectionlabel=new JLabel("");
        selectionlabel.setBounds(300,385,500,25);
        selectionlabel.setBackground(Color.white);
        selectionlabel.setForeground(Color.RED);
        selectionlabel.setFont(new Font("MONOSPACED", Font.BOLD, 12));
        add(selectionlabel);
        
        
        PaymentButton=new JButton("PAYMENT");
        PaymentButton.setBounds(300,455,200,25);
        PaymentButton.setBackground(Color.RED);
        PaymentButton.setForeground(Color.WHITE);
        PaymentButton.setFont(new Font("MONOSPACED", Font.BOLD, 12));
	add(PaymentButton);
        
        AgreeMent=new JLabel("© 2016 SHOPPERS STOP LTD. ALL RIGHTS RESERVED.");
        AgreeMent.setBounds(245,485,500,25);
        AgreeMent.setBackground(Color.white);
        AgreeMent.setForeground(Color.darkGray);
        AgreeMent.setFont(new Font("monospaced", Font.BOLD, 11));
	add(AgreeMent);
        
        CARD.addActionListener(new Handler());
        BKash.addActionListener(new Handler());
        OnDelivery.addActionListener(new Handler());
        ROCKET.addActionListener(new Handler());
        PaymentButton.addActionListener(new Handler());
        
        
        
        
    }
    class Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent we)
        {
            if(we.getSource()==CARD)
            {
                selectionlabel.setText("Enter your card number");
                RadioButtonSelection.setVisible(true);
                RadioButtonSelection.setText("");
            }
             if(we.getSource()==BKash)
            {
                selectionlabel.setText("Pay to:No.1732455;transcation id :5213");
                RadioButtonSelection.setVisible(false);
            }
              if(we.getSource()==OnDelivery)
            {
                selectionlabel.setText("Enter your address");
                RadioButtonSelection.setVisible(true);
                RadioButtonSelection.setText("");
            }
               if(we.getSource()==ROCKET)
            {
                selectionlabel.setText("Pay to:No.1732455;transcation id :5213");
                RadioButtonSelection.setVisible(false);;
            } 
               if(we.getSource()==PaymentButton)
            {
                String rs="INSERT INTO `Sale`(`saleid`, `Customer`, `Amount`) VALUES ('"+LogOutFrame.UserDetails+"','"+LogOutFrame.Firstname+" "+LogOutFrame.lastname+"','"+total+"')";
                DBConnector com=new DBConnector();
                com.updateData(rs);
                for(int i=0;i<proccedtokart.Counter;i++)
                {   
                    int size=proccedtokart.Available[i]-proccedtokart.Quantity[i];
                    String rsupdate="UPDATE `"+proccedtokart.Table[i]+"` SET `Available`='"+size+"'";
                    com.updateData(rsupdate);}
                
                    PaymentConfirmation con=new PaymentConfirmation();
                    con.setVisible(true);
                    setVisible(false);
                    proccedtokart.Counter=0; 
            }
                    
            
               
        }
    }

    
    }
