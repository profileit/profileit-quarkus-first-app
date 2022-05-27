package org.acme.service.impl;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.acme.service.GreetingService;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.logging.Log; 

@ApplicationScoped
public class GreetingServiceImpl implements GreetingService {
	
	@ConfigProperty(name = "greeting.message") 
	String message;

	@ConfigProperty(name = "greeting.suffix", defaultValue="!") 
	String suffix;
	
	@ConfigProperty(name = "greeting.name")
	Optional<String> name;
		
	
	@Override	
	public String greet() {
	     return message + " " + name.orElse("mundo") + suffix;	
	}
	
	void onStart(@Observes StartupEvent ev) {
        Log.info("GreetingService is starting...");
    }
	
    void onStop(@Observes ShutdownEvent ev) {
    	Log.info("GreetingService is stopping...");
    }
	
}
