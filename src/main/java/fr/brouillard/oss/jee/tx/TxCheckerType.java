package fr.brouillard.oss.jee.tx;

public enum TxCheckerType {
    ANY,
    EJB_BASE_TX_CLASS_EXPLICIT,                             // Tx declared on the base class using TransactionAttribute(REQUIRED)
    EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_DEFAULTS,        // Tx declared on parent class using TransactionAttribute(REQUIRED)
    EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_NO_TX_CLASS,     // Tx declared on parent and no Tx explicit on class using TransactionAttribute(SUPPORTS)
    EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_DEFAULTS,           // Tx declared on parent class using TransactionAttribute(REQUIRED), method overridden
    EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_CLASS,        // Tx declared on parent, and no Tx explicit on class using TransactionAttribute(SUPPORTS), method overridden
    EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_METHOD,       // Tx declared on parent, and no Tx explicit on methods using TransactionAttribute(SUPPORTS), method overridden
    
    EJB_BASE_NO_TX,                                         // Tx declared on the base class using TransactionAttribute(SUPPORTS)
    EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_TX_CLASS_EXPLICIT,     // Tx declared on the child class using TransactionAttribute(REQUIRED)
    EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_DEFAULTS,              // No explicit TX on child class
    EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_CLASS_EXPLICIT,        // Tx declared on the child class using TransactionAttribute(REQUIRED), method overridden
    EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_METHODS_EXPLICIT,      // Tx declared on the child class methods using TransactionAttribute(REQUIRED), method overridden
    EJB_BASE_NO_TX_CHILD_OVERRIDE_DEFAULTS                  // No explicit TX on child class, method overridden
    ;
}
