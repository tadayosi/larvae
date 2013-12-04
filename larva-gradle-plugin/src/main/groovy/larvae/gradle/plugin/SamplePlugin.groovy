package larvae.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class SamplePlugin implements Plugin<Project> {
    void apply(Project project) {
        project.task("hello") {
            description = "Says 'hello'."
            doLast { println "Hello!"}
        }
    }
}
