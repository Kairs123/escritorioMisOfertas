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
import cl.duoc.misOfertasEscritorio.Entities.Rubro;
import cl.duoc.misOfertasEscritorio.Entities.Valoracion;
import java.util.ArrayList;
import java.util.List;
import cl.duoc.misOfertasEscritorio.Entities.Oferta;
import cl.duoc.misOfertasEscritorio.Entities.DescuentoEmitido;
import cl.duoc.misOfertasEscritorio.Entities.Producto;
import cl.duoc.misOfertasEscritorio.EntitiesController.exceptions.IllegalOrphanException;
import cl.duoc.misOfertasEscritorio.EntitiesController.exceptions.NonexistentEntityException;
import cl.duoc.misOfertasEscritorio.EntitiesController.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author David
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) throws PreexistingEntityException, Exception {
        if (producto.getValoracionList() == null) {
            producto.setValoracionList(new ArrayList<Valoracion>());
        }
        if (producto.getOfertaList() == null) {
            producto.setOfertaList(new ArrayList<Oferta>());
        }
        if (producto.getDescuentoEmitidoList() == null) {
            producto.setDescuentoEmitidoList(new ArrayList<DescuentoEmitido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rubro rubroId = producto.getRubroId();
            if (rubroId != null) {
                rubroId = em.getReference(rubroId.getClass(), rubroId.getIdRubro());
                producto.setRubroId(rubroId);
            }
            List<Valoracion> attachedValoracionList = new ArrayList<Valoracion>();
            for (Valoracion valoracionListValoracionToAttach : producto.getValoracionList()) {
                valoracionListValoracionToAttach = em.getReference(valoracionListValoracionToAttach.getClass(), valoracionListValoracionToAttach.getValoracionId());
                attachedValoracionList.add(valoracionListValoracionToAttach);
            }
            producto.setValoracionList(attachedValoracionList);
            List<Oferta> attachedOfertaList = new ArrayList<Oferta>();
            for (Oferta ofertaListOfertaToAttach : producto.getOfertaList()) {
                ofertaListOfertaToAttach = em.getReference(ofertaListOfertaToAttach.getClass(), ofertaListOfertaToAttach.getIdOferta());
                attachedOfertaList.add(ofertaListOfertaToAttach);
            }
            producto.setOfertaList(attachedOfertaList);
            List<DescuentoEmitido> attachedDescuentoEmitidoList = new ArrayList<DescuentoEmitido>();
            for (DescuentoEmitido descuentoEmitidoListDescuentoEmitidoToAttach : producto.getDescuentoEmitidoList()) {
                descuentoEmitidoListDescuentoEmitidoToAttach = em.getReference(descuentoEmitidoListDescuentoEmitidoToAttach.getClass(), descuentoEmitidoListDescuentoEmitidoToAttach.getDescuentoId());
                attachedDescuentoEmitidoList.add(descuentoEmitidoListDescuentoEmitidoToAttach);
            }
            producto.setDescuentoEmitidoList(attachedDescuentoEmitidoList);
            persistProducto(producto, em);
            if (rubroId != null) {
                rubroId.getProductoList().add(producto);
                rubroId = em.merge(rubroId);
            }
            for (Valoracion valoracionListValoracion : producto.getValoracionList()) {
                Producto oldProductoIdOfValoracionListValoracion = valoracionListValoracion.getProductoId();
                valoracionListValoracion.setProductoId(producto);
                valoracionListValoracion = em.merge(valoracionListValoracion);
                if (oldProductoIdOfValoracionListValoracion != null) {
                    oldProductoIdOfValoracionListValoracion.getValoracionList().remove(valoracionListValoracion);
                    oldProductoIdOfValoracionListValoracion = em.merge(oldProductoIdOfValoracionListValoracion);
                }
            }
            for (Oferta ofertaListOferta : producto.getOfertaList()) {
                Producto oldProductoIdOfOfertaListOferta = ofertaListOferta.getProductoId();
                ofertaListOferta.setProductoId(producto);
                ofertaListOferta = em.merge(ofertaListOferta);
                if (oldProductoIdOfOfertaListOferta != null) {
                    oldProductoIdOfOfertaListOferta.getOfertaList().remove(ofertaListOferta);
                    oldProductoIdOfOfertaListOferta = em.merge(oldProductoIdOfOfertaListOferta);
                }
            }
            for (DescuentoEmitido descuentoEmitidoListDescuentoEmitido : producto.getDescuentoEmitidoList()) {
                Producto oldProductoIdOfDescuentoEmitidoListDescuentoEmitido = descuentoEmitidoListDescuentoEmitido.getProductoId();
                descuentoEmitidoListDescuentoEmitido.setProductoId(producto);
                descuentoEmitidoListDescuentoEmitido = em.merge(descuentoEmitidoListDescuentoEmitido);
                if (oldProductoIdOfDescuentoEmitidoListDescuentoEmitido != null) {
                    oldProductoIdOfDescuentoEmitidoListDescuentoEmitido.getDescuentoEmitidoList().remove(descuentoEmitidoListDescuentoEmitido);
                    oldProductoIdOfDescuentoEmitidoListDescuentoEmitido = em.merge(oldProductoIdOfDescuentoEmitidoListDescuentoEmitido);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProducto(producto.getIdProducto()) != null) {
                throw new PreexistingEntityException("Producto " + producto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            Rubro rubroIdOld = persistentProducto.getRubroId();
            Rubro rubroIdNew = producto.getRubroId();
            List<Valoracion> valoracionListOld = persistentProducto.getValoracionList();
            List<Valoracion> valoracionListNew = producto.getValoracionList();
            List<Oferta> ofertaListOld = persistentProducto.getOfertaList();
            List<Oferta> ofertaListNew = producto.getOfertaList();
            List<DescuentoEmitido> descuentoEmitidoListOld = persistentProducto.getDescuentoEmitidoList();
            List<DescuentoEmitido> descuentoEmitidoListNew = producto.getDescuentoEmitidoList();
            List<String> illegalOrphanMessages = null;
            for (Valoracion valoracionListOldValoracion : valoracionListOld) {
                if (!valoracionListNew.contains(valoracionListOldValoracion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Valoracion " + valoracionListOldValoracion + " since its productoId field is not nullable.");
                }
            }
            for (Oferta ofertaListOldOferta : ofertaListOld) {
                if (!ofertaListNew.contains(ofertaListOldOferta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Oferta " + ofertaListOldOferta + " since its productoId field is not nullable.");
                }
            }
            for (DescuentoEmitido descuentoEmitidoListOldDescuentoEmitido : descuentoEmitidoListOld) {
                if (!descuentoEmitidoListNew.contains(descuentoEmitidoListOldDescuentoEmitido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DescuentoEmitido " + descuentoEmitidoListOldDescuentoEmitido + " since its productoId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (rubroIdNew != null) {
                rubroIdNew = em.getReference(rubroIdNew.getClass(), rubroIdNew.getIdRubro());
                producto.setRubroId(rubroIdNew);
            }
            List<Valoracion> attachedValoracionListNew = new ArrayList<Valoracion>();
            for (Valoracion valoracionListNewValoracionToAttach : valoracionListNew) {
                valoracionListNewValoracionToAttach = em.getReference(valoracionListNewValoracionToAttach.getClass(), valoracionListNewValoracionToAttach.getValoracionId());
                attachedValoracionListNew.add(valoracionListNewValoracionToAttach);
            }
            valoracionListNew = attachedValoracionListNew;
            producto.setValoracionList(valoracionListNew);
            List<Oferta> attachedOfertaListNew = new ArrayList<Oferta>();
            for (Oferta ofertaListNewOfertaToAttach : ofertaListNew) {
                ofertaListNewOfertaToAttach = em.getReference(ofertaListNewOfertaToAttach.getClass(), ofertaListNewOfertaToAttach.getIdOferta());
                attachedOfertaListNew.add(ofertaListNewOfertaToAttach);
            }
            ofertaListNew = attachedOfertaListNew;
            producto.setOfertaList(ofertaListNew);
            List<DescuentoEmitido> attachedDescuentoEmitidoListNew = new ArrayList<DescuentoEmitido>();
            for (DescuentoEmitido descuentoEmitidoListNewDescuentoEmitidoToAttach : descuentoEmitidoListNew) {
                descuentoEmitidoListNewDescuentoEmitidoToAttach = em.getReference(descuentoEmitidoListNewDescuentoEmitidoToAttach.getClass(), descuentoEmitidoListNewDescuentoEmitidoToAttach.getDescuentoId());
                attachedDescuentoEmitidoListNew.add(descuentoEmitidoListNewDescuentoEmitidoToAttach);
            }
            descuentoEmitidoListNew = attachedDescuentoEmitidoListNew;
            producto.setDescuentoEmitidoList(descuentoEmitidoListNew);
            producto = em.merge(producto);
            //mergeProducto(producto, em);
            if (rubroIdOld != null && !rubroIdOld.equals(rubroIdNew)) {
                rubroIdOld.getProductoList().remove(producto);
                rubroIdOld = em.merge(rubroIdOld);
            }
            if (rubroIdNew != null && !rubroIdNew.equals(rubroIdOld)) {
                rubroIdNew.getProductoList().add(producto);
                rubroIdNew = em.merge(rubroIdNew);
            }
            for (Valoracion valoracionListNewValoracion : valoracionListNew) {
                if (!valoracionListOld.contains(valoracionListNewValoracion)) {
                    Producto oldProductoIdOfValoracionListNewValoracion = valoracionListNewValoracion.getProductoId();
                    valoracionListNewValoracion.setProductoId(producto);
                    valoracionListNewValoracion = em.merge(valoracionListNewValoracion);
                    if (oldProductoIdOfValoracionListNewValoracion != null && !oldProductoIdOfValoracionListNewValoracion.equals(producto)) {
                        oldProductoIdOfValoracionListNewValoracion.getValoracionList().remove(valoracionListNewValoracion);
                        oldProductoIdOfValoracionListNewValoracion = em.merge(oldProductoIdOfValoracionListNewValoracion);
                    }
                }
            }
            for (Oferta ofertaListNewOferta : ofertaListNew) {
                if (!ofertaListOld.contains(ofertaListNewOferta)) {
                    Producto oldProductoIdOfOfertaListNewOferta = ofertaListNewOferta.getProductoId();
                    ofertaListNewOferta.setProductoId(producto);
                    ofertaListNewOferta = em.merge(ofertaListNewOferta);
                    if (oldProductoIdOfOfertaListNewOferta != null && !oldProductoIdOfOfertaListNewOferta.equals(producto)) {
                        oldProductoIdOfOfertaListNewOferta.getOfertaList().remove(ofertaListNewOferta);
                        oldProductoIdOfOfertaListNewOferta = em.merge(oldProductoIdOfOfertaListNewOferta);
                    }
                }
            }
            for (DescuentoEmitido descuentoEmitidoListNewDescuentoEmitido : descuentoEmitidoListNew) {
                if (!descuentoEmitidoListOld.contains(descuentoEmitidoListNewDescuentoEmitido)) {
                    Producto oldProductoIdOfDescuentoEmitidoListNewDescuentoEmitido = descuentoEmitidoListNewDescuentoEmitido.getProductoId();
                    descuentoEmitidoListNewDescuentoEmitido.setProductoId(producto);
                    descuentoEmitidoListNewDescuentoEmitido = em.merge(descuentoEmitidoListNewDescuentoEmitido);
                    if (oldProductoIdOfDescuentoEmitidoListNewDescuentoEmitido != null && !oldProductoIdOfDescuentoEmitidoListNewDescuentoEmitido.equals(producto)) {
                        oldProductoIdOfDescuentoEmitidoListNewDescuentoEmitido.getDescuentoEmitidoList().remove(descuentoEmitidoListNewDescuentoEmitido);
                        oldProductoIdOfDescuentoEmitidoListNewDescuentoEmitido = em.merge(oldProductoIdOfDescuentoEmitidoListNewDescuentoEmitido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Valoracion> valoracionListOrphanCheck = producto.getValoracionList();
            for (Valoracion valoracionListOrphanCheckValoracion : valoracionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Valoracion " + valoracionListOrphanCheckValoracion + " in its valoracionList field has a non-nullable productoId field.");
            }
            List<Oferta> ofertaListOrphanCheck = producto.getOfertaList();
            for (Oferta ofertaListOrphanCheckOferta : ofertaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Oferta " + ofertaListOrphanCheckOferta + " in its ofertaList field has a non-nullable productoId field.");
            }
            List<DescuentoEmitido> descuentoEmitidoListOrphanCheck = producto.getDescuentoEmitidoList();
            for (DescuentoEmitido descuentoEmitidoListOrphanCheckDescuentoEmitido : descuentoEmitidoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the DescuentoEmitido " + descuentoEmitidoListOrphanCheckDescuentoEmitido + " in its descuentoEmitidoList field has a non-nullable productoId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Rubro rubroId = producto.getRubroId();
            if (rubroId != null) {
                rubroId.getProductoList().remove(producto);
                rubroId = em.merge(rubroId);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Long getMaxId() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        return em.createNamedQuery("Producto.getMaxId", Long.class).getSingleResult();
    }

    public List<Producto> findProductoEntities() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        return em.createNamedQuery("Producto.findAll", Producto.class).getResultList();
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public void persistProducto(Producto p, EntityManager m) {
        StoredProcedureQuery createProducto = m.createNamedStoredProcedureQuery("createProducto");
        createProducto.setParameter("p_producto_id", p.getIdProducto());
        createProducto.setParameter("p_nombre_producto", p.getNombreProducto());
        createProducto.setParameter("p_rubro_id", p.getRubroId().getIdRubro());
        createProducto.setParameter("p_es_perecible", p.getEsPerecible());
        createProducto.setParameter("p_fecha_venc", p.getFechaVencimiento());
        createProducto.execute();
    }

    public void mergeProducto(Producto p, EntityManager m) {
        StoredProcedureQuery editProducto = m.createNamedStoredProcedureQuery("editProducto");
        editProducto.setParameter("p_id_prod", p.getIdProducto());
        editProducto.setParameter("p_nombre_producto", p.getNombreProducto());
        editProducto.executeUpdate();
        m.getTransaction().commit();
    }

    public Producto findProducto(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
