package fr.brouillard.oss.jee.tx.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class ChildNoTxEJBOverrideTxOnMethodsExplicit extends BaseNoTx {
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean method(String caller) {
        return super.method(caller);
    }
}
