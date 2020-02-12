package clienteweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.monthalcantara.model.Cliente;
import br.com.monthalcantara.service.ClienteService;

@WebServlet(urlPatterns = "/cliente")
public class ClienteServlet extends HttpServlet {

	Cliente cli;
	ClienteService clienteservice = new ClienteService();

	public ClienteServlet() {// TomCat cria uma instância do Servlet
		System.out.println("Construindo Servlet...");
	}

	@Override
	public void init() throws ServletException {// TomCat inicia a instância que ele criou

		System.out.println("Iniciando o Servlet...");
		super.init();
	}

	@Override // Pega os pedidos vindo do Browser e encaminha para o doPost ou doGet
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamando o Service...");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String i = req.getParameter("i");
		if (i != null && i != "") {
			clienteservice.excluir(Integer.parseInt(i));
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", clienteservice.getLista());
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		// Capturando email da tela de formulario
		String email = req.getParameter("email");

		// Criando um objeto de Cliente
		cli = new Cliente();

		// setando email no cliente
		cli.setEmail(email);

		// Adcionando à lista de Clientes

		clienteservice.cadastrar(cli);

		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("msg", "Cadastrado com Sucesso");
		req.setAttribute("lista", clienteservice.getLista());
		dispatcher.forward(req, resp);

		// resp.getWriter().print("Chamou pelo método POST adicionando o cliente: " +
		// email);
		// resp.sendRedirect("cliente");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou o método DELETE");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método PUT ");
	}

	@Override
	public void destroy() {// Encerra o ciclo de vida do Servlet
		System.out.println("Servlet será destruído");
		super.destroy();
	}
}
