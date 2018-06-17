package br.com.barnis.dataanalysis;

import br.com.barnis.dataanalysis.utils.CompanyEnvironmentConfigs;
import br.com.barnis.dataanalysis.utils.CompanyFileProcessor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    @Autowired
    CompanyFileProcessor processor;


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DataanalysisApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    /**
     * {@inheritDoc}
     **/
    @Override
    public void run(String... args) throws Exception {


        if(environmentConfigs.isFirstExecution()){
            processor.processReadDirectoryFiles();
        }else{
            createDirectoryWatcher();
        }

    }

    private void createDirectoryWatcher() throws Exception{

        // get path object pointing to the directory we wish to monitor
        Path path = Paths.get(environmentConfigs.getFullPathReadFilesDirectory());

        // watch service for keep monitoring the directory
        WatchService watcher;
        System.out.println("Will monitor the directory: " + environmentConfigs.getFullPathReadFilesDirectory());

        while (true) {
            watcher = path.getFileSystem().newWatchService();
            path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);

            // listen to directory changes
            WatchKey watchKey = watcher.take();

            List<WatchEvent<?>> events = watchKey.pollEvents();

            for (WatchEvent event : events) {
                //check if the event refers to a new file created
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    String fileName = event.context().toString();
                    if (FilenameUtils.getExtension(fileName).equals("dat")) {
                        processor.processReadDirectoryFiles();
                    } else {
                        System.out.println("Não irá processar o arquivo: " + fileName);
                    }
                }
            }
        }
    }
}
