package com.kk.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.kk.endpoints.TopicJerseyRestService;

@Component
public class JerseyConfig extends ResourceConfig{
			public JerseyConfig() {
				register(TopicJerseyRestService.class);
			}
}
