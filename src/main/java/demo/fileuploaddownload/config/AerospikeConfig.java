package demo.fileuploaddownload.config;

import com.aerospike.client.Host;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.config.AerospikeDataSettings;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EnableAerospikeRepositories(basePackages = "demo.fileuploaddownload.repositories")
@ConfigurationProperties(prefix = "aerospike")
public class AerospikeConfig extends AbstractAerospikeDataConfiguration {

    private String namespace;
    private List<AerospikeNode> nodes;

    @Override
    protected Collection<Host> getHosts() {
        List<Host> data  = new ArrayList<>();
        nodes.forEach(d -> data.add(new Host(d.getHost(),d.getPort())));
        return data;
    }

    @Override
    protected String nameSpace() {
        return namespace;
    }

    @Override
    protected void configureDataSettings(AerospikeDataSettings.AerospikeDataSettingsBuilder builder) {
        builder.scansEnabled(true);
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public List<AerospikeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<AerospikeNode> nodes) {
        this.nodes = nodes;
    }

}