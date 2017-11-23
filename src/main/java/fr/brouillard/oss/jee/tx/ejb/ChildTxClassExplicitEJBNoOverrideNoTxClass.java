package fr.brouillard.oss.jee.tx.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ChildTxClassExplicitEJBNoOverrideNoTxClass extends BaseTxClassExplicit {
}
