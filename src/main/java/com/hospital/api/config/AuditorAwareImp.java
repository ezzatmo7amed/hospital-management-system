package com.hospital.api.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImp implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        // should get userName from spring security
        return Optional.of("test user");
    }
}
