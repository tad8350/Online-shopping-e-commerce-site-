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

class TermsOfUseFrame extends JFrame
{
    JLabel TermsOfUsePic;
   public TermsOfUseFrame()
        {
        setTitle("Terms Of Use");
        setSize(1140,550);
        setLocation(120,120);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
            ImageIcon GentleIcon=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/lowerpanel textfiles/terms& policies.PNG"));
            TermsOfUsePic=new JLabel(GentleIcon);
            TermsOfUsePic.setBounds(0,-5,800,1200);
            TermsOfUsePic.setBackground(Color.BLUE);
            add(TermsOfUsePic);
       
	}

      

    }


