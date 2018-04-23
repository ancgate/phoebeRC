/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.beans;


import com.merqury.phoebe.entity.Identifiable;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.primefaces.model.SortOrder;

/**
 *
 * @author jeffersonbienaime
 * @param <T>
 */
public abstract class AbstractFacade<T extends Identifiable>{

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Integer id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
     
    public List<T> loadLazy(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters, List<String> columnNameList) {
        CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> myObj = cq.from(entityClass);
        cq.where(getFilterCondition(cb, myObj, filters, columnNameList));
        if (sortField != null) {
            if (sortField.contains(".")) {
                String[] sortFields = sortField.split(Pattern.quote("."));
                if (sortOrder.equals(SortOrder.ASCENDING)) {
                    cq.orderBy(cb.asc(myObj.get(sortFields[0]).get(sortFields[1])));
                } else if (sortOrder.equals(SortOrder.DESCENDING)) {
                    cq.orderBy(cb.desc(myObj.get(sortFields[0]).get(sortFields[1])));
                }
            } else {
                if (sortOrder.equals(SortOrder.ASCENDING)) {
                    cq.orderBy(cb.asc(myObj.get(sortField)));
                } else if (sortOrder.equals(SortOrder.DESCENDING)) {
                    cq.orderBy(cb.desc(myObj.get(sortField)));
                }
            }
        }
        return this.getEntityManager().createQuery(cq).setFirstResult(first).setMaxResults(pageSize).getResultList();
    }
    
    public Predicate getFilterCondition(CriteriaBuilder cb, Root<T> root, Map<String, Object> filters, List<String> columnNameList) {
        Predicate filterCondition = cb.conjunction();
        String wildCard = "%";
        for (Map.Entry<String, Object> filter : filters.entrySet()) {
            String value = wildCard + filter.getValue() + wildCard;
            if (!filter.getValue().equals("")) {
                if (filter.getKey().contains(".")) {
                    String[] parts = filter.getKey().split(Pattern.quote("."));
                    String part1 = parts[0];
                    String part2 = parts[1];
                    javax.persistence.criteria.Path<String> path = (javax.persistence.criteria.Path<String>) root.get(part1).get(part2).as(String.class);
                    filterCondition = cb.and(filterCondition, cb.like(path, value));
                } else {
                    if (filter.getKey().equals("globalFilter")) {
                        Predicate[] pre = new Predicate[columnNameList.size()];
                        for (int i = 0; i < columnNameList.size(); i++) {
                            String get = columnNameList.get(i);
                            javax.persistence.criteria.Path<String> path = root.get(get);
                            Predicate p = cb.like(path, value);
                            pre[i] = p;
                        }
                        filterCondition = cb.or(pre);
                    } else {
                        javax.persistence.criteria.Path<String> path = root.get(filter.getKey());
                        filterCondition = cb.and(filterCondition, cb.like(path, value));
                    }

                }

            }

        }
        return filterCondition;
    }
    
}
