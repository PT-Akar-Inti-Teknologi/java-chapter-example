package org.ait.project.aitboilerplate.shared.utils;

import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.shared.constant.enums.ResponseEnum;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResponseHelpers {

    private final MessagePicker messagePicker;

    public <T> ResponseEntity<ResponseTemplate<T>> createResponse(ResponseEnum responseEnum, T data) {
        return ResponseEntity.status(responseEnum.getHttpStatus()).body(new ResponseTemplate<>(responseEnum.getResponseCode(), messagePicker.getMessage(responseEnum,null), data));
    }


    public ResponseEntity<Object> createResponseError(ResponseEnum responseEnum,String[] argsMessage, Object errors) {
        return ResponseEntity.status(responseEnum.getHttpStatus()).body(new ResponseTemplate<>(responseEnum.getResponseCode(), messagePicker.getMessage(responseEnum,argsMessage),errors));
    }
}
