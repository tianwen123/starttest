package org.example.common;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import org.example.entity.DemoPo;
import org.example.entity.UserPo;
import org.example.utils.StringUtil;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class DpBase {

    @DataProvider(name = "dataProviderYaml")
    public Iterator<Object[]> dataProviderYaml(Method method) throws Exception {
    String filePath=method.getAnnotation(Path.class).value();
    ClassLoader classLoader = getClass().getClassLoader();
    String path = classLoader.getResource(filePath).getPath();
    List<DemoPo> listTestData = StringUtil.getListTestData(path);
    Iterator it=listTestData.iterator();
    List<Object[]> result=new ArrayList<Object[]>();
    while(it.hasNext()){
        result.add(new Object[] { it.next() });
    }
    return  result.iterator();
}


}
