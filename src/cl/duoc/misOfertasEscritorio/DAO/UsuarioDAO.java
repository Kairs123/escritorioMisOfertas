/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misOfertasEscritorio.DAO;

import cl.duoc.misOfertasEscritorio.Entities.Usuario;
import cl.duoc.misOfertasEscritorio.EntitiesController.UsuarioJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author David
 */
public class UsuarioDAO {

    private final UsuarioJpaController usuarioController;
    private final EntityManagerFactory emf;
/**
 * 
 */
    public UsuarioDAO() {
        try {
            emf = Persistence.createEntityManagerFactory("misOfertasEscritorioPU");
            usuarioController = new UsuarioJpaController(emf);
        } finally {

        }
    }

    public Usuario findByCredential(String username, String passw) {
        return usuarioController.findUsuario(username, passw);
    }
}
