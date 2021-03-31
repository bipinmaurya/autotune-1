/*******************************************************************************
 * Copyright (c) 2020, 2021 Red Hat, IBM Corporation and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.autotune.experimentmanager.fsm.api;

import com.autotune.experimentmanager.fsm.object.ExperimentTrialObject;
/**
 * This is a top level interface for Autotune Finite state machine. 
 * @author Bipin Kumar
 *
 * Mar 30, 2021
 */
public interface EMEvent {

	/**
	 * Name of the experiment manager event.
	 * 
	 * @return event name of experiment manager
	 */
	String getEMEventName();

	/**
	 * Timestamp of the event.
	 * 
	 * @return event timestamp
	 */
	long getEMEventTimestamp();
	
	ExperimentTrialObject getData();

}
