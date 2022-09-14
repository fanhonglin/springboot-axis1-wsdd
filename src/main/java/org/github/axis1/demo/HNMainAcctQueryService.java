package org.github.axis1.demo;

import org.github.axis1.dto.query_main_account.MainAcctStrongAuthenticationResponseHeader;
import org.github.axis1.dto.query_main_account.QueryMainAccountResponseBody;
import org.github.axis1.dto.query_main_account.QueryMainAccountResponseInfo;
import org.github.axis1.dto.query_main_account.QueryMainAccountSubAcctResponse;
import org.github.axis1.util.Xml2ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pony
 * @date 2018年5月21日
 */
public class HNMainAcctQueryService {

    private static final Logger logger = LoggerFactory.getLogger(HNMainAcctQueryService.class);

    public String HNMainAcctQueryService(String Request) throws IOException {

        // 请求参数
        System.out.println("HNMainAcctQueryService请求参数:" + Request);

        // 封装返回的数据
        QueryMainAccountResponseInfo queryMainAccountResponseInfo = new QueryMainAccountResponseInfo();

        // header
        MainAcctStrongAuthenticationResponseHeader header = MainAcctStrongAuthenticationResponseHeader.builder().build();
        queryMainAccountResponseInfo.setHead(header);

        // body
        QueryMainAccountResponseBody queryMainAccountResponseBody = QueryMainAccountResponseBody.builder().desc("success").rsp("0").build();
        List<QueryMainAccountSubAcctResponse> queryMainAccountSubAcctResponses = new ArrayList<>();
        QueryMainAccountSubAcctResponse queryMainAccountSubAcctResponse = new QueryMainAccountSubAcctResponse();
        queryMainAccountSubAcctResponse.setMainAcctId("MainAcctId");
        queryMainAccountSubAcctResponse.setMainLoginInNo("MainLoginInNo");
        queryMainAccountSubAcctResponses.add(queryMainAccountSubAcctResponse);


        QueryMainAccountSubAcctResponse queryMainAccountSubAcctResponse1 = new QueryMainAccountSubAcctResponse();
        queryMainAccountSubAcctResponse1.setMainAcctId("MainAcctId1");
        queryMainAccountSubAcctResponse1.setMainLoginInNo("MainLoginInNo2");
        queryMainAccountSubAcctResponses.add(queryMainAccountSubAcctResponse1);

        queryMainAccountResponseBody.setUserInfo(queryMainAccountSubAcctResponses);
        queryMainAccountResponseInfo.setBody(queryMainAccountResponseBody);

        // 返回的数据
        String result = Xml2ObjectUtil.object2Xml(queryMainAccountResponseInfo);
        System.out.println("HNMainAcctQueryService返回的数据：" + result);
        return result;
    }
}
