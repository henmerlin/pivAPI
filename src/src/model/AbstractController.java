package src.model;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import javax.inject.Inject;

public abstract class AbstractController {

    @Inject
    protected Result result;

    @Inject
    protected Validator validation;


}
