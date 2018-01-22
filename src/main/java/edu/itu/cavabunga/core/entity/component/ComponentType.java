package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;

public enum ComponentType {

    CALENDAR {
        public Component create() {
            return new Calendar();
        }
    },
    ALARM {
        public Component create(){
            return new Alarm();
        }
    },
    DAYLIGHT {
        public Component create(){
            return new Daylight();
        }
    },
    EVENT {
        public Component create() {
            return new Event();
        }
    },
    FREEBUSY {
        public Component create(){
            return new Freebusy();
        }
    },
    JOURNAL {
        public Component create(){
            return new Journal();
        }
    },
    STANDARD {
        public Component create(){
            return new Standard();
        }
    },
    TIMEZONE {
        public Component create(){
            return new Timezone();
        }
    },
    TODO {
        public Component create(){
            return new Todo();
        }
    };

    public Component create() {
        return null;
    }
}
