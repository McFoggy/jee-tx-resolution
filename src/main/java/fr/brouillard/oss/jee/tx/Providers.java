package fr.brouillard.oss.jee.tx;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.transaction.TransactionSynchronizationRegistry;

@ApplicationScoped
public class Providers {
    @Resource
    TransactionSynchronizationRegistry tsr;
    
    @Produces
    public TransactionSynchronizationRegistry produceTSR() {
        return tsr;
    } 
}
