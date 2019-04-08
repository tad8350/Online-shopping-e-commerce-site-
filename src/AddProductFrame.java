/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class AddProductFrame extends JFrame 
{
    JTextField IdFIELD,NameFIELD,priceFIELD,DiscountFIELD,AvailableFIELD,ColorIdFIELD,PictureFIELD,SizeIdFIELD,DesignerIdFIELD;
    JLabel ProductCatagory,ProductYouCanSee,IDLabel,NameLabel,PriceLabel,ProductListLabel,DiscountLabel,AvailableLabel,ColorLabel,PictureLabel,SizeLabel,DesignerLabel,LowerLabel,ProductBoxlabel;
    JComboBox ProductBox,ProductListBox;
    JButton addProduct,check;
    String [] ProductName={"Select Catagory","MenProduct","WomenProduct","KidProduct","Accessory"};
    String [] MenProduct={"Select Product","Shirt","Jeans","Jackets","Punjabi","T-Shirt"};
    String [] WomenProduct={"Select Product","Saree","Lehenga","LehengaSaree","Kurta","Anarkali"};
    String [] KidProduct={"Select Product","Top","Skirt","BoyJacket","GirlJacket","KidPant","KidShirt"};
    String [] Accessory={"Select Product","Tie","Wallet","Clutch","Watch","Bangle","Belt","Earring","Braclet"};
    int ProductBoxIndex=0;
    final DefaultComboBoxModel men,women,kid,accessory;
    
    
                           
    
   
    public AddProductFrame()
    {
        men=new DefaultComboBoxModel(MenProduct);
        women=new DefaultComboBoxModel(WomenProduct);
        kid=new DefaultComboBoxModel(KidProduct);
        accessory=new DefaultComboBoxModel(Accessory);
        setLayout(null);
        setTitle("Product Catagory Frame");
        setSize(800,1200);
        setLocation(350,0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        ProductCatagory=new JLabel("PRODUCT CATAGORY");
        ProductCatagory.setBounds(200,25,300,25);
        ProductCatagory.setBackground(Color.white);
        ProductCatagory.setForeground(Color.BLACK);
        ProductCatagory.setFont(new Font("monospaced", Font.BOLD, 19));
	add(ProductCatagory);
        
        ProductYouCanSee=new JLabel("YOU CAN SEE OUR PRODUCTS");
        ProductYouCanSee.setBounds(210,60,300,25);
        ProductYouCanSee.setBackground(Color.white);
        ProductYouCanSee.setForeground(Color.red);
        ProductYouCanSee.setFont(new Font("serif", Font.PLAIN, 10));
	add(ProductYouCanSee);
        
        ProductListBox=new JComboBox();
        ProductListBox.setBounds(140,140,300,35);
        ProductListBox.setBackground(Color.white);
        ProductListBox.setForeground(Color.BLACK);
        ProductListBox.setFont(new Font("monospaced", Font.BOLD, 12));
        add(ProductListBox);
        ProductListBox.setVisible(false);
        
        
        
        ProductBox=new JComboBox(ProductName);
        ProductBox.setBounds(140,95,300,35);
        ProductBox.setBackground(Color.white);
        ProductBox.setForeground(Color.BLACK);
        ProductBox.setFont(new Font("monospaced", Font.BOLD, 12));
        add(ProductBox);
        ProductBoxlabel=new JLabel();
        ProductBoxlabel.setBounds(440,95,300,35);
        ProductBoxlabel.setBackground(Color.white);
        ProductBoxlabel.setForeground(Color.red);
        ProductBoxlabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(ProductBoxlabel);
        
        ProductBox.addItemListener(new ItemListener()
        {
            
            public void itemStateChanged(ItemEvent e) 
            {
                if(e.getStateChange()==ItemEvent.SELECTED)
                {
                    String a=(String) ProductBox.getSelectedItem();
                    System.out.println(a);
                    if(a.equals("MenProduct"))
                    {
                        ProductListBox.setModel(men);
                        ProductListBox.setVisible(true);
                        ProductBoxIndex=ProductBox.getSelectedIndex();
                    }
                    if(a.equals("WomenProduct"))
                    {
                        ProductListBox.setModel(women);
                        ProductListBox.setVisible(true);
                        ProductBoxIndex=ProductBox.getSelectedIndex();
                    }
                    if(ProductName[ProductBox.getSelectedIndex()]=="KidProduct")
                    {
                        ProductListBox.setModel(kid);
                        ProductListBox.setVisible(true);
                        ProductBoxIndex=ProductBox.getSelectedIndex();
                    }
                    if(ProductName[ProductBox.getSelectedIndex()]=="Accessory")
                    {
                        ProductListBox.setModel(accessory);
                        ProductListBox.setVisible(true);
                        ProductBoxIndex=ProductBox.getSelectedIndex();
                    }
                    if(a.equals("Select Catagory"))
                    {
                        ProductListBox.setVisible(false);
                        ProductBoxIndex=ProductBox.getSelectedIndex();
                    }
                }
            }
            
            
        }
        
        
        );
        System.out.println(ProductBoxIndex);
        
        IdFIELD=new JTextField();
        IdFIELD.setBounds(140,185,300,35);
        IdFIELD.setBackground(Color.white);
        IdFIELD.setForeground(Color.BLACK);
        IdFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(IdFIELD);
        
        IDLabel=new JLabel(" Id here");
        IDLabel.setBounds(440,185,300,35);
        IDLabel.setBackground(Color.white);
        IDLabel.setForeground(Color.red);
        IDLabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(IDLabel);
        
        DesignerIdFIELD=new JTextField(" Designer Id");
        DesignerIdFIELD.setBounds(140,230,300,35);
        DesignerIdFIELD.setBackground(Color.white);
        DesignerIdFIELD.setForeground(Color.BLACK);
        DesignerIdFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(DesignerIdFIELD);
        
        DesignerLabel=new JLabel(" Designer Id");
        DesignerLabel.setBounds(440,230,300,35);
        DesignerLabel.setBackground(Color.white);
        DesignerLabel.setForeground(Color.red);
        DesignerLabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(DesignerLabel);
        
        
        
        NameFIELD=new JTextField("Name");
        NameFIELD.setBounds(140,275,300,35);
        NameFIELD.setBackground(Color.white);
        NameFIELD.setForeground(Color.BLACK);
        NameFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(NameFIELD);
        
        NameLabel=new JLabel("Name");
        NameLabel.setBounds(440,275,300,35);
        NameLabel.setBackground(Color.white);
        NameLabel.setForeground(Color.RED);
        NameLabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(NameLabel);
        
        priceFIELD=new JTextField(" Price");
        priceFIELD.setBounds(140,320,300,35);
        priceFIELD.setBackground(Color.white);
        priceFIELD.setForeground(Color.BLACK);
        priceFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(priceFIELD);
        
        PriceLabel=new JLabel(" Price");
        PriceLabel.setBounds(440,320,300,35);
        PriceLabel.setBackground(Color.white);
        PriceLabel.setForeground(Color.red);
        PriceLabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(PriceLabel);
        
        DiscountFIELD=new JTextField(" Discount");
        DiscountFIELD.setBounds(140,365,300,35);
        DiscountFIELD.setBackground(Color.white);
        DiscountFIELD.setForeground(Color.BLACK);
        DiscountFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(DiscountFIELD);
        
        DiscountLabel=new JLabel(" Discount");
        DiscountLabel.setBounds(440,365,300,35);
        DiscountLabel.setBackground(Color.white);
        DiscountLabel.setForeground(Color.red);
        DiscountLabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(DiscountLabel);
        
        AvailableFIELD=new JTextField(" Available");
        AvailableFIELD.setBounds(140,410,300,35);
        AvailableFIELD.setBackground(Color.white);
        AvailableFIELD.setForeground(Color.BLACK);
        AvailableFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(AvailableFIELD);
        
        AvailableLabel=new JLabel(" Available");
        AvailableLabel.setBounds(440,410,300,35);
        AvailableLabel.setBackground(Color.white);
        AvailableLabel.setForeground(Color.red);
        AvailableLabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(AvailableLabel);
        
        PictureFIELD=new JTextField(" Picture");
        PictureFIELD.setBounds(140,455,300,35);
        PictureFIELD.setBackground(Color.white);
        PictureFIELD.setForeground(Color.BLACK);
        PictureFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(PictureFIELD);
        
        PictureLabel=new JLabel(" Picture");
        PictureLabel.setBounds(440,455,300,35);
        PictureLabel.setBackground(Color.white);
        PictureLabel.setForeground(Color.RED);
        PictureLabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(PictureLabel);
        
        SizeIdFIELD=new JTextField(" Size Id");
        SizeIdFIELD.setBounds(140,500,300,35);
        SizeIdFIELD.setBackground(Color.white);
        SizeIdFIELD.setForeground(Color.BLACK);
        SizeIdFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(SizeIdFIELD);
        
        SizeLabel=new JLabel(" Size Id");
        SizeLabel.setBounds(440,500,300,35);
        SizeLabel.setBackground(Color.white);
        SizeLabel.setForeground(Color.red);
        SizeLabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(SizeLabel);
        
        ColorIdFIELD=new JTextField(" Color Id");
        ColorIdFIELD.setBounds(140,545,300,35);
        ColorIdFIELD.setBackground(Color.white);
        ColorIdFIELD.setForeground(Color.BLACK);
        ColorIdFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(ColorIdFIELD);
        
        ColorLabel=new JLabel(" Color Id");
        ColorLabel.setBounds(440,545,300,35);
        ColorLabel.setBackground(Color.white);
        ColorLabel.setForeground(Color.RED);
        ColorLabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(ColorLabel);
        
       
        addProduct=new JButton(" Add Product");
        addProduct.setBounds(140,590,150,35);
        addProduct.setBackground(Color.white);
        addProduct.setForeground(Color.RED);
        addProduct.setFont(new Font("monospaced", Font.BOLD, 12));
        add(addProduct);
        check=new JButton("check");
        check.setBounds(290,590,150,35);
        check.setBackground(Color.white);
        check.setForeground(Color.RED);
        check.setFont(new Font("monospaced", Font.BOLD, 12));
        add(check);
        
        LowerLabel=new JLabel("***Before Adding Product you must Check by clicking 'Check' Button");
        LowerLabel.setBounds(140, 630, 600, 35);
        LowerLabel.setBackground(Color.white);
        LowerLabel.setForeground(Color.red);
        LowerLabel.setFont(new Font("monospaced", Font.BOLD, 14));
        add(LowerLabel);
        addProduct.addActionListener(new Handler());
        check.addActionListener(new Handler());
    
}
    class Handler implements ActionListener
            {

        
        public void actionPerformed(ActionEvent e)
        {   
            boolean flag;
            if(e.getSource()==check)
            {
            if(ProductBoxIndex==1)
            {
               int a=ProductListBox.getSelectedIndex();
              
                   IDLabel.setText(MenProduct[a]+"Id here(First put '" +MenProduct[a]+"' Must)");
                   NameLabel.setText(MenProduct[a]+" name");
                   PriceLabel.setText(MenProduct[a]+" Price");
                   DiscountLabel.setText(MenProduct[a]+" Discount");
                   AvailableLabel.setText(MenProduct[a]+" Available");
                   ColorLabel.setText(MenProduct[a]+" Color id");
                   PictureLabel.setText(MenProduct[a]+" Picture");
                   SizeLabel.setText(MenProduct[a]+"  Size id");
                   DesignerLabel.setText(MenProduct[a]+" Designer id");
                   
                   
              }
            else if(ProductBoxIndex==2)
            {
               int a=ProductListBox.getSelectedIndex();
              
                   IDLabel.setText(WomenProduct[a]+"Id here(First put '" +WomenProduct[a]+"' Must)");
                   NameLabel.setText(WomenProduct[a]+" name");
                   PriceLabel.setText(WomenProduct[a]+" Price");
                   DiscountLabel.setText(WomenProduct[a]+" Discount");
                   AvailableLabel.setText(WomenProduct[a]+" Available");
                   ColorLabel.setText(WomenProduct[a]+" Color id");
                   PictureLabel.setText(WomenProduct[a]+" Picture");
                   SizeLabel.setText(WomenProduct[a]+"  Size id");
                   DesignerLabel.setText(WomenProduct[a]+" Designer id");
                   
                   
              }
            if(ProductBoxIndex==3)
            {
               int a=ProductListBox.getSelectedIndex();
              
                   IDLabel.setText(KidProduct[a]+"Id here(First put '" +KidProduct[a]+"' Must)");
                   NameLabel.setText(KidProduct[a]+" name");
                   PriceLabel.setText(KidProduct[a]+" Price");
                   DiscountLabel.setText(KidProduct[a]+" Discount");
                   AvailableLabel.setText(KidProduct[a]+" Available");
                   ColorLabel.setText(KidProduct[a]+" Color id");
                   PictureLabel.setText(KidProduct[a]+" Picture");
                   SizeLabel.setText(KidProduct[a]+"  Size id");
                   DesignerLabel.setText(KidProduct[a]+" Designer id");
                   
                   
              }
            if(ProductBoxIndex==4)
            {
               int a=ProductListBox.getSelectedIndex();
              
                   IDLabel.setText(Accessory[a]+"Id here(First put '" +Accessory[a]+"' Must)");
                   NameLabel.setText(Accessory[a]+" name");
                   PriceLabel.setText(Accessory[a]+" Price");
                   DiscountLabel.setText(Accessory[a]+" Discount");
                   AvailableLabel.setText(Accessory[a]+" Available");
                   ColorLabel.setText(Accessory[a]+" Color id");
                   PictureLabel.setText(Accessory[a]+" Picture");
                   SizeLabel.setText(Accessory[a]+"  Size id");
                   DesignerLabel.setText(Accessory[a]+" Designer id");
                   
                   
              }
               
                
            }
            if(e.getSource()==addProduct)
            {
                flag=check();
                if(flag==true)
                {
                    int ProductListIndex=ProductListBox.getSelectedIndex();
                    if(ProductBoxIndex==1)
                    {   
                        
                        
                        if(ProductListIndex==1)
                        {   int shirtUsercheck=0;
                            String ShirtUser="SELECT `ShirtID` FROM `shirt`";
                            ResultSet rsShirt;
                            DBConnector com=new DBConnector();
                            rsShirt=com.setData(ShirtUser);
                            try {
                                while(rsShirt.next())
                                {
                                    if(rsShirt.getString("ShirtID").equals(IdFIELD.getText()))
                                    {
                                        shirtUsercheck=1;
                                        break;
                                    }
                                }
                                if(shirtUsercheck==1)
                                {
                                    IDLabel.setText("Already have this Shirtid");
                                }
                                else
                                {
                                    String shirt="INSERT INTO `shirt`(`MenProductID`, `ShirtID`, `ShirtName`, `ShirtPrice`, `Discount`, `Available`, `Picture`) VALUES ('M1','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String shirtsize="INSERT INTO `availableshirtsize`(`ShirtID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String shirtcolor="INSERT INTO `availableshirtcolor`(`ShirtID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    String designershirt="INSERT INTO `availabledesignershirt`(`ShirtID`, `DesignerID`) VALUES ('"+IdFIELD.getText()+"','"+DesignerIdFIELD.getText()+"')";
                                    DBConnector com1=new DBConnector();
                                    com.updateData(shirt);
                                    com.updateData(shirtsize);
                                    com.updateData(shirtcolor);
                                    com.updateData(designershirt);
                                    //setVisible(false);
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                    
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                       else if(ProductListIndex==2)
                        {
                            int jeansUsercheck=0;
                            String JeansUser="SELECT `JeansID` FROM `jeans`";
                            ResultSet rsJeans;
                            DBConnector com=new DBConnector();
                            rsJeans=com.setData(JeansUser);
                            try {
                                while(rsJeans.next())
                                {
                                    if(rsJeans.getString("JeansID").equals(IdFIELD.getText()))
                                    {
                                        jeansUsercheck=1;
                                        break;
                                    }
                                }
                                if(jeansUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String jeans="INSERT INTO `jeans`(`MenProductID`, `JeansID`, `JeansName`, `JeansPrice`, `Discount`, `Available`, `Picture`) VALUES ('M2','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String jeanssize="INSERT INTO `availablejeanssize`(`JeansID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String jeanscolor="INSERT INTO `availablejeanscolor`(`JeansID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    String designerjeans="INSERT INTO `availabledesignerjeans`(`JeansID`, `DesignerID`) VALUES ('"+IdFIELD.getText()+"','"+DesignerIdFIELD.getText()+"')";
                                    DBConnector com1=new DBConnector();
                                    com.updateData(jeans);
                                    com.updateData(jeanssize);
                                    com.updateData(jeanscolor);
                                    com.updateData(designerjeans);
                                    //setVisible(false);
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                       else if(ProductListIndex==3)
                        {
                            int jacketsUsercheck=0;
                            String jacketsUser="SELECT `JacketID` FROM `jackets` ";
                            ResultSet rsjackets;
                            DBConnector com=new DBConnector();
                            rsjackets=com.setData(jacketsUser);
                            try {
                                while(rsjackets.next())
                                {
                                    if(rsjackets.getString("JacketID").equals(IdFIELD.getText()))
                                    {
                                        jacketsUsercheck=1;
                                        break;
                                    }
                                }
                                if(jacketsUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String jackets="INSERT INTO `jackets`(`MenProductID`, `JacketID`, `JacketName`, `JacketPrice`, `Discount`, `Available`, `Picture`) VALUES ('M3','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String jacketsize="INSERT INTO `availablejacketsize`(`JacketID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String jacketcolor="INSERT INTO `availablejacketcolor`(`JacketID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    String designerjacket="INSERT INTO `availabledesignerjacket`(`JacketID`, `DesignerID`) VALUES ('"+IdFIELD.getText()+"','"+DesignerIdFIELD.getText()+"')";
                                    com.updateData(jackets);
                                    com.updateData(jacketsize);
                                    com.updateData(jacketcolor);
                                    com.updateData(designerjacket);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful"); 
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                       else if(ProductListIndex==4)
                        {
                            int punjabiUsercheck=0;
                            String punjabiUser="SELECT `PunjabiID` FROM `punjabi`";
                            ResultSet rspunjabi;
                            DBConnector com=new DBConnector();
                            rspunjabi=com.setData(punjabiUser);
                            try {
                                while(rspunjabi.next())
                                {
                                    if(rspunjabi.getString("PunjabiID").equals(IdFIELD.getText()))
                                    {
                                        punjabiUsercheck=1;
                                        break;
                                    }
                                }
                                if(punjabiUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String punjabi="INSERT INTO `punjabi`(`MenProductID`, `PunjabiID`, `PunjabiName`, `PunjabiPrice`, `Discount`, `Available`, `Picture`) VALUES ('M4','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String punjabisize="INSERT INTO `availablepunjabisize`(`PunjabiID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String punjabicolor="INSERT INTO `avaiilablepunjabicolor`(`PunjabiID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    String designerpunjabi="INSERT INTO `availabledesignerpunjabi`(`PunjabiID`, `DesignerID`) VALUES ('"+IdFIELD.getText()+"','"+DesignerIdFIELD.getText()+"')";
                                    com.updateData(punjabi);
                                    com.updateData(punjabisize);
                                    com.updateData(punjabicolor);
                                    com.updateData(designerpunjabi);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful"); 
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                       else if(ProductListIndex==5)
                        {
                            int tshirtUsercheck=0;
                            String tshirtUser="SELECT `TshirtID` FROM `tshirt`";
                            ResultSet rstshirt;
                            DBConnector com=new DBConnector();
                            rstshirt=com.setData(tshirtUser);
                            try {
                                while(rstshirt.next())
                                {
                                    if(rstshirt.getString("TshirtID").equals(IdFIELD.getText()))
                                    {
                                        tshirtUsercheck=1;
                                        break;
                                    }
                                }
                                if(tshirtUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String tshirt="INSERT INTO `tshirt`(`MenProductID`, `TshirtID`, `TshirtName`, `TshirtPrice`, `Discount`, `Available`, `Picture`) VALUES ('M5','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String tshirtsize="INSERT INTO `availabletshirtsize`(`TshirtID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String tshirtcolor="INSERT INTO `availabletshirtcolor`(`TshirtID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    String designertshirt="INSERT INTO `availabledesignertshirt`(`TshirtID`, `DesignerID`) VALUES ('"+IdFIELD.getText()+"','"+DesignerIdFIELD.getText()+"')";
                                    com.updateData(tshirt);
                                    com.updateData(tshirtsize);
                                    com.updateData(tshirtcolor);
                                    com.updateData(designertshirt);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful"); 
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                    }
                    else if(ProductBoxIndex==2)
                    {
                        if(ProductListIndex==1)
                        {
                            int sareeUsercheck=0;
                            String sareeUser="SELECT `SareeID` FROM `saree`";
                            ResultSet rssaree;
                            DBConnector com=new DBConnector();
                            rssaree=com.setData(sareeUser);
                            try {
                                while(rssaree.next())
                                {
                                    if(rssaree.getString("SareeID").equals(IdFIELD.getText()))
                                    {
                                        sareeUsercheck=1;
                                        break;
                                    }
                                }
                                if(sareeUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String saree="INSERT INTO `saree`(`WomenProductID`, `SareeID`, `SareeName`, `SareePrice`, `Discount`, `Available`, `Picture`) VALUES ('W1','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String sareecolor="INSERT INTO `availablesareecolor`(`SareeID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    String designersaree="INSERT INTO `availabledesignersaree`(`SareeID`, `DesignerID`) VALUES ('"+IdFIELD.getText()+"','"+DesignerIdFIELD.getText()+"')";
                                    com.updateData(saree);
                                    com.updateData(sareecolor);
                                    com.updateData(designersaree);
                                    
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful"); 
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==2)
                        {
                            int LehengaUsercheck=0;
                            String LehengaUser="SELECT `LehengaID` FROM `lehenga`";
                            ResultSet rsLehenga;
                            DBConnector com=new DBConnector();
                            rsLehenga=com.setData(LehengaUser);
                            try {
                                while(rsLehenga.next())
                                {
                                    if(rsLehenga.getString("LehengaID").equals(IdFIELD.getText()))
                                    {
                                        LehengaUsercheck=1;
                                        break;
                                    }
                                }
                                if(LehengaUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String lehenga="INSERT INTO `lehenga`(`WomenProductID`, `LehengaID`, `LehengaName`, `LehengaPrice`, `Discount`, `Available`, `Picture`) VALUES ('W2','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String lehengasize="INSERT INTO `availablelehengasize`(`LehengaID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String lehengacolor="INSERT INTO `availablelehengacolor`(`LehengaID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    String designerlehenga="INSERT INTO `availabledesignerlehenga`(`LehengaID`, `DesignerID`) VALUES ('"+IdFIELD.getText()+"','"+DesignerIdFIELD.getText()+"')";
                                    com.updateData(lehenga);
                                    com.updateData(lehengasize);
                                    com.updateData(lehengacolor);
                                    com.updateData(designerlehenga);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==3)
                        {
                            int LehengasareeUsercheck=0;
                            String LehengasareeUser="SELECT `LehengaSareeID` FROM `lehengasaree`";
                            ResultSet rsLehengasaree;
                            DBConnector com=new DBConnector();
                            rsLehengasaree=com.setData(LehengasareeUser);
                            try {
                                while(rsLehengasaree.next())
                                {
                                    if(rsLehengasaree.getString("LehengaSareeID").equals(IdFIELD.getText()))
                                    {
                                        LehengasareeUsercheck=1;
                                        break;
                                    }
                                }
                                if(LehengasareeUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String lehengasaree="INSERT INTO `lehengasaree`(`WomenProductID`, `LehengaSareeID`, `LehengaSareeName`, `LehengaSareePrice`, `Discount`, `Available`, `Picture`) VALUES ('W3','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String lehengasareesize="INSERT INTO `availabelehengasareesize`(`LehengaSareeID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String lehengasareecolor="INSERT INTO `availabelehengasareecolor`(`LehengaSareeID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    String designerlehengasaree="INSERT INTO `availabedesignerlehengasaree`(`LehengaSareeID`, `DesignerID`) VALUES ('"+IdFIELD.getText()+"','"+DesignerIdFIELD.getText()+"')";
                                    com.updateData(lehengasaree);
                                    com.updateData(lehengasareesize);
                                    com.updateData(lehengasareecolor);
                                    com.updateData(designerlehengasaree);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==4)
                        {
                            int kurtaUsercheck=0;
                            String kurtaUser="SELECT `KurtaID` FROM `kurta`";
                            ResultSet rskurta;
                            DBConnector com=new DBConnector();
                            rskurta=com.setData(kurtaUser);
                            try {
                                while(rskurta.next())
                                {
                                    if(rskurta.getString("KurtaID").equals(IdFIELD.getText()))
                                    {
                                        kurtaUsercheck=1;
                                        break;
                                    }
                                }
                                if(kurtaUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String kurta="INSERT INTO `kurta`(`WomenProductID`, `KurtaID`, `KurtaName`, `KurtaPrice`, `Discount`, `Available`, `Picture`) VALUES ('W4','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String kurtasize="INSERT INTO `availablekurtasize`(`KurtaID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String kurtacolor="INSERT INTO `availablekurtacolor`(`KurtaID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    String designerkurta="INSERT INTO `availabledesignerkurta`(`KurtaID`, `DesignerID`) VALUES ('"+IdFIELD.getText()+"','"+DesignerIdFIELD.getText()+"')";
                                    com.updateData(kurta);
                                    com.updateData(kurtasize);
                                    com.updateData(kurtacolor);
                                    com.updateData(designerkurta);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful"); 
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==5)
                        {
                            int anarkaliUsercheck=0;
                            String anarkaliUser="SELECT `AnarkaliID` FROM `anarkali`";
                            ResultSet rsanarkali;
                            DBConnector com=new DBConnector();
                            rsanarkali=com.setData(anarkaliUser);
                            try {
                                while(rsanarkali.next())
                                {
                                    if(rsanarkali.getString("AnarkaliID").equals(IdFIELD.getText()))
                                    {
                                        anarkaliUsercheck=1;
                                        break;
                                    }
                                }
                                if(anarkaliUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String anarkali="INSERT INTO `anarkali`(`WomenProductID`, `AnarkaliID`, `AnarkaliName`, `AnarkaliPrice`, `Discount`, `Available`, `Picture`) VALUES ('W5','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String anarkalisize="INSERT INTO `availableanarkalisize`(`AnarkaliID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String anarkalicolor="INSERT INTO `availableanarkalicolor`(`AnarkaliID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    String designeranarkali="INSERT INTO `availabledesigneranarkali`(`AnarkaliID`, `DesignerID`) VALUES ('"+IdFIELD.getText()+"','"+DesignerIdFIELD.getText()+"')";
                                    com.updateData(anarkali);
                                    com.updateData(anarkalisize);
                                    com.updateData(anarkalicolor);
                                    com.updateData(designeranarkali);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        
                    }
                    else if(ProductBoxIndex==4)
                    {
                        if(ProductListIndex==1)
                        {
                            int TieUsercheck=0;
                            String TieUser="SELECT `TieID` FROM `tie`";
                            ResultSet rsTie;
                            DBConnector com=new DBConnector();
                            rsTie=com.setData(TieUser);
                            try {
                                while(rsTie.next())
                                {
                                    if(rsTie.getString("TieID").equals(IdFIELD.getText()))
                                    {
                                        TieUsercheck=1;
                                        break;
                                    }
                                }
                                if(TieUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String tie="INSERT INTO `tie`(`AccesoryID`, `TieID`, `TieName`, `TiePrice`, `Discount`, `Available`, `Picture`) VALUES ('A1','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String tiecolor="INSERT INTO `availabletiecolor`(`TieID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    com.updateData(tie);
                                    com.updateData(tiecolor);
                                    //com.updateData(anarkalicolor);
                                    //com.updateData(designeranarkali);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");  
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==2)
                        {
                            int walletUsercheck=0;
                            String walletUser="SELECT `WalletID` FROM `wallet`";
                            ResultSet rswallet;
                            DBConnector com=new DBConnector();
                            rswallet=com.setData(walletUser);
                            try {
                                while(rswallet.next())
                                {
                                    if(rswallet.getString("WalletID").equals(IdFIELD.getText()))
                                    {
                                        walletUsercheck=1;
                                        break;
                                    }
                                }
                                if(walletUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String wallet="INSERT INTO `wallet`(`AccesoryID`, `WalletID`, `WalletName`, `WalletPrice`, `Discount`, `Available`, `Picture`) VALUES ('A2','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String walletcolor="INSERT INTO `availablewalletcolor`(`WalletID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    com.updateData(wallet);
                                    com.updateData(walletcolor);
                                    //com.updateData(anarkalicolor);
                                    //com.updateData(designeranarkali);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==3)
                        {
                            int clutchUsercheck=0;
                            String clutchUser="SELECT `ClutchID` FROM `clutch`";
                            ResultSet rsclutch;
                            DBConnector com=new DBConnector();
                            rsclutch=com.setData(clutchUser);
                            try {
                                while(rsclutch.next())
                                {
                                    if(rsclutch.getString("ClutchID").equals(IdFIELD.getText()))
                                    {
                                        clutchUsercheck=1;
                                        break;
                                    }
                                }
                                if(clutchUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String clutch="INSERT INTO `clutch`(`AccesoryID`, `ClutchID`, `ClutchName`, `ClutchPrice`, `Discount`, `Available`, `Picture`) VALUES ('A6','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";

                                    com.updateData(clutch);
                                    //com.updateData(walletcolor);
                                    //com.updateData(anarkalicolor);
                                    //com.updateData(designeranarkali);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==4)
                        {
                            int WatchUsercheck=0;
                            String WatchUser="SELECT `WatchID` FROM `watch` ";
                            ResultSet rsWatch;
                            DBConnector com=new DBConnector();
                            rsWatch=com.setData(WatchUser);
                            try {
                                while(rsWatch.next())
                                {
                                    if(rsWatch.getString("WatchID").equals(IdFIELD.getText()))
                                    {
                                        WatchUsercheck=1;
                                        break;
                                    }
                                }
                                if(WatchUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String watch="INSERT INTO `watch`(`AccesoryID`, `WatchID`, `WatchName`, `WatchPrice`, `Discount`, `Available`, `Picture`) VALUES ('A3','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')"; 
                                    com.updateData(watch);
                                    //com.updateData(walletcolor);
                                    //com.updateData(anarkalicolor);
                                    //com.updateData(designeranarkali);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==5)
                        {
                            int bangleUsercheck=0;
                            String bangleUser="SELECT `BangleID` FROM `bangle` ";
                            ResultSet rsbangle;
                            DBConnector com=new DBConnector();
                            rsbangle=com.setData(bangleUser);
                            try {
                                while(rsbangle.next())
                                {
                                    if(rsbangle.getString("BangleID").equals(IdFIELD.getText()))
                                    {
                                        bangleUsercheck=1;
                                        break;
                                    }
                                }
                                if(bangleUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                   String bangle="INSERT INTO `bangle`(`AccesoryID`, `BangleID`, `BangleName`, `BanglePrice`, `Discount`, `Available`, `Picture`) VALUES ('A5','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')"; 
                                   com.updateData(bangle);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==6)
                        {
                            int beltUsercheck=0;
                            String beltUser="SELECT `BeltID` FROM `belt`  ";
                            ResultSet rsbelt;
                            DBConnector com=new DBConnector();
                            rsbelt=com.setData(beltUser);
                            try {
                                while(rsbelt.next())
                                {
                                    if(rsbelt.getString("BeltID").equals(IdFIELD.getText()))
                                    {
                                        beltUsercheck=1;
                                        break;
                                    }
                                }
                                if(beltUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String belt="INSERT INTO `belt`(`AccesoryID`, `BeltID`, `BeltName`, `BeltPrice`, `Discount`, `Available`, `Picture`) VALUES ('A4','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String beltcolor="INSERT INTO `availablebeltcolor`(`BeltID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    com.updateData(belt);
                                    com.updateData(beltcolor);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");  
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==7)
                        {
                            int earringUsercheck=0;
                            String earringUser="SELECT `EarRingID` FROM `earring`";
                            ResultSet rsearring;
                            DBConnector com=new DBConnector();
                            rsearring=com.setData(earringUser);
                            try {
                                while(rsearring.next())
                                {
                                    if(rsearring.getString("EarRingID").equals(IdFIELD.getText()))
                                    {
                                        earringUsercheck=1;
                                        break;
                                    }
                                }
                                if(earringUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String earring="INSERT INTO `earring`(`AccesoryID`, `EarringID`, `EarringName`, `EarringPrice`, `Discount`, `Available`, `Picture`) VALUES ('A7','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    com.updateData(earring);
                                    
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");  
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==8)
                        {
                            int bracletUsercheck=0;
                            String bracletUser="SELECT `BraceletID` FROM `bracelet`";
                            ResultSet rsbraclet;
                            DBConnector com=new DBConnector();
                            rsbraclet=com.setData(bracletUser);
                            try {
                                while(rsbraclet.next())
                                {
                                    if(rsbraclet.getString("BraceletID").equals(IdFIELD.getText()))
                                    {
                                        bracletUsercheck=1;
                                        break;
                                    }
                                }
                                if(bracletUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                   String bracelet="INSERT INTO `bracelet`(`AccesoryID`, `BraceletID`, `BraceletName`, `BraceletPrice`, `Discount`, `Available`, `Picture`) VALUES ('A8','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    com.updateData(bracelet);
                                    
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");   
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        
                    }
                    else if(ProductBoxIndex==3)
                    {
                        if(ProductListIndex==1)
                        {
                            int TopUsercheck=0;
                            String TopUser="SELECT `TopID` FROM `top`";
                            ResultSet rsTop;
                            DBConnector com=new DBConnector();
                            rsTop=com.setData(TopUser);
                            try {
                                while(rsTop.next())
                                {
                                    if(rsTop.getString("TopID").equals(IdFIELD.getText()))
                                    {
                                        TopUsercheck=1;
                                        break;
                                    }
                                }
                                if(TopUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String top="INSERT INTO `top`(`KidProductID`, `TopID`, `TopName`, `TopPrice`, `Discount`, `Available`, `Picture`) VALUES ('K1','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String topcolor="INSERT INTO `avaialabletopcolor`(`TopID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    String topsize="INSERT INTO `availabletopsize`(`TopID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    com.updateData(top);
                                    com.updateData(topcolor);
                                    com.updateData(topsize);
                                    //com.updateData(designeranarkali);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==2)
                        {
                            int skirtUsercheck=0;
                            String skirtUser="SELECT `SkirtID` FROM `skirt`";
                            ResultSet rsskirt;
                            DBConnector com=new DBConnector();
                            rsskirt=com.setData(skirtUser);
                            try {
                                while(rsskirt.next())
                                {
                                    if(rsskirt.getString("SkirtID").equals(IdFIELD.getText()))
                                    {
                                        skirtUsercheck=1;
                                        break;
                                    }
                                }
                                if(skirtUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String skirt="INSERT INTO `skirt`(`KidProductID`, `SkirtID`, `SkirtName`, `SkirtPrice`, `Discount`, `Available`, `Picture`) VALUES ('K2','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String skirtsize="INSERT INTO `availableskirtsize`(`SkirtID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String skirtcolor="INSERT INTO `availableskirtcolor`(`SkirtID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    com.updateData(skirt);
                                    com.updateData(skirtsize);
                                    com.updateData(skirtcolor);
                                    //com.updateData(designeranarkali);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==3)
                        {
                            int BoyjacketUsercheck=0;
                            String BoyjacketUser="SELECT `BoyJacketID` FROM `boyjacket`";
                            ResultSet rsBoyjacket;
                            DBConnector com=new DBConnector();
                            rsBoyjacket=com.setData(BoyjacketUser);
                            try {
                                while(rsBoyjacket.next())
                                {
                                    if(rsBoyjacket.getString("BoyJacketID").equals(IdFIELD.getText()))
                                    {
                                        BoyjacketUsercheck=1;
                                        break;
                                    }
                                }
                                if(BoyjacketUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {   
                                    String boyjacket="INSERT INTO `boyjacket`(`KidProductID`, `BoyJacketID`, `BoyJacketName`, `BoyJacketPrice`, `Discount`, `Available`, `Picture`) VALUES ('K4','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String boyjacketsize="INSERT INTO `availableboyjacketsize`(`BoyJacketID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String boyjacketcolor="INSERT INTO `availableboyjacketcolor`(`BoyJacketID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    com.updateData(boyjacket);
                                    com.updateData(boyjacketsize);
                                    com.updateData(boyjacketcolor);
                                    //com.updateData(designeranarkali);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==4)
                        {
                            int girljacketUsercheck=0;
                            String girljacketUser="SELECT `GirlJacketID` FROM `girljacket` ";
                            ResultSet rsgirljacket;
                            DBConnector com=new DBConnector();
                            rsgirljacket=com.setData(girljacketUser);
                            try {
                                while(rsgirljacket.next())
                                {
                                    if(rsgirljacket.getString("GirlJacketID").equals(IdFIELD.getText()))
                                    {
                                        girljacketUsercheck=1;
                                        break;
                                    }
                                }
                                if(girljacketUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String girljacket="INSERT INTO `girljacket`(`KidProductID`, `GirlJacketID`, `GirlJacketName`, `GirlJacketPrice`, `Discount`, `Available`, `Picture`) VALUES ('K3','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String girljacketsize="INSERT INTO `availablegirljacketsize`(`GirlJacketID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String girljacketcolor="INSERT INTO `availablegirljacketcolor`(`GirlJacketID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    com.updateData(girljacket);
                                    com.updateData(girljacketsize);
                                    com.updateData(girljacketcolor);
                                    //com.updateData(designeranarkali);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==5)
                        {
                            int kidpantUsercheck=0;
                            String kidpantUser="SELECT `KidPantID` FROM `kidpant`";
                            ResultSet rskidpant;
                            DBConnector com=new DBConnector();
                            rskidpant=com.setData(kidpantUser);
                            try {
                                while(rskidpant.next())
                                {
                                    if(rskidpant.getString("KidPantID").equals(IdFIELD.getText()))
                                    {
                                        kidpantUsercheck=1;
                                        break;
                                    }
                                }
                                if(kidpantUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String kidpant="INSERT INTO `kidpant`(`KidProductID`, `KidPantID`, `KidPantName`, `KidPantPrice`, `Discount`, `Available`, `Picture`) VALUES ('K6','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String kidpantsize="INSERT INTO `availablekidpantsize`(`KidPantID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String kidpantcolor="INSERT INTO `availablekidpantcolor`(`KidPantID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    com.updateData(kidpant);
                                    com.updateData(kidpantsize);
                                    com.updateData(kidpantcolor);
                                    //com.updateData(designeranarkali);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");  
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        else if(ProductListIndex==6)
                        {
                            int kidshirtUsercheck=0;
                            String kidshirtUser="SELECT `KidShirtID` FROM `kidshirt` ";
                            ResultSet rskidshirt;
                            DBConnector com=new DBConnector();
                            rskidshirt=com.setData(kidshirtUser);
                            try {
                                while(rskidshirt.next())
                                {
                                    if(rskidshirt.getString("KidShirtID").equals(IdFIELD.getText()))
                                    {
                                        kidshirtUsercheck=1;
                                        break;
                                    }
                                }
                                if(kidshirtUsercheck==1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                    String kidshirt="INSERT INTO `kidshirt`(`KidProductID`, `KidShirtID`, `KidShirtName`, `KidShirtPrice`, `Discount`, `Available`, `Picture`) VALUES ('K5','"+IdFIELD.getText()+"','"+NameFIELD.getText()+"','"+Integer.parseInt(priceFIELD.getText())+"','"+Integer.parseInt(DiscountFIELD.getText())+"','"+Integer.parseInt(AvailableFIELD.getText())+"','"+PictureFIELD.getText()+"')";
                                    String kidshirtsize="INSERT INTO `availablekidshirtsize`(`KidShirtID`, `SizeID`) VALUES ('"+IdFIELD.getText()+"','"+SizeIdFIELD.getText()+"')";
                                    String kidshirtcolor="INSERT INTO `availablekidshirtcolor`(`KidShirtID`, `ColorID`) VALUES ('"+IdFIELD.getText()+"','"+ColorIdFIELD.getText()+"')";
                                    com.updateData(kidshirt);
                                    com.updateData(kidshirtsize);
                                    com.updateData(kidshirtcolor);
                                    //com.updateData(designeranarkali);
                                    
                                    JOptionPane.showMessageDialog(rootPane,"Sucessful");   
                                }
                            } catch (SQLException ex) {
                                System.out.println("Error is:"+ex);
                            }
                        }
                        
                    }
                }
            }
        }
        public boolean check()
        {
            boolean flag=true;
            if(ProductBoxIndex==0)
            {
                ProductBoxlabel.setText("Please Select a option");
                flag=false;
            }
            else
            {
                ProductBoxlabel.setText("Accept");
            }
            if(IdFIELD.getText().equals(""))
            {
                IDLabel.setText("Input an Id");
                flag=false;
            }
            else
            {
                IDLabel.setText("Input found");
            }
            if(DesignerIdFIELD.getText().equals("") || DesignerIdFIELD.getText().equals(" Designer Id") )
            {
                DesignerLabel.setText("Input an Designer Id");
                flag=false;
            }
            else
            {
                DesignerLabel.setText("Input found");
            }
            if(NameFIELD.getText().equals(null) || NameFIELD.getText().equals("Name") )
            {
                NameLabel.setText("Input Name");
                flag=false;
            }
            else
            {
                NameLabel.setText("Input found");
            }
            if(priceFIELD.getText().equals("") || priceFIELD.getText().equals(" Price") )
            {
                PriceLabel.setText("Input price");
                flag=false;
            }
            else
            {
                PriceLabel.setText("Input found");
            }
            if(DiscountFIELD.getText().equals("") || DiscountFIELD.getText().equals(" Discount") )
            {
                DiscountLabel.setText("Input a Discounter Id");
                flag=false;
            }
            else
            {
                DiscountLabel.setText("Input found");
            }
            if(AvailableFIELD.getText().equals("") || AvailableFIELD.getText().equals(" Available") )
            {
                AvailableLabel.setText("Input available product");
                flag=false;
            }
            else
            {
                AvailableLabel.setText("Input found");
            }
             if(PictureFIELD.getText().equals("") || PictureFIELD.getText().equals(" Picture") )
            {
                PictureLabel.setText("Input a picture");
                flag=false;
            }
            else
            {
                PictureLabel.setText("Input found");
            }
              if(SizeIdFIELD.getText().equals("") || SizeIdFIELD.getText().equals(" Size Id") )
            {
                SizeLabel.setText("Input a size Id");
                flag=false;
            }
            else
            {
                SizeLabel.setText("Input found");
            }
             if(ColorIdFIELD.getText().equals("") || ColorIdFIELD.getText().equals(" Color Id") )
            {
                ColorLabel.setText("Input a color Id");
                flag=false;
            }
            else
            {
                ColorLabel.setText("Input found");
            }
            
            
            return flag;
        }
        }
                
          }
