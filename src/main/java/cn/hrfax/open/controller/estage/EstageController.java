package cn.hrfax.open.controller.estage;

import cn.hrfax.open.api.ApiResponse;
import cn.hrfax.open.api.ResponseInfo;
import cn.hrfax.open.common.BankApplyBusiCode;
import cn.hrfax.open.common.util.HttpClientUtils;
import cn.hrfax.open.config.EsbConfig;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpw
 * @version 1.0
 * @date 2018/12/7 11:53
 **/
@RestController("/estage")
@Api(tags = "e分期外部机构对接接口", description = "机构进件接口",value = "/estage")
public class EstageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EstageController.class);

    @Autowired
    private EsbConfig esbConfig;

//    @PostMapping("/hello")
//    @ApiOperation(value = "hello",notes = "Hello")
//    @ApiImplicitParam
//    public Object hello(@ApiJsonObject(name = "params", value = {
//            @ApiJsonProperty(key = "mobile", example = "18614242538", description = "user mobile",required = true,allowMultiple=true,value = {
//                    @ApiSingleParam(name = "aaa",value = "sss")
//            }),
//            @ApiJsonProperty(key = "password", example = "123456", description = "user password",required = true,allowMultiple=false)
//    })@RequestBody Map<String, Object> params){
//        LOGGER.error("hello");
//        return "Hello";
//    }

    //征信进件参数
    private final String creditApplyParam="{" +
            "\"assurerNo\":\"合作商户号；String(25)；技术提供；必传\"," +
            "\"bankType\":\"银行类型；String(25)；ICBC；必传\"," +
            "\"busiCode\":\"接口标识；String(30)；1001,每个接口有个字符串来标识接口唯一性；必传\"," +
            "\"sign\":\"签名\"," +
            "\"platNo\":\"平台编码；String(10)；技术提供；必传\"," +
            "\"data\":{" +
                "\"pub\":{" +
                    "\"bankCode\":\"经办行；String(50)；业务落地行编号，技术提供；必传\"," +
                    "\"assurerNo\":\"合作商户号；String(25)；技术提供；必传\"," +
                    "\"bankType\":\"银行类型；String(25)；ICBC；非必传\"," +
                    "\"busiCode\":\"接口标识；String(30)；1001,每个接口有个字符串来标识接口唯一性；非必传\"," +
                    "\"orderNo\":\"订单号；String(50)；每笔交易唯一标识，贵方订单号；必传\"," +
                    "\"platNo\":\"平台编码；String(10)；技术提供；必传\"," +
                    "\"productType\":\"产品类型；Int(2)；技术提供：业务作业审批的流程编码，不同的作业流程有不同编码；必传\"" +
                "}," +
                "\"req\":{" +
                    "\"intentionPrice\":\"意向价格；Decimal(17,2)；意向车辆价格；必传\"," +
                    "\"carType\":\"业务品种；Int(2)；0-新车，1-二手车，2-新能源车；必传\"," +
                    "\"downloadMode\":\"材料下载方式；Int(2)；1-http下载,2-ftp下载,3-sftp下载；必传\"," +
                    "\"lender(主借款人信息)\":{" +
                        "\"userName\":\"姓名；String(30)；主借款人姓名；必传\"," +
                        "\"idCard\":\"身份证号码；String(18)；主借款人身份证号码；必传\"," +
                        "\"startDate\":\"证件有限期起始日；String(10)；yyyy.MM.dd，例2015.07.14；必传\"," +
                        "\"endDate\":\"证件有限期截止日；String(10)；yyyy.MM.dd，例2035.07.14；必传\"," +
                        "\"bankCardNo\":\"银行卡号；String(20)；银行卡号；非必传\"," +
                        "\"phoneNum\":\"手机号码；String(11)；主借款人手机号码；必传\"," +
                        "\"signMode\":\"签约方式；Int(2)；1-电子签约方式，2-影像上传方式，非必传\"," +
                        "\"issueAuthority\":\"身份证签发机关；String(60)；身份证签发机关；必传\"," +
                        "\"familyAddress\":\"住宅地址；String(120)；住宅地址；必传\"," +
                        "\"pics\":[" +
                            "{" +
                                "\"picId\":\"材料ID；Int(11)；材料唯一ID；必传\"," +
                                "\"picCode\":\"材料Code；String(30)；材料code，sfzzm:身份证正面，sfzfm:身份证反面，zxsqs:征信授权书，sjcxsqs:数据查询授权书，zxsqszp:授权书签字照片，rlzmz:人脸正面照，WGDCL:其他贷款材料； 身份证正面、身份证反面、征信授权书必传,订单为电子签约方式时，征信授权书不用传\"," +
                                "\"picFileName\":\"材料的fileName；String(30)；材料的fileName；必传\"," +
                                "\"picAddress\":\"材料完整路径地址；String(250)；材料完整路径地址；必传\"" +
                            "}" +
                        "]" +
                    "}," +
                    "\"spouse(关联人信息),整个区块可不传\":[" +
                        "{" +
                            "\"userName\":\"姓名；String(30)；共同还款人姓名；必传\"," +
                            "\"idCard\":\"身份证号码；String(18)；关联人身份证号码；必传\"," +
                            "\"startDate\":\"证件有限期起始日；String(10)；yyyy.MM.dd，例2015.07.14；必传\"," +
                            "\"endDate\":\"证件有限期截止日；String(10)；yyyy.MM.dd，例2035.07.14；必传\"," +
                            "\"bankCardNo\":\"银行卡号；String(20)；银行卡号；非必传\"," +
                            "\"phoneNum\":\"手机号码；String(11)；共同还款人手机号码；必传\"," +
                            "\"signMode\":\"签约方式；Int(2)；1-电子签约方式，2-影像上传方式，非必传\"," +
                            "\"issueAuthority\":\"身份证签发机关；String(60)；关联人身份证签发机关；必传\"," +
                            "\"isQueryCredit\":\"是否查征信；Integer(1)；0-是 1-否，默认0-是；必传\"," +
                            "\"userRelationShip\":\"与申请人关系；Integer(1)；1-财产共有人，2-担保关系人，3-共同申请人，4-共同偿还人；必传\"," +
                            "\"userRelationShip\":\"关系类型；Integer(2)；1-配偶，2-父母，3-子女，4-兄弟姐妹，5-亲戚，6-同学，7-同乡，8-朋友，9-同事；必传\"," +
                            "\"familyAddress\":\"住宅地址；String(120)；住宅地址；必传\"," +
                            "\"pics\":[" +
                                "{" +
                                "\"picId\":\"材料ID；Int(11)；材料唯一ID；必传\"," +
                                "\"picCode\":\"材料Code；String(30)；材料code，sfzzm:身份证正面，sfzfm:身份证反面，zxsqs:征信授权书，sjcxsqs:数据查询授权书，zxsqszp:授权书签字照片，rlzmz:人脸正面照，WGDCL:其他贷款材料； 身份证正面、身份证反面、征信授权书必传,订单为电子签约方式时，征信授权书不用传\"," +
                                "\"picFileName\":\"材料的fileName；String(30)；材料的fileName；必传\"," +
                                "\"picAddress\":\"材料完整路径地址；String(250)；材料完整路径地址；必传\"" +
                                "}" +
                            "]" +
                        "}" +
                    "]" +
                "}" +
            "}" +
            "}";

    //@PostMapping("/bank/creditApply")
    @PostMapping("/1/bank/route")
    @ApiOperation(value = "征信进件", notes = "征信进件接口，业务代码busiCode为1001")
    @ApiImplicitParam(name = "jsonObject", value = creditApplyParam, required = true, paramType = "body" )
    public Object creditApply(@RequestBody JSONObject jsonObject){
        LOGGER.error("征信进件接口:{}"+jsonObject);
        String busiCode=jsonObject.getString("busiCode");
        if(busiCode==null||!BankApplyBusiCode.ICBC_CREDIT_APPLY.routeBusiCode.equals(busiCode)){
            return new ApiResponse(ResponseInfo.ILLEGAL_PARAM.code, ResponseInfo.ILLEGAL_PARAM.msg+": busiCode错误");
        }
        return bankRoute(jsonObject);
    }

    //开卡进件参数
    private final String cardApplyParam="{" +
            "\"assurerNo\":\"合作商户号；String(25)；技术提供；必传\"," +
            "\"bankType\":\"银行类型；String(25)；ICBC；必传\"," +
            "\"busiCode\":\"接口标识；String(30)；1003,每个接口有个字符串来标识接口唯一性；必传\"," +
            "\"sign\":\"签名\"," +
            "\"platNo\":\"平台编码；String(10)；技术提供；必传\"," +
            "\"data\":{" +
                "\"pub\":{" +
                    "\"bankCode\":\"经办行；String(50)；业务落地行编号，技术提供；必传\"," +
                    "\"assurerNo\":\"合作商户号；String(25)；技术提供；必传\"," +
                    "\"bankType\":\"银行类型；String(25)；ICBC；非必传\"," +
                    "\"busiCode\":\"接口标识；String(30)；1003,每个接口有个字符串来标识接口唯一性；非必传\"," +
                    "\"orderNo\":\"订单号；String(50)；每笔交易唯一标识，贵方订单号；必传\"," +
                    "\"platNo\":\"平台编码；String(10)；技术提供；必传\"," +
                    "\"productType\":\"产品类型；Int(2)；技术提供：业务作业审批的流程编码，不同的作业流程有不同编码；必传\"" +
                "}," +
                "\"req\":{" +
                    "\"workdate\":\"上传日期；String(8)；YYYY.MM.DD；必传\"," +
                    "\"custsort\":\"证件类型；Int(4)；0-身份证 1-护照 2-军官证 3-士兵证 4-回乡证 5-临时身份证 6-户口本 7-其他 9-警官证；必传\"," +
                    "\"custcode\":\"证件号码；String(18)；证件号码；必传\"," +
                    "\"chnsname\":\"姓名；String(30)；姓名；必传\"," +
                    "\"engname\":\"姓名拼音或英文名；String(50)；如：ZHANG,SAN  用英文逗号隔开；必传\"," +
                    "\"sex\":\"性别；Int(4)；1-男,2-女,当证件类型为身份证的时候，该字段可以不输；必传\"," +
                    "\"mrtlstat\":\"婚姻状况；int(4)；0:未知,1:未婚(无配偶),2:已婚(有配偶),3:分居,4:离异,5:丧偶,6:其他；必传\"," +
                    "\"edulvl\":\"受教育程度；Int(4)；1:博士及以上,2:硕士研究生,3:大学本科,4:大学专科/电大,5:中专,6:技工学校,7:高中,8:初中,9:小学及以下；必传\"," +
                    "\"drawzono\":\"领卡地区号；String(5)；领卡地区号；非必传\"," +
                    "\"drawbrno\":\"领卡网点号；String(5)；领卡网点号；非必传\"," +
                    "\"homestat\":\"住宅状况；Int(4)；1-自有住房，2-分期付款购房，3-租房，4-其他，5-集体宿舍，6-单位分配；必传\"," +
                    "\"hprovince\":\"住宅地址省份；String(5)；住宅地址省份；必传\"," +
                    "\"hcity\":\"住宅地址市；String(50)；住宅地址市；必传\"," +
                    "\"hcounty\":\"住宅地址县(区)；String(50)；住宅地址县(区)；必传\"," +
                    "\"haddress\":\"住宅地址；String(150)；住宅地址；必传\"," +
                    "\"homezip\":\"住宅邮编；String(6)；例如523000；必传\"," +
                    "\"indate\":\"何时入住现址；String(10)；YYYY-MM-DD；必传\"," +
                    "\"hphonzono\":\"住宅电话区号；String(5)；住宅电话区号；必传\"," +
                    "\"hphoneno\":\"住宅电话号码；String(12)；住宅电话号码；必传\"," +
                    "\"mvblno\":\"手机号码；String(11)；手机号码；必传\"," +
                    "\"email\":\"电子邮箱；String(50)；住宅地址；非必传\"," +
                    "\"unitname\":\"工作单位名称；String(60)；工作单位名称；必传\"," +
                    "\"duty\":\"职务；Int(4)；1:国家主席、副主席、总理级副总理、国务委员级，2:部、省级、副部、副省级，3：董事/司、局、地、厅级，4：总经理/县处级，5：科级/部门经理，6：职员/科员级；必传\"," +
                    "\"cophozono\":\"单位电话区号；String(5)；单位电话区号；必传\"," +
                    "\"cophoneno\":\"单位电话号码；String(12)；单位电话号码；必传\"," +
                    "\"caddress\":\"工作单位地址；String(120)；工作单位地址；必传\"," +
                    "\"corpzip\":\"单位邮编；String(6)；单位邮编；必传\"," +
                    "\"joindate\":\"进入现单位工作时间；String(10)；YYYYMM；必传\"," +
                    "\"yearincome\":\"本人年收入；Decimal(17,2)；单位：元；必传\"," +
                    "\"modelcode\":\"单位性质；int(4)；10－国有 20－集体 30－国有控股 40-集体控股 50-三资 60-私营 70-个体 80-外贸 90-股份合作 100-其他股份制 110-民营 120-联营 130-乡镇企业 190-其他；必传\"," +
                    "\"occptn\":\"职业及职级；int(4)；1公务员，2事业单位员工，3职员，4军人，5自由职业者，6工人，7农民，10邮电通讯行业职员，11房地产行业职员，12交通运输行业职员，13法律/司法行业职员，14文化/娱乐/体育行业职员，15媒介/广告行业职员，16科研/教育行业职员，17学生，18计算机/网络行业职员，19商业贸易行业职员，20银行/金融/证券/投资行业职员，21税务行业职员，22咨询行业职员，23社会服务行业职员，24旅游/饭店行业职员，25健康/医疗服务行业职员，26管理人员，27技术人员，28文体明星，29无职业，30私人业主；必传\"," +
                    "\"carstat\":\"自购车状况；Int(4)；0-有，1-无；必传\"," +
                    "\"reltname1\":\"联系人1姓名；String(30)；联系人1姓名；必传\"," +
                    "\"reltship1\":\"联系人1与主卡联系人关系；Int(4)；1-父子，2-母子，3-兄弟姐妹，4-亲属，5-夫妻，6-同学，7-同乡，8-朋友，9-同事；必传\"," +
                    "\"reltphzon1\":\"联系人1联系电话区号；String(5)；联系人1联系电话区号；必传\"," +
                    "\"relaphone1\":\"联系人1联系电话号码；String(12)；联系人1联系电话号码；必传\"," +
                    "\"reltmobl1\":\"联系人1手机；String(11)；联系人1手机；必传\"," +
                    "\"reltname2\":\"联系人2姓名；String(30)；联系人2姓名；必传\"," +
                    "\"reltship2\":\"联系人2与主卡联系人关系；Int(4)；1-父子，2-母子，3-兄弟姐妹，4-亲属，5-夫妻，6-同学，7-同乡，8-朋友，9-同事；必传\"," +
                    "\"reltphzon2\":\"联系人2联系电话区号；String(5)；联系人2联系电话区号；必传\"," +
                    "\"relaphone2\":\"联系人2联系电话号码；String(12)；联系人2联系电话号码；必传\"," +
                    "\"reltmobl2\":\"联系人2手机；String(11)；联系人2手机；必传\"," +
                    "\"cprovince\":\"单位地址省份；String(5)；单位地址省份；必传\"," +
                    "\"ccity\":\"单位地址市；String(30)；单位地址市；必传\"," +
                    "\"ccounty\":\"单位地址县（区）；String(30)；单位地址县（区）；必传\"," +
                    "\"drawmode\":\"卡片领取方式；int(4)；1-自取，2-寄送单位地址，3-寄送住宅地址；必传\"," +
                    "\"statdate\":\"证件有效期；String(10)；YYYY-MM-DD，如果是长期，则填入9999-12-30；必传\"," +
                    "\"primnat\":\"国籍；Int(4)；国籍，见字典；必传\"," +
                    "\"cstsign\":\"亲见客户签名；Int(4)；1:是 2:否；必传\"," +
                    "\"almebno\":\"联名单位会员号；String(20)；联名单位会员号；非必传\"," +
                    "\"outcardno1\":\"转出卡号/账号；String(32)；转出卡号/账号；非必传\"" +
                "}" +
            "}" +
            "}";

    //@PostMapping("/bank/cardApply")
    @PostMapping("/2/bank/route")
    @ApiOperation(value = "申请开卡", notes = "申请开卡接口，业务代码busiCode为1003，收到4-授信通过通知后可调用此接口")
    @ApiImplicitParam(name = "jsonObject", value = cardApplyParam, required = true, paramType = "body",example = "example")
    public Object cardApply(@RequestBody JSONObject jsonObject){
        LOGGER.error("申请开卡接口:{}"+jsonObject);
        String busiCode=jsonObject.getString("busiCode");
        if(busiCode==null||!BankApplyBusiCode.ICBC_CARD_APPLY.routeBusiCode.equals(busiCode)){
            return new ApiResponse(ResponseInfo.ILLEGAL_PARAM.code, ResponseInfo.ILLEGAL_PARAM.msg+": busiCode错误");
        }
        return bankRoute(jsonObject);
    }

    //分期进件参数
    private final String stageApplyParam="{" +
            "\"assurerNo\":\"合作商户号；String(25)；技术提供；必传\"," +
            "\"bankType\":\"银行类型；String(25)；ICBC；必传\"," +
            "\"busiCode\":\"接口标识；String(30)；1002,每个接口有个字符串来标识接口唯一性；必传\"," +
            "\"sign\":\"签名\"," +
            "\"platNo\":\"平台编码；String(10)；技术提供；必传\"," +
            "\"data\":{" +
                "\"pub\":{" +
                    "\"bankCode\":\"经办行；String(50)；业务落地行编号，技术提供；必传\"," +
                    "\"assurerNo\":\"合作商户号；String(25)；技术提供；必传\"," +
                    "\"bankType\":\"银行类型；String(25)；ICBC；非必传\"," +
                    "\"busiCode\":\"接口标识；String(30)；1002,每个接口有个字符串来标识接口唯一性；非必传\"," +
                    "\"orderNo\":\"订单号；String(50)；每笔交易唯一标识，贵方订单号；必传\"," +
                    "\"platNo\":\"平台编码；String(10)；技术提供；必传\"," +
                    "\"productType\":\"产品类型；Int(2)；技术提供：业务作业审批的流程编码，不同的作业流程有不同编码；必传\"" +
                "}," +
                "\"req\":{" +
                    "\"signMode\":\"签约方式；Int；1.电子签约方式，2.影像上传方式；非必传\"," +
                    "\"carInfo(车辆信息)\":{" +
                        "\"carName\":\"车型名称；String(60)；传第一车网id；必传\"," +
                        "\"carPrice\":\"车辆价格；Decimal(17,2)；非行内系统字段，不传不影响办理业务；非必传\"," +
                        "\"carType\":\"国产车还是进口车；Int；0-国产车，1-进口车，非行内系统字段，不传不影响办理业务；非必传\"," +
                        "\"frameNo\":\"车架号；String(40)；视业务行要求；非必传\"," +
                        "\"engineNo\":\"发动机号；String(30)；视业务行要求；非必传\"" +
                    "}," +
                    "\"stageInfo (分期信息)\":{" +
                        "\"businessModel\":\"业务模式；Int(4)；1-抵押,2-质押,3-保证,4-组合,5-抵押+合作机构保证(先放款后抵押),6-抵押+合作机构保证(先抵押后放款),7-阶段性保证+抵押；必传\"," +
                        "\"dealer\":\"经销商名称；String(100)；经销商名称；非必传\"," +
                        "\"contractLoanMoney\":\"车辆贷款本金；decimal(17,2)；除担保费之外的贷款金额。计算公式：车辆贷款本金=贷款金额合计-附加费 ；非必传\"," +
                        "\"dscode\":\"营销代码；String(30)；信用卡卡表上的营销代码；非必传\"," +
                        "\"contractSfRatio\":\"收入还贷比；Decimal(2,2)；收入还贷比；非必传\"," +
                        "\"repayPeriod\":\"还款期限；Int(4)；3/6/9/12/18/24/36/48/60；必传\"," +
                        "\"marketingArchivesNum\":\"营销档案编号；String(8)；信用卡卡产品编号；必传\"," +
                        "\"commissionFeeRate\":\"分期手续费率；String(20)；例如10% 则传 10，非行内系统字段，不传不影响办理业务，非必传\"," +
                        "\"willResign\":\"是否重新签约；Int(1)；是否重新签约，0-否,1-是；非必传\"," +
                        "\"sfMoney\":\"首付金额；decimal(17,2)；首付金额；必传\"," +
                        "\"sfProportion\":\"首付比例；decimal(17,2)；非行内系统字段，不传不影响办理业务；非必传\"," +
                        "\"stageMoney\":\"分期金额；decimal(17,2)；非行内系统字段，不传不影响办理业务；非必传\"," +
                        "\"firstMonthMoney\":\"首月还款金额；decimal(17,2)；非行内系统字段，不传不影响办理业务；非必传\"," +
                        "\"monthMoney\":\"月还款金额；decimal(17,2)；非行内系统字段，不传不影响办理业务；非必传\"," +
                        "\"poundageAmount\":\"手续费总额；decimal(17,2)；非行内系统字段，不传不影响办理业务；非必传\"," +
                        "\"monthincome\":\"还款人月均总收入；decimal(17,2)；还款人月均总收入；必传\"," +
                        "\"monthhomeincome\":\"还款人家庭月均总收入；decimal(17,2)；还款人家庭月均总收入；非必传\"," +
                        "\"property\":\"个人总资产；decimal(17,2)；个人总资产；必传\"," +
                        "\"houseArea\":\"现住房面积；decimal(17,2)；现住房面积，单位m²；必传\"," +
                        "\"othdebtbal\":\"其他负债余额；decimal(17,2)；其他负债余额，不包含本笔；必传\"," +
                        "\"monrepayamt\":\"其他月还款额；decimal(17,2)；其他月还款额，不包含本笔；必传\"," +
                        "\"dealer\":\"汽车经销商名称(全称)；String(100)；汽车经销商名称(全称)；必传\"," +
                        "\"insureamt\":\"车损险投保金额；decimal(17,2)；需大于贷款金额合计+首付款金额；必传\"," +
                        "\"loanMoney\":\"贷款金额合计；decimal(17,2)；包含担保费等，等于最终的放款金额；必传\"," +
                        "\"actualLoanAmount\":\"关联人月收入；decimal(17,2)；关联人月收入；非必传\"" +
                    "}," +
                    "\"guaranteeInfo(担保信息)\":{" +
                        "\"encbno\":\"他项权证号；String(60)；他项权证号；非必传\"," +
                        "\"mortname\":\"抵押品名称；String(200)；抵押品名称；非必传\"," +
                        "\"chnsname\":\"权属人姓名；String(30)；权属人姓名；非必传\"," +
                        "\"apprel\":\"申请人与抵押物权属人关系；Int(2)；1:本人 2:父母 3:配偶 4:子女；非必传\"," +
                        "\"mortltype\":\"抵押品大类；String(3)；抵押品大类，见字典5；非必传\"," +
                        "\"mortmtype\":\"抵押品中类；String(6)；抵押品中类，见字典5；非必传\"," +
                        "\"mortstype\":\"抵押品小类；String(9)；抵押品小类，见字典5；非必传\"," +
                        "\"mortvalue\":\"抵押品价值；Decimal(17,2)；抵押品价值；非必传\"," +
                        "\"mortaddr\":\"抵押品地址；String(120)；抵押品地址；非必传\"," +
                        "\"encbregdate\":\"他项权证登记日期；String(10)；yyyy-MM-dd；非必传\"," +
                        "\"encbpreddate\":\"预计可办理他项权日期；String(10)；yyyy-MM-dd；非必传\"," +
                        "\"maxmortrate\":\"最高抵押率；Decimal(17,2)；最高抵押率；非必传\"," +
                        "\"mortbegdate\":\"抵押起始日；String(10)；抵押起始日，yyyy-MM-dd；非必传\"," +
                        "\"mortenddate\":\"抵押到期日；String(10)；抵押到期日，yyyy-MM-dd；非必传\"," +
                        "\"mortcontrno\":\"抵押合同编号；String(100)；抵押合同编号；非必传\"," +
                        "\"dbimpno\":\"质押品编号；String(13)；质押品编号；非必传\"," +
                        "\"bailname\":\"保证人名称；String(30)；保证人名称；非必传\"," +
                        "\"bailamount\":\"保证总金额；Decimal(17,2)；保证总金额；非必传\"," +
                        "\"bailaccno\":\"保证金账号；String(19)；保证金账号；非必传\"," +
                        "\"bailcontno\":\"担保合同/担保承诺函编号；String(100)；担保合同/担保承诺函编号；非必传\"" +
                    "}," +
                    "\"financeChargeCardInfo(附加费开卡信息)\":{" +
                        "\"marketId\":\"附加费营销档案编号；String(30)；附加费营销档案编号；非必传\"," +
                        "\"financeCharge\":\"附加费；Decimal(17,2)；附加费；非必传\"," +
                        "\"guaranteeCode\":\"附加费担保合同/担保承诺函编号；String(30)；附加费担保合同/担保承诺函编号；非必传\"" +
                    "}," +
                    "\"payMentInfo(打款信息)\":{" +
                        "\"payMode\":\"支付模式；Int(2)；1-受托支付;2-实体POS刷卡分期；必传\"," +
                        "\"payeeType\":\"收款对象类型；Int(2)；1合作机构;2合作单位;3合作机构+合作单位；必传\"," +
                        "\"agencyId\":\"第三方机构编码；Int(2)；第三方机构编码；非必传\"," +
                        "\"agencyReceiveAmt1\":\"第三方收款金额1；decimal(17,2)；第三方收款金额1；非必传\"," +
                        "\"agencyReceiveType1\":\"第三方机构收款金额1标志；Int(2)；1:贷款金额，2:附加费；非必传\"," +
                        "\"agencyReceiveAmt2\":\"第三方机构收款金额2；decimal(17,2)；第三方机构收款金额2；非必传\"," +
                        "\"agencyReceiveType2\":\"第三方机构收款金额2标志；Int(2)；1:贷款金额，2:附加费；非必传\"," +
                        "\"cocomNos(合作单位信息)\":[" +
                            "{" +
                                "\"cocomId\":\"合作单位编号；String(15)；合作单位编号；非必传\"," +
                                "\"cocomInterestFlag\":\"是否贴息；Int(2)；是否贴息，1-是,0-否；非必传\"," +
                                "\"cocomInterestNo\":\"贴息商品编号；String(4)；贴息商品编号；非必传\"," +
                                "\"cocomReceiveAmt\":\"合作单位收款金额；Decimal(17,2)；合作单位收款金额；非必传\"," +
                                "\"cocomReceiveType\":\"合作单位收款金额标志；Int(2)；1:贷款金额，2:附加费；非必传\"" +
                            "}" +
                        "]" +
                    "}," +
                    "\"JKRCL(主借款人材料)\":{" +
                        "\"name\":\"姓名；String(30)；姓名；必传\"," +
                        "\"idCard\":\"身份证号；String(18)；身份证号；必传\"," +
                        "\"mobile\":\"手机号码；String(11)；手机号码；必传\"," +
                        "\"materials(材料信息)\":[" +
                            "{" +
                                "\"materialCode\":\"材料编码；String(30)；材料编码，见字典；必传\"," +
                                "\"materialsType\":\"材料类型；String(2)；0-图片 1-视频；必传\"," +
                                "\"downloadMode\":\"材料下载方式；String(2)；1-http下载，2-ftp下载，3-sftp下载；必传\"," +
                                "\"mates\":[" +
                                    "{" +
                                        "\"demandMateId\":\"材料ID；Int(11)；材料唯一标识；必传\"," +
                                        "\"materialsPic\":\"材料下载地址；String(250)；图片大小须小于500K，单个视频时长最大10分钟；如果ftp下载，请提供文件路径；必传\"," +
                                        "\"fileName\":\"材料文件名；String(30)；材料文件名；必传\"" +
                                    "}" +
                                "]" +
                            "}" +
                        "]" +
                    "}," +
                    "\"GTHKRCL(共同还款人材料)\":{" +
                        "\"name\":\"姓名；String(30)；姓名；必传\"," +
                        "\"idCard\":\"身份证号；String(18)；身份证号；必传\"," +
                        "\"mobile\":\"手机号码；String(11)；手机号码；必传\"," +
                        "\"materials(材料信息)\":[" +
                            "{" +
                                "\"materialCode\":\"材料编码；String(30)；材料编码，见字典；必传\"," +
                                "\"materialsType\":\"材料类型；String(2)；0-图片 1-视频；必传\"," +
                                "\"downloadMode\":\"材料下载方式；String(2)；1-http下载，2-ftp下载，3-sftp下载；必传\"," +
                                "\"mates\":[" +
                                    "{" +
                                        "\"demandMateId\":\"材料ID；Int(11)；材料唯一标识；必传\"," +
                                        "\"materialsPic\":\"材料下载地址；String(250)；图片大小须小于500K，单个视频时长最大10分钟；如果ftp下载，请提供文件路径；必传\"," +
                                        "\"fileName\":\"材料文件名；String(30)；材料文件名；必传\"" +
                                    "}" +
                                "]" +
                            "}" +
                        "]" +
                    "}," +
                    "\"DBRCL(担保人材料)\":{" +
                        "\"name\":\"姓名；String(30)；姓名；必传\"," +
                        "\"idCard\":\"身份证号；String(18)；身份证号；必传\"," +
                        "\"mobile\":\"手机号码；String(11)；手机号码；必传\"," +
                        "\"materials(材料信息)\":[" +
                            "{" +
                                "\"materialCode\":\"材料编码；String(30)；材料编码，见字典；必传\"," +
                                "\"materialsType\":\"材料类型；String(2)；0-图片 1-视频；必传\"," +
                                "\"downloadMode\":\"材料下载方式；String(2)；1-http下载，2-ftp下载，3-sftp下载；必传\"," +
                                "\"mates\":[" +
                                    "{" +
                                        "\"demandMateId\":\"材料ID；Int(11)；材料唯一标识；必传\"," +
                                        "\"materialsPic\":\"材料下载地址；String(250)；图片大小须小于500K，单个视频时长最大10分钟；如果ftp下载，请提供文件路径；必传\"," +
                                        "\"fileName\":\"材料文件名；String(30)；材料文件名；必传\"" +
                                    "}" +
                                "]" +
                            "}" +
                        "]" +
                    "}" +
                "}" +
            "}" +
            "}";

    //@PostMapping("/bank/stageApply")
    @PostMapping("/3/bank/route")
    @ApiOperation(value = "分期进件", notes = "分期进件接口，业务代码busiCode为1002，收到4-授信通过通知后可调用此接口，先调用开卡接口，再调次分期进件接口")
    @ApiImplicitParam(name = "jsonObject", value = stageApplyParam, required = true, paramType = "body")
    public Object stageApply(@RequestBody JSONObject jsonObject){
        LOGGER.error("分期进件接口:{}"+jsonObject);
        String busiCode=jsonObject.getString("busiCode");
        if(busiCode==null||!BankApplyBusiCode.ICBC_STAGE_APPLY.routeBusiCode.equals(busiCode)){
            return new ApiResponse(ResponseInfo.ILLEGAL_PARAM.code, ResponseInfo.ILLEGAL_PARAM.msg+": busiCode错误");
        }
        return bankRoute(jsonObject);
    }

    //材料补录参数
    private final String materialsSupplementParam="{" +
            "\"assurerNo\":\"合作商户号；String(25)；技术提供；必传\"," +
            "\"bankType\":\"银行类型；String(25)；ICBC；必传\"," +
            "\"busiCode\":\"接口标识；String(30)；1005,每个接口有个字符串来标识接口唯一性；必传\"," +
            "\"sign\":\"签名\"," +
            "\"platNo\":\"平台编码；String(10)；技术提供；必传\"," +
            "\"data\":{" +
                "\"pub\":{" +
                    "\"bankCode\":\"经办行；String(50)；业务落地行编号，技术提供；必传\"," +
                    "\"assurerNo\":\"合作商户号；String(25)；技术提供；必传\"," +
                    "\"bankType\":\"银行类型；String(25)；ICBC；非必传\"," +
                    "\"busiCode\":\"接口标识；String(30)；1005,每个接口有个字符串来标识接口唯一性；非必传\"," +
                    "\"orderNo\":\"订单号；String(50)；每笔交易唯一标识，贵方订单号；必传\"," +
                    "\"platNo\":\"平台编码；String(10)；技术提供；必传\"," +
                    "\"productType\":\"产品类型；Int(2)；技术提供：业务作业审批的流程编码，不同的作业流程有不同编码；必传\"" +
                "}," +
                "\"req\":{" +
                    "\"guaranteeInfo(担保信息)\":{" +
                        "\"encbno\":\"他项权证号；String(60)；他项权证号；非必传\"," +
                        "\"mortname\":\"抵押品名称；String(200)；抵押品名称；非必传\"," +
                        "\"chnsname\":\"权属人姓名；String(30)；权属人姓名；非必传\"," +
                        "\"apprel\":\"申请人与抵押物权属人关系；Int(2)；1:本人 2:父母 3:配偶 4:子女；非必传\"," +
                        "\"mortltype\":\"抵押品大类；String(3)；抵押品大类，见字典5；非必传\"," +
                        "\"mortmtype\":\"抵押品中类；String(6)；抵押品中类，见字典5；非必传\"," +
                        "\"mortstype\":\"抵押品小类；String(9)；抵押品小类，见字典5；非必传\"," +
                        "\"mortvalue\":\"抵押品价值；Decimal(17,2)；抵押品价值；非必传\"," +
                        "\"mortaddr\":\"抵押品地址；String(120)；抵押品地址；非必传\"," +
                        "\"encbregdate\":\"他项权证登记日期；String(10)；yyyy-MM-dd；非必传\"," +
                        "\"encbpreddate\":\"预计可办理他项权日期；String(10)；yyyy-MM-dd；非必传\"," +
                        "\"maxmortrate\":\"最高抵押率；Decimal(17,2)；最高抵押率；非必传\"," +
                        "\"mortbegdate\":\"抵押起始日；String(10)；抵押起始日，yyyy-MM-dd；非必传\"," +
                        "\"mortenddate\":\"抵押到期日；String(10)；抵押到期日，yyyy-MM-dd；非必传\"," +
                        "\"mortcontrno\":\"抵押合同编号；String(100)；抵押合同编号；非必传\"," +
                        "\"dbimpno\":\"质押品编号；String(13)；质押品编号；非必传\"," +
                        "\"bailname\":\"保证人名称；String(30)；保证人名称；非必传\"," +
                        "\"bailamount\":\"保证总金额；Decimal(17,2)；保证总金额；非必传\"," +
                        "\"bailaccno\":\"保证金账号；String(19)；保证金账号；非必传\"," +
                        "\"bailcontno\":\"担保合同/担保承诺函编号；String(100)；担保合同/担保承诺函编号；非必传\"" +
                    "}," +
                    "\"materials(材料信息)\":[" +
                        "{" +
                            "\"materialCode\":\"材料编码；String(30)；材料编码，见字典；必传\"," +
                            "\"materialsType\":\"材料类型；String(2)；0-图片 1-视频；必传\"," +
                            "\"downloadMode\":\"材料下载方式；String(2)；1-http下载，2-ftp下载，3-sftp下载；必传\"," +
                            "\"mates\":[" +
                                "{" +
                                    "\"demandMateId\":\"材料ID；Int(11)；材料唯一标识；必传\"," +
                                    "\"materialsPic\":\"材料下载地址；String(250)；图片大小须小于500K，单个视频时长最大10分钟；如果ftp下载，请提供文件路径；必传\"," +
                                    "\"fileName\":\"材料文件名；String(30)；材料文件名；必传\"" +
                                "}" +
                            "]" +
                        "}" +
                    "]" +
                "}" +
            "}" +
            "}";

    //@PostMapping("/bank/materialsSupplement")
    @PostMapping("/4/bank/route")
    @ApiOperation(value = "材料补录", notes = "材料补录接口，业务代码busiCode为1005，在收到6-材料补录通知后可调用此接口，在进件过程中为非必调接口")
    @ApiImplicitParam(name = "jsonObject", value = materialsSupplementParam, required = true, paramType = "body")
    public Object materialsSupplement(@RequestBody JSONObject jsonObject){
        LOGGER.error("材料补录接口:{}"+jsonObject);
        String busiCode=jsonObject.getString("busiCode");
        if(busiCode==null||!BankApplyBusiCode.ICBC_SUPPLEMENT.routeBusiCode.equals(busiCode)){
            return new ApiResponse(ResponseInfo.ILLEGAL_PARAM.code, ResponseInfo.ILLEGAL_PARAM.msg+": busiCode错误");
        }
        return bankRoute(jsonObject);
    }

    //抵押材料补录参数
    private final String mortgageSupplementsParam="{" +
            "\"assurerNo\":\"合作商户号；String(25)；技术提供；必传\"," +
            "\"bankType\":\"银行类型；String(25)；ICBC；必传\"," +
            "\"busiCode\":\"接口标识；String(30)；1006,每个接口有个字符串来标识接口唯一性；必传\"," +
            "\"sign\":\"签名\"," +
            "\"platNo\":\"平台编码；String(10)；技术提供；必传\"," +
            "\"data\":{" +
                "\"pub\":{" +
                    "\"bankCode\":\"经办行；String(50)；业务落地行编号，技术提供；必传\"," +
                    "\"assurerNo\":\"合作商户号；String(25)；技术提供；必传\"," +
                    "\"bankType\":\"银行类型；String(25)；ICBC；非必传\"," +
                    "\"busiCode\":\"接口标识；String(30)；1006,每个接口有个字符串来标识接口唯一性；非必传\"," +
                    "\"orderNo\":\"订单号；String(50)；每笔交易唯一标识，贵方订单号；必传\"," +
                    "\"platNo\":\"平台编码；String(10)；技术提供；必传\"," +
                    "\"productType\":\"产品类型；Int(2)；技术提供：业务作业审批的流程编码，不同的作业流程有不同编码；必传\"" +
                "}," +
                "\"req\":{" +
                    "\"taskId\":\"任务号；String(18)；任务号；必传\"," +
                    "\"materials(材料信息)\":[" +
                        "{" +
                            "\"materialCode\":\"材料编码；String(30)；材料编码，见字典；必传\"," +
                            "\"materialsType\":\"材料类型；String(2)；0-图片 1-视频；必传\"," +
                            "\"downloadMode\":\"材料下载方式；String(2)；1-http下载，2-ftp下载，3-sftp下载；必传\"," +
                            "\"mates\":[" +
                                "{" +
                                    "\"demandMateId\":\"材料ID；Int(11)；材料唯一标识；必传\"," +
                                    "\"materialsPic\":\"材料下载地址；String(250)；图片大小须小于500K，单个视频时长最大10分钟；如果ftp下载，请提供文件路径；必传\"," +
                                    "\"fileName\":\"材料文件名；String(30)；材料文件名；必传\"" +
                                "}" +
                            "]" +
                        "}" +
                    "]" +
                "}" +
            "}" +
            "}";

    //@PostMapping("/bank/mortgageSupplements")
    @PostMapping("/5/bank/route")
    @ApiOperation(value = "抵押材料补录", notes = "抵押材料补录接口，业务代码busiCode为1006，在收到5-等待押品补录通知后可调用此接口")
    @ApiImplicitParam(name = "jsonObject", value = mortgageSupplementsParam, required = true, paramType = "body")
    public Object mortgageSupplements(@RequestBody JSONObject jsonObject){
        LOGGER.error("抵押材料补录接口:{}"+jsonObject);
        String busiCode=jsonObject.getString("busiCode");
        if(busiCode==null||!BankApplyBusiCode.ICBC_MORTGAGE_SUPPLE.routeBusiCode.equals(busiCode)){
            return new ApiResponse(ResponseInfo.ILLEGAL_PARAM.code, ResponseInfo.ILLEGAL_PARAM.msg+": busiCode错误");
        }
        return bankRoute(jsonObject);
    }

    //信息确认参数
    private final String orderInfoConfirmParam="{" +
            "\"assurerNo\":\"合作商户号；String(25)；技术提供；必传\"," +
            "\"bankType\":\"银行类型；String(25)；ICBC；必传\"," +
            "\"busiCode\":\"接口标识；String(30)；1008,每个接口有个字符串来标识接口唯一性；必传\"," +
            "\"sign\":\"签名\"," +
            "\"platNo\":\"平台编码；String(10)；技术提供；必传\"," +
            "\"data\":{" +
                "\"pub\":{" +
                    "\"bankCode\":\"经办行；String(50)；业务落地行编号，技术提供；必传\"," +
                    "\"assurerNo\":\"合作商户号；String(25)；技术提供；必传\"," +
                    "\"bankType\":\"银行类型；String(25)；ICBC；非必传\"," +
                    "\"busiCode\":\"接口标识；String(30)；1008,每个接口有个字符串来标识接口唯一性；非必传\"," +
                    "\"orderNo\":\"订单号；String(50)；每笔交易唯一标识，贵方订单号；必传\"," +
                    "\"platNo\":\"平台编码；String(10)；技术提供；必传\"," +
                    "\"productType\":\"产品类型；Int(2)；技术提供：业务作业审批的流程编码，不同的作业流程有不同编码；必传\"" +
                "}," +
                "\"req\":{" +
                    "\"signConfirm\":\"确认标记；Int(1)；1-征信确认，2-请款确认；必传\"" +
                "}" +
            "}" +
            "}";

    //@PostMapping("/bank/orderInfoConfirm")
    @PostMapping("/6/bank/route")
    @ApiOperation(value = "信息确认", notes = "信息确认接口，业务代码busiCode为1008，当订单为电子签约方式时需在相应阶段调用此接口，目前有征信确认、请款确认。" +
            "例如征信提交后，再调用该接口，signConfirm传1-征信确认，e分期方才可将此订单提交至行内进行风险筛查等操作")
    @ApiImplicitParam(name = "jsonObject", value = orderInfoConfirmParam, required = true, paramType = "body")
    public Object orderInfoConfirm(@RequestBody JSONObject jsonObject){
        LOGGER.error("信息确认接口:{}"+jsonObject);
        String busiCode=jsonObject.getString("busiCode");
        if(busiCode==null||!BankApplyBusiCode.ICBC_LOANORDER_CONFIRM.routeBusiCode.equals(busiCode)){
            return new ApiResponse(ResponseInfo.ILLEGAL_PARAM.code, ResponseInfo.ILLEGAL_PARAM.msg+": busiCode错误");
        }
        return bankRoute(jsonObject);
    }

    private Object bankRoute(JSONObject jsonObject){
        String result= "";
        try {
            result=HttpClientUtils.post(esbConfig.getRouteUrl(),jsonObject.toString());
        }catch (Exception e){
            LOGGER.error("异常",e);
            return new ApiResponse(ResponseInfo.EXCEPTION.code, ResponseInfo.EXCEPTION.msg);
        }
        return JSONObject.parseObject(result);
    }
}
