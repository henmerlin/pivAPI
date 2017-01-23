package model.business.equipe;

/**
 *
 * @author G0042204
 */
public enum Equipe {

    /* CWB */
    CHECKLIST("CHECKLIST", Site.CWB, false, 340d),
    MULTISKILL("MULTISKILL", Site.CWB, true, 360d),
    MULTISKILL_NOVOS("MULTISKILL NOVOS", Site.CWB, false, 360d),
    ESPECIALIZADA("ESPECIALIZADA", Site.CWB, true, 498d),
    CADASTRO("CADASTRO", Site.CWB, true, 510d),
    TRIAGEM("TRIAGEM", Site.CWB, false, 1d),
    /* SP */
    CERTIFICACAO_COBRE("CERTIFICACAO MASSIVA", Site.SP, false, 300d),
    CERTIFICACAO_FIBRA("CERTIFICACAO FIBRA", Site.SP, false, 470d),
    TRIAGEM_SP("TRIAGEM - SÃO PAULO", Site.SP, false, 1d),
    SUPORTE_IPTV("SUPORTE IPTV", Site.SP, true, 710d),
    SUPORTE_COBRE("SUPORTE COBRE", Site.SP, true, 290d),
    SUPORTE_FIBRA("SUPORTE FIBRA", Site.SP, true, 710d);

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
