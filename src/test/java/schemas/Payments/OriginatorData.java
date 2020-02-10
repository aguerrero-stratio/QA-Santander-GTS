
package schemas.Payments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class OriginatorData {

    @SerializedName("accountId")
    @Expose
    private String accountId;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
        return new HashCodeBuilder().append(accountId).append(agentName).append(agent).append(agentCountry).append(agentLocation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OriginatorData) == false) {
            return false;
        }
        OriginatorData rhs = ((OriginatorData) other);
        return new EqualsBuilder().append(accountId, rhs.accountId).append(agentName, rhs.agentName).append(agent, rhs.agent).append(agentCountry, rhs.agentCountry).append(agentLocation, rhs.agentLocation).isEquals();
    }

}
