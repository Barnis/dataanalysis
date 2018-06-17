package br.com.barnis.dataanalysis.utils;

import br.com.barnis.dataanalysis.domain.EnumLayoutType;
import br.com.barnis.dataanalysis.domain.LayoutProcessor;
import br.com.barnis.dataanalysis.domain.LayoutProcessorSalesman;
import br.com.barnis.dataanalysis.models.AbstractModel;
import br.com.barnis.dataanalysis.models.SalesMan;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Barnis Marinho on Junho, 2018
 */
@Component
public class CompanyFileProcessor {

    @Autowired
    private CompanyEnvironmentConfigs environmentConfig;

    @Autowired
    private CompanyDataAnalyst companyDataAnalyst;

    private Map<String, List> dataTypeMap = new HashMap<>();

    public CompanyFileProcessor() {

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
            sendDataToAnalysis();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processFileLine(String fileLine){

        String[] split = fileLine.split("ç");

        EnumLayoutType enumLayoutType = EnumLayoutType.layoutByCodeId(split[0]);
        LayoutProcessor layoutProcessor = enumLayoutType.returnLayoutProcessor();
        layoutProcessor.process(split);
        layoutProcessor.obtainModel();

        dataTypeMap.put(layoutProcessor.getLayoutCode(),layoutProcessor.obtainModel());

    }

    public void sendDataToAnalysis(){
        //CompanyDataAnalyst companyDataAnalyst = new CompanyDataAnalyst();
        companyDataAnalyst.generateAnalysisReport(dataTypeMap);
    }
}
