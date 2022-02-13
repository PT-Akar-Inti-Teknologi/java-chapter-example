package org.ait.project.aitboilerplate.abstraction.service;

import org.ait.project.aitboilerplate.abstraction.presentation.FormObject;

public interface DeletionService<F extends FormObject,
                                 IDTYPE> {
	
    public void deleteByQuery(F request);
	
	public void deleteById(IDTYPE id);

}
