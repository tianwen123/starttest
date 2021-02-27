package org.example.utils;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.example.entity.DemoPo;
import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringUtil {
    public static Map<String,Object> context=new HashMap<>();
    public static final String LOG_TAG="";
    static {
        context.put("common",new CommonUtil());
    }
    public static List<DemoPo> getListTestData(String pathName) throws Exception {
        String listInfo = readFile(pathName);
        Writer writer=new StringWriter();
        VelocityContext vc=new VelocityContext(context);
        Velocity.evaluate(vc,writer,LOG_TAG,listInfo);
        List<Object[]> result=new ArrayList<Object[]>();
        Yaml yaml = new Yaml();
        List<DemoPo> list=(List<DemoPo>)yaml.load(writer.toString());
        return  list;
    }
    public static String readFile(String fileName) throws Exception {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long fileLength = file.length();
        byte[] fileContent = new byte[fileLength.intValue()];
        FileInputStream in =  new FileInputStream(file);
        in.read(fileContent);
        in.close();
        return new String(fileContent, encoding);
        }

}
