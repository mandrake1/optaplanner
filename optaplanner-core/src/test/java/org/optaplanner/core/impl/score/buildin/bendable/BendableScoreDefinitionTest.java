/*
 * Copyright 2013 JBoss Inc
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

package org.optaplanner.core.impl.score.buildin.bendable;

import org.junit.Test;
import org.optaplanner.core.api.score.buildin.bendable.BendableScore;

import static org.junit.Assert.*;

public class BendableScoreDefinitionTest {

    @Test
    public void getLevelCount() {
        assertEquals(2, new BendableScoreDefinition(1, 1).getLevelCount());
        assertEquals(7, new BendableScoreDefinition(3, 4).getLevelCount());
        assertEquals(7, new BendableScoreDefinition(4, 3).getLevelCount());
        assertEquals(5, new BendableScoreDefinition(0, 5).getLevelCount());
        assertEquals(5, new BendableScoreDefinition(5, 0).getLevelCount());
    }

    @Test
    public void getFeasibleLevelCount() {
        assertEquals(1, new BendableScoreDefinition(1, 1).getFeasibleLevelCount());
        assertEquals(3, new BendableScoreDefinition(3, 4).getFeasibleLevelCount());
        assertEquals(4, new BendableScoreDefinition(4, 3).getFeasibleLevelCount());
        assertEquals(0, new BendableScoreDefinition(0, 5).getFeasibleLevelCount());
        assertEquals(5, new BendableScoreDefinition(5, 0).getFeasibleLevelCount());
    }

}
