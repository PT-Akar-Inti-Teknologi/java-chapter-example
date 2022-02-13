package org.ait.project.aitboilerplate.abstraction.transform;

import java.util.List;

import org.ait.project.aitboilerplate.abstraction.persistence.EntityObject;
import org.ait.project.aitboilerplate.abstraction.presentation.FormObject;
import org.ait.project.aitboilerplate.abstraction.service.BusinessObject;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * abstract Mapper untuk di-extend oleh Mapper yang digunakan pada modul setempat  
 *
 * @author [AIT] Java Chapter Collective
 *
 * @param <F> type yang extend dari {@link FormObject}
 * @param <D> type yang extend dari {@link BusinessObject}
 * @param <E> type yang extend dari {@link EntityObject}
 */
public abstract interface AbstractMapper<F extends FormObject,
                                         D extends BusinessObject<?>,
                                         E extends EntityObject<?>> {
	
	// Inward
	/**
	 * digunakan untuk merubah terimaan dari endpoint, 
	 * yang masih berbentuk {@link FormObject}
	 * menjadi {@link BusinessObject} 
	 * @param sourceForm object {@link FormObject} yang diterima dari endpoint di {@link Controller}
	 * @return {@link BusinessObject} yang akan digunakan dalam {@link Service} layer
	 */
	public D fromFormToBusinessObject(F sourceForm);
	
	/**
	 * digunakan untuk mengkemas {@link BusinessObject}
	 * menjadi {@link EntityObject}
	 * yang selanjutnya disimpan kedalam {@link Repository}.
	 *  
	 * @param source {@link BusinessObject} yang sudah diproses di {@link Service} layer
	 * @return {@link EntityObject} yang siap disave ke {@link Repository}
	 */
	public E fromBusinessObjectToEntity(D source);
	
	public List<E> fromBusinessObjectToEntity(List<D> source);
	
	
	// Outward
	/**
	 * Digunakan untuk merubah 
	 * sebuah {@link EntityObject} 
	 * menjadi {@link BusinessObject}
	 * agar selanjutnya dilakukan manipulasi berdasarkan business proccess 
	 * @param sourceEntity
	 * @return
	 */
	public D fromEntityToBusinessObject(E sourceEntity);
	
	public List<D> fromEntityToBusinessObject(List<E> sourceEntity);
	
	/**
	 * Digunakan untuk memberikan form Update ke FE
	 * 
	 * @param source {@link BusinessObject} yang akan dilempar ke FE
	 * @return object dalam bentuk {@link FormObject}
	 */
	public F fromBusinessObjectToForm(D source);
	

}
