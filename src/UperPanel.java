/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
/**
 *
 * @author user
 */
 public class UperPanel extends JPanel
    {
        JTextField SearchField;
        JButton JustIn,Men,Women,Child,Accessories,WinterSale,User,SearchButton,Notification,HomeIcon,Currency,cart,notificaton,DelivaryTruck;
        Label BlackBackground1,Shoppers4,Shoppers3,Shoppers1,Shoppers2,WhiteBackground;
        MenButtonFrame ab;
        
        JMenuBar menuBar;
        static boolean flag;
        static String user;
        
        
        
        
        public UperPanel()
        { 
                
                 
                setSize(1500,158);
                setLayout(null);
                JFrame a=new JFrame();
                
                menuBar = new JMenuBar();
                //a.setJMenuBar(menuBar);
                
                
                JMenu fileMenu = new JMenu("Contact Us");
                menuBar.add(fileMenu);
                menuBar.setFont(new Font("monospaced", Font.PLAIN, 12));
                
                JMenuItem WhatsAppAction = new JMenuItem("WhatsApp : +8801236547891");
                JMenuItem CustomerCareAction = new JMenuItem("Customer Care : +8801144778855");
                JMenuItem MailAction = new JMenuItem("Email ID : info@shoppersstop.com");
                JMenuItem FacebookAction=new JMenuItem("Connect Us:ShoppersStop@gmail.com");
                JMenuItem CallAction = new JMenuItem("request a call back");
    
                
                ButtonGroup bg = new ButtonGroup();
                fileMenu.add(WhatsAppAction);
                fileMenu.add(CustomerCareAction);
                fileMenu.add(MailAction);
                fileMenu.add(FacebookAction);
                fileMenu.add(CallAction);
                fileMenu.addSeparator();
                
                ImageIcon ContactIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/phone-book.png"));
                JLabel imagelabel2 = new JLabel(ContactIcon);
                menuBar.add(imagelabel2);
                
                WhatsAppAction.setIcon(new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/whatsapp.png")));
                CustomerCareAction.setIcon(new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/call-center-operator.png")));                                             
                MailAction.setIcon(new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/email.png"))); 
                FacebookAction.setIcon(new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/facebook.png")));
                CallAction.setIcon(new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/call-center.png")));
                
                //adding  BlackBackground label on top
                BlackBackground1=new Label("   ");
                BlackBackground1.setBounds(0,0,1500,80);
                BlackBackground1.setBackground(Color.black);
                
                
                //adding WhiteBackground label
                WhiteBackground=new Label("   ");
                WhiteBackground.setBounds(0,81,1500,78);
                WhiteBackground.setBackground(Color.white);
                
                
                
                //adding JustIn button
                JustIn=new JButton("JUST IN");
                JustIn.setBounds(0,100,227,40);
                JustIn.setBackground(Color.white);
                JustIn.setForeground(Color.gray);
                JustIn.setFont(new Font("serif", Font.PLAIN, 14));
                add(JustIn);
                
                //adding Men button
                Men=new JButton("M E N");
                Men.setBounds(227,100,227,40);
                Men.setBackground(Color.white);
                Men.setForeground(Color.gray);
                Men.setFont(new Font("serif", Font.PLAIN, 12));
                add(Men);
                
                //adding Women button
                Women=new JButton("W O M E N");
                Women.setBounds(454,100,227,40);
                Women.setBackground(Color.white);
                Women.setForeground(Color.gray);
                Women.setFont(new Font("monospaced", Font.PLAIN, 13));
                add(Women);
                
                //adding Child button
                Child=new JButton("C H I L D");
                Child.setBounds(681,100,227,40);
                Child.setBackground(Color.white);
                Child.setForeground(Color.gray);
                Child.setFont(new Font("serif", Font.PLAIN, 12));
                add(Child);
                
                //adding Accessories button
                Accessories=new JButton("ACCESSORIES");
                Accessories.setBounds(908,100,227,40);
                Accessories.setBackground(Color.white);
                Accessories.setForeground(Color.gray);
                Accessories.setFont(new Font("serif", Font.PLAIN, 12));
                add(Accessories);
                
                //adding WinterSale button
                WinterSale=new JButton("YEAR  END  SALE");
                WinterSale.setBounds(1135,100,227,40);
                WinterSale.setBackground(Color.white);
                WinterSale.setForeground(Color.gray);
                WinterSale.setFont(new Font("serif", Font.PLAIN, 12));
                add(WinterSale);
               /* 
                //adding SearchField at TextField
                SearchField=new JTextField("   S E A R C H ");
                SearchField.setBounds(1200,100,160,40);
                SearchField.setBackground(Color.white);
                SearchField.setForeground(Color.gray);
                SearchField.setFont(new Font("serif", Font.PLAIN, 15));
                SearchButton=new JButton();
                SearchButton.setBounds(1320,100,40,40);
                ImageIcon SearchIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/search.png"));
                SearchButton.setIcon(SearchIcon);
                SearchButton.setBackground(Color.white);
                
                add(SearchButton);
                add(SearchField);*/
                
                //adding UserImage button
                ImageIcon UserImage=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/avatar.png"));
                User =new JButton(UserImage);
                //User.setBounds(1150,0,70,80);
                User.setBounds(1290, 0, 70, 80);
                User.setBackground(Color.BLACK);
                add(User);
                
                //adding Notification button
                /*ImageIcon NotificationImage=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/notifications-bell-button.png"));
                Notification =new JButton(NotificationImage);
                Notification.setBounds(1220, 0, 70, 80);
                Notification.setBackground(Color.BLACK);
                add(Notification);*/
                
                //adding Currency button
               /* ImageIcon NoteImage=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/Banknotes Filled-24.png"));
                Currency =new JButton(NoteImage);
                Currency.setBounds(1290, 0, 70, 80);
                Currency.setBackground(Color.BLACK);
                add(Currency);*/
                
                //adding cart button
                ImageIcon cartImage=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/shopping-cart.png"));
                cart =new JButton(cartImage);
                cart.setBounds(70, 0, 70, 80);
                cart.setBackground(Color.BLACK);
                add(cart);
                cart.addActionListener(new ActionListener()
                {public void actionPerformed(ActionEvent we)
                {
                   KartLayout a=new KartLayout();
                  a.setVisible(true); 
                }}
                );
                
                //adding notification button
                ImageIcon notificationImage=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/valentines-heart.png"));
                notificaton=new JButton(notificationImage);
                notificaton.setBounds(0,0,70,80);
                notificaton.setBackground(Color.BLACK);
                add(notificaton);
                notificaton.addActionListener(new notificationAction());
                                                     
                //adding delivary truck button
                /*ImageIcon DelivaryImage=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/truck-icon.png"));
                DelivaryTruck=new JButton(DelivaryImage);
                DelivaryTruck.setBounds(140,0,70,80);
                DelivaryTruck.setBackground(Color.BLACK);
                add(DelivaryTruck);
                DelivaryTruck.addActionListener(new TruckAction());*/
                
                //adding delivary home button
                ImageIcon HomeImage=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/home-icon-silhouette.png"));
                HomeIcon=new JButton(HomeImage);
                //HomeIcon.setBounds(210,0,70,80);
                HomeIcon.setBounds(140,0,70,80);
                HomeIcon.setBackground(Color.BLACK);
                add(HomeIcon);
                //HomeIcon.addActionListener(new HomeAction());
                
                
                ///////////////////////////////////////////
                //adding our e-store name "Shoppers Stop"// 
                ///////////////////////////////////////////
                
                //adding Shoppers Stop first word last seven letters " HOPPERS " 
                Shoppers2=new Label("HOPPERS");
                Shoppers2.setBounds(551,27,118,28);
                Shoppers2.setBackground(Color.black);
                Shoppers2.setForeground(Color.white);
                Shoppers2.setFont(new Font("serif", Font.PLAIN, 26));
                add(Shoppers2);
                
                //adding Shoppers Stop first letter " S "
                Shoppers1=new Label("S");
                Shoppers1.setBounds(530,25,20,28);
                Shoppers1.setBackground(Color.black);
                Shoppers1.setForeground(Color.white);
                Shoppers1.setFont(new Font("serif", Font.PLAIN, 35));
                add(Shoppers1);
                
                //adding Shoppers Stop second word first letter " S "
                Shoppers3=new Label("S");
                Shoppers3.setBounds(680,25,20,28);
                Shoppers3.setBackground(Color.black);
                Shoppers3.setForeground(Color.white);
                Shoppers3.setFont(new Font("serif", Font.PLAIN, 35));
                add(Shoppers3);
                
                //adding Shoppers Stop second word last part " TOP "
                Shoppers4=new Label("TOP");
                Shoppers4.setBounds(700,27,55,28);
                Shoppers4.setBackground(Color.black);
                Shoppers4.setForeground(Color.white);
                Shoppers4.setFont(new Font("serif", Font.PLAIN, 28));
                add(Shoppers4);

                
                /*//Adding tagline "Where Everything Stops Here ." 
                Shoppers5=new Label("Where Everything Stops Here .");
                Shoppers5.setBounds(650,50,165,28);
                Shoppers5.setBackground(Color.black);
                Shoppers5.setForeground(Color.white);
                Shoppers5.setFont(new Font("youfoundme", Font.TRUETYPE_FONT, 12));
                add(Shoppers5);*/
                add(BlackBackground1);
                add(WhiteBackground);
               // Men.addActionListener(new Handler());
               // Women.addActionListener(new Handler());
               flag=login();
               if(flag==true)
                {
                    System.out.println("System in log in ");
                }
                else
                {
                    System.out.println("System in log out ");
                    
                }
                
                
                }
         public  static boolean login()
        {
          if(login.flag==true)
          {
              return true;
          }
          else if(login.flag==false)
          {
           return false; 
          }
          return false;
        }
  
        
         class notificationAction implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
              if(e.getSource()==notificaton)
              {
                  notificaton.setBackground(Color.red);
                  ILikeThisPage Like=new ILikeThisPage();
                  setVisible(true);
                  Like.setVisible(true);
              }
            }
        }
         
        
          class TruckAction implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
              if(e.getSource()==DelivaryTruck)
              {
                 TrackOrder t1=new TrackOrder();
                 t1.setVisible(true);
                 //HomeIcon.setBackground(Color.red);
              }
              
            }
        }
    
    
 }
        
 