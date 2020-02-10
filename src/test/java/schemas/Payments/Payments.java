
package schemas.Payments;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Payments {

    @SerializedName("paymentsList")
    @Expose
    private List<PaymentsList> paymentsList = null;
    @SerializedName("documents")
    @Expose
    private Documents documents;

    public List<PaymentsList> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<PaymentsList> paymentsList) {
        this.paymentsList = paymentsList;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(documents).append(paymentsList).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Payments)) {
            return false;
        }
        Payments rhs = ((Payments) other);
        return new EqualsBuilder().append(documents, rhs.documents).append(paymentsList, rhs.paymentsList).isEquals();
    }

}
