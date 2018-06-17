package br.com.barnis.dataanalysis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Barnis Marinho on Junho, 2018
 */

@Configuration
@ConfigurationProperties
public class DirectoryProperties {

    private String rootFilesDirectoryName;

    private String readFilesDirectory;

    private String writeFilesDirectory;

    private boolean firstExecution;

    private String fileLineSeparator;

    public String getRootFilesDirectoryName() {
        return rootFilesDirectoryName;
    }

    public void setRootFilesDirectoryName(String rootFilesDirectoryName) {
        this.rootFilesDirectoryName = rootFilesDirectoryName;
    }

    public String getReadFilesDirectory() {
        return readFilesDirectory;
    }

    public void setReadFilesDirectory(String readFilesDirectory) {
        this.readFilesDirectory = readFilesDirectory;
    }

    public String getWriteFilesDirectory() {
        return writeFilesDirectory;
    }

    public void setWriteFilesDirectory(String writeFilesDirectory) {
        this.writeFilesDirectory = writeFilesDirectory;
    }

    public boolean isFirstExecution(){
        return this.firstExecution;
    }

    public void setFirstExecution(boolean firstExecution){
        this.firstExecution = firstExecution;
    }

    public String getFileLineSeparator() {
        return fileLineSeparator;
    }

    public void setFileLineSeparator(String fileLineSeparator) {
        this.fileLineSeparator = fileLineSeparator;
    }
}
