package copyFilesGo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import org.apache.commons.io.FileUtils;

class Filewalker {
    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar();
    int Counter = 0;

    public void CopyDirectoryRecursively(Path sourceDir, Path destinationDir) throws IOException {
        bar.setValue(0);
        bar.setBounds(0, 0, 420, 50);
        bar.setStringPainted(true);
        frame.add(bar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        Files.walk(sourceDir).forEach(sourcePath -> {
            try {
                Path targetPath = destinationDir.resolve(sourceDir.relativize(sourcePath));
                System.out.printf("Copying %s to %s%n", sourcePath, targetPath);
                File sourcFile = new File(sourcePath.toString());
                File targetFile = new File(targetPath.toString());
                FileUtils.copyDirectory(sourcFile, targetFile);
                System.out.println(Counter);
                if ((Counter % 10) == 0) {
                    bar.setValue(Counter);

                }
                Counter += 1;
            } catch (IOException e) {
                System.out.format("I/O error: %s%n", e);
                // TODO: handle exception
            }
        });
    }

}

/**
 * main
 */
public class App {

    public static void main(String[] args) {
        Path sourceDir = Paths.get("/Users/dionboles/Documents");
        Path destinationDir = Paths.get(
                "/Users/dionboles/Library/Containers/com.wdc.WDDesktop.WDDesktopFinderSync/Data/volumes/e161eba9-2a6b-4d7c-af87-31f627c83d7f/Dion's My Cloud Home/Coding");
        try {
            Filewalker file_walker = new Filewalker();
            file_walker.CopyDirectoryRecursively(sourceDir, destinationDir);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
