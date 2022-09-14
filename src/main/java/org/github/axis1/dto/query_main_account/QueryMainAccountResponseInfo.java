package org.github.axis1.dto.query_main_account;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.github.axis1.util.Xml2ObjectUtil;

import java.io.IOException;


@JacksonXmlRootElement(localName = "RESPONSE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryMainAccountResponseInfo {

    @JacksonXmlProperty(localName = "HEAD")
    private MainAcctStrongAuthenticationResponseHeader head;

    @JacksonXmlProperty(localName = "BODY")
    private QueryMainAccountResponseBody body;

    public static void main(String[] args) throws IOException {
        String value = "<?xml version='1.0' encoding='UTF-8'?>\n" +
                "<RESPONSE>\n" +
                "<HEAD><CODE></CODE><SID></SID><TIMESTAMP>2\n" +
                "0220706171700</TIMESTAMP><SERVICEID>HANGHNYYZJ</SERVICEID>\n" +
                "</HEAD>\n" +
                "<BODY>\n" +
                "<RSP>0</RSP>\n" +
                "</BODY>\n" +
                "</RESPONSE>";

        QueryMainAccountResponseInfo smResponseInfo = Xml2ObjectUtil.xml2Object(value, QueryMainAccountResponseInfo.class);
        System.out.println(smResponseInfo);
    }

}

