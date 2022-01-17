package guru.springframework;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class inlineMockTest {

	@Test
	void tsetInlineMock() {
		Map mapMock = mock(Map.class);
		assertEquals(mapMock.size(),0);
	}
}
