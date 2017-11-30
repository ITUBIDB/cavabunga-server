package edu.itu.cavabunga.entity.property;

import edu.itu.cavabunga.entity.Property;

public enum PropertyType {
    ACKNOWLEDGED {
        public Property create() {
            return new Acknowledged();
        }
    },
    ATTACH {
        public Property create() {
            return new Acknowledged();
        }
    };
    public Property create() {
        return null;
    }
}
