package rh.home.data.rules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.openpojo.random.RandomFactory;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoField;
import com.openpojo.reflection.PojoMethod;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.Rule;
import com.openpojo.validation.utils.SameInstanceIdentityHandlerStub;
import com.openpojo.validation.utils.ValidationHelper;

import rh.home.data.MabEntitiesTest;

/***
 * rule used to test hash code, equals and toString (used in automatic POJO UT)
 * @see MabEntitiesTest
 * @author FredG (creator)
 * @author Vincent ROSSIGNOL (maintainer)
 * @since version 0.0.1
 * @version 0.0.1
 */
public class EqualsHashCodeAndToStringValidationRule implements Rule {

    public void evaluate(PojoClass pojoClass) {
        boolean hasEquals = this.hasMethod(pojoClass, "equals", 1);
        boolean hasHashCode = this.hasMethod(pojoClass, "hashCode", 0);
        boolean hasToString = this.hasMethod(pojoClass, "toString", 0);
        if (hasEquals && !hasHashCode) {
            Affirm.fail("equals implemented but hashcode isn't in Pojo [" + pojoClass + "]");
        }

        if (!hasEquals && hasHashCode) {
            Affirm.fail("hashCode implemented but equals isn't in Pojo [" + pojoClass + "]");
        }

        if (hasToString || hasHashCode || hasEquals) {
            Object classInstance1 = ValidationHelper.getBasicInstance(pojoClass);
            Object classInstance2 = ValidationHelper.getBasicInstance(pojoClass);

            List<PojoField> fields = new ArrayList<>();
            fields.addAll(pojoClass.getSuperClass().getPojoFields());
            fields.addAll(pojoClass.getPojoFields());

            for(PojoField fieldEntry : fields) {
                if (fieldEntry.hasSetter()) {
                    Object value = RandomFactory.getRandomValue(fieldEntry);
                    SameInstanceIdentityHandlerStub.registerIdentityHandlerStubForValue(value);
                    fieldEntry.invokeSetter(classInstance1, value);
                    fieldEntry.invokeSetter(classInstance2, value);
                }
            }

            if (hasHashCode) {
                Affirm.affirmEquals("hashcode failed, non equal value", classInstance1.hashCode(), classInstance2.hashCode());
            }
            if (hasEquals) {
                Affirm.affirmTrue("equals failed", classInstance1.equals(classInstance2));
            }
            if (hasToString) {
                Affirm.affirmEquals("hashcode failed, non equal value", classInstance1.toString(), classInstance2.toString());
            }
        }
    }

    private boolean hasMethod(PojoClass pojoClass, String methodName, int expectedParamCount) {
        Iterator<PojoMethod> methodsIterator = pojoClass.getPojoMethods().iterator();
        PojoMethod method;
        do {
            if (!methodsIterator.hasNext()) {
                return false;
            }
            method = methodsIterator.next();
        } while(!method.getName().equals(methodName) || method.getPojoParameters().size() != expectedParamCount);

        return true;
    }
}
