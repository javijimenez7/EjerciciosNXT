package com.example.BS12.person.application.mappers;


import com.example.BS12.person.domain.Person;
import com.example.BS12.person.infraestructure.dto.PersonInputDTO;
import com.example.BS12.person.infraestructure.dto.PersonOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    Person PersonInputToPerson(PersonInputDTO personInputDto);
    PersonOutputDTO PersonToPersonOutput(Person person);
}
