package me.mkhwang.senssms.sendModule.request;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.mkhwang.senssms.sendModule.HmacUtil;
import me.mkhwang.senssms.sendModule.request.model.SendMessageRequest;
import me.mkhwang.senssms.sendModule.response.parser.ResponseData;
import me.mkhwang.senssms.sendModule.service.HttpUtil;
import me.mkhwang.senssms.sendModule.service.SensConfig;
import me.mkhwang.senssms.sendModule.types.ServiceConstants;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Slf4j
public class RequestHelper {

    private SensConfig sensConfig;

    public RequestHelper (SensConfig config) {
        this.sensConfig = config;
    }

    private Map<String, String> genHeader(String timeStamp, String signatrue) {
        Map<String, String> headers = new TreeMap<>();
        headers.put("Content-Type", "application/json");
        headers.put(ServiceConstants.HEADER_TIMESTAMP, timeStamp);
        headers.put(ServiceConstants.HEADER_ACCESSKEY, sensConfig.getAccessKeyId());
        headers.put(ServiceConstants.HEADER_SIGNATURE_V, signatrue);

        return headers;
    }

    public ResponseData getPostURL(SendMessageRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseData responseData = null;
        String requestData = "";
        String signatrue = "";
        String timeStamp = Long.toString(System.currentTimeMillis());
        String serviceUri = ServiceConstants.API_MESSAGESERVICE + sensConfig.getServId() + ServiceConstants.SEND_MESSAGE_URI;
        String requestUri = ServiceConstants.API_URI + serviceUri;
        try {
            requestData = objectMapper.writeValueAsString(request);
            log.info("SendMessageRequest params : {}", requestData);
            signatrue = HmacUtil.generateHmac256(generateSecretMessage("POST", serviceUri, timeStamp, sensConfig.getAccessKeyId()), sensConfig.getSecretKey());
            responseData = HttpUtil.httpSendRequest("POST", requestUri, requestData, genHeader(timeStamp, signatrue));
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return responseData;
    }

    private String generateSecretMessage(String method, String requestUri, String timeStamp, String accessKey) {
        String space = " ";					// one space
        String newLine = "\n";              // new line
        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(requestUri)
                .append(newLine)
                .append(timeStamp)
                .append(newLine)
                .append(accessKey)
                .toString();

        return message;
    }
}