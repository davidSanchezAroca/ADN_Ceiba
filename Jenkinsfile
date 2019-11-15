pipeline {
 //Donde se va a ejecutar el Pipeline
                    agent {
                    label 'Slave_Induccion'
                    }
 //Opciones específicas de Pipeline dentro del Pipeline
            options {
                            //Mantener artefactos y salida de consola para el # específico de ejecuciones
                            buildDiscarder(logRotator(numToKeepStr: '3'))
                            //No permitir ejecuciones concurrentes de Pipeline
                            disableConcurrentBuilds()
            }
            //Una sección que define las herramientas para “autoinstalar” y poner en la PATH
            tools {
                    jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
                    gradle 'Gradle5.6_Centos' //Preinstalada en la Configuración del Master
            }
 //Aquí comienzan los “items” del Pipeline
        stages{
                        stage('Checkout') {
                                    steps{
                                    echo "------------>Checkout<------------"
                                    checkout([
                                    $class: 'GitSCM',
                                    branches: [[name: '*/master']],
                                    doGenerateSubmoduleConfigurations: false,
                                    extensions: [],
                                    gitTool: 'Git_Centos',
                                    submoduleCfg: [],
                                    userRemoteConfigs: [[
                                    credentialsId: 'GitHub_david.sanchez',
                                    url:'https://github.com/davidSanchezAroca/ADN_Ceiba.git'
                                    ]]
                                    ])

                                    }
                        }
						
						stage('Build project') { 
							   steps { 
									sh 'gradle --b ./tiendamovie/build.gradle clean'
									sh 'gradle --b ./tiendamovie/build.gradle build'
								}
						}
                        stage('Compile & Unit Tests') {
                                    steps{
                                    echo "------------>Unit Tests<------------"
                                    sh 'gradle --b ./tiendamovie/build.gradle test'
                                    }
                        }
                        stage('Static Code Analysis') {
                                    steps{
                                    echo '------------>Análisis de código estático<------------'
                                        withSonarQubeEnv('Sonar') {
                                        sh "${tool name: 'SonarScanner',type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner-Dproject.settings=./sonar-project.properties"
                                        }
                                    }
                        }

 }
 post {
                failure {
                    echo 'This will run only if failed'
                    mail (to: 'david.sanchez@ceiba.com.co', subject: "Failed Pipeline:${currentBuild.fullDisplayName}",
                            body: "Something is wrong with ${env.BUILD_URL}")
                    }
 }
}
