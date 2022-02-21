package org.ait.project.aitboilerplate.modules.customer.exception;

import org.ait.project.aitboilerplate.config.exception.ModuleException;
import org.ait.project.aitboilerplate.shared.constant.enums.ResponseEnum;

public class CustomerException extends ModuleException {

    public CustomerException(ResponseEnum enums, Object... argMessage) {
        super(enums, null, argMessage);
    }

}
