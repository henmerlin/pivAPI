package model.business.equipe;

/**
 *
 * @author G0042204
 */
public enum Equipe {

    MULTISKILL("MULTISKILL", Site.CWB),
    MULTISKILL_NOVOS("MULTISKILL NOVOS", Site.CWB),
    ESPECIALIZADA("ESPECIALIZADA", Site.CWB),
    CADASTRO("CADASTRO", Site.CWB);

    public String nome;

    public Site site;

    private Equipe(String nome, Site site) {
        this.nome = nome;
        this.site = site;
    }

    public String getNome() {
        return nome;
    }

    public Site getSite() {
        return site;
    }

}
