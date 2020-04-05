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
              withCredentials([usernamePassword(credentialsId: 'aw1234', passwordVariable: 'pass1', usernameVariable: 'user1')]) {
    // some block
                  //scp -o $WORKSPACE/target/myweb.jar aw@138.91.160.89:/opt/tomcat/webapps/
              //    ssh -i tomcat_key aw@138.91.160.89 /opt/tomcat/shutdown.sh
               // ssh -i tomcat_key aw@138.91.160.89 /opt/tomcat/startup.sh
              sh """
                sshpass -p $pass1 ssh $user1@138.91.160.89
              """
    
              }
          }
        }
      }
}
