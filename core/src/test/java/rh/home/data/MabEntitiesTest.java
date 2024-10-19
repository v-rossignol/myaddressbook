package rh.home.data;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import rh.home.data.rules.EqualsHashCodeAndToStringValidationRule;

@RunWith(Parameterized.class)
@SpringBootTest
public class MabEntitiesTest {

    @SuppressWarnings("rawtypes")
	private Class testedClass;

    @Parameterized.Parameters(name = "Testing {0} entity ")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {	MabEntry.class.getSimpleName(),	MabEntry.class	}
        });
    }

    @SuppressWarnings("rawtypes")
	public MabEntitiesTest(String entityName, Class testedClass) {
        this.testedClass = testedClass;
    }

    private static final Validator ACCESSOR_VALIDATOR = ValidatorBuilder.create()
            .with(new GetterTester()) // test all getters
            .with(new SetterTester()) // test all setters
            .with(new EqualsHashCodeAndToStringValidationRule()) // test Equals, HashCode and ToString
            .build();

    @Test
    public void testEntity(){
        ACCESSOR_VALIDATOR.validate(PojoClassFactory.getPojoClass(testedClass));
    }
	
}
