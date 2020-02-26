
package schemas.Payments.Events;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TransactionStatus implements Serializable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("reason")
    @Expose
    private String reason;
    private final static long serialVersionUID = 928974330385722033L;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("status", status).append("reason", reason).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(reason).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionStatus) == false) {
            return false;
        }
        TransactionStatus rhs = ((TransactionStatus) other);
        return new EqualsBuilder().append(reason, rhs.reason).append(status, rhs.status).isEquals();
    }

}
