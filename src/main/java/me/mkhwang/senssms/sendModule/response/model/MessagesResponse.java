package me.mkhwang.senssms.sendModule.response.model;

import lombok.Data;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Data
public class MessagesResponse {
    private String messageId;
    private String requestTime;
    private String countryCode;
    private String from;
    private String to;
}
