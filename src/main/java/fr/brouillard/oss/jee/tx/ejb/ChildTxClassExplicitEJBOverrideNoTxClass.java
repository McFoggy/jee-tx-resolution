package fr.brouillard.oss.jee.tx.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ChildTxClassExplicitEJBOverrideNoTxClass extends BaseTxClassExplicit {
    @Override
    public boolean method(String caller) {
        return super.method(caller);
    }
}
