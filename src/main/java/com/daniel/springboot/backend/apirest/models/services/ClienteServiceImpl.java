package com.daniel.springboot.backend.apirest.models.services;

import com.daniel.springboot.backend.apirest.models.dao.IClienteDao;
import com.daniel.springboot.backend.apirest.models.dao.IFacturaDAO;
import com.daniel.springboot.backend.apirest.models.dao.IProductoDAO;
import com.daniel.springboot.backend.apirest.models.entity.Cliente;
import com.daniel.springboot.backend.apirest.models.entity.Factura;
import com.daniel.springboot.backend.apirest.models.entity.Producto;
import com.daniel.springboot.backend.apirest.models.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;
    @Autowired
    private IFacturaDAO facturaDAO;
    @Autowired
    private IProductoDAO productoDAO;

    @Override @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }

    @Override @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Region> findAllRegiones() {
        return clienteDao.findAllRegiones();
    }

    @Override @Transactional(readOnly = true)
    public Factura findFacturaById(Long id) {
        return facturaDAO.findById(id).orElse(null);
    }

    @Override @Transactional
    public Factura saveFactura(Factura factura) {
        return facturaDAO.save(factura);
    }

    @Override @Transactional
    public void deleteFacturaById(Long id) {
        facturaDAO.deleteById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Producto> findProductoByNombre(String term) {
        return productoDAO.findByNombreContainingIgnoreCase(term);
    }
}
