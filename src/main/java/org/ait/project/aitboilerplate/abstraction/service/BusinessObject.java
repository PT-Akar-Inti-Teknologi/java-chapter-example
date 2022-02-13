package org.ait.project.aitboilerplate.abstraction.service;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

/**
 * Bentuk object yang hidup di {@link Service} layer, 
 * dapat dimanipulasi/diolah sesuai business requirements.
 * 
 * Bisa juga dibilang sebagai Business Object
 * 
 * @author [AIT] Java Chapter Collective
 *
 */
@Getter
@Setter
public abstract class BusinessObject<IDTYPE> {
	
	private IDTYPE id;

}
