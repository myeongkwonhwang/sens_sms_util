package me.mkhwang.senssms.sendModule.response.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Data
public class SendMessageResponse implements SensResponse {

    private String requestId; //요청 아이디
    private Date requestTime; //요청 시간
    private String statusCode; //요청 상태 코드 : 202 - 성공 , 그 외 - 실패 HTTP Status 규격을 따름
    private String statusName; //요청 상태명 : success - 성공, fail - 실패

    @Override
    public int responseStatusCode() {
        return Integer.parseInt(statusCode);
    }
}
