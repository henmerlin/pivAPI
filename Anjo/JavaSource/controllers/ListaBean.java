package controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.Atendimento;
import models.sistema.AtendimentoServico;

@ManagedBean
@ViewScoped
public class ListaBean {

	private List<Atendimento> listaDeAtendimento;
	
	private List<Atendimento> listaDeAtendimentoFiltrada;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	@EJB
	private AtendimentoServico atendimentoServico;
	
	
	public void listarAtendimentosRegistrados() {
		
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
				
		this.listaDeAtendimento = this.atendimentoServico.listarAtendimentosPorData(this.dataInicio, this.dataFim);
		
	}


	public List<Atendimento> getListaDeAtendimento() {
		return listaDeAtendimento;
	}


	public void setListaDeAtendimento(List<Atendimento> listaDeAtendimento) {
		this.listaDeAtendimento = listaDeAtendimento;
	}


	public List<Atendimento> getListaDeAtendimentoFiltrada() {
		return listaDeAtendimentoFiltrada;
	}


	public void setListaDeAtendimentoFiltrada(List<Atendimento> listaDeAtendimentoFiltrada) {
		this.listaDeAtendimentoFiltrada = listaDeAtendimentoFiltrada;
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
