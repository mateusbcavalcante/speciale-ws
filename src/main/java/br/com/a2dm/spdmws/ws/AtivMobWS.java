package br.com.a2dm.spdmws.ws;

import br.com.a2dm.brcmn.dto.ativmob.EventDTO;
import br.com.a2dm.spdm.ativmob.service.AtivMobService;
import br.com.a2dm.spdm.exception.ApiException;
import br.com.a2dm.spdm.exception.ExceptionUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Path("/ativmob")
public class AtivMobWS {

//    @GET
//    @Path("/eventos/{cnpj}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<EventDTO> buscarEventos(@PathParam("cnpj") BigInteger cnpj) throws ApiException {
//        try {
//            return AtivMobService.getInstance().buscarEvents(cnpj);
//        } catch (Exception e) {
//            throw ExceptionUtils.handlerApiException(e);
//        }
//    }

    @POST
    @Path("/events/{cnpj}")
    @Produces(MediaType.APPLICATION_JSON)
    public void salvarEvents(@PathParam("cnpj") BigInteger cnpj) throws ApiException {
        try {
            AtivMobService service = AtivMobService.getInstance();
            ArrayList<EventDTO> events = service.buscarEvents(cnpj);
            service.marcarLidoEvents(events);
            service.salvarEvents(events);
        } catch (Exception e) {
            throw ExceptionUtils.handlerApiException(e);
        }
    }

}
