package com.example.DBA1.person.infraestructure.repositories;

import com.example.DBA1.person.domain.Person;
import org.aspectj.weaver.ast.Or;
import org.hibernate.Criteria;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PersonRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;


    public List<Person> getData(HashMap<String, Object> conditions){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query= cb.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);
        final List<Order>[] ord = new List[]{new ArrayList<>()};
        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field,value) ->{
            switch (field) {
                case "user":
                case "name":
                case "surname":
                    Predicate greaterThan = cb.greaterThan(root.get(field), "%" + (String) value + "%");
                    Predicate lessThan = cb.lessThan(root.get(field), "%" + (String) value + "%");
                    Predicate unidos = cb.or(greaterThan,lessThan);
                    predicates.add(unidos);
                    break;

                case "create_date":
                    predicates.add(cb.greaterThan(root.<Date>get(field), (Date) value));
                    break;
                case "orden":
                    if(value.toString().equals("user")) {
                        ord[0].add(cb.asc(root.get("user")));;
                    } else {
                        if (value.toString().equals("name")) {
                            ord[0].add(cb.asc(root.get("name")));;
                        }
                    }
                }
        });


        query.select(root).where(predicates.toArray(new Predicate[predicates.size()])).orderBy(ord[0]);
        int firstResult = Integer.parseInt((String) conditions.get("pageIndex"));
        int maxResults = 10;
        if(conditions.containsKey("pageSize")){
            maxResults= Integer.parseInt((String) conditions.get("pageSize"));
        }
        return entityManager.createQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

}
