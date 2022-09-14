package org.github.axis1.dto.query_main_account;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@JacksonXmlRootElement(localName = "BODY")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryMainAccountResponseBody {

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


    @JacksonXmlElementWrapper(localName = "USERLIST")
    private List<QueryMainAccountSubAcctResponse> userInfo;

}
