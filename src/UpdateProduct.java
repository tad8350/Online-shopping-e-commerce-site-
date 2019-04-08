/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author user
 */
public class UpdateProduct extends JFrame {
 
    JLabel RemoveProductLabel,RemoveProductQuote,RemoveProductboxLabel,RemoveProductlistLabel,IDLabel;
            JButton RemoveProductLabel4;
    JTextField IdFIELD;
    JComboBox ProductBox,ProductListBox;
    JButton addProduct,check;
    String [] ProductName={"Select Catagory","MenProduct","WomenProduct","KidProduct","Accessory"};
    String [] MenProduct={"Select Product","Shirt","Jeans","Jackets","Punjabi","T-Shirt"};
    String [] WomenProduct={"Select Product","Saree","Lehenga","LehengaSaree","Kurta","Anarkali"};
    String [] KidProduct={"Select Product","Top","Skirt","BoyJacket","GirlJacket","KidPant","KidShirt"};
    String [] Accessory={"Select Product","Tie","Wallet","Clutch","Watch","Bangle","Belt","Earring","Braclet"};
    int ProductBoxIndex=0;
    final DefaultComboBoxModel men,women,kid,accessory;

    public UpdateProduct()
    {
        men=new DefaultComboBoxModel(MenProduct);
        women=new DefaultComboBoxModel(WomenProduct);
        kid=new DefaultComboBoxModel(KidProduct);
        accessory=new DefaultComboBoxModel(Accessory);
        setLayout(null);
        setTitle("Remove Product Frame");
        setSize(600,1200);
        setLocation(350,0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        RemoveProductLabel=new JLabel("REMOVE PRODUCT");
        RemoveProductLabel.setBounds(210,110,300,25);
        RemoveProductLabel.setBackground(Color.white);
        RemoveProductLabel.setForeground(Color.red);
        RemoveProductLabel.setFont(new Font("monospaced", Font.BOLD, 19));
	add(RemoveProductLabel);
        
        RemoveProductQuote=new JLabel("YOU CAN REMOVE PRODUCT FROM HERE");
        RemoveProductQuote.setBounds(185,145,300,25);
        RemoveProductQuote.setBackground(Color.white);
        RemoveProductQuote.setForeground(Color.BLACK);
        RemoveProductQuote.setFont(new Font("serif", Font.PLAIN, 10));
	add(RemoveProductQuote);
        
        ProductListBox=new JComboBox();
        ProductListBox.setBounds(140,235,300,35);
        ProductListBox.setBackground(Color.white);
        ProductListBox.setForeground(Color.BLACK);
        ProductListBox.setFont(new Font("monospaced", Font.BOLD, 12));
        add(ProductListBox);
        
        ProductBox=new JComboBox(ProductName);
        ProductBox.setBounds(140,190,300,35);
        ProductBox.setBackground(Color.white);
        ProductBox.setForeground(Color.BLACK);
        ProductBox.setFont(new Font("monospaced", Font.BOLD, 12));
        add(ProductBox);
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
            
            
        });
        
        IdFIELD=new JTextField("ProductId");
        IdFIELD.setBounds(140,280,300,35);
        IdFIELD.setBackground(Color.white);
        IdFIELD.setForeground(Color.lightGray);
        IdFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(IdFIELD);
        
        RemoveProductboxLabel=new JLabel(" label 1");
        RemoveProductboxLabel.setBounds(450,190,100,35);
        RemoveProductboxLabel.setBackground(Color.white);
        RemoveProductboxLabel.setForeground(Color.red);
        RemoveProductboxLabel.setFont(new Font("monospaced", Font.BOLD, 12));
	add(RemoveProductboxLabel);
        
        RemoveProductlistLabel=new JLabel(" label 2");
        RemoveProductlistLabel.setBounds(450,235,100,35);
        RemoveProductlistLabel.setBackground(Color.white);
        RemoveProductlistLabel.setForeground(Color.red);
        RemoveProductlistLabel.setFont(new Font("monospaced", Font.BOLD, 12));
	add(RemoveProductlistLabel);
        
        IDLabel=new JLabel(" label 3");
        IDLabel.setBounds(450,280,100,35);
        IDLabel.setBackground(Color.white);
        IDLabel.setForeground(Color.red);
        IDLabel.setFont(new Font("monospaced", Font.BOLD, 12));
	add(IDLabel);
        
       /* RemoveProductLabel4=new JButton("Remove Product");
        RemoveProductLabel4.setBounds(140,320,300,35);
        RemoveProductLabel4.setBackground(Color.red);
        RemoveProductLabel4.setForeground(Color.black);
        RemoveProductLabel4.setFont(new Font("serif", Font.PLAIN, 14));
	add(RemoveProductLabel4);*/
}
  /*  class Handler implements ActionListener
            {

        
        public void actionPerformed(ActionEvent e)
        {   
            boolean flag;
            
            if(e.getSource()==addProduct)
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
                                if(shirtUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                  
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
                                if(jeansUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                    
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
                                if(jacketsUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                    
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
                                if(punjabiUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                    
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
                                if(tshirtUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                    
                                    
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
                                if(sareeUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                 
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
                                if(LehengaUsercheck!=1)
                                {
                                    IDLabel.setText("Already have this id");
                                }
                                else
                                {
                                   
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
                                if(LehengasareeUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                    
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
                                if(kurtaUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                    
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
                                if(anarkaliUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                    
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
                                if(TieUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                   
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
                                if(walletUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                  
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
                                if(clutchUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                
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
                                if(WatchUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                  
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
                                if(bangleUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                   
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
                                if(beltUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                    
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
                                if(earringUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                    
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
                                if(bracletUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                  
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
                                if(TopUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                   
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
                                if(skirtUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                   
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
                                if(BoyjacketUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {   
                                    
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
                                if(girljacketUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                    
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
                                if(kidpantUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                    
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
                                if(kidshirtUsercheck!=1)
                                {
                                    IDLabel.setText("Id not Found");
                                }
                                else
                                {
                                    
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
        }*/
}

    

