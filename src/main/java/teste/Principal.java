package teste;


import java.util.ArrayList;
import br.usuario.dao.UsuarioDAO;
import br.usuario.entidade.Usuario;

public class Principal {

	public static void main(String[] args) {
		UsuarioDAO usrDAO = new UsuarioDAO();
		//gerar cadastro (tirar/colocar o comentario para adicionar usuario no banco a cada execução.) 
		
		Usuario umUsr = new Usuario();
		
		umUsr.setNome("TESTE_novo");
		umUsr.setSenha("123456");
		umUsr.setEmail("teste_novo@tr.tr");
		umUsr.setTelefone("98989898989");
		
		usrDAO.inserirUsuario(umUsr);
		
		
		
		//Alterar um usuario (tirar comentario e setar valores para alterar)
		
		/*Usuario umUsr = new Usuario();
		
		umUsr.setNome("TESTE_novo_USUARIO_ALTERADO");
		umUsr.setSenha("123456");
		umUsr.setEmail("teste_novo@tr.tr");
		umUsr.setTelefone("98989898989");
		umUsr.setId(2);
		usrDAO.alterarUsuario(umUsr);*/
		
		

		//excluir usuario (tirar comentario e setar Id do usuario a ser excluido.)
		
		/*Usuario umUsr = new Usuario();
		
		umUsr.setId(1);
		
		usrDAO.excluiUsuario(umUsr);*/
		
		
		
		//listar cadastros no banco(rodar para gerar lista de usuarios atualizada no banco.)
		ArrayList<Usuario> listUsuarios = usrDAO.listarTodosUsuarios();
		for(Usuario umUsuario : listUsuarios)
			System.out.println(umUsuario.toString());
		
	}

}
