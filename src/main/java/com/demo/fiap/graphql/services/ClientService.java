package com.demo.fiap.graphql.services;

import com.demo.fiap.graphql.entities.Client;
import com.demo.fiap.graphql.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repo;

    ClientService(
            ClientRepository repository
    ) {
        this.repo = repository;
    }

    public Client findById(Long id) {
        return this.repo.findById(id).orElse(null);
    }

    public List<Client> findAll() {
        return this.repo.findAll();
    }

    public Client save(Client client) {
        return this.repo.save(client);
    }

    public Long deleteById(Long id) {
        this.repo.deleteById(id);
        return id;
    }

}
