package schemas;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Accounts {

    @SerializedName("accountsList")
    @Expose
    private List<AccountsList> accountsList = null;

    public List<AccountsList> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<AccountsList> accountsList) {
        this.accountsList = accountsList;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accountsList).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Accounts)) {
            return false;
        }
        Accounts rhs = ((Accounts) other);
        return new EqualsBuilder().append(accountsList, rhs.accountsList).isEquals();
    }

}
