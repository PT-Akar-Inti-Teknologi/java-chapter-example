package org.ait.project.aitboilerplate.abstraction.exceptions;

import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.springframework.http.ResponseEntity;

public abstract interface ModuleExceptionHandler<E extends ModuleException> {

	public ResponseEntity<Object> handleException(E exception);
}
