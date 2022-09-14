package org.github.axis1.demo;

import org.github.axis1.dto.query_main_account.MainAcctStrongAuthenticationResponseHeader;
import org.github.axis1.dto.update_app_acct.UpdateAppAcctBody;
import org.github.axis1.dto.update_app_acct.UpdateAppAcctResponse;
import org.github.axis1.util.Xml2ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author pony
 * @date 2018年5月21日
 */
public class HNUpdateAppAcctService {

    private static final Logger logger = LoggerFactory.getLogger(HNUpdateAppAcctService.class);

    public String HNUpdateAppAcctService(String RequestInfo) throws IOException {

        // 请求参数
        System.out.println("HNUpdateAppAcctService请求参数:" + RequestInfo);


        UpdateAppAcctResponse updateAppAcctResponse = UpdateAppAcctResponse.builder().build();

        // header
        updateAppAcctResponse.setHead(new MainAcctStrongAuthenticationResponseHeader());

        String type = "add";
        if (RequestInfo.contains("add")) {
            type = "add";
        } else if (RequestInfo.contains("delete")) {
            type = "delete";
        } else if (RequestInfo.contains("chgstatus")) {
            type = "chgstatus";
        } else if (RequestInfo.contains("resetpwd")) {
            type = "resetpwd";
        } else if (RequestInfo.contains("change")) {
            type = "change";
        }

        UpdateAppAcctBody updateAppAcctBody = UpdateAppAcctBody.builder().rsp("0").desc("success").queryMode(type).build();

        updateAppAcctResponse.setBody(updateAppAcctBody);

        String result = Xml2ObjectUtil.object2Xml(updateAppAcctResponse);

        System.out.println("HNMainAcctQueryService返回的数据：" + result);
        return result;
    }
}
