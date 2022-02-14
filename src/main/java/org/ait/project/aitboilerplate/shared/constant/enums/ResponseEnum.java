package org.ait.project.aitboilerplate.shared.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS("00","success",HttpStatus.OK),

    CUSTOMER_NOT_FOUND("66","response.customer-not-found",HttpStatus.NOT_FOUND),
    DATA_NOT_FOUND("77","response.data-not-found",HttpStatus.NOT_FOUND),
    PARAM_INVALID("88","response.param-invalid",HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR("99","respone.internal-server-error",HttpStatus.INTERNAL_SERVER_ERROR),
    ;

    private final String responseCode;
    private final String messageTxt;
    private final HttpStatus httpStatus;
}
