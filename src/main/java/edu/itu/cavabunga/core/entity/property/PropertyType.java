package edu.itu.cavabunga.core.entity.property;

import edu.itu.cavabunga.core.entity.Property;

public enum PropertyType {
    ACKNOWLEDGED {
        public Property create() {
            return new Acknowledged();
        }
    },
    ACTION {
        public Property create() {
            return new Action();
        }
    },
    ATTACH {
        public Property create() {
            return new Attach();
        }
    },
    ATTENDEE {
        public Property create() {
            return new Attendee();
        }
    },
    CALSCALE {
        public Property create() {
            return new Calscale();
        }
    },
    CATAGORIES {
        public Property create() {
            return new Catagories();
        }
    },
    CLASS {
        public Property create() {
            return new Class();
        }
    },
    COMMENT {
        public Property create() {
            return new Comment();
        }
    },
    COMPLETED {
        public Property create() {
            return new Completed();
        }
    },
    CONTACT {
        public Property create() {
            return new Contact();
        }
    },
    COUNTRY {
        public Property create() {
            return new Country();
        }
    },
    CREATED {
        public Property create() {
            return new Created();
        }
    },
    DESCRIPTION {
        public Property create() {
            return new Description();
        }
    },
    DTEND {
        public Property create() {
            return new Dtend();
        }
    },
    DTSTAMP {
        public Property create() {
            return new Dtstamp();
        }
    },
    DTSTART {
        public Property create() {
            return new Dtstart();
        }
    },
    DUE {
        public Property create() {
            return new Due();
        }
    },
    DURATION {
        public Property create() {
            return new Duration();
        }
    },
    EXDATE {
        public Property create() {
            return new Exdate();
        }
    },
    EXRULE {
        public Property create() {
            return new Exrule();
        }
    },
    FREEBUSY {
        public Property create() {
            return new Freebusy();
        }
    },
    GEO {
        public Property create() {
            return new Geo();
        }
    },
    LASTMOD {
        public Property create() {
            return new Lastmod();
        }
    },
    LOCATION {
        public Property create() {
            return new Location();
        }
    },
    METHOD {
        public Property create() {
            return new Method();
        }
    },
    ORGANIZER{
        public Property create() {
            return new Organizer();
        }
    },
    PERCENT {
        public Property create() {
            return new Percent();
        }
    },
    PRIORITY {
        public Property create() {
            return new Priority();
        }
    },
    PRODID {
        public Property create() {
            return new Prodid();
        }
    },
    RDATE {
        public Property create() {
            return new Rdate();
        }
    },
    RECURID {
        public Property create() {
            return new Recurid();
        }
    },
    RELATED {
        public Property create() {
            return new Related();
        }
    },
    REPEAT {
        public Property create() {
            return new Repeat();
        }
    },
    RESOURCES {
        public Property create() {
            return new Resources();
        }
    },
    RRULE {
        public Property create() {
            return new Rrule();
        }
    },
    RSTATUS {
        public Property create() {
            return new Rstatus();
        }
    },
    SEQ {
        public Property create() {
            return new Seq();
        }
    },
    STATUS {
        public Property create() {
            return new Status();
        }
    },
    SUMMARY {
        public Property create() {
            return new Summary();
        }
    },
    TRANSP {
        public Property create() {
            return new Transp();
        }
    },
    TRIGGER {
        public Property create() {
            return new Trigger();
        }
    },
    TZID {
        public Property create() {
            return new Tzid();
        }
    },
    TZNAME {
        public Property create() {
            return new Tzname();
        }
    },
    TZOFFSETFROM {
        public Property create() {
            return new Tzoffsetfrom();
        }
    },
    TZOFFSETTO {
        public Property create() {
            return new Tzoffsetto();
        }
    },
    TZURL {
        public Property create() {
            return new Tzurl();
        }
    },
    UID {
        public Property create() {
            return new Uid();
        }
    },
    URL {
        public Property create() {
            return new Url();
        }
    },
    VERSION {
        public Property create() {
            return new Version();
        }
    };

    public Property create() {
        return null;
    }
}
