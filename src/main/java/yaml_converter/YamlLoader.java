package yaml_converter;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class YamlLoader {
    private YamlLoader() {
    }

    public static String loadYamlFile(String key) {
        Yaml yaml = new Yaml();
        String loadDataToConnect = null;
        try {
            InputStream inputStream = new FileInputStream("connectDataInYaml.yaml");
            Map<String, String> obj = yaml.load(inputStream);
            loadDataToConnect = obj.get(key);
            inputStream.close();
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
        return loadDataToConnect;
    }
}