package org.github.axis1.dto.login;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@JacksonXmlRootElement(localName = "USERREQ")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestInfo {

    @JacksonXmlProperty(localName = "HEAD")
    private LoginHeader head;

    @JacksonXmlProperty(localName = "BODY")
    private LoginBody body;
}

