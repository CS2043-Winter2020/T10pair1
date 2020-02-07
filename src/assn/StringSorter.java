
package assn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StringSorter {

	ArrayList<String> lines = new ArrayList<String>();

	public void read(File rawData) throws FileNotFoundException{
		Scanner in= new Scanner(rawData);
		while(in.hasNextLine()){
			lines.add(in.nextLine());
		}
		in.close();
	}

	public void write(File sortedData) throws FileNotFoundException{
		PrintWriter out = new PrintWriter(sortedData);
		Iterator<String> it =lines.iterator();
		while (it.hasNext()){
			out.println(it.next());
		}
		out.close();
	}

	//This is the raw version which needs to be refactored
	public void sort(){
		//Collections.sort(lines);
		int j = lines.size()-1;
		while (j>0){
			List <String> sublist = lines.subList(0,j+1);
			String str = sublist.get(findLastLine(sublist));

			swap(findLastLine(sublist), j);
		
			
			j = j-1;
		}
		System.out.println("Sort Complete");
	}
	
	public void swap(int primary, int secondary){
		//Method swaps the strings described by their index 
		String primaryString = lines.get(primary);
		String secondaryString = lines.get(secondary);
		lines.set(secondary, primaryString);
		lines.set(primary, secondaryString);
		
	}

	public int findLastLine(List <String> sublist){
		int index = 0;
		String str = sublist.get(index);
		for (int i=0; i<sublist.size(); i++){
			if (str.compareTo(sublist.get(i))<=0){
				index = i;
				str = sublist.get(index);
			}
		}

		return index;

	}

	}
