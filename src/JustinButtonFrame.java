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
 * @author projna
 */
public class JustinButtonFrame extends JFrame
{
        
        JPanel ContentPane;
        JScrollPane Scroll;
        LowerPanel1 lPane1;
        LowerPanel2 lPane2;
        UperPanel uPane;
        JustinPanel wPane;
        
    public JustinButtonFrame()
    {
       
        setLayout(null);
        setTitle("Shoppers Stop");
        setSize(1500,1500);
        //setLocation(300,50);
        setExtendedState(MyFrame.MAXIMIZED_BOTH);
        uPane=new UperPanel();
        setJMenuBar(uPane.menuBar);
        
        wPane=new JustinPanel(this);
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
        
        setContentPane(ContentPane);
        add(uPane);
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
        wPane.UpdateButton.addActionListener(new Handler());;
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
class JustinPanel extends JPanel
{
    static JButton[] ProductButton=new JButton[10000];
    static String[] UserName=new String[1000];
    static String[] TableName=new String[1000];
    static String[] Userid=new String[1000];
    static ArrayList<String[]> SizeProduct=new ArrayList<String[]>(50);
    static int[] Availableproduct=new int[1000];
    static int[] Discountproduct=new int[10000];
    static ArrayList<String[]> colorid=new ArrayList<String[]>(50);
    static int[] PriceProduct=new int[1000];
    static String[] Picture=new String[1000];
    static String Username,Table,UserId,PriceId,Available,Discount,SizeId,color;    
    JustinButtonFrame fm;
    JLabel Gender,GentlePic,MenShelf,WomenShelf,Size,PrizeRange,Designers;
    JRadioButton Anarkali,LehengaSaree,Saree,Kurta,Lehenga,RituKumar,Sabyasachi,RohitBal,AND,AnjuModi,AnitaDongre,MaliniRamani,Jackets,Jeans,Punjabi,TShirt,Shirt,SizeL,SizeS,SizeM,SizeXL,SizeXXL,SizeXS,PrizeLess2k,PrizeBet2kTo5k,PrizeGreat5k;
    ButtonGroup group1;
    JButton AddProduct,RemoveProduct,UpdateButton,AddAdmin,RemoveAdmin,MenPictureNo1,MenPictureNo2,MenPictureNo3,MenPictureNo4,MenPictureNo5,MenPictureNo6;
    static int IncerX,IncerY,ButtonCounter,j;
    String[] list={  "/shoppersstoponlineshop/just in pictures/justin cover.PNG",
                      "/shoppersstoponlineshop/just in pictures/new arrivals cover2.PNG",
                      "/shoppersstoponlineshop/just in pictures/new arrivals cover3.PNG"};
           Timer tm;
           int x=0;
    
    public JustinPanel(JustinButtonFrame f)
    {
    
    
        setLayout(null);
        fm=f;
        ImageIcon GentleIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/just in pictures/justin cover.PNG"));
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
        MenShelf=new JLabel("Clothing [MEN]");
        MenShelf.setBounds(50, 420, 100, 30);
        MenShelf.setFont(new Font("serif", Font.PLAIN, 16));
        add(MenShelf);
        Jackets=new JRadioButton("Jackets",false);
        Jackets.setBounds(50, 450, 120, 20);
        Jackets.setFont(new Font("monospaced", Font.PLAIN, 12));
        Jackets.setForeground(Color.darkGray);
        Jeans=new JRadioButton("Jeans",false);
        Jeans.setBounds(50, 470, 120, 20);
        Jeans.setFont(new Font("monospaced", Font.PLAIN, 12));
        Jeans.setForeground(Color.darkGray);
        Punjabi=new JRadioButton("Punjabi",false);
        Punjabi.setBounds(50, 490, 120, 20);
        Punjabi.setFont(new Font("monospaced", Font.PLAIN, 12));
        Punjabi.setForeground(Color.darkGray);
        Shirt=new JRadioButton("Shirt",false);
        Shirt.setBounds(50, 510, 120, 20);
        Shirt.setFont(new Font("monospaced", Font.PLAIN, 12));
        Shirt.setForeground(Color.darkGray);
        TShirt=new JRadioButton("T-Shirt",false);
        TShirt.setBounds(50, 530, 120, 20);
        TShirt.setFont(new Font("monospaced", Font.PLAIN, 12));
        TShirt.setForeground(Color.darkGray);
        add(Jackets);
        add(Jeans);
        add(Punjabi);
        add(Shirt);
        add(TShirt);
        group1=new ButtonGroup();
        
       
        
        WomenShelf=new JLabel("Clothing [Women]");
        WomenShelf.setBounds(50, 560, 120, 20);
        WomenShelf.setFont(new Font("serif", Font.PLAIN, 16));
        add(WomenShelf);
        Anarkali=new JRadioButton("Anarkali",false);
        Anarkali.setBounds(50, 580, 120, 20);
        Anarkali.setFont(new Font("monospaced", Font.PLAIN, 12));
        Anarkali.setForeground(Color.darkGray);
        Kurta=new JRadioButton("Kurta",false);
        Kurta.setBounds(50, 600, 120, 20);
        Kurta.setFont(new Font("monospaced", Font.PLAIN, 12));
        Kurta.setForeground(Color.darkGray);
        Lehenga=new JRadioButton("Lehenga");
        Lehenga.setBounds(50, 620, 120, 20);
        Lehenga.setFont(new Font("monospaced", Font.PLAIN, 12));
        Lehenga.setForeground(Color.darkGray);
        LehengaSaree=new JRadioButton("Lehenga-Saree");
        LehengaSaree.setBounds(50, 640, 120, 20);
        LehengaSaree.setFont(new Font("monospaced", Font.PLAIN, 12));
        LehengaSaree.setForeground(Color.darkGray);
        Saree=new JRadioButton("Saree");
        Saree.setBounds(50, 660, 120, 20);
        Saree.setFont(new Font("monospaced", Font.PLAIN, 12));
        Saree.setForeground(Color.darkGray);
        add(Anarkali);
        add(Kurta);
        add(Lehenga);
        add(LehengaSaree);
        add(Saree);
        group1.add(Jackets);
        group1.add(Jeans);
        group1.add(Punjabi);
        group1.add(Shirt);
        group1.add(TShirt);
        group1.add(Anarkali);
        group1.add(Kurta);
        group1.add(Lehenga);
        group1.add(LehengaSaree);
        group1.add(Saree);
        
        
   
      
       
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
        
        
       
        Lehenga.addActionListener(new RadioHandler());
        Saree.addActionListener(new RadioHandler());
        LehengaSaree.addActionListener(new RadioHandler());
        Kurta.addActionListener(new RadioHandler());
        Anarkali.addActionListener(new RadioHandler());
        Shirt.addActionListener(new RadioHandler());
        Jeans.addActionListener(new RadioHandler());
        Jackets.addActionListener(new RadioHandler());
        Punjabi.addActionListener(new RadioHandler());
        TShirt.addActionListener(new RadioHandler());
        String rs="SELECT * FROM `jackets` WHERE `Available`>0";
                MenPanel.Username="JacketName";
                MenPanel.UserId="JacketID";
                MenPanel.PriceId="JacketPrice";
                MenPanel.Available="Available";
                MenPanel.Discount="Discount";
                MenPanel.Table="jackets";
                //System.out.println("Akash in jackets");
                AddButton(rs);
        for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
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
            if(we.getSource()==Shirt)
            {
                String rs="SELECT * FROM `shirt` WHERE `Available`>0";
                Username="ShirtName";
                UserId="ShirtID";
                PriceId="ShirtPrice";
                Available="Available";
                Discount="Discount";
                Table="shirt";
                for(int i=0;i<ButtonCounter;i++)
                {
                    remove(ProductButton[i]);
                    revalidate();
                    repaint();
                }
                
                System.out.println("Akash in Shirt");
        
                AddButton(rs);
                
                for(int i=0;i<ButtonCounter;i++)
              { 
                  System.out.println(Userid[i]);
                  String rsColor="SELECT `ColorName` FROM Color WHERE `ColorID` IN(SELECT `ColorID` FROM `availableshirtcolor` WHERE `ShirtID`='"+Userid[i]+"')";
                  String rsSize="SELECT `SizeName` FROM size WHERE `SizeID` IN(SELECT `SizeID` FROM `availableshirtsize` WHERE `ShirtID`='"+Userid[i]+"')";
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
                for(int k=0;k<colorid.size();k++)
                        {
                      String[] bd=colorid.get(k);
                      for(int j=0;j<bd.length;j++)
                         {   
                         
                             System.out.println("Color  is:"+k+" "+ bd[j]);
                         
                         }
                         
                       }
                for(int i=0;i<ButtonCounter;i++)
             {
            ProductButton[i].addActionListener(new RadioHandler());
             }
                
            }
            else if(we.getSource()==Jeans)
            {
                String rs="SELECT * FROM `jeans` WHERE `Available`>0";
                Username="JeansName";
                UserId="JeansID";
                PriceId="JeansPrice";
                Available="Available";
                Discount="Discount";
                Table="jeans";
                System.out.println("Akash in jeans");
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
                  String rsColor="SELECT `ColorName` FROM Color WHERE `ColorID` IN(SELECT `ColorID` FROM `availablejeanscolor` WHERE `JeansID`='"+Userid[i]+"')";
                  String rsSize="SELECT `SizeName` FROM size WHERE `SizeID` IN(SELECT `SizeID` FROM `availablejeanssize` WHERE `JeansID`='"+Userid[i]+"')";
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
                    } }  
              for(int i=0;i<ButtonCounter;i++)
        {
            ProductButton[i].addActionListener(new RadioHandler());
        }
              
              
              
            }
            else if(we.getSource()==Jackets)
            {
                String rs="SELECT * FROM `jackets` WHERE `Available`>0";
                Username="JacketName";
                UserId="JacketID";
                PriceId="JacketPrice";
                Available="Available";
                Discount="Discount";
                Table="jackets";
                System.out.println("Akash in jackets");
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
                  String rsColor="SELECT `ColorName` FROM Color WHERE `ColorID` IN(SELECT `ColorID` FROM `availablejacketcolor` WHERE `JacketID`='"+Userid[i]+"')";
                  String rsSize="SELECT `SizeName` FROM size WHERE `SizeID` IN(SELECT `SizeID` FROM `availablejacketsize` WHERE `JacketID`='"+Userid[i]+"')";
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
            else if(we.getSource()==Punjabi)
            {
                String rs="SELECT * FROM `punjabi` WHERE `Available`>0";
                Username="PunjabiName";
                UserId="PunjabiID";
                PriceId="PunjabiPrice";
                Available="Available";
                Discount="Discount";
                Table="punjabi";
                System.out.println("Akash in punjabi");
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
                  String rsColor="SELECT `ColorName` FROM Color WHERE `ColorID` IN(SELECT `ColorID` FROM `avaiilablepunjabicolor` WHERE `PunjabiID`='"+Userid[i]+"')";
                  String rsSize="SELECT `SizeName` FROM size WHERE `SizeID` IN(SELECT `SizeID` FROM `availablepunjabisize` WHERE `PunjabiID`='"+Userid[i]+"')";
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
            else if(we.getSource()==TShirt)
            {
                String rs="SELECT * FROM `tshirt` WHERE `Available`>0";
                Username="TshirtName";
                UserId="TshirtID";
                PriceId="TshirtPrice";
                Available="Available";
                Discount="Discount";
                Table="tshirt";
                System.out.println("Akash in tshirt");
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
                  String rsColor="SELECT `ColorName` FROM Color WHERE `ColorID` IN(SELECT `ColorID` FROM `availabletshirtcolor` WHERE `TshirtID`='"+Userid[i]+"')";
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
            if(we.getSource()==Lehenga)
            {
                String rs="SELECT * FROM `lehenga` WHERE `Available`>0";
               Username="LehengaName";
                UserId="LehengaID";
                PriceId="LehengaPrice";
                Available="Available";
                Discount="Discount";
                Table="lehenga";
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
            else if(we.getSource()==Saree)
            {
                String rs="SELECT * FROM `saree` WHERE `Available`>0";
                Username="SareeName";
                UserId="SareeID";
                PriceId="SareePrice";
                Available="Available";
                Discount="Discount";
                Table="saree";
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
            else if(we.getSource()==LehengaSaree)
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
                    Picture[ButtonCounter]=rsShirt.getString("Picture");
                    ProductButton[ButtonCounter]=new JButton(Icon);
                    ProductButton[ButtonCounter].setBounds(285+IncerX, 450+IncerY, 250, 450);
                    ProductButton[ButtonCounter].setBackground(Color.white);
                    add(ProductButton[ButtonCounter]);
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

    
