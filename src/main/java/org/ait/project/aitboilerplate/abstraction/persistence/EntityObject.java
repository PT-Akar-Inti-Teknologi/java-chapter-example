package org.ait.project.aitboilerplate.abstraction.persistence;

import javax.persistence.Entity;

import lombok.Getter;

/**
 * object {@link Entity} standar 
 * di Persistence layer pada module setempat
 *  
 * 
 * @author [AIT] Java Chapter Collective
 *
 * @param <IDTYPE>
 */
@Getter
public abstract class EntityObject<IDTYPE> {
	
	private IDTYPE id;

}
