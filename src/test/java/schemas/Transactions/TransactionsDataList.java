
package schemas.Transactions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TransactionsDataList {

    @SerializedName("transactionDetails")
    @Expose
    private TransactionDetails transactionDetails;

    public TransactionDetails getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(TransactionDetails transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("transactionDetails", transactionDetails).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(transactionDetails).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionsDataList) == false) {
            return false;
        }
        TransactionsDataList rhs = ((TransactionsDataList) other);
        return new EqualsBuilder().append(transactionDetails, rhs.transactionDetails).isEquals();
    }

}
