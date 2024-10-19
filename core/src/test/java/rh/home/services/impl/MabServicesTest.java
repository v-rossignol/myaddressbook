package rh.home.services.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Parameterized.class)
@SpringBootTest
class MabServicesTest {

	@Autowired
	private MabServices services;
	
	@Test
	void testMabServices() {
		assertThat( services ).isNotNull(); 
	}

	@Test
	void testGetEntryService() {
		assertThat( services.getEntryService() ).isNotNull();
		assertThat( services.getEntryService() ).isSameAs( services.getEntryService() );
	}

	@Test
	void testGetRepositories() {
		assertThat( services.getRepositories() ).isNotNull();
		assertThat( services.getRepositories() ).isSameAs( services.getRepositories() );
	}

	@Test
	void testGetInstance() {
		assertThat( MabServices.getInstance() ).isNotNull();
	}
}
