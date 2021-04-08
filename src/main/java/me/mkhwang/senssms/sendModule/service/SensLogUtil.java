package me.mkhwang.senssms.sendModule.service;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Slf4j
public class SensLogUtil {

    public void logMessage(String message) {
        log.debug(message);
    }
}
