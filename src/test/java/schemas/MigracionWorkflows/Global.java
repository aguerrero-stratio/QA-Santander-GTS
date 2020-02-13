
package schemas.MigracionWorkflows;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Global {

    @SerializedName("executionMode")
    @Expose
    private String executionMode;
    @SerializedName("userPluginsJars")
    @Expose
    private List<Object> userPluginsJars = null;
    @SerializedName("preExecutionSqlSentences")
    @Expose
    private List<Object> preExecutionSqlSentences = null;
    @SerializedName("postExecutionSqlSentences")
    @Expose
    private List<Object> postExecutionSqlSentences = null;
    @SerializedName("addAllUploadedPlugins")
    @Expose
    private Boolean addAllUploadedPlugins;
    @SerializedName("mesosConstraintOperator")
    @Expose
    private String mesosConstraintOperator;
    @SerializedName("parametersLists")
    @Expose
    private List<String> parametersLists = null;
    @SerializedName("parametersUsed")
    @Expose
    private List<String> parametersUsed = null;
    @SerializedName("udfsToRegister")
    @Expose
    private List<Object> udfsToRegister = null;
    @SerializedName("udafsToRegister")
    @Expose
    private List<Object> udafsToRegister = null;
    @SerializedName("marathonDeploymentSettings")
    @Expose
    private MarathonDeploymentSettings marathonDeploymentSettings;
    @SerializedName("enableQualityRules")
    @Expose
    private Boolean enableQualityRules;

    public String getExecutionMode() {
        return executionMode;
    }

    public void setExecutionMode(String executionMode) {
        this.executionMode = executionMode;
    }

    public List<Object> getUserPluginsJars() {
        return userPluginsJars;
    }

    public void setUserPluginsJars(List<Object> userPluginsJars) {
        this.userPluginsJars = userPluginsJars;
    }

    public List<Object> getPreExecutionSqlSentences() {
        return preExecutionSqlSentences;
    }

    public void setPreExecutionSqlSentences(List<Object> preExecutionSqlSentences) {
        this.preExecutionSqlSentences = preExecutionSqlSentences;
    }

    public List<Object> getPostExecutionSqlSentences() {
        return postExecutionSqlSentences;
    }

    public void setPostExecutionSqlSentences(List<Object> postExecutionSqlSentences) {
        this.postExecutionSqlSentences = postExecutionSqlSentences;
    }

    public Boolean getAddAllUploadedPlugins() {
        return addAllUploadedPlugins;
    }

    public void setAddAllUploadedPlugins(Boolean addAllUploadedPlugins) {
        this.addAllUploadedPlugins = addAllUploadedPlugins;
    }

    public String getMesosConstraintOperator() {
        return mesosConstraintOperator;
    }

    public void setMesosConstraintOperator(String mesosConstraintOperator) {
        this.mesosConstraintOperator = mesosConstraintOperator;
    }

    public List<String> getParametersLists() {
        return parametersLists;
    }

    public void setParametersLists(List<String> parametersLists) {
        this.parametersLists = parametersLists;
    }

    public List<String> getParametersUsed() {
        return parametersUsed;
    }

    public void setParametersUsed(List<String> parametersUsed) {
        this.parametersUsed = parametersUsed;
    }

    public List<Object> getUdfsToRegister() {
        return udfsToRegister;
    }

    public void setUdfsToRegister(List<Object> udfsToRegister) {
        this.udfsToRegister = udfsToRegister;
    }

    public List<Object> getUdafsToRegister() {
        return udafsToRegister;
    }

    public void setUdafsToRegister(List<Object> udafsToRegister) {
        this.udafsToRegister = udafsToRegister;
    }

    public MarathonDeploymentSettings getMarathonDeploymentSettings() {
        return marathonDeploymentSettings;
    }

    public void setMarathonDeploymentSettings(MarathonDeploymentSettings marathonDeploymentSettings) {
        this.marathonDeploymentSettings = marathonDeploymentSettings;
    }

    public Boolean getEnableQualityRules() {
        return enableQualityRules;
    }

    public void setEnableQualityRules(Boolean enableQualityRules) {
        this.enableQualityRules = enableQualityRules;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("executionMode", executionMode).append("userPluginsJars", userPluginsJars).append("preExecutionSqlSentences", preExecutionSqlSentences).append("postExecutionSqlSentences", postExecutionSqlSentences).append("addAllUploadedPlugins", addAllUploadedPlugins).append("mesosConstraintOperator", mesosConstraintOperator).append("parametersLists", parametersLists).append("parametersUsed", parametersUsed).append("udfsToRegister", udfsToRegister).append("udafsToRegister", udafsToRegister).append("marathonDeploymentSettings", marathonDeploymentSettings).append("enableQualityRules", enableQualityRules).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(marathonDeploymentSettings).append(executionMode).append(userPluginsJars).append(mesosConstraintOperator).append(parametersLists).append(udfsToRegister).append(udafsToRegister).append(postExecutionSqlSentences).append(addAllUploadedPlugins).append(preExecutionSqlSentences).append(enableQualityRules).append(parametersUsed).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Global) == false) {
            return false;
        }
        Global rhs = ((Global) other);
        return new EqualsBuilder().append(marathonDeploymentSettings, rhs.marathonDeploymentSettings).append(executionMode, rhs.executionMode).append(userPluginsJars, rhs.userPluginsJars).append(mesosConstraintOperator, rhs.mesosConstraintOperator).append(parametersLists, rhs.parametersLists).append(udfsToRegister, rhs.udfsToRegister).append(udafsToRegister, rhs.udafsToRegister).append(postExecutionSqlSentences, rhs.postExecutionSqlSentences).append(addAllUploadedPlugins, rhs.addAllUploadedPlugins).append(preExecutionSqlSentences, rhs.preExecutionSqlSentences).append(enableQualityRules, rhs.enableQualityRules).append(parametersUsed, rhs.parametersUsed).isEquals();
    }

}
