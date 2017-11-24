package fr.brouillard.oss.jee.tx.jta;


import javax.transaction.Transactional;

import fr.brouillard.oss.jee.tx.TCT;
import fr.brouillard.oss.jee.tx.TxCheckerType;

@TCT(TxCheckerType.JTA_BASE_TX_METHOD_OVERRIDE_NO_TX_CLASS)
@Transactional(Transactional.TxType.SUPPORTS)
public class BaseTxMethodOverrideNoTxClass extends BaseTxMethod {
    @Override
    public boolean method(String caller) {
        return super.method(caller);
    }
}
