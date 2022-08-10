package com.daniel.springboot.backend.apirest.models.dao;

import com.daniel.springboot.backend.apirest.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {

    public Usuario findByUsername(String usename);
}
