
package schemas.Transactions;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Transactions {

    @SerializedName("documents")
    @Expose
    private Documents documents;
    @SerializedName("transactionsListResponse")
    @Expose
    private List<TransactionsListResponse> transactionsListResponse = null;

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    public List<TransactionsListResponse> getTransactionsListResponse() {
        return transactionsListResponse;
    }

    public void setTransactionsListResponse(List<TransactionsListResponse> transactionsListResponse) {
        this.transactionsListResponse = transactionsListResponse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("documents", documents).append("transactionsListResponse", transactionsListResponse).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(documents).append(transactionsListResponse).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Transactions) == false) {
            return false;
        }
        Transactions rhs = ((Transactions) other);
        return new EqualsBuilder().append(documents, rhs.documents).append(transactionsListResponse, rhs.transactionsListResponse).isEquals();
    }

}
