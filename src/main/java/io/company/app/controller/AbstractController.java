package io.company.app.controller;

import io.company.app.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractController {

    protected ResponseEntity makeResponse() {
        return ResponseEntity.ok(new ApiResponse() {{

        }});
    }

    protected ResponseEntity makeResponse(Object data) {
        return ResponseEntity.ok(new ApiResponse() {{
            this.setData(data);
        }});
    }

    protected ResponseEntity makeResponse(HttpStatus httpStatus, String msg) {
        return ResponseEntity.ok(new ApiResponse() {{

        }});
    }

    /*
    ResponseEntity makeResponse() {
        return ResponseEntity.ok(new ApiResponse() {{

        }});
    }*/
}
