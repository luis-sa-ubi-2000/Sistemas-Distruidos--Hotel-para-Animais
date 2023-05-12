package com.example.demo;


import jakarta.persistence.*;


@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    private String tipo;

    private boolean disponivel;

    private double preco;

    private String capacidade;

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public boolean isDisponivel() {
		return disponivel;
	}



	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}



	public double getPreco() {
		return preco;
	}



	public void setPreco(double preco) {
		this.preco = preco;
	}



	@Override
	public String toString() {
		return "Quarto [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", disponivel=" + disponivel + ", preco="
				+ preco + "]";
	}
	
}
    
    
