/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
 public class LowerPanel2 extends JPanel
        {
            JButton ExchaneReturn,Help,SizeGuide,AboutUS,CorporateSite;
            Label BlackBackground2,FollowUs,ReachUS,Customer,StoreandSite,PoliciesDescription,AnyQuery,EmailStore;
            JButton ChatIcon,Subscribe,TermOfUse;
            JTextField EmailField;
            public LowerPanel2()
            {
               setSize(1500,60);
               setLayout(null);
               
               
               //adding PoliciesDescription 
                PoliciesDescription=new Label("POLICIES");
                PoliciesDescription.setBounds(348,5,100,13);
                PoliciesDescription.setBackground(Color.black);
                PoliciesDescription.setForeground(Color.white);
                PoliciesDescription.setFont(new Font("arial", Font.BOLD,12));
                add(PoliciesDescription);
                
                //adding PoliciesList "TERMS OF USE"
                TermOfUse=new JButton("TERMS OF USE");
                TermOfUse.setBounds(348,27,140,13);
                TermOfUse.setBackground(Color.black);
                TermOfUse.setForeground(Color.white);
                TermOfUse.setFont(new Font("arial", Font.BOLD,8));
                add(TermOfUse);
                TermOfUse.addActionListener(new TermOfUseAction());
                
                         
                //adding PoliciesList " EXCHANGES & RETURNS "
                ExchaneReturn=new JButton(" EXCHANGES & RETURNS ");
                ExchaneReturn.setBounds(348,40,140,13);
                ExchaneReturn.setBackground(Color.black);
                ExchaneReturn.setForeground(Color.white);
                ExchaneReturn.setFont(new Font("serif", Font.BOLD,8));
                add(ExchaneReturn);
                ExchaneReturn.addActionListener(new ExchaneReturnAction());
                
                //adding PoliciesList " CUSTOMER "
                Customer=new Label(" CUSTOMER ");
                Customer.setBounds(520,5,110,13);
                Customer.setBackground(Color.black);
                Customer.setForeground(Color.white);
                Customer.setFont(new Font("arial", Font.BOLD,12));
                add(Customer);
                
                //adding PoliciesList " HELP/FAQS "
                Help=new JButton(" HELP / FAQS ");
                Help.setBounds(522,27,110,13);
                Help.setBackground(Color.black);
                Help.setForeground(Color.white);
                Help.setFont(new Font("arial", Font.BOLD,8));
                add(Help);
                Help.addActionListener(new FaqsHelpsAction());
                
                //adding PoliciesList " SIZE GUIDE "
                SizeGuide=new JButton(" SIZE GUIDE ");
                SizeGuide.setBounds(522,40,110,13);
                SizeGuide.setBackground(Color.black);
                SizeGuide.setForeground(Color.white);
                SizeGuide.setFont(new Font("arial", Font.BOLD,8));
                add(SizeGuide);
                SizeGuide.addActionListener(new SizeGuideAction());
                
                //adding PoliciesList " STORE AND SITES "
                StoreandSite=new Label(" STORE AND SITES ");
                StoreandSite.setBounds(675,5,110,13);
                StoreandSite.setBackground(Color.black);
                StoreandSite.setForeground(Color.white);
                StoreandSite.setFont(new Font("arial", Font.BOLD,12));
                add(StoreandSite);
                                                        
                //adding PoliciesList " ABOUT US "
                AboutUS=new JButton(" ABOUT US ");
                AboutUS.setBounds(677,27,110,13);
                AboutUS.setBackground(Color.black);
                AboutUS.setForeground(Color.white);
                AboutUS.setFont(new Font("arial", Font.BOLD,8));
                add(AboutUS);
                AboutUS.addActionListener(new aboutUsAction());
                
                //adding PoliciesList " CORPORATE SITE "
                CorporateSite=new JButton(" CORPORATE SITE ");
                CorporateSite.setBounds(677,40,110,13);
                CorporateSite.setBackground(Color.black);
                CorporateSite.setForeground(Color.white);
                CorporateSite.setFont(new Font("arial", Font.BOLD,8));
                add(CorporateSite);
                CorporateSite.addActionListener(new corporateSiteAction());
                
                //adding PoliciesList " REACH US "
                ReachUS=new Label(" REACH US ");
                ReachUS.setBounds(847,5,110,13);
                ReachUS.setBackground(Color.black);
                ReachUS.setForeground(Color.white);
                ReachUS.setFont(new Font("arial", Font.BOLD,12));
                add(ReachUS);
                
                //adding PoliciesList "FOR ANY QUERY PLEASE EMAIL US "
                AnyQuery=new Label(" FOR ANY QUERY PLEASE EMAIL US ");
                AnyQuery.setBounds(847,27,150,13);
                AnyQuery.setBackground(Color.black);
                AnyQuery.setForeground(Color.white);
                AnyQuery.setFont(new Font("arial", Font.BOLD,8));
                add(AnyQuery);
                
                //adding PoliciesList "estore@shoppersstop.com "
                EmailStore=new Label(" estore@shoppersstop.com ");
                EmailStore.setBounds(847,40,150,13);
                EmailStore.setBackground(Color.black);
                EmailStore.setForeground(Color.white);
                EmailStore.setFont(new Font("arial", Font.BOLD,9));
                add(EmailStore);
                
                //adding PoliciesList "FOLLOW US "
                FollowUs=new Label(" FOLLOW US ");
                FollowUs.setBounds(1017,5,100,13);
                FollowUs.setBackground(Color.black);
                FollowUs.setForeground(Color.white);
                FollowUs.setFont(new Font("arial", Font.BOLD,12));
                add(FollowUs);
                
                //adding FacebookIcon icon
                ImageIcon FacebookIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/facebook (2).png"));
                JLabel Facebook = new JLabel(FacebookIcon);
                Facebook.setBounds(1022,17,16,16);
                add(Facebook);
                
                //adding instagram icon
                ImageIcon instagramIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/instagram.png"));
                JLabel instagram = new JLabel(instagramIcon);
                instagram.setBounds(1047,17,16,16);
                add(instagram);
                
                //adding twitter icon
                ImageIcon twitterIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/twitter.png"));
                JLabel twitter = new JLabel(twitterIcon);
                twitter.setBounds(1073,17,16,16);
                add(twitter);
                
                //adding google-plus icon
                ImageIcon googleplusIcon = new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/google-plus.png"));
                JLabel googleplus = new JLabel(googleplusIcon);
                googleplus.setBounds(1099,17,16,16);
                add(googleplus);
                
                /*//chating icon button
                ChatIcon=new JButton("Chat With Us");
                ChatIcon.setBounds(1200,17,140,30);
                ChatIcon.setIcon(new ImageIcon(getClass().getResource("/shoppersstoponlineshop/project icons/speech-bubbles-comment-option.png")));
                ChatIcon.setBackground(Color.BLACK);
                ChatIcon.setForeground(Color.WHITE);
                add(ChatIcon);*/
                
                //adding Subscribe button
                Subscribe=new JButton("SUBSCRIBE");
                Subscribe.setBounds(210,17,100,30);
                Subscribe.setBackground(Color.red);
                Subscribe.setForeground(Color.white);
                Subscribe.setFont(new Font("Calibri", Font.BOLD, 12));
                add(Subscribe);
                Subscribe.addActionListener(new SubscribeAction());
                
                //adding EmailField at TextField
                EmailField=new JTextField(" Enter Your Email ID");
		EmailField.setBounds(10,17,200,30);
                EmailField.setBackground(Color.white);
                EmailField.setForeground(Color.gray);
                EmailField.setFont(new Font("Arial", Font.BOLD, 12));
                add(EmailField);
                
                                  
                //adding BlackBackground2 label at the end
                BlackBackground2=new Label("   ");
                BlackBackground2.setBounds(0,0,1500,62);
                BlackBackground2.setBackground(Color.black);
                add(BlackBackground2);
               
            }
            
         class SubscribeAction implements ActionListener
        {
            public void actionPerformed(ActionEvent we)
            {
              if(we.getSource()==Subscribe)
              {
                  if(EmailField.getText().equals(" Enter Your Email ID") || EmailField.getText().equals(""))
                  {
                      JOptionPane.showMessageDialog(null, "Insert a valid email address");
                  }
                  else
                  {
                  SubscribeFrame sub=new SubscribeFrame();
                  setVisible(true);
                  sub.setVisible(true);
                  }
              }
            }
        }
           class TermOfUseAction implements ActionListener
        {
            public void actionPerformed(ActionEvent we)
            {
              if(we.getSource()==TermOfUse)
              {
                  TermsOfUseFrame term=new TermsOfUseFrame();
                  setVisible(true);
                  term.setVisible(true);
                  term.dispose();
              }
            }
        }
            class aboutUsAction implements ActionListener
        {
            public void actionPerformed(ActionEvent we)
            {
              if(we.getSource()==AboutUS)
              {
                  aboutUs us=new aboutUs();
                  setVisible(true);
                  us.setVisible(true);
              }
            }
        }
             class corporateSiteAction implements ActionListener
        {
            public void actionPerformed(ActionEvent we)
            {
              if(we.getSource()==CorporateSite)
              {
                  corporateSite site=new corporateSite();
                  setVisible(true);
                  site.setVisible(true);
              }
            }
        }
              class ExchaneReturnAction implements ActionListener
        {
            public void actionPerformed(ActionEvent we)
            {
              if(we.getSource()==ExchaneReturn)
              {
                  exchangeAndReturn site=new exchangeAndReturn();
                  setVisible(true);
                  site.setVisible(true);
              }
            }
        }
              class FaqsHelpsAction implements ActionListener
        {
            public void actionPerformed(ActionEvent we)
            {
              if(we.getSource()==Help)
              {
                  FaqsHelps site=new FaqsHelps();
                  setVisible(true);
                  site.setVisible(true);
              }
            }
        }
              class SizeGuideAction implements ActionListener
        {
            public void actionPerformed(ActionEvent we)
            {
              if(we.getSource()==SizeGuide)
              {
                  SizeGuide site=new SizeGuide();
                  setVisible(true);
                  site.setVisible(true);
              }
            }
        }
        }

