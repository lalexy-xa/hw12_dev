package org.example;

import org.example.entity_servicies.ClientCrudService;
import org.example.entity_servicies.PlanetCrudService;
import org.example.hibernate_entities.Client;
import org.example.hibernate_entities.Planet;

import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Migration.getInstance().repair();
        Migration.getInstance().clean();
        Migration.getInstance().migrate();

        ClientCrudService clientSevice = new ClientCrudService();

        Client client = new Client();
        client.setName("Marta");

        clientSevice.saveClient(client);
        System.out.println(clientSevice.findClientById(11L).getName());
        client.setName("Marta2");
        client.setId(11L);
        clientSevice.updateClient(client);
        System.out.println(clientSevice.findClientById(11L).getName());
        clientSevice.deleteClient(client);
        try {
            clientSevice.findClientById(11L).getName();
        }catch (NullPointerException e){
            System.out.println("Already deleted");
        }

        PlanetCrudService planetCrudService = new PlanetCrudService();
        Planet planet = new Planet();
        planet.setId("GFGF");
        planet.setName("ddwdew");

        planetCrudService.savePlanet(planet);
        System.out.println(planetCrudService.findPlanetById("GFGF").getName());
        planet.setId("GFGF");
        planet.setName("Dddwdew");
        planetCrudService.updatePlanet(planet);
        System.out.println(planetCrudService.findPlanetById("GFGF").getName());
        planetCrudService.deletePlanet(planet);
        try {
            planetCrudService.findPlanetById("GFGF").getName();
        }catch (NullPointerException e){
            System.out.println("Already deleted");
        }



    }
}