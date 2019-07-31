/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fw;
import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class FW {

    
    public  static boolean createFile()
    {
        try{
         File f=new File("FreshWorks.JSON");
         if(f.createNewFile())
         {
         System.out.println("File created");
 
         return true;
         }
        }
        catch(Exception e)
        {
            System.out.println("File not created");
            return false;
    }
        return true;
    }
private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
public static String randomAlphaNumeric(int count) {
StringBuilder builder = new StringBuilder();
while (count-- != 0) {
int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
builder.append(ALPHA_NUMERIC_STRING.charAt(character));
}
return builder.toString();
}
public static void createData()
{
    
        HashMap<String, Object> hm = new HashMap<String, Object>();
         hm.put(randomAlphaNumeric(32), "{1}");
         hm.put(randomAlphaNumeric(32), "{2}");
         hm.put(randomAlphaNumeric(32), "{3}");
         Set set = hm.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
         System.out.println(mentry.getValue());
      }
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter key");
      
      String key=sc.nextLine();
      Object var= hm.get(key);
      System.out.println("Value of the key: "+var);
      
      System.out.println("Enter the key to be removed");
      key=sc.nextLine();
      hm.remove(key);
      System.out.println("Map key and values after removal:");
      Set set2 = hm.entrySet();
      Iterator iterator2 = set2.iterator();
      while(iterator2.hasNext()) {
          Map.Entry mentry2 = (Map.Entry)iterator2.next();
          System.out.print("Key is: "+mentry2.getKey() + " & Value is: ");
          System.out.println(mentry2.getValue());
       }
      JSONObject json = new JSONObject();
      json.putAll( hm);
 



       
         
        //Write JSON file
        try (FileWriter file = new FileWriter("FreshWorks.json")) {
 
            file.write(json.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
 

}
public static void readData()
{
    JSONParser jsonParser = new JSONParser();
         try
         {
        FileReader reader = new FileReader("FreshWorks.json");
    
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            System.out.println(obj);
                 
 
 
            
             
            //Iterate over array
           
         }
         
         catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        } catch (ParseException e) {
            System.out.println("PARSE EXCEPTION");
        }
 
}
    public static void main(String[] args) throws Exception{
        
    int choice,flag=0,count=0;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the choice\n1.create/get/delete data\n2.read\n4.Exit");
    choice = sc.nextInt();
    sc.nextLine();
    while(true){
      switch(choice){
      case 1:
          createData();count++;
          break;
      case 2:
          readData();
          break;
      case 4:
          flag=1;    
    }
  if(flag==1)
		break;
   System.out.println("Enter the choice\n1.create/get/delete data\n2.read\n4.Exit");
   choice = sc.nextInt();
   sc.nextLine();
}
}
}