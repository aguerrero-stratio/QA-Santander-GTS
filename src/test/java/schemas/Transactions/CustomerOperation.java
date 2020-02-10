
package schemas.Transactions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CustomerOperation {

    @SerializedName("customerAdditionalInformation")
    @Expose
    private String customerAdditionalInformation;
    @SerializedName("customerTransactionCode")
    @Expose
    private String customerTransactionCode;
    @SerializedName("customerTransactionDescription")
    @Expose
    private String customerTransactionDescription;

    public String getCustomerAdditionalInformation() {
        return customerAdditionalInformation;
    }

    public void setCustomerAdditionalInformation(String customerAdditionalInformation) {
        this.customerAdditionalInformation = customerAdditionalInformation;
    }

    public String getCustomerTransactionCode() {
        return customerTransactionCode;
    }

    public void setCustomerTransactionCode(String customerTransactionCode) {
        this.customerTransactionCode = customerTransactionCode;
    }

    public String getCustomerTransactionDescription() {
        return customerTransactionDescription;
    }

    public void setCustomerTransactionDescription(String customerTransactionDescription) {
        this.customerTransactionDescription = customerTransactionDescription;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("customerAdditionalInformation", customerAdditionalInformation).append("customerTransactionCode", customerTransactionCode).append("customerTransactionDescription", customerTransactionDescription).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerTransactionDescription).append(customerAdditionalInformation).append(customerTransactionCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerOperation) == false) {
            return false;
        }
        CustomerOperation rhs = ((CustomerOperation) other);
        return new EqualsBuilder().append(customerTransactionDescription, rhs.customerTransactionDescription).append(customerAdditionalInformation, rhs.customerAdditionalInformation).append(customerTransactionCode, rhs.customerTransactionCode).isEquals();
    }

}
