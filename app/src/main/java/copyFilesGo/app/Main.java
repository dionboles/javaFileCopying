package copyFilesGo.app;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.print.DocFlavor;
import javax.swing.*;

import org.apache.commons.io.FileUtils;

/**
Description of class
**/
class Filewalker {

    /**
    Description of method
    @param arg description of parameter
    **/
    public void CopyDirectoryRecursively(String sourcePath, String targetPath) throw Exception {

        System.out.printf("Copying %s to %s%n", sourcePath, targetPath);
        
        File sourcFile = new File(sourcePath);
        File targetFile = new File(targetPath);        

        FileUtils.copyDirectory(sourcFile, targetFile);
    }

}
    /**
     * Description of class
     */
    public class Main {
        
        static Filewalker file_walker = new Filewalker();
        
        /**
        Description of method
        @param arg description of parameter
        **/
        public static void main(String[] args) {
            String sourceDir = Paths.get("/Users/dionboles/Documents").toString();
            String destinationDir = Paths.get(
                    "/Users/dionboles/Library/Containers/com.wdc.WDDesktop.WDDesktopFinderSync/Data/volumes/e161eba9-2a6b-4d7c-af87-31f627c83d7f/Dion's My Cloud Home/Coding").toString();
            try {
                //Filewalker file_walker = new Filewalker();
                Main.file_walker.CopyDirectoryRecursively(sourceDir, destinationDir);
                
                //Catch all exception here
            } catch (Exception e) {
                System.out.println("Exception: " + e.message(), e);
            }
        }
    }


