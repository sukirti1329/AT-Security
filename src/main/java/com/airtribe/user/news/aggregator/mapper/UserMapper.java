package com.airtribe.user.news.aggregator.mapper;


import com.airtribe.user.news.aggregator.domain.User;
import com.airtribe.user.news.aggregator.dto.SignupRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    SignupRequest toDTO(User user);
    User toEntity(SignupRequest userDTO);
}
