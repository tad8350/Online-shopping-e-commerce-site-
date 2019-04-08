/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnector {
    
    Connection con;
    Statement stat;
    ResultSet rs;
    public DBConnector()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppersstop","root", "");
            
        }
        catch(Exception e)
        {
            System.out.println("Error is:"+e);
        }
    }
    public ResultSet setData(String q)
    {   try{
        String sql;
        sql=q;
        stat=con.createStatement();
        rs=stat.executeQuery(sql);
       
        }catch(Exception e)
        {
             System.out.println("Error is "+e);
        }
    
       return rs;
    }
    public void updateData(String q)
    {   
       
        try{
        
        String sql;
        sql=q;
        stat=con.createStatement();
        stat.executeUpdate(sql);
    }catch(Exception e)
    {
        System.out.println("Error is "+e);
    }
    }
    
}
