
package schemas.Transactions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TransactionDetails {

    @SerializedName("accountingDate")
    @Expose
    private String accountingDate;
    @SerializedName("creationDate")
    @Expose
    private String creationDate;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("operation")
    @Expose
    private Operation operation;
    @SerializedName("processedDate")
    @Expose
    private String processedDate;
    @SerializedName("references")
    @Expose
    private References references;
    @SerializedName("transactionAmount")
    @Expose
    private Long transactionAmount;
    @SerializedName("transactionAmountCurrency")
    @Expose
    private String transactionAmountCurrency;
    @SerializedName("transactionBalanceAmount")
    @Expose
    private Long transactionBalanceAmount;
    @SerializedName("transactionBalanceAmountCurrency")
    @Expose
    private String transactionBalanceAmountCurrency;
    @SerializedName("transactionCategory")
    @Expose
    private String transactionCategory;
    @SerializedName("transactionConsolidated")
    @Expose
    private Boolean transactionConsolidated;
    @SerializedName("transactionId")
    @Expose
    private String transactionId;
    @SerializedName("transactionType")
    @Expose
    private String transactionType;

    public String getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(String accountingDate) {
        this.accountingDate = accountingDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(String processedDate) {
        this.processedDate = processedDate;
    }

    public References getReferences() {
        return references;
    }

    public void setReferences(References references) {
        this.references = references;
    }

    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionAmountCurrency() {
        return transactionAmountCurrency;
    }

    public void setTransactionAmountCurrency(String transactionAmountCurrency) {
        this.transactionAmountCurrency = transactionAmountCurrency;
    }

    public Long getTransactionBalanceAmount() {
        return transactionBalanceAmount;
    }

    public void setTransactionBalanceAmount(Long transactionBalanceAmount) {
        this.transactionBalanceAmount = transactionBalanceAmount;
    }

    public String getTransactionBalanceAmountCurrency() {
        return transactionBalanceAmountCurrency;
    }

    public void setTransactionBalanceAmountCurrency(String transactionBalanceAmountCurrency) {
        this.transactionBalanceAmountCurrency = transactionBalanceAmountCurrency;
    }

    public String getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(String transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public Boolean getTransactionConsolidated() {
        return transactionConsolidated;
    }

    public void setTransactionConsolidated(Boolean transactionConsolidated) {
        this.transactionConsolidated = transactionConsolidated;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("accountingDate", accountingDate).append("creationDate", creationDate).append("description", description).append("operation", operation).append("processedDate", processedDate).append("references", references).append("transactionAmount", transactionAmount).append("transactionAmountCurrency", transactionAmountCurrency).append("transactionBalanceAmount", transactionBalanceAmount).append("transactionBalanceAmountCurrency", transactionBalanceAmountCurrency).append("transactionCategory", transactionCategory).append("transactionConsolidated", transactionConsolidated).append("transactionId", transactionId).append("transactionType", transactionType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accountingDate).append(references).append(transactionBalanceAmount).append(description).append(transactionAmountCurrency).append(transactionBalanceAmountCurrency).append(creationDate).append(transactionId).append(transactionConsolidated).append(transactionType).append(processedDate).append(transactionAmount).append(transactionCategory).append(operation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionDetails) == false) {
            return false;
        }
        TransactionDetails rhs = ((TransactionDetails) other);
        return new EqualsBuilder().append(accountingDate, rhs.accountingDate).append(references, rhs.references).append(transactionBalanceAmount, rhs.transactionBalanceAmount).append(description, rhs.description).append(transactionAmountCurrency, rhs.transactionAmountCurrency).append(transactionBalanceAmountCurrency, rhs.transactionBalanceAmountCurrency).append(creationDate, rhs.creationDate).append(transactionId, rhs.transactionId).append(transactionConsolidated, rhs.transactionConsolidated).append(transactionType, rhs.transactionType).append(processedDate, rhs.processedDate).append(transactionAmount, rhs.transactionAmount).append(transactionCategory, rhs.transactionCategory).append(operation, rhs.operation).isEquals();
    }

}
