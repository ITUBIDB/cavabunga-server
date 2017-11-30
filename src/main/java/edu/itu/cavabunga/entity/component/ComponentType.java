package edu.itu.cavabunga.entity.component;

import edu.itu.cavabunga.entity.Component;

public enum ComponentType {
    CALENDAR {
        public Component create() {
            return new Calendar();
        }
    },
    EVENT {
        public Component create() {
            return new Calendar();
        }
    };
    public Component create() {
        return null;
    }
}
