/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.entidades;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PE_ENQUETE")
public class Enquete extends ComponentePortal {

    public Enquete() {
    }

    private Calendar dataInicio;

    private Calendar dataFim;

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

}
