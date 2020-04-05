pipeline
{
    agent any
    environment
    {
      PATH = "/usr/share/maven:$PATH"
    }
    stages
      {
        stage ('Git check')
        {
          steps
          {
            echo "Git check step"
            git 'https://github.com/ankush56/helloWorld'
          }
        }
        stage ('Maven Build')
        {
          steps 
          {
            echo "Maven Build now"
            sh "mvn clean package" 
            sh "mv $WORKSPACE/target/*.jar $WORKSPACE/target/myweb.jar"
          }
        }
        stage('Deploy')
        {
          steps
          {
              sshagent(['new']) {
                // some block
                  sh """
                    scp -o StrictHostKeyChecking=no $WORKSPACE/target/myweb.war aw@138.91.160.89:/opt/tomcat/webapps/
                    ssh aw@138.91.160.89 /opt/tomcat/shutdown.sh
                    ssh aw@138.91.160.89 /opt/tomcat/startup.sh
                  """
              }
          }
        }
      }
}
