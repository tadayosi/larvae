package larvae.jpa.domain;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonRepository {

    @Inject
    EntityManager entityManager;

    public void add(Person person) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(person);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
        }
    }

    public Person get(Long id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> findAll() {
        return entityManager.createQuery("from Person", Person.class).getResultList();
    }

}
