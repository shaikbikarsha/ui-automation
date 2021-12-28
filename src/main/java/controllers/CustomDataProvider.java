package controllers;

import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.*;

public class CustomDataProvider extends ValueAssigner {
    public static String listOfYamlFiles = "";
    public static Yaml yaml = new Yaml();

    @DataProvider(name = "customDataProvider")
    public static Object[][] fileNameAsClassName(Class cls, Method method) throws Exception {
        File folder = new File(System.getProperty("user.dir")+"/src/test/java/tests");
        String yamlFile = listFilesForFolder(folder, cls.getSimpleName()+".java");
        InputStream inputStream = new FileInputStream(String.valueOf(yamlFile));
        Map<String, Object> yamlMap = yaml.load(inputStream);
        Map<String, Object> testSets = (Map<String, Object>) yamlMap.get(method.getName());
        List<Map<String, String>> list = new ArrayList<>();
        String[][] data = new String[testSets.size()][method.getParameters().length];

        testSets.forEach((key, collection) -> {
            list.add((Map<String, String>) testSets.get(key));
        });

        for(int i=0;i<list.size();i++) {
            for(int j=0;j<list.get(i).size();j++){
                list.get(i).values().toArray()[j].toString();
                data[i][j]=list.get(i).values().toArray()[j].toString();
            }
        }

        return data;
    }

    public static List<Map<String, String>> getObjects(Class cls, String objectName) throws Exception {

        File folder = new File(System.getProperty("user.dir")+"/src/test/java/tests");
        String yamlFile = listFilesForFolder(folder, cls.getSimpleName()+".java");
        InputStream inputStream = new FileInputStream(String.valueOf(yamlFile));
        Map<String, Object> yamlMap = yaml.load(inputStream);
        Map<String, Object> testSets = (Map<String, Object>) yamlMap.get(objectName);
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> data = new HashMap<>();

        testSets.forEach((key, collection) -> {
            list.add((Map<String, String>) testSets.get(key));
        });

        System.out.println(list);

        return list;

    }

    public static String listFilesForFolder(File folder, String FineName) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry,FineName);
            } else {
                if(fileEntry.getName().contains(FineName)){
                    listOfYamlFiles = listOfYamlFiles + (new File((fileEntry.getAbsolutePath().contains("/java/tests/") ?
                            fileEntry.getAbsolutePath().replace("/java/tests/", "/resources/testData/") :
                            fileEntry.getAbsolutePath().replace("\\java\\tests\\", "\\resources\\testData\\")).replace(".java", ".yml")));
                    }
                }
            continue;
            }
        return listOfYamlFiles;
    }
}
