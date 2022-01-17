package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

	@Mock
	VisitRepository visitRepository;
	
	@InjectMocks
	VisitSDJpaService service;
	
	@Test
	void findAll() {
		Visit visit = new Visit();
		Set<Visit> visits = new HashSet<Visit>();
		visits.add(visit);
		when(visitRepository.findAll()).thenReturn(visits);
		Set<Visit> foundVisits = service.findAll();
		verify(visitRepository).findAll();
		assertThat(foundVisits).hasSize(1);
	}
	
	@Test
	void testFindById() {
		Visit visit = new Visit();
		when(visitRepository.findById(1l)).thenReturn(Optional.of(visit));
		Visit foundVisit = service.findById(1l);
		assertThat(foundVisit).isNotNull();
		verify(visitRepository).findById(anyLong());
	}

	@Test
	void testSave() {
		Visit visit  = new Visit();
		service.save(visit);
		verify(visitRepository).save(any(Visit.class));
	}

	@Test
	void testDelete() {
		Visit visit  = new Visit();
		service.delete(visit);
		verify(visitRepository).delete(visit);
	}

	@Test
	void testDeleteById() {
		service.deleteById(1l);
		verify(visitRepository).deleteById(anyLong());
	}

}
