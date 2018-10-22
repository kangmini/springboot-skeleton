package io.company.app.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResponse {

    private int status;
    private String errorMsg;
    private String errorCode;
    private Object data;

    public ApiResponse() {
        this(HttpStatus.OK);
    }

    public ApiResponse(HttpStatus status) {
        this.status = status.value();
        this.errorMsg = status.getReasonPhrase();
        this.errorCode = "0000";
    }

    public ApiResponse(HttpStatus status, String errorCode) {
        this.status = status.value();
        this.errorMsg = status.getReasonPhrase();
        this.errorCode = errorCode;
    }

    public ApiResponse(HttpStatus status, String errorCode, String errorMsg) {
        this.status = status.value();
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }
}
