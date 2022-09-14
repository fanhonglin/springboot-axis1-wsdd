package org.github.axis1.dto.update_app_acct;

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
public class UpdateAppAcctBody {

    /**
     * 返回结果, 返回结果标识：0成功，非0失败
     */
    @JacksonXmlProperty(localName = "RSP")
    private String rsp;


    /**
     * 错误描述, 错误描述，非必填。当RSP非0时使用
     */
    @JacksonXmlProperty(localName = "DESC")
    private String desc;


    @JacksonXmlProperty(localName = "QUERYMODE")
    private String queryMode;

}
