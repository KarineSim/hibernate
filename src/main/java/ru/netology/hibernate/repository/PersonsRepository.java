package ru.netology.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Persons;

import java.util.List;

@AllArgsConstructor
@Repository
public class PersonsRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Persons> getPersonsByCity(String city) {
        String sql = "select p from Persons p where lower(p.cityOfLiving) = lower(:city)";

        return entityManager.createQuery(sql)
                .setParameter("city", city)
                .getResultList();
    }
}
