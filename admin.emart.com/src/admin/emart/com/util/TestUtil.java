package admin.emart.com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TestUtil {
	
	public static String dirPath	= "D:\\";
	public static String searchTxt = "ST_INV_RANDOM";
//	public static String includeExtension = "txt|java|jsp|js|xml|css|properties|html|";
	public static String includeExtension = "sql|";
	
	public static void main(String[] args) {
		
		TestUtil testUtil = new TestUtil();

		System.out.println("keyword >> " + searchTxt);
		testUtil.fileAllSearch(dirPath);
	}
	
	public void fileAllSearch(String dirPath) {
		
		try {
			File directory = new File(dirPath);
			File[] files = directory.listFiles();
			//System.out.println("now directory ------------ " + dirPath + ", size : " + files.length);
			
			for(File file : files) {
				
				if(file.isFile()) {
					String fileName = file.getName();
					String[] fileExtension = fileName.split("\\.");
					//System.out.println(">>>>>>>>> " + fileExtension[1]);
					
					if(fileExtension.length > 1) {
						if(includeExtension.contains(fileExtension[1] + "|")) {
							//System.out.println("1 >> " + file.getCanonicalPath().toString());
							String result = readFile(file.getCanonicalPath().toString());
							System.out.println("     " + result);
						}
					}
				} else if(file.isDirectory()) {
					//System.out.println(file.isDirectory()  + " : " + file.getName());
					//System.out.println("getCanonicalPath --> " + file.getCanonicalPath().toString());
					if(file.getCanonicalPath() != null && file.exists()) {
						fileAllSearch(file.getCanonicalPath().toString());
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String readFile(String readFile) {
		
		String result = "";
		
        try {
        	File filePath = new File(readFile);
            FileReader filereader = new FileReader(filePath);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null) {
            		if(line.contains(searchTxt)) {
            			//System.out.println(line);
            			result = readFile;
            		}
            }
            bufReader.close();

        }catch (Exception e) {
            System.out.println(e);
        }
        return result;
	}

}
