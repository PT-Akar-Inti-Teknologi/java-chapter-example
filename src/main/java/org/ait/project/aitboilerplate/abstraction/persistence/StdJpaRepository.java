package org.ait.project.aitboilerplate.abstraction.persistence;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * abstraksi Repository untuk Entity yang dimanage oleh AIT,
 * ditandai dengan diextend-nya entity dengan {@link EntityObject}
 * 
 * @author [AIT] Java Chapter Collective
 *
 * @param <T> Class yang meng-extend {@link EntityObject}
 * @param <ID> bentuk/type yang digunakan sebagai {@link Id}
 */
@NoRepositoryBean
public interface StdJpaRepository<T extends EntityObject<ID>, 
                                  ID> 
       extends JpaRepository<T, ID> {

}
