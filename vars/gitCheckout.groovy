def call(String repoUrl, String branch, String credId) {
    echo "Checking out code from ${repoUrl}..." //message in Jenkins console
    checkout([
        $class: 'GitSCM', //pulling the code from the git
        branches: [[name: branch]],
        userRemoteConfigs: [[credentialsId: credId, url: repoUrl]]
    ])
}