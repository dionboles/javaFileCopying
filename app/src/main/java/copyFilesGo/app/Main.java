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

class Filewalker {

    public void CopyDirectoryRecursively(String sourceDir, String destinationDir) {

        String sourcePath = sourceDir;
        String targetPath = destinationDir;
        System.out.printf("Copying %s to %s%n", sourcePath, targetPath);
        File sourcFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        try {
            FileUtils.copyDirectory(sourcFile, targetFile, pathname -> {
                if(!pathname.toString().contains("node_modules") || !pathname.toString().contains("bower_components")) {
                    if(!pathname.toString().contains("node_modules") == false) {
                        System.out.println(pathname);
                    }
                    return pathname.canRead();
                }
                return false;
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
    /**
     * main
     */
    public class Main {

        public static void main(String[] args) {
            String sourceDir = Paths.get("/Users/dionboles/Documents").toString();
            String destinationDir = Paths.get(
                    "/Users/dionboles/Library/Containers/com.wdc.WDDesktop.WDDesktopFinderSync/Data/volumes/e161eba9-2a6b-4d7c-af87-31f627c83d7f/Dion's My Cloud Home/Coding").toString();
            try {
                Filewalker file_walker = new Filewalker();
                file_walker.CopyDirectoryRecursively(sourceDir, destinationDir);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }


