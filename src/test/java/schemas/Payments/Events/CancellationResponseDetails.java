
package schemas.Payments.Events;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CancellationResponseDetails implements Serializable
{

    @SerializedName("investigationExecutionStatus")
    @Expose
    private String investigationExecutionStatus;
    @SerializedName("investigationExecutionStatusReason")
    @Expose
    private InvestigationExecutionStatusReason investigationExecutionStatusReason;
    private final static long serialVersionUID = -5893421941322842712L;

    public String getInvestigationExecutionStatus() {
        return investigationExecutionStatus;
    }

    public void setInvestigationExecutionStatus(String investigationExecutionStatus) {
        this.investigationExecutionStatus = investigationExecutionStatus;
    }

    public InvestigationExecutionStatusReason getInvestigationExecutionStatusReason() {
        return investigationExecutionStatusReason;
    }

    public void setInvestigationExecutionStatusReason(InvestigationExecutionStatusReason investigationExecutionStatusReason) {
        this.investigationExecutionStatusReason = investigationExecutionStatusReason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("investigationExecutionStatus", investigationExecutionStatus).append("investigationExecutionStatusReason", investigationExecutionStatusReason).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(investigationExecutionStatus).append(investigationExecutionStatusReason).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CancellationResponseDetails) == false) {
            return false;
        }
        CancellationResponseDetails rhs = ((CancellationResponseDetails) other);
        return new EqualsBuilder().append(investigationExecutionStatus, rhs.investigationExecutionStatus).append(investigationExecutionStatusReason, rhs.investigationExecutionStatusReason).isEquals();
    }

}
