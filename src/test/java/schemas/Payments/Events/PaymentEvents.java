
package schemas.Payments.Events;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PaymentEvents implements Serializable
{

    @SerializedName("transactionStatus")
    @Expose
    private TransactionStatus transactionStatus;
    @SerializedName("cancellationStatus")
    @Expose
    private CancellationStatus cancellationStatus;
    @SerializedName("initiationTime")
    @Expose
    private String initiationTime;
    @SerializedName("completionTime")
    @Expose
    private String completionTime;
    @SerializedName("lastUpdateTime")
    @Expose
    private String lastUpdateTime;
    @SerializedName("PaymentEventsResponse")
    @Expose
    private List<PaymentEventsResponse> paymentEventsResponse = null;
    private final static long serialVersionUID = 6862158508756916427L;

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public CancellationStatus getCancellationStatus() {
        return cancellationStatus;
    }

    public void setCancellationStatus(CancellationStatus cancellationStatus) {
        this.cancellationStatus = cancellationStatus;
    }

    public String getInitiationTime() {
        return initiationTime;
    }

    public void setInitiationTime(String initiationTime) {
        this.initiationTime = initiationTime;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<PaymentEventsResponse> getPaymentEventsResponse() {
        return paymentEventsResponse;
    }

    public void setPaymentEventsResponse(List<PaymentEventsResponse> paymentEventsResponse) {
        this.paymentEventsResponse = paymentEventsResponse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("transactionStatus", transactionStatus).append("cancellationStatus", cancellationStatus).append("initiationTime", initiationTime).append("completionTime", completionTime).append("lastUpdateTime", lastUpdateTime).append("paymentEventsResponse", paymentEventsResponse).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(completionTime).append(transactionStatus).append(cancellationStatus).append(initiationTime).append(lastUpdateTime).append(paymentEventsResponse).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentEvents) == false) {
            return false;
        }
        PaymentEvents rhs = ((PaymentEvents) other);
        return new EqualsBuilder().append(completionTime, rhs.completionTime).append(transactionStatus, rhs.transactionStatus).append(cancellationStatus, rhs.cancellationStatus).append(initiationTime, rhs.initiationTime).append(lastUpdateTime, rhs.lastUpdateTime).append(paymentEventsResponse, rhs.paymentEventsResponse).isEquals();
    }

}
