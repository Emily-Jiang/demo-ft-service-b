/*
 *******************************************************************************
 * Copyright (c) 2018 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *   2018-06-19 - Jon Hawkes / IBM Corp
 *      Initial code
 *
 *******************************************************************************/

package org.eclipse.microprofile.ft.serviceb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Health
@ApplicationScoped
public class HealthEndpoint implements HealthCheck {

  /*
   *  Health is controlled by a config property
   */
  @Inject
  @ConfigProperty(name = "healthy", defaultValue = "true")
  private boolean healthy;

  @Override
  public HealthCheckResponse call() {
    HealthCheckResponse hcr;

    if (healthy) {
      hcr = HealthCheckResponse.named("serviceB")
                                .withData("healthy", healthy)
                                .up().build();
    } else {
      hcr = HealthCheckResponse.named("serviceB")
                                .withData("healthy", healthy)
                                .down().build();
    }

    System.out.println("Health endpoint called: " + hcr);
    return hcr;
  }
}
