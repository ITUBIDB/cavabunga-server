package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;

public enum ComponentType {

    CALENDAR {
        private final static String name = "VCALENDAR";

        public String toString(){
            return name;
        }

        public Component create() {
            return new Calendar();
        }
    },
    ALARM {
        private final static String name = "VALARM";

        public String toString(){
            return name;
        }

        public Component create(){
            return new Alarm();
        }
    },
    DAYLIGHT {
        private final static String name = "VDAYLIGHT";

        public String toString(){
            return name;
        }
        public Component create(){
            return new Daylight();
        }
    },
    EVENT {
        private final static String name = "VEVENT";

        public String toString(){
            return name;
        }

        public Component create() {
            return new Event();
        }
    },
    FREEBUSY {
        private final static String name = "VFREEBUSY";

        public String toString(){
            return name;
        }
        public Component create(){
            return new Freebusy();
        }
    },
    JOURNAL {
        private final static String name = "VJOURNAL";

        public String toString(){
            return name;
        }

        public Component create(){
            return new Journal();
        }
    },
    STANDARD {
        private final static String name = "VSTANDARD";

        public String toString(){
            return name;
        }

        public Component create(){
            return new Standard();
        }
    },
    TIMEZONE {
        private final static String name = "VTIMEZONE";

        public String toString(){
            return name;
        }

        public Component create(){
            return new Timezone();
        }
    },
    TODO {
        private final static String name = "VTODO";

        public String toString(){
            return name;
        }

        public Component create(){
            return new Todo();
        }
    };

    public Component create() {
        return null;
    }
}
