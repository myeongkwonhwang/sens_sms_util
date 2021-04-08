package me.mkhwang.senssms.sendModule.service;

import lombok.extern.slf4j.Slf4j;
import me.mkhwang.senssms.sendModule.request.RequestHelper;
import me.mkhwang.senssms.sendModule.request.model.SendMessageRequest;
import me.mkhwang.senssms.sendModule.response.parser.Parser;
import me.mkhwang.senssms.sendModule.response.parser.ResponseData;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Slf4j
public class SensClient implements Client {

    private final SensConfig config;
    private final RequestHelper helper;

    public SensClient(SensConfig config) {
        this.config = config;
        this.helper = new RequestHelper(config);
    }

    @Override
    public Object sendMessage(SendMessageRequest request) throws Exception {
        ResponseData responseData = helper.getPostURL(request);
        log.info("sendMessage : {}", responseData.getResponseXml());
        if(responseData.getStatusCode() != 202 && responseData.getStatusCode() != 200) return Parser.errMessage(responseData);
        return Parser.sendMessage(responseData);
    }
}
