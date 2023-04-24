package br.com.a2dm.spdmws.ws;

import java.math.BigInteger;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.a2dm.brcmn.dto.ativmob.EventDTO;
import br.com.a2dm.spdm.ativmob.service.AtivMobService;
import br.com.a2dm.spdm.entity.SugestaoPedido;
import br.com.a2dm.spdm.exception.ApiException;
import br.com.a2dm.spdm.exception.ExceptionUtils;

@Path("/ativmob")
public class AtivMobWS {

    @POST
    @Path("/sugestoesPedido/{cnpj}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SugestaoPedido> proccessSugestoesPedido(@PathParam("cnpj") BigInteger cnpj) throws ApiException {
        try {
            return AtivMobService.getInstance().proccessSugestoesPedido(cnpj);
        } catch (Exception e) {
            throw ExceptionUtils.handlerApiException(e);
        }
    }
    
    @POST
    @Path("/cadastrar-evento}")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public SugestaoPedido cadastrarEvento(EventDTO event) throws ApiException {
        try {
            return AtivMobService.getInstance().saveSugestaoPedido(event);
        } catch (Exception e) {
            throw ExceptionUtils.handlerApiException(e);
        }
    }
}