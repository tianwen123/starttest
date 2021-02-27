package org.example.testcase;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.example.common.DpBase;
import org.example.common.Path;
import org.example.entity.DemoPo;
import org.example.entity.UserPo;
import org.example.utils.CommonUtil;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompleteCase extends DpBase {

    @Test(description = "验证jenkins查询 ",dataProvider = "dataProviderYaml")
    @Path("testdata/demo2.yaml")
    public void shouldAnswerWithTrue2(DemoPo demoPo){
        System.out.println(demoPo.getAge());
    }
    @Test
    public void tt(){
        String template="- !!org.example.entity.DemoPo\n" +
                "  name: n1\n" +
                "  age: 1\n" +
                "  infoData:\n" +
                "    user:\n" +
                "      !!org.example.entity.UserPo\n" +
                "      addr: $mm.getStr()";
        Map<String,Object> context = new HashMap();
        context.put("mm",new CommonUtil());
        Writer writer=new StringWriter();
        VelocityContext vc=new VelocityContext(context);
        Velocity.evaluate(vc,writer,"",template);
        String tag = writer.toString();
    }
}
