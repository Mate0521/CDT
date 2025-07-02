/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import conexion.exceptions.NonexistentEntityException;
import conexion.exceptions.PreexistingEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import modelo.CDT;

/**
 *
 * @author MATEO CARVAJAL
 */
public class CDTJpaController implements Serializable {

    public CDTJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CDT CDT) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(CDT);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCDT(CDT.getNumeroCuenta()) != null) {
                throw new PreexistingEntityException("CDT " + CDT + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CDT CDT) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CDT = em.merge(CDT);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = CDT.getNumeroCuenta();
                if (findCDT(id) == null) {
                    throw new NonexistentEntityException("The cDT with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CDT CDT;
            try {
                CDT = em.getReference(CDT.class, id);
                CDT.getNumeroCuenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The CDT with id " + id + " no longer exists.", enfe);
            }
            em.remove(CDT);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CDT> findCDTEntities() {
        return findCDTEntities(true, -1, -1);
    }

    public List<CDT> findCDTEntities(int maxResults, int firstResult) {
        return findCDTEntities(false, maxResults, firstResult);
    }

    private List<CDT> findCDTEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CDT.class));
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

    public CDT findCDT(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CDT.class, id);
        } finally {
            em.close();
        }
    }

    public int getCDTCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CDT> rt = cq.from(CDT.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
