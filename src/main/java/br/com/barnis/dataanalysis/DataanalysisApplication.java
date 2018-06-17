package br.com.barnis.dataanalysis;

import br.com.barnis.dataanalysis.config.DirectoryProperties;
import br.com.barnis.dataanalysis.utils.CompanyEnvironmentConfigs;
import br.com.barnis.dataanalysis.utils.CompanyFileProcessor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.FileSystemUtils;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

@SpringBootApplication
public class DataanalysisApplication implements CommandLineRunner {

    @Autowired
    CompanyEnvironmentConfigs environmentConfigs;

    private boolean firstExecution = true;

    public static void main(String[] args) {
        //SpringApplication.run(DataanalysisApplication.class, args);
        SpringApplication app = new SpringApplication(DataanalysisApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    /**
     * {@inheritDoc}
     **/
    @Override
    public void run(String... args) throws Exception {

        if(firstExecution){
            //System.out.println(environmentConfigs.getFullPathRootFilesDirectoryName());
            //System.out.println(environmentConfigs.getFullPathReadFilesDirectory());
            //System.out.println(environmentConfigs.getFullPathWriteFilesDirectory());

            CompanyFileProcessor processor = new CompanyFileProcessor(environmentConfigs);
            processor.processReadDirectoryFiles();
        }else{
            createDirectoryWatcher();
        }




    }

    private void createDirectoryWatcher() throws Exception{

        // get path object pointing to the directory we wish to monitor
        Path path = Paths.get(System.getProperty("user.home") + System.getProperty("file.separator") + "data");

        // get watch service which will monitor the directory
        WatchService watcher;

        while (true) {

            watcher = path.getFileSystem().newWatchService();
            path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
            System.out.println("Monitoring directory for changes...");

            // listen to events

            WatchKey watchKey = watcher.take();
            // get list of events as they occur
            List<WatchEvent<?>> events = watchKey.pollEvents();
            //iterate over events
            for (WatchEvent event : events) {
                //check if the event refers to a new file created
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    //print file name which is newly created
                    System.out.println("Created: " + event.context().toString());
                    String fileName = event.context().toString();
                    if (FilenameUtils.getExtension(fileName).equals("dat")) {
                        System.out.println("Deve processar o arquivo : " + fileName);
                    } else {
                        System.out.println("Não irá processar o arquivo: " + fileName);
                    }
                }
            }
        }
    }
}
