package ch.etml.pl.commerceapi.controller;

import ch.etml.pl.commerceapi.dao.ClientsRepository;
import ch.etml.pl.commerceapi.dto.ClientsDto;
import ch.etml.pl.commerceapi.entity.ClientsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientsController(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    //get all clients api with /clients
    @GetMapping("")
    public List<ClientsDto> getAllClients() {
        List<ClientsEntity> clientsEntities = clientsRepository.findAll();
        return clientsEntities.stream()
                .map(ClientsEntity::toDto)
                .collect(Collectors.toList());
    }

    //get client by id api with /clients/{id}
    @GetMapping("/{id}")
    public ClientsDto getClientById(@PathVariable Integer id) {
        Optional<ClientsEntity> clientOptional = clientsRepository.findById(id);
        if (clientOptional.isPresent()) {
            ClientsEntity client = clientOptional.get();
            return client.toDto();
        } else {
            return null;
        }
    }

    //get client by prenom api with /clients/prenom/{prenom}
    @GetMapping("/prenom/{prenom}")
    public ClientsDto getClientByPrenom(@PathVariable String prenom) {
        ClientsEntity client = clientsRepository.findByPrenom(prenom);
        return client.toDto();
    }

    //post client api with /clients
    @PostMapping("")
    public void postClient(@RequestBody ClientsDto clientDto) {
        //check if client already exists
        ClientsEntity client = clientsRepository.findByPrenom(clientDto.getPrenom());
        if (client != null) {
            return;
        }
        client = new ClientsEntity();
        client.setPrenom(clientDto.getPrenom());
        client.setSolde(clientDto.getSolde());
        clientsRepository.save(client);
    }

    //put client api with /clients/{id}
    @PutMapping("/{id}")
    public void putClient(@PathVariable Integer id, @RequestBody ClientsDto clientDto) {
        Optional<ClientsEntity> clientOptional = clientsRepository.findById(id);
        if (clientOptional.isPresent()) {
            ClientsEntity client = clientOptional.get();
            client.setPrenom(clientDto.getPrenom());
            client.setSolde(clientDto.getSolde());
            clientsRepository.save(client);
        }
    }

    //delete client api with /clients/{id}
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientsRepository.deleteById(id);
    }
}
