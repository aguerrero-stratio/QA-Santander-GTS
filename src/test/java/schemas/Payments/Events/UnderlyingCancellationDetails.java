
package schemas.Payments.Events;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UnderlyingCancellationDetails implements Serializable
{

    @SerializedName("cancellationRequestDetails")
    @Expose
    private CancellationRequestDetails cancellationRequestDetails;
    @SerializedName("cancellationResponseDetails")
    @Expose
    private CancellationResponseDetails cancellationResponseDetails;
    @SerializedName("cancellationRequestTrackingStatus")
    @Expose
    private String cancellationRequestTrackingStatus;
    private final static long serialVersionUID = -7486779831149302365L;

    public CancellationRequestDetails getCancellationRequestDetails() {
        return cancellationRequestDetails;
    }

    public void setCancellationRequestDetails(CancellationRequestDetails cancellationRequestDetails) {
        this.cancellationRequestDetails = cancellationRequestDetails;
    }

    public CancellationResponseDetails getCancellationResponseDetails() {
        return cancellationResponseDetails;
    }

    public void setCancellationResponseDetails(CancellationResponseDetails cancellationResponseDetails) {
        this.cancellationResponseDetails = cancellationResponseDetails;
    }

    public String getCancellationRequestTrackingStatus() {
        return cancellationRequestTrackingStatus;
    }

    public void setCancellationRequestTrackingStatus(String cancellationRequestTrackingStatus) {
        this.cancellationRequestTrackingStatus = cancellationRequestTrackingStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cancellationRequestDetails", cancellationRequestDetails).append("cancellationResponseDetails", cancellationResponseDetails).append("cancellationRequestTrackingStatus", cancellationRequestTrackingStatus).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cancellationRequestDetails).append(cancellationResponseDetails).append(cancellationRequestTrackingStatus).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UnderlyingCancellationDetails) == false) {
            return false;
        }
        UnderlyingCancellationDetails rhs = ((UnderlyingCancellationDetails) other);
        return new EqualsBuilder().append(cancellationRequestDetails, rhs.cancellationRequestDetails).append(cancellationResponseDetails, rhs.cancellationResponseDetails).append(cancellationRequestTrackingStatus, rhs.cancellationRequestTrackingStatus).isEquals();
    }

}
