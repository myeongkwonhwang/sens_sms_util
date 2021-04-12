package me.mkhwang.senssms.sendModule.request.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by mkhwang on 2021/04/09.
 */
@Data
@AllArgsConstructor
@Builder
public class MessageFile {
    private String name;
    private String body;
}
