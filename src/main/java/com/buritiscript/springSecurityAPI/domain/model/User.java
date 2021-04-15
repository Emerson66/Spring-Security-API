package com.buritiscript.springSecurityAPI.domain.model;

import java.time.LocalDate;

public class User {
	

	private Long id;
	
	private String usuario;
	private String senha;
	private String nomeCompleto;
	
	private LocalDate dataCriacao;
	private LocalDate dataModificacao;
	
}
