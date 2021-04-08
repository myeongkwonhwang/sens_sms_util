package me.mkhwang.senssms.sendModule.request.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Messages {
    private String content;
    private String subject;
    private String to;
}
