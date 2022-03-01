package org.ait.project.aitboilerplate.modules.customer.exception;

import org.ait.project.aitboilerplate.config.exception.ModuleException;
import org.ait.project.aitboilerplate.shared.constant.enums.ResponseEnum;

public class CustomerNotFoundException extends ModuleException {

    public CustomerNotFoundException(Object... argMessage) {
        super(ResponseEnum.CUSTOMER_NOT_FOUND, null, argMessage);
    }

}
