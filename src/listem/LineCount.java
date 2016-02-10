package listem;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LineCount extends FileProcessor implements ILineCounter {
	
	Map<File, Integer> fileCounts;
	
	public LineCount(){}
	
	@Override
	public Map<File, Integer> countLines(File directory, String fileSelectionPattern, boolean recursive) {
		fileCounts = new TreeMap<File, Integer>();
		processFile(directory, fileSelectionPattern, recursive);
		return fileCounts;
	}

	@Override
	void processInChild(File f) {
		try{
			
			
			int line = 0;
			Scanner s = new Scanner(f);
			while(s.hasNextLine()){
				line++;
				s.nextLine();
			}
			fileCounts.put(f, line);
			s.close();
		}
		catch(IOException e){
			System.out.println("Error");
		}
		
	}
	
}

