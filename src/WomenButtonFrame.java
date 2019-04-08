/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author user
 */
public class WomenButtonFrame extends JFrame
{       
        JPanel ContentPane;
        JScrollPane Scroll;
        LowerPanel1 lPane1;
        LowerPanel2 lPane2;
        UperPanel uPane;
        WomenPanel wPane;
        
        
     public WomenButtonFrame()
    {
        
        setLayout(null);
        setTitle("Shoppers Stop");
        setSize(1500,1500);
        //setLocation(300,50);
        setExtendedState(MyFrame.MAXIMIZED_BOTH);
        uPane=new UperPanel();
        setJMenuBar(uPane.menuBar);
        
        wPane=new WomenPanel(this);
        /*mPane.setBounds(0, 180, 1500, 800);
        //mPane.setBackground(Color.red);
        add(mPane);*/
        
        Scroll=new JScrollPane(wPane);
        Scroll.setBounds(0,160,1366,460);
        
        wPane.setPreferredSize(new Dimension(1500,1600));
        Scroll.setViewportView(wPane);
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
        if(login.flag==false)
        {
           wPane.AddProduct.setVisible(false);
           wPane.RemoveProduct.setVisible(false);
           wPane.AddAdmin.setVisible(false);
           wPane.RemoveAdmin.setVisible(false);
           wPane.UpdateButton.setVisible(false);
        }
        else
        { if(LogOutFrame.personTypeid.equalsIgnoreCase("1"))
        {
           wPane.AddProduct.setVisible(true);
           wPane.RemoveProduct.setVisible(true);
           wPane.AddAdmin.setVisible(true);
           wPane.RemoveAdmin.setVisible(true);
           wPane.UpdateButton.setVisible(true); 
        }
        else
        {
           wPane.AddProduct.setVisible(false);
           wPane.RemoveProduct.setVisible(false);
           wPane.AddAdmin.setVisible(false);
           wPane.RemoveAdmin.setVisible(false);
           wPane.UpdateButton.setVisible(false);
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
        wPane.AddProduct.addActionListener(new Handler());
        wPane.RemoveProduct.addActionListener(new Handler());
        wPane.AddAdmin.addActionListener(new Handler());
        wPane.RemoveAdmin.addActionListener(new Handler());
        wPane.UpdateButton.addActionListener(new Handler());
                
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
                
              if(a.getSource()==wPane.AddProduct)
                {
                    AddProductFrame af=new AddProductFrame();
                    af.setVisible(true);
                }
                if(a.getSource()==wPane.RemoveProduct)
                {
                    RemoveProduct af=new RemoveProduct();
                    af.setVisible(true);
                }
                if(a.getSource()==wPane.AddAdmin)
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
                        String rs="UPDATE `person` SET `PersonTypeId`='1' WHERE `UserName`='"+id+"'";
                        com.updateData(rs);
                        JOptionPane.showMessageDialog(rootPane, id+" Added as Admin");
                    }
                    
                }
                if(a.getSource()==wPane.RemoveAdmin)
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
                if(a.getSource()==wPane.UpdateButton)
                {
                    Sale sale=new Sale();
                    sale.setVisible(true);
                            
                }
             
                

        }
 }
    }

class WomenPanel extends JPanel
{
    JButton AddProduct,RemoveProduct,UpdateButton,AddAdmin,RemoveAdmin,MenPictureNo1,MenPictureNo2,MenPictureNo3,MenPictureNo4,MenPictureNo5,MenPictureNo6;
    static JButton[] ProductButton=new JButton[10000];
    static String[] UserName=new String[1000];
    static String[] TableName=new String[1000];
    static String[] Userid=new String[1000];
    static String[] Picture=new String[1000];
    static ArrayList<String[]> colorid=new ArrayList<String[]>(50);
    static int[] Availableproduct=new int[1000];
    static int[] Discountproduct=new int[10000];
    static ArrayList<String[]> SizeProduct=new ArrayList<String[]>(50);
    static int[] PriceProduct=new int[1000];
    static String Username,Table,UserId,PriceId,Available,Discount,SizeId,color;
    WomenButtonFrame fm;
    JLabel GentlePic,MenShelf,Size,PrizeRange,Designers,Wedding;
    JRadioButton RituKumar,Sabyasachi,AND,AnitaDongre,MaliniRamani,AnjuModi,Lehenga,Sari,LehengaSaries,Kurta,Anarkali,SizeL,SizeS,SizeM,SizeXL,SizeXXL,SizeXS,PrizeLess5k,PrizeBet5kTo1Cr,PrizeGreat1Cr;
    ButtonGroup group1,group2,group3,group4,group5;
    static int IncerX,IncerY,ButtonCounter,j;
    
            String[] list={  "/shoppersstoponlineshop/womenproduct/womne cover.PNG",
                           "/shoppersstoponlineshop/womenproduct/womne cover2.PNG"};
           Timer tm;
           int x=0;
    public WomenPanel(WomenButtonFrame f)
    {
    
    
        setLayout(null);
        fm=f;
        ImageIcon GentleIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/women  pictures/womne cover.PNG"));
        GentlePic=new JLabel(GentleIcon);
        
        GentlePic.setBounds(-15,10,1430,400);
        GentlePic.setBackground(Color.BLUE);
        
        add(GentlePic);
        tm=new Timer(2500,new ActionListener()
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
        MenShelf=new JLabel("Clothing");
        MenShelf.setBounds(50, 420, 100, 30);
        MenShelf.setFont(new Font("monospaced", Font.PLAIN, 16));
        add(MenShelf);
        Lehenga=new JRadioButton("Lehenga",false);
        Lehenga.setBounds(50, 450, 120, 20);
        Lehenga.setFont(new Font("monospaced", Font.PLAIN, 12));
        Lehenga.setForeground(Color.darkGray);
        Sari=new JRadioButton("Saree",false);
        Sari.setBounds(50, 470, 120, 20);
        Sari.setFont(new Font("monospaced", Font.PLAIN, 12));
        Sari.setForeground(Color.darkGray);
        LehengaSaries=new JRadioButton("Lehenga-Saree",false);
        LehengaSaries.setBounds(50, 490, 120, 20);
        LehengaSaries.setFont(new Font("monospaced", Font.PLAIN, 12));
        LehengaSaries.setForeground(Color.darkGray);
        Kurta=new JRadioButton("Kurta",false);
        Kurta.setBounds(50, 510, 120, 20);
        Kurta.setFont(new Font("monospaced", Font.PLAIN, 12));
        Kurta.setForeground(Color.darkGray);
        Anarkali=new JRadioButton("Anarkali",false);
        Anarkali.setBounds(50, 530, 120, 20);
        Anarkali.setFont(new Font("monospaced", Font.PLAIN, 12));
        Anarkali.setForeground(Color.darkGray);
        add(Lehenga);
        add(Sari);
        add(LehengaSaries);
        add(Kurta);
        add(Anarkali);
        group1=new ButtonGroup();
        group1.add(Lehenga);
        group1.add(Sari);
        group1.add(LehengaSaries);
        group1.add(Kurta);
        group1.add(Anarkali);
        
       
        
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
        
        String rs="SELECT * FROM `lehenga` WHERE `Available`>0";
        Username="LehengaName";
        UserId="LehengaID";
        PriceId="LehengaPrice";
        Available="Available";
        Discount="Discount";
        Table="lehenga";
        
        AddButton(rs);
        Lehenga.addActionListener(new RadioHandler());
        Sari.addActionListener(new RadioHandler());
        LehengaSaries.addActionListener(new RadioHandler());
        Kurta.addActionListener(new RadioHandler());
        Anarkali.addActionListener(new RadioHandler());
       for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RaHandler());
        }
    }
    class RaHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent we)
        {for(int i=0;i<ButtonCounter;i++){
            if(we.getSource()==ProductButton[i])
            {
                MenProductAddToCart add=new MenProductAddToCart(Userid[i],TableName[i],ButtonCounter,Availableproduct[i],PriceProduct[i],UserName[i],Discountproduct[i],Picture[i]);
                        add.setVisible(true);
            }
        }}
    }
    class RadioHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent we)
        {
            if(we.getSource()==Lehenga)
            {
                String rs="SELECT * FROM `lehenga` WHERE `Available`>0";
                WomenPanel.Username="LehengaName";
                WomenPanel.UserId="LehengaID";
                WomenPanel.PriceId="LehengaPrice";
                WomenPanel.Available="Available";
                WomenPanel.Discount="Discount";
                WomenPanel.Table="lehenga";
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
                
                System.out.println("Akash in lehenga");
        
                AddButton(rs);
                for(int i=0;i<ButtonCounter;i++)
              { 
                  System.out.println(Userid[i]);
                  String rsColor="SELECT `ColorName` FROM Color WHERE `ColorID` IN(SELECT `ColorID` FROM `availablelehengacolor` WHERE `LehengaID`='"+Userid[i]+"')";
                  String rsSize="SELECT `SizeName` FROM size WHERE `SizeID` IN(SELECT `SizeID` FROM `availablelehengasize` WHERE `LehengaID`='"+Userid[i]+"')";
                  DBConnector con=new DBConnector();
                  ResultSet rsCol,rsSiz;
                   rsCol=con.setData(rsColor);
                   rsSiz=con.setData(rsSize);
                   String[] color=new String[10];
                   String[] size=new String[10];
                    try {
                        int counter1=0,counter2=0;
                        while(rsCol.next())
                        {
                            
                            color[counter1]=rsCol.getString("ColorName");
                            counter1++;
                            //System.out.println(rsCol.getString("ColorName"));
                        }
                        while(rsSiz.next())
                        {
                            
                            size[counter2]=rsSiz.getString("SizeName");
                            counter2++;
                        }
                        colorid.add(color);
                       SizeProduct.add(size);
                       
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(GentlePic, "Error is:"+ex);
                    }   
                    
              }
                for(int i=0;i<ButtonCounter;i++)
             {
            ProductButton[i].addActionListener(new RadioHandler());
             }
                
            }
            else if(we.getSource()==Sari)
            {
                String rs="SELECT * FROM `saree` WHERE `Available`>0";
                WomenPanel.Username="SareeName";
                WomenPanel.UserId="SareeID";
                WomenPanel.PriceId="SareePrice";
                WomenPanel.Available="Available";
                WomenPanel.Discount="Discount";
                WomenPanel.Table="saree";
                System.out.println("Akash in saree");
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
            
              AddButton(rs);
              for(int i=0;i<ButtonCounter;i++)
              { 
                  System.out.println(Userid[i]);
                  String rsColor="SELECT `ColorName` FROM Color WHERE `ColorID` IN(SELECT `ColorID` FROM `availablesareecolor` WHERE `SareeID`='"+Userid[i]+"')";
                  String rsSize="SELECT `SizeName` FROM size WHERE `SizeID` IN(SELECT `SizeID` FROM `availabletshirtsize` WHERE `TshirtID`='"+Userid[i]+"')";
                  DBConnector con=new DBConnector();
                 
                  ResultSet rsCol,rsSiz;
                   rsCol=con.setData(rsColor);
                   rsSiz=con.setData(rsSize);
                   String[] color=new String[10];
                   String[] size=new String[10];
                    try {
                        int counter1=0,counter2=0;
                        while(rsCol.next())
                        {
                            
                            color[counter1]=rsCol.getString("ColorName");
                            counter1++;
                            //System.out.println(rsCol.getString("ColorName"));
                        }
                        while(rsSiz.next())
                        {
                            
                            size[counter2]=rsSiz.getString("SizeName");
                            counter2++;
                        }
                        colorid.add(color);
                       SizeProduct.add(size);
                       
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(GentlePic, "Error is:"+ex);
                    }   
                    
              }
              for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
              
              
              
            }
            else if(we.getSource()==LehengaSaries)
            {
                String rs="SELECT * FROM `lehengasaree` WHERE `Available` >0";
                Username="LehengaSareeName";
                UserId="LehengaSareeID";
                PriceId="LehengaSareePrice";
                Available="Available";
                Discount="Discount";
                Table="lehengasaree";
                System.out.println("Akash in lehengasaree");
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
            
              AddButton(rs);
              for(int i=0;i<ButtonCounter;i++)
              { 
                  System.out.println(Userid[i]);
                  String rsColor="SELECT `ColorName` FROM Color WHERE `ColorID` IN(SELECT `ColorID` FROM `availabelehengasareecolor` WHERE `LehengaSareeID`='"+Userid[i]+"')";
                  String rsSize="SELECT `SizeName` FROM size WHERE `SizeID` IN(SELECT `SizeID` FROM `availabelehengasareesize` WHERE `LehengaSareeID`='"+Userid[i]+"')";
                  DBConnector con=new DBConnector();
                  ResultSet rsCol,rsSiz;
                   rsCol=con.setData(rsColor);
                   rsSiz=con.setData(rsSize);
                   String[] color=new String[10];
                   String[] size=new String[10];
                    try {
                        int counter1=0,counter2=0;
                        while(rsCol.next())
                        {
                            
                            color[counter1]=rsCol.getString("ColorName");
                            counter1++;
                            //System.out.println(rsCol.getString("ColorName"));
                        }
                        while(rsSiz.next())
                        {
                            
                            size[counter2]=rsSiz.getString("SizeName");
                            counter2++;
                        }
                        colorid.add(color);
                       SizeProduct.add(size);
                       
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(GentlePic, "Error is:"+ex);
                    }   
                    
              }
              for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
              
              
              
            }
            else if(we.getSource()==Kurta)
            {
                String rs="SELECT * FROM `kurta` WHERE `Available`>0";
                Username="KurtaName";
                UserId="KurtaID";
                PriceId="KurtaPrice";
                Available="Available";
                Discount="Discount";
                Table="kurta";
                System.out.println("Akash in kurta");
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
            
              AddButton(rs);
              for(int i=0;i<ButtonCounter;i++)
              { 
                  System.out.println(Userid[i]);
                  String rsColor="SELECT `ColorName` FROM Color WHERE `ColorID` IN(SELECT `ColorID` FROM `availablekurtacolor` WHERE `KurtaID`='"+Userid[i]+"')";
                  String rsSize="SELECT `SizeName` FROM size WHERE `SizeID` IN(SELECT `SizeID` FROM `availablekurtasize` WHERE `KurtaID`='"+Userid[i]+"')";
                  DBConnector con=new DBConnector();
                  ResultSet rsCol,rsSiz;
                   rsCol=con.setData(rsColor);
                   rsSiz=con.setData(rsSize);
                   String[] color=new String[10];
                   String[] size=new String[10];
                    try {
                        int counter1=0,counter2=0;
                        while(rsCol.next())
                        {
                            
                            color[counter1]=rsCol.getString("ColorName");
                            counter1++;
                            //System.out.println(rsCol.getString("ColorName"));
                        }
                        while(rsSiz.next())
                        {
                            
                            size[counter2]=rsSiz.getString("SizeName");
                            counter2++;
                        }
                        colorid.add(color);
                       SizeProduct.add(size);
                       
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(GentlePic, "Error is:"+ex);
                    }   
                    
              }
              for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
              
              
              
            }
            else if(we.getSource()==Anarkali)
            {
                String rs="SELECT * FROM `anarkali` WHERE `Available`>0";
                Username="AnarkaliName";
                UserId="AnarkaliID";
                PriceId="AnarkaliPrice";
                Available="Available";
                Discount="Discount";
                Table="anarkali";
                System.out.println("Akash in anarkali");
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
            
              AddButton(rs);
              for(int i=0;i<ButtonCounter;i++)
              { 
                  System.out.println(Userid[i]);
                  String rsColor="SELECT `ColorName` FROM Color WHERE `ColorID` IN(SELECT `ColorID` FROM `availableanarkalicolor` WHERE `AnarkaliID`='"+Userid[i]+"')";
                  String rsSize="SELECT `SizeName` FROM size WHERE `SizeID` IN(SELECT `SizeID` FROM `availableanarkalisize` WHERE `AnarkaliID`='"+Userid[i]+"')";
                  DBConnector con=new DBConnector();
                  ResultSet rsCol,rsSiz;
                   rsCol=con.setData(rsColor);
                   rsSiz=con.setData(rsSize);
                   String[] color=new String[10];
                   String[] size=new String[10];
                    try {
                        int counter1=0,counter2=0;
                        while(rsCol.next())
                        {
                            
                            color[counter1]=rsCol.getString("ColorName");
                            counter1++;
                            //System.out.println(rsCol.getString("ColorName"));
                        }
                        while(rsSiz.next())
                        {
                            
                            size[counter2]=rsSiz.getString("SizeName");
                            counter2++;
                        }
                        colorid.add(color);
                       SizeProduct.add(size);
                       
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(GentlePic, "Error is:"+ex);
                    }   
                    
              }
              for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
              
              
              
            }
            for(int i=0;i<ButtonCounter;i++)
                {
                    if(we.getSource()==ProductButton[i])
                    {
                        MenProductAddToCart add=new MenProductAddToCart(Userid[i],TableName[i],ButtonCounter,Availableproduct[i],PriceProduct[i],UserName[i],colorid.get(i),SizeProduct.get(i),Discountproduct[i],Picture[i]);
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
                    IncerX=280;
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
            
        }
    }
     public void setimagesize(int i)
    {
        ImageIcon icon=new ImageIcon(getClass().getResource(list[i]));
        GentlePic.setIcon(icon);
    }
    
}

    

