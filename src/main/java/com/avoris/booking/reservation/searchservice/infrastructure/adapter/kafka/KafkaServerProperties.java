package com.avoris.booking.reservation.searchservice.infrastructure.adapter.kafka;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "kafka.server")
public class KafkaServerProperties {

    private String bootstrap;
    private String security;
    private String trustStoreLocation;
    private String trustStorePassword;
    private String keystoreLocation;
    private String keystorePassword;
    private String keyPassword;
    private Integer backOffAttempt;
    private Integer backOffInterval;
    private String autoOffsetReset;
    private Integer heartbeatInterval;
    private Integer sessionTimeOut;
    private Integer requestTimeOut;

    private Integer concurrency;
    private Boolean enableAutoCommit;
    private Integer autoCommitInterval;
    private Integer maxPollInterval;
    private Integer maxPollRecords;
    private Boolean idempotence;
    private String acks;

    public String getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(String bootstrap) {
        this.bootstrap = bootstrap;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getTrustStoreLocation() {
        return trustStoreLocation;
    }

    public void setTrustStoreLocation(String trustStoreLocation) {
        this.trustStoreLocation = trustStoreLocation;
    }

    public String getTrustStorePassword() {
        return trustStorePassword;
    }

    public void setTrustStorePassword(String trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
    }

    public String getKeystoreLocation() {
        return keystoreLocation;
    }

    public void setKeystoreLocation(String keystoreLocation) {
        this.keystoreLocation = keystoreLocation;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public Integer getBackOffAttempt() {
        return backOffAttempt;
    }

    public void setBackOffAttempt(Integer backOffAttempt) {
        this.backOffAttempt = backOffAttempt;
    }

    public Integer getBackOffInterval() {
        return backOffInterval;
    }

    public void setBackOffInterval(Integer backOffInterval) {
        this.backOffInterval = backOffInterval;
    }

    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

    public Integer getHeartbeatInterval() {
        return heartbeatInterval;
    }

    public void setHeartbeatInterval(Integer heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
    }

    public Integer getSessionTimeOut() {
        return sessionTimeOut;
    }

    public void setSessionTimeOut(Integer sessionTimeOut) {
        this.sessionTimeOut = sessionTimeOut;
    }

    public Integer getRequestTimeOut() {
        return requestTimeOut;
    }

    public void setRequestTimeOut(Integer requestTimeOut) {
        this.requestTimeOut = requestTimeOut;
    }



    public Integer getConcurrency() {
        return concurrency;
    }

    public void setConcurrency(Integer concurrency) {
        this.concurrency = concurrency;
    }

    public Boolean getEnableAutoCommit() {
        return enableAutoCommit;
    }

    public void setEnableAutoCommit(Boolean enableAutoCommit) {
        this.enableAutoCommit = enableAutoCommit;
    }

    public Integer getAutoCommitInterval() {
        return autoCommitInterval;
    }

    public void setAutoCommitInterval(Integer autoCommitInterval) {
        this.autoCommitInterval = autoCommitInterval;
    }

    public Integer getMaxPollInterval() {
        return maxPollInterval;
    }

    public void setMaxPollInterval(Integer maxPollInterval) {
        this.maxPollInterval = maxPollInterval;
    }

    public Integer getMaxPollRecords() {
        return maxPollRecords;
    }

    public void setMaxPollRecords(Integer maxPollRecords) {
        this.maxPollRecords = maxPollRecords;
    }

    public Boolean getIdempotence() {
        return idempotence;
    }

    public void setIdempotence(Boolean idempotence) {
        this.idempotence = idempotence;
    }

    public String getAcks() {
        return acks;
    }

    public void setAcks(String acks) {
        this.acks = acks;
    }
}

