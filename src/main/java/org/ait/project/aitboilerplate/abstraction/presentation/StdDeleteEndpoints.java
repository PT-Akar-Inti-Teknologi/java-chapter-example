package org.ait.project.aitboilerplate.abstraction.presentation;

import javax.persistence.Id;

import org.ait.project.aitboilerplate.abstraction.persistence.EntityObject;
import org.ait.project.aitboilerplate.abstraction.service.BusinessObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 
 * Endpoint-endpoint dasar yang menjadi penerimaan operasi HTTP DELETE
 * <br/><br/>
 * 
 * perlu diingat bahwa annotation :
 * <ul>
 *   <li>@{@link PostMapping}</li>
 *   <li>@{@link PathVariable} (bila ada)</li>
 * <ul>
 *  
 * harus di-declare di function pada {@link Controller} yang meng-implement ini
 * 
 * @author [AIT] Java Chapter Collective
 *
 */
public interface StdDeleteEndpoints<IDTYPE> {
	
	/**
	 * untuk delete berdasarkan {@link Id}
	 * 
	 * @param id {@link Id} dari 
	 *           {@link BusinessObject} atau {@link EntityObject} 
	 *           yang akan di-delete 
	 * @return sebuah body berisi pesan, minimal HTTP status untuk diteruskan ke FE
	 */
	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable IDTYPE id);
	 

}
