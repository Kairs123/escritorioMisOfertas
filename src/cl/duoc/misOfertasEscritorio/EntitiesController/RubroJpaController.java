/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misOfertasEscritorio.EntitiesController;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cl.duoc.misOfertasEscritorio.Entities.Tienda;
import cl.duoc.misOfertasEscritorio.Entities.Producto;
import java.util.ArrayList;
import java.util.List;
import cl.duoc.misOfertasEscritorio.Entities.PrefRubroUsuario;
import cl.duoc.misOfertasEscritorio.Entities.Rubro;
import cl.duoc.misOfertasEscritorio.EntitiesController.exceptions.IllegalOrphanException;
import cl.duoc.misOfertasEscritorio.EntitiesController.exceptions.NonexistentEntityException;
import cl.duoc.misOfertasEscritorio.EntitiesController.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author David
 */
public class RubroJpaController implements Serializable {

    public RubroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rubro rubro) throws PreexistingEntityException, Exception {
        if (rubro.getProductoList() == null) {
            rubro.setProductoList(new ArrayList<Producto>());
        }
        if (rubro.getPrefRubroUsuarioList() == null) {
            rubro.setPrefRubroUsuarioList(new ArrayList<PrefRubroUsuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tienda tiendaId = rubro.getTiendaId();
            if (tiendaId != null) {
                tiendaId = em.getReference(tiendaId.getClass(), tiendaId.getIdTienda());
                rubro.setTiendaId(tiendaId);
            }
            List<Producto> attachedProductoList = new ArrayList<Producto>();
            for (Producto productoListProductoToAttach : rubro.getProductoList()) {
                productoListProductoToAttach = em.getReference(productoListProductoToAttach.getClass(), productoListProductoToAttach.getIdProducto());
                attachedProductoList.add(productoListProductoToAttach);
            }
            rubro.setProductoList(attachedProductoList);
            List<PrefRubroUsuario> attachedPrefRubroUsuarioList = new ArrayList<PrefRubroUsuario>();
            for (PrefRubroUsuario prefRubroUsuarioListPrefRubroUsuarioToAttach : rubro.getPrefRubroUsuarioList()) {
                prefRubroUsuarioListPrefRubroUsuarioToAttach = em.getReference(prefRubroUsuarioListPrefRubroUsuarioToAttach.getClass(), prefRubroUsuarioListPrefRubroUsuarioToAttach.getIdPrefRubro());
                attachedPrefRubroUsuarioList.add(prefRubroUsuarioListPrefRubroUsuarioToAttach);
            }
            rubro.setPrefRubroUsuarioList(attachedPrefRubroUsuarioList);
            em.persist(rubro);
            if (tiendaId != null) {
                tiendaId.getRubroList().add(rubro);
                tiendaId = em.merge(tiendaId);
            }
            for (Producto productoListProducto : rubro.getProductoList()) {
                Rubro oldRubroIdOfProductoListProducto = productoListProducto.getRubroId();
                productoListProducto.setRubroId(rubro);
                productoListProducto = em.merge(productoListProducto);
                if (oldRubroIdOfProductoListProducto != null) {
                    oldRubroIdOfProductoListProducto.getProductoList().remove(productoListProducto);
                    oldRubroIdOfProductoListProducto = em.merge(oldRubroIdOfProductoListProducto);
                }
            }
            for (PrefRubroUsuario prefRubroUsuarioListPrefRubroUsuario : rubro.getPrefRubroUsuarioList()) {
                Rubro oldRubroIdOfPrefRubroUsuarioListPrefRubroUsuario = prefRubroUsuarioListPrefRubroUsuario.getRubroId();
                prefRubroUsuarioListPrefRubroUsuario.setRubroId(rubro);
                prefRubroUsuarioListPrefRubroUsuario = em.merge(prefRubroUsuarioListPrefRubroUsuario);
                if (oldRubroIdOfPrefRubroUsuarioListPrefRubroUsuario != null) {
                    oldRubroIdOfPrefRubroUsuarioListPrefRubroUsuario.getPrefRubroUsuarioList().remove(prefRubroUsuarioListPrefRubroUsuario);
                    oldRubroIdOfPrefRubroUsuarioListPrefRubroUsuario = em.merge(oldRubroIdOfPrefRubroUsuarioListPrefRubroUsuario);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRubro(rubro.getIdRubro()) != null) {
                throw new PreexistingEntityException("Rubro " + rubro + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rubro rubro) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rubro persistentRubro = em.find(Rubro.class, rubro.getIdRubro());
            Tienda tiendaIdOld = persistentRubro.getTiendaId();
            Tienda tiendaIdNew = rubro.getTiendaId();
            List<Producto> productoListOld = persistentRubro.getProductoList();
            List<Producto> productoListNew = rubro.getProductoList();
            List<PrefRubroUsuario> prefRubroUsuarioListOld = persistentRubro.getPrefRubroUsuarioList();
            List<PrefRubroUsuario> prefRubroUsuarioListNew = rubro.getPrefRubroUsuarioList();
            List<String> illegalOrphanMessages = null;
            for (Producto productoListOldProducto : productoListOld) {
                if (!productoListNew.contains(productoListOldProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producto " + productoListOldProducto + " since its rubroId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (tiendaIdNew != null) {
                tiendaIdNew = em.getReference(tiendaIdNew.getClass(), tiendaIdNew.getIdTienda());
                rubro.setTiendaId(tiendaIdNew);
            }
            List<Producto> attachedProductoListNew = new ArrayList<Producto>();
            for (Producto productoListNewProductoToAttach : productoListNew) {
                productoListNewProductoToAttach = em.getReference(productoListNewProductoToAttach.getClass(), productoListNewProductoToAttach.getIdProducto());
                attachedProductoListNew.add(productoListNewProductoToAttach);
            }
            productoListNew = attachedProductoListNew;
            rubro.setProductoList(productoListNew);
            List<PrefRubroUsuario> attachedPrefRubroUsuarioListNew = new ArrayList<PrefRubroUsuario>();
            for (PrefRubroUsuario prefRubroUsuarioListNewPrefRubroUsuarioToAttach : prefRubroUsuarioListNew) {
                prefRubroUsuarioListNewPrefRubroUsuarioToAttach = em.getReference(prefRubroUsuarioListNewPrefRubroUsuarioToAttach.getClass(), prefRubroUsuarioListNewPrefRubroUsuarioToAttach.getIdPrefRubro());
                attachedPrefRubroUsuarioListNew.add(prefRubroUsuarioListNewPrefRubroUsuarioToAttach);
            }
            prefRubroUsuarioListNew = attachedPrefRubroUsuarioListNew;
            rubro.setPrefRubroUsuarioList(prefRubroUsuarioListNew);
            rubro = em.merge(rubro);
            if (tiendaIdOld != null && !tiendaIdOld.equals(tiendaIdNew)) {
                tiendaIdOld.getRubroList().remove(rubro);
                tiendaIdOld = em.merge(tiendaIdOld);
            }
            if (tiendaIdNew != null && !tiendaIdNew.equals(tiendaIdOld)) {
                tiendaIdNew.getRubroList().add(rubro);
                tiendaIdNew = em.merge(tiendaIdNew);
            }
            for (Producto productoListNewProducto : productoListNew) {
                if (!productoListOld.contains(productoListNewProducto)) {
                    Rubro oldRubroIdOfProductoListNewProducto = productoListNewProducto.getRubroId();
                    productoListNewProducto.setRubroId(rubro);
                    productoListNewProducto = em.merge(productoListNewProducto);
                    if (oldRubroIdOfProductoListNewProducto != null && !oldRubroIdOfProductoListNewProducto.equals(rubro)) {
                        oldRubroIdOfProductoListNewProducto.getProductoList().remove(productoListNewProducto);
                        oldRubroIdOfProductoListNewProducto = em.merge(oldRubroIdOfProductoListNewProducto);
                    }
                }
            }
            for (PrefRubroUsuario prefRubroUsuarioListOldPrefRubroUsuario : prefRubroUsuarioListOld) {
                if (!prefRubroUsuarioListNew.contains(prefRubroUsuarioListOldPrefRubroUsuario)) {
                    prefRubroUsuarioListOldPrefRubroUsuario.setRubroId(null);
                    prefRubroUsuarioListOldPrefRubroUsuario = em.merge(prefRubroUsuarioListOldPrefRubroUsuario);
                }
            }
            for (PrefRubroUsuario prefRubroUsuarioListNewPrefRubroUsuario : prefRubroUsuarioListNew) {
                if (!prefRubroUsuarioListOld.contains(prefRubroUsuarioListNewPrefRubroUsuario)) {
                    Rubro oldRubroIdOfPrefRubroUsuarioListNewPrefRubroUsuario = prefRubroUsuarioListNewPrefRubroUsuario.getRubroId();
                    prefRubroUsuarioListNewPrefRubroUsuario.setRubroId(rubro);
                    prefRubroUsuarioListNewPrefRubroUsuario = em.merge(prefRubroUsuarioListNewPrefRubroUsuario);
                    if (oldRubroIdOfPrefRubroUsuarioListNewPrefRubroUsuario != null && !oldRubroIdOfPrefRubroUsuarioListNewPrefRubroUsuario.equals(rubro)) {
                        oldRubroIdOfPrefRubroUsuarioListNewPrefRubroUsuario.getPrefRubroUsuarioList().remove(prefRubroUsuarioListNewPrefRubroUsuario);
                        oldRubroIdOfPrefRubroUsuarioListNewPrefRubroUsuario = em.merge(oldRubroIdOfPrefRubroUsuarioListNewPrefRubroUsuario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = rubro.getIdRubro();
                if (findRubro(id) == null) {
                    throw new NonexistentEntityException("The rubro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rubro rubro;
            try {
                rubro = em.getReference(Rubro.class, id);
                rubro.getIdRubro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rubro with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Producto> productoListOrphanCheck = rubro.getProductoList();
            for (Producto productoListOrphanCheckProducto : productoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Rubro (" + rubro + ") cannot be destroyed since the Producto " + productoListOrphanCheckProducto + " in its productoList field has a non-nullable rubroId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Tienda tiendaId = rubro.getTiendaId();
            if (tiendaId != null) {
                tiendaId.getRubroList().remove(rubro);
                tiendaId = em.merge(tiendaId);
            }
            List<PrefRubroUsuario> prefRubroUsuarioList = rubro.getPrefRubroUsuarioList();
            for (PrefRubroUsuario prefRubroUsuarioListPrefRubroUsuario : prefRubroUsuarioList) {
                prefRubroUsuarioListPrefRubroUsuario.setRubroId(null);
                prefRubroUsuarioListPrefRubroUsuario = em.merge(prefRubroUsuarioListPrefRubroUsuario);
            }
            em.remove(rubro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rubro> findRubroEntities() {
        return findRubroEntities(true, -1, -1);
    }

    public List<Rubro> findRubroEntities(int maxResults, int firstResult) {
        return findRubroEntities(false, maxResults, firstResult);
    }

    private List<Rubro> findRubroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rubro.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Rubro findRubro(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rubro.class, id);
        } finally {
            em.close();
        }
    }
    public Long getMaxId() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        return em.createNamedQuery("Rubro.getMaxId",Long.class).getSingleResult();
    }

    public Rubro findRubro(String name) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Rubro.findByNombreRubro", Rubro.class);
        q.setParameter(
                "nombreRubro", name);
        return (Rubro) q.getSingleResult();
    }

    public int getRubroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rubro> rt = cq.from(Rubro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
