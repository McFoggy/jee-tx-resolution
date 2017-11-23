package fr.brouillard.oss.jee.tx;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EJBsIntegrationTest  {
    // BASE TX
    @Inject @TCT(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT)
    TxChecker baseTxClassExplicit;

    @Inject @TCT(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_DEFAULTS)
    TxChecker baseTxClassExplicitNoOverrideDefaults;

    @Inject @TCT(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_NO_TX_CLASS)
    TxChecker baseTxClassExplicitNoOverrideNoTxClass;

    @Inject @TCT(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_DEFAULTS)
    TxChecker baseTxClassExplicitOverrideDefaults;

    @Inject @TCT(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_CLASS)
    TxChecker baseTxClassExplicitOverrideNoTxClass;

    @Inject @TCT(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_METHOD)
    TxChecker baseTxClassExplicitOverrideNoTxMethod;

    // BASE NO TX
    @Inject @TCT(TxCheckerType.EJB_BASE_NO_TX)
    TxChecker baseNoTx;
    
    @Inject @TCT(TxCheckerType.EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_TX_CLASS_EXPLICIT)
    TxChecker baseNoTxchildTxOnClassNoOverride;
    
    @Inject @TCT(TxCheckerType.EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_CLASS_EXPLICIT)
    TxChecker baseNoTxchildTxOnClassSuperOverride;

    @Inject @TCT(TxCheckerType.EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_DEFAULTS)
    TxChecker baseNoTxChildSuperNoOverrideDefaults;
    
    @Inject @TCT(TxCheckerType.EJB_BASE_NO_TX_CHILD_OVERRIDE_DEFAULTS)
    TxChecker baseNoTxChildSuperOverrideDefaults;
    
    @Inject @TCT(TxCheckerType.EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_METHODS_EXPLICIT)
    TxChecker baseNoTxChildOverrideTxMethodsExplicit;

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "tx-ejb.war")
                .addPackage("fr.brouillard.oss.jee.tx")
                .addPackage("fr.brouillard.oss.jee.tx.ejb")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        
        webArchive.as(ZipExporter.class).exportTo(new File("d:/" + webArchive.getName()), true);
        
        return webArchive;
    }
    
    @Test
    public void test_base_no_tx() {
        testTransactionStates(TxCheckerType.EJB_BASE_NO_TX.name(), baseNoTx, false);
    }
    
    @Test
    public void test_base_no_tx_child_tx_class_annotation_no_override() {
        testTransactionStates(TxCheckerType.EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_TX_CLASS_EXPLICIT.name(), baseNoTxchildTxOnClassNoOverride, true);
    }

    @Test
    public void test_base_no_tx_child_tx_class_annotation_super_override() {
        testTransactionStates(TxCheckerType.EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_CLASS_EXPLICIT.name(), baseNoTxchildTxOnClassSuperOverride, true);
    }
    
    @Test
    public void test_base_no_tx_child_tx_class_annotation_super_override_defaults() {
        testTransactionStates(TxCheckerType.EJB_BASE_NO_TX_CHILD_OVERRIDE_DEFAULTS.name(), baseNoTxChildSuperOverrideDefaults, false);
    }
    
    @Test
    public void test_base_no_tx_child_tx_class_annotation_super_no_override_defaults() {
        testTransactionStates(TxCheckerType.EJB_BASE_NO_TX_CHILD_NO_OVERRIDE_DEFAULTS.name(), baseNoTxChildSuperNoOverrideDefaults, false);
    }

    @Test
    public void test_base_no_tx_child_override_tx_methods_explicit() {
        testTransactionStates(TxCheckerType.EJB_BASE_NO_TX_CHILD_OVERRIDE_TX_METHODS_EXPLICIT.name(), baseNoTxChildOverrideTxMethodsExplicit, true);
    }

    @Test
    public void test_base_tx_explicit() {
        testTransactionStates(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT.name(), baseTxClassExplicit, true);
    }

    @Test
    public void test_base_tx_explicit_no_override_defaults() {
        testTransactionStates(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_DEFAULTS.name(), baseTxClassExplicitNoOverrideDefaults, true);
    }

    @Test
    public void test_base_tx_explicit_no_override_no_tx_class() {
        testTransactionStates(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_NO_OVERRIDE_NO_TX_CLASS.name(), baseTxClassExplicitNoOverrideNoTxClass, false);
    }

    @Test
    public void test_base_tx_explicit_override_defaults() {
        testTransactionStates(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_DEFAULTS.name(), baseTxClassExplicitOverrideDefaults, true);
    }

    @Test
    public void test_base_tx_explicit_override_no_tx_class() {
        testTransactionStates(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_CLASS.name(), baseTxClassExplicitOverrideNoTxClass, false);
    }

    @Test
    public void test_base_tx_explicit_override_no_tx_methods() {
        testTransactionStates(TxCheckerType.EJB_BASE_TX_CLASS_EXPLICIT_OVERRIDE_NO_TX_METHOD.name(), baseTxClassExplicitOverrideNoTxMethod, false);
    }
    
    private void testTransactionStates(String caller, TxChecker txChecker, boolean txStateForMethod) {
        assertThat(caller + "::method transaction state is wrong", txChecker.method(caller), is(txStateForMethod));
    }
}
