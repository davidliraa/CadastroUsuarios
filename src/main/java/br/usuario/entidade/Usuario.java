package br.usuario.entidade;

public class Usuario {

	private int Id;
	private String Nome;
	private String Senha;
	private String Email;
	private String Telefone;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	
	public String toString() {
		return "Usuario [ ID=" + Id + " , Nome=" + Nome + " , Senha=" + Senha
				+ " , Email=" + Email + " ,Telefone=" + Telefone + "]";
	}
	
	public int hascode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((Senha == null) ? 0 : Senha.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Telefone == null) ? 0 : Telefone.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (Id != other.Id)
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (Senha == null) {
			if (other.Senha != null)
				return false;
		} else if (!Senha.equals(other.Senha))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		}else if (!Email.equals(other.Email))
			return false;
		if (Telefone == null) {
			if (other.Telefone != null)
				return false;
		}else if (!Telefone.equals(other.Telefone))
			return false;
		return true;
	}

}
