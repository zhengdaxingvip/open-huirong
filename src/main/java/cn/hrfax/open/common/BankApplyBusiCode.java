/**
 * Copyright (C) 2014-2018, Hrfax and/or its affiliates. All rights reserved.
 * Hrfax PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cn.hrfax.open.common;

/**
 * @author zhouyq
 * @Date 2018年1月16日
 */
public enum BankApplyBusiCode {

    ENCRYPT_SIGN("0000","encryptAndSign",true),
    CREDIT_APPLY("0001", "bankCreditApply", true),
    CREDIT_RESULT("0002", "bankCreditResult"),
    CREDIT_BACK("0003", "bankCreditBack"),
    STAGE_APPLY("0004", "bankStageApply", true),
    STAGE_BACK("0005", "bankStageBack"),
    STAGE_RESULT("0006", "bankStageResult"),
    STAGE_PROGRESS("0007", "bankStageProgress", true),
    CARD_APPLY("0008", "bankCardApply", true),
    CARD_BACK("0009", "bankCardBack"),
    CARD_INFO("0010", "bankCardResult"),
    CREDIT_VALIDATE("0011", "creditValidate", true),
    SUPPLEMENT("0012", "supplement", true),
    OVERDUE_ASSIGN("0013", "overdueAssign"),
    RISK_RESERVE("0014", "riskReserve", true),
    SUP_MATERIAL_NOTICE("0015", "supMaterialNotice"),
    SYN_STATUS("0016", "synStatus"),
    SEND_MATERIALS("0017", "sendMaterials"),
    /*** e分期新增 ***/
    ICBC_CREDIT_APPLY("1001", "bankCreditApply", true),
    ICBC_STAGE_APPLY("1002", "bankStageApply", true),
    ICBC_CARD_APPLY("1003", "bankCardApply", true),
    ICBC_NOTICCE_CALLBACK("1004", "bankNoticeCallback"),
    ICBC_SUPPLEMENT("1005", "supplement", true),
    ICBC_MORTGAGE_SUPPLE("1006", "mortgageSupple", true),
    ICBC_SIGNCHECK("1007", "signCheck", true),
    ICBC_LOANORDER_CONFIRM("1008", "loanOrderConfirm", true),
    ICBC_SIGNC_CONTRACT_DOWNLOAD("1009", "contractDownload", true),
    ICBC_SIGNC_CONTRACT_LIST("1010", "contractList", true),
    /*** 电子签约新增 ***/
    DIGIT_ORG_APPLY("1020", "orgSignApply", true),
    DIGIT_ORG_SIGN("1021", "orgSign", true),
    DIGIT_ORG_SIGN_TASK("1022", "orgSignTask"),
    ;

    public final String routeBusiCode;

    public final String busiCode;

    public final boolean isApply;

    BankApplyBusiCode(String routeBusiCode, String busiCode, boolean isApply) {
        this.routeBusiCode = routeBusiCode;
        this.busiCode = busiCode;
        this.isApply = isApply;
    }

    BankApplyBusiCode(String routeBusiCode, String busiCode) {
        this(routeBusiCode, busiCode, false);
    }

    public static boolean isApply(String busiCode) {

        BankApplyBusiCode[] applys = BankApplyBusiCode.values();
        for (BankApplyBusiCode bankApplyBusiCode : applys) {
            if (bankApplyBusiCode.busiCode.equals(busiCode)) {
                return bankApplyBusiCode.isApply;
            }
        }
        return false;
    }

    public static String getBusiCode(String routeBusiCode) {

        BankApplyBusiCode[] applys = BankApplyBusiCode.values();
        for (BankApplyBusiCode bankApplyBusiCode : applys) {
            if (bankApplyBusiCode.routeBusiCode.equals(routeBusiCode)) {
                return bankApplyBusiCode.busiCode;
            }
        }
        throw new RuntimeException("业务编码[" + routeBusiCode + "]非法");
    }

}
