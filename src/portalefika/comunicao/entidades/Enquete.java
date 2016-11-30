/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author G0034481
 */
@Entity
@Table(name = "PE_ENQUETE")
public class Enquete extends ComponentePortal {
    
    @NotNull
    private Date dataInicio;
    
    @NotNull
    private Date dataFim;

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
