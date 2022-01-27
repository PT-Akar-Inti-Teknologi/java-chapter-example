package org.ait.project.aitboilerplate.shared.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS("00","Success",HttpStatus.OK),

    DATA_NOT_FOUND("77","Some Param not valid",HttpStatus.NOT_FOUND),
    PARAM_INVALID("88","Some Param not valid",HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR("99","Success",HttpStatus.INTERNAL_SERVER_ERROR),
    ;

    private final String responseCode;
    private final String responseTxt;
    private final HttpStatus httpStatus;
}
