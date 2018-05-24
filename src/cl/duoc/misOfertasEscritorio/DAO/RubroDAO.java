/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misOfertasEscritorio.DAO;

import cl.duoc.misOfertasEscritorio.Entities.Rubro;
import cl.duoc.misOfertasEscritorio.EntitiesController.RubroJpaController;
import cl.duoc.misOfertasEscritorio.EntitiesController.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author David
 */
public class RubroDAO {

    private final RubroJpaController rubroController;
    private final EntityManagerFactory emf;

    public RubroDAO() {
        emf = Persistence.createEntityManagerFactory("misOfertasEscritorioPU");
        rubroController = new RubroJpaController(emf);
    }

    public Long getMaxId() {
        return rubroController.getMaxId();
    }

    public List<Rubro> listAll() {
        return rubroController.findRubroEntities();
    }

    public Rubro findByName(String s) {
        return rubroController.findRubro(s);
    }

    public Rubro findById(Long id) {
        return rubroController.findRubro(id);
    }
    public void editRubro(Rubro r) throws NonexistentEntityException, Exception
    {
        rubroController.edit(r);
    }
}
