package me.mkhwang.senssms.sendModule.service;

import lombok.Data;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Data
public class SensConfig {

    private String servId;
    private String accessKeyId;
    private String secretKey;

    public SensConfig(String servId, String accessKeyId, String secretKey){
        this.servId = servId;
        this.accessKeyId = accessKeyId;
        this.secretKey = secretKey;
    }

}
