package br.com.tecbanbrms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import br.com.tecban.transacao;

public class ServletBrms extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Layout layout;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			transacao fatos = constroiRegra(request);
			layout = new Layout();
			layout.setMensagem2(fatos.getMsgErro());
			String[] acoes = fatos.getAcoes().split(";");
			for (String acao : acoes) {
				request.setAttribute("layout", layout);
				if (acao.equals("1")) {
					System.out.println("OK 1");
					request.getRequestDispatcher("Layout1.jsp").forward(request, response);
				}
				if (acao.equals("2")) {
					System.out.println("Imprimindo demonstrativo de ocorrência");
				}
				if (acao.equals("3")) {
					System.out.println("OK 3");
					request.getRequestDispatcher("Layout2.jsp").forward(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private transacao constroiRegra(HttpServletRequest request) {
		transacao fatos = new transacao();
		fatos.setIndErro(Integer.parseInt((request.getParameter("indErro"))));
		fatos.setCodResposta((String) request.getParameter("codResposta"));
		fatos.setIdTransacao(Integer.parseInt(request.getParameter("idTransacao")));
		fatos.setIF((String) request.getParameter("IF"));
		fatos.setCodErro((Integer.parseInt(request.getParameter("codErro"))));
		return fatos;

	}


}