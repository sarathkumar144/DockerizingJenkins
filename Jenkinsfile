node {
    // reference to maven
    def mvnHome = tool 'localMaven'

    // holds reference to docker image
    def dockerImage
    // ip address of the docker private repository(nexus)
   
    
    stage('Clone Repo') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/sarathkumar144/DockerizingJenkins.git'
            
      mvnHome = tool 'localMaven'
    }    
  
    stage('Build Project') {
      // build project via maven
      sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
    }
	
	stage('Tag and Push'){
            	echo "Build Number is ${env.BUILD_NUMBER}"
		git tag "${env.BUILD_NUMBER}"	
                git push origin --tags
         }
		
	stage('Build image') {       
       
         dockerImage = docker.build("sarathkumar14/myspringbootapp:${env.BUILD_ID}")
       
      }      
    
	
      stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
        dockerImage.push("${env.BUILD_NUMBER}")
        }
	      echo "Trying to push docker image to Dockerhub"
      }      
}
