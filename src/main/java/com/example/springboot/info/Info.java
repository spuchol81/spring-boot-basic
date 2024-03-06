package com.example.springboot.info;

import org.springframework.lang.Nullable;

record Info(
        @Nullable
        String groupId,
        @Nullable
        String artifactId,
        @Nullable
        String version,
        String javaVersion,
        String springBootVersion,
        String springBootProfiles,
        String ipAddress,
        boolean runningInKubernetes
) {
}
