package br.com.barnis.dataanalysis.utils;

import br.com.barnis.dataanalysis.config.DirectoryProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ResourceBundle;

/**
 * Created by Barnis Marinho on Junho, 2018
 */

//@Component
//@PropertySource("classpath:application.properties")
//@ConfigurationProperties
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


    @PostConstruct
    public void init(){
        startDirectoriesConfiguration();
    }


    private void startDirectoriesConfiguration() {
        this.fullPathRootFilesDirectoryName = USER_HOME + FILE_SEPARATOR + directoryProperties.getRootFilesDirectoryName();
        this.fullPathReadFilesDirectory = fullPathRootFilesDirectoryName + FILE_SEPARATOR + directoryProperties.getReadFilesDirectory();
        this.fullPathWriteFilesDirectory = fullPathRootFilesDirectoryName + FILE_SEPARATOR + directoryProperties.getWriteFilesDirectory();

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



}
