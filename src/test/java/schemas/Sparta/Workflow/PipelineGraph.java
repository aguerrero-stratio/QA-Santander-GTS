
package schemas.Sparta.Workflow;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PipelineGraph implements Serializable
{

    @SerializedName("nodes")
    @Expose
    private List<Node> nodes = null;
    @SerializedName("edges")
    @Expose
    private List<Edge> edges = null;
    @SerializedName("annotations")
    @Expose
    private List<Object> annotations = null;
    private final static long serialVersionUID = 9140942641331634482L;

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public List<Object> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Object> annotations) {
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("nodes", nodes).append("edges", edges).append("annotations", annotations).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(edges).append(annotations).append(nodes).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PipelineGraph) == false) {
            return false;
        }
        PipelineGraph rhs = ((PipelineGraph) other);
        return new EqualsBuilder().append(edges, rhs.edges).append(annotations, rhs.annotations).append(nodes, rhs.nodes).isEquals();
    }

}
