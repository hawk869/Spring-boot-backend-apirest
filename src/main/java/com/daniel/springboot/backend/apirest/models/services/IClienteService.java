package com.daniel.springboot.backend.apirest.models.services;

import com.daniel.springboot.backend.apirest.models.entity.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();
}
