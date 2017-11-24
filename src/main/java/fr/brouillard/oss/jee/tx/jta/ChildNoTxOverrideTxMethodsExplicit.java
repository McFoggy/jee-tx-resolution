package fr.brouillard.oss.jee.tx.jta;

import javax.transaction.Transactional;

import fr.brouillard.oss.jee.tx.TCT;
import fr.brouillard.oss.jee.tx.TxCheckerType;

@TCT(TxCheckerType.JTA_BASE_NO_TX_OVERRIDE_TX_METHODS_EXPLICIT)
public class ChildNoTxOverrideTxMethodsExplicit extends BaseNoTx {
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public boolean method(String caller) {
        return super.method(caller);
    }
}
