
package schemas.Transactions;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TransactionsListResponse {

    @SerializedName("accountId")
    @Expose
    private String accountId;
    @SerializedName("agent")
    @Expose
    private String agent;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("displayNumber")
    @Expose
    private String displayNumber;
    @SerializedName("transactionsDataList")
    @Expose
    private List<TransactionsDataList> transactionsDataList = null;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(String displayNumber) {
        this.displayNumber = displayNumber;
    }

    public List<TransactionsDataList> getTransactionsDataList() {
        return transactionsDataList;
    }

    public void setTransactionsDataList(List<TransactionsDataList> transactionsDataList) {
        this.transactionsDataList = transactionsDataList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("accountId", accountId).append("agent", agent).append("alias", alias).append("country", country).append("displayNumber", displayNumber).append("transactionsDataList", transactionsDataList).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accountId).append(country).append(agent).append(displayNumber).append(alias).append(transactionsDataList).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionsListResponse) == false) {
            return false;
        }
        TransactionsListResponse rhs = ((TransactionsListResponse) other);
        return new EqualsBuilder().append(accountId, rhs.accountId).append(country, rhs.country).append(agent, rhs.agent).append(displayNumber, rhs.displayNumber).append(alias, rhs.alias).append(transactionsDataList, rhs.transactionsDataList).isEquals();
    }

}
