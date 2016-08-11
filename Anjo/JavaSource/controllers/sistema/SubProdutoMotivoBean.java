package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import models.sistema.SubProdutoMotivo;
import models.sistema.SubProdutoMotivoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class SubProdutoMotivoBean {
	
	private SubProdutoMotivo subProdutoMotivo;
	
	private SubProdutoMotivo subProdutoMotivoModifica;
	
	@EJB
	private SubProdutoMotivoServico subProdutoMotivoServico;
	
	public SubProdutoMotivoBean() {
		
		this.subProdutoMotivo = new SubProdutoMotivo();
		
		this.subProdutoMotivoModifica = new SubProdutoMotivo();
		
	}
	
	public void cadastrarSubProdutoMotivo() {
		
		try {
			
			this.subProdutoMotivoServico.cadastrarSubProdutoMotivo(this.subProdutoMotivo);
			JSFUtil.addInfoMessage("Sub Produto Motivo cadastrado com sucesso.");
			this.subProdutoMotivo = new SubProdutoMotivo();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarSubProdutoMotivo() {
		
		try {
			
			this.subProdutoMotivoServico.modificaSubProdutoMotivo(this.subProdutoMotivoModifica);
			JSFUtil.addInfoMessage("Sub Produto Motivo modificado com sucesso.");
			this.subProdutoMotivoModifica = new SubProdutoMotivo();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<SubProdutoMotivo> listarSubProdutoMotivo() {
		
		return this.subProdutoMotivoServico.listarSubProdutoMotivo();
		
	}

	public SubProdutoMotivo getSubProdutoMotivo() {
		return subProdutoMotivo;
	}

	public void setSubProdutoMotivo(SubProdutoMotivo subProdutoMotivo) {
		this.subProdutoMotivo = subProdutoMotivo;
	}

	public SubProdutoMotivo getSubProdutoMotivoModifica() {
		return subProdutoMotivoModifica;
	}

	public void setSubProdutoMotivoModifica(SubProdutoMotivo subProdutoMotivoModifica) {
		this.subProdutoMotivoModifica = subProdutoMotivoModifica;
	}	
	
}
