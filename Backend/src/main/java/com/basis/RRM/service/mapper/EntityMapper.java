package com.basis.RRM.service.mapper;

import java.util.List;

public interface EntityMapper<D, E>{

    E toEntity(D dto);

    E toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

}
