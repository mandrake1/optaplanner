/*
 * Copyright 2011 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.examples.tsp.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.tsp.domain.solver.DomicileDistanceVisitDifficultyWeightFactory;
import org.optaplanner.examples.tsp.domain.solver.LatitudeVisitDifficultyComparator;

@PlanningEntity(difficultyComparatorClass = LatitudeVisitDifficultyComparator.class)
@XStreamAlias("Visit")
public class Visit extends AbstractPersistable implements Standstill {

    private City city; // the destinationCity
    
    // Planning variables: changes during planning, between score calculations.
    private Standstill previousStandstill;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @PlanningVariable(chained = true, valueRangeProviderRefs = {"domicileRange", "visitRange"})
    public Standstill getPreviousStandstill() {
        return previousStandstill;
    }

    public void setPreviousStandstill(Standstill previousStandstill) {
        this.previousStandstill = previousStandstill;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

    /**
     * @return a positive number, the distance multiplied by 1000 to avoid floating point arithmetic rounding errors
     */
    public long getDistanceToPreviousStandstill() {
        if (previousStandstill == null) {
            return 0L;
        }
        return getDistanceTo(previousStandstill);
    }

    /**
     * @param standstill never null
     * @return a positive number, the distance multiplied by 1000 to avoid floating point arithmetic rounding errors
     */
    public long getDistanceTo(Standstill standstill) {
        return city.getDistance(standstill.getCity());
    }

    @Override
    public String toString() {
        return city + "(after " + (previousStandstill == null ? "null" : previousStandstill.getCity()) + ")";
    }

}
