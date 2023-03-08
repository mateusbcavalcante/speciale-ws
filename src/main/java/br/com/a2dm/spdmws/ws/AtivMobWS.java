package br.com.a2dm.spdmws.ws;

import java.math.BigInteger;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.a2dm.spdm.ativmob.service.AtivMobService;
import br.com.a2dm.spdm.entity.Event;
import br.com.a2dm.spdm.exception.ApiException;
import br.com.a2dm.spdm.exception.ExceptionUtils;

@Path("/ativmob")
public class AtivMobWS {

    @POST
    @Path("/events/{cnpj}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> proccessEvents(@PathParam("cnpj") BigInteger cnpj) throws ApiException {
        try {
            return AtivMobService.getInstance().proccessEvents(cnpj);
        } catch (Exception e) {
            throw ExceptionUtils.handlerApiException(e);
        }
    }
}