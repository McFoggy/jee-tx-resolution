package fr.brouillard.oss.jee.tx.jta;

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

import fr.brouillard.oss.jee.tx.TCT;
import fr.brouillard.oss.jee.tx.TxChecker;
import fr.brouillard.oss.jee.tx.TxCheckerType;

@RunWith(Arquillian.class)
public class JTAViaCDIIntegrationTest {
    // Base no TX
    @Inject  @TCT(TxCheckerType.JTA_BASE_NO_TX)
    TxChecker baseNoTx;

    @Inject  @TCT(TxCheckerType.JTA_BASE_NO_TX_NO_OVERRIDE_DEFAULTS)
    TxChecker baseNoTxNoOverrideDefaults;

    @Inject  @TCT(TxCheckerType.JTA_BASE_NO_TX_OVERRIDE_DEFAULTS)
    TxChecker baseNoTxOverrideDefaults;

    @Inject  @TCT(TxCheckerType.JTA_BASE_NO_TX_NO_OVERRIDE_TX_CLASS_EXPLICIT)
    TxChecker baseNoTxNoOverrideTxClassExplicit;

    @Inject  @TCT(TxCheckerType.JTA_BASE_NO_TX_OVERRIDE_TX_CLASS_EXPLICIT)
    TxChecker baseNoTxOverrideTxClassExplicit;

    @Inject  @TCT(TxCheckerType.JTA_BASE_NO_TX_OVERRIDE_TX_METHODS_EXPLICIT)
    TxChecker baseNoTxOverrideTxMethodsExplicit;

    @Inject  @TCT(TxCheckerType.JTA_BASE_TX_CLASS)
    TxChecker baseTxClass;

    @Inject  @TCT(TxCheckerType.JTA_BASE_TX_CLASS_NO_OVERRIDE_DEFAULTS)
    TxChecker baseTxClassNoOverrideDefaults;

    @Inject  @TCT(TxCheckerType.JTA_BASE_TX_CLASS_OVERRIDE_DEFAULTS)
    TxChecker baseTxClassOverrideDefaults;

    @Inject  @TCT(TxCheckerType.JTA_BASE_TX_CLASS_NO_OVERRIDE_NO_TX_CLASS)
    TxChecker baseTxClassNoOverrideNoTxClass;

    @Inject  @TCT(TxCheckerType.JTA_BASE_TX_CLASS_OVERRIDE_NO_TX_CLASS)
    TxChecker baseTxClassOverrideNoTxClass;

    @Inject  @TCT(TxCheckerType.JTA_BASE_TX_CLASS_OVERRIDE_NO_TX_METHOD)
    TxChecker baseTxClassOverrideNoTxMethod;

    @Inject  @TCT(TxCheckerType.JTA_BASE_TX_METHOD)
    TxChecker baseTxMethod;

    @Inject  @TCT(TxCheckerType.JTA_BASE_TX_METHOD_NO_OVERRIDE_DEFAULTS)
    TxChecker baseTxMethodNoOverrideDefaults;
    
    @Inject  @TCT(TxCheckerType.JTA_BASE_TX_METHOD_NO_OVERRIDE_NO_TX_CLASS)
    TxChecker baseTxMethodNoOverrideNoTxClass;

    @Inject  @TCT(TxCheckerType.JTA_BASE_TX_METHOD_OVERRIDE_DEFAULTS)
    TxChecker baseTxMethodOverrideDefaults;

    @Inject  @TCT(TxCheckerType.JTA_BASE_TX_METHOD_OVERRIDE_NO_TX_CLASS)
    TxChecker baseTxMethodOverrideNoTxClass;

    @Inject  @TCT(TxCheckerType.JTA_BASE_TX_METHOD_OVERRIDE_NO_TX_METHOD)
    TxChecker baseTxMethodOverrideNoTxMethod;

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "tx-jta.war")
                .addPackage("fr.brouillard.oss.jee.tx")
                .addPackage("fr.brouillard.oss.jee.tx.jta")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

        webArchive.as(ZipExporter.class).exportTo(new File("d:/" + webArchive.getName()), true);

        return webArchive;
    }

    @Test
    public void test_base_no_tx() {
        testTransactionStates(TxCheckerType.JTA_BASE_NO_TX.name(), baseNoTx, false);
    }
    
    @Test
    public void test_base_no_tx_no_override_defaults() {
        testTransactionStates(TxCheckerType.JTA_BASE_NO_TX_NO_OVERRIDE_DEFAULTS.name(), baseNoTxNoOverrideDefaults, false);
    }
    
    @Test
    public void test_base_no_tx_override_defaults() {
        testTransactionStates(TxCheckerType.JTA_BASE_NO_TX_OVERRIDE_DEFAULTS.name(), baseNoTxOverrideDefaults, false);
    }
    
    @Test
    public void test_base_no_tx_no_override_tx_class_explicit() {
        testTransactionStates(TxCheckerType.JTA_BASE_NO_TX_NO_OVERRIDE_TX_CLASS_EXPLICIT.name(), baseNoTxNoOverrideTxClassExplicit, true);
    }
    
    @Test
    public void test_base_no_tx_override_tx_class_explicit() {
        testTransactionStates(TxCheckerType.JTA_BASE_NO_TX_OVERRIDE_TX_CLASS_EXPLICIT.name(), baseNoTxOverrideTxClassExplicit, true);
    }
    
    @Test
    public void test_base_no_tx_override_tx_methods_explicit() {
        testTransactionStates(TxCheckerType.JTA_BASE_NO_TX_OVERRIDE_TX_METHODS_EXPLICIT.name(), baseNoTxOverrideTxMethodsExplicit, true);
    }
    
    @Test
    public void test_base_tx_class() {
        testTransactionStates(TxCheckerType.JTA_BASE_TX_CLASS.name(), baseTxClass, true);
    }
    
    @Test
    public void test_base_tx_class_no_override_defaults() {
        testTransactionStates(TxCheckerType.JTA_BASE_TX_CLASS_NO_OVERRIDE_DEFAULTS.name(), baseTxClassNoOverrideDefaults, true);
    }
    
    @Test
    public void test_base_tx_class_override_defaults() {
        testTransactionStates(TxCheckerType.JTA_BASE_TX_CLASS_OVERRIDE_DEFAULTS.name(), baseTxClassOverrideDefaults, true);
    }
    
    @Test
    public void test_base_tx_class_no_override_no_tx_class() {
        testTransactionStates(TxCheckerType.JTA_BASE_TX_CLASS_NO_OVERRIDE_NO_TX_CLASS.name(), baseTxClassNoOverrideNoTxClass, false);
    }
    
    @Test
    public void test_base_tx_class_override_no_tx_class() {
        testTransactionStates(TxCheckerType.JTA_BASE_TX_CLASS_OVERRIDE_NO_TX_CLASS.name(), baseTxClassOverrideNoTxClass, false);
    }

    @Test
    public void test_base_tx_class_override_no_tx_method() {
        testTransactionStates(TxCheckerType.JTA_BASE_TX_CLASS_OVERRIDE_NO_TX_METHOD.name(), baseTxClassOverrideNoTxMethod, false);
    }


    @Test
    public void test_base_tx_method() {
        testTransactionStates(TxCheckerType.JTA_BASE_TX_METHOD.name(), baseTxMethod, true);
    }

    @Test
    public void test_base_tx_method_no_override_defaults() {
        testTransactionStates(TxCheckerType.JTA_BASE_TX_METHOD_NO_OVERRIDE_DEFAULTS.name(), baseTxMethodNoOverrideDefaults, true);
    }

    @Test
    public void test_base_tx_method_override_defaults() {
        testTransactionStates(TxCheckerType.JTA_BASE_TX_METHOD_OVERRIDE_DEFAULTS.name(), baseTxMethodOverrideDefaults, true);
    }

    @Test
    public void test_base_tx_method_no_override_no_tx_class() {
        testTransactionStates(TxCheckerType.JTA_BASE_TX_METHOD_NO_OVERRIDE_NO_TX_CLASS.name(), baseTxMethodNoOverrideNoTxClass, true);
    }

    @Test
    public void test_base_tx_method_override_no_tx_class() {
        testTransactionStates(TxCheckerType.JTA_BASE_TX_METHOD_OVERRIDE_NO_TX_CLASS.name(), baseTxMethodOverrideNoTxClass, false);
    }

    @Test
    public void test_base_tx_method_override_no_tx_method() {
        testTransactionStates(TxCheckerType.JTA_BASE_TX_METHOD_OVERRIDE_NO_TX_METHOD.name(), baseTxMethodOverrideNoTxMethod, false);
    }

    private void testTransactionStates(String caller, TxChecker txChecker, boolean txStateForMethod) {
        assertThat(caller + "::method transaction state is wrong", txChecker.method(caller), is(txStateForMethod));
    }
}
