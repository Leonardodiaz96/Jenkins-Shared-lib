"""def call(String kubeconfigCredId, String manifestsPath = "k8s") {
    echo "Deploying to Kubernetes..."
    kubeconfig(credentialsId: kubeconfigCredId, serverUrl: "") {
        sh """

        """
    }
}
"""

def call(String kubeconfigFileCredId, String manifestsPath = "k8s") {
  echo "Deploying to Kubernetes..."

  withCredentials([file(credentialsId: kubeconfigFileCredId, variable: 'KUBECONFIG')]) {
    sh """
      set -eux
      kubectl version
      kubectl apply -f ${manifestsPath}/deployment.yaml
      kubectl apply -f ${manifestsPath}/service.yaml
      kubectl rollout status deployment/flask-deployment
    """
  }
}