
package schemas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CancellationStatus {

    @SerializedName("transactionCancellationStatus")
    @Expose
    private Object transactionCancellationStatus;

    public Object getTransactionCancellationStatus() {
        return transactionCancellationStatus;
    }

    public void setTransactionCancellationStatus(Object transactionCancellationStatus) {
        this.transactionCancellationStatus = transactionCancellationStatus;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(transactionCancellationStatus).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CancellationStatus) == false) {
            return false;
        }
        CancellationStatus rhs = ((CancellationStatus) other);
        return new EqualsBuilder().append(transactionCancellationStatus, rhs.transactionCancellationStatus).isEquals();
    }

}
