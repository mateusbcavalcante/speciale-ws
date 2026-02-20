package br.com.a2dm.spdmws.ws;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.a2dm.brcmn.dto.ClienteDTO;
import br.com.a2dm.brcmn.dto.ClienteIntegracaoDTO;
import br.com.a2dm.spdm.exception.ApiException;
import br.com.a2dm.spdm.exception.ExceptionUtils;
import br.com.a2dm.spdm.omie.payload.ClienteWebhookPayload;
import br.com.a2dm.spdm.omie.service.OmieClienteService;

@Path("/clientes")
public class ClientesWS {
	
	@GET
	@Path("/idExternoOmie/{idExternoOmie}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteIntegracaoDTO pesquisarCliente(@PathParam("idExternoOmie") BigInteger idExternoOmie) throws ApiException {
		try {
			return OmieClienteService.getInstance().pesquisarCliente(idExternoOmie);
		} catch (Exception e) {
			throw ExceptionUtils.handlerApiException(e);
		}
	}

	@GET
	@Path("/{nomeCliente}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteDTO> pesquisarClientes(@PathParam("nomeCliente") String nomeCliente) throws ApiException {
		try {
			return OmieClienteService.getInstance().pesquisarClientes(nomeCliente);
		} catch (Exception e) {
			throw ExceptionUtils.handlerApiException(e);
		}
	}
	
	@GET
	@Path("/omie")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> pesquisarClientesOMIE(List<String> clientes) throws ApiException {
		try {
			return OmieClienteService.getInstance().pesquisarClientesList(clientes);
		} catch (Exception e) {
			throw ExceptionUtils.handlerApiException(e);
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<BigInteger> alterarClientes(List<String> clientes) throws ApiException {
		try {
			return OmieClienteService.getInstance().alterarClientes(clientes);
		} catch (Exception e) {
			throw ExceptionUtils.handlerApiException(e);
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response processar(ClienteWebhookPayload clienteWebhookPayload) throws ApiException {
	    try {
	    	if (clienteWebhookPayload.getMessageId() != null) {	    		
	    		OmieClienteService.getInstance().processar(clienteWebhookPayload);
	    	}

	        Map<String, Object> responseJson = new HashMap<>();
	        responseJson.put("resultCode", 0);
	        responseJson.put("resultMsg", "");

	        return Response.ok(responseJson).build();
	    } catch (Exception e) {
	        throw ExceptionUtils.handlerApiException(e);
	    }
	}
}

