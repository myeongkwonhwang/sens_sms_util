package me.mkhwang.senssms.sendModule.service;

import me.mkhwang.senssms.sendModule.request.model.SendMessageRequest;

/**
 * Created by mkhwang on 2021/04/08.
 */
public interface Client {
    Object sendMessage(SendMessageRequest sendMessageRequest) throws Exception;
}
