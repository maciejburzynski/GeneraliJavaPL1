package pl.generali.Spring.laptop;

import lombok.Getter;

@Getter
public enum Make {
    LENOVO("Lenovo"),
    MACBOOK("MacBook");

    private String value;

    Make(String value) {
        this.value = value;
    }
}
