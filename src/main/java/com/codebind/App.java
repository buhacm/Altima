package com.codebind;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class App {


public static void  draw_family_tree(Map<String, ArrayList<String>> Hierarchy, String root, int level)
		{
			if(root!=null &!root.isEmpty())
			{
				for(int i = 0; i<level;i++)
					System.out.print(" ");
		        System.out.println( root);
		}
		if(Hierarchy.get(root)!=null)
		{
	        ArrayList<String>children = Hierarchy.get(root);
	        for (String string : children) {
	        	draw_family_tree(Hierarchy, string,level+3);
			}
	                
	}
	}
public static Map<String,ArrayList<String>> PopuniTablicu(String putanja) throws IOException
{
	Map<String, ArrayList<String>> Hierarchy = new HashMap<String, ArrayList<String>>();

	try (BufferedReader br = new BufferedReader(new FileReader(putanja))) {
	    String line;
	    while ((line = br.readLine()) != null) {
	  	  if (line==null || line.isEmpty())
			    continue;
	  	String[] splited = line.split("\\s+");
		  if (splited.length != 2)
		  {
		    continue;  
		  }
		  String parent = splited[1];
		  ArrayList<String> children;
		  children = Hierarchy.get(parent);
		     if(children == null)
		     {
		     children = new ArrayList<String>();
		    Hierarchy.put(parent, children);
		  
		     }
		     children.add(splited[0]);
	    }
	    }
	return Hierarchy;
}
	public static void main(String[] args) throws FileNotFoundException, IOException
	{

		Map<String, ArrayList<String>> Hierarchy = App.PopuniTablicu("C:\\Users\\buhac\\eclipse-workspace\\maven-demo\\src\\main\\java\\Family.txt");
	
		/*for (String name: Hierarchy.keySet()){
	        String key = name.toString();
	        String value = Hierarchy.get(name).toString();  
	        System.out.println(key + " " + value);  
	} */
		ArrayList<String> roots = new ArrayList<String>();
		
		for (String name: Hierarchy.keySet()){
			int brojac=0;
	        String key = name.toString();
	        for (String name2: Hierarchy.keySet()){
	        ArrayList< String> lista = Hierarchy.get(name2);  

	        for (String string : lista) {
				if(string.compareTo(key)==0)
				{
				
					brojac++;
				}
			}

	        }

	        if(brojac==0)
	        {
	        	roots.add(key);
	        }
	       
	} 

	for (String string : roots) {
		App.draw_family_tree(Hierarchy,string,0);
	}
		
			  
		
			
		}
	}


