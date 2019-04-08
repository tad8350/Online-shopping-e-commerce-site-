/*
 * To change thi license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
/**
 *
 * @author Projna
 */
class MyFrame extends JFrame
{   
    UperPanel uPane;
    CenterPanel cPane;
    LowerPanel1 lPane1;
    LowerPanel2 lPane2;
    JPanel ContentPane;
    JScrollPane Scroll;
    static boolean flag;
    static String user;
    
    
        public MyFrame() 
            {
                setLayout(null);
                setTitle("Shoppers Stop");
                setSize(1500,1500);
                setExtendedState(MyFrame.MAXIMIZED_BOTH);                                                              
                setTitle("Shoppers Stop");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //setSize(800,600);
             
                 uPane=new UperPanel();
                 setJMenuBar(uPane.menuBar);
                
                 cPane=new CenterPanel();
                
                /*cPane.setBounds(0,160,1500,400);
                add(cPane);*/
                Scroll=new JScrollPane(cPane);
                Scroll.setBounds(0,160,1366,400);
                cPane.setPreferredSize(new Dimension(1500,800));
                Scroll.setViewportView(cPane);
                Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                ContentPane=new JPanel(null);
                ContentPane.setBounds(0, 160, 1500, 400);
                ContentPane.add(Scroll);
                setContentPane(ContentPane);
                add(uPane);
                
                lPane1=new LowerPanel1();
                lPane1.setBounds(0,560,1500,60);
                add(lPane1);
                lPane2=new LowerPanel2();
                lPane2.setBounds(0,620,1500,62);
                add(lPane2);
                
                
                uPane.Men.addActionListener(new Handler());
                uPane.Women.addActionListener(new Handler());
                uPane.Accessories.addActionListener(new Handler());
                uPane.Child.addActionListener(new Handler());
                uPane.JustIn.addActionListener(new Handler());
                uPane.User.addActionListener(new Handler());
                uPane.WinterSale.addActionListener(new Handler());
                lPane2.Subscribe.addActionListener(new Handler());
                lPane2.TermOfUse.addActionListener(new Handler());
               
               
             
                
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
                {
                    if(UperPanel.flag==false)
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
                 else if(a.getSource()==lPane2.Subscribe)
                 {
                     SubscribeFrame sub=new SubscribeFrame();
                     setVisible(true);
                 }
                if(a.getSource()==uPane.HomeIcon)
              {
                 
                  uPane.HomeIcon.setBackground(Color.red);
                 
                  
              }
                else if(a.getSource()==lPane2.TermOfUse)
                {
                    TermsOfUseFrame Text1=new TermsOfUseFrame();
                    Text1.setVisible(true);
                    
                }
                
             
                

        }
 }

}
              
              
   


 
   
    
               
    
    

  

public class shoppersstoponlineshop
{
      public static void main(String[] args) 
      {
          
          MyFrame a=new MyFrame();
          //a.setContentPane(new ScrollBar());
          
          a.setVisible(true);
          a.setResizable(true);
          
          
          
    }

  
}


    

