package com.example.facebookclone.config;

//import io.opentelemetry.api.GlobalOpenTelemetry;
//import io.opentelemetry.api.common.Attributes;
//import io.opentelemetry.exporter.zipkin.ZipkinSpanExporter;
//import io.opentelemetry.sdk.OpenTelemetrySdk;
//import io.opentelemetry.sdk.resources.Resource;
//import io.opentelemetry.sdk.trace.SdkTracerProvider;
//import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
//import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class TracingConfig {

//    @Bean
//    public OpenTelemetrySdk openTelemetrySdk() {
//        // Configure Zipkin exporter
//        ZipkinSpanExporter zipkinExporter = ZipkinSpanExporter.builder()
//                .setEndpoint("http://localhost:9411/api/v2/spans")
//                .build();
//
//        // Configure tracer provider with Zipkin exporter
//        SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
//                .addSpanProcessor(BatchSpanProcessor.builder(zipkinExporter).build())
//                .setResource(Resource.create(Attributes.of(ResourceAttributes.SERVICE_NAME, "my-service")))
//                .build();
//
//        OpenTelemetrySdk openTelemetrySdk = OpenTelemetrySdk.builder()
//                .setTracerProvider(tracerProvider)
//                .build();
//
//        // Set the global OpenTelemetry instance
//        GlobalOpenTelemetry.set(openTelemetrySdk);
//        return openTelemetrySdk;
//    }
}
