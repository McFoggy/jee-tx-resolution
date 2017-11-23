package fr.brouillard.oss.jee.tx.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ChildNoTxEJBNoOverrideTxOnClassExplicit extends BaseNoTx {
}
