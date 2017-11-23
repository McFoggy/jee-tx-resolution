package fr.brouillard.oss.jee.tx.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import fr.brouillard.oss.jee.tx.TCT;
import fr.brouillard.oss.jee.tx.TxChecker;
import fr.brouillard.oss.jee.tx.TxCheckerType;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)  // do not influence Tx
public class TxCheckerEJBsProducer {
    @EJB(lookup = "java:app/tx-ejb/BaseNoTx")
    TxChecker baseNoTx;
    @EJB(lookup = "java:app/tx-ejb/ChildNoTxEJBNoOverrideTxOnClassExplicit")
    TxChecker baseNoTxNoOverrideTxClassExplicit;
    @EJB(lookup = "java:app/tx-ejb/ChildNoTxEJBOverrideTxOnClassExplicit")
    TxChecker baseNoTxOverrideTxClassExplicit;
    @EJB(lookup = "java:app/tx-ejb/ChildNoTxEJBNoOverrideDefaults")
    TxChecker baseNoTxNoOverrideDefaults;
    @EJB(lookup = "java:app/tx-ejb/ChildNoTxEJBOverrideDefaults")
    TxChecker baseNoTxOverrideDefaults;
    @EJB(lookup = "java:app/tx-ejb/ChildNoTxEJBOverrideTxOnMethodsExplicit")
    TxChecker baseNoTxOverrideTxMethods;
    
    @EJB(lookup = "java:app/tx-ejb/BaseTxClassExplicit")
    TxChecker baseTx;
    @EJB(lookup = "java:app/tx-ejb/ChildTxClassExplicitEJBNoOverrideDefaults")
    TxChecker baseTxNoOverrideDefaults;
    @EJB(lookup = "java:app/tx-ejb/ChildTxClassExplicitEJBNoOverrideNoTxClass")
    TxChecker baseTxNoOverrideNoTxClass;
    @EJB(lookup = "java:app/tx-ejb/ChildTxClassExplicitEJBOverrideDefaults")
    TxChecker baseTxOverrideDefaults;
    @EJB(lookup = "java:app/tx-ejb/ChildTxClassExplicitEJBOverrideNoTxClass")
    TxChecker baseTxOverrideNoTxClass;
    @EJB(lookup = "java:app/tx-ejb/ChildTxClassExplicitEJBOverrideNoTxMethods")
    TxChecker baseTxOverrideNoTxMethods;

    @Produces
    @TCT(TxCheckerType.EJB_BASE_NO_TX)
    public TxChecker produce_EJB_BASE_NO_TX() {
        return baseNoTx;
    }

    @Produces
    @TCT(TxCheckerType.EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_DEFAULTS)
    public TxChecker produce_EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_DEFAULTS() {
        return baseNoTxNoOverrideDefaults;
    }
    
    @Produces
    @TCT(TxCheckerType.EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_TX_CLASS_EXPLICIT)
    public TxChecker produce_EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_TX_CLASS_EXPLICIT() {
        return baseNoTxNoOverrideTxClassExplicit;
    }
    
    @Produces
    @TCT(TxCheckerType.EJB_BASE_NO_TX_CHILD_OVERRIDE_DEFAULTS)
    public TxChecker produce_EJB_BASE_NO_TX_CHILD_OVERRIDE_DEFAULTS() {
        return baseNoTxOverrideDefaults;
    }
    
    @Produces
    @TCT(TxCheckerType.EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_CLASS_EXPLICIT)
    public TxChecker produce_EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_CLASS_EXPLICIT() {
        return baseNoTxOverrideTxClassExplicit;
    }
    
    @Produces
    @TCT(TxCheckerType.EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_METHODS_EXPLICIT)
    public TxChecker produce_EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_METHODS_EXPLICIT() {
        return baseNoTxOverrideTxMethods;
    }

    @Produces
    @TCT(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT)
    public TxChecker produce_EJB_BASE_TX_CLASS_EXPLICIT() {
        return baseTx;
    }

    @Produces
    @TCT(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_DEFAULTS)
    public TxChecker produce_EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_DEFAULTS() {
        return baseTxNoOverrideDefaults;
    }
    
    @Produces
    @TCT(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_NO_TX_CLASS)
    public TxChecker produce_EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_NO_TX_CLASS() {
        return baseTxNoOverrideNoTxClass;
    }
    
    @Produces
    @TCT(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_DEFAULTS)
    public TxChecker produce_EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_DEFAULTS() {
        return baseTxOverrideDefaults;
    }
    
    @Produces
    @TCT(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_CLASS)
    public TxChecker produce_EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_CLASS() {
        return baseTxOverrideNoTxClass;
    }
    
    @Produces
    @TCT(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_METHOD)
    public TxChecker produce_EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_METHOD() {
        return baseTxOverrideNoTxMethods;
    }
//
//    @Produces
//    @TCT(TxCheckerType.ANY)
//    public TxChecker produce(InjectionPoint ip) {
//        TxCheckerType type = ip.getAnnotated().getAnnotation(TCT.class).value();
//
//        switch (type) {
//            // BASE_TX
//            case EJB_BASE_TX_CLASS_EXPLICIT:
//                return baseTx;
//            case EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_DEFAULTS:
//                return baseTxNoOverrideDefaults;
//            case EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_NO_TX_CLASS:
//                return baseTxNoOverrideNoTxClass;
//            case EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_DEFAULTS:
//                return baseTxOverrideDefaults;
//            case EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_CLASS:
//                return baseTxOverrideNoTxClass;
//            case EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_METHOD:
//                return baseTxOverrideNoTxMethods;
//                
//            // BASE_NO_TX
//            case EJB_BASE_NO_TX:
//                return baseNoTx;
//            case EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_TX_CLASS_EXPLICIT:
//                return baseNoTxNoOverrideTxClassExplicit;
//            case EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_CLASS_EXPLICIT:
//                return baseNoTxOverrideTxClassExplicit;
//            case EJB_BASE_NO_TX_CHILD_OVERRIDE_DEFAULTS:
//                return baseNoTxOverrideDefaults;
//            case EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_DEFAULTS:
//                return baseNoTxNoOverrideDefaults;
//            case EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_METHODS_EXPLICIT:
//                return baseNoTxOverrideTxMethods;
//            default:
//                return null;
//        }
//    }
}
