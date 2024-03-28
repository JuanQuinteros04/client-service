package com.client.service;

import com.client.model.DTO.ClientDTO;
import com.client.model.DTO.ClientResponse;

import java.util.List;

public interface ClientService {
    List<ClientResponse> findAllClients();

    ClientResponse findClientById(Long id);

    ClientResponse createClient(ClientDTO clientDTO);

    void updateClient(Long id, ClientDTO clientDTO);

    void deleteClient(Long id);
}
