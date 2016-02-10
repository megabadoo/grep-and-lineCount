package listem;

import java.io.File;

abstract public class FileProcessor {
	
	abstract void processInChild(File f);
	
	public void processFile(File directory, String fsp, boolean r){
		
		for(File f: directory.listFiles()) 
			if(f.isDirectory()	&& r)
				processFile(f, fsp, r);
			else if(f.isFile() && f.getName().matches(fsp))
				processInChild(f);	
			
		
	}
	
}

