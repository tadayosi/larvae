package larvae.jpa;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactory {

    @Produces
    public EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory("larva-jpa").createEntityManager();
    }

}
