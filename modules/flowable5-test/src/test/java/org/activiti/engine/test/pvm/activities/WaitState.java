/* Licensed under the Apache License, Version 2.0 (the "License");
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

package org.activiti.engine.test.pvm.activities;

import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.activiti.engine.impl.pvm.delegate.SignallableActivityBehavior;
import org.flowable.engine.delegate.DelegateExecution;

/**
 * @author Tom Baeyens
 */
public class WaitState implements SignallableActivityBehavior {

    public void execute(DelegateExecution execution) {
    }

    public void signal(ActivityExecution execution, String signalName, Object signalData) throws Exception {
        PvmTransition transition = execution.getActivity().getOutgoingTransitions().get(0);
        execution.take(transition);
    }
}
