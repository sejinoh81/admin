package admin.emart.com.util;

import java.io.File;
import java.util.ArrayList;

public class FileSearch {
	
	public static void main(String[] args) { 
          File f= new File("D:\\"); 
          ArrayList<File> subFiles= new ArrayList<File>(); 
           
          if(!f.exists()) 
          { 
             System.out.println("no dir..."); 
             return; 
          } 
           
          findSubFiles(f, subFiles); 
           
          System.out.println("-----------------------------------------"); 
           
          for(File file : subFiles) {
              if(file.isFile()) { 
                  System.out.println("파일 이름 : "+file.getName()); 
                  try{ 
                      System.out.println("파일 경로 : "+file.getCanonicalPath()); 
                  }catch(Exception e){ 
                      e.printStackTrace(); 
                  } 
                  System.out.println("파일 크기 : "+file.length()); 
                  System.out.println("-----------------------------------------"); 
              } 
              else if(file.isDirectory()) 
              { 
                  System.out.println("디렉토리 이름 : "+file.getName()); 
                  try{ 
                      System.out.println("디렉토리 경로 : "+file.getCanonicalPath()); 
                  }catch(Exception e){ 
                      e.printStackTrace(); 
                  } 
                  System.out.println("-----------------------------------------"); 
              } 
          } 
      }

	public static void findSubFiles(File parentFile, ArrayList<File> subFiles) {
		if (parentFile.isFile()) {
			if("sql".equals(parentFile.getName().substring(parentFile.getName().lastIndexOf(".") + 1))) {
				subFiles.add(parentFile);
			}
			
		} else if (parentFile.isDirectory()) {
			subFiles.add(parentFile);
			File[] childFiles = parentFile.listFiles();
			
			for (File childFile : childFiles) {
				findSubFiles(childFile, subFiles);
			}
		}
	}
}
