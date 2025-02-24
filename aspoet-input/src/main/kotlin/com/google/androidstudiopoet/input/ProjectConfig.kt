/*
Copyright 2017 Google Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.google.androidstudiopoet.input

class ProjectConfig {
    lateinit var projectName: String
    lateinit var root: String
    var buildSystemConfig: BuildSystemConfig? = null
    lateinit var moduleConfigs: List<ModuleConfig>
    var repositories: List<RepositoryConfig>? = null
    var classpathDependencies: List<String>? = null

    val pureModuleConfigs : List<ModuleConfig> by lazy { moduleConfigs.filter { it !is AndroidModuleConfig } }
    val androidModuleConfigs: List<AndroidModuleConfig> by lazy { moduleConfigs.filterIsInstance<AndroidModuleConfig>() }

    var jsonText: String = ""
    var buildToolsVersion: String? = buildSystemConfig?.buildToolsVersion
}
