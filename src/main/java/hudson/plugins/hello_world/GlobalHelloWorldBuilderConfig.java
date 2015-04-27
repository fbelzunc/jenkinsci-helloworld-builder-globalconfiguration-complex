package hudson.plugins.hello_world;

import hudson.Extension;
import hudson.model.Hudson;
import hudson.util.CopyOnWriteList;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felix on 26/04/15.
 */

@Extension
public class GlobalHelloWorldBuilderConfig extends GlobalConfiguration {

    private List<HostConfiguration> hostConfiguration = new ArrayList<HostConfiguration>();


    public GlobalHelloWorldBuilderConfig() {
        load();
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        req.bindJSON(this, json);
        return true;
    }

    public List<HostConfiguration> getHostConfiguration() {
        return hostConfiguration;
    }

    public void setHostConfiguration(List <HostConfiguration> hostConfiguration) {
        this.hostConfiguration = hostConfiguration;
        save();
    }

    public static GlobalHelloWorldBuilderConfig get() {
        return GlobalConfiguration.all().get(GlobalHelloWorldBuilderConfig.class);
    }

}
