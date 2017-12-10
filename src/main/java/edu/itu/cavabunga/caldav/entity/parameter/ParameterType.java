package edu.itu.cavabunga.caldav.entity.parameter;

import edu.itu.cavabunga.caldav.entity.Parameter;

public enum ParameterType {
    ENCODING {
        public Parameter create() {
            return new Encoding();
        }
    },
    LANGUAGE {
        public Parameter create() {
            return new Language();
        }
    },
    TZID {
        public Parameter create() {
            return new Tzid();
        }
    };

    public Parameter create() {
        return null;
    }
}
