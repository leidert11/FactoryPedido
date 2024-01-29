package com.factoryPedido.tiendaOnline.controller;

import com.factoryPedido.tiendaOnline.model.Factura;
import com.factoryPedido.tiendaOnline.model.DAO.Operaciones.FacturaDao;

import java.util.List;

public class ControllerFactura {

    private FacturaDao facturaDao;

    public ControllerFactura() {
        this.facturaDao = new FacturaDao(); // Puedes manejar la creación de FacturaDao como mejor se adapte a tu aplicación.
    }

    public void insertarFactura(Factura factura) {
        facturaDao.insertar(factura);
    }

    public void actualizarFactura(Factura factura) {
        facturaDao.actualizar(factura);
    }

    public void eliminarFactura(int id) {
        Factura factura = new Factura();
        factura.setId(id);
        facturaDao.eliminar(factura);
    }

    public Factura buscarFactura(int id) {
        return facturaDao.buscar(id);
    }

    public List<Factura> obtenerTodasLasFacturas() {
        // Este método dependerá de cómo has implementado tu FacturaDao para obtener todas las facturas.
        return facturaDao.obtenerTodasLasFacturas();
    }
}
