package org.ait.project.aitboilerplate.shared.utils;

import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.shared.constant.enums.ResponseEnum;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class MessagePicker {
    private final MessageSource messageSource;

    public String getMessage(ResponseEnum responseEnum,String[] args){
        return messageSource.getMessage(responseEnum.getMessageTxt(),
                args,
                Locale.getDefault());
    }
}
