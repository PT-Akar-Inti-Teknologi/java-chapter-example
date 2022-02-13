package org.ait.project.aitboilerplate.abstraction.service;

import org.ait.project.aitboilerplate.abstraction.presentation.FormObject;

public interface UpdateService<F extends FormObject, 
                               D extends BusinessObject<IDTYPE>,
                               IDTYPE> {
	
	public D update(F request, IDTYPE primaryKey);

}
