/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author user
 */

class corporateSite extends JFrame
{
    JLabel TermsOfUsePic;
   public corporateSite()
        {
        setTitle("Corporate Site");
        setSize(1140,550);
        setLocation(120,120);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
            ImageIcon GentleIcon1=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/lowerpanel textfiles/corporate sites.PNG"));
            TermsOfUsePic=new JLabel(GentleIcon1);
            TermsOfUsePic.setBounds(0,-100,800,1200);
            TermsOfUsePic.setBackground(Color.BLUE);
            add(TermsOfUsePic);
       
	}

      

    }


