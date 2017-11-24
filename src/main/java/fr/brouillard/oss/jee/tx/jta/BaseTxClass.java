package fr.brouillard.oss.jee.tx.jta;


import javax.inject.Inject;
import javax.transaction.Status;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.brouillard.oss.jee.tx.JTAStatus;
import fr.brouillard.oss.jee.tx.TCT;
import fr.brouillard.oss.jee.tx.TxCheckerType;

@TCT(TxCheckerType.JTA_BASE_TX_CLASS)
@Transactional(Transactional.TxType.REQUIRED)
public class BaseTxClass implements fr.brouillard.oss.jee.tx.TxChecker {
    private final static Logger LOGGER = LoggerFactory.getLogger(BaseTxClass.class);
    
    @Inject
    TransactionSynchronizationRegistry tsr;
    
    @Override
    public boolean method(String caller) {
        LOGGER.info("{}::method => {}", caller, JTAStatus.from(tsr.getTransactionStatus()));
        return tsr.getTransactionStatus() == Status.STATUS_ACTIVE;
    }
}
