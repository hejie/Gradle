package com.hejie.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by HE JIE on 17/7/30.
 */
class GreetingPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create('greet', GreetingExtension)
        project.task('greet') {
            doLast {
                GreetingExtension ext = project.extensions.greet;
                println ext.enable ? "Hello ${ext.text}!" : 'GreetingPlugin is disabled.'
            }
        }
    }
}
