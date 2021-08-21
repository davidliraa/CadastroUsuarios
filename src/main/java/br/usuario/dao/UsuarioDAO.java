package br.usuario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.conexao.jdbc.CNXJDBC;
import br.usuario.entidade.Usuario;

public class UsuarioDAO {
	private final String SQL_INSERE_USUARIO= "INSERT INTO CadastroUsuarios(\"NOME\",\"SENHA\", \"EMAIL\", \"TELEFONE\") VALUES (?,?,?,?);";
	private final String SQL_ALTERA_USUARIO= "UPDATE CadastroUsuarios SET NOME=?, SENHA=?, EMAIL=?, TELEFONE=? where ID=?;";
	private final String SQL_EXCLUI_USUARIO= "DELETE FROM CadastroUsuarios WHERE ID=?";
	private final String SQL_SELECIONA_USUARIO = "SELECT * FROM CadastroUsuarios;";
	
	private PreparedStatement pst = null;
	
	public boolean inserirUsuario(Usuario umUsuario) {
		boolean ret = false;
		Connection conn = CNXJDBC.conectar();
		try {
			pst = conn.prepareStatement(SQL_INSERE_USUARIO);
			pst.setString(1, umUsuario.getNome());
			pst.setString(2, umUsuario.getSenha());
			pst.setString(3, umUsuario.getEmail());
			pst.setString(4, umUsuario.getTelefone());
			ret = pst.execute();
			pst.close();
			CNXJDBC.fecharCNX();
		}catch (SQLException e) {
			System.out.println("Erro ao executar o Statment "+ e.toString());;
		}
		return ret;
	}

	
	public ArrayList<Usuario> listarTodosUsuarios() {
		ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		Connection conn = CNXJDBC.conectar();
		Usuario umUsuario;
		try {
			pst = conn.prepareStatement(SQL_SELECIONA_USUARIO);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				umUsuario = new Usuario();
				umUsuario.setId(rs.getInt("ID"));
				umUsuario.setNome(rs.getString("NOME"));
				umUsuario.setSenha(rs.getString("SENHA"));
				umUsuario.setEmail(rs.getString("EMAIL"));
				umUsuario.setTelefone(rs.getString("TELEFONE"));
				listaDeUsuarios.add(umUsuario);
			}
			rs.close();
			pst.close();
			CNXJDBC.fecharCNX();
		}catch (SQLException e) {
			System.out.println("Erro ao executar o Statment "+e.toString());
		}
		return listaDeUsuarios;
	}
	
	public boolean alterarUsuario(Usuario umUsuario) {
		boolean ret = false;
		Connection conn = CNXJDBC.conectar();
		try {
			pst = conn.prepareStatement(SQL_ALTERA_USUARIO);
			pst.setString(1, umUsuario.getNome());
			pst.setString(2, umUsuario.getSenha());
			pst.setString(3, umUsuario.getEmail());
			pst.setString(4, umUsuario.getTelefone());
			pst.setInt(5, umUsuario.getId());
			ret = pst.execute();
			pst.close();
			CNXJDBC.fecharCNX();
		}catch (SQLException e) {
				System.out.println("Erro ao executar o Statment " + e.toString());
			}
			return ret;
	}

	public boolean excluiUsuario(Usuario umUsuario) {
		boolean ret = false;
		Connection conn = CNXJDBC.conectar();
		try {
			pst = conn.prepareStatement(SQL_EXCLUI_USUARIO);
			pst.setInt(1, umUsuario.getId());
			ret = pst.execute();
			pst.close();
			CNXJDBC.fecharCNX();
		}catch (SQLException e) {
			System.out.println("Erro ao executar o Statment " + e.toString());
		}
		return ret;
	}
}
