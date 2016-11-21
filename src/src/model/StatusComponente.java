package src.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "PE_STATUSCOMPONENTE")
public class StatusComponente {

    @Id
    private Integer id;

    @NotEmpty
    private String nome;

    public StatusComponente() {
    }

    public StatusComponente(Integer id) {
        this.id = id;
    }

    public StatusComponente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
