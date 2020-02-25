
package schemas.Payments.Events;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PaymentEventsResponse implements Serializable
{

    @SerializedName("networkReference")
    @Expose
    private String networkReference;
    @SerializedName("messageNameIdentification")
    @Expose
    private String messageNameIdentification;
    @SerializedName("businessService")
    @Expose
    private String businessService;
    @SerializedName("trackerEventType")
    @Expose
    private String trackerEventType;
    @SerializedName("valid")
    @Expose
    private Boolean valid;
    @SerializedName("invalidityReason")
    @Expose
    private String invalidityReason;
    @SerializedName("invalidityDescription")
    @Expose
    private String invalidityDescription;
    @SerializedName("instructionIdentification")
    @Expose
    private String instructionIdentification;
    @SerializedName("releatedReference")
    @Expose
    private Object releatedReference;
    @SerializedName("caseIdentification")
    @Expose
    private String caseIdentification;
    @SerializedName("originalInstructionIdentification")
    @Expose
    private String originalInstructionIdentification;
    @SerializedName("assignmentIdentification")
    @Expose
    private String assignmentIdentification;
    @SerializedName("resolvedCaseIdentification")
    @Expose
    private String resolvedCaseIdentification;
    @SerializedName("underlyingCancellationDetails")
    @Expose
    private UnderlyingCancellationDetails underlyingCancellationDetails;
    @SerializedName("forwardedToAgent")
    @Expose
    private String forwardedToAgent;
    @SerializedName("fundsAvailableDate")
    @Expose
    private Object fundsAvailableDate;
    @SerializedName("fromAgent")
    @Expose
    private Object fromAgent;
    @SerializedName("toAgent")
    @Expose
    private Object toAgent;
    @SerializedName("originatorAgent")
    @Expose
    private Object originatorAgent;
    @SerializedName("serialParties")
    @Expose
    private SerialParties serialParties;
    @SerializedName("coverParties")
    @Expose
    private CoverParties coverParties;
    @SerializedName("senderAcknowledgementReceipt")
    @Expose
    private String senderAcknowledgementReceipt;
    @SerializedName("receivedDate")
    @Expose
    private String receivedDate;
    @SerializedName("instructedAmount")
    @Expose
    private InstructedAmount instructedAmount;
    @SerializedName("confirmedAmount")
    @Expose
    private ConfirmedAmount confirmedAmount;
    @SerializedName("interbankSettlementAmount")
    @Expose
    private InterbankSettlementAmount interbankSettlementAmount;
    @SerializedName("interbankSettlementDate")
    @Expose
    private String interbankSettlementDate;
    @SerializedName("chargerBearer")
    @Expose
    private Object chargerBearer;
    @SerializedName("chargeAmount")
    @Expose
    private ChargeAmount chargeAmount;
    @SerializedName("foreignExchangeDetails")
    @Expose
    private ForeignExchangeDetails foreignExchangeDetails;
    @SerializedName("updatePayment")
    @Expose
    private String updatePayment;
    @SerializedName("duplicateMessageReference")
    @Expose
    private String duplicateMessageReference;
    @SerializedName("copiedBusinessService")
    @Expose
    private String copiedBusinessService;
    private final static long serialVersionUID = -2246684389328811754L;

    public String getNetworkReference() {
        return networkReference;
    }

    public void setNetworkReference(String networkReference) {
        this.networkReference = networkReference;
    }

    public String getMessageNameIdentification() {
        return messageNameIdentification;
    }

    public void setMessageNameIdentification(String messageNameIdentification) {
        this.messageNameIdentification = messageNameIdentification;
    }

    public String getBusinessService() {
        return businessService;
    }

    public void setBusinessService(String businessService) {
        this.businessService = businessService;
    }

    public String getTrackerEventType() {
        return trackerEventType;
    }

    public void setTrackerEventType(String trackerEventType) {
        this.trackerEventType = trackerEventType;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getInvalidityReason() {
        return invalidityReason;
    }

    public void setInvalidityReason(String invalidityReason) {
        this.invalidityReason = invalidityReason;
    }

    public String getInvalidityDescription() {
        return invalidityDescription;
    }

    public void setInvalidityDescription(String invalidityDescription) {
        this.invalidityDescription = invalidityDescription;
    }

    public String getInstructionIdentification() {
        return instructionIdentification;
    }

    public void setInstructionIdentification(String instructionIdentification) {
        this.instructionIdentification = instructionIdentification;
    }

    public Object getReleatedReference() {
        return releatedReference;
    }

    public void setReleatedReference(Object releatedReference) {
        this.releatedReference = releatedReference;
    }

    public String getCaseIdentification() {
        return caseIdentification;
    }

    public void setCaseIdentification(String caseIdentification) {
        this.caseIdentification = caseIdentification;
    }

    public String getOriginalInstructionIdentification() {
        return originalInstructionIdentification;
    }

    public void setOriginalInstructionIdentification(String originalInstructionIdentification) {
        this.originalInstructionIdentification = originalInstructionIdentification;
    }

    public String getAssignmentIdentification() {
        return assignmentIdentification;
    }

    public void setAssignmentIdentification(String assignmentIdentification) {
        this.assignmentIdentification = assignmentIdentification;
    }

    public String getResolvedCaseIdentification() {
        return resolvedCaseIdentification;
    }

    public void setResolvedCaseIdentification(String resolvedCaseIdentification) {
        this.resolvedCaseIdentification = resolvedCaseIdentification;
    }

    public UnderlyingCancellationDetails getUnderlyingCancellationDetails() {
        return underlyingCancellationDetails;
    }

    public void setUnderlyingCancellationDetails(UnderlyingCancellationDetails underlyingCancellationDetails) {
        this.underlyingCancellationDetails = underlyingCancellationDetails;
    }

    public String getForwardedToAgent() {
        return forwardedToAgent;
    }

    public void setForwardedToAgent(String forwardedToAgent) {
        this.forwardedToAgent = forwardedToAgent;
    }

    public Object getFundsAvailableDate() {
        return fundsAvailableDate;
    }

    public void setFundsAvailableDate(Object fundsAvailableDate) {
        this.fundsAvailableDate = fundsAvailableDate;
    }

    public Object getFromAgent() {
        return fromAgent;
    }

    public void setFromAgent(Object fromAgent) {
        this.fromAgent = fromAgent;
    }

    public Object getToAgent() {
        return toAgent;
    }

    public void setToAgent(Object toAgent) {
        this.toAgent = toAgent;
    }

    public Object getOriginatorAgent() {
        return originatorAgent;
    }

    public void setOriginatorAgent(Object originatorAgent) {
        this.originatorAgent = originatorAgent;
    }

    public SerialParties getSerialParties() {
        return serialParties;
    }

    public void setSerialParties(SerialParties serialParties) {
        this.serialParties = serialParties;
    }

    public CoverParties getCoverParties() {
        return coverParties;
    }

    public void setCoverParties(CoverParties coverParties) {
        this.coverParties = coverParties;
    }

    public String getSenderAcknowledgementReceipt() {
        return senderAcknowledgementReceipt;
    }

    public void setSenderAcknowledgementReceipt(String senderAcknowledgementReceipt) {
        this.senderAcknowledgementReceipt = senderAcknowledgementReceipt;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public InstructedAmount getInstructedAmount() {
        return instructedAmount;
    }

    public void setInstructedAmount(InstructedAmount instructedAmount) {
        this.instructedAmount = instructedAmount;
    }

    public ConfirmedAmount getConfirmedAmount() {
        return confirmedAmount;
    }

    public void setConfirmedAmount(ConfirmedAmount confirmedAmount) {
        this.confirmedAmount = confirmedAmount;
    }

    public InterbankSettlementAmount getInterbankSettlementAmount() {
        return interbankSettlementAmount;
    }

    public void setInterbankSettlementAmount(InterbankSettlementAmount interbankSettlementAmount) {
        this.interbankSettlementAmount = interbankSettlementAmount;
    }

    public String getInterbankSettlementDate() {
        return interbankSettlementDate;
    }

    public void setInterbankSettlementDate(String interbankSettlementDate) {
        this.interbankSettlementDate = interbankSettlementDate;
    }

    public Object getChargerBearer() {
        return chargerBearer;
    }

    public void setChargerBearer(Object chargerBearer) {
        this.chargerBearer = chargerBearer;
    }

    public ChargeAmount getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(ChargeAmount chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public ForeignExchangeDetails getForeignExchangeDetails() {
        return foreignExchangeDetails;
    }

    public void setForeignExchangeDetails(ForeignExchangeDetails foreignExchangeDetails) {
        this.foreignExchangeDetails = foreignExchangeDetails;
    }

    public String getUpdatePayment() {
        return updatePayment;
    }

    public void setUpdatePayment(String updatePayment) {
        this.updatePayment = updatePayment;
    }

    public String getDuplicateMessageReference() {
        return duplicateMessageReference;
    }

    public void setDuplicateMessageReference(String duplicateMessageReference) {
        this.duplicateMessageReference = duplicateMessageReference;
    }

    public String getCopiedBusinessService() {
        return copiedBusinessService;
    }

    public void setCopiedBusinessService(String copiedBusinessService) {
        this.copiedBusinessService = copiedBusinessService;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("networkReference", networkReference).append("messageNameIdentification", messageNameIdentification).append("businessService", businessService).append("trackerEventType", trackerEventType).append("valid", valid).append("invalidityReason", invalidityReason).append("invalidityDescription", invalidityDescription).append("instructionIdentification", instructionIdentification).append("releatedReference", releatedReference).append("caseIdentification", caseIdentification).append("originalInstructionIdentification", originalInstructionIdentification).append("assignmentIdentification", assignmentIdentification).append("resolvedCaseIdentification", resolvedCaseIdentification).append("underlyingCancellationDetails", underlyingCancellationDetails).append("forwardedToAgent", forwardedToAgent).append("fundsAvailableDate", fundsAvailableDate).append("fromAgent", fromAgent).append("toAgent", toAgent).append("originatorAgent", originatorAgent).append("serialParties", serialParties).append("coverParties", coverParties).append("senderAcknowledgementReceipt", senderAcknowledgementReceipt).append("receivedDate", receivedDate).append("instructedAmount", instructedAmount).append("confirmedAmount", confirmedAmount).append("interbankSettlementAmount", interbankSettlementAmount).append("interbankSettlementDate", interbankSettlementDate).append("chargerBearer", chargerBearer).append("chargeAmount", chargeAmount).append("foreignExchangeDetails", foreignExchangeDetails).append("updatePayment", updatePayment).append("duplicateMessageReference", duplicateMessageReference).append("copiedBusinessService", copiedBusinessService).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(copiedBusinessService).append(chargerBearer).append(toAgent).append(updatePayment).append(valid).append(resolvedCaseIdentification).append(invalidityDescription).append(messageNameIdentification).append(duplicateMessageReference).append(fromAgent).append(originalInstructionIdentification).append(assignmentIdentification).append(instructedAmount).append(chargeAmount).append(caseIdentification).append(receivedDate).append(trackerEventType).append(businessService).append(senderAcknowledgementReceipt).append(underlyingCancellationDetails).append(fundsAvailableDate).append(releatedReference).append(foreignExchangeDetails).append(confirmedAmount).append(forwardedToAgent).append(instructionIdentification).append(originatorAgent).append(invalidityReason).append(serialParties).append(coverParties).append(interbankSettlementAmount).append(networkReference).append(interbankSettlementDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentEventsResponse) == false) {
            return false;
        }
        PaymentEventsResponse rhs = ((PaymentEventsResponse) other);
        return new EqualsBuilder().append(copiedBusinessService, rhs.copiedBusinessService).append(chargerBearer, rhs.chargerBearer).append(toAgent, rhs.toAgent).append(updatePayment, rhs.updatePayment).append(valid, rhs.valid).append(resolvedCaseIdentification, rhs.resolvedCaseIdentification).append(invalidityDescription, rhs.invalidityDescription).append(messageNameIdentification, rhs.messageNameIdentification).append(duplicateMessageReference, rhs.duplicateMessageReference).append(fromAgent, rhs.fromAgent).append(originalInstructionIdentification, rhs.originalInstructionIdentification).append(assignmentIdentification, rhs.assignmentIdentification).append(instructedAmount, rhs.instructedAmount).append(chargeAmount, rhs.chargeAmount).append(caseIdentification, rhs.caseIdentification).append(receivedDate, rhs.receivedDate).append(trackerEventType, rhs.trackerEventType).append(businessService, rhs.businessService).append(senderAcknowledgementReceipt, rhs.senderAcknowledgementReceipt).append(underlyingCancellationDetails, rhs.underlyingCancellationDetails).append(fundsAvailableDate, rhs.fundsAvailableDate).append(releatedReference, rhs.releatedReference).append(foreignExchangeDetails, rhs.foreignExchangeDetails).append(confirmedAmount, rhs.confirmedAmount).append(forwardedToAgent, rhs.forwardedToAgent).append(instructionIdentification, rhs.instructionIdentification).append(originatorAgent, rhs.originatorAgent).append(invalidityReason, rhs.invalidityReason).append(serialParties, rhs.serialParties).append(coverParties, rhs.coverParties).append(interbankSettlementAmount, rhs.interbankSettlementAmount).append(networkReference, rhs.networkReference).append(interbankSettlementDate, rhs.interbankSettlementDate).isEquals();
    }

}
