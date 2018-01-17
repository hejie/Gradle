package com.hejie.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by HE JIE on 17/7/30.
 */
class TestPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create('testTask', TestExtension)
        project.task('testTask') {
            doLast {
                TestExtension ext = project.extensions.testTask
                println ext.enable ? "Hello ${ext.text}!" : 'TestPlugin is disabled.'
            }
        }
        project.afterEvaluate {
            TestExtension ext= project.getExtensions().findByType(TestExtension.class)
            println ext.enable ? "------afterEvaluate-------- ${ext.text}!" : 'TestPlugin is disabled.'
        }

    }
}
