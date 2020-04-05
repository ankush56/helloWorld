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
            sh "mv $WORKSPACE/Test/target/*.jar $WORKSPACE/Test/target/myweb.jar"
          }
        }
        stage('Deploy')
        {
          steps
          {
              sshagent(['d1f60b10-5e80-4ca7-b4e4-331ae6a51a3b'])
               {
                // some block
                  sh """
                    scp -o StrictHostKeyChecking=no /target/myweb.war aw@138.91.160.89:/opt/tomcat/webapps/
                    ssh aw@138.91.160.89 /opt/tomcat/shutdown.sh
                    ssh aw@138.91.160.89 /opt/tomcat/startup.sh
                  """
              }
          }
        }
      }
}
