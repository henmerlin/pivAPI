package model.entitiy;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "MIS_PAINEL_ATENDIMENTO_CWB_SP")
public class IndicadoresOperador implements Serializable {

    @Id
    @Column(name = "MATRICULA_ANTIGA")
    private String loginOperador;

    @Column(name = "AVAYA")
    private String avaya;

    @Column(name = "DATA_ADMISSAO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataAdmissao;

    @Column(name = "DATA_TMA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataTma;

    @Column(name = "DATA_FCR")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataFcr;

    @Column(name = "DATA_ABS")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataAbs;

    @Column(name = "DATA_ADERENCIA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataAdr;

    @Column(name = "COLABORADOR")
    private String nome;

    @Column(name = "SUPERVISOR")
    private String nomeSupervisor;

    @Column(name = "EQUIPE")
    private String equipe;

    @Column(name = "FALTAS")
    private Integer faltas;

    @Column(name = "DIAS_TRABALHADOS")
    private Integer diasTrabalhados;

    @Column(name = "TOTAL_IN")
    private Double totalIn;

    @Column(name = "SCHED")
    private Double sched;

    @Column(name = "CA_")
    private Integer chamadasAtendidas;

    @Column(name = "TEMPO_FALADO")
    private Double tempoFalado;

    @Column(name = "FCR_CHAMADAS")
    private Integer chamadasFCR;

    @Column(name = "FCR_RECHAMADAS")
    private Integer rechamadasFCR;

    public IndicadoresOperador() {
    }

    public IndicadoresOperador(String loginOperador) {
        this.loginOperador = loginOperador;
    }

    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setLoginOperador(String loginOperador) {
        this.loginOperador = loginOperador;
    }

    public String getLoginOperador() {
        return loginOperador;
    }

    public void setAvaya(String avaya) {
        this.avaya = avaya;
    }

    public String getAvaya() {
        return avaya;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNomeSupervisor(String nomeSupervisor) {
        this.nomeSupervisor = nomeSupervisor;
    }

    public String getNomeSupervisor() {
        return nomeSupervisor;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setDiasTrabalhados(Integer diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    public Integer getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setTotalIn(Double totalIn) {
        this.totalIn = totalIn;
    }

    public Double getTotalIn() {
        return totalIn;
    }

    public void setSched(Double sched) {
        this.sched = sched;
    }

    public Double getSched() {
        return sched;
    }

    public void setChamadasAtendidas(Integer chamadasAtendidas) {
        this.chamadasAtendidas = chamadasAtendidas;
    }

    public Integer getChamadasAtendidas() {
        return chamadasAtendidas;
    }

    public void setTempoFalado(Double tempoFalado) {
        this.tempoFalado = tempoFalado;
    }

    public Double getTempoFalado() {
        return tempoFalado;
    }

    public void setChamadasFCR(Integer chamadasFCR) {
        this.chamadasFCR = chamadasFCR;
    }

    public Integer getChamadasFCR() {
        return chamadasFCR;
    }

    public void setRechamadasFCR(Integer rechamadasFCR) {
        this.rechamadasFCR = rechamadasFCR;
    }

    public Integer getRechamadasFCR() {
        return rechamadasFCR;
    }

    public Calendar getDataTma() {
        return dataTma;
    }

    public void setDataTma(Calendar dataTma) {
        this.dataTma = dataTma;
    }

    public Calendar getDataFcr() {
        return dataFcr;
    }

    public void setDataFcr(Calendar dataFcr) {
        this.dataFcr = dataFcr;
    }

    public Calendar getDataAbs() {
        return dataAbs;
    }

    public void setDataAbs(Calendar dataAbs) {
        this.dataAbs = dataAbs;
    }

    public Calendar getDataAdr() {
        return dataAdr;
    }

    public void setDataAdr(Calendar dataAdr) {
        this.dataAdr = dataAdr;
    }

}
