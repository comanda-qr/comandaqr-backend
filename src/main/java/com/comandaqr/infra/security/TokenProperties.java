package com.comandaqr.infra.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "token")
public class TokenProperties {
  private String secret;
  private long expirationTimeInHours;
  private long expirationTimeInDays;
}