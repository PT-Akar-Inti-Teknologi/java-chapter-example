package org.ait.project.aitboilerplate.abstraction.service;

import java.util.List;

import org.ait.project.aitboilerplate.abstraction.presentation.FormObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 
 * function-function dasar Create dan Read dari sebuah {@link Service} dalam module.
 * di-implement oleh service yang menjadi penengah 
 * antara {@link Controller} dengan {@link Repository}  
 * 
 * @author [AIT] Java Chapter Collective
 *
 * @param <F> terimaan dari {@link Controller} dalam bentuk {@link FormObject}. 
 *            dapat menggunakan ? sebagai parameter apabila belum ada
 *            implementasi {@link Controller} untuk modul tersebut 
 * @param <D> yang dapat {@link Service} berikan dalam bentuk  {@link BusinessObject}
 * @param <IDTYPE> tipe id/Primary Key yang digunakan oleh entity
 */
public interface CreateAndReadService<F extends FormObject,
                                      D extends BusinessObject<?>,
                                      IDTYPE> {
	
	public D create(F request);
	
	public D readOneById(IDTYPE id);
	
	public List<D> readAll();
	
	public List<D> readByQuery(F request);
	
	public Page<D> readAllPaginated(Pageable pageable);
	
	public Page<D> readByQueryPaginated(F request, Pageable pageable);
	
}
