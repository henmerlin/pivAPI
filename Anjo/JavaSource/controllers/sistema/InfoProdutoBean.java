package controllers.sistema;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.InfoProduto;
import models.sistema.InfoProdutoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class InfoProdutoBean {

	private InfoProduto infoProduto;

	private InfoProduto infoProdutoModifica;

	@EJB
	private InfoProdutoServico infoProdutoServico;

	public InfoProdutoBean() {

		this.infoProduto = new InfoProduto();

		this.infoProdutoModifica = new InfoProduto();

	}

	public void cadastrarInfoProduto() {

		try {
			
			this.infoProdutoServico.cadastrarInfoProduto(this.infoProduto);
			JSFUtil.addInfoMessage("Informação do produto cadastrada com sucesso.");
			this.infoProduto = new InfoProduto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}

	}

	public void modificarInfoProduto() {

		try {
			
			this.infoProdutoServico.modificarInfoProduto(this.infoProdutoModifica);
			JSFUtil.addInfoMessage("Informação do produto modificada com sucesso.");			
			this.infoProdutoModifica = new InfoProduto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}

	}


}
