
package schemas.Payments.Events;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CancellationRequestDetails implements Serializable
{

    @SerializedName("cancellationReasonInformation")
    @Expose
    private String cancellationReasonInformation;
    @SerializedName("indemnityAgreement")
    @Expose
    private String indemnityAgreement;
    private final static long serialVersionUID = 8354187958675978688L;

    public String getCancellationReasonInformation() {
        return cancellationReasonInformation;
    }

    public void setCancellationReasonInformation(String cancellationReasonInformation) {
        this.cancellationReasonInformation = cancellationReasonInformation;
    }

    public String getIndemnityAgreement() {
        return indemnityAgreement;
    }

    public void setIndemnityAgreement(String indemnityAgreement) {
        this.indemnityAgreement = indemnityAgreement;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cancellationReasonInformation", cancellationReasonInformation).append("indemnityAgreement", indemnityAgreement).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(indemnityAgreement).append(cancellationReasonInformation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CancellationRequestDetails) == false) {
            return false;
        }
        CancellationRequestDetails rhs = ((CancellationRequestDetails) other);
        return new EqualsBuilder().append(indemnityAgreement, rhs.indemnityAgreement).append(cancellationReasonInformation, rhs.cancellationReasonInformation).isEquals();
    }

}
