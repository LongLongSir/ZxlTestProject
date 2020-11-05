package com.studyspringboot.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentView implements EnvironmentAware {

    @Autowired
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        //this.environment=environment;

        String s = environment.getProperty("ssf.vsla.tt");
    }


}
