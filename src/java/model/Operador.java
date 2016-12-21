package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author G0042204
 */
@Entity(name = "MIS_PAINEL_ATENDIMENTO")
public class Operador implements Serializable {

    @Id
    @Column(name = "MATRICULA_ANTIGA")
    private String login;

    public Operador() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
