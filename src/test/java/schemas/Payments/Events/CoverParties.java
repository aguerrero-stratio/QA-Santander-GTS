
package schemas.Payments.Events;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CoverParties implements Serializable
{

    @SerializedName("debtor")
    @Expose
    private String debtor;
    @SerializedName("debtorAgent")
    @Expose
    private String debtorAgent;
    @SerializedName("intermediaryAgent1")
    @Expose
    private String intermediaryAgent1;
    @SerializedName("creditorAgent")
    @Expose
    private String creditorAgent;
    @SerializedName("creditor")
    @Expose
    private String creditor;
    private final static long serialVersionUID = 515640128091332138L;

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public String getDebtorAgent() {
        return debtorAgent;
    }

    public void setDebtorAgent(String debtorAgent) {
        this.debtorAgent = debtorAgent;
    }

    public String getIntermediaryAgent1() {
        return intermediaryAgent1;
    }

    public void setIntermediaryAgent1(String intermediaryAgent1) {
        this.intermediaryAgent1 = intermediaryAgent1;
    }

    public String getCreditorAgent() {
        return creditorAgent;
    }

    public void setCreditorAgent(String creditorAgent) {
        this.creditorAgent = creditorAgent;
    }

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("debtor", debtor).append("debtorAgent", debtorAgent).append("intermediaryAgent1", intermediaryAgent1).append("creditorAgent", creditorAgent).append("creditor", creditor).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(intermediaryAgent1).append(creditor).append(debtor).append(debtorAgent).append(creditorAgent).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CoverParties) == false) {
            return false;
        }
        CoverParties rhs = ((CoverParties) other);
        return new EqualsBuilder().append(intermediaryAgent1, rhs.intermediaryAgent1).append(creditor, rhs.creditor).append(debtor, rhs.debtor).append(debtorAgent, rhs.debtorAgent).append(creditorAgent, rhs.creditorAgent).isEquals();
    }

}
