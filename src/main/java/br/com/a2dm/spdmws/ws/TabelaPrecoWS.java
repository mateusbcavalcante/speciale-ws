package br.com.a2dm.spdmws.ws;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.a2dm.spdm.exception.ApiException;
import br.com.a2dm.spdm.exception.ExceptionUtils;
import br.com.a2dm.spdm.omie.payload.TabelaPrecoWebhookPayload;
import br.com.a2dm.spdm.omie.service.OmieTabelaPrecoWebhookService;

@Path("/tabelas-preco")
public class TabelaPrecoWS {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response processar(TabelaPrecoWebhookPayload tabelaPrecoWebhookPayload) throws ApiException {
		try {
			if (tabelaPrecoWebhookPayload.getMessageId() != null) {
				OmieTabelaPrecoWebhookService.getInstance().processar(tabelaPrecoWebhookPayload);
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
