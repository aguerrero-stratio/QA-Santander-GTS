
package schemas.Sparta.Workflow;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SpartaWorkflowExecution implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("statuses")
    @Expose
    private List<Status> statuses = null;
    @SerializedName("genericDataExecution")
    @Expose
    private GenericDataExecution genericDataExecution;
    @SerializedName("sparkSubmitExecution")
    @Expose
    private SparkSubmitExecution sparkSubmitExecution;
    @SerializedName("marathonExecution")
    @Expose
    private MarathonExecution marathonExecution;
    @SerializedName("archived")
    @Expose
    private Boolean archived;
    @SerializedName("resumedDate")
    @Expose
    private String resumedDate;
    @SerializedName("resumedStatus")
    @Expose
    private String resumedStatus;
    @SerializedName("executionEngine")
    @Expose
    private String executionEngine;
    @SerializedName("searchText")
    @Expose
    private String searchText;
    @SerializedName("qualityRules")
    @Expose
    private List<QualityRule> qualityRules = null;
    @SerializedName("executionType")
    @Expose
    private String executionType;
    @SerializedName("spartaVersion")
    @Expose
    private String spartaVersion;
    private final static long serialVersionUID = -3309979645439554260L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public GenericDataExecution getGenericDataExecution() {
        return genericDataExecution;
    }

    public void setGenericDataExecution(GenericDataExecution genericDataExecution) {
        this.genericDataExecution = genericDataExecution;
    }

    public SparkSubmitExecution getSparkSubmitExecution() {
        return sparkSubmitExecution;
    }

    public void setSparkSubmitExecution(SparkSubmitExecution sparkSubmitExecution) {
        this.sparkSubmitExecution = sparkSubmitExecution;
    }

    public MarathonExecution getMarathonExecution() {
        return marathonExecution;
    }

    public void setMarathonExecution(MarathonExecution marathonExecution) {
        this.marathonExecution = marathonExecution;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getResumedDate() {
        return resumedDate;
    }

    public void setResumedDate(String resumedDate) {
        this.resumedDate = resumedDate;
    }

    public String getResumedStatus() {
        return resumedStatus;
    }

    public void setResumedStatus(String resumedStatus) {
        this.resumedStatus = resumedStatus;
    }

    public String getExecutionEngine() {
        return executionEngine;
    }

    public void setExecutionEngine(String executionEngine) {
        this.executionEngine = executionEngine;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<QualityRule> getQualityRules() {
        return qualityRules;
    }

    public void setQualityRules(List<QualityRule> qualityRules) {
        this.qualityRules = qualityRules;
    }

    public String getExecutionType() {
        return executionType;
    }

    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }

    public String getSpartaVersion() {
        return spartaVersion;
    }

    public void setSpartaVersion(String spartaVersion) {
        this.spartaVersion = spartaVersion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("statuses", statuses).append("genericDataExecution", genericDataExecution).append("sparkSubmitExecution", sparkSubmitExecution).append("marathonExecution", marathonExecution).append("archived", archived).append("resumedDate", resumedDate).append("resumedStatus", resumedStatus).append("executionEngine", executionEngine).append("searchText", searchText).append("qualityRules", qualityRules).append("executionType", executionType).append("spartaVersion", spartaVersion).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(marathonExecution).append(executionType).append(genericDataExecution).append(executionEngine).append(sparkSubmitExecution).append(spartaVersion).append(archived).append(searchText).append(statuses).append(id).append(qualityRules).append(resumedStatus).append(resumedDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpartaWorkflowExecution) == false) {
            return false;
        }
        SpartaWorkflowExecution rhs = ((SpartaWorkflowExecution) other);
        return new EqualsBuilder().append(marathonExecution, rhs.marathonExecution).append(executionType, rhs.executionType).append(genericDataExecution, rhs.genericDataExecution).append(executionEngine, rhs.executionEngine).append(sparkSubmitExecution, rhs.sparkSubmitExecution).append(spartaVersion, rhs.spartaVersion).append(archived, rhs.archived).append(searchText, rhs.searchText).append(statuses, rhs.statuses).append(id, rhs.id).append(qualityRules, rhs.qualityRules).append(resumedStatus, rhs.resumedStatus).append(resumedDate, rhs.resumedDate).isEquals();
    }

}
