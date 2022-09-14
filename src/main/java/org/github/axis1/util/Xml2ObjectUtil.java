package org.github.axis1.util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;


/**
 * Object 和 Xml 互转
 */
public class Xml2ObjectUtil {

    private final static XmlMapper XML_MAPPER = new XmlMapper();

    // xml 头信息
    private final static String HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";


    /**
     * xml 转 Object
     *
     * @param xml
     * @param t
     */
    public static <T> T xml2Object(String xml, Class<T> t) throws IOException {

        // xml 反解为对象
        return XML_MAPPER.readValue(xml, t);
    }

    /**
     * Object 转 xml
     *
     * @param object
     * @param
     * @return
     * @throws IOException
     */
    public static String object2Xml(Object object) throws IOException {

        // 数据信息
        String value = XML_MAPPER.writeValueAsString(object);

        // 加入头信息
        return HEADER + value;
    }
}
