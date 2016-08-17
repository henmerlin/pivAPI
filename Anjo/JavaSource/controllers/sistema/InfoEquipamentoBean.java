package controllers.sistema;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.InfoEquipamento;
import models.sistema.InfoEquipamentoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class InfoEquipamentoBean {

	private InfoEquipamento infoEquipamento;

	private InfoEquipamento infoEquipamentoModifica;

	@EJB
	private InfoEquipamentoServico infoEquipamentoServico;

	public InfoEquipamentoBean() {

		this.infoEquipamento = new InfoEquipamento();

		this.infoEquipamentoModifica = new InfoEquipamento();

	}

	public void cadastrarInfoEquipamento() {

		try {
			
			this.infoEquipamentoServico.cadastrarInfoEquipamento(this.infoEquipamento);
			JSFUtil.addInfoMessage("Informação de Equipamento foi cadastrado com sucesso.");
			this.infoEquipamento = new InfoEquipamento();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}

	}

	public void modificaInfoEquipamento() {

		try {
			
			this.infoEquipamentoServico.modificarInfoEquipamento(this.infoEquipamentoModifica);
			JSFUtil.addInfoMessage("Informação de Equipamento foi modificada com sucesso.");		
			this.infoEquipamentoModifica = new InfoEquipamento();
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}

	}

}
