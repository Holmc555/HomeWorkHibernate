package com.spacetravel;

import jakarta.persistence.*;
import org.example.Planet;

public class PlanetCrudService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SpaceTravelPU");

    public Planet createPlanet(String id, String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Planet planet = new Planet(id, name);
        em.persist(planet);
        em.getTransaction().commit();
        em.close();
        return planet;
    }

    public Planet findPlanet(String id) {
        EntityManager em = emf.createEntityManager();
        Planet planet = em.find(Planet.class, id);
        em.close();
        return planet;
    }

    public Planet updatePlanet(String id, String newName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Planet planet = em.find(Planet.class, id);
        if (planet != null) {
            planet.setName(newName);
        }
        em.getTransaction().commit();
        em.close();
        return planet;
    }

    public void deletePlanet(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Planet planet = em.find(Planet.class, id);
        if (planet != null) {
            em.remove(planet);
        }
        em.getTransaction().commit();
        em.close();
    }
}
