package model.entitiy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MIS_PAINEL_ATENDIMENTO")
public class IndicadoresOperador implements Serializable {

    @Id
    @Column(name = "MATRICULA_ANTIGA")
    private String loginOperador;

    @Column(name = "AVAYA", nullable = true)
    private String avaya;

    @Column(name = "COLABORADOR", nullable = true)
    private String nome;

    @Column(name = "SUPERVISOR", nullable = true)
    private String nomeSupervisor;

    @Column(name = "EQUIPE")
    private String equipe;

    @Column(name = "FALTAS", nullable = true)
    private Integer faltas;

    @Column(name = "DIAS_TRABALHADOS", nullable = true)
    private Integer diasTrabalhados;

    @Column(name = "TOTAL_IN", nullable = true)
    private Double totalIn;

    @Column(name = "SCHED", nullable = true)
    private Double sched;

    @Column(name = "CA_", nullable = true)
    private Integer chamadasAtendidas;

    @Column(name = "TEMPO_FALADO", nullable = true)
    private Double tempoFalado;

    @Column(name = "FCR_CHAMADAS", nullable = true)
    private Integer chamadasFCR;

    @Column(name = "FCR_RECHAMADAS", nullable = true)
    private Integer rechamadasFCR;

    public IndicadoresOperador() {
    }

    public IndicadoresOperador(String loginOperador) {
        this.loginOperador = loginOperador;
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
}
