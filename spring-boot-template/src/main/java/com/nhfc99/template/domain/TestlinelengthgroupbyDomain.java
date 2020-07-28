package com.nhfc99.template.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class TestlinelengthgroupbyDomain implements Serializable {
    /**
     * 隧道编号
     */
    private String tunnelInfoId;

    /**
     * 
     */
    private BigDecimal testLineLength;

    /**
     * testlinelengthgroupby
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated 2020-06-23
     */
    public TestlinelengthgroupbyDomain(String tunnelInfoId, BigDecimal testLineLength) {
        this.tunnelInfoId = tunnelInfoId;
        this.testLineLength = testLineLength;
    }

    /**
     *
     * @mbggenerated 2020-06-23
     */
    public TestlinelengthgroupbyDomain() {
        super();
    }

    /**
     * 隧道编号
     * @return TunnelInfoId 隧道编号
     */
    public String getTunnelInfoId() {
        return tunnelInfoId;
    }

    /**
     * 隧道编号
     * @param tunnelInfoId 隧道编号
     */
    public void setTunnelInfoId(String tunnelInfoId) {
        this.tunnelInfoId = tunnelInfoId == null ? null : tunnelInfoId.trim();
    }

    /**
     * 
     * @return TestLineLength 
     */
    public BigDecimal getTestLineLength() {
        return testLineLength;
    }

    /**
     * 
     * @param testLineLength 
     */
    public void setTestLineLength(BigDecimal testLineLength) {
        this.testLineLength = testLineLength;
    }
}