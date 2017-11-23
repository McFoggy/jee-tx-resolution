package fr.brouillard.oss.jee.tx;

import java.util.Arrays;

import javax.transaction.Status;

public enum JTAStatus {
    STATUS_ACTIVE(Status.STATUS_ACTIVE),
    STATUS_MARKED_ROLLBACK(Status.STATUS_MARKED_ROLLBACK),
    STATUS_PREPARED(Status.STATUS_PREPARED),
    STATUS_COMMITTED(Status.STATUS_COMMITTED),
    STATUS_ROLLEDBACK(Status.STATUS_ROLLEDBACK),
    STATUS_UNKNOWN(Status.STATUS_UNKNOWN),
    STATUS_NO_TRANSACTION(Status.STATUS_NO_TRANSACTION),
    STATUS_PREPARING(Status.STATUS_PREPARING),
    STATUS_COMMITTING(Status.STATUS_COMMITTING),
    STATUS_ROLLING_BACK(Status.STATUS_ROLLING_BACK);

    private int status;

    JTAStatus(int status) {
        this.status = status;
    }
    
    public static JTAStatus from(int status) {
        return Arrays.asList(JTAStatus.values()).stream().filter(jta -> jta.status == status).findFirst().orElseThrow(() -> new IllegalArgumentException("No JTASatus with value: " + status));
    }
}
