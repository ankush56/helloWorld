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
              withCredentials([sshUserPrivateKey(credentialsId: 'awkey', keyFileVariable: 'tomcat_key', passphraseVariable: '-----BEGIN RSA PRIVATE KEY----- Proc-Type: 4,ENCRYPTED DEK-Info: AES-128-CBC,87F828EB44BE69C051B199E661E6CED7  5q/tT97rNXwy2ln1Rv+aW0fuGVevkY4E30SedNxtoZijdXQABdXRukE3/JMN8xMx cn8v0MqXW7vR86n9b5kAZzGR3Ufeg4YAOvggNVzL5CqDC2rizY0OzCYcueXiHFG1 AjPKYfMkmU8lDjjvjRn/boI27oM09plOnSc/G/ZDH7GFOHDtmD4nY+MDxHpbvi+k aWLXkOau6iP8coFPV+W3g1NOhDkOX8XqiyEAAGGqgMeHHGLGBWmoHq0uEcGKATWj pbV48gDIzxpcYhkhSiRDFndAq2AapfTxbOPi8GxYYDlG8b4S1tvlzw1kI3BexhQ2 ytzZdcsDMmDUIqyRNaKQ3mcTfgFnr3gPOePc1b5Pw1nVypc6WGiD2LlgfKOU0w/r EwkFkz/vc9stOA7nnS5OjEuiYJXqYLONOYOlMeAEXgv1pgIi4hxE5tXYQnPTijBk gYXVlKAGPIyH5BAWOACF80Fb12Xm6Q2zvpx204EtVy3BC5/R2xbh5b5aMuVMvkBr HLhPyjhKxeFHycF69cmLbLvM0J0L5Insrqu+lHC1fi4K4u+h6EMw5eSWW5px1rAh 0T45yydszG6XYof2mf2wrCTMjB1r3W1KCuphpf/7GID2RVXhBg3HBqP7V+/U0dgJ TDK04Sql+Xp8XJ3//TuP27SWUpM9pE9TpOipZGbKg8v/Bkgk6cvgQeVoqVbKnS70 qpfCIXSwbk7n0E4KXs37rcGehzeDokIzRDwVU3RQeuzRks96yI+zCuCutFA8P7K7 9mzzhLRukfTo/ci+mgqhQdy9ylPbdOsXnMsQNf4vuL5/X/Uk00iPkHvVkioUUz++ laXtbeafu5lMEOF9/lmb/b0jxaZXlVphRlEfBgCGnaKkUQQYiJ0058sO0Pk4J7ny rHuQGREtzZDf8EEsk2qY5gHROKxl7UtECcOmK9NkvyQogb37u+6vZ17oHg3W9MCF a0dEP9TwKIgqmPCnPUiUwzBhs0OxpkS09akYJATEBhq23a2uQaqDgH77tnEeKJ8F bNUInHAJw7fJD3R8iu9SJ6dezD4z1F3f4mKJN405YbUQqaLqmCuAp78M8Pimw7i6 Z6R15IXf3ABL0Sp6VV11ie1+aeg0ZN2rluBSZTObgCns3OJgaEfHktxd+KOHiG/H H/RSHE/0puWIHgdm/bbG8TEj9b70EC2565DRncAa7De9VYI97pnaF1Dt8UWDqurO MR508KtIuOnX2RFcBLobaJz+F53uosZN9IbVobGTUGtvGLyUqFM5jBO77vQao4q6 /OiLWfCJhsHlrCumTuiPc8lBFGu03UWRW3E3TA8yRkYtbrOLuA+9D42KemTFZ0ar /9g4Kwm695eELoXdGANfWUZaF6rbnxMouXc8SSZzTNKul7E806BFjVc14cMOHFvU zxKIiFKyROnyfdck1/H4FN8iV+G28P0OvbKExuzC977YMxW66qMaYPohbt0u+AET +Eybo9Go+fPIkXUfuxLlRj8e4Qg+sPvwayQnhgopmEZnmA7x92GPL2w1x7ZALJXx yf/rI0g3m2aOZZOu9u5giI+wI34NrRkINue47ih2tjn6WC30WmbROTCMFqHW4g4S -----END RSA PRIVATE KEY-----', usernameVariable: 'aw')]) {
    // some block
    // some block
                  //scp -o $WORKSPACE/target/myweb.jar aw@138.91.160.89:/opt/tomcat/webapps/
              sh """
                ssh -i tomcat_key aw@138.91.160.89 /opt/tomcat/shutdown.sh
                ssh -i tomcat_key aw@138.91.160.89 /opt/tomcat/startup.sh
              """
    
              }
          }
        }
      }
}
