package rh.home.ui;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MabMainWindowTest {

	/**
	 * instance under test.
	 */
	private MabMainWindow window;
	
	@BeforeEach
	void setUp() throws Exception {
		this.window = new MabMainWindow();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.window = null;
	}

	@Test
	void test() {
		assertThat( window ).isNotNull();
		assertThat( window.getServices() ).isNotNull();
		assertThat( window.getServices().getEntryService() ).isNotNull();
	}

}
