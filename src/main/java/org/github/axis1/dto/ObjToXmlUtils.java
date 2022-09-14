package org.github.axis1.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * XML Obj 互相转换
 *
 * @author <a href="mailto:***@163.com">***</a>
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Created at 2018/9/30
 */
public class ObjToXmlUtils {

    public static void main(String[] args) throws IOException {

        obj2Xml();

//        xmlToObj();
    }

    private static void obj2Xml() throws JsonProcessingException {

        List<Clazz> mx = new ArrayList<>();
        Clazz clazz = new Clazz();
        clazz.setA("Aone");
        clazz.setB("Bone");
        mx.add(clazz);
        clazz = new Clazz();
        clazz.setA("Atow");
        clazz.setB("Atow");
        mx.add(clazz);

        ObjectMapper mapper = new XmlMapper();
        String s = mapper.writeValueAsString(new Person("serv10000000156", "张三", "女", "武汉市", mx));
        System.out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + s);

    }

    public static void xmlToObj() throws IOException {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><msgbody><StringList><mx><paramA>Aone</paramA><paramB>Bone</paramB></mx><mx><paramA>Atow</paramA><paramB>Atow</paramB></mx></StringList><serverId>serv10000000156</serverId><name>张三</name><age>女</age><address>武汉市</address></msgbody>\n";
        ObjectMapper mapper = new XmlMapper();
        Object po = null;
        po = mapper.readValue(xml, Person.class);
        System.out.println(po.toString());
    }

}
