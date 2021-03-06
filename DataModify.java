import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 * @author lingdean
 * The DataModify class is used to modify the data in text files if needed. 
 * It holds the static methods for modifying or deleting specific data in files.
 * 
 */
public class DataModify {

	public static void modifyMoney(String filePath, String username, String accountType, int new_money) {
       
		File file= new File(filePath);
       
		String content = "";
		BufferedReader reader=null;
        FileWriter writer=null;
         
        try
        {
        	reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
             
            while (line != null) 
            {
            	String [] data = line.split(" ");
            	if(data[0].equals(username)) {
            		if(accountType.equals("Saving")) {
            			data[3] = String.valueOf(new_money);
            		}
            		else {
            			data[5] = String.valueOf(new_money);
            		}
            	}
            	String new_line = String.join(" ", data);
                content = content + new_line + System.lineSeparator();
                line = reader.readLine();
            }
 
           writer = new FileWriter(file);
           writer.write(content);
            
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try{
                reader.close();  
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
	
	public static void modifyLoan(String filePath, String username, int loan_money) {
		File file= new File(filePath);
	       
		String content = "";
		BufferedReader reader=null;
        FileWriter writer=null;
         
        try
        {
        	reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
             
            while (line != null) 
            {
            	String [] data = line.split(" ");
            	if(data[0].equals(username)) {
            		data[7]=String.valueOf(loan_money);
            	}
            	String new_line = String.join(" ", data);
                content = content + new_line + System.lineSeparator();
                line = reader.readLine();
            }
 
           writer = new FileWriter(file);
           writer.write(content);
            
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try{
                reader.close();  
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
	}
	
	public static void modifyLoanCurrency(String filePath, String username, String currency) {
		File file= new File(filePath);
	       
		String content = "";
		BufferedReader reader=null;
        FileWriter writer=null;
         
        try
        {
        	reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
             
            while (line != null) 
            {
            	String [] data = line.split(" ");
            	if(data[0].equals(username)) {
            		data[8]=currency;
            	}
            	String new_line = String.join(" ", data);
                content = content + new_line + System.lineSeparator();
                line = reader.readLine();
            }
 
           writer = new FileWriter(file);
           writer.write(content);
            
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try{
                reader.close();  
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
	}
	
	public static void modifyLoanDate(String filePath, String username, String date) {
		File file= new File(filePath);
	       
		String content = "";
		BufferedReader reader=null;
        FileWriter writer=null;
         
        try
        {
        	reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
             
            while (line != null) 
            {
            	String [] data = line.split(" ");
            	if(data[0].equals(username)) {
            		data[9]=date;
            	}
            	String new_line = String.join(" ", data);
                content = content + new_line + System.lineSeparator();
                line = reader.readLine();
            }
 
           writer = new FileWriter(file);
           writer.write(content);
            
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try{
                reader.close();  
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
	}
	
	public static void modifyBankMoney(String filePath, String currency, int money) {
		File file= new File(filePath);
	       
		String content = "";
		BufferedReader reader=null;
        FileWriter writer=null;
         
        try
        {
        	reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
             
            while (line != null) 
            {
            	String [] data = line.split(" ");
            	if(data[1].equals(currency)) {
            		data[0]=String.valueOf(money);
            	}
            	String new_line = String.join(" ", data);
                content = content + new_line + System.lineSeparator();
                line = reader.readLine();
            }
 
           writer = new FileWriter(file);
           writer.write(content);
            
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try{
                reader.close();  
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
	}
	
	public static void DeleteUser(String filePath, String username) {
	       
		File file= new File(filePath);
       
		String content = "";
		BufferedReader reader=null;
        FileWriter writer=null;
         
        try
        {
        	reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
             
            while (line != null) 
            {
            	String [] data = line.split(" ");
            	if(data[0].equals(username)) {
            		line = reader.readLine();
            		continue;
            	}
            	String new_line = String.join(" ", data);
                content = content + new_line + System.lineSeparator();
                line = reader.readLine();
            }
 
           writer = new FileWriter(file);
           writer.write(content);
            
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try{
                reader.close();  
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
	
}
