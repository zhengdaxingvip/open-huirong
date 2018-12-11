package cn.hrfax.open.common.rsa;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * RSA数据加密、签名密钥
 * <p>1、由行方(银行端)提供给机构数据加密公钥、数据签名私钥（方式：数据经过公钥加密、再签名私钥进行签名）</p>
 * <p>2、银行端通过数据加密私钥对数据进行解密、使用数据签名公钥进行验签</p>
 * @author chenpw
 * @version 1.0
 * @date 2018/12/11 10:59
 **/
@Component
@Configuration
@Data
public class RSAkeyConstant {


    /**************************************惠瀜科技加密KEY**********************************************************/

    /**
     * 数据加密公钥
     */
    @Value("${esb.RSAkey.HRKJ_DATA_PUBLIC_KEY}")
    private String HRKJ_DATA_PUBLIC_KEY;

    /**
     * 数据加密私钥
     */
    @Value("${esb.RSAkey.HRKJ_DATA_PRIVATE_KEY}")
    private String HRKJ_DATA_PRIVATE_KEY;

    /**
     * 数据签名公钥
     */
    @Value("${esb.RSAkey.HRKJ_SIGN_PUBLIC_KEY}")
    private String HRKJ_SIGN_PUBLIC_KEY ;

    /**
     * 数据签名私钥
     */
    @Value("${esb.RSAkey.HRKJ_SIGN_PRIVATE_KEY}")
    private String HRKJ_SIGN_PRIVATE_KEY;



    /**************************************第三方加密KEY**********************************************************/

    /**
     * 数据加密公钥
     */
    @Value("${esb.RSAkey.DATA_PUBLIC_KEY}")
    private String DATA_PUBLIC_KEY ;

    /**
     * 数据加密私钥
     */
    @Value("${esb.RSAkey.DATA_PRIVATE_KEY}")
    private String DATA_PRIVATE_KEY;

    /**
     * 数据签名公钥
     */
    @Value("${esb.RSAkey.SIGN_PUBLIC_KEY}")
    private String SIGN_PUBLIC_KEY;

    /**
     * 数据签名私钥
     */
    @Value("${esb.RSAkey.SIGN_PRIVATE_KEY}")
    private String SIGN_PRIVATE_KEY;

}
