currentBuild.displayName = "SimpleGreeting#"+curentBuild.number
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
              sh """
                sshpass -p $pass1 scp -P 22 $WORKSPACE/target/myweb.jar aw@138.91.160.89:~/
                sshpass -p $pass1 ssh $user1@138.91.160.89 '
                echo $pass1 | sudo -kS mv ~/tmp/*.jar /opt/tomcat/webapps
                echo $pass1 | sudo -kS /opt/tomcat/bin/shutdown.sh
                echo $pass1 | sudo -kS /opt/tomcat/bin/startup.sh
                '
              """ 
              }
          }
        }
      }
}
