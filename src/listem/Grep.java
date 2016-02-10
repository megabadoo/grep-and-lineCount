package listem;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
import java.util.Scanner;

public class Grep extends FileProcessor implements IGrep{

	String SSSPat;
	Map<File, List<String>> fileMatches;
	
	public Grep(){}
	
	@Override
	public Map<File, List<String>> grep(File directory, String fileSelectionPattern, String substringSelectionPattern,
			boolean recursive) {
		SSSPat = substringSelectionPattern;
		fileMatches = new TreeMap<File, List<String>>();
		processFile(directory, fileSelectionPattern, recursive);
		return fileMatches;
	}


	@Override
	void processInChild(File f) {
		try{
	
			Scanner s = new Scanner(f);
			List<String> list = new LinkedList<String>();
			while(s.hasNextLine()){
				String line = s.nextLine();
				if(line.matches(".*" + SSSPat + ".*"))
					list.add(line);
			}
			if(!list.isEmpty())
				fileMatches.put(f, list);
			s.close();
		}
		catch(IOException e){
			System.out.println("Error");
		}
	}
	
}

