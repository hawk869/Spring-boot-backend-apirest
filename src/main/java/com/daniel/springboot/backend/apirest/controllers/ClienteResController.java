package com.daniel.springboot.backend.apirest.controllers;

import com.daniel.springboot.backend.apirest.models.entity.Cliente;
import com.daniel.springboot.backend.apirest.models.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> show(@PathVariable Long id){
        Cliente cliente = null;
        Map<String, Object> response = new HashMap<>();

        try{
            cliente = clienteService.findById(id);
        }catch(DataAccessException e){
            response.put("Mensaje", "Error al realizar la consulta en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (cliente == null){
            response.put("Mensaje", "El cliente con ID ".concat(id.toString().concat(", no existe en la base de datos!")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> create(@RequestBody Cliente cliente){
        Cliente cliente1 = null;
        Map<String, Object> response = new HashMap<>();

        try{
            cliente1 = clienteService.save(cliente);
        }catch (DataAccessException e){
            response.put("Mensaje", "Error al registrar el cliente en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("Cliente", cliente1);
        response.put("Mensaje:", "El cliente ha sido creado con exito");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente cliente1 = clienteService.findById(id);
        Cliente clienteActualizado = null;
        Map<String, Object> response = new HashMap<>();
        if (cliente1 == null){
            response.put("Mensaje", "Error: no se pudo actualizar el cliente con ID ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try{
            cliente1.setNombre(cliente.getNombre());
            cliente1.setApellido(cliente.getApellido());
            cliente1.setEmail(cliente.getEmail());
            clienteActualizado = clienteService.save(cliente1);
        }catch (DataAccessException e){
            response.put("Mensaje", "Error al actualizar el cliente en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("Cliente", clienteActualizado);
        response.put("Mensaje:", "El cliente ha sido actualizado con exito");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            clienteService.delete(id);
        }catch (DataAccessException e){
            response.put("Mensaje", "Error al eliminar el cliente en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("Mensaje", "El cliente ha sido eliminado con exito");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
