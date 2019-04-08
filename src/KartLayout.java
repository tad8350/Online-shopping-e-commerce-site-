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
 * @author user
 */
public class KartLayout extends JFrame 
{
    JLabel ShoppersstopPicture,ProccedToPay,CartQuote,ProductName,AgreeMent,TotalPriceBelow,Quantity,Price,TotalPrice,ProductNameBelow,PriceBelow,QuantityBelow,Grand,Total;
    JButton AddToCart;
    static JButton[] removebutton=new JButton[10000];
    int y=235;
    Double GrandTotal=0.0;
    
    public KartLayout()
    { 
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1100,600);
        setLocation(260,70);
        
        ImageIcon ShoppersstopPictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/shoppersstopLogo/shoppersstop.PNG"));
        ShoppersstopPicture=new JLabel(ShoppersstopPictureIcon);
        
        ShoppersstopPicture.setBounds(-315,-200,1430,500);
        ShoppersstopPicture.setBackground(Color.BLUE);
        add(ShoppersstopPicture);
        
        ProccedToPay=new JLabel("CART");
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
        
        ProductName=new JLabel("PRODUCT NAME");
        ProductName.setBounds(50,200,300,25);
        ProductName.setBackground(Color.white);
        ProductName.setForeground(Color.BLACK);
        ProductName.setFont(new Font("serif", Font.BOLD, 12));
	add(ProductName);
        
        
        
        Quantity=new JLabel("QUANTITY");
        Quantity.setBounds(370,200,100,25);
        Quantity.setBackground(Color.white);
        Quantity.setForeground(Color.BLACK);
        Quantity.setFont(new Font("serif", Font.BOLD, 12));
	add(Quantity);
        
        Price=new JLabel("PRICE");
        Price.setBounds(490,200,200,25);
        Price.setBackground(Color.white);
        Price.setForeground(Color.BLACK);
        Price.setFont(new Font("serif", Font.BOLD, 12));
	add(Price);
        TotalPrice=new JLabel("TOTAL PRICE");
        TotalPrice.setBounds(650,200,200,25);
        TotalPrice.setBackground(Color.white);
        TotalPrice.setForeground(Color.BLACK);
        TotalPrice.setFont(new Font("serif", Font.BOLD, 12));
	add(TotalPrice);
        for(int i=0;i<proccedtokart.Counter;i++)
        {
        ProductNameBelow=new JLabel(proccedtokart.ProductName[i]);
        ProductNameBelow.setBounds(50,y,300,25);
        ProductNameBelow.setBackground(Color.white);
        ProductNameBelow.setForeground(Color.red);
        ProductNameBelow.setFont(new Font("monospaced", Font.BOLD, 12));
	add(ProductNameBelow);
        
          
        QuantityBelow=new JLabel(Integer.toString(proccedtokart.Quantity[i]));
        QuantityBelow.setBounds(370,y,100,25);
        QuantityBelow.setBackground(Color.white);
        QuantityBelow.setForeground(Color.red);
        QuantityBelow.setFont(new Font("monospaced", Font.BOLD, 12));
	add(QuantityBelow);
        
        
        
        PriceBelow=new JLabel(Double.toString(proccedtokart.Price[i])+"/=");
        PriceBelow.setBounds(490,y,200,25);
        PriceBelow.setBackground(Color.white);
        PriceBelow.setForeground(Color.red);
        PriceBelow.setFont(new Font("monospaced", Font.BOLD, 12));
	add(PriceBelow);
        
        
        
        TotalPriceBelow=new JLabel(Double.toString(proccedtokart.TotalPrice[i])+"/=");
        TotalPriceBelow.setBounds(650,y,200,25);
        TotalPriceBelow.setBackground(Color.white);
        TotalPriceBelow.setForeground(Color.red);
        TotalPriceBelow.setFont(new Font("monospaced", Font.BOLD, 12));
	add(TotalPriceBelow);
        removebutton[i]=new JButton("Remove");
        removebutton[i].setBounds(810, y, 200, 25);
        add(removebutton[i]);
        
        
        GrandTotal=GrandTotal+proccedtokart.TotalPrice[i];
        y=y+25;
        }
        for(int i=0;i<proccedtokart.Counter;i++)
        {
            removebutton[i].addActionListener(new remvoehandler());
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
        
        AddToCart=new JButton("PROCEED TO PAY");
        AddToCart.setBounds(300,y+60,200,25);
        AddToCart.setBackground(Color.red);
        AddToCart.setForeground(Color.white);
        AddToCart.setFont(new Font("monospaced", Font.BOLD, 14));
	add(AddToCart);
        
      
        AgreeMent=new JLabel("Â© 2016 SHOPPERS STOP LTD. ALL RIGHTS RESERVED.");
        AgreeMent.setBounds(245,y+85,500,25);
        AgreeMent.setBackground(Color.white);
        AgreeMent.setForeground(Color.darkGray);
        AgreeMent.setFont(new Font("monospaced", Font.BOLD, 11));
	add(AgreeMent);
        AddToCart.addActionListener(new Handler());
    

       
}
     class Handler implements ActionListener
        {
            public void actionPerformed(ActionEvent we)
            {
                if(GrandTotal<=0.)
                {
                    JOptionPane.showMessageDialog(AgreeMent,"No Product Selected.Please Add item first to go to payment");
                }
                else
                {
                if(login.flag==false)
                {
                    login a=new login();
                    a.setVisible(true);
                }
                else
                {
                  Payment a=new Payment(GrandTotal);
                  a.setVisible(true);
                  setVisible(false); 
                }
            }
            }
        }
     class remvoehandler implements ActionListener
     {

        
        public void actionPerformed(ActionEvent e)
        {
        for(int i=0;i<proccedtokart.Counter;i++)
        {
            if(e.getSource()==removebutton[i])
            {
                int count=i;
                for(int j=0;j<proccedtokart.Counter-1;j++)
                {
                    if(j<count)
                    {
                        continue;
                    }
                    else
                    {
                        proccedtokart.Productid[j]=proccedtokart.Productid[j+1];
                        proccedtokart.ProductName[j]=proccedtokart.ProductName[j+1];
                        proccedtokart.Price[j]=proccedtokart.Price[j+1];
                        proccedtokart.Quantity[j]=proccedtokart.Quantity[j+1];
                        proccedtokart.TotalPrice[j]=proccedtokart.TotalPrice[j+1];
                        proccedtokart.Table[j]=proccedtokart.Table[j+1];
                        proccedtokart.Available[j]=proccedtokart.Available[j+1];
                    }
                }
                proccedtokart.Counter--;
                KartLayout AF=new KartLayout();
                setVisible(false);
                AF.setVisible(true);
                
            }
            
        }
        }
         
     }
}
    
    




    
   

    
