package me.mkhwang.senssms.sendModule.response.model;

import lombok.Data;

/**
 * Created by mkhwang on 2021/04/08.
 */
@Data
public class SensErrorResponse implements SensResponse {
    private Error errors;

    @Override
    public int responseStatusCode() {
        return errors.errorCode;
    }

    @Data
    class Error {
        private int errorCode;
        private String message;
        private String details;
    }
}
