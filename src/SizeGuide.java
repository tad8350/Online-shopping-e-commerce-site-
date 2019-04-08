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

class SizeGuide extends JFrame
{
    JLabel SizeGuide;
     JScrollPane Scroll;
   public SizeGuide()
        {
        setTitle("Size Guide");
        setSize(600,550);
        setLocation(380,120);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
            ImageIcon GentleIcon1=new ImageIcon(getClass().getResource("/shoppersstoponlineshop/lowerpanel textfiles/nike_size_guide.PNG"));
            SizeGuide=new JLabel(GentleIcon1);
            SizeGuide.setBounds(-500,-500,800,0);
            SizeGuide.setBackground(Color.BLUE);
            add(SizeGuide);
       
	}

      

    }


