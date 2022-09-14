package org.github.axis1.dto.login;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@JacksonXmlRootElement(localName = "HEAD")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginHeader {

    @JacksonXmlProperty(localName = "CODE")
    private String code;

    @JacksonXmlProperty(localName = "SID")
    private String sid;

    @JacksonXmlProperty(localName = "TIMESTAMP")
    private String timestamp;

    @JacksonXmlProperty(localName = "SERVICEID")
    private String serviceId;
}
