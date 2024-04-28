package org.example;

import jakarta.persistence.*;
import java.util.List;

public class ClientCrudService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SpaceTravelPU");
    private EntityManager entityManager;

    public ClientCrudService() {
        this.entityManager = emf.createEntityManager();
    }

    public Client createClient(String name) {
        entityManager.getTransaction().begin();
        Client client = new Client(name);
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        return client;
    }

    public Client findClient(Long id) {
        return entityManager.find(Client.class, id);
    }

    public Client updateClient(Client client) {
        entityManager.getTransaction().begin();
        Client updatedClient = entityManager.merge(client);
        entityManager.getTransaction().commit();
        return updatedClient;
    }

    public void deleteClient(Long id) {
        entityManager.getTransaction().begin();
        Client client = entityManager.find(Client.class, id);
        if (client != null) {
            entityManager.remove(client);
        }
        entityManager.getTransaction().commit();
    }
}
