package larvae.gradle.plugin;

import static org.hamcrest.Matchers.*
import static org.junit.Assert.*

import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class SamplePluginTest {

    @Test
    public void test() {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: "larva"

        assertThat(project.tasks.hello, isA(DefaultTask.class))
    }
}
