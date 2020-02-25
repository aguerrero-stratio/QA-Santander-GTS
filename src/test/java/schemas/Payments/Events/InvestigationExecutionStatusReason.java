
package schemas.Payments.Events;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class InvestigationExecutionStatusReason implements Serializable
{

    @SerializedName("rejected")
    @Expose
    private String rejected;
    @SerializedName("pending")
    @Expose
    private String pending;
    private final static long serialVersionUID = 2271497571713294128L;

    public String getRejected() {
        return rejected;
    }

    public void setRejected(String rejected) {
        this.rejected = rejected;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("rejected", rejected).append("pending", pending).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rejected).append(pending).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InvestigationExecutionStatusReason) == false) {
            return false;
        }
        InvestigationExecutionStatusReason rhs = ((InvestigationExecutionStatusReason) other);
        return new EqualsBuilder().append(rejected, rhs.rejected).append(pending, rhs.pending).isEquals();
    }

}
