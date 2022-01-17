package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

	@Mock
	SpecialtyRepository specialtyRepository;
	
	@InjectMocks //@Mockを注入するテスト対象のクラスを指定(constructor,setter,propertyのいずれかでinjectionする)
	SpecialitySDJpaService service;
	
	@Test
	void testDeleteByObject() {
		Speciality speciality = new Speciality();
		service.delete(speciality);
		verify(specialtyRepository).delete(any(Speciality.class)); //any(Object type): 引数のクラスのオブジェクトならなんでもOK 
	}
	
	@Test
	void findByIdTest() {
		//Repositoryで受け取るentityを作成
		Speciality speciality = new Speciality();
		//when(methodcall).thenReturn(returnedValue) : methodcallが呼ばれたらreturnedValueが戻り値になるように設定
		when(specialtyRepository.findById(1l)).thenReturn(Optional.of(speciality));
		//テスト対象クラスからメソッドを実行
		Speciality foundSpeciality = service.findById(1l);
		//検索結果のOptional<Speciality>がnullでないことを検証
		assertThat(foundSpeciality).isNotNull();
		//mockしたRepositoryのfindById(1l)が1回呼ばれていることを検証、whenで指定したreturnedValueを持つべき
		verify(specialtyRepository).findById(anyLong());
	}
	
	@Test
	void deleteById() {
		service.deleteById(1l);
		service.deleteById(1l);
		//verify(mock,times).mockMethod : mockのmockMethodがテストメソッド内で何回呼ばれたか検証
		verify(specialtyRepository,times(2)).deleteById(1l);
	}
	
	@Test
	void deleteByIdNever() {
		service.deleteById(1l);
		verify(specialtyRepository,never()).deleteById(3l);
	}
	
	@Test
	void testDelete() {
		service.delete(new Speciality());
	}

}
