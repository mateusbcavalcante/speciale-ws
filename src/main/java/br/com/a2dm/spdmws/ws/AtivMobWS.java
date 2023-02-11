package br.com.a2dm.spdmws.ws;

import br.com.a2dm.brcmn.dto.ClienteIntegracaoDTO;
import br.com.a2dm.spdm.exception.ApiException;
import br.com.a2dm.spdm.exception.ExceptionUtils;
import br.com.a2dm.spdm.omie.service.OmieClienteService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;

@Path("/ativmob")
public class AtivMobWS {

    @GET
    @Path("/eventos/{cnpj}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteIntegracaoDTO buscarEventos(@PathParam("cnpj") BigInteger cnpj) throws ApiException {
        try {
            return OmieClienteService.getInstance().pesquisarCliente(cnpj);
        } catch (Exception e) {
            throw ExceptionUtils.handlerApiException(e);
        }
    }

}
