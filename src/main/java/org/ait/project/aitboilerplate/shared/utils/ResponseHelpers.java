package org.ait.project.aitboilerplate.shared.utils;

import org.ait.project.aitboilerplate.shared.constant.enums.ResponseEnum;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.springframework.http.ResponseEntity;

public class ResponseHelpers {
    private ResponseHelpers() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> ResponseEntity<ResponseTemplate<T>> createResponse(ResponseEnum responseEnum, T data) {
        return ResponseEntity.status(responseEnum.getHttpStatus()).body(new ResponseTemplate<>(responseEnum.getResponseCode(), responseEnum.getResponseTxt(), data));
    }


    public static ResponseEntity<Object> createResponseError(ResponseEnum responseEnum, Object errors) {
        return ResponseEntity.status(responseEnum.getHttpStatus()).body(new ResponseTemplate<>(responseEnum.getResponseCode(), responseEnum.getResponseTxt(), errors));
    }
}
