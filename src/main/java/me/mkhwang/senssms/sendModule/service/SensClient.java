package me.mkhwang.senssms.sendModule.service;

import lombok.extern.slf4j.Slf4j;
import me.mkhwang.senssms.sendModule.request.RequestHelper;
import me.mkhwang.senssms.sendModule.request.model.SendMessageRequest;
import me.mkhwang.senssms.sendModule.response.model.SensResponse;
import me.mkhwang.senssms.sendModule.response.parser.Parser;
import me.mkhwang.senssms.sendModule.response.parser.ResponseData;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Slf4j
public class SensClient implements Client {

    private SensConfig config;
    private RequestHelper helper;

    public SensClient(SensConfig config) {
        this.config = config;
        this.helper = new RequestHelper(config);
    }

    @Override
    public SensResponse sendMessage(SendMessageRequest request) throws Exception {
        ResponseData responseData = helper.getPostURL(request);
        log.info("sendMessage : {}", responseData.getResponseXml());
        if(responseData.getStatusCode() < HttpsURLConnection.HTTP_BAD_REQUEST) return Parser.sendMessage(responseData);
        return Parser.errMessage(responseData);
    }
}
