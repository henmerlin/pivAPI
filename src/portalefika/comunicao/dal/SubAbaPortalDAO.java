package portalefika.comunicao.dal;

import javax.transaction.Transactional;
import portalefika.comunicao.entidades.ComponentePortal;
import portalefika.comunicao.entidades.SubAbaPortal;

public class SubAbaPortalDAO extends ComponentePortalDAO {

    @Override
    @Transactional
    public void cadastrar(ComponentePortal c) {
        super.cadastrar((SubAbaPortal) c);
    }

}
