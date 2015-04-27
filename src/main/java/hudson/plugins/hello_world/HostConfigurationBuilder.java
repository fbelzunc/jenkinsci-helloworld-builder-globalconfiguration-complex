package hudson.plugins.hello_world;

import hudson.Launcher;
import hudson.Extension;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.tasks.Builder;
import hudson.tasks.BuildStepDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;

import java.util.List;


public class HostConfigurationBuilder extends Builder {

    private final String name;

    @DataBoundConstructor
    public HostConfigurationBuilder(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener) {
        GlobalHelloWorldBuilderConfig globalHelloWorldBuilderConfig;
        globalHelloWorldBuilderConfig = GlobalHelloWorldBuilderConfig.get();
        List<HostConfiguration> hostConfigurationList = globalHelloWorldBuilderConfig.getHostConfiguration();

        listener.getLogger().println("My name is , " + getName() + "!");
        listener.getLogger().println("Below you have my machine configurations");

        for (HostConfiguration hostConfiguration : hostConfigurationList) {
            listener.getLogger().println("---------------------------------");
            listener.getLogger().println("Name: "+ hostConfiguration.getName());
            listener.getLogger().println("HostName: "+ hostConfiguration.getHostname());
            listener.getLogger().println("Username: "+ hostConfiguration.getUsername());
            listener.getLogger().println("Remote Root path: "+ hostConfiguration.getRemoteRootDir());
        }
        return true;
    }

    @Override
    public DescriptorImpl getDescriptor() {
        // see Descriptor javadoc for more about what a descriptor is.
        return (DescriptorImpl)super.getDescriptor();
    }

    @Extension
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {

        public DescriptorImpl() {
            load();
        }

        @Override
        public String getDisplayName() {
            return "List my machines";
        }

        @Override
        public boolean isApplicable(Class type) {
            return true;
        }

    }

}
