
package schemas.Sparta.Workflow;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Workflow implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("settings")
    @Expose
    private Settings settings;
    @SerializedName("pipelineGraph")
    @Expose
    private PipelineGraph pipelineGraph;
    @SerializedName("executionEngine")
    @Expose
    private String executionEngine;
    @SerializedName("uiSettings")
    @Expose
    private UiSettings uiSettings;
    @SerializedName("lastUpdateDate")
    @Expose
    private String lastUpdateDate;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("group")
    @Expose
    private Group group;
    @SerializedName("debugMode")
    @Expose
    private Boolean debugMode;
    @SerializedName("versionSparta")
    @Expose
    private String versionSparta;
    @SerializedName("parametersUsedInExecution")
    @Expose
    private ParametersUsedInExecution parametersUsedInExecution;
    @SerializedName("executionId")
    @Expose
    private String executionId;
    @SerializedName("groupId")
    @Expose
    private String groupId;
    private final static long serialVersionUID = -4423382715711367065L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public PipelineGraph getPipelineGraph() {
        return pipelineGraph;
    }

    public void setPipelineGraph(PipelineGraph pipelineGraph) {
        this.pipelineGraph = pipelineGraph;
    }

    public String getExecutionEngine() {
        return executionEngine;
    }

    public void setExecutionEngine(String executionEngine) {
        this.executionEngine = executionEngine;
    }

    public UiSettings getUiSettings() {
        return uiSettings;
    }

    public void setUiSettings(UiSettings uiSettings) {
        this.uiSettings = uiSettings;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Boolean getDebugMode() {
        return debugMode;
    }

    public void setDebugMode(Boolean debugMode) {
        this.debugMode = debugMode;
    }

    public String getVersionSparta() {
        return versionSparta;
    }

    public void setVersionSparta(String versionSparta) {
        this.versionSparta = versionSparta;
    }

    public ParametersUsedInExecution getParametersUsedInExecution() {
        return parametersUsedInExecution;
    }

    public void setParametersUsedInExecution(ParametersUsedInExecution parametersUsedInExecution) {
        this.parametersUsedInExecution = parametersUsedInExecution;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("description", description).append("settings", settings).append("pipelineGraph", pipelineGraph).append("executionEngine", executionEngine).append("uiSettings", uiSettings).append("lastUpdateDate", lastUpdateDate).append("version", version).append("group", group).append("debugMode", debugMode).append("versionSparta", versionSparta).append("parametersUsedInExecution", parametersUsedInExecution).append("executionId", executionId).append("groupId", groupId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(settings).append(lastUpdateDate).append(groupId).append(uiSettings).append(description).append(parametersUsedInExecution).append(executionEngine).append(version).append(executionId).append(name).append(pipelineGraph).append(id).append(debugMode).append(group).append(versionSparta).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Workflow) == false) {
            return false;
        }
        Workflow rhs = ((Workflow) other);
        return new EqualsBuilder().append(settings, rhs.settings).append(lastUpdateDate, rhs.lastUpdateDate).append(groupId, rhs.groupId).append(uiSettings, rhs.uiSettings).append(description, rhs.description).append(parametersUsedInExecution, rhs.parametersUsedInExecution).append(executionEngine, rhs.executionEngine).append(version, rhs.version).append(executionId, rhs.executionId).append(name, rhs.name).append(pipelineGraph, rhs.pipelineGraph).append(id, rhs.id).append(debugMode, rhs.debugMode).append(group, rhs.group).append(versionSparta, rhs.versionSparta).isEquals();
    }

}
