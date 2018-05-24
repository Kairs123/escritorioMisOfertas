/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misOfertasEscritorio.DAO;

import cl.duoc.misOfertasEscritorio.Entities.Tienda;
import cl.duoc.misOfertasEscritorio.EntitiesController.TiendaJpaController;
import cl.duoc.misOfertasEscritorio.EntitiesController.UsuarioJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author David
 */
public class TiendaDAO {

    private final TiendaJpaController tiendaController;
    private final EntityManagerFactory emf;

    public TiendaDAO() {
        try {
            emf = Persistence.createEntityManagerFactory("misOfertasEscritorioPU");
            tiendaController = new TiendaJpaController(emf);
        } finally {

        }
    }
    public List<Tienda> findAll()
    {
        return tiendaController.findTiendaEntities();
    }
}
