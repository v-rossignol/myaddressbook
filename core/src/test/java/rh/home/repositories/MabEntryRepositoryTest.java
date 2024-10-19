package rh.home.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import rh.home.data.MabEntry;

@DataJpaTest
class MabEntryRepositoryTest {

	/**
	 * instance under test
	 */
	@Autowired
	private MabEntryRepository repository;

	@Test
	void testRepository() {
		assertThat( repository ).isNotNull();
	}
	
	@Test
	void CRUD() {
		
		MabEntry entry = new MabEntry();
		entry.setDisplay( "New Entry" );
		entry.setName( "CRUD" );
		
		MabEntry read = repository.save( entry );
		assertThat( read ).isNotNull();
		assertThat( read.getDisplay() ).isEqualTo( "New Entry" );
		
		MabEntry found = repository.findById( read.getId() );
		assertThat( found ).isNotNull();
		assertThat( found.getDisplay() ).isEqualTo( "New Entry" );
		
		found.setDisplay( "Same Entry New Display" );
		MabEntry modified = repository.save( found );
		assertThat( modified ).isNotNull();
		assertThat( modified.getDisplay() ).isEqualTo( "Same Entry New Display" );

		found = repository.findById( read.getId() );
		assertThat( found ).isNotNull();
		assertThat( found.getDisplay() ).isEqualTo( "Same Entry New Display" );
		
		repository.deleteById( read.getId() );
		assertThat( repository.findById( read.getId() ) ).isNull();
		
	}

}
