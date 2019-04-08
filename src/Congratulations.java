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
class Congratulations extends JFrame
{
    JLabel CongratulationsPicture,ThankuLabel;
    public Congratulations()
    {
       setLayout(null);
        setTitle("Login Frame");
        setSize(850,650);
        setLocation(250,50);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ImageIcon CongratulationsPictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/congratulations Image/congratulations.PNG"));
        CongratulationsPicture=new JLabel(CongratulationsPictureIcon);
        
        CongratulationsPicture.setBounds(-300,10,1430,500);
        CongratulationsPicture.setBackground(Color.BLUE);
        add(CongratulationsPicture);
        
        
        
        ThankuLabel=new JLabel("THANK YOU FOR SIGNING UP.");
        ThankuLabel.setBounds(200,510,1430,30);
        ThankuLabel.setBackground(Color.white);
        ThankuLabel.setForeground(Color.red);
        ThankuLabel.setFont(new Font("monospaced", Font.BOLD, 30));
        
	add(ThankuLabel);
        
    }
}