package org.eclipse.microprofile.ft.serviceb;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TiredExceptionMapper implements ExceptionMapper<TiredException> {

    @Override
    public Response toResponse(TiredException ex) {
        return Response.status(500)
                       .entity(ex.getMessage())
                       .build();
    }

}
