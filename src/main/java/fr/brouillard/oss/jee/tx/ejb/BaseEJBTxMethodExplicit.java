package fr.brouillard.oss.jee.tx.ejb;


import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.transaction.Status;
import javax.transaction.TransactionSynchronizationRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.brouillard.oss.jee.tx.JTAStatus;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class BaseEJBTxMethodExplicit implements fr.brouillard.oss.jee.tx.TxChecker {
    private final static Logger LOGGER = LoggerFactory.getLogger(BaseEJBTxMethodExplicit.class);
    
    @Resource
    TransactionSynchronizationRegistry tsr;
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean method(String caller) {
        LOGGER.info("{}::method => {}", caller, JTAStatus.from(tsr.getTransactionStatus()));
        return tsr.getTransactionStatus() == Status.STATUS_ACTIVE;
    }
}
