package pl.generali.Spring.exception;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {
    private List<ErrorDetails> errors;
}
