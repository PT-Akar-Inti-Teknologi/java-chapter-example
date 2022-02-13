package org.ait.project.aitboilerplate.abstraction.presentation;

import javax.validation.Valid;

import org.ait.project.aitboilerplate.abstraction.service.BusinessObject;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 
 * Endpoint-endpoint dasar yang menjadi penerimaan operasi HTTP POST
 * <br/><br/>
 * 
 * perlu diingat bahwa annotation :
 * <ul>
 *   <li>@{@link PostMapping}</li>
 *   <li>@{@link Valid} dan @{@link RequestBody}</li>
 *   <li>@{@link PathVariable} (bila ada)</li>
 * <ul>
 *  
 * harus di-declare di function pada {@link Controller} yang meng-implement ini
 * 
 * @author [AIT] Java Chapter Collective
 *
 */
public interface StdPostEndpoints<F extends FormObject, 
                                  D extends BusinessObject<?>> {
	
	@PostMapping
	public ResponseEntity<ResponseTemplate<D>> createNew(@RequestBody @Valid F form);
	
	

}
