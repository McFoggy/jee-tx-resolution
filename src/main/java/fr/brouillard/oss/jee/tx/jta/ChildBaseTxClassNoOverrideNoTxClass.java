package fr.brouillard.oss.jee.tx.jta;

import javax.transaction.Transactional;

import fr.brouillard.oss.jee.tx.TCT;
import fr.brouillard.oss.jee.tx.TxCheckerType;

@TCT(TxCheckerType.JTA_BASE_TX_CLASS_NO_OVERRIDE_NO_TX_CLASS)
@Transactional(Transactional.TxType.SUPPORTS)
public class ChildBaseTxClassNoOverrideNoTxClass extends BaseTxClass {
}
