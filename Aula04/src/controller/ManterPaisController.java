package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import service.ClienteService;
/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterCliente.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**

	 * @see HttpServlet#doGet(HttpServletRequest request,
HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,
HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {

		String pPais = request.getParameter("pais");
		long pPopulacao = request.getParameter("populacao");
		double pArea = request.getParameter("area");
		String acao = request.getParameter("acao");
		//instanciar o javabean
		Cliente cliente = new Cliente();
		cliente.setPais(pPais);
		cliente.setPopulacao(pPopulacao);
		cliente.setArea(pArea);
		//instanciar o service
		ClienteService cs = new ClienteService();
		RequestDispatcher dispatcher = null;
		switch(acao){
		case "Incluir":
			cs.criar(cliente);
			cliente = cs.carregar(cliente.getId());
			//manda parametro para o JSP via request
			request.setAttribute("cliente", cliente);
			dispatcher =

					request.getRequestDispatcher("Cliente.jsp");

			break;
		case "Listar":
			ArrayList<Cliente> clientes = cs.listarTodos();
			request.setAttribute("clientes", clientes);
			dispatcher =

					request.getRequestDispatcher("ListaDeClientes.jsp");

		}
		//despachar para o JSP correto
		dispatcher.forward(request, response);
	}
}