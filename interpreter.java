package lab2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
public class interpreter{

	 	static HashMap<String, Integer> hash;
		
		
	 	interpreter(){	
	 	hash = new HashMap<String, Integer>();
	 	}
	 	
	 	public void readFile(String path){
			BufferedReader breader = null;
			 
			try {
	 
				String line;
	 
				breader = new BufferedReader(new FileReader(path));
			
				
				while ((line = breader.readLine()) != null) {
					System.out.println(line);
					String fwd = line;
					//System.out.println(fwd);
					 StringTokenizer tokenizer = new StringTokenizer(line, "\n");
			            while (tokenizer.hasMoreElements()) {
			            	
			            	
			            	String element = tokenizer.nextToken();
			                //System.out.println(element);
			            	  			            
			            		String let = "let";
			            		String print = "print";
			            		String other ;
			                	String[] words = line.split(" ");
			                	int length = words.length;
			                	for (int i = 0; i<length ; i++){
			                		//System.out.println(words[i]);
			                		if(let.compareTo(words[i].toLowerCase()) == 0){
			                			
			                			let(fwd);
			                			break;
			                			}
			                	
			                
			                		else if(print.compareTo(words[i].toLowerCase()) == 0){
			                			print(fwd);
			                			break;
			                			}
	
			                		
			                		else if(words[i].charAt(0) >= 'a' && words[i].charAt(0) <= 'z'){
			                			other(fwd);
			                			break;
			                			}
			                		
			                		else{
			                			throw new IllegalArgumentException("Invalid charcaters in line");
			                			
			                		}
	
			                	
			               
			                }
			            }
				
				}            
			
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (breader != null)breader.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			
	 
		}


private void other(String line) {
			// TODO Auto-generated method stub
	String[] calc = line.split(" ");
	int length = calc.length;
	//System.out.println(length);
	String add = "+";
	String sub = "-";
	String mul = "*";
	String div = "/";
	
	String[] tok = line.split("=");
	String[] tok1 = tok[1].split(" ");
	int length2 = tok1.length;
	//for(int  i = 0; i< length2 ; i++){
	//int ll;
	int result = 0;
	//System.out.println(tok1[1]);
		if(add.compareTo(tok1[1]) == 0){
			
			for(int j = 0; j<length2; j = j+2){
				if(hash.get(tok1[j]) !=null){
					result = result + hash.get(tok1[j]);
					//System.out.println(result);
				}
				else {
					
					result = result + Integer.parseInt(tok1[j]);
					
				}
				
				}
				
		
			hash.put(tok[0].trim(), result);
			
		
			}
	
		if(sub.compareTo(tok1[1]) == 0){
			int results = 0;
			for(int j = 0; j<length2; j = j+2){
				if(hash.get(tok1[j]) !=null){
					results = hash.get(tok1[j]) - results;
					//System.out.println(result);
				}
				else {
					
					results =   hash.get(tok1[j]) - results;
					
				}
				
				}
				
		
			hash.put(tok[0].trim(), results);
			
		
			}
		
if(mul.compareTo(tok1[1]) == 0){
			int result1  = 1;
			for(int j = 0; j<length2; j = j+2){
				if(hash.get(tok1[j]) !=null){
					result1 = result1 * hash.get(tok1[j]);
					//System.out.println(result);
				}
				else {
					
					result1 = result1 * Integer.parseInt(tok1[j]);
					
				}
				
				}
				
		
			hash.put(tok[0].trim(), result1);
			
		
			}

if(div.compareTo(tok1[1]) == 0){
	int result2 = 1;
	for(int j = 0; j<length2; j = j+2){
		if(hash.get(tok1[j]) !=null){
			result2 =  hash.get(tok1[j])/result2;
			//System.out.println(result);
		}
		else {
			
			result2 = Integer.parseInt(tok1[j])/result2 ;
			
		}
		
		}
		

	hash.put(tok[0].trim(), result2);
	

	}


		
		
		
		
		
		
		
	}
	
		
		


private void print(String line) {
			// TODO Auto-generated method stub
			
	String[] printArray = line.split(" ");
	int value1 = hash.get(printArray[1]);
	System.out.println(value1);
	
		}


private void let(String line) {
			// TODO Auto-generated method stub
	//System.out.println(line);
	String[] letArray = line.split(" ");
	
	int value = Integer.parseInt(letArray[3]);
			//System.out.println(y);
			hash.put(letArray[1].trim(), value);
			String key = letArray[1];
			//int value1 = hash.get("x");
			
			 System.out.println(key + " " + value);

}

}
