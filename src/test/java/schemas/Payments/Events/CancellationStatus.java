
package schemas.Payments.Events;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CancellationStatus implements Serializable
{

    @SerializedName("transactionCancellationStatus")
    @Expose
    private String transactionCancellationStatus;
    private final static long serialVersionUID = -1788736731864712599L;

    public String getTransactionCancellationStatus() {
        return transactionCancellationStatus;
    }

    public void setTransactionCancellationStatus(String transactionCancellationStatus) {
        this.transactionCancellationStatus = transactionCancellationStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("transactionCancellationStatus", transactionCancellationStatus).toString();
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
