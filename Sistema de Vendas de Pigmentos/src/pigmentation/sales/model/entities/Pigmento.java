package pigmentation.sales.model.entities;

import java.awt.Color;

import pigmentation.sales.model.session.ConverterCMYK;
import pigmentation.sales.model.session.Services;

public class Pigmento extends Services{
	
	private String id;
	private String nomeCor;
	private int qtdEstoque;
	private double preco;
	
	public Pigmento(String id, String nomeCor, 
			int qtdEstoque, double preco) {
		this.id = id;
		this.nomeCor = nomeCor;
		this.qtdEstoque = qtdEstoque;
		this.preco = preco;
	}

	public String getId() {
		return id;
	}

	public String getNomeCor() {
		return nomeCor;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public double getPreco() {
		return preco;
	}

	private void setId(String id) {
		this.id = id;
	}

	private void setNomeCor(String nomeCor) {
		this.nomeCor = nomeCor;
	}

	private void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	private void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public double distanceCalculator(Pigmento p1, Pigmento p2) {
		// TODO Auto-generated method stub
		return 0;
	}	
	
}