package guru.springframework;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//mockオブジェクトの初期化方法 1:static mock(Object), 2:@BeforeEach内でinitMocks(class),3:@ExtendWith(MockitoExtension.class)の３種類
@ExtendWith(MockitoExtension.class) 
public class JUnitExtensionTest {

	@Mock
	Map<String,Object> mapMock;
	
	@Test
	void testMock() {
		mapMock.put("keyvalue", "foo");
	}
}
