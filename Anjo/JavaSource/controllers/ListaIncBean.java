package controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistemainc.AtendimentoInc;
import models.sistemainc.AtendimentoIncServico;

@ManagedBean
@ViewScoped
public class ListaIncBean {

	private List<AtendimentoInc> listaAtendimentoInc;

	private Date dataInicio;

	private Date dataFim;

	@EJB
	private AtendimentoIncServico atendimentoIncServico;

	public ListaIncBean() {



	}

	public void listarIncsRegistrados() {

		Calendar cal = Calendar.getInstance();

		if (this.dataInicio == null) {

			Date date = new Date();

			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			cal.set(Calendar.HOUR_OF_DAY, -24);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);

			this.dataInicio = cal.getTime();

		}

		if (this.dataFim == null) {

			this.dataFim = this.dataInicio;

			cal.setTime(this.dataFim);
			cal.add(Calendar.DATE, 1);

			this.dataFim = cal.getTime();

		}else{

			cal.setTime(this.dataFim);
			cal.add(Calendar.DATE, 1);

			this.dataFim = cal.getTime();

		}
		
		this.listaAtendimentoInc = this.atendimentoIncServico.listarAtendimentoIncDate(this.dataInicio, this.dataFim);

	}


	public List<AtendimentoInc> getListaAtendimentoInc() {
		return listaAtendimentoInc;
	}

	public void setListaAtendimentoInc(List<AtendimentoInc> listaAtendimentoInc) {
		this.listaAtendimentoInc = listaAtendimentoInc;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
