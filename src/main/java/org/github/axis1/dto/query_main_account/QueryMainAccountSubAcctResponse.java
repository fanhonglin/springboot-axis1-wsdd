package org.github.axis1.dto.query_main_account;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@JacksonXmlRootElement(localName = "USERINFO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryMainAccountSubAcctResponse {


    // 序列号
    @JacksonXmlProperty(localName = "MAINACCTID")
    private String mainAcctId;

    // 登录名
    @JacksonXmlProperty(localName = "MAINLOGINNO")
    private String mainLoginInNo;

    /**
     * 1正常 0锁定 2失效(停用)
     */
    @JacksonXmlProperty(localName = "LOCKSTATUS")
    private String lockStatus;

    @JacksonXmlProperty(localName = "LOCKTYPE")
    private String lockType;

    @JacksonXmlProperty(localName = "EFFECTDATE")
    private String effectDate;

    @JacksonXmlProperty(localName = "EXPIREDATE")
    private String expireDate;

    @JacksonXmlProperty(localName = "AUTHOREFFECTDATE")
    private String authorEffectDate;

    @JacksonXmlProperty(localName = "AUTHOREXPIREDATE")
    private String authorExpireDate;

}
