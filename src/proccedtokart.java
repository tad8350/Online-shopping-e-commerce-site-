/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppersstoponlineshop;

/**
 *
 * @author user
 */
public class proccedtokart 
{
 static String[] Productid=new String[1000];
 static String[] ProductName=new String[1000];
 static Double[] Price=new Double[1000];
 static int[]  Quantity=new int[1000];
 static Double[] TotalPrice=new Double[1000];
 static String[] Table=new String[1000];
 static int[] Available=new int[1000];
 static int Counter=0;
 public proccedtokart()
 {
     
 }
 public proccedtokart(String id,String name,Double price,int quantity,Double total,String table,int av)
 {
     Productid[Counter]=id;
     ProductName[Counter]=name;
     Price[Counter]=price;
     Quantity[Counter]=quantity;      
     TotalPrice[Counter]=total;
     Table[Counter]=table;
     Available[Counter]=av;
     Counter++;
     
 }
 public void see()
 {
     for(int i=0;i<Counter;i++)
     {
         System.out.println(Productid[i]+ProductName[i]+Price[i]+Quantity[i]+TotalPrice[i]+Table[i]);
     }
 }
 
}
