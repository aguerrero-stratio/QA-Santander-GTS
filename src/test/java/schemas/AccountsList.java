package schemas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AccountsList {

    @SerializedName("accountId")
    @Expose
    private String accountId;
    @SerializedName("displayNumber")
    @Expose
    private String displayNumber;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("agent")
    @Expose
    private String agent;
    @SerializedName("agentDescription")
    @Expose
    private String agentDescription;
    @SerializedName("corporateName")
    @Expose
    private String corporateName;
    @SerializedName("subsidiaryName")
    @Expose
    private String subsidiaryName;
    @SerializedName("lastTransactionDate")
    @Expose
    private String lastTransactionDate;
    @SerializedName("amountMainBalance")
    @Expose
    private Double amountMainBalance;
    @SerializedName("currencyCodeMainBalance")
    @Expose
    private String currencyCodeMainBalance;
    @SerializedName("lastUpdateMainBalance")
    @Expose
    private String lastUpdateMainBalance;
    @SerializedName("amountAvailableBalance")
    @Expose
    private Double amountAvailableBalance;
    @SerializedName("currencyCodeAvailableBalance")
    @Expose
    private String currencyCodeAvailableBalance;
    @SerializedName("lastUpdateAvailableBalance")
    @Expose
    private String lastUpdateAvailableBalance;
    @SerializedName("amountPendingBalance")
    @Expose
    private Double amountPendingBalance;
    @SerializedName("currencyCodePendingBalance")
    @Expose
    private String currencyCodePendingBalance;
    @SerializedName("lastUpdatePendingBalance")
    @Expose
    private String lastUpdatePendingBalance;
    @SerializedName("amountWithholdingBalance")
    @Expose
    private Double amountWithholdingBalance;
    @SerializedName("currencyCodeWithholdingBalance")
    @Expose
    private String currencyCodeWithholdingBalance;
    @SerializedName("lastUpdateWithholdingBalance")
    @Expose
    private String lastUpdateWithholdingBalance;
    @SerializedName("amountOverdraftLimit")
    @Expose
    private Double amountOverdraftLimit;
    @SerializedName("currencyCodeOverdraftLimit")
    @Expose
    private String currencyCodeOverdraftLimit;
    @SerializedName("lastUpdateOverdraftLimit")
    @Expose
    private String lastUpdateOverdraftLimit;
    @SerializedName("lastUpdateSwiftPayment")
    @Expose
    private String lastUpdateSwiftPayment;
    @SerializedName("hasSwiftPayments")
    @Expose
    private Boolean hasSwiftPayments;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(String displayNumber) {
        this.displayNumber = displayNumber;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAgentDescription() {
        return agentDescription;
    }

    public void setAgentDescription(String agentDescription) {
        this.agentDescription = agentDescription;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getSubsidiaryName() {
        return subsidiaryName;
    }

    public void setSubsidiaryName(String subsidiaryName) {
        this.subsidiaryName = subsidiaryName;
    }

    public String getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(String lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    public Double getAmountMainBalance() {
        return amountMainBalance;
    }

    public void setAmountMainBalance(Double amountMainBalance) {
        this.amountMainBalance = amountMainBalance;
    }

    public String getCurrencyCodeMainBalance() {
        return currencyCodeMainBalance;
    }

    public void setCurrencyCodeMainBalance(String currencyCodeMainBalance) {
        this.currencyCodeMainBalance = currencyCodeMainBalance;
    }

    public String getLastUpdateMainBalance() {
        return lastUpdateMainBalance;
    }

    public void setLastUpdateMainBalance(String lastUpdateMainBalance) {
        this.lastUpdateMainBalance = lastUpdateMainBalance;
    }

    public Double getAmountAvailableBalance() {
        return amountAvailableBalance;
    }

    public void setAmountAvailableBalance(Double amountAvailableBalance) {
        this.amountAvailableBalance = amountAvailableBalance;
    }

    public String getCurrencyCodeAvailableBalance() {
        return currencyCodeAvailableBalance;
    }

    public void setCurrencyCodeAvailableBalance(String currencyCodeAvailableBalance) {
        this.currencyCodeAvailableBalance = currencyCodeAvailableBalance;
    }

    public String getLastUpdateAvailableBalance() {
        return lastUpdateAvailableBalance;
    }

    public void setLastUpdateAvailableBalance(String lastUpdateAvailableBalance) {
        this.lastUpdateAvailableBalance = lastUpdateAvailableBalance;
    }

    public Double getAmountPendingBalance() {
        return amountPendingBalance;
    }

    public void setAmountPendingBalance(Double amountPendingBalance) {
        this.amountPendingBalance = amountPendingBalance;
    }

    public String getCurrencyCodePendingBalance() {
        return currencyCodePendingBalance;
    }

    public void setCurrencyCodePendingBalance(String currencyCodePendingBalance) {
        this.currencyCodePendingBalance = currencyCodePendingBalance;
    }

    public String getLastUpdatePendingBalance() {
        return lastUpdatePendingBalance;
    }

    public void setLastUpdatePendingBalance(String lastUpdatePendingBalance) {
        this.lastUpdatePendingBalance = lastUpdatePendingBalance;
    }

    public Double getAmountWithholdingBalance() {
        return amountWithholdingBalance;
    }

    public void setAmountWithholdingBalance(Double amountWithholdingBalance) {
        this.amountWithholdingBalance = amountWithholdingBalance;
    }

    public String getCurrencyCodeWithholdingBalance() {
        return currencyCodeWithholdingBalance;
    }

    public void setCurrencyCodeWithholdingBalance(String currencyCodeWithholdingBalance) {
        this.currencyCodeWithholdingBalance = currencyCodeWithholdingBalance;
    }

    public String getLastUpdateWithholdingBalance() {
        return lastUpdateWithholdingBalance;
    }

    public void setLastUpdateWithholdingBalance(String lastUpdateWithholdingBalance) {
        this.lastUpdateWithholdingBalance = lastUpdateWithholdingBalance;
    }

    public Double getAmountOverdraftLimit() {
        return amountOverdraftLimit;
    }

    public void setAmountOverdraftLimit(Double amountOverdraftLimit) {
        this.amountOverdraftLimit = amountOverdraftLimit;
    }

    public String getCurrencyCodeOverdraftLimit() {
        return currencyCodeOverdraftLimit;
    }

    public void setCurrencyCodeOverdraftLimit(String currencyCodeOverdraftLimit) {
        this.currencyCodeOverdraftLimit = currencyCodeOverdraftLimit;
    }

    public String getLastUpdateOverdraftLimit() {
        return lastUpdateOverdraftLimit;
    }

    public void setLastUpdateOverdraftLimit(String lastUpdateOverdraftLimit) {
        this.lastUpdateOverdraftLimit = lastUpdateOverdraftLimit;
    }

    public String getLastUpdateSwiftPayment() {
        return lastUpdateSwiftPayment;
    }

    public void setLastUpdateSwiftPayment(String lastUpdateSwiftPayment) {
        this.lastUpdateSwiftPayment = lastUpdateSwiftPayment;
    }

    public Boolean getHasSwiftPayments() {
        return hasSwiftPayments;
    }

    public void setHasSwiftPayments(Boolean hasSwiftPayments) {
        this.hasSwiftPayments = hasSwiftPayments;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(country).append(displayNumber).append(agent).append(currencyCodeOverdraftLimit).append(description).append(hasSwiftPayments).append(type).append(currencyCodeWithholdingBalance).append(amountOverdraftLimit).append(agentDescription).append(lastUpdatePendingBalance).append(corporateName).append(lastUpdateWithholdingBalance).append(subsidiaryName).append(lastTransactionDate).append(amountAvailableBalance).append(alias).append(amountPendingBalance).append(amountMainBalance).append(lastUpdateOverdraftLimit).append(currencyCodeAvailableBalance).append(currencyCodePendingBalance).append(lastUpdateSwiftPayment).append(accountId).append(amountWithholdingBalance).append(lastUpdateAvailableBalance).append(currencyCodeMainBalance).append(status).append(lastUpdateMainBalance).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AccountsList)) {
            return false;
        }
        AccountsList rhs = ((AccountsList) other);
        return new EqualsBuilder().append(country, rhs.country).append(displayNumber, rhs.displayNumber).append(agent, rhs.agent).append(currencyCodeOverdraftLimit, rhs.currencyCodeOverdraftLimit).append(description, rhs.description).append(hasSwiftPayments, rhs.hasSwiftPayments).append(type, rhs.type).append(currencyCodeWithholdingBalance, rhs.currencyCodeWithholdingBalance).append(amountOverdraftLimit, rhs.amountOverdraftLimit).append(agentDescription, rhs.agentDescription).append(lastUpdatePendingBalance, rhs.lastUpdatePendingBalance).append(corporateName, rhs.corporateName).append(lastUpdateWithholdingBalance, rhs.lastUpdateWithholdingBalance).append(subsidiaryName, rhs.subsidiaryName).append(lastTransactionDate, rhs.lastTransactionDate).append(amountAvailableBalance, rhs.amountAvailableBalance).append(alias, rhs.alias).append(amountPendingBalance, rhs.amountPendingBalance).append(amountMainBalance, rhs.amountMainBalance).append(lastUpdateOverdraftLimit, rhs.lastUpdateOverdraftLimit).append(currencyCodeAvailableBalance, rhs.currencyCodeAvailableBalance).append(currencyCodePendingBalance, rhs.currencyCodePendingBalance).append(lastUpdateSwiftPayment, rhs.lastUpdateSwiftPayment).append(accountId, rhs.accountId).append(amountWithholdingBalance, rhs.amountWithholdingBalance).append(lastUpdateAvailableBalance, rhs.lastUpdateAvailableBalance).append(currencyCodeMainBalance, rhs.currencyCodeMainBalance).append(status, rhs.status).append(lastUpdateMainBalance, rhs.lastUpdateMainBalance).isEquals();
    }

}
