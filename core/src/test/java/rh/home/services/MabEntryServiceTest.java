package rh.home.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import rh.home.data.MabEntry;
import rh.home.services.impl.MabRepositories;

@RunWith(Parameterized.class)
@SpringBootTest
class MabEntryServiceTest {

	@Autowired
	private MabRepositories repositories;
	
	/**
	 * instance under test.
	 */
	private MabEntryService entries;
	
	@BeforeEach
	void setUp() throws Exception {
		this.entries = new MabEntryService( repositories );
	}

	@AfterEach
	void tearDown() throws Exception {
		this.entries = null;
	}

	@Test
	void testMabEntryService() {
		assertThat( entries ).isNotNull();
	}

	@Test
	void testGetRepository() {
		assertThat( entries.getRepository() ).isSameAs( repositories.getEntryRepository() );
	}

	@Test
	void testCreateStringString() {
		
		MabEntry entry = entries.create( "First-Name", "Last Name" );
		
		assertThat( entry ).isNotNull();
		assertThat( entry.getFirstName() ).isEqualTo( "First-Name" );
		assertThat( entry.getName()      ).isEqualTo( "Last Name"  );
		
		assertThat( entry.getDisplay()   ).isEqualTo( "Last Name, First-Name" );
		
		assertThat( entry.getId() ).isGreaterThanOrEqualTo( 0 );
		assertThat( entry.getDisplay() ).isEqualTo( entries.getRepository().findById( entry.getId() ).getDisplay() );
		
	}
	
	@Test
	void testCreateMabEntry() {
		
		/* first and last name */
		MabEntry entry = new MabEntry();
		entry.setFirstName( "FirstName" );
		entry.setName( "LASTNAME" );
		MabEntry created = entries.create( entry );
		
		assertThat( created.getDisplay() ).isEqualTo( "LASTNAME, FirstName" );
		
		/* first name only */
		entry = new MabEntry();
		entry.setFirstName( "FirstName" );
		created = entries.create( entry );
		assertThat( created.getDisplay() ).isEqualTo( "FirstName" );
		
		/* last name only */
		entry = new MabEntry();
		entry.setName( "LASTNAME" );
		created = entries.create( entry );
		assertThat( created.getDisplay() ).isEqualTo( "LASTNAME" );
		
	}

	@Test
	void testGetRepositories() {
		assertThat( entries.getRepositories() ).isSameAs( repositories );
	}

}
