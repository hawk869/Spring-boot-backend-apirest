package com.daniel.springboot.backend.apirest.models.dao;

import com.daniel.springboot.backend.apirest.models.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDAO extends CrudRepository<Factura, Long> {
}
