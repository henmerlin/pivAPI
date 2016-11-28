package portalefika.comunicao.dal;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import portalefika.comunicao.entidades.AbaPortal;
import portalefika.comunicao.entidades.ComponentePortal;

@Stateless
public class AbaPortalDAO extends ComponentePortalDAO {

    @Override
    @Transactional
    public void cadastrar(ComponentePortal c) {
        super.cadastrar((AbaPortal) c);
    }

}
