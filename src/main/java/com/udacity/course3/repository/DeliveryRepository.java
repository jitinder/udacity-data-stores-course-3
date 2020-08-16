package com.udacity.course3.repository;

import com.udacity.course3.data.Delivery;
import com.udacity.course3.data.Plant;
import com.udacity.course3.data.RecipientAndPrice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Delivery delivery){
        entityManager.persist(delivery);
    }

    public Delivery find(Long id){
        return entityManager.find(Delivery.class, id);
    }

    public List<Delivery> findDeliveriesByName(String name){
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.byName", Delivery.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public RecipientAndPrice getBill(Long id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> criteriaQuery = cb.createQuery(RecipientAndPrice.class);
        Root<Plant> root = criteriaQuery.from(Plant.class);

        criteriaQuery.select(
                cb.construct(
                        RecipientAndPrice.class,
                        root.get("delivery").get("name"),
                        cb.sum(root.get("price"))
                )
        ).where(cb.equal(root.get("delivery").get("id"), id));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public Delivery merge(Delivery delivery){
        return entityManager.merge(delivery);
    }

    public void delete(Long id){
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }

}
