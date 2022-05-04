package com.example.TE1;

import com.example.TE1.person.application.PersonService;
import com.example.TE1.person.domain.Person;
import com.example.TE1.person.infraestructure.PersonController;
import com.example.TE1.person.infraestructure.dto.PersonInputDTO;
import com.example.TE1.person.infraestructure.dto.PersonOutputDTO;
import com.example.TE1.person.infraestructure.repositories.PersonRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)


class Te1ApplicationTests {

	@Mock
	PersonService personServiceMock;

	@InjectMocks
	PersonController personController;

	PersonInputDTO personInputDTO =
			new PersonInputDTO(
					"1",
					"luis01",
					"",
					"luis",
					"gomez",
					"jhghjgh@gmail.com",
					"qweqwe@gmail.com",
					"Jaén",
					true,
					new Date(),
					"k",
					new Date());
	PersonOutputDTO personOutputDTO =
			new PersonOutputDTO(
					"1",
					"luis01",
					"luis",
					"gomez",
					"jhghjgh@gmail.com",
					"qweqwe@gmail.com",
					"Jaén",
					true,
					new Date(),
					"k",
					new Date());
	List<PersonOutputDTO> personOutputDTOList;
	@Before
	void before() {
		System.out.println("Before");
		personOutputDTOList = new ArrayList<>();
		personOutputDTOList.add(personOutputDTO);
	}
	@Test
	void findByIdTest() throws Exception {
		System.out.println("TEST1");
		when(personServiceMock.findById("1")).thenReturn(personOutputDTO);
		assertEquals(personOutputDTO, personController.getPersonById("1"));
		System.out.println(personOutputDTO);
	}

	@Test
	void findAllTest() throws Exception {
		System.out.println("TEST2");
		when(personServiceMock.findAll()).thenReturn(personOutputDTOList);
		assertEquals(personOutputDTOList, personController.getPeople());
		System.out.println(personOutputDTOList);
	}
	@Test
	void findByNameTest() throws Exception {
		System.out.println("TEST3");
		when(personServiceMock.findByName("luis")).thenReturn(personOutputDTOList);
		assertEquals(personOutputDTOList, personController.getPeopleByName("luis"));
		System.out.println(personOutputDTOList);
	}
	@Test
	void addPersonTest() throws Exception {
		System.out.println("TEST4");
		when(personServiceMock.addPerson(personInputDTO))
				.thenReturn(new PersonOutputDTO(new Person(personInputDTO)));
		assertEquals(personOutputDTO, personController.insertPerson(personInputDTO));
		System.out.println(personOutputDTO);
	}
	@Test
	void deletePersonTest() throws Exception {
		System.out.println("TEST5");
		when(personServiceMock.deletedById("1")).thenReturn(new Person(personInputDTO));
		assertEquals(new Person(personInputDTO), personController.deletePersonById("1"));
	}

}
