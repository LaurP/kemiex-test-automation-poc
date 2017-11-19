package kemiex.selenium.automation.poc.models;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class EnvironmentData {
    public HashMap<String, String> environmentUrls;

    public EnvironmentData() {
        Map env = null;
        File file = new File("./src/test/resources/testdata/kemiex_test_env.yml");
        Yaml yaml = new Yaml();
        try {
            env = (HashMap<String, HashMap<String, Object>>) yaml.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        environmentUrls = (HashMap<String, String>) env.get("environment_urls");
    }
}
