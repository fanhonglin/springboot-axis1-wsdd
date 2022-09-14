package org.github.axis1.demo;

import org.github.axis1.dto.query_main_account.MainAcctStrongAuthenticationResponseHeader;
import org.github.axis1.dto.update_org.UpdateOrgBody;
import org.github.axis1.dto.update_org.UpdateOrgResponse;
import org.github.axis1.util.Xml2ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author pony
 * @date 2018年5月21日
 */
public class UpdateAppOrgServices {

    private static final Logger logger = LoggerFactory.getLogger(UpdateAppOrgServices.class);

    public String UpdateAppOrgServices(String RequestInfo) throws IOException {

        // 请求参数
        System.out.println("组织机构UpdateAppOrgServices请求参数:" + RequestInfo);

        UpdateOrgResponse updateOrgResponse = UpdateOrgResponse.builder().build();

        // header
        updateOrgResponse.setHead(new MainAcctStrongAuthenticationResponseHeader());

        UpdateOrgBody updateAppAcctBody = UpdateOrgBody.builder().rsp("0").errDesc("").orgId("1").build();

        updateOrgResponse.setBody(updateAppAcctBody);

        String result = Xml2ObjectUtil.object2Xml(updateOrgResponse);

        System.out.println("组织机构UpdateAppOrgServices返回的数据：" + result);
        return result;
    }
}
