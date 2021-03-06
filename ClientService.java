package service;

import dao.ClientAddressDAO;
import dao.ClientDAO;
import entity.Client;
import entity.ClientAddress;
import entity.Phone;

import java.util.List;

public class ClientService {

    private ClientDAO clientDAO = new ClientDAO();

    private ClientAddressDAO clientAddressDAO = new ClientAddressDAO();

    public void addClient(Client client) {
            clientDAO.create(client);
    }

    public void addClientAddress(ClientAddress clientAddress) {
        clientAddressDAO.create(clientAddress);
    }

    public void listClientsFromCity(String city) {
        List<Client> clients = clientDAO.findByCity(city);
        clients.forEach(System.out::println);
    }

    public void addClientWithAddress(Client client) {
        clientAddressDAO.create(client.getClientAddress());
        clientDAO.create(client);
    }

    public void addPhoneToClient(Client client, Phone phone){
        clientDAO.addPhoneToClient(client, phone);

    }
}
