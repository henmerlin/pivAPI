package portalefika.comunicao.entidades;

import java.util.Calendar;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class ComponenteExpiravel extends ComponentePortal {
    
    private Calendar dataInicio;

    private Calendar dataFim;

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    public Calendar getDataFim() {
        return dataFim;
    }
}
