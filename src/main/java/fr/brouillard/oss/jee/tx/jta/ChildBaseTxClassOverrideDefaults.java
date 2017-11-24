package fr.brouillard.oss.jee.tx.jta;

import fr.brouillard.oss.jee.tx.TCT;
import fr.brouillard.oss.jee.tx.TxCheckerType;

@TCT(TxCheckerType.JTA_BASE_TX_CLASS_OVERRIDE_DEFAULTS)
public class ChildBaseTxClassOverrideDefaults extends BaseTxClass {
    @Override
    public boolean method(String caller) {
        return super.method(caller);
    }
}
