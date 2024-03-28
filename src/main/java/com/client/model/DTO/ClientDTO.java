package com.client.model.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode
public class ClientDTO {

    private String name;

    private String lastName;

    private String mail;

    private Long phoneNumber;


}
