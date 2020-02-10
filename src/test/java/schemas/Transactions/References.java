
package schemas.Transactions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class References {

    @SerializedName("transactionBatchReference")
    @Expose
    private String transactionBatchReference;
    @SerializedName("transactionClientReference")
    @Expose
    private String transactionClientReference;
    @SerializedName("transactionInternalReference")
    @Expose
    private String transactionInternalReference;

    public String getTransactionBatchReference() {
        return transactionBatchReference;
    }

    public void setTransactionBatchReference(String transactionBatchReference) {
        this.transactionBatchReference = transactionBatchReference;
    }

    public String getTransactionClientReference() {
        return transactionClientReference;
    }

    public void setTransactionClientReference(String transactionClientReference) {
        this.transactionClientReference = transactionClientReference;
    }

    public String getTransactionInternalReference() {
        return transactionInternalReference;
    }

    public void setTransactionInternalReference(String transactionInternalReference) {
        this.transactionInternalReference = transactionInternalReference;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("transactionBatchReference", transactionBatchReference).append("transactionClientReference", transactionClientReference).append("transactionInternalReference", transactionInternalReference).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(transactionClientReference).append(transactionInternalReference).append(transactionBatchReference).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof References) == false) {
            return false;
        }
        References rhs = ((References) other);
        return new EqualsBuilder().append(transactionClientReference, rhs.transactionClientReference).append(transactionInternalReference, rhs.transactionInternalReference).append(transactionBatchReference, rhs.transactionBatchReference).isEquals();
    }

}
