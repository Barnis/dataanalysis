package br.com.barnis.dataanalysis.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
public class CompanyFileProcessor {

    private CompanyEnvironmentConfigs environmentConfig;

    public CompanyFileProcessor(CompanyEnvironmentConfigs environmentConfigs) {
        this.environmentConfig = environmentConfigs;
    }

    public void processReadDirectoryFiles() {
        List<Path> paths = readFiles();

        paths.forEach(this::processFile);
    }

    private List<Path> readFiles(){

        List<Path> pathList = null;

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");

        try {
            Path path = Paths.get(environmentConfig.getFullPathReadFilesDirectory());
            Stream<Path> list = Files.list(path);
            //list.forEach(System.out::println);
            pathList = list.filter(f -> matcher.matches(f.getFileName())).collect(Collectors.toList());
            //pathList = list.filter(f -> f.endsWith(".dat")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pathList;
    }

    private void processFile(Path path){

        try {
            String s = FileUtils.readFileToString(path.toFile(), Charset.defaultCharset());
            String[] split = s.split(System.getProperty("line.separator"));
            List<String> fileLines = Arrays.asList(split);
            fileLines.forEach(this::processFileLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processFileLine(String fileLine){
        String[] split = fileLine.split("ç");
        String idLayout = "001";
        if(idLayout.equals(split[0])){
            System.out.println("Vai popular um layout de dados do cliente");
        }


    }
}
