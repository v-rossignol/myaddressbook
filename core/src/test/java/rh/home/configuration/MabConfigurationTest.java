package rh.home.configuration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MabConfigurationTest {

	/**
	 * instance under test.
	 */
	private MabConfiguration configuration = null;
	
	@BeforeEach
	void setUp() throws Exception {
		this.configuration = new MabConfiguration();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.configuration = null;
	}

	@Test
	void testGetInstance() {
		assertThat( MabConfiguration.getInstance() ).isNotNull();
		assertThat( MabConfiguration.getInstance() ).isSameAs( MabConfiguration.getInstance() );
	}

	@Test
	void testMabConfiguration() {
		assertThat( configuration ).isNotNull(); 
	}

}
