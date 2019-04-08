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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author user
 */
class MenProductAddToCart extends JFrame
{
    JLabel ShoppersstopPicture,AddToCart,MenProductQuantityBesideLabel,PriceAfterDiscountLabelBeside,PriceAfterDiscountLabel,DiscountLabelBeside,DiscountLabel,MenProductPriceLabelBeside,MenProductPriceLabel,StyleQuote,MenPictureNo1,MenProductQuantity,MenProductSize,MenProductSizeBeside,MenProductColor,MenProductColorBeside,MenProductNameBeside,MenProductIdBeside,MenProductName,MenProductId;
    JButton MenProductAddToCartButton;
    JTextField MenProductQuantityBeside;
    String [] ColorBox;
    String [] SizeBox;
    String [] s={"Not available"};
    String userId,table,username,pic;
    int counter,available;
    double price,discount;
    static double disprice;
   
    public MenProductAddToCart(String userId,String table,int counter,int available,int price,String username,String[] color,String[] size,int discount,String pic) 
    {   
        this.userId=userId;
        this.table=table;
        this.username=username;
        this.counter=counter;
        this.available= available;
        this.price=(double) price;
        this.discount=(double) discount;
        
        this.pic=pic;
        
        ColorBox=color;
        SizeBox=size;
        setLayout(null);
        setTitle("Add To Cart Frame");
        setSize(600,1200);
        setLocation(350,0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
       
        
        ImageIcon ShoppersstopPictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/shoppersstopLogo/shoppersstop.PNG"));
        ShoppersstopPicture=new JLabel(ShoppersstopPictureIcon);
        
        ShoppersstopPicture.setBounds(-425,-200,1430,500);
        ShoppersstopPicture.setBackground(Color.BLUE);
        add(ShoppersstopPicture);
        
        AddToCart=new JLabel("ADD TO CART");
        AddToCart.setBounds(230,110,200,25);
        AddToCart.setBackground(Color.white);
        AddToCart.setForeground(Color.BLACK);
        AddToCart.setFont(new Font("monospaced", Font.BOLD, 19));
	add(AddToCart);
        
        StyleQuote=new JLabel("Everything you need to rock out in style");
        StyleQuote.setBounds(195,145,300,25);
        StyleQuote.setBackground(Color.white);
        StyleQuote.setForeground(Color.BLACK);
        StyleQuote.setFont(new Font("serif", Font.PLAIN, 11));
	add(StyleQuote);
        
        ImageIcon MenPictureNo1Icon=new ImageIcon(getClass().getResource(pic));
        MenPictureNo1=new JLabel(MenPictureNo1Icon);
        
        MenPictureNo1.setBounds(30,190,250,420);
        MenPictureNo1.setBackground(Color.white);
        add(MenPictureNo1);
        
        MenProductName=new JLabel(" PRODUCT NAME :");
        MenProductName.setBounds(300,190,100,25);
        MenProductName.setBackground(Color.white);
        MenProductName.setForeground(Color.BLACK);
        MenProductName.setFont(new Font("serif", Font.PLAIN, 11));
	add(MenProductName);
        
        MenProductNameBeside=new JLabel(username);
        MenProductNameBeside.setBounds(400,190,300,25);
        MenProductNameBeside.setBackground(Color.white);
        MenProductNameBeside.setForeground(Color.BLACK);
        MenProductNameBeside.setFont(new Font("MONOSPACED", Font.PLAIN, 12));
	add(MenProductNameBeside);
        
        MenProductId=new JLabel(" PRODUCT ID        :");
        MenProductId.setBounds(300,225,300,25); 
        MenProductId.setBackground(Color.white);
        MenProductId.setForeground(Color.BLACK);
        MenProductId.setFont(new Font("serif", Font.PLAIN, 11));
	add(MenProductId);
        
        MenProductIdBeside=new JLabel(userId);
        MenProductIdBeside.setBounds(400,225,300,25);
        MenProductIdBeside.setBackground(Color.white);
        MenProductIdBeside.setForeground(Color.BLACK);
        MenProductIdBeside.setFont(new Font("monospaced", Font.PLAIN, 14));
	add(MenProductIdBeside);
        
        MenProductColor=new JLabel(" COLOR                  :");
        MenProductColor.setBounds(300,260,150,25);
        MenProductColor.setBackground(Color.white);
        MenProductColor.setForeground(Color.BLACK);
        MenProductColor.setFont(new Font("SERIF", Font.PLAIN, 11));
	add(MenProductColor);
        

        JComboBox ColorList=new JComboBox(ColorBox);
        ColorList.setBounds(410,260,150,25);
        ColorList.setBackground(Color.white);
        ColorList.setForeground(Color.BLACK);
        ColorList.setFont(new Font("monospaced", Font.BOLD, 12));
        add(ColorList);
        int i=ColorList.getSelectedIndex();
        
        
        MenProductSize=new JLabel(" SIZE                       :");
        MenProductSize.setBounds(300,295,150,25);
        MenProductSize.setBackground(Color.white);
        MenProductSize.setForeground(Color.BLACK);
        MenProductSize.setFont(new Font("SERIF", Font.PLAIN, 11));
	add(MenProductSize);
        
        

        JComboBox SizeList=new JComboBox(SizeBox);
        SizeList.setBounds(410,295,150,25);
        SizeList.setBackground(Color.white);
        SizeList.setForeground(Color.BLACK);
        SizeList.setFont(new Font("monospaced", Font.BOLD, 12));
        add(SizeList);
        int j=SizeList.getSelectedIndex();
        
        
        MenProductQuantity=new JLabel(" QUANTITY           :");
        MenProductQuantity.setBounds(300,330,150,25);
        MenProductQuantity.setBackground(Color.white);
        MenProductQuantity.setForeground(Color.BLACK);
        MenProductQuantity.setFont(new Font("SERIF", Font.PLAIN, 11));
	add(MenProductQuantity);
        
        MenProductQuantityBeside=new JTextField("1");
        MenProductQuantityBeside.setBounds(410,330,50,25);
        MenProductQuantityBeside.setBackground(Color.white);
        MenProductQuantityBeside.setForeground(Color.BLACK);
        MenProductQuantityBeside.setFont(new Font("monospaced", Font.PLAIN, 11));
	add(MenProductQuantityBeside);
        
        MenProductQuantityBesideLabel=new JLabel(" required");
        MenProductQuantityBesideLabel.setBounds(470,330,100,25);
        MenProductQuantityBesideLabel.setBackground(Color.white);
        MenProductQuantityBesideLabel.setForeground(Color.red);
        MenProductQuantityBesideLabel.setFont(new Font("monospaced", Font.PLAIN, 11));
	add(MenProductQuantityBesideLabel);
        
        MenProductPriceLabel=new JLabel(" Price                :");
        MenProductPriceLabel.setBounds(300,365,110,25);
        MenProductPriceLabel.setBackground(Color.white);
        MenProductPriceLabel.setForeground(Color.black);
        MenProductPriceLabel.setFont(new Font("serif", Font.PLAIN, 14));
	add(MenProductPriceLabel);
        
        MenProductPriceLabelBeside=new JLabel(Integer.toString(price));
        MenProductPriceLabelBeside.setBounds(400,365,150,25);
        MenProductPriceLabelBeside.setBackground(Color.white);
        MenProductPriceLabelBeside.setForeground(Color.black);
        MenProductPriceLabelBeside.setFont(new Font("monospaced", Font.PLAIN, 14));
	add(MenProductPriceLabelBeside);
        
        DiscountLabel=new JLabel(" DISCOUNT           :");
        DiscountLabel.setBounds(300,400,110,25);
        DiscountLabel.setBackground(Color.white);
        DiscountLabel.setForeground(Color.black);
        DiscountLabel.setFont(new Font("SERIF", Font.PLAIN, 12));
	add(DiscountLabel);
        
        DiscountLabelBeside=new JLabel(Integer.toString(discount)+"%");
        DiscountLabelBeside.setBounds(400,400,110,25);
        DiscountLabelBeside.setBackground(Color.white);
        DiscountLabelBeside.setForeground(Color.red);
        DiscountLabelBeside.setFont(new Font("monospaced", Font.PLAIN, 14));
	add(DiscountLabelBeside);
        
        double disprice=discalculate();
        PriceAfterDiscountLabel=new JLabel(" After Discount Price :");
        PriceAfterDiscountLabel.setBounds(300,435,150,25);
        PriceAfterDiscountLabel.setBackground(Color.white);
        PriceAfterDiscountLabel.setForeground(Color.black);
        PriceAfterDiscountLabel.setFont(new Font("serif", Font.PLAIN, 14));
	add(PriceAfterDiscountLabel);
        
        PriceAfterDiscountLabelBeside=new JLabel("   "+Double.toString(disprice));
        PriceAfterDiscountLabelBeside.setBounds(425,435,200,25);
        PriceAfterDiscountLabelBeside.setBackground(Color.white);
        PriceAfterDiscountLabelBeside.setForeground(Color.red);
        PriceAfterDiscountLabelBeside.setFont(new Font("monospaced", Font.PLAIN, 14));
	add(PriceAfterDiscountLabelBeside);
        
        MenProductAddToCartButton=new JButton(" ADD TO CART");
        MenProductAddToCartButton.setBounds(315,500,200,25);
        MenProductAddToCartButton.setBackground(Color.RED);
        MenProductAddToCartButton.setForeground(Color.WHITE);
        MenProductAddToCartButton.setFont(new Font("monospaced", Font.PLAIN, 12));
	add(MenProductAddToCartButton);
        MenProductAddToCartButton.addActionListener(new handler());
        
    }
     public MenProductAddToCart(String userId,String table,int counter,int available,int price,String username,int discount,String pic)
     {
         this.userId=userId;
        this.table=table;
        this.username=username;
        this.counter=counter;
        this.available= available;
        this.price=(double) price;
        this.discount=(double) discount;
        
        this.pic=pic;
        
        
        setLayout(null);
        setTitle("Add To Cart Frame");
        setSize(600,1200);
        setLocation(350,0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
       
        
        ImageIcon ShoppersstopPictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/shoppersstopLogo/shoppersstop.PNG"));
        ShoppersstopPicture=new JLabel(ShoppersstopPictureIcon);
        
        ShoppersstopPicture.setBounds(-425,-200,1430,500);
        ShoppersstopPicture.setBackground(Color.BLUE);
        add(ShoppersstopPicture);
        
        AddToCart=new JLabel("ADD TO CART");
        AddToCart.setBounds(230,110,200,25);
        AddToCart.setBackground(Color.white);
        AddToCart.setForeground(Color.BLACK);
        AddToCart.setFont(new Font("monospaced", Font.BOLD, 19));
	add(AddToCart);
        
        StyleQuote=new JLabel("Everything you need to rock out in style");
        StyleQuote.setBounds(195,145,300,25);
        StyleQuote.setBackground(Color.white);
        StyleQuote.setForeground(Color.BLACK);
        StyleQuote.setFont(new Font("serif", Font.PLAIN, 11));
	add(StyleQuote);
        
        ImageIcon MenPictureNo1Icon=new ImageIcon(getClass().getResource(pic));
        MenPictureNo1=new JLabel(MenPictureNo1Icon);
        
        MenPictureNo1.setBounds(30,190,250,420);
        MenPictureNo1.setBackground(Color.white);
        add(MenPictureNo1);
        
        MenProductName=new JLabel(" PRODUCT NAME :");
        MenProductName.setBounds(300,190,100,25);
        MenProductName.setBackground(Color.white);
        MenProductName.setForeground(Color.BLACK);
        MenProductName.setFont(new Font("serif", Font.PLAIN, 11));
	add(MenProductName);
        
        MenProductNameBeside=new JLabel(username);
        MenProductNameBeside.setBounds(400,190,300,25);
        MenProductNameBeside.setBackground(Color.white);
        MenProductNameBeside.setForeground(Color.BLACK);
        MenProductNameBeside.setFont(new Font("MONOSPACED", Font.PLAIN, 12));
	add(MenProductNameBeside);
        
        MenProductId=new JLabel(" PRODUCT ID        :");
        MenProductId.setBounds(300,225,300,25); 
        MenProductId.setBackground(Color.white);
        MenProductId.setForeground(Color.BLACK);
        MenProductId.setFont(new Font("serif", Font.PLAIN, 11));
	add(MenProductId);
        
        MenProductIdBeside=new JLabel(userId);
        MenProductIdBeside.setBounds(400,225,300,25);
        MenProductIdBeside.setBackground(Color.white);
        MenProductIdBeside.setForeground(Color.BLACK);
        MenProductIdBeside.setFont(new Font("monospaced", Font.PLAIN, 14));
	add(MenProductIdBeside);
        
        MenProductColor=new JLabel(" COLOR                  :");
        MenProductColor.setBounds(300,260,150,25);
        MenProductColor.setBackground(Color.white);
        MenProductColor.setForeground(Color.BLACK);
        MenProductColor.setFont(new Font("SERIF", Font.PLAIN, 11));
	add(MenProductColor);
        

        JComboBox ColorList=new JComboBox(s);
        ColorList.setBounds(410,260,150,25);
        ColorList.setBackground(Color.white);
        ColorList.setForeground(Color.BLACK);
        ColorList.setFont(new Font("monospaced", Font.BOLD, 12));
        add(ColorList);
        int i=ColorList.getSelectedIndex();
        
        
        MenProductSize=new JLabel(" SIZE                       :");
        MenProductSize.setBounds(300,295,150,25);
        MenProductSize.setBackground(Color.white);
        MenProductSize.setForeground(Color.BLACK);
        MenProductSize.setFont(new Font("SERIF", Font.PLAIN, 11));
	add(MenProductSize);
        
        

        JComboBox SizeList=new JComboBox(s);
        SizeList.setBounds(410,295,150,25);
        SizeList.setBackground(Color.white);
        SizeList.setForeground(Color.BLACK);
        SizeList.setFont(new Font("monospaced", Font.BOLD, 12));
        add(SizeList);
        int j=SizeList.getSelectedIndex();
        
        
        MenProductQuantity=new JLabel(" QUANTITY           :");
        MenProductQuantity.setBounds(300,330,150,25);
        MenProductQuantity.setBackground(Color.white);
        MenProductQuantity.setForeground(Color.BLACK);
        MenProductQuantity.setFont(new Font("SERIF", Font.PLAIN, 11));
	add(MenProductQuantity);
        
        MenProductQuantityBeside=new JTextField("1");
        MenProductQuantityBeside.setBounds(410,330,50,25);
        MenProductQuantityBeside.setBackground(Color.white);
        MenProductQuantityBeside.setForeground(Color.BLACK);
        MenProductQuantityBeside.setFont(new Font("monospaced", Font.PLAIN, 11));
	add(MenProductQuantityBeside);
        
        MenProductQuantityBesideLabel=new JLabel(" required");
        MenProductQuantityBesideLabel.setBounds(470,330,100,25);
        MenProductQuantityBesideLabel.setBackground(Color.white);
        MenProductQuantityBesideLabel.setForeground(Color.red);
        MenProductQuantityBesideLabel.setFont(new Font("monospaced", Font.PLAIN, 11));
	add(MenProductQuantityBesideLabel);
        
        MenProductPriceLabel=new JLabel(" Price                :");
        MenProductPriceLabel.setBounds(300,365,110,25);
        MenProductPriceLabel.setBackground(Color.white);
        MenProductPriceLabel.setForeground(Color.black);
        MenProductPriceLabel.setFont(new Font("serif", Font.PLAIN, 14));
	add(MenProductPriceLabel);
        
        MenProductPriceLabelBeside=new JLabel(Integer.toString(price));
        MenProductPriceLabelBeside.setBounds(400,365,150,25);
        MenProductPriceLabelBeside.setBackground(Color.white);
        MenProductPriceLabelBeside.setForeground(Color.black);
        MenProductPriceLabelBeside.setFont(new Font("monospaced", Font.PLAIN, 14));
	add(MenProductPriceLabelBeside);
        
        DiscountLabel=new JLabel(" DISCOUNT           :");
        DiscountLabel.setBounds(300,400,110,25);
        DiscountLabel.setBackground(Color.white);
        DiscountLabel.setForeground(Color.black);
        DiscountLabel.setFont(new Font("SERIF", Font.PLAIN, 12));
	add(DiscountLabel);
        
        DiscountLabelBeside=new JLabel(Integer.toString(discount)+"%");
        DiscountLabelBeside.setBounds(400,400,110,25);
        DiscountLabelBeside.setBackground(Color.white);
        DiscountLabelBeside.setForeground(Color.red);
        DiscountLabelBeside.setFont(new Font("monospaced", Font.PLAIN, 14));
	add(DiscountLabelBeside);
        
        disprice=discalculate();
        PriceAfterDiscountLabel=new JLabel(" After Discount Price :");
        PriceAfterDiscountLabel.setBounds(300,435,150,25);
        PriceAfterDiscountLabel.setBackground(Color.white);
        PriceAfterDiscountLabel.setForeground(Color.black);
        PriceAfterDiscountLabel.setFont(new Font("serif", Font.PLAIN, 14));
	add(PriceAfterDiscountLabel);
        
        PriceAfterDiscountLabelBeside=new JLabel("   "+Double.toString(disprice));
        PriceAfterDiscountLabelBeside.setBounds(425,435,200,25);
        PriceAfterDiscountLabelBeside.setBackground(Color.white);
        PriceAfterDiscountLabelBeside.setForeground(Color.red);
        PriceAfterDiscountLabelBeside.setFont(new Font("monospaced", Font.PLAIN, 14));
	add(PriceAfterDiscountLabelBeside);
        
        MenProductAddToCartButton=new JButton(" ADD TO CART");
        MenProductAddToCartButton.setBounds(315,500,200,25);
        MenProductAddToCartButton.setBackground(Color.RED);
        MenProductAddToCartButton.setForeground(Color.WHITE);
        MenProductAddToCartButton.setFont(new Font("monospaced", Font.PLAIN, 12));
	add(MenProductAddToCartButton);
        MenProductAddToCartButton.addActionListener(new handler());
     }
    public double discalculate()
    {
        double disprice;
        disprice=price-(price*(discount/100));
        //System.out.println(disprice);
        return disprice;
    }
    public class handler implements ActionListener
    {
        public void actionPerformed(ActionEvent we)
        {   
            int quantity=Integer.parseInt(MenProductQuantityBeside.getText());
            
            if(quantity>available)
            {
                JOptionPane.showMessageDialog(rootPane, "Don't Have enough product");
            }
            else{
            Double TotalPrice= quantity *discalculate();
            
            proccedtokart ab=new proccedtokart(userId,username,discalculate(),quantity,TotalPrice,table,available);
            
            
            KartLayout a=new KartLayout();
            a.setVisible(true);}
        }
    }
}