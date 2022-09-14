package org.github.axis1.dto.update_app_acct;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.github.axis1.dto.query_main_account.MainAcctStrongAuthenticationResponseHeader;


@JacksonXmlRootElement(localName = "RESPONSE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAppAcctResponse {

    /**
     * 返回结果, 返回结果标识：0成功，非0失败
     */
    @JacksonXmlProperty(localName = "HEAD")
    private MainAcctStrongAuthenticationResponseHeader head;


    /**
     * 错误描述, 错误描述，非必填。当RSP非0时使用
     */
    @JacksonXmlProperty(localName = "BODY")
    private UpdateAppAcctBody body;


}
