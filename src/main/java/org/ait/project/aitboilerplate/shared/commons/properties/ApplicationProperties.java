package org.ait.project.aitboilerplate.shared.commons.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties
public class ApplicationProperties {
    private Spring spring;

    @Data
    public static class Spring {
        private Profile profile;
        private Application application;

        @Data
        public static class Profile {
            private String active;
        }
        @Data
        public static class Application {
            private String name;
            private String groupId;
            private String artifactId;
            private String description;
            private String version;
        }
    }
}
