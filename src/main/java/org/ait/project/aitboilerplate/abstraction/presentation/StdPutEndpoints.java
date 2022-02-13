package org.ait.project.aitboilerplate.abstraction.presentation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;

import org.ait.project.aitboilerplate.abstraction.service.BusinessObject;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Endpoint-endpoint dasar yang menjadi penerimaan operasi HTTP PUT
 * <br/><br/>
 * 
 * perlu diingat bahwa annotation : 
 * <ul>
 *   <li>@{@link PutMapping}</li> 
 *   <li>@{@link Valid} dan @{@link RequestBody}</li>
 *   <li>@ {@link PathVariable}</li>
 * </ul> 
 * harus di-declare di function pada {@link Controller} yang meng-implement ini
 * 
 * @author [AIT] Java Chapter Collective
 *
 * @param <F> class yg extend dari {@link FormObject}
 * @param <IDTYPE> type dari ID yang digunakan oleh {@link Entity} dalam module setempat
 */
public interface StdPutEndpoints<F extends FormObject, IDTYPE> {

	/**
	 * 
	 * @param form {@link FormObject} berisi pengajuan update pada 
	 * @param id {@link Id} dari {@link Entity} atau {@link BusinessObject} yang akan diupdate
	 * @return hasil update dari entity tersebut
	 */
	@PutMapping
	public ResponseEntity<ResponseTemplate<?>> update(@RequestBody @Valid F form, IDTYPE id);

}
