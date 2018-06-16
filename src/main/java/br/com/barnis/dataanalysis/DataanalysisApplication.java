package br.com.barnis.dataanalysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.Banner;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@SpringBootApplication
public class DataanalysisApplication implements CommandLineRunner {

    @Autowired
    TestMessage testeMessage;

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
        System.out.println(testeMessage.getNome());

        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("file.separator"));

        // get path object pointing to the directory we wish to monitor
        Path path = Paths.get(System.getProperty("user.home") + System.getProperty("file.separator") + "data");
        //try {
        // get watch service which will monitor the directory
        WatchService watcher = path.getFileSystem().newWatchService();
        // associate watch service with the directory to listen to the event
        // types
        path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
        System.out.println("Monitoring directory for changes...");
        // listen to events
        while (true) {
            WatchKey watchKey = watcher.take();
            // get list of events as they occur
            List<WatchEvent<?>> events = watchKey.pollEvents();
            //iterate over events
            for (WatchEvent event : events) {
                //check if the event refers to a new file created
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    //print file name which is newly created
                    System.out.println("Created: " + event.context().toString());
                }
            }
        }
        /*} catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //}

    }
}
