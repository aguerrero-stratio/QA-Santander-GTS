
package schemas.Payments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CreditorCreditAccount {

    @SerializedName("idType")
    @Expose
    private String idType;
    @SerializedName("accountId")
    @Expose
    private String accountId;

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accountId).append(idType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreditorCreditAccount) == false) {
            return false;
        }
        CreditorCreditAccount rhs = ((CreditorCreditAccount) other);
        return new EqualsBuilder().append(accountId, rhs.accountId).append(idType, rhs.idType).isEquals();
    }

}
