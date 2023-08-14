package br.com.guru.backend.usecases.port;

public interface PasswordEncoder {
    String encode(final String password);
}
