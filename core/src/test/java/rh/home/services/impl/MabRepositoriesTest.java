package rh.home.services.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Parameterized.class)
@SpringBootTest
class MabRepositoriesTest {

	/**
	 * instance under test.
	 */
	@Autowired
	private MabRepositories repositories;

	@Test
	void testMabRepositories() {
		assertThat( repositories ).isNotNull();
	}

	@Test
	void testGetEntryRepository() {
		assertThat( repositories.getEntryRepository() ).isNotNull();
		assertThat( repositories.getEntryRepository() ).isSameAs( repositories.getEntryRepository() );
	}

}
