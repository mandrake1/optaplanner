package org.optaplanner.core.impl.testdata.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.core.impl.domain.entity.descriptor.EntityDescriptor;
import org.optaplanner.core.impl.domain.solution.descriptor.SolutionDescriptor;
import org.optaplanner.core.impl.domain.variable.descriptor.GenuineVariableDescriptor;

@PlanningEntity
public class TestdataEntity extends TestdataObject {

    public static EntityDescriptor buildEntityDescriptor() {
        SolutionDescriptor solutionDescriptor = TestdataSolution.buildSolutionDescriptor();
        return solutionDescriptor.getEntityDescriptor(TestdataEntity.class);
    }

    public static GenuineVariableDescriptor buildVariableDescriptorForValue() {
        SolutionDescriptor solutionDescriptor = TestdataSolution.buildSolutionDescriptor();
        EntityDescriptor entityDescriptor = solutionDescriptor.getEntityDescriptor(TestdataEntity.class);
        return entityDescriptor.getVariableDescriptor("value");
    }

    private TestdataValue value;

    public TestdataEntity() {
    }

    public TestdataEntity(String code) {
        super(code);
    }

    public TestdataEntity(String code, TestdataValue value) {
        this(code);
        this.value = value;
    }

    @PlanningVariable(valueRangeProviderRefs = "valueRange")
    public TestdataValue getValue() {
        return value;
    }

    public void setValue(TestdataValue value) {
        this.value = value;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

}
