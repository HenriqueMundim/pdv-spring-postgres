package com.personalprojects.pdv.domain.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandardException {
    private Instant date;
    private String path;
    private String cause;

    @Override
    public String toString() {
        return "\"date\": " + this.getDate() + "," + "\n"
                + " \"path\": " + this.getPath() + "," + "\n"
                + " \"message\": " + this.getCause();
    }
}
