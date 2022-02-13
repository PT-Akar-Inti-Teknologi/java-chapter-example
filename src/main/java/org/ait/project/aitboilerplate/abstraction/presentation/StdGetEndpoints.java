package org.ait.project.aitboilerplate.abstraction.presentation;

import java.util.List;

import javax.persistence.Entity;

import org.ait.project.aitboilerplate.abstraction.service.BusinessObject;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Endpoint-endpoint dasar yang menjadi penerimaan operasi HTTP GET
 * <br/><br/>
 * 
 * perlu diingat bahwa annotation : 
 * <ul>
 *   <li>@{@link GetMapping}</li> 
 *   <li>@ {@link PathVariable}</li>
 * </ul> 
 * harus di-declare di function pada {@link Controller} yang meng-implement ini
 * 
 * @author [AIT] Java Chapter Collective
 *
 * @param <F> class yg extend dari {@link FormObject}
 * @param <IDTYPE> type dari ID yang digunakan oleh {@link Entity} dalam module setempat
 */
public interface StdGetEndpoints<F extends FormObject, 
                                   D extends BusinessObject<IDTYPE>, 
                                   IDTYPE> {
	
	@GetMapping
    public ResponseEntity<ResponseTemplate<D>> getOne(@PathVariable IDTYPE id);
	
	@GetMapping
	public ResponseEntity<ResponseTemplate<Page<D>>> getAllAsPage(Pageable pageable);
	
	@GetMapping
	public ResponseEntity<ResponseTemplate<Page<D>>> queryAsPage(Pageable pageable, @RequestBody F form);
	
	@GetMapping
	public ResponseEntity<ResponseTemplate<List<D>>> getAllAsList();
	
	@GetMapping
	public ResponseEntity<ResponseTemplate<List<D>>> queryAsList(@RequestBody F form);

}
