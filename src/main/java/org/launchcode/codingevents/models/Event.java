package org.launchcode.codingevents.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Event {

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private static int nextid = 1;

    @Setter(AccessLevel.NONE)
    private int id;
    @EqualsAndHashCode.Exclude
    private String name;
    @EqualsAndHashCode.Exclude
    private String description;

    public Event(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = nextid;
        nextid++;
    }

}
