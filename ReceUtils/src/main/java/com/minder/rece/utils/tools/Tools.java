package com.minder.rece.utils.tools;

import java.io.File;

public class Tools {
	public static void deleteFile(File tempFile) {
        try
        {
            if(tempFile.isDirectory()){
               File[] entries = tempFile.listFiles();
               for(File currentFile: entries){
            	   deleteFile(currentFile);
               }
               tempFile.delete();
            }else{
               tempFile.delete();
            }
        }
        catch(Throwable t)
        {
        }
    }
}
