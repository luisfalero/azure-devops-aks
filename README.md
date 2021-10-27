## Login Azure
```
az login
```

## Variable
```
set subscriptionId=a4c2f5f0-bf03-4b51-a844-14406fe9ce03
set resourceGroupName=RSGREU2LUISD01
set aksName=akseu2luisd01
set acrName=acreu2luisd01
set cosmosDbName=codbeu2luisd01
set cosmosDbSql=azure-devops
set cosmosDbContainer=banks
set partitionKey=/code
set locationName=EastUS2
set tags=codApp=LUIS environment=DESA
```

## Resource Group (RG)

### Create RG
```
az group create --name %resourceGroupName% --subscription %subscriptionId% --location %locationName% --tags %tags%
```

## Azure Cosmos DB

### Create Cosmos DB
```
az cosmosdb create --name %cosmosDbName% --subscription %subscriptionId% --resource-group %resourceGroupName% --location regionName=%locationName% --tags %tags%
```

### Create Database
```
az cosmosdb sql database create --account-name %cosmosDbName% --name %cosmosDbSql% --subscription %subscriptionId% --resource-group %resourceGroupName%
```

### Create Container
```
az cosmosdb sql container create --account-name %cosmosDbName% --database-name %cosmosDbSql% --name %cosmosDbContainer% --partition-key-path %partitionKey% --subscription %subscriptionId% --resource-group %resourceGroupName%
```

## Azure Kubernetes Service (AKS)

### Create AKS
```
az aks create --name %aksName% --node-count 2 --generate-ssh-keys --disable-rbac --subscription %subscriptionId% --resource-group %resourceGroupName% --location %locationName% --tags %tags%
```

### Namespace
```
kubectl create namespace luis
kubectl get namespaces

kubectl -n luis delete deploy azure-devops
kubectl -n luis delete svc azure-devops
kubectl -n luis delete hpa azure-devops
kubectl -n luis delete ingress azure-devops

kubectl -n luis get deploy azure-devops
kubectl -n luis get svc azure-devops
kubectl -n luis get hpa azure-devops
kubectl -n luis get ingress azure-devops

kubectl create clusterrolebinding kubernetes-dashboard --clusterrole=cluster-admin --serviceaccount=kube-system:kubernetes-dashboard --user=clusterUser
kubectl delete clusterrolebinding kubernetes-dashboard
az aks browse --name %aksName% --subscription %subscriptionId% --resource-group %resourceGroupName%
```


## Azure Container Registry (ACR)
```
az acr create --name %acrName% --sku Standard --subscription %subscriptionId% --resource-group %resourceGroupName% --location %locationName% --tags %tags%
```

## Kubernetes Helm

### Install Kubernetes Helm
```
https://helm.sh/docs/intro/install/
```

### Create Kubernetes Helm
```
helm create aks
helm package ./aks
helm upgrade
```

