package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.Duvida;
import java.util.Arrays;
import java.util.Collections;
import models.sistema.DuvidaServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class DuvidaBean {

    private Duvida duvida;

    private Duvida duvidaModifica;

    @EJB
    private DuvidaServico duvidaServico;

    public DuvidaBean() {

        this.duvida = new Duvida();

        this.duvidaModifica = new Duvida();

    }

    public void cadastrarDuvida() {

        try {

            this.duvidaServico.cadastrarDuvida(this.duvida);
            JSFUtil.addInfoMessage("Duvida cadastrada com sucesso.");
            this.duvida = new Duvida();

        } catch (Exception e) {

            JSFUtil.addErrorMessage(e.getMessage());

        }

    }

    public void modificaDuvida() {

        try {

            this.duvidaServico.modificarDuvida(this.duvidaModifica);
            JSFUtil.addInfoMessage("Duvida modificada com sucesso.");
            this.duvidaModifica = new Duvida();

        } catch (Exception e) {

            JSFUtil.addErrorMessage(e.getMessage());

        }

    }

    public List<Duvida> listaTodasDuvidas() {

        return this.duvidaServico.listaTodasDuvidas();

    }

    public List<Duvida> listaDuvidasLista(Boolean lista, Boolean ativo) {
        List<Duvida> ds = this.duvidaServico.listaDuvidasLista(lista, ativo);
        Collections.sort(ds);
        return ds;

    }

    public Duvida getDuvida() {
        return duvida;
    }

    public void setDuvida(Duvida duvida) {
        this.duvida = duvida;
    }

    public Duvida getDuvidaModifica() {
        return duvidaModifica;
    }

    public void setDuvidaModifica(Duvida duvidaModifica) {
        this.duvidaModifica = duvidaModifica;
    }

}
