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
class SubscribeFrame extends JFrame
{
    JLabel SubscribePicture1,SubscribePictureQuote1,SubscribePictureQuote2,ShoppersstopPicture;
    public SubscribeFrame()
    {
        setLayout(null);
        setTitle("Subscriber");
        setSize(600,1200);
        setLocation(350,0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ImageIcon SubscribePicture1Icon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/Subscribe/welcome.PNG"));
        SubscribePicture1=new JLabel(SubscribePicture1Icon);
        
        SubscribePicture1.setBounds(-420,-90,1430,500);
        SubscribePicture1.setBackground(Color.BLUE);
        add(SubscribePicture1);
        
        SubscribePictureQuote1=new JLabel("Now You Are Our Subscriber.");
        SubscribePictureQuote1.setBounds(50,400,600,35);
        SubscribePictureQuote1.setBackground(Color.white);
        SubscribePictureQuote1.setForeground(Color.red);
        SubscribePictureQuote1.setFont(new Font("monospaced", Font.BOLD, 30));
	add(SubscribePictureQuote1);
        
        SubscribePictureQuote2=new JLabel("You Will Get Our Updates!!!");
        SubscribePictureQuote2.setBounds(130,455,600,35);
        SubscribePictureQuote2.setBackground(Color.white);
        SubscribePictureQuote2.setForeground(Color.BLACK);
        SubscribePictureQuote2.setFont(new Font("monospaced", Font.BOLD, 20));
	add(SubscribePictureQuote2);
        
        ImageIcon ShoppersstopPictureIcon2=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/shoppersstopLogo/shoppersstop2.PNG"));
        ShoppersstopPicture=new JLabel(ShoppersstopPictureIcon2);
        
        ShoppersstopPicture.setBounds(-420,350,1430,500);
        ShoppersstopPicture.setBackground(Color.BLUE);
        add(ShoppersstopPicture);
        
        
       
        
        

        
    }
}