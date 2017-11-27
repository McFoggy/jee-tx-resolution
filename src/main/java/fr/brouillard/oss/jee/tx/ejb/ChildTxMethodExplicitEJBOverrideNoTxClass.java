package fr.brouillard.oss.jee.tx.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ChildTxMethodExplicitEJBOverrideNoTxClass extends BaseEJBTxMethodExplicit {
    @Override
    public boolean method(String caller) {
        return super.method(caller);
    }
}
