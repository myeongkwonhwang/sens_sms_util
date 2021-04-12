package me.mkhwang.senssms.sendModule.request.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Data
@Builder
@AllArgsConstructor
public class SendMessageRequest {

    private String type;
    private String from;
    private String subject;
    private String content;
    private List<Messages> messages;
    private List<MessageFile> files;
    private String reserveTime;         //yyyy-MM-dd HH:mm
    private String reserveTimeZone;
    private String scheduleCode;
}
