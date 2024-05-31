package ec.edu.ups.ppw63.facturacionTechShop.conf;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TracingConfig {

    public TracingConfig() {
    	init();
    }
    
    public void init() {
        Configuration.SamplerConfiguration samplerConfig = Configuration.SamplerConfiguration.fromEnv()
            .withType("const")
            .withParam(1);
        
        Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv()
            .withLogSpans(true);

        Configuration config = new Configuration("techshop")
            .withSampler(samplerConfig)
            .withReporter(reporterConfig);

        var tracer = config.getTracer();
        io.opentracing.util.GlobalTracer.register(tracer);
    }
}