/*
 *  Copyright (c) 2025 Original Author(s), PhonePe India Pvt. Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.phonepe.sdk.pg.common.events;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    public static final int MAX_EVENTS_IN_BATCH = 10;
    public static final String SOURCE = "BACKEND_SDK";
    public static final String CLIENT_VERSION = "v2";
    public static final String AUTHORIZATION = "Authorization";

    public static final String EVENTS_ENDPOINT = "/client/v1/backend/events/batch";
    public static final int QUEUE_MAX_SIZE = 20000; // Should be greater than MAX_EVENTS_IN_BATCH
    public static final int INITIAL_DELAY = 1;
    public static final int DELAY = 1;
}
