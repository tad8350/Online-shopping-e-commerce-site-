/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author user
 */
public class Sale extends JFrame 
{
    SalePanel sPane;
    JScrollPane Scroll;
    JPanel ContentPane;
    public Sale()
    {
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800,600);
        setLocation(260,70);
        sPane=new SalePanel();
        Scroll=new JScrollPane(sPane);
        Scroll.setBounds(0,0,780,600);
        sPane.setPreferredSize(new Dimension(800,40* sPane.getComponents().length));
        Scroll.setViewportView(sPane);
        Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ContentPane=new JPanel(null);
        ContentPane.add(Scroll);
        
        setContentPane(ContentPane);
    }
    
    
}
class SalePanel extends JPanel
{
    JLabel ShoppersstopPicture,ProccedToPay,CartQuote,ProductName,AgreeMent,TotalPriceBelow,Quantity,Price,TotalPrice,ProductNameBelow,PriceBelow,QuantityBelow,Grand,Total;
    JButton AddToCart;
    int y=235;
    Double GrandTotal=0.0;
    public SalePanel()
    {
        setLayout(null);
        
        setSize(800,600);
        setLocation(260,70);
        
        ImageIcon ShoppersstopPictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/shoppersstopLogo/shoppersstop.PNG"));
        ShoppersstopPicture=new JLabel(ShoppersstopPictureIcon);
        
        ShoppersstopPicture.setBounds(-315,-200,1430,500);
        ShoppersstopPicture.setBackground(Color.BLUE);
        add(ShoppersstopPicture);
        ProccedToPay=new JLabel("SALE");
        ProccedToPay.setBounds(380,110,80,25);
        ProccedToPay.setBackground(Color.white);
        ProccedToPay.setForeground(Color.BLACK);
        ProccedToPay.setFont(new Font("monospaced", Font.BOLD, 19));
	add(ProccedToPay);
        
        CartQuote=new JLabel("EVERYTHING IN YOUR CHOICE");
        CartQuote.setBounds(325,145,200,25);
        CartQuote.setBackground(Color.white);
        CartQuote.setForeground(Color.BLACK);
        CartQuote.setFont(new Font("serif", Font.PLAIN, 10));
	add(CartQuote);
        ProductName=new JLabel("USER NAME");
        ProductName.setBounds(50,200,100,25);
        ProductName.setBackground(Color.white);
        ProductName.setForeground(Color.BLACK);
        ProductName.setFont(new Font("serif", Font.BOLD, 12));
	add(ProductName);
        Price=new JLabel("CUSTOMER NAME");
        Price.setBounds(200,200,400,25);
        Price.setBackground(Color.white);
        Price.setForeground(Color.BLACK);
        Price.setFont(new Font("serif", Font.BOLD, 12));
	add(Price);
        TotalPrice=new JLabel("AMOUNT");
        TotalPrice.setBounds(650,200,200,25);
        TotalPrice.setBackground(Color.white);
        TotalPrice.setForeground(Color.BLACK);
        TotalPrice.setFont(new Font("serif", Font.BOLD, 12));
	add(TotalPrice);
        
        String rs="SELECT * FROM `sale` ";
        ResultSet rssale;
        DBConnector com=new DBConnector();
        rssale=com.setData(rs);
        try {
            while(rssale.next())
            {
         ProductNameBelow=new JLabel(rssale.getString("saleid"));
         ProductNameBelow.setBounds(50,y,100,25);
         ProductNameBelow.setBackground(Color.white);
         ProductNameBelow.setForeground(Color.red);
         ProductNameBelow.setFont(new Font("monospaced", Font.BOLD, 12));
	 add(ProductNameBelow);
         QuantityBelow=new JLabel((rssale.getString("Customer")));
         QuantityBelow.setBounds(200,y,400,25);
         QuantityBelow.setBackground(Color.white);
         QuantityBelow.setForeground(Color.red);
         QuantityBelow.setFont(new Font("monospaced", Font.BOLD, 12));
	 add(QuantityBelow);
         PriceBelow=new JLabel(Double.toString(rssale.getDouble("Amount"))+"/=");
         PriceBelow.setBounds(650,y,200,25);
         PriceBelow.setBackground(Color.white);
         PriceBelow.setForeground(Color.red);
         PriceBelow.setFont(new Font("monospaced", Font.BOLD, 12));
	 add(PriceBelow);
         y=y+25;
         GrandTotal=GrandTotal+rssale.getDouble("Amount");
         }
        } catch (SQLException ex) {
            
        }
        Grand=new JLabel("GrandTotal:");
        Grand.setBounds(490,y+25,200,25);
        Grand.setBackground(Color.white);
        Grand.setForeground(Color.red);
        Grand.setFont(new Font("monospaced", Font.BOLD, 14));
	add(Grand);
        Total=new JLabel(Double.toString(GrandTotal)+"/=");
        Total.setBounds(650,y+25,200,25);
        Total.setBackground(Color.white);
        Total.setForeground(Color.red);
        Total.setFont(new Font("monospaced", Font.BOLD, 14));
	add(Total);
}
}

