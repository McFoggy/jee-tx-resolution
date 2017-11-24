package fr.brouillard.oss.jee.tx.jta;

import fr.brouillard.oss.jee.tx.TCT;
import fr.brouillard.oss.jee.tx.TxCheckerType;

@TCT(TxCheckerType.JTA_BASE_NO_TX_OVERRIDE_DEFAULTS)
public class ChildNoTxOverrideDefaults extends BaseNoTx {
    @Override
    public boolean method(String caller) {
        return super.method(caller);
    }
}
