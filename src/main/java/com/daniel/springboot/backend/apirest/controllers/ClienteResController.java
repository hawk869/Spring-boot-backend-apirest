package com.daniel.springboot.backend.apirest.controllers;

import com.daniel.springboot.backend.apirest.models.entity.Cliente;
import com.daniel.springboot.backend.apirest.models.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController @RequestMapping("/api")
public class ClienteResController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @PostMapping("/clientes") @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/{id}") @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente cliente1 = clienteService.findById(id);
        cliente1.setNombre(cliente.getNombre());
        cliente1.setApellido(cliente.getApellido());
        cliente1.setEmail(cliente.getEmail());
        return clienteService.save(cliente1);
    }

    @DeleteMapping("/clientes/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }
}
