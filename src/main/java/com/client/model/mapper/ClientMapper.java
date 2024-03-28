package com.client.model.mapper;

import com.client.model.Client;
import com.client.model.DTO.ClientDTO;
import com.client.model.DTO.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "id", ignore = true)
    Client clientDTOToClient(ClientDTO clientDTO);

    ClientResponse clientToClientResponse(Client client);
}