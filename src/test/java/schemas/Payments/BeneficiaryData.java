
package schemas.Payments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class BeneficiaryData {

    @SerializedName("beneficiaryName")
    @Expose
    private String beneficiaryName;
    @SerializedName("creditorCreditAccount")
    @Expose
    private CreditorCreditAccount creditorCreditAccount;
    @SerializedName("agent")
    @Expose
    private Object agent;
    @SerializedName("agentName")
    @Expose
    private String agentName;
    @SerializedName("agentCountry")
    @Expose
    private Object agentCountry;
    @SerializedName("agentLocation")
    @Expose
    private String agentLocation;

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public CreditorCreditAccount getCreditorCreditAccount() {
        return creditorCreditAccount;
    }

    public void setCreditorCreditAccount(CreditorCreditAccount creditorCreditAccount) {
        this.creditorCreditAccount = creditorCreditAccount;
    }

    public Object getAgent() {
        return agent;
    }

    public void setAgent(Object agent) {
        this.agent = agent;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Object getAgentCountry() {
        return agentCountry;
    }

    public void setAgentCountry(Object agentCountry) {
        this.agentCountry = agentCountry;
    }

    public String getAgentLocation() {
        return agentLocation;
    }

    public void setAgentLocation(String agentLocation) {
        this.agentLocation = agentLocation;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(agent).append(beneficiaryName).append(creditorCreditAccount).append(agentName).append(agentCountry).append(agentLocation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BeneficiaryData) == false) {
            return false;
        }
        BeneficiaryData rhs = ((BeneficiaryData) other);
        return new EqualsBuilder().append(agent, rhs.agent).append(beneficiaryName, rhs.beneficiaryName).append(creditorCreditAccount, rhs.creditorCreditAccount).append(agentName, rhs.agentName).append(agentCountry, rhs.agentCountry).append(agentLocation, rhs.agentLocation).isEquals();
    }

}
