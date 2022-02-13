package org.ait.project.aitboilerplate.abstraction.exceptions;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 
 * kerangka untuk guideline/petunjuk implementasi bean {@link ControllerAdvice} per module.  
 *
 * @author [AIT] Java Chapter Collective
 *
 * @param <E> class yg meng-extend {@link ModuleException}. 
 */
public abstract class ModuleExceptionHandler<E extends ModuleException> {
	
	@Autowired
	private MessageSource messageSource;
	
	protected final DecimalFormat df;
	
	public ModuleExceptionHandler() {
		super();
		this.df = new DecimalFormat("#,###.00");
		this.df.setParseBigDecimal(true);
	}

	protected final String resolveMessage(ModuleException exception) {
		
		List<Object> params = exception.getMessageParameters();
		
		List<String> messageParams = new ArrayList<>();
		
		params.forEach(param -> {
			if (param instanceof BigDecimal) {
				
				messageParams.add(df.format((BigDecimal) param));
				
			} else {
				
				messageParams.add(String.valueOf(param));
				
			}
		});
		
		return messageSource.getMessage(exception.getMessage(), 
				                        messageParams.toArray(), 
				                        Locale.getDefault());
	}
	
	protected final String resolveMessage(String messageCode) {
		return messageSource.getMessage(messageCode, null, Locale.getDefault());
	}

}
