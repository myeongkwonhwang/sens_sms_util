package me.mkhwang.senssms.sendModule.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensConfig {

    private String servId;
    private String accessKeyId;
    private String secretKey;

    public String getServId() {
        return servId;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getSecretKey() {
        return secretKey;
    }

}
