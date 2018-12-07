package cn.hrfax.open.controller.estage;

import cn.hrfax.open.api.ApiResponse;
import cn.hrfax.open.api.ResponseInfo;
import cn.hrfax.open.common.BankApplyBusiCode;
import cn.hrfax.open.common.util.HttpClientUtils;
import cn.hrfax.open.config.EsbConfig;
import cn.hrfax.open.controller.BaseController;
import cn.hrfax.open.exception.BusiException;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpw
 * @version 1.0
 * @date 2018/12/7 11:53
 **/
@RestController("/estage")
@Api(tags = "e分期外部机构对接接口", description = "机构进件接口")
public class EstageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EstageController.class);

    @Autowired
    private EsbConfig esbConfig;

//    @GetMapping("/hello")
//    @ApiOperation(value = "hello",notes = "Hello")
//    public Object hello(){
//        LOGGER.error("hello");
//        return "Hello";
//    }

    @PostMapping("/bank/creditApply")
    @ApiOperation(value = "征信进件", notes = "征信进件接口，业务代码busiCode为1001")
    @ApiImplicitParam(name = "jsonObject", value = "{\n" +
            "  \"assurerNo\": \"商户代码\",\n" +
            "  \"data\": \"加密data数据\",\n" +
            "  \"sign\": \"签名\",\n" +
            "  \"bankType\": \"银行类型\",\n" +
            "  \"busiCode\": \"业务编码\",\n" +
            "  \"platNo\":\"平台编号\"\n" +
            "}")
    public Object creditApply(@RequestBody JSONObject jsonObject){
        LOGGER.error("征信进件接口:{}"+jsonObject);
        String busiCode=jsonObject.getString("busiCode");
        if(busiCode==null||!BankApplyBusiCode.ICBC_CREDIT_APPLY.routeBusiCode.equals(busiCode)){
            return new ApiResponse(ResponseInfo.ILLEGAL_PARAM.code, ResponseInfo.ILLEGAL_PARAM.msg+": busiCode错误");
        }
        return bankRoute(jsonObject);
    }

    @PostMapping("/bank/cardApply")
    @ApiOperation(value = "申请开卡", notes = "申请开卡接口，业务代码busiCode为1003")
    @ApiImplicitParam(name = "jsonObject", value = "{\n" +
            "  \"assurerNo\": \"商户代码\",\n" +
            "  \"data\": \"加密data数据\",\n" +
            "  \"sign\": \"签名\",\n" +
            "  \"bankType\": \"银行类型\",\n" +
            "  \"busiCode\": \"业务编码\",\n" +
            "  \"platNo\":\"平台编号\"\n" +
            "}")
    public Object cardApply(@RequestBody JSONObject jsonObject){
        LOGGER.error("申请开卡接口:{}"+jsonObject);
        String busiCode=jsonObject.getString("busiCode");
        if(busiCode==null||!BankApplyBusiCode.ICBC_CARD_APPLY.routeBusiCode.equals(busiCode)){
            return new ApiResponse(ResponseInfo.ILLEGAL_PARAM.code, ResponseInfo.ILLEGAL_PARAM.msg+": busiCode错误");
        }
        return bankRoute(jsonObject);
    }

    @PostMapping("/bank/stageApply")
    @ApiOperation(value = "分期进件", notes = "分期进件接口，业务代码busiCode为1002")
    @ApiImplicitParam(name = "jsonObject", value = "{\n" +
            "  \"assurerNo\": \"商户代码\",\n" +
            "  \"data\": \"加密data数据\",\n" +
            "  \"sign\": \"签名\",\n" +
            "  \"bankType\": \"银行类型\",\n" +
            "  \"busiCode\": \"业务编码\",\n" +
            "  \"platNo\":\"平台编号\"\n" +
            "}")
    public Object stageApply(@RequestBody JSONObject jsonObject){
        LOGGER.error("分期进件接口:{}"+jsonObject);
        String busiCode=jsonObject.getString("busiCode");
        if(busiCode==null||!BankApplyBusiCode.ICBC_STAGE_APPLY.routeBusiCode.equals(busiCode)){
            return new ApiResponse(ResponseInfo.ILLEGAL_PARAM.code, ResponseInfo.ILLEGAL_PARAM.msg+": busiCode错误");
        }
        return bankRoute(jsonObject);
    }

    @PostMapping("/bank/materialsSupplement")
    @ApiOperation(value = "材料补录", notes = "材料补录接口，业务代码busiCode为1005")
    @ApiImplicitParam(name = "jsonObject", value = "{\n" +
            "  \"assurerNo\": \"商户代码\",\n" +
            "  \"data\": \"加密data数据\",\n" +
            "  \"sign\": \"签名\",\n" +
            "  \"bankType\": \"银行类型\",\n" +
            "  \"busiCode\": \"业务编码\",\n" +
            "  \"platNo\":\"平台编号\"\n" +
            "}")
    public Object materialsSupplement(@RequestBody JSONObject jsonObject){
        LOGGER.error("材料补录接口:{}"+jsonObject);
        String busiCode=jsonObject.getString("busiCode");
        if(busiCode==null||!BankApplyBusiCode.ICBC_SUPPLEMENT.routeBusiCode.equals(busiCode)){
            return new ApiResponse(ResponseInfo.ILLEGAL_PARAM.code, ResponseInfo.ILLEGAL_PARAM.msg+": busiCode错误");
        }
        return bankRoute(jsonObject);
    }

    @PostMapping("/bank/mortgageSupplements")
    @ApiOperation(value = "抵押材料补录", notes = "抵押材料补录接口，业务代码busiCode为1006")
    @ApiImplicitParam(name = "jsonObject", value = "{\n" +
            "  \"assurerNo\": \"商户代码\",\n" +
            "  \"data\": \"加密data数据\",\n" +
            "  \"sign\": \"签名\",\n" +
            "  \"bankType\": \"银行类型\",\n" +
            "  \"busiCode\": \"业务编码\",\n" +
            "  \"platNo\":\"平台编号\"\n" +
            "}")
    public Object mortgageSupplements(@RequestBody JSONObject jsonObject){
        LOGGER.error("抵押材料补录接口:{}"+jsonObject);
        String busiCode=jsonObject.getString("busiCode");
        if(busiCode==null||!BankApplyBusiCode.ICBC_MORTGAGE_SUPPLE.routeBusiCode.equals(busiCode)){
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
            return new ApiResponse(ResponseInfo.EXCEPTION.code, ResponseInfo.EXCEPTION.msg+": busiCode错误");
        }
        return JSONObject.parseObject(result);
    }
}
