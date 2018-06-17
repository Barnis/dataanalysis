package br.com.barnis.dataanalysis.utils;

import br.com.barnis.dataanalysis.config.DirectoryProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Barnis Marinho on Junho, 2018
 */

@Component
public class CompanyEnvironmentConfigs {


    private static final String USER_HOME;
    private static final String FILE_SEPARATOR;

    static {
        USER_HOME = System.getProperty("user.home");
        FILE_SEPARATOR = System.getProperty("file.separator");
    }

    @Autowired
    private DirectoryProperties directoryProperties;

    private String fullPathRootFilesDirectoryName;


    private String fullPathReadFilesDirectory;

    private String fullPathWriteFilesDirectory;

    private boolean isFirstExecution;

    private String fileLineSeparator;


    @PostConstruct
    public void init(){
        startDirectoriesConfiguration();
    }


    private void startDirectoriesConfiguration() {
        this.fullPathRootFilesDirectoryName = USER_HOME + FILE_SEPARATOR + directoryProperties.getRootFilesDirectoryName();
        this.fullPathReadFilesDirectory = fullPathRootFilesDirectoryName + FILE_SEPARATOR + directoryProperties.getReadFilesDirectory();
        this.fullPathWriteFilesDirectory = fullPathRootFilesDirectoryName + FILE_SEPARATOR + directoryProperties.getWriteFilesDirectory();
        this.isFirstExecution = directoryProperties.isFirstExecution();
        this.fileLineSeparator = directoryProperties.getFileLineSeparator();

    }

    public String getFullPathRootFilesDirectoryName() {
        return fullPathRootFilesDirectoryName;
    }

    public String getFullPathReadFilesDirectory() {
        return fullPathReadFilesDirectory;
    }

    public String getFullPathWriteFilesDirectory() {
        return fullPathWriteFilesDirectory;
    }

    public boolean isFirstExecution() {
         return isFirstExecution;
     }

    public String getFileLineSeparator() {
        return fileLineSeparator;
    }
}
