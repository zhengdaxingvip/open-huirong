package cn.hrfax.open.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author chenpw
 * @version 1.0
 * @date 2018/12/7 18:28
 **/
@Component
@Configuration
@Data
public class FsConfig {
    public static FsConfig process;

    @PostConstruct
    public void init() {
        process = this;
    }

    @Value("${fs.storage.local.temp}")
    private String storageLocalTemp;   //本地临时文件目录

    public static String getLocalTemp(){
       return process.getStorageLocalTemp();
    }

}
