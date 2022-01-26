package org.ait.project.aitboilerplate.shared.utils;

import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelpers {
    private ResponseHelpers() { throw new IllegalStateException("Utility class"); }

    public static <T> ResponseEntity<ResponseTemplate<T>> createResponse(HttpStatus httpStatus,String responseCode, String responseTxt, T data){
        return ResponseEntity.status(httpStatus).body(new ResponseTemplate<>(responseCode,responseTxt,data));
    }
}
