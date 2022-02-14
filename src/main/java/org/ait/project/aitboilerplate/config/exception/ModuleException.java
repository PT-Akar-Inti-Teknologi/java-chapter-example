package org.ait.project.aitboilerplate.config.exception;

import lombok.Getter;
import org.ait.project.aitboilerplate.shared.constant.enums.ResponseEnum;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class ModuleException extends RuntimeException {

    private ResponseEnum responseEnum;

    private Object data;

    private String[] argsMessage;

    protected final DecimalFormat df = new DecimalFormat("#,###.00");

    public ModuleException(ResponseEnum responseEnum,Object data, Object...argMessage) {
        super(responseEnum.getMessageTxt());
        this.responseEnum = responseEnum;
        this.data = data;
        processArgsMessage(argMessage);
    }

    private void processArgsMessage(Object...argMessage){
        List<String> messageParams = new ArrayList<>();

        if(argMessage !=null){
            Arrays.asList(argMessage).forEach(param -> {
                if (param instanceof BigDecimal) {
                    df.setParseBigDecimal(true);
                    messageParams.add(df.format(param));
                } else {
                    messageParams.add(String.valueOf(param));
                }
            });
        }

        this.argsMessage = messageParams.toArray(new String[0]);
    }
}
