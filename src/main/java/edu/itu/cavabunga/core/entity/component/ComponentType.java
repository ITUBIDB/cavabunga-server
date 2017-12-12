package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;

public enum ComponentType {

    CALENDAR {
        private final String name = "VCALENDAR";

        public String toString(){
            return this.name;
        }

        public Component create() {
            return new Calendar();
        }
    },
    ALARM {
        private final String name = "VALARM";

        public String toString(){
            return this.name;
        }

        public Component create(){
            return new Alarm();
        }
    },
    DAYLIGHT {
        private final String name = "VDAYLIGHT";

        public String toString(){
            return this.name;
        }
        public Component create(){
            return new Daylight();
        }
    },
    EVENT {
        private final String name = "VEVENT";

        public String toString(){
            return this.name;
        }

        public Component create() {
            return new Event();
        }
    },
    FREEBUSY {
        private final String name = "VFREEBUSY";

        public String toString(){
            return this.name;
        }
        public Component create(){
            return new Freebusy();
        }
    },
    JOURNAL {
        private final String name = "VJOURNAL";

        public String toString(){
            return this.name;
        }

        public Component create(){
            return new Journal();
        }
    },
    STANDARD {
        private final String name = "VSTANDARD";

        public String toString(){
            return this.name;
        }

        public Component create(){
            return new Standard();
        }
    },
    TIMEZONE {
        private final String name = "VTIMEZONE";

        public String toString(){
            return this.name;
        }

        public Component create(){
            return new Timezone();
        }
    },
    TODO {
        private final String name = "VTODO";

        public String toString(){
            return this.name;
        }

        public Component create(){
            return new Todo();
        }
    };


    public Component create() {
        return null;
    }
}
