package org.github.axis1.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * <?xml version="1.0" encoding="utf-8"?>
 * <msgbody>
 * <StringList>
 * <mx>
 * <paramA>Aone</paramA>
 * <paramB>Bone</paramB>
 * </mx>
 * <mx>
 * <paramA>Atow</paramA>
 * <paramB>Atow</paramB>
 * </mx>
 * </StringList>
 * <serverId>serv10000000156</serverId>
 * <name>张三</name>
 * <age>女</age>
 * <address>武汉市</address>
 * </msgbody>
 */
@JacksonXmlRootElement(localName = "msgbody")
public class Person {
    @JacksonXmlProperty(localName = "serverId")
    private String serverId;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "age")
    private String age;
    @JacksonXmlProperty(localName = "address")
    private String address;
    @JacksonXmlElementWrapper(localName = "StringList")
    private List<Clazz> mx;

    public Person() {
    }

    public Person(String serverId, String name, String age, String address, List<Clazz> mx) {
        this.serverId = serverId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.mx = mx;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Clazz> getMx() {
        return mx;
    }

    public void setMx(List<Clazz> mx) {
        this.mx = mx;
    }

    @Override
    public String toString() {
        return "Person{" +
                "serverId='" + serverId + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", mx=" + mx +
                '}';
    }
}

