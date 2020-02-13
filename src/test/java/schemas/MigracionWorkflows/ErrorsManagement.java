
package schemas.MigracionWorkflows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ErrorsManagement {

    @SerializedName("genericErrorManagement")
    @Expose
    private GenericErrorManagement genericErrorManagement;
    @SerializedName("transformationStepsManagement")
    @Expose
    private TransformationStepsManagement transformationStepsManagement;
    @SerializedName("transactionsManagement")
    @Expose
    private TransactionsManagement transactionsManagement;

    public GenericErrorManagement getGenericErrorManagement() {
        return genericErrorManagement;
    }

    public void setGenericErrorManagement(GenericErrorManagement genericErrorManagement) {
        this.genericErrorManagement = genericErrorManagement;
    }

    public TransformationStepsManagement getTransformationStepsManagement() {
        return transformationStepsManagement;
    }

    public void setTransformationStepsManagement(TransformationStepsManagement transformationStepsManagement) {
        this.transformationStepsManagement = transformationStepsManagement;
    }

    public TransactionsManagement getTransactionsManagement() {
        return transactionsManagement;
    }

    public void setTransactionsManagement(TransactionsManagement transactionsManagement) {
        this.transactionsManagement = transactionsManagement;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("genericErrorManagement", genericErrorManagement).append("transformationStepsManagement", transformationStepsManagement).append("transactionsManagement", transactionsManagement).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(genericErrorManagement).append(transactionsManagement).append(transformationStepsManagement).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ErrorsManagement) == false) {
            return false;
        }
        ErrorsManagement rhs = ((ErrorsManagement) other);
        return new EqualsBuilder().append(genericErrorManagement, rhs.genericErrorManagement).append(transactionsManagement, rhs.transactionsManagement).append(transformationStepsManagement, rhs.transformationStepsManagement).isEquals();
    }

}
