package hudson.plugins.hello_world;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Created by Felix on 26/04/15.
 */
public class HostConfiguration extends AbstractDescribableImpl<HostConfiguration> {

    private static final long serialVersionUID = 1L;
    private String name;
    private String hostname;
    private String username;
    private String remoteRootDir;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRemoteRootDir() {
        return remoteRootDir;
    }

    public void setRemoteRootDir(String remoteRootDir) {
        this.remoteRootDir = remoteRootDir;
    }

    @DataBoundConstructor
    public HostConfiguration(final String name, final String hostname, final String username, final String remoteRootDir) {
        this.name = name;
        this.hostname = hostname;
        this.username = username;
        this.remoteRootDir = remoteRootDir;
    }

    @Extension
    public static class HostConfigurationDescriptor extends Descriptor<HostConfiguration> {

        @Override
        public String getDisplayName() {
            return "Write here your host configurations";
        }
    }

}
