package schemas.Sparta.QualityRules;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class QualityRule implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("executionId")
    @Expose
    private String executionId;
    @SerializedName("dataQualityRuleId")
    @Expose
    private String dataQualityRuleId;
    @SerializedName("numTotalEvents")
    @Expose
    private Integer numTotalEvents;
    @SerializedName("numPassedEvents")
    @Expose
    private Integer numPassedEvents;
    @SerializedName("numDiscardedEvents")
    @Expose
    private Integer numDiscardedEvents;
    @SerializedName("metadataPath")
    @Expose
    private String metadataPath;
    @SerializedName("transformationStepName")
    @Expose
    private String transformationStepName;
    @SerializedName("outputStepName")
    @Expose
    private String outputStepName;
    @SerializedName("satisfied")
    @Expose
    private Boolean satisfied;
    @SerializedName("successfulWriting")
    @Expose
    private Boolean successfulWriting;
    @SerializedName("conditionThreshold")
    @Expose
    private String conditionThreshold;
    @SerializedName("sentToApi")
    @Expose
    private Boolean sentToApi;
    @SerializedName("warning")
    @Expose
    private Boolean warning;
    @SerializedName("qualityRuleName")
    @Expose
    private String qualityRuleName;
    @SerializedName("conditionsString")
    @Expose
    private String conditionsString;
    @SerializedName("globalAction")
    @Expose
    private String globalAction;
    @SerializedName("creationDate")
    @Expose
    private String creationDate;
    @SerializedName("workflowName")
    @Expose
    private String workflowName;
    @SerializedName("workflowVersion")
    @Expose
    private Integer workflowVersion;
    @SerializedName("workflowGroup")
    @Expose
    private String workflowGroup;
    @SerializedName("executedFromScheduler")
    @Expose
    private Boolean executedFromScheduler;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getDataQualityRuleId() {
        return dataQualityRuleId;
    }

    public void setDataQualityRuleId(String dataQualityRuleId) {
        this.dataQualityRuleId = dataQualityRuleId;
    }

    public Integer getNumTotalEvents() {
        return numTotalEvents;
    }

    public void setNumTotalEvents(Integer numTotalEvents) {
        this.numTotalEvents = numTotalEvents;
    }

    public Integer getNumPassedEvents() {
        return numPassedEvents;
    }

    public void setNumPassedEvents(Integer numPassedEvents) {
        this.numPassedEvents = numPassedEvents;
    }

    public Integer getNumDiscardedEvents() {
        return numDiscardedEvents;
    }

    public void setNumDiscardedEvents(Integer numDiscardedEvents) {
        this.numDiscardedEvents = numDiscardedEvents;
    }

    public String getMetadataPath() {
        return metadataPath;
    }

    public void setMetadataPath(String metadataPath) {
        this.metadataPath = metadataPath;
    }

    public String getTransformationStepName() {
        return transformationStepName;
    }

    public void setTransformationStepName(String transformationStepName) {
        this.transformationStepName = transformationStepName;
    }

    public String getOutputStepName() {
        return outputStepName;
    }

    public void setOutputStepName(String outputStepName) {
        this.outputStepName = outputStepName;
    }

    public Boolean getSatisfied() {
        return satisfied;
    }

    public void setSatisfied(Boolean satisfied) {
        this.satisfied = satisfied;
    }

    public Boolean getSuccessfulWriting() {
        return successfulWriting;
    }

    public void setSuccessfulWriting(Boolean successfulWriting) {
        this.successfulWriting = successfulWriting;
    }

    public String getConditionThreshold() {
        return conditionThreshold;
    }

    public void setConditionThreshold(String conditionThreshold) {
        this.conditionThreshold = conditionThreshold;
    }

    public Boolean getSentToApi() {
        return sentToApi;
    }

    public void setSentToApi(Boolean sentToApi) {
        this.sentToApi = sentToApi;
    }

    public Boolean getWarning() {
        return warning;
    }

    public void setWarning(Boolean warning) {
        this.warning = warning;
    }

    public String getQualityRuleName() {
        return qualityRuleName;
    }

    public void setQualityRuleName(String qualityRuleName) {
        this.qualityRuleName = qualityRuleName;
    }

    public String getConditionsString() {
        return conditionsString;
    }

    public void setConditionsString(String conditionsString) {
        this.conditionsString = conditionsString;
    }

    public String getGlobalAction() {
        return globalAction;
    }

    public void setGlobalAction(String globalAction) {
        this.globalAction = globalAction;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public Integer getWorkflowVersion() {
        return workflowVersion;
    }

    public void setWorkflowVersion(Integer workflowVersion) {
        this.workflowVersion = workflowVersion;
    }

    public String getWorkflowGroup() {
        return workflowGroup;
    }

    public void setWorkflowGroup(String workflowGroup) {
        this.workflowGroup = workflowGroup;
    }

    public Boolean getExecutedFromScheduler() {
        return executedFromScheduler;
    }

    public void setExecutedFromScheduler(Boolean executedFromScheduler) {
        this.executedFromScheduler = executedFromScheduler;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("executionId", executionId).append("dataQualityRuleId", dataQualityRuleId).append("numTotalEvents", numTotalEvents).append("numPassedEvents", numPassedEvents).append("numDiscardedEvents", numDiscardedEvents).append("metadataPath", metadataPath).append("transformationStepName", transformationStepName).append("outputStepName", outputStepName).append("satisfied", satisfied).append("successfulWriting", successfulWriting).append("conditionThreshold", conditionThreshold).append("sentToApi", sentToApi).append("warning", warning).append("qualityRuleName", qualityRuleName).append("conditionsString", conditionsString).append("globalAction", globalAction).append("creationDate", creationDate).append("workflowName", workflowName).append("workflowVersion", workflowVersion).append("workflowGroup", workflowGroup).append("executedFromScheduler", executedFromScheduler).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(metadataPath).append(sentToApi).append(numTotalEvents).append(executedFromScheduler).append(successfulWriting).append(conditionThreshold).append(satisfied).append(numPassedEvents).append(transformationStepName).append(workflowName).append(creationDate).append(executionId).append(outputStepName).append(conditionsString).append(qualityRuleName).append(numDiscardedEvents).append(dataQualityRuleId).append(warning).append(id).append(workflowVersion).append(workflowGroup).append(globalAction).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof QualityRule) == false) {
            return false;
        }
        QualityRule rhs = ((QualityRule) other);
        return new EqualsBuilder().append(metadataPath, rhs.metadataPath).append(sentToApi, rhs.sentToApi).append(numTotalEvents, rhs.numTotalEvents).append(executedFromScheduler, rhs.executedFromScheduler).append(successfulWriting, rhs.successfulWriting).append(conditionThreshold, rhs.conditionThreshold).append(satisfied, rhs.satisfied).append(numPassedEvents, rhs.numPassedEvents).append(transformationStepName, rhs.transformationStepName).append(workflowName, rhs.workflowName).append(creationDate, rhs.creationDate).append(executionId, rhs.executionId).append(outputStepName, rhs.outputStepName).append(conditionsString, rhs.conditionsString).append(qualityRuleName, rhs.qualityRuleName).append(numDiscardedEvents, rhs.numDiscardedEvents).append(dataQualityRuleId, rhs.dataQualityRuleId).append(warning, rhs.warning).append(id, rhs.id).append(workflowVersion, rhs.workflowVersion).append(workflowGroup, rhs.workflowGroup).append(globalAction, rhs.globalAction).isEquals();
    }

}
