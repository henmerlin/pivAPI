package model.business.equipe;

/**
 *
 * @author G0042204
 */
public enum Equipe {

    /* CWB */
    CHECKLIST("CHECKLIST", Site.CWB, false, 340d),
    MULTISKILL("MULTISKILL", Site.CWB, true, 360d),
    MULTISKILL_NOVOS("MULTISKILL NOVOS", Site.CWB, true, 360d),
    ESPECIALIZADA("ESPECIALIZADA", Site.CWB, true, 498d),
    CADASTRO("CADASTRO", Site.CWB, true, 510d),
    TRIAGEM("TRIAGEM", Site.CWB, false, 1d),
    /* SP */
    CERTIFICACAO_COBRE("CERTIFICAÇÃO COBRE", Site.SP, false, 300d),
    CERTIFICACAO_FIBRA("CERTIFICAÇÃO FIBRA", Site.SP, false, 470d),
    TRIAGEM_SP("TRIAGEM - SÃO PAULO", Site.SP, false, 1d),
    SUPORTE_N1("SUPORTE - N1", Site.SP, false, 710d),
    SUPORTE_N2("SUPORTE - N2", Site.SP, false, 710d),
    SUPORTE_COBRE("SUPORTE - COBRE", Site.SP, false, 290d);

    private final String nome;

    private final Site site;

    private final Boolean ativo;

    private final Double tma;

    private Equipe(String nome, Site site, Boolean ativo, Double tma) {
        this.nome = nome;
        this.site = site;
        this.ativo = ativo;
        this.tma = tma;
    }

    public String getNome() {
        return nome;
    }

    public Site getSite() {
        return site;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Double getTma() {
        return tma;
    }

    /**
     * De-para para Inumerados
     *
     * @param nome
     * @return
     */
    public static Equipe buscarPorNome(String nome) {

        for (Equipe eqp : Equipe.values()) {
            if (eqp.getNome().equalsIgnoreCase(nome)) {
                return eqp;
            }
        }
        return null;
    }

}
