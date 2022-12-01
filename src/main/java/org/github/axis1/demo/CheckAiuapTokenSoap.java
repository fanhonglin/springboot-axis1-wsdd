package org.github.axis1.demo;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.github.axis1.dto.login.LoginHeader;
import org.github.axis1.dto.login.LoginRequestInfo;
import org.github.axis1.dto.login.LoginResponseBody;
import org.github.axis1.dto.login.LoginResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author pony
 * @date 2018年5月21日
 */
public class CheckAiuapTokenSoap {


    private static final Logger logger = LoggerFactory.getLogger(CheckAiuapTokenSoap.class);

    public String CheckAiuapTokenSoap(String RequestInfo) throws IOException {

        // xml 转 对象

        XmlMapper xmlMapper = new XmlMapper();

        LoginRequestInfo loginRequestInfo = xmlMapper.readValue(RequestInfo, LoginRequestInfo.class);
        System.out.println(loginRequestInfo.toString());

        // 对象转xml
        LoginHeader loginHeader = loginRequestInfo.getHead();
        LoginResponseBody loginResponseBody = LoginResponseBody
                .builder()
                .rsp("0")
                .mainAcctId("administrator")
                .appAcctId("administrator")
                .build();

        LoginResponseInfo loginResponseInfo = LoginResponseInfo
                .builder()
                .head(loginHeader)
                .body(loginResponseBody)
                .build();


        String s = xmlMapper.writeValueAsString(loginResponseInfo);
        String header = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";

        return header + s;
    }
}
