package com.example.java18;

import com.example.domain.AccountRoleEnum;
import com.example.domain.QryEngineerAdminPageListRspBO;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 郝少杰
 * @date 2021/1/22 14:41
 */
public class JAVA18 {
    public static void main(String[] args) {
        List<QryEngineerAdminPageListRspBO> rspBOS = new ArrayList<>();
        QryEngineerAdminPageListRspBO qryEngineerAdminPageListRspBO = new QryEngineerAdminPageListRspBO("","","","00","","","","","","","","","");
        QryEngineerAdminPageListRspBO qryEngineerAdminPageListRspBO1 = new QryEngineerAdminPageListRspBO("","","","00","","","","","","","","","");
        QryEngineerAdminPageListRspBO qryEngineerAdminPageListRspBO2 = new QryEngineerAdminPageListRspBO("","","","00","","","","","","","","","");
        rspBOS.add(qryEngineerAdminPageListRspBO);
        rspBOS.add(qryEngineerAdminPageListRspBO1);
        rspBOS.add(qryEngineerAdminPageListRspBO2);

        rspBOS = rspBOS.stream().map(rspBO -> {
            rspBO.setAccountRoleName(AccountRoleEnum.codeOf(rspBO.getAccountRole()).getDesc());
            return rspBO;
        }).collect(Collectors.toList());

        System.out.println(rspBOS);
    }
}
