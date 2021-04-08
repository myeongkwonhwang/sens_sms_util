package me.mkhwang.senssms.sendModule.request.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import me.mkhwang.senssms.sendModule.types.MessageType;

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

    public SendMessageRequest(String from, String subject, String content, List<Messages> messages){
        this.type = MessageType.LMS.toString();
        this.from = from;
        this.messages = messages;
        this.subject = subject;
        this.content = content;
    }
}
