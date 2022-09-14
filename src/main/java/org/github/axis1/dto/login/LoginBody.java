package org.github.axis1.dto.login;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@JacksonXmlRootElement(localName = "BODY")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginBody {

    @JacksonXmlProperty(localName = "APPACCTID")
    private String appAccId;

    @JacksonXmlProperty(localName = "TOKEN")
    private String token;

}
