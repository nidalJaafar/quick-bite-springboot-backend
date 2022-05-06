package com.quickbite.backend.common.service;

import com.quickbite.backend.common.response.CollectionResponse;

/** Main interface for all crud services <br/>
 * <strong>T</strong>: Response <br/>
 * <strong>E</strong>: entity <br/>
 * <strong>D</strong>: dto <br/>
 * <strong>R</strong>: request <br/>
 * */
public interface CrudService<T, E, D, R> {

  T getEntity(Integer id);

  CollectionResponse<D> getEntities();

  T createEntity(R request);

  T updateEntity(R request, Integer id);

  T deleteEntity(Integer id);

  E init(R request, E entity);

}
