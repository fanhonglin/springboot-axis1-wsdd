package org.github.axis1.dto.login;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@JacksonXmlRootElement(localName = "USERRSP")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseInfo {

    //    @JacksonXmlElementWrapper(localName = "HEAD")
    @JacksonXmlProperty(localName = "HEAD")
    private LoginHeader head;

    //    @JacksonXmlElementWrapper(localName = "BODY")
    @JacksonXmlProperty(localName = "BODY")
    private LoginResponseBody body;
}

