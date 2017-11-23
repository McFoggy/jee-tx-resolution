package fr.brouillard.oss.jee.tx.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ChildNoTxEJBOverrideTxOnClassExplicit extends BaseNoTx {
    @Override
    public boolean method(String caller) {
        return super.method(caller);
    }
}
