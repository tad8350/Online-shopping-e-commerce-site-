/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Projna
 */
class PaymentConfirmation extends JFrame
{
    JLabel ShoppersstopPicture,ShoppingCartLabel,StartSomethingNewLabel,ShoppingCartQuote,TokenNumberAutoGebaratedCodeLabel,TokenNumberLabel,ThankuForYourCooperationLabel;
    public PaymentConfirmation()
    {
        setLayout(null);
        setTitle("SELECTED PRODUCT Frame");
        setSize(600,1200);
        setLocation(350,0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ImageIcon ShoppersstopPictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/shoppersstopLogo/shoppersstop.PNG"));
        ShoppersstopPicture=new JLabel(ShoppersstopPictureIcon);
        
        ShoppersstopPicture.setBounds(-425,-200,1430,500);
        ShoppersstopPicture.setBackground(Color.BLUE);
        add(ShoppersstopPicture);
        
        ShoppingCartLabel=new JLabel("SHOPPING CART");
        ShoppingCartLabel.setBounds(215,110,150,25);
        ShoppingCartLabel.setBackground(Color.white);
        ShoppingCartLabel.setForeground(Color.red);
        ShoppingCartLabel.setFont(new Font("monospaced", Font.BOLD, 19));
	add(ShoppingCartLabel);
        
        StartSomethingNewLabel=new JLabel(" START SOMETHING NEW");
        StartSomethingNewLabel.setBounds(225,145,140,25);
        StartSomethingNewLabel.setBackground(Color.white);
        StartSomethingNewLabel.setForeground(Color.BLACK);
        StartSomethingNewLabel.setFont(new Font("serif", Font.PLAIN, 10));
	add(StartSomethingNewLabel);
        
        ThankuForYourCooperationLabel=new JLabel(" THANK YOU FOR YOUR NICE CO-OPERATION.");
        ThankuForYourCooperationLabel.setBounds(140,250,500,25);
        ThankuForYourCooperationLabel.setBackground(Color.white);
        ThankuForYourCooperationLabel.setForeground(Color.BLACK);
        ThankuForYourCooperationLabel.setFont(new Font("monospaced", Font.BOLD, 14));
	add(ThankuForYourCooperationLabel);
        
        TokenNumberLabel=new JLabel(" THANKS AGAIN FOR STOPPING BY HERE");
        TokenNumberLabel.setBounds(115,295,570,25);
        TokenNumberLabel.setBackground(Color.white);
        TokenNumberLabel.setForeground(Color.blue);
        TokenNumberLabel.setFont(new Font("monospaced", Font.BOLD, 18));
	add(TokenNumberLabel);
        
        
        
        ShoppingCartQuote=new JLabel("© 2016 SHOPPERS STOP LTD. ALL RIGHTS RESERVED.");
        ShoppingCartQuote.setBounds(140,500,400,35);
        ShoppingCartQuote.setBackground(Color.white);
        ShoppingCartQuote.setForeground(Color.darkGray);
        ShoppingCartQuote.setFont(new Font("monospaced", Font.BOLD, 12));
        add(ShoppingCartQuote);
    }
}