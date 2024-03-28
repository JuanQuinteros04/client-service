package com.client.service;

import com.client.exceptions.NotFoundException;
import com.client.model.Client;
import com.client.model.DTO.ClientDTO;
import com.client.model.DTO.ClientResponse;
import com.client.model.mapper.ClientMapper;
import com.client.persistence.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientRepository clientRepository;

    ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Override
    public List<ClientResponse> findAllClients() {
        return clientRepository.findAll().stream().map(client -> clientMapper.clientToClientResponse(client)).collect(Collectors.toList());
    }

    @Override
    public ClientResponse findClientById(Long id) {
        return clientMapper.clientToClientResponse(clientRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public ClientResponse createClient(ClientDTO clientDTO) {

        Client client = clientMapper.clientDTOToClient(clientDTO);
        clientRepository.save(client);
        return clientMapper.clientToClientResponse(client);
    }

    @Override
    public void updateClient(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElseThrow(NotFoundException::new);

        client.setName(clientDTO.getName() != null ? clientDTO.getName() : client.getName());
        client.setLastName(clientDTO.getLastName() != null ? clientDTO.getLastName() : client.getLastName());
        client.setMail(clientDTO.getMail() != null ? clientDTO.getMail() : client.getMail());
        client.setPhoneNumber(clientDTO.getPhoneNumber() != null ? clientDTO.getPhoneNumber() : client.getPhoneNumber());

        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete(clientRepository.findById(id).orElseThrow(NotFoundException::new));
    }
}
