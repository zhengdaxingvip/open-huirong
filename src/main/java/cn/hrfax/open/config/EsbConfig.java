package cn.hrfax.open.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author chenpw
 * @version 1.0
 * @date 2018/12/7 17:28
 **/
@Component
@Configuration
@Data
public class EsbConfig {
    @Value("${esb.dataPubKey}")
    private String dataPubKey;   //数据加密公钥

    @Value("${esb.signPrvKey}")
    private String signPrvKey;  //签名秘钥

    @Value("${esb.routeUrl}")
    private String routeUrl;  //esb统一路由接口

}
