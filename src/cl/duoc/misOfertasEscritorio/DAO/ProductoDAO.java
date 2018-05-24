/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misOfertasEscritorio.DAO;

import cl.duoc.misOfertasEscritorio.Entities.Producto;
import cl.duoc.misOfertasEscritorio.EntitiesController.ProductoJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author David
 */
public class ProductoDAO {

    private final ProductoJpaController productoController;
    private final EntityManagerFactory emf;

    public ProductoDAO() {
        emf = Persistence.createEntityManagerFactory("misOfertasEscritorioPU");
        productoController = new ProductoJpaController(emf);
    }

    public void addProducto(Producto producto) throws Exception {
        productoController.create(producto);
    }

    public Long getMaxId() {
        return productoController.getMaxId();
    }

    public void editProducto(Producto producto) throws Exception {
        productoController.edit(producto);
    }

    public Producto findById(Long idProducto) {
        return productoController.findProducto(idProducto);
    }

    public List<Producto> listAll() {
        return productoController.findProductoEntities();
    }
    public Producto findProducto(Long idProducto)
    {
        return productoController.findProducto(idProducto);
    }

}
