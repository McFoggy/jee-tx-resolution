package fr.brouillard.oss.jee.tx.ejb;

import javax.ejb.Stateless;

@Stateless
public class ChildNoTxEJBOverrideDefaults extends BaseEJBNoTx {
    @Override
    public boolean method(String caller) {
        return super.method(caller);
    }
}
