package com.demo.fiap.graphql.controllers;

import com.demo.fiap.graphql.dtos.ClientDTO;
import com.demo.fiap.graphql.entities.Client;
import com.demo.fiap.graphql.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClientController {

    private final ClientService service;

    ClientController(
            ClientService service
    ) {
        this.service = service;
    }

    @QueryMapping
    public Client client(@Argument Long id) {
       return  this.service.findById(id);
    }

    @QueryMapping
    public List<Client> clients() {
        return this.service.findAll();
    }

    @MutationMapping
    public Client saveClient(@Argument ClientDTO clientDTO) {
        ModelMapper model = new ModelMapper();
        Client client = model.map(clientDTO, Client.class);
        return this.service.save(client);
    }

    @MutationMapping
    public Long deleteClient(@Argument Long id) {
        return this.service.deleteById(id);
    }
}
