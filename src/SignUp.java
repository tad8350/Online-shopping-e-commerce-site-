/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

/**
 *
 * @author user
 */
public class SignUp  extends JFrame
{
    JLabel signup,idonthaveanaccount,SIGINGAGREEMENT,passwordLabel,confirmpasswordLabel,maleLabel,signupLabel,FirstNameLabel,LASTNameLabel,EMAILADDRESSLabel,PHONENUMBERLabel,UserNameLabel,CountryLabel,ShoppersstopPicture;
    JTextField FirstNameFIELD,LASTNameFIELD,EMAILADDRESSFIELD,PHONENUMBERFIELD,PHONENUMBER,USERNameFIELD;
    JPasswordField confirmpassword,password ;
    JButton signupBUTTON;
    JRadioButton female,male;
    ButtonGroup Group1;
    JComboBox Country;
    String [] CountryName={"Select country","Australia","Bangladesh","Canada","China","Germany","India","Japan","Singapur","UK","USA"};
    String [] CountryCode={"...","+61","+088","+1","+86","+49","+91","+81","+65","+44","+1"};
    
    //JPasswordField password;
    int index;
    String Gender="male";
    public SignUp()
    {
        setLayout(null);
        setTitle("SIGNUP Frame");
        setSize(600,1200);
        setLocation(350,0);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon ShoppersstopPictureIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/shoppersstopLogo/shoppersstop.PNG"));
        ShoppersstopPicture=new JLabel(ShoppersstopPictureIcon);
        
        ShoppersstopPicture.setBounds(-425,-200,1430,500);
        ShoppersstopPicture.setBackground(Color.BLUE);
        add(ShoppersstopPicture);
        
        signup=new JLabel("SIGN UP");
        signup.setBounds(250,110,80,25);
        signup.setBackground(Color.white);
        signup.setForeground(Color.BLACK);
        signup.setFont(new Font("monospaced", Font.BOLD, 19));
	add(signup);
        
        idonthaveanaccount=new JLabel("I DON'T HAVE AN ACCOUNT");
        idonthaveanaccount.setBounds(220,145,140,25);
        idonthaveanaccount.setBackground(Color.white);
        idonthaveanaccount.setForeground(Color.BLACK);
        idonthaveanaccount.setFont(new Font("serif", Font.PLAIN, 10));
	add(idonthaveanaccount);
        
         FirstNameFIELD=new JTextField("First name*");
        FirstNameFIELD.setBounds(140,190,300,35);
        FirstNameFIELD.setBackground(Color.white);
        FirstNameFIELD.setForeground(Color.black);
        FirstNameFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(FirstNameFIELD);
        
        LASTNameFIELD=new JTextField("Last name*");
        LASTNameFIELD.setBounds(140,235,300,35);
        LASTNameFIELD.setBackground(Color.white);
        LASTNameFIELD.setForeground(Color.black);
        LASTNameFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(LASTNameFIELD);
        
        USERNameFIELD=new JTextField("User name*");
        USERNameFIELD.setBounds(140,280,300,35);
        USERNameFIELD.setBackground(Color.white);
        USERNameFIELD.setForeground(Color.black);
        USERNameFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(USERNameFIELD);
        
        EMAILADDRESSFIELD=new JTextField("Enter your email address*");
        EMAILADDRESSFIELD.setBounds(140,325,300,35);
        EMAILADDRESSFIELD.setBackground(Color.white);
        EMAILADDRESSFIELD.setForeground(Color.black);
        EMAILADDRESSFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(EMAILADDRESSFIELD);
        
        JComboBox Country=new JComboBox(CountryName);
        Country.setBounds(140,370,300,35);
        Country.setBackground(Color.white);
        Country.setForeground(Color.BLACK);
        Country.setFont(new Font("monospaced", Font.BOLD, 12));
        add(Country);
        
        PHONENUMBERFIELD=new JTextField("...");
        PHONENUMBERFIELD.setBounds(140,415,50,35);
        PHONENUMBERFIELD.setBackground(Color.white);
        PHONENUMBERFIELD.setForeground(Color.black);
        PHONENUMBERFIELD.setEditable(false);
        PHONENUMBERFIELD.setFont(new Font("monospaced", Font.BOLD, 12));
        add(PHONENUMBERFIELD);
        
        PHONENUMBER=new JTextField("Mobile number*");
        PHONENUMBER.setBounds(195,415,245,35);
        PHONENUMBER.setBackground(Color.white);
        PHONENUMBER.setForeground(Color.black);
        PHONENUMBER.setFont(new Font("monospaced", Font.BOLD, 12));
        add(PHONENUMBER);
        
        password=new JPasswordField("password");
        password.setBounds(140,460,300,35);
        password.setBackground(Color.white);
        password.setForeground(Color.lightGray);
        add(password);
        
        confirmpassword=new JPasswordField("Confirm password*");
        confirmpassword.setBounds(140,505,300,35);
        confirmpassword.setBackground(Color.white);
        confirmpassword.setForeground(Color.lightGray);
        add(confirmpassword);
        
        
        
        male=new JRadioButton("Male",true);
        male.setBounds(140,550,100,25);
        male.setBackground(Color.white);
        male.setForeground(Color.BLACK);
        male.setFont(new Font("monospaced", Font.BOLD, 12));
	add(male);
        
        female=new JRadioButton("Female",false);
        female.setBounds(300,550,80,25);
        female.setBackground(Color.white);
        female.setForeground(Color.BLACK);
        female.setFont(new Font("monospaced", Font.BOLD, 12));
	add(female);
        Group1=new ButtonGroup();
        Group1.add(male);
        Group1.add(female);
        male.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent we)
            {
                if(we.getSource()==male)
                {
                    Gender="male";
                }
            }
            
        }
        );
        female.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent we)
            {
                if(we.getSource()==female)
                {
                    Gender="female";
                }
            }
            
        }
        );
        
        
        
        signupBUTTON=new JButton("SIGN UP");
        signupBUTTON.setBounds(140,585,300,35);
        signupBUTTON.setBackground(Color.RED);
        signupBUTTON.setForeground(Color.white);
        signupBUTTON.setFont(new Font("SERIF", Font.BOLD, 14));
        add(signupBUTTON);
        signupBUTTON.addActionListener(new CongratulationAction());
                
        SIGINGAGREEMENT=new JLabel("By siging up you agree to our Terms Of Service & Privacy Policy");
        SIGINGAGREEMENT.setBounds(138,630,330,35);
        SIGINGAGREEMENT.setBackground(Color.white);
        SIGINGAGREEMENT.setForeground(Color.darkGray);
        SIGINGAGREEMENT.setFont(new Font("arial", Font.PLAIN, 10));
	add(SIGINGAGREEMENT);
        
        Country.addItemListener(new ItemListener()
        {
           
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED)
                {
                    PHONENUMBERFIELD.setText(CountryCode[Country.getSelectedIndex()]);
                    index=Country.getSelectedIndex();
                }
            }
        }
        );
        
        FirstNameLabel=new JLabel("first");
        FirstNameLabel.setBounds(450,190,150,35);
        FirstNameLabel.setBackground(Color.white);
        FirstNameLabel.setForeground(Color.red);
        FirstNameLabel.setFont(new Font("monospaced", Font.BOLD, 14));
	add(FirstNameLabel);
        
        
        LASTNameLabel=new JLabel("last");
        LASTNameLabel.setBounds(450,235,150,35);
        LASTNameLabel.setBackground(Color.white);
        LASTNameLabel.setForeground(Color.red);
        LASTNameLabel.setFont(new Font("monospaced", Font.BOLD, 14));
	add(LASTNameLabel);
        
        UserNameLabel=new JLabel("user");
        UserNameLabel.setBounds(450,280,150,35);
        UserNameLabel.setBackground(Color.white);
        UserNameLabel.setForeground(Color.red);
        UserNameLabel.setFont(new Font("monospaced", Font.BOLD, 14));
	add(UserNameLabel);
        
        EMAILADDRESSLabel=new JLabel("email");
        EMAILADDRESSLabel.setBounds(450,325,160,35);
        EMAILADDRESSLabel.setBackground(Color.white);
        EMAILADDRESSLabel.setForeground(Color.red);
        EMAILADDRESSLabel.setFont(new Font("monospaced", Font.BOLD, 14));
        add(EMAILADDRESSLabel);
        
        CountryLabel=new JLabel("select country"); 
        CountryLabel.setBounds(450,370,300,35);
        CountryLabel.setBackground(Color.white);
        CountryLabel.setForeground(Color.red);
        CountryLabel.setFont(new Font("monospaced", Font.BOLD, 14));
        add(CountryLabel);
        
                
        PHONENUMBERLabel=new JLabel("phone");
        PHONENUMBERLabel.setBounds(450,415,150,35);
        PHONENUMBERLabel.setBackground(Color.white);
        PHONENUMBERLabel.setForeground(Color.red);
        PHONENUMBERLabel.setFont(new Font("monospaced", Font.BOLD, 14));
        add(PHONENUMBERLabel);
        
        passwordLabel=new JLabel("8 characters!!");
        passwordLabel.setBounds(450,460,150,35);
        passwordLabel.setBackground(Color.white);
        passwordLabel.setForeground(Color.red);
        passwordLabel.setFont(new Font("serif", Font.PLAIN, 14));
        add(passwordLabel);
        
        confirmpasswordLabel=new JLabel("confirm");
        confirmpasswordLabel.setBounds(450,505,150,35);
        confirmpasswordLabel.setBackground(Color.white);
        confirmpasswordLabel.setForeground(Color.red);
        confirmpasswordLabel.setFont(new Font("monospaced", Font.BOLD, 12));
        add(confirmpasswordLabel);

        
        signupLabel=new JLabel("");
        signupLabel.setBounds(450,505,150,35);
        signupLabel.setBackground(Color.white);
        signupLabel.setForeground(Color.red);
        signupLabel.setFont(new Font("monospaced", Font.BOLD, 12));
	add(signupLabel);
              
    }
        class CongratulationAction implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {  
                boolean flag=true;
                int emailcheck,wrongEmail,userCheck,checkuser;
                 emailcheck=-1;
                 wrongEmail=-1;
                 checkuser=-1;
                 
              if(e.getSource()==signupBUTTON)
              {
                  
                  if(FirstNameFIELD.getText().equals("")==true || FirstNameFIELD.getText().equals("First name*")==true)
                  {
                      FirstNameLabel.setText("Required!!!");
                      FirstNameLabel.setForeground(Color.RED);
                      flag=false;
                  }
                  else
                  {
                      FirstNameLabel.setText("");
                      FirstNameLabel.setForeground(Color.GREEN);
                      
                  }
                   if(LASTNameFIELD.getText().equals("")==true || LASTNameFIELD.getText().equals("Last name*")==true)
                  {
                      LASTNameLabel.setText("Required!!!");
                      LASTNameLabel.setForeground(Color.RED);
                      flag=false;
                  }
                  else
                  {
                      LASTNameLabel.setText("");
                      LASTNameLabel.setForeground(Color.GREEN);
                      
                  }
                   if(EMAILADDRESSFIELD.getText().equals("")==true || EMAILADDRESSFIELD.getText().equals("Enter your email address*")==true)
                  {
                      EMAILADDRESSLabel.setText("Required!!!");
                      EMAILADDRESSLabel.setForeground(Color.RED);
                      flag=false;
                  }
                  else
                  {
                      
                      String email="SELECT `EmailAddress` FROM `person`";
                      ResultSet rsemail;
                      DBConnector com=new DBConnector();
                      rsemail=com.setData(email);
                      try {
                          while(rsemail.next())
                          {
                              if(rsemail.getString("EmailAddress").equals(EMAILADDRESSFIELD.getText()))
                              {
                                  emailcheck=1;
                                  flag=false;
                                  System.out.println("check");
                                  break;
                              }
                              
                          }
                          if(EMAILADDRESSFIELD.getText().indexOf("@")<0 || EMAILADDRESSFIELD.getText().indexOf(".com")<0 )
                          {
                              
                              wrongEmail=1;
                              
                          }
                          
                          
                          if(emailcheck==1  )
                          {
                              EMAILADDRESSLabel.setText("You already created an account");
                              EMAILADDRESSLabel.setForeground(Color.RED);
                              flag=false;
                          }
                          else if(wrongEmail==1)
                          {
                              EMAILADDRESSLabel.setText("Required @ or .com!!!");
                              EMAILADDRESSLabel.setForeground(Color.RED);
                              flag=false;
                          }
                          else
                          {
                              EMAILADDRESSLabel.setText("Accepted");
                              EMAILADDRESSLabel.setForeground(Color.GREEN);
                          }
                          
                          
                      } catch (SQLException ex) {
                          System.out.println("Error is:"+ex);
                      }
                
                      
                  }
                   if(PHONENUMBER.getText().equals("")==true || PHONENUMBER.getText().equals("Mobile number*")==true)
                  {
                      PHONENUMBERLabel.setText("Required!!!");
                      PHONENUMBERLabel.setForeground(Color.RED);
                      flag=false;
                  }
                  else
                  {
                      PHONENUMBERLabel.setText("");
                      PHONENUMBERLabel.setForeground(Color.GREEN);
                      
                  }
                   if(password.getText().equals("")==true || password.getText().equals("password")==true)
                  {
                      passwordLabel.setText("Required!!!");
                      passwordLabel.setForeground(Color.RED);
                      flag=false;
                  }
                  else
                  {
                      if(password.getText().length()<8)
                      {
                          passwordLabel.setText("Required at least 8 letter!!!");
                          passwordLabel.setForeground(Color.RED);
                          flag=false;
                      }
                      else
                      {
                          passwordLabel.setText("Accepted");
                          passwordLabel.setForeground(Color.GREEN);
                      }
                      
                  }
                    if(USERNameFIELD.getText().equals("")==true || USERNameFIELD.getText().equals("User name*")==true)
                  {
                      UserNameLabel.setText("Required!!!");
                      UserNameLabel.setForeground(Color.RED);
                      flag=false;
                  }
                  else
                  {
                       String user="SELECT `UserName` FROM `person";
                       ResultSet rsuser;
                       DBConnector com=new DBConnector();
                       rsuser=com.setData(user);
                         try
                       {
                           while(rsuser.next())
                           {
                               if(rsuser.getString("UserName").equals(USERNameFIELD.getText()))
                               {
                                   checkuser=1;
                                   flag=false;
                                   System.out.println(rsuser.getString("UserName"));
                                   break;
                              
                                   
                               }
                               
                              
                               //System.out.println(user.getString("UserName"));
                           }
                           if(checkuser==1)
                                   {
                                       UserNameLabel.setText("Username already exist");
                                       UserNameLabel.setForeground(Color.RED);
                                       flag=false;
                                   }
                           else
                           {
                               UserNameLabel.setText("Accepted");
                               UserNameLabel.setForeground(Color.GREEN);
                               
                           }
                       }catch (SQLException ex) {
                          System.out.println("Error is:"+ex);
                      }
                      
                  }
                      if(confirmpassword.getText().equals("")==true || confirmpassword.getText().equals("Confirm password*")==true)
                  {
                      confirmpasswordLabel.setText("Required!!!");
                      confirmpasswordLabel.setForeground(Color.RED);
                      flag=false;
                  }
                  else
                  {
                      if(password.getText().equals(confirmpassword.getText())==false)
                      {
                          confirmpasswordLabel.setText("Not Matched");
                          confirmpasswordLabel.setForeground(Color.RED);
                          flag=false;
                      }
                      else
                      {
                          confirmpasswordLabel.setText(" Matched");
                          confirmpasswordLabel.setForeground(Color.GREEN);
                      }
                  }
                      if(index>0)
                      {
                          System.out.println(CountryName[index]);
                          System.out.println(CountryCode[index]);
                          CountryLabel.setText("Acceptd");
                          CountryLabel.setForeground(Color.GREEN);
                      }
                      else
                      {
                          CountryLabel.setText("no country selected");
                          confirmpasswordLabel.setForeground(Color.red);
                          flag=false;
                          
                      }
                     
                      System.out.println(Gender);
                      if(flag==true)
                      {
                          String rs;
                          rs="INSERT INTO `person` (`UserName`, `FirstName`, `LastName`, `EmailAddress`, `Country`, `PhoneNo`, `Password`, `Gender`, `PersonTypeId`) VALUES ('"+USERNameFIELD.getText()+"', '"+FirstNameFIELD.getText()+"', '"+LASTNameFIELD.getText()+"', '"+EMAILADDRESSFIELD.getText()+"', '"+CountryName[index]+"', '"+CountryCode[index]+PHONENUMBER.getText()+"', '"+password.getText()+"', '"+Gender+"', 0)";
                          System.out.println(rs);
                          DBConnector com=new DBConnector();
                          com.updateData(rs);
                          setVisible(false);
                          Congratulations con=new Congratulations();
                          con.setVisible(true);
                      }
                      else if(flag==false)
                      {
                          System.out.println("Its false");
                      }
                  
              }
              
            }
        }
    
}
