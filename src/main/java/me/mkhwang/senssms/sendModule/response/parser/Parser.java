package me.mkhwang.senssms.sendModule.response.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.mkhwang.senssms.sendModule.response.model.ErrorResponse;
import me.mkhwang.senssms.sendModule.response.model.SendMessageResponse;
import me.mkhwang.senssms.sendModule.response.model.SensErrorResponse;

import java.io.IOException;

/**
 * Created by mkhwang on 2021/04/08.
 */
public class Parser {

    public static SendMessageResponse sendMessage(ResponseData response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.getResponseXml(), SendMessageResponse.class);
    }

    public static SensErrorResponse sensErrMessage(ResponseData response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.getResponseXml(), SensErrorResponse.class);
    }

    public static ErrorResponse errMessage(ResponseData response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.getResponseXml(), ErrorResponse.class);
    }
}
