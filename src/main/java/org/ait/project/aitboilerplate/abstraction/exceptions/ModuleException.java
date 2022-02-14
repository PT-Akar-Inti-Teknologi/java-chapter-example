package org.ait.project.aitboilerplate.abstraction.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.Getter;

/**
 * 
 * kerangka exception untuk implementasi {@link ControllerAdvice} {@link ExceptionHandler} per-module
 * 
 * urutan extendnya adalah sebagai berikut :
 * 
 * <ol>
 *   <li> {@link ModuleException} </li>
 *   <li> Class exception untuk module setempat (cth : OrderModuleException extends ModuleException)</li>
 *   <li> Class exception untuk delik/kejadian (cth : InsufficientBalanceException extends OrderModuleException</li>
 * </ol>
 *
 * @author [AIT] Java Chapter Collective
 *
 */
public abstract class ModuleException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	protected List<Object> messageParameters =  new ArrayList<>();

	public ModuleException(String messageCode, Object...messageParameters) {
		super(messageCode);
		for (Object messageParameter : messageParameters) {
			addMessageParameter(messageParameter);
		}
	}
	
	/**
	 * digunakan di dalam constructor untuk mem-populate message parameters,
	 * agar dapat nantinya digunakan untuk me-resolve message di {@link ModuleExceptionControllerAdvice}.
	 * 
	 * @param messageParameter tambahan parameter untuk message yang berparameter
	 */
	private void addMessageParameter(Object messageParameter) {
		messageParameters.add(messageParameter);
	};
	
	

}
