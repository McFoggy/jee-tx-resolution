package fr.brouillard.oss.jee.tx.jta;

import fr.brouillard.oss.jee.tx.TCT;
import fr.brouillard.oss.jee.tx.TxCheckerType;

@TCT(TxCheckerType.JTA_BASE_TX_CLASS_NO_OVERRIDE_DEFAULTS)
public class ChildBaseTxClassNoOverrideDefaults extends BaseTxClass {
}
