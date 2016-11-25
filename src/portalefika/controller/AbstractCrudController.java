package portalefika.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

public abstract class AbstractCrudController {

    @Inject
    protected Result result;

    @Inject
    protected Validator validation;

    public AbstractCrudController() {

    }

}
