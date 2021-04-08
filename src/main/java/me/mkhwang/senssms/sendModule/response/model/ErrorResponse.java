package me.mkhwang.senssms.sendModule.response.model;

import lombok.Data;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Data
public class ErrorResponse {
    private Error error;

    @Data
    class Error {
        private int errorCode;
        private String message;
        private String details;
    }
}
