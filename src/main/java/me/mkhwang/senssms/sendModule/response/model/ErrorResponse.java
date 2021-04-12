package me.mkhwang.senssms.sendModule.response.model;

import lombok.Data;

/**
 * Created by mkhwang on 2021/04/09.
 */
@Data
public class ErrorResponse implements SensResponse {
    private int status;
    private String errorMessage;
    private String[] errors;

    @Override
    public int responseStatusCode() {
        return status;
    }
}
