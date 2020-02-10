
package schemas.Transactions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class LocalOperation {

    @SerializedName("additionalInformation")
    @Expose
    private String additionalInformation;
    @SerializedName("localTransactionCode")
    @Expose
    private String localTransactionCode;
    @SerializedName("localTransactionDescription")
    @Expose
    private String localTransactionDescription;

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getLocalTransactionCode() {
        return localTransactionCode;
    }

    public void setLocalTransactionCode(String localTransactionCode) {
        this.localTransactionCode = localTransactionCode;
    }

    public String getLocalTransactionDescription() {
        return localTransactionDescription;
    }

    public void setLocalTransactionDescription(String localTransactionDescription) {
        this.localTransactionDescription = localTransactionDescription;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("additionalInformation", additionalInformation).append("localTransactionCode", localTransactionCode).append("localTransactionDescription", localTransactionDescription).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalInformation).append(localTransactionCode).append(localTransactionDescription).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LocalOperation) == false) {
            return false;
        }
        LocalOperation rhs = ((LocalOperation) other);
        return new EqualsBuilder().append(additionalInformation, rhs.additionalInformation).append(localTransactionCode, rhs.localTransactionCode).append(localTransactionDescription, rhs.localTransactionDescription).isEquals();
    }

}
