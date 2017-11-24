package fr.brouillard.oss.jee.tx.jta;


import fr.brouillard.oss.jee.tx.TCT;
import fr.brouillard.oss.jee.tx.TxCheckerType;

@TCT(TxCheckerType.JTA_BASE_TX_METHOD_OVERRIDE_DEFAULTS)
public class BaseTxMethodOverrideDefaults extends BaseTxMethod {
}
