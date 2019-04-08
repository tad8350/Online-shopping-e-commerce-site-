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
import javax.swing.*;


/**
 *
 * @author user
 */
public class accessoriesFrame extends JFrame 
{
        
        JPanel ContentPane;
        JScrollPane Scroll;
        LowerPanel1 lPane1;
        LowerPanel2 lPane2;
        UperPanel uPane;
        accessoriesPane aPane;
        
        
        
     public accessoriesFrame()
    {   
        
        setLayout(null);
        setTitle("Shoppers Stop");
        setSize(1500,1500);
        //setLocation(300,50);
        setExtendedState(MyFrame.MAXIMIZED_BOTH);
        uPane=new UperPanel();
        setJMenuBar(uPane.menuBar);
        
        aPane=new accessoriesPane(this);
        /*mPane.setBounds(0, 180, 1500, 800);
        //mPane.setBackground(Color.red);
        add(mPane);*/
        
        Scroll=new JScrollPane(aPane);
        Scroll.setBounds(0,160,1366,460);
        
        aPane.setPreferredSize(new Dimension(1500,1600));
        Scroll.setViewportView(aPane);
        Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ContentPane=new JPanel(null);
        ContentPane.add(Scroll);
        ContentPane.add(uPane);
        setContentPane(ContentPane);
        /*lPane1=new LowerPanel1();
        lPane1.setBounds(0,560,1500,60);
        add(lPane1);*/
        lPane2=new LowerPanel2();
        lPane2.setBounds(0,620,1500,62);
        add(lPane2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*uPane.Men.addActionListener(new Handler());
        uPane.Women.addActionListener(new Handler());
        uPane.Accessories.addActionListener(new Handler());
        uPane.Child.addActionListener(new Handler());
        uPane.JustIn.addActionListener(new Handler());
        uPane.User.addActionListener(new Handler());
        uPane.WinterSale.addActionListener(new Handler());
        uPane.HomeIcon.addActionListener(new Handler());*/
          if(login.flag==false)
        {
           aPane.AddProduct.setVisible(false);
           aPane.RemoveProduct.setVisible(false);
           aPane.AddAdmin.setVisible(false);
           aPane.RemoveAdmin.setVisible(false);
           aPane.UpdateButton.setVisible(false);
        }
        else
        { if(LogOutFrame.personTypeid.equalsIgnoreCase("1"))
        {
           aPane.AddProduct.setVisible(true);
           aPane.RemoveProduct.setVisible(true);
           aPane.AddAdmin.setVisible(true);
           aPane.RemoveAdmin.setVisible(true);
           aPane.UpdateButton.setVisible(true); 
        }
        else
        {
           aPane.AddProduct.setVisible(false);
           aPane.RemoveProduct.setVisible(false);
           aPane.AddAdmin.setVisible(false);
           aPane.RemoveAdmin.setVisible(false);
           aPane.UpdateButton.setVisible(false);
        }
           
        }
       
        uPane.Men.addActionListener(new Handler());
        uPane.Women.addActionListener(new Handler());
        uPane.Accessories.addActionListener(new Handler());
        uPane.Child.addActionListener(new Handler());
        uPane.JustIn.addActionListener(new Handler());
        uPane.User.addActionListener(new Handler());
        uPane.WinterSale.addActionListener(new Handler());
        uPane.HomeIcon.addActionListener(new Handler());
        aPane.AddProduct.addActionListener(new Handler());
        aPane.RemoveProduct.addActionListener(new Handler());
        aPane.AddAdmin.addActionListener(new Handler());
        aPane.RemoveAdmin.addActionListener(new Handler());
        aPane.UpdateButton.addActionListener(new Handler());;
                
            }
class Handler implements ActionListener
        {   
          
            
            
            
            public void actionPerformed(ActionEvent a)
            {   
                if(a.getSource()==uPane.Men)
                {   
                  MenButtonFrame menFrame=new MenButtonFrame();            
                  setVisible(false);
                  menFrame.setVisible(true);
                 
                }
                else if(a.getSource()==uPane.Women)
                {
                    
                    WomenButtonFrame Wf=new WomenButtonFrame();
                    setVisible(false);
                    Wf.setVisible(true);
                }
                else if(a.getSource()==uPane.Accessories)
                {
                    accessoriesFrame AF=new accessoriesFrame();
                    setVisible(false);
                    AF.setVisible(true);
                }
                 else if(a.getSource()==uPane.Child)
                {
                    ChildButtonFrame CF=new ChildButtonFrame();
                    setVisible(false);
                    CF.setVisible(true);
                }
                 else if(a.getSource()==uPane.JustIn)
                {
                    JustinButtonFrame JF=new JustinButtonFrame();
                    setVisible(false);
                    JF.setVisible(true);
                }
                else if(a.getSource()==uPane.User)
                {   if(UperPanel.flag==false)
                     {UserFrame in=new UserFrame();
                    in.setVisible(true);}
                else
                {
                    LogOutFrame out=new LogOutFrame();
                    out.setVisible(true);
                }
                }
                  else if(a.getSource()==uPane.WinterSale)
                {
                    WinterSaleButtonFrame Winter=new WinterSaleButtonFrame();
                    setVisible(false);
                    Winter.setVisible(true);
                }
              if(a.getSource()==uPane.HomeIcon)
              {
                 
                  uPane.HomeIcon.setBackground(Color.red);
                  MyFrame frame=new MyFrame();
                  setVisible(false);
                  frame.setVisible(true);
                 
              }
              if(a.getSource()==aPane.AddProduct)
                {
                    AddProductFrame af=new AddProductFrame();
                    af.setVisible(true);
                }
                if(a.getSource()==aPane.RemoveProduct)
                {
                    RemoveProduct af=new RemoveProduct();
                    af.setVisible(true);
                }
                if(a.getSource()==aPane.AddAdmin)
                {
                    String id;
                    id=JOptionPane.showInputDialog("Enter New Admin Id:");
                    String user="SELECT `UserName` FROM `person";
                     ResultSet rsuser;
                     DBConnector com=new DBConnector();
                     rsuser=com.setData(user);
                     int counter=0;
                    try {
                        while(rsuser.next())
                        {
                         if( id.equals(rsuser.getString("UserName")))
                         {
                               counter=1;
                               break;
                         }
                        }
                    } catch (SQLException ex) {
                        
                    }
                    if(counter==0)
                    {
                        JOptionPane.showMessageDialog(rootPane,"User name not availabe");
                    }
                    else
                    {
                        String rs="UPDATE `person` SET `PersonTypeId`='1' WHERE `UserName`='"+id+"'";
                        com.updateData(rs);
                        JOptionPane.showMessageDialog(rootPane, id+" Added as Admin");
                    }
                    
                }
                if(a.getSource()==aPane.RemoveAdmin)
                {
                    String id=JOptionPane.showInputDialog("Enter New Admin Id:");
                    String user="SELECT `UserName` FROM `person";
                     ResultSet rsuser;
                     DBConnector com=new DBConnector();
                     rsuser=com.setData(user);
                     int counter=0;
                    try {
                        while(rsuser.next())
                        {
                         if( id.equals(rsuser.getString("UserName")))
                         {
                               counter=1;
                               break;
                         }
                        }
                    } catch (SQLException ex) {
                        
                    }
                    if(counter==0)
                    {
                        JOptionPane.showMessageDialog(rootPane,"User name not availabe");
                    }
                     else
                    {
                        String rs="UPDATE `person` SET `PersonTypeId`='0' WHERE `UserName`='"+id+"'";
                        com.updateData(rs);
                        JOptionPane.showMessageDialog(rootPane, id+" Removed from Admin");
                    }
                }
                if(a.getSource()==aPane.UpdateButton)
                {
                    Sale sale=new Sale();
                    sale.setVisible(true);
                            
                }
                

        }
 }
    }
     
    


 class accessoriesPane extends JPanel
     {
        
         JLabel AccesoriesPic,MenShelf,Size,PrizeRange,Designers;
         JRadioButton Bangle,Belt,Bracelet,Clutch,Earring,Tie,Wallet,Watch,RituKumar,Sabyasachi,AND,bangles,belts,wallets,ties,AnitaDongre,MaliniRamani,AnjuModi,clutches,earrings,bracelets,hairAccessories,SizeF,Size7,Size8,Size9,Size10,Size11,Size12,Size13,PrizeLess2k,PrizeBet2kTo20k,PrizeGreat20k;
         ButtonGroup group1,group2,group3,group4;
        JButton AddProduct,RemoveProduct,UpdateProduct,AddAdmin,RemoveAdmin,UpdateButton;
        static String[] Picture=new String[1000];
         static JButton[] ProductButton=new JButton[10000];
         static String[] UserName=new String[1000];
         static String[] TableName=new String[1000];
        static String[] Userid=new String[1000];
        static String[] colorid=new String[1000];
        static int[] Availableproduct=new int[1000];
        static int[] Discountproduct=new int[10000];
        static String[] SizeProduct=new String[1000];
        static int[] PriceProduct=new int[1000];
        static String Username,Table,UserId,PriceId,Available,Discount,SizeId,color;
        //    static String[] 
    
         static int IncerX,IncerY,ButtonCounter,j;
         String[] list={  "/shoppersstoponlineshop/accesory/new arrivals cover.PNG",
                           "/shoppersstoponlineshop/accesory/ACCESSORY.PNG"};
           Timer tm;
           int x=0;
     
         accessoriesFrame fm;
         public accessoriesPane(accessoriesFrame f)
         {
            setLayout(null);
            fm=f;
            AccesoriesPic =new JLabel();
            ImageIcon GentleIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/accesory/new arrivals cover.PNG"));
            AccesoriesPic=new JLabel(GentleIcon);
            AccesoriesPic.setBounds(-15,10,1430,400);
            AccesoriesPic.setBackground(Color.BLUE);
            add(AccesoriesPic);
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
        
        add(AccesoriesPic);
        tm.start();
            
        
        
            
        
        MenShelf=new JLabel("Clothing");
        MenShelf.setBounds(50, 420, 100, 30);
        MenShelf.setFont(new Font("monospaced", Font.PLAIN, 16));
        add(MenShelf);
        Bangle=new JRadioButton("Bangle",false);
        Bangle.setBounds(50, 450, 120, 20);
        Bangle.setFont(new Font("monospaced", Font.PLAIN, 12));
        Bangle.setForeground(Color.darkGray);
        Belt=new JRadioButton("Belt",false);
        Belt.setBounds(50, 470, 120, 20);
        Belt.setFont(new Font("monospaced", Font.PLAIN, 12));
        Belt.setForeground(Color.darkGray);
        Bracelet=new JRadioButton("Bracelet",false);
        Bracelet.setBounds(50, 490, 120, 20);
        Bracelet.setFont(new Font("monospaced", Font.PLAIN, 12));
        Bracelet.setForeground(Color.darkGray);
        Clutch=new JRadioButton("Clutch",false);
        Clutch.setBounds(50, 510, 120, 20);
        Clutch.setFont(new Font("monospaced", Font.PLAIN, 12));
        Clutch.setForeground(Color.darkGray);
        Earring=new JRadioButton("Ear-Ring",false);
        Earring.setBounds(50, 530, 120, 20);
        Earring.setFont(new Font("monospaced", Font.PLAIN, 12));
        Earring.setForeground(Color.darkGray);
        Tie=new JRadioButton("Tie",false);
        Tie.setBounds(50, 550, 120, 20);
        Tie.setFont(new Font("monospaced", Font.PLAIN, 12));
        Tie.setForeground(Color.darkGray);
        Wallet=new JRadioButton("Wallet",false);
        Wallet.setBounds(50, 570, 120, 20);
        Wallet.setFont(new Font("monospaced", Font.PLAIN, 12));
        Wallet.setForeground(Color.darkGray);
        Watch=new JRadioButton("Watch",false);
        Watch.setBounds(50, 590, 120, 20);
        Watch.setFont(new Font("monospaced", Font.PLAIN, 12));
        Watch.setForeground(Color.darkGray);
        add(Bangle);
        add(Belt);
        add(Bracelet);
        add(Clutch);
        add(Earring);
        add(Tie);
        add(Wallet);
        add(Watch);
        group1=new ButtonGroup();
        group1.add(Bangle);
        group1.add(Belt);
        group1.add(Bracelet);
        group1.add(Clutch);
        group1.add(Earring);
        group1.add(Tie);
        group1.add(Wallet);
        group1.add(Watch);
        
        
        
        AddProduct=new JButton("Add Product");
        AddProduct.setBounds(1200,420,125,25);
        AddProduct.setBackground(Color.white);
        AddProduct.setForeground(Color.blue);
        AddProduct.setFont(new Font("monospaced", Font.PLAIN, 12));
	add(AddProduct);
        
        RemoveProduct=new JButton("Remove Product");
        RemoveProduct.setBounds(1200,455,125,25);
        RemoveProduct.setBackground(Color.white);
        RemoveProduct.setForeground(Color.red);
        RemoveProduct.setFont(new Font("serif", Font.PLAIN, 12));
	add(RemoveProduct);
        
        UpdateButton=new JButton("SALE");
        UpdateButton.setBounds(1200,490,125,25);
        UpdateButton.setBackground(Color.white);
        UpdateButton.setForeground(Color.black);
        UpdateButton.setFont(new Font("monospaced", Font.BOLD, 12));
	add(UpdateButton);
        AddAdmin=new JButton("Additional Admin");
        AddAdmin.setBounds(1200,525,125,25);
        AddAdmin.setBackground(Color.white);
        AddAdmin.setForeground(Color.blue);
        AddAdmin.setFont(new Font("SERIF", Font.PLAIN, 12));
        add(AddAdmin);
	
        
        RemoveAdmin=new JButton("Remove Admin");
        RemoveAdmin.setBounds(1200,560,125,25);
        RemoveAdmin.setBackground(Color.white);
        RemoveAdmin.setForeground(Color.red);
        RemoveAdmin.setFont(new Font("monospaced", Font.BOLD, 12));
        add(RemoveAdmin);
             
          
        
        Bangle.addActionListener(new RadioHandler());
        Belt.addActionListener(new RadioHandler());
        Bracelet.addActionListener(new RadioHandler());
        Clutch.addActionListener(new RadioHandler());
        Earring.addActionListener(new RadioHandler());
        Tie.addActionListener(new RadioHandler());
        Wallet.addActionListener(new RadioHandler());
        Watch.addActionListener(new RadioHandler());
        String rs="SELECT * FROM `bangle` WHERE `Available`>0";
                accessoriesPane.Username="BangleName";
                accessoriesPane.UserId="BangleID";
                accessoriesPane.PriceId="BanglePrice";
                accessoriesPane.Available="Available";
                accessoriesPane.Discount="Discount";
                accessoriesPane.Table="bangle";
                AddButton(rs);
       for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
           
     }
         class RadioHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent we)
        {
            if(we.getSource()==Bangle)
            {
                String rs="SELECT * FROM `bangle` WHERE `Available`>0";
                accessoriesPane.Username="BangleName";
                accessoriesPane.UserId="BangleID";
                accessoriesPane.PriceId="BanglePrice";
                accessoriesPane.Available="Available";
                accessoriesPane.Discount="Discount";
                accessoriesPane.Table="bangle";
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
                
                System.out.println("Bangle");
        
                AddButton(rs);
                for(int i=0;i<ButtonCounter;i++)
             {
            ProductButton[i].addActionListener(new RadioHandler());
             }
                
            }
            else if(we.getSource()==Belt)
            {
                String rs="SELECT * FROM `belt` WHERE `Available`>0";
                accessoriesPane.Username="BeltName";
                accessoriesPane.UserId="BeltID";
                accessoriesPane.PriceId="BeltPrice";
                accessoriesPane.Available="Available";
                accessoriesPane.Discount="Discount";
                accessoriesPane.Table="belt";
                System.out.println("belt");
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
            
              AddButton(rs);
              for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
              
              
              
            }
            else if(we.getSource()==Bracelet)
            {
                String rs="SELECT * FROM `bracelet` WHERE `Available`>0";
                accessoriesPane.Username="BraceletName";
                accessoriesPane.UserId="BraceletID";
                accessoriesPane.PriceId="BraceletPrice";
                accessoriesPane.Available="Available";
                accessoriesPane.Discount="Discount";
                accessoriesPane.Table="bracelet";
                System.out.println("bracelet");
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
            
              AddButton(rs);
              for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
              
              
              
            }
            else if(we.getSource()==Clutch)
            {
                String rs="SELECT * FROM `clutch` WHERE `Available`>0";
                accessoriesPane.Username="ClutchName";
                accessoriesPane.UserId="ClutchID";
                accessoriesPane.PriceId="ClutchPrice";
                accessoriesPane.Available="Available";
                accessoriesPane.Discount="Discount";
                accessoriesPane.Table="clutch";
                System.out.println("clutch");
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
            
              AddButton(rs);
              for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
              
              
              
            }
            else if(we.getSource()==Earring)
            {
                String rs="SELECT * FROM `earring` WHERE `Available`>0";
                accessoriesPane.Username="EarRingName";
                accessoriesPane.UserId="EarRingID";
                accessoriesPane.PriceId="EarRingPrice";
                accessoriesPane.Available="Available";
                accessoriesPane.Discount="Discount";
                accessoriesPane.Table="earring";
                System.out.println("earring");
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
            
              AddButton(rs);
              for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
              
              
              
            }
            
             else if(we.getSource()==Tie)
            {
                String rs="SELECT * FROM `tie` WHERE `Available`>0";
                accessoriesPane.Username="TieName";
                accessoriesPane.UserId="TieID";
                accessoriesPane.PriceId="TiePrice";
                accessoriesPane.Available="Available";
                accessoriesPane.Discount="Discount";
                accessoriesPane.Table="tie";
                System.out.println("Tie");
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
            
              AddButton(rs);
              for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
              
              
              
            }
             else if(we.getSource()==Wallet)
            {
                String rs="SELECT * FROM `wallet` WHERE `Available`>0";
                accessoriesPane.Username="WalletName";
                accessoriesPane.UserId="WalletID";
                accessoriesPane.PriceId="WalletPrice";
                accessoriesPane.Available="Available";
                accessoriesPane.Discount="Discount";
                accessoriesPane.Table="wallet";
                System.out.println("wallet");
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
            
              AddButton(rs);
              for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
              
              
              
            }
             else if(we.getSource()==Watch)
            {
                String rs="SELECT * FROM `watch` WHERE `Available`>0";
                accessoriesPane.Username="WatchName";
                accessoriesPane.UserId="WatchID";
                accessoriesPane.PriceId="WatchPrice";
                accessoriesPane.Available="Available";
                accessoriesPane.Discount="Discount";
                accessoriesPane.Table="watch";
                System.out.println("watch");
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
            
              AddButton(rs);
              for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
              
              
              
            }
            
            
            for(int i=0;i<ButtonCounter;i++)
                {
                    if(we.getSource()==ProductButton[i])
                    {
                        MenProductAddToCart add=new MenProductAddToCart(Userid[i],TableName[i],ButtonCounter,Availableproduct[i],PriceProduct[i],UserName[i],Discountproduct[i],Picture[i]);
                        add.setVisible(true);
                        
                    }
                }
        }
    }
          public  void AddButton(String rs)
    {
        ResultSet rsShirt;
        IncerX=0;
        IncerY=0;
        ButtonCounter=0;
        j=0;
        DBConnector con=new DBConnector();
        
        rsShirt=con.setData(rs);
        try {
            while(rsShirt.next())
            {
                for(j=0;j<3;j++)
                {
                    ImageIcon Icon=new ImageIcon(getClass().getResource(rsShirt.getString("Picture")));
                    ProductButton[ButtonCounter]=new JButton(Icon);
                    ProductButton[ButtonCounter].setBounds(285+IncerX, 450+IncerY, 250, 450);
                    ProductButton[ButtonCounter].setBackground(Color.white);
                    add(ProductButton[ButtonCounter]);
                    Picture[ButtonCounter]=rsShirt.getString("Picture");
                    UserName[ButtonCounter]=rsShirt.getString(Username);
                    TableName[ButtonCounter]=Table;
                    Userid[ButtonCounter]=rsShirt.getString(UserId);
                    Availableproduct[ButtonCounter]=rsShirt.getInt(Available);
                    Discountproduct[ButtonCounter]=rsShirt.getInt(Discount);
                    PriceProduct[ButtonCounter]=rsShirt.getInt(PriceId);
                    System.out.println(UserName[ButtonCounter]+TableName[ButtonCounter]+Userid[ButtonCounter]+Availableproduct[ButtonCounter]+Discountproduct[ButtonCounter]+PriceProduct[ButtonCounter]);
                    ButtonCounter++;
                    
                    System.out.println(ButtonCounter);
                    
                    
                     if(j==0)
                        {
                            rsShirt.next();
                            IncerX=280;
                        }   
                     else if(j==1)
                     {
                         rsShirt.next();
                         IncerX=560;
                     }
                    
                    
               
                }
                IncerY=IncerY+480;
                IncerX=0;
            }
            } catch (SQLException ex) {
            System.out.println( "Erroer is"+ex);
        }
    }
          public void setimagesize(int i)
    {
        ImageIcon icon=new ImageIcon(getClass().getResource(list[i]));
        AccesoriesPic.setIcon(icon);
    }
    
}

         
         

    
