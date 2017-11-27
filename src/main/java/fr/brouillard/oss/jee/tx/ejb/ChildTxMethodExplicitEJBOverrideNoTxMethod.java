package fr.brouillard.oss.jee.tx.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class ChildTxMethodExplicitEJBOverrideNoTxMethod extends BaseEJBTxMethodExplicit {
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public boolean method(String caller) {
        return super.method(caller);
    }
}

