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
import br.com.a2dm.spdm.omie.payload.TabelaPrecoItemWebhookPayload;
import br.com.a2dm.spdm.omie.service.OmieTabelaPrecoItemWebhookService;

@Path("/tabelas-preco-item")
public class TabelaPrecoItemWS {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response processar(TabelaPrecoItemWebhookPayload tabelaPrecoItemWebhookPayload) throws ApiException {
		try {
			if (tabelaPrecoItemWebhookPayload.getMessageId() != null) {
				OmieTabelaPrecoItemWebhookService.getInstance().processar(tabelaPrecoItemWebhookPayload);
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
