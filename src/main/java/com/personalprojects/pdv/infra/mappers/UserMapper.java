package com.personalprojects.pdv.infra.mappers;

import com.personalprojects.pdv.domain.entities.User;
import com.personalprojects.pdv.infra.dto.CreateUserRequest;
import com.personalprojects.pdv.infra.dto.UserDto;

public class UserMapper {

    public static UserDto toDto(User userEntity) {
        UserDto userDto = new UserDto();
        userDto.setKey(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        userDto.setOrders(userEntity.getOrders());

        return userDto;
    }

    public static User toEntity(UserDto userDto) {
        User userEntity = new User();
        userEntity.setId(userDto.getKey());
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());

        return userEntity;
    }

    public static UserDto RequestToDto(CreateUserRequest user) {
        UserDto userDto = new UserDto();

        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
