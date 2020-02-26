
package schemas.Payments.Events;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SerialParties implements Serializable
{

    @SerializedName("debtorAgent")
    @Expose
    private String debtorAgent;
    @SerializedName("instructingReimbursementAgent")
    @Expose
    private String instructingReimbursementAgent;
    @SerializedName("creditorAgent")
    @Expose
    private String creditorAgent;
    private final static long serialVersionUID = 5219236245307206739L;

    public String getDebtorAgent() {
        return debtorAgent;
    }

    public void setDebtorAgent(String debtorAgent) {
        this.debtorAgent = debtorAgent;
    }

    public String getInstructingReimbursementAgent() {
        return instructingReimbursementAgent;
    }

    public void setInstructingReimbursementAgent(String instructingReimbursementAgent) {
        this.instructingReimbursementAgent = instructingReimbursementAgent;
    }

    public String getCreditorAgent() {
        return creditorAgent;
    }

    public void setCreditorAgent(String creditorAgent) {
        this.creditorAgent = creditorAgent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("debtorAgent", debtorAgent).append("instructingReimbursementAgent", instructingReimbursementAgent).append("creditorAgent", creditorAgent).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(instructingReimbursementAgent).append(debtorAgent).append(creditorAgent).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SerialParties) == false) {
            return false;
        }
        SerialParties rhs = ((SerialParties) other);
        return new EqualsBuilder().append(instructingReimbursementAgent, rhs.instructingReimbursementAgent).append(debtorAgent, rhs.debtorAgent).append(creditorAgent, rhs.creditorAgent).isEquals();
    }

}
