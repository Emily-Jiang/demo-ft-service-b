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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ServiceBEndpoint {


    private static int count;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String callMe() throws Exception {

        count++;
        
        if ((count %10 >3) && (count %10 <7)){
            //x4, x5, x6 will succeed
            return "I'm happy from Service B. Invocation count: " + count;
        } else if (count % 10 >=7 ) {
            Thread.sleep(3000);//sleep for 8s
            return "I'm slow from Service B. Invocation count:" + count;
        } else {
            throw new Exception("Internal Server Error: I'm tired! Invocation count" + count);
        }
        
    }
    
}
