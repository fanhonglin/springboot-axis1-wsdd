package org.github.axis1.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "MX")
public class Clazz {
    @JacksonXmlProperty(localName = "paramA")
    private String a;
    @JacksonXmlProperty(localName = "paramB")
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
