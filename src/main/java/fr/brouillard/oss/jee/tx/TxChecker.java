package fr.brouillard.oss.jee.tx;

public interface TxChecker {
    boolean method(String caller);
}
