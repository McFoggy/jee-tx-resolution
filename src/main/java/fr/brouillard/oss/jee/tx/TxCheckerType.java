package fr.brouillard.oss.jee.tx;

public enum TxCheckerType {
    EJB_BASE_NO_TX,                                         // Tx declared on the base class using TransactionAttribute(SUPPORTS)
    EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_TX_CLASS_EXPLICIT,     // Tx declared on the child class using TransactionAttribute(REQUIRED)
    EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_DEFAULTS,              // No explicit TX on child class
    EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_CLASS_EXPLICIT,        // Tx declared on the child class using TransactionAttribute(REQUIRED), method overridden
    EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_METHODS_EXPLICIT,      // Tx declared on the child class methods using TransactionAttribute(REQUIRED), method overridden
    EJB_BASE_NO_TX_CHILD_OVERRIDE_DEFAULTS,                 // No explicit TX on child class, method overridden

    EJB_BASE_TX_CLASS_EXPLICIT,                             // Tx declared on the base class using TransactionAttribute(REQUIRED)
    EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_DEFAULTS,        // Tx declared on parent class using TransactionAttribute(REQUIRED)
    EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_NO_TX_CLASS,     // Tx declared on parent and no Tx explicit on class using TransactionAttribute(SUPPORTS)
    EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_DEFAULTS,           // Tx declared on parent class using TransactionAttribute(REQUIRED), method overridden
    EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_CLASS,        // Tx declared on parent, and no Tx explicit on class using TransactionAttribute(SUPPORTS), method overridden
    EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_METHOD,       // Tx declared on parent, and no Tx explicit on methods using TransactionAttribute(SUPPORTS), method overridden

    EJB_BASE_TX_METHOD_EXPLICIT,                            // Tx declared on the base method using TransactionAttribute(REQUIRED), class uses @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    EJB_BASE_TX_METHOD_EXPLICIT_NO_OVERRIDE_DEFAULTS,       // Tx declared on parent method using TransactionAttribute(REQUIRED)
    EJB_BASE_TX_METHOD_EXPLICIT_NO_OVERRIDE_NO_TX_CLASS,    // Tx declared on parent method and no Tx explicit on class using TransactionAttribute(SUPPORTS)
    EJB_BASE_TX_METHOD_EXPLICIT_OVERRIDE_DEFAULTS,          // Tx declared on parent method, method overridden
    EJB_BASE_TX_METHOD_EXPLICIT_OVERRIDE_NO_TX_CLASS,       // Tx declared on parent method, and no Tx explicit on class using TransactionAttribute(SUPPORTS), method overridden
    EJB_BASE_TX_METHOD_EXPLICIT_OVERRIDE_NO_TX_METHOD,      // Tx declared on parent method, and no Tx explicit on methods using TransactionAttribute(SUPPORTS), method overridden

    JTA_BASE_NO_TX,                                         // pure CDI bean, no tx annotation
    JTA_BASE_NO_TX_NO_OVERRIDE_DEFAULTS,                    // no tx annotation on parent, no tx on child, no override
    JTA_BASE_NO_TX_NO_OVERRIDE_TX_CLASS_EXPLICIT,           // no tx annotation on parent, tx on child class using @Transactional(REQUIRED), no override
    JTA_BASE_NO_TX_OVERRIDE_DEFAULTS,                       // no tx annotation on parent, no tx on child, override methods
    JTA_BASE_NO_TX_OVERRIDE_TX_CLASS_EXPLICIT,              // no tx annotation on parent, tx on child class using @Transactional(REQUIRED), override methods
    JTA_BASE_NO_TX_OVERRIDE_TX_METHODS_EXPLICIT,            // no tx annotation on parent, tx on child methods using @Transactional(REQUIRED), override methods

    JTA_BASE_TX_CLASS,                                      // pure CDI bean, tx declared at class level
    JTA_BASE_TX_CLASS_NO_OVERRIDE_DEFAULTS,                 // tx declared at class level, no tx on child, no override
    JTA_BASE_TX_CLASS_NO_OVERRIDE_NO_TX_CLASS,              // tx declared at class level, tx removed on child at class level, no override
    JTA_BASE_TX_CLASS_OVERRIDE_DEFAULTS,                    // tx declared at class level, no tx on child, override
    JTA_BASE_TX_CLASS_OVERRIDE_NO_TX_CLASS,                 // tx declared at class level, tx removed on child at class level, override
    JTA_BASE_TX_CLASS_OVERRIDE_NO_TX_METHOD,                // tx declared at class level, tx removed on child at method level, override

    JTA_BASE_TX_METHOD,                                     // pure CDI bean, tx declared at method level
    JTA_BASE_TX_METHOD_NO_OVERRIDE_DEFAULTS,                // tx declared at method level, no tx on child, no override
    JTA_BASE_TX_METHOD_NO_OVERRIDE_NO_TX_CLASS,             // tx declared at method level, tx removed on child at class level, no override
    JTA_BASE_TX_METHOD_OVERRIDE_DEFAULTS,                   // tx declared at method level, no tx on child, override
    JTA_BASE_TX_METHOD_OVERRIDE_NO_TX_CLASS,                // tx declared at method level, tx removed on child at class level, override
    JTA_BASE_TX_METHOD_OVERRIDE_NO_TX_METHOD,               // tx declared at method level, tx removed on child at method level, override
}
