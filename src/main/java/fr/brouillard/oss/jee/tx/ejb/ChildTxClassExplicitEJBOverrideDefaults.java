package fr.brouillard.oss.jee.tx.ejb;

import javax.ejb.Stateless;

@Stateless
public class ChildTxClassExplicitEJBOverrideDefaults extends BaseEJBTxClassExplicit {
    @Override
    public boolean method(String caller) {
        return super.method(caller);
    }
}
