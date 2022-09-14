package org.github.axis1.dto.query_main_account;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.github.axis1.util.DateUtils;


@JacksonXmlRootElement(localName = "HEAD")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainAcctStrongAuthenticationResponseHeader {

    @JacksonXmlProperty(localName = "CODE")
    private String code ;

    @JacksonXmlProperty(localName = "SID")
    private String sid ;

    /**
     * 系统时间戳，格式为YYYYMMDDHHmmss
     */
    @JacksonXmlProperty(localName = "TIMESTAMP")
    @Builder.Default
    private String timestamp = DateUtils.getToday();

    /**
     * 应用标识，由4A统一分配，命名规则：移动公司省份两位简写+NG+系统缩写。
     * 如上海BOSS定义为SHNGBOSS，上海BOMC定义为SHNGBOMC，广西BOSS定义为GXNGBOSS，重庆BOSS定义CQNGBOSS等，4A的标识统一为AIUAP
     */
    @JacksonXmlProperty(localName = "SERVICEID")
    @Builder.Default
    private String serviceId = "HANGHNYYZJ";
}
