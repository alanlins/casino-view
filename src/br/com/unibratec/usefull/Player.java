package br.com.unibratec.usefull;

import java.io.Serializable;


public class Player implements Serializable {
	
	private static final long serialVersionUID = -748616466532431361L;
	
	private Long id;
	private String nick;
	private String nome;
	private String jogo;
	private String email;
	

	

	public Player(Long id, String nick, String nome, String jogo, String email) {
		super();
		this.id = id;
		this.nick = nick;
		this.nome = nome;
		this.jogo = jogo;
		this.email = email;
	}
	
	public Player () {
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getJogo() {
		return jogo;
	}

	public void setJogo(String jogo) {
		this.jogo = jogo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	@Override
	public String toString() {
		return "Player {id=" + id + ", nick='" + nick + "', nome='" + nome + "',  jogo='" + jogo + "' , email ='"+email +"'}";
	}

	

	
	@Override
	public int hashCode() {
		final int prime = 51;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
