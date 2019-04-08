/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author user
 */
class CenterPanel extends JPanel
    {
        JButton NewArrivals,DesignerSpotlight,Sale,GentlemensClub,StopsWedding;
        JLabel GentlePic;
         static String[] Picture=new String[1000];
        
         String[] list={  "/shoppersstoponlineshop/Image Galary/new arrivalis.PNG",
                          "/shoppersstoponlineshop/Image Galary/designerspotlight.PNG",
                          "/shoppersstoponlineshop/Image Galary/sale.PNG",
                          "/shoppersstoponlineshop/Image Galary/gentlemenclub.PNG",
                          "/shoppersstoponlineshop/Image Galary/stops wedding2.PNG"};
                    Timer tm;
                    int x=0;
        public CenterPanel()
        {       
                setSize(1500,400);
                setLayout(null);
                 GentlePic=new JLabel();
        
                GentlePic.setBounds(450,0,1430,400);
                GentlePic.setBackground(Color.BLUE);
                
                tm=new Timer(1500,new ActionListener()
        {
            public void actionPerformed(ActionEvent we)
            {
                setimagesize(x);
                x++;
                if(x>=list.length)
                    x=0;
            }
        });
                add(GentlePic);
                tm.start();
    
               
             
                //adding NewArrivals button
                NewArrivals=new JButton("NEW ARRIVALS");
                NewArrivals.setBounds(0,0,200,80);
                NewArrivals.setBackground(Color.white);
                NewArrivals.setForeground(Color.darkGray);
                NewArrivals.setFont(new Font("serif", Font.PLAIN, 15));
                add(NewArrivals);
                             
                //adding DesignerSpotlight button
                DesignerSpotlight=new JButton("DESIGNER SPOTLIGHT");
                DesignerSpotlight.setBounds(0,80,200,80);
                DesignerSpotlight.setBackground(Color.white);
                DesignerSpotlight.setForeground(Color.darkGray);
                DesignerSpotlight.setFont(new Font("monospaced", Font.BOLD, 15));
                add(DesignerSpotlight);
                
                //adding Sale button
                Sale=new JButton("S   A   L   E");
                Sale.setBounds(0,160,200,80);
                Sale.setBackground(Color.white);
                Sale.setForeground(Color.darkGray);
                Sale.setFont(new Font("Arial", Font.BOLD, 16));
                add(Sale);
                
                //adding GentlemensClub button
                GentlemensClub=new JButton("G E N T L E M E N'S  CLUB");
                GentlemensClub.setBounds(0,240,200,80);
                GentlemensClub.setBackground(Color.white);
                GentlemensClub.setForeground(Color.darkGray);
                GentlemensClub.setFont(new Font("Arial", Font.BOLD, 12));
                add(GentlemensClub);
                
                //adding StopsWedding button
                StopsWedding=new JButton("S T O P ' S  W E D D I N G");
                StopsWedding.setBounds(0,320,200,80);
                StopsWedding.setBackground(Color.white);
                StopsWedding.setForeground(Color.red);
                StopsWedding.setFont(new Font("serif", Font.BOLD, 12));
                add(StopsWedding);
                
              NewArrivals.addActionListener(new Handler());
              DesignerSpotlight.addActionListener(new Handler());
              Sale.addActionListener(new Handler());
              GentlemensClub.addActionListener(new Handler());
              StopsWedding.addActionListener(new Handler());
                
        }
        class Handler implements ActionListener
        {
             public void actionPerformed(ActionEvent e)
             {
                 if(e.getSource()==NewArrivals)
                 {
                     ImageIcon icon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/Image Galary/new arrivalis.PNG"));
                     GentlePic.setIcon(icon);
                 }
                 else if(e.getSource()==DesignerSpotlight)
                 {
                     ImageIcon icon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/Image Galary/designerspotlight.PNG"));
                     GentlePic.setIcon(icon);
                 }
                 else if(e.getSource()==Sale)
                 {
                      ImageIcon icon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/Image Galary/sale.PNG"));
                     GentlePic.setIcon(icon);
                 }
                 else if(e.getSource()==GentlemensClub)
                 {
                      ImageIcon icon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/Image Galary/gentlemenclub.PNG"));
                     GentlePic.setIcon(icon);
                 }
                  else if(e.getSource()==StopsWedding)
                 {
                      ImageIcon icon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/Image Galary/stops wedding2.PNG"));
                     GentlePic.setIcon(icon);
                 }
             }
         }
        public void setimagesize(int i)
    {
        ImageIcon icon=new ImageIcon(getClass().getResource(list[i]));
        GentlePic.setIcon(icon);
    }
    }
