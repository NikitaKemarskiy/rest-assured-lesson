package org.nikita.api.model;

import java.util.Date;

public class IpAddressData {
    private String ipAddress;
    private boolean isPublic;
    private String ipVersion;
    private boolean isWhiteListed;
    private int abuseConfidenceScore;
    private String countryCode;
    private String countryName;
    private String usageType;
    private String isp;
    private String domain;
    private String[] hostnames;
    private int totalReports;
    private int numDistinctUsers;
    private Date lastReportedAt;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getIpVersion() {
        return ipVersion;
    }

    public void setIpVersion(String ipVersion) {
        this.ipVersion = ipVersion;
    }

    public boolean isWhiteListed() {
        return isWhiteListed;
    }

    public void setWhiteListed(boolean whiteListed) {
        isWhiteListed = whiteListed;
    }

    public int getAbuseConfidenceScore() {
        return abuseConfidenceScore;
    }

    public void setAbuseConfidenceScore(int abuseConfidenceScore) {
        this.abuseConfidenceScore = abuseConfidenceScore;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}