/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.server.ejb.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.tyaa.java.portal.server.ejb.entity.Author;
import org.tyaa.java.portal.server.ejb.entity.Author_;
import org.tyaa.java.portal.server.ejb.entity.projections.AuthorProjection;

/**
 *
 * @author yurii
 */
@Stateless
public class AuthorFacade extends AbstractFacade<Author> {

    @PersistenceContext(unitName = "JavaPortalEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuthorFacade() {
        super(Author.class);
    }
    
    public List<AuthorProjection> findAllProjection() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<AuthorProjection> cq =
                cb.createQuery(AuthorProjection.class);
        Root<Author> root = cq.from(Author.class);
        //cq.multiselect(root.get(Author_.id), root.get(Author_.name), root.get(Author_.about));
        cq.select(
                cb.construct(
                        AuthorProjection.class
                        , root.get(Author_.id)
                        , root.get(Author_.name)
                        , root.get(Author_.startedAt)
                )
        );
        TypedQuery<AuthorProjection> q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }
    
    public List<AuthorProjection> findAllRangeProjection(int[] range) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<AuthorProjection> cq =
                cb.createQuery(AuthorProjection.class);
        Root<Author> root = cq.from(Author.class);
        cq.select(
                cb.construct(
                        AuthorProjection.class
                        , root.get(Author_.id)
                        , root.get(Author_.name)
                        , root.get(Author_.about)
                )
        );
        TypedQuery<AuthorProjection> q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
}
