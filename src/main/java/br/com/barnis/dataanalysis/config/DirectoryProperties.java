package br.com.barnis.dataanalysis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by Barnis Marinho on Junho, 2018
 */

@Configuration
@ConfigurationProperties
public class DirectoryProperties {

    private String rootFilesDirectoryName;

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

    private String readFilesDirectory;

    private String writeFilesDirectory;


}
