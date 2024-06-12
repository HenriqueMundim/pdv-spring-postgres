package com.personalprojects.pdv.infra.mappers;

import com.personalprojects.pdv.domain.entities.User;
import com.personalprojects.pdv.infra.dto.RegisterUserRequestDTO;
import com.personalprojects.pdv.infra.dto.UserDomainOutputDTO;
import com.personalprojects.pdv.infra.dto.UserDTO;

public class UserMapper {

    public static UserDTO toDto(User userEntity) {
        UserDTO userDto = new UserDTO();
        userDto.setKey(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        userDto.setOrders(userEntity.getOrders());

        return userDto;
    }

    public static User toEntity(UserDTO userDto) {
        User userEntity = new User();
        userEntity.setId(userDto.getKey());
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());

        return userEntity;
    }

    public static UserDTO createUserToDto(RegisterUserRequestDTO user) {
        UserDTO userDto = new UserDTO();

        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    public static UserDomainOutputDTO toDomainOutput(User user) {
        UserDomainOutputDTO userResponse = new UserDomainOutputDTO();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }

}
