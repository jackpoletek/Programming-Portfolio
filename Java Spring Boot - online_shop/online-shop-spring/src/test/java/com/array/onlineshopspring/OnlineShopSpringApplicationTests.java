package com.array.onlineshopspring;

import com.array.onlineshopspring.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class OnlineShopSpringApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void testEntityToDto() {
//		CatEntity entity = new CatEntity("roofer", 3, CatGenderEnum.FEMALE);
//		CatDTO dto = CatMapper.CAT_MAPPER.getDto(entity);
//
//		assertThat(dto.getBreedDTO()).isEqualTo("roofer");
//		assertThat(dto.getNumberOfPawsDTO()).isEqualTo(3);
//		assertThat(dto.getGenderDTO().toString()).isEqualTo(CatGenderEnum.FEMALE.toString());
//	}

//	@Test
//	public void testDtoToEntity() {
//		CatDTO dto = new CatDTO("kitty", 2, CatGenderEnum.MALE);
//		CatEntity entity = CatMapper.CAT_MAPPER.getEntity(dto);
//
//		assertThat(entity.getBreed()).isEqualTo("kitty");
//		assertThat(entity.getNumberOfPaws()).isEqualTo(2);
//		assertThat(entity.getGender().toString()).isEqualTo(CatGenderEnum.MALE.toString());
//	}

	@Test
	public void repoTest() {
		String className = userRepository.getClass().getName();
		String packageName = userRepository.getClass().getPackageName();
		System.out.println(className);
		System.out.println(packageName);
	}
	public static void main(String[] args) {
		SpringApplication.run(OnlineShopSpringApplicationTests.class, args);
	}
}
