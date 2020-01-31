
package schemas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PaymentsList {

    @SerializedName("paymentId")
    @Expose
    private String paymentId;
    @SerializedName("transactionStatus")
    @Expose
    private TransactionStatus transactionStatus;
    @SerializedName("statusDate")
    @Expose
    private Object statusDate;
    @SerializedName("cancellationStatus")
    @Expose
    private CancellationStatus cancellationStatus;
    @SerializedName("issueDate")
    @Expose
    private String issueDate;
    @SerializedName("valueDate")
    @Expose
    private String valueDate;
    @SerializedName("paymentAmount")
    @Expose
    private PaymentAmount paymentAmount;
    @SerializedName("originatorData")
    @Expose
    private OriginatorData originatorData;
    @SerializedName("beneficiaryData")
    @Expose
    private BeneficiaryData beneficiaryData;
    @SerializedName("paymentTrackerDetailResponse")
    @Expose
    private Object paymentTrackerDetailResponse;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Object getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Object statusDate) {
        this.statusDate = statusDate;
    }

    public CancellationStatus getCancellationStatus() {
        return cancellationStatus;
    }

    public void setCancellationStatus(CancellationStatus cancellationStatus) {
        this.cancellationStatus = cancellationStatus;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public PaymentAmount getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(PaymentAmount paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public OriginatorData getOriginatorData() {
        return originatorData;
    }

    public void setOriginatorData(OriginatorData originatorData) {
        this.originatorData = originatorData;
    }

    public BeneficiaryData getBeneficiaryData() {
        return beneficiaryData;
    }

    public void setBeneficiaryData(BeneficiaryData beneficiaryData) {
        this.beneficiaryData = beneficiaryData;
    }

    public Object getPaymentTrackerDetailResponse() {
        return paymentTrackerDetailResponse;
    }

    public void setPaymentTrackerDetailResponse(Object paymentTrackerDetailResponse) {
        this.paymentTrackerDetailResponse = paymentTrackerDetailResponse;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(statusDate).append(transactionStatus).append(paymentId).append(originatorData).append(valueDate).append(issueDate).append(paymentTrackerDetailResponse).append(paymentAmount).append(cancellationStatus).append(beneficiaryData).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PaymentsList)) {
            return false;
        }
        PaymentsList rhs = ((PaymentsList) other);
        return new EqualsBuilder().append(statusDate, rhs.statusDate).append(transactionStatus, rhs.transactionStatus).append(paymentId, rhs.paymentId).append(originatorData, rhs.originatorData).append(valueDate, rhs.valueDate).append(issueDate, rhs.issueDate).append(paymentTrackerDetailResponse, rhs.paymentTrackerDetailResponse).append(paymentAmount, rhs.paymentAmount).append(cancellationStatus, rhs.cancellationStatus).append(beneficiaryData, rhs.beneficiaryData).isEquals();
    }

}
