/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
  public class LowerPanel1 extends JPanel
        {
            JLabel BrandsDescription,LightgrayBackground;;
            public LowerPanel1()
            {
                setSize(1500,60);
                setLayout(null);
                
                
                //adding BrandsDescription
                BrandsDescription=new JLabel("THE BRANDS WE LOVE ");
                BrandsDescription.setBounds(10,5,200,13);
                BrandsDescription.setBackground(Color.lightGray);
                BrandsDescription.setForeground(Color.BLACK);
                BrandsDescription.setFont(new Font("arial", Font.BOLD,12));
                add(BrandsDescription);
                
                //adding ritukumar brand icon
                ImageIcon RitukumarIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/ritu-kumar4 1.png"));
                JLabel RituKumar = new JLabel(RitukumarIcon);
                RituKumar.setBounds(10,20,130, 30);
                add(RituKumar);
                
                //adding biba brand icon
                ImageIcon BIBAIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/BIBA 1.jpg"));
                JLabel BIBA = new JLabel(BIBAIcon);
                BIBA.setBounds(150,20,80, 30);
                add(BIBA);
                
                //adding westecs brand icon
                ImageIcon WestecsIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/westecs 1.jpg"));
                JLabel Westecs = new JLabel(WestecsIcon);
                Westecs.setBounds(240,20,100, 30);
                add(Westecs);
                
                //adding sabyasachi brand icon
                ImageIcon SabyasachiIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/Sabyasachi-Mukherjee-Party-and-casual-wear-2015-5 1.jpg"));
                JLabel Sabyasachi = new JLabel(SabyasachiIcon);
                Sabyasachi.setBounds(350,5,160, 50);
                add(Sabyasachi);
                
                //adding eastasy brand icon
                ImageIcon eastasyIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/eastasy 1.jpg"));
                JLabel Eastasy = new JLabel(eastasyIcon);
                Eastasy.setBounds(520,10,70, 40);
                add(Eastasy);
                
                //adding Rohitbal brand icon
                ImageIcon rohitbalIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/rohitbal 1.jpg"));
                JLabel Rohitbal = new JLabel(rohitbalIcon);
                Rohitbal.setBounds(600,10,70, 40);
                add(Rohitbal);
                
                //adding Aurelia brand icon
                ImageIcon AureliaIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/Aurelia 1.jpg"));
                JLabel Aurelia = new JLabel(AureliaIcon);
                Aurelia.setBounds(680,10,83, 40);
                add(Aurelia);
                
                //adding AND brand icon
                ImageIcon ANDIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/AND-Logo 1.jpg"));
                JLabel AND = new JLabel(ANDIcon);
                AND.setBounds(773,10,70, 40);
                add(AND);
                
                //adding mandirawirk brand icon
                ImageIcon mandirawirkIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/mandira_wirk_logo_1528336596 1.jpg"));
                JLabel mandirawirk = new JLabel(mandirawirkIcon);
                mandirawirk.setBounds(853,10,70, 40);
                add(mandirawirk);
                
                //adding ashisnsoni brand icon
                ImageIcon ashisnsoniIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/ashisnsoni 1.jpg"));
                JLabel ashisnsoni = new JLabel(ashisnsoniIcon);
                ashisnsoni.setBounds(933,10,170, 40);
                add(ashisnsoni);
                
                //adding Raghavendra brand icon
                ImageIcon RaghavendraIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/13712256_536131246572745_1416759391_n 1.jpg"));
                JLabel Raghavendra = new JLabel(RaghavendraIcon);
                Raghavendra.setBounds(1113,0,70,55);
                add(Raghavendra);
                
                //adding khanijo brand icon
                ImageIcon khanijoIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/khanijo 1.jpg"));
                JLabel khanijo = new JLabel(khanijoIcon);
                khanijo.setBounds(1193,0,70, 55);
                add(khanijo);
                
                //adding Aarong brand icon
                ImageIcon AarongIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project pictures/Aarong_Logo_2010 1.jpg"));
                JLabel Aarong = new JLabel(AarongIcon);
                Aarong.setBounds(1273,0,70, 55);
                add(Aarong);
            
            
                //adding LightgrayBackground label
                LightgrayBackground=new JLabel("  ");
                LightgrayBackground.setBounds(0,0,1500,60);
                LightgrayBackground.setBackground(Color.lightGray);
                LightgrayBackground.setForeground(Color.lightGray);
                LightgrayBackground.setFont(new Font("monospaced", Font.BOLD, 30));
                add(LightgrayBackground);
                
            }
            
        }
