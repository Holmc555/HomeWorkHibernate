package com.spacetravel;

import com.spacetravel.*;
import org.example.Client;
import org.example.ClientCrudService;
import org.example.Planet;

public class Main {
    public static void main(String[] args) {
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();

        // Створення нових об'єктів
        Client newClient = clientService.createClient("John Doe");
        Planet newPlanet = planetService.createPlanet("MARS", "Mars");

        // Вивід інформації
        System.out.println("Client Created: " + newClient.getName());
        System.out.println("Planet Created: " + newPlanet.getName());

        // Додайте код для тестування оновлення та видалення
    }
}
