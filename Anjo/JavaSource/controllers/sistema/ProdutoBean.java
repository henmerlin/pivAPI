package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.Produto;
import models.sistema.ProdutoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto produto;
	
	private Produto produtoModifica;
	
	@EJB
	private ProdutoServico produtoServico;
	
	public ProdutoBean() {

		this.produto = new Produto();
		
		this.produtoModifica = new Produto();
		
	}
	
	public void cadastrarProduto() {
		
		try {
			
			this.produtoServico.cadastrarProduto(this.produto);
			JSFUtil.addInfoMessage("Produto cadastrado com sucesso.");
			this.produto = new Produto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarProduto() {
		
		try {
			
			this.produtoServico.modificarProduto(this.produtoModifica);
			JSFUtil.addInfoMessage("Produto modificado com sucesso.");
			this.produtoModifica = new Produto();			
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
	
	}
	
	public List<Produto> listarProduto() {
		
		return this.produtoServico.listarProduto();
		
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProdutoModifica() {
		return produtoModifica;
	}

	public void setProdutoModifica(Produto produtoModifica) {
		this.produtoModifica = produtoModifica;
	}	
	
}