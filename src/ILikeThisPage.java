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
class ILikeThisPage extends JFrame
{
    JLabel ShoppersstopPicture,ILikeThisPagePicture,ILikeThisPictureQuoteI,ILikeThisPictureQuoteThis,ILikeThisPicture2,StayWithUsLabel,ILikeThisPicture1;
    public ILikeThisPage()
    {
        setLayout(null);
        setTitle("i Like This Page");
        setSize(650,450);
        setLocation(350,150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ImageIcon ShoppersstopPictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/shoppersstopLogo/shoppersstop.PNG"));
        ShoppersstopPicture=new JLabel(ShoppersstopPictureIcon);
        
        ShoppersstopPicture.setBounds(-400,-200,1430,500);
        ShoppersstopPicture.setBackground(Color.BLUE);
        add(ShoppersstopPicture);
        
        ImageIcon ILikeThisPagePictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/valentines-heart (2).PNG"));
        ILikeThisPagePicture=new JLabel(ILikeThisPagePictureIcon);
        
        ILikeThisPagePicture.setBounds(-620,-80,1430,500);
        ILikeThisPagePicture.setBackground(Color.BLUE);
        add(ILikeThisPagePicture);
        
        ILikeThisPictureQuoteI=new JLabel("I");
        ILikeThisPictureQuoteI.setBounds(40,150,80,35);
        ILikeThisPictureQuoteI.setBackground(Color.white);
        ILikeThisPictureQuoteI.setForeground(Color.DARK_GRAY);
        ILikeThisPictureQuoteI.setFont(new Font("monospaced", Font.BOLD, 30));
	add(ILikeThisPictureQuoteI);
        
        ILikeThisPictureQuoteThis=new JLabel("shoppersstoponlineshop.com");
        ILikeThisPictureQuoteThis.setBounds(130,150,500,35);
        ILikeThisPictureQuoteThis.setBackground(Color.white);
        ILikeThisPictureQuoteThis.setForeground(Color.darkGray);
        ILikeThisPictureQuoteThis.setFont(new Font("monospaced", Font.BOLD,30));
	add(ILikeThisPictureQuoteThis);
        
        StayWithUsLabel=new JLabel("Stay With Us");
        StayWithUsLabel.setBounds(210,200,500,35);
        StayWithUsLabel.setBackground(Color.white);
        StayWithUsLabel.setForeground(Color.red);
        StayWithUsLabel.setFont(new Font("monospaced", Font.BOLD,30));
	add(StayWithUsLabel);
        
        ImageIcon ILikeThisPictureIcon1=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/LikePage/qr-code.PNG"));
        ILikeThisPicture1=new JLabel(ILikeThisPictureIcon1);
        
        ILikeThisPicture1.setBounds(-350,70,1430,500);
        ILikeThisPicture1.setBackground(Color.white);
        add(ILikeThisPicture1);
        
        ImageIcon ILikeThisPictureIcon2=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/LikePage/barcode.PNG"));
        ILikeThisPicture2=new JLabel(ILikeThisPictureIcon2);
        
        ILikeThisPicture2.setBounds(-450,70,1430,500);
        ILikeThisPicture2.setBackground(Color.white);
        add(ILikeThisPicture2);
        


        
       
        
        

        
    }
}