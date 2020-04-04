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
          }
        }
      }
}
