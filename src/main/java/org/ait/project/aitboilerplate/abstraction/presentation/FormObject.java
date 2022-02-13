package org.ait.project.aitboilerplate.abstraction.presentation;

import java.lang.ModuleLayer.Controller;
import java.util.HashMap;
import java.util.Map;

import org.ait.project.aitboilerplate.abstraction.service.BusinessObject;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * Bentuk dari object yang diterima dari client,
 * biasanya menjadi {@link RequestBody}, 
 * yang berada sebagai parameter dalam {@link Controller}.
 * 
 * rule khusus saat extend {@link Class} ini adalah :
 * 1. kalau ada reference ke {@link BusinessObject} lain, 
 *    hanya berikan id-nya yang akan menjadi ForeignKey untuk module setempat 
 * 2. form ini digunakan hanya untuk operasi 
 *    field-field {@link BusinessObject} yang ada pada
 *    module setempat 
 *    
 * yang berada pada module ini
 * 
 * @author [AIT] Java Chapter Collective
 *
 */
@Getter
@Setter
public abstract class FormObject {
	
	/**
	 * field-field "liar" yang di luar persetujuan antara kedua belah pihak
	 */
	private Map<String, String> unmappedFields = new HashMap<>();
	
	@JsonAnyGetter
	public Map<String, String> getUnmappedFields() {
		return this.unmappedFields;
	};
	
	/**
	 * untuk menentukan ada field yang diluar spec atau tidak.
	 * 
	 * contoh penggunaannya adalah 
	 * saat diterima controller dan ingin menuliskan warning di log, 
	 * bahwa ada request diterima yang diluar ketentuan antara FE dan BE
	 * 
	 * @return true apabila ada, false apabila request body sesuai spec
	 */
	@JsonIgnore
	public Boolean hasUnmappedFields() {
		return unmappedFields.isEmpty() ==  false;
	}

}
