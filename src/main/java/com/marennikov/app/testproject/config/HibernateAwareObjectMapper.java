package com.marennikov.app.testproject.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper() {
        Hibernate5Module hm = new Hibernate5Module();
        hm.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, false);
        registerModule(hm);
        configure(SerializationFeature.INDENT_OUTPUT, true);
    }

}