package br.com.a2dm.spdmws.ws;

import java.math.BigInteger;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.a2dm.brcmn.util.HibernateUtil;
import br.com.a2dm.spdm.exception.ApiException;
import br.com.a2dm.spdm.exception.ExceptionUtils;
import br.com.a2dm.spdm.omie.service.CargaResultado;
import br.com.a2dm.spdm.omie.service.OmieCargaProdutoService;
import br.com.a2dm.spdm.omie.service.OmieCargaTabelaPrecoItemService;
import br.com.a2dm.spdm.omie.service.OmieCargaTabelaPrecoService;
import br.com.a2dm.spdm.service.ProdutoService;

@Path("/carga")
public class CargaWS {

	@POST
	@Path("/produtos")
	@Produces(MediaType.APPLICATION_JSON)
	public CargaResultado cargaProdutos() throws ApiException {
		try {
			return OmieCargaProdutoService.getInstance().executar();
		} catch (Exception e) {
			throw ExceptionUtils.handlerApiException(e);
		}
	}

	@POST
	@Path("/tabelas-preco")
	@Produces(MediaType.APPLICATION_JSON)
	public CargaResultado cargaTabelasPreco() throws ApiException {
		try {
			return OmieCargaTabelaPrecoService.getInstance().executar();
		} catch (Exception e) {
			throw ExceptionUtils.handlerApiException(e);
		}
	}

	@POST
	@Path("/itens-tabela-preco")
	@Produces(MediaType.APPLICATION_JSON)
	public CargaResultado cargaItensTabelaPreco() throws ApiException {
		try {
			return OmieCargaTabelaPrecoItemService.getInstance().executar();
		} catch (Exception e) {
			throw ExceptionUtils.handlerApiException(e);
		}
	}
}
