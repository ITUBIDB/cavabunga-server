package edu.itu.cavabunga.entity.parameter;

import edu.itu.cavabunga.entity.Parameter;

public enum ParameterType {
    ACKNOWLEDGED {
        public Parameter create() {
            return new Language();
        }
    },
    ATTACH {
        public Parameter create() {
            return new Language();
        }
    };
    public Parameter create() {
        return null;
    }
}
