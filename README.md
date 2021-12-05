# dns
![Jenkins](https://img.shields.io/jenkins/build/http/trevorism-build.eastus.cloudapp.azure.com/dns)
![Jenkins Coverage](https://img.shields.io/jenkins/coverage/jacoco/http/trevorism-build.eastus.cloudapp.azure.com/dns)
![GitHub last commit](https://img.shields.io/github/last-commit/trevorism/dns)
![GitHub language count](https://img.shields.io/github/languages/count/trevorism/dns)
![GitHub top language](https://img.shields.io/github/languages/top/trevorism/dns)

A webapp that wraps the dns API for trevorism. This helps with automated creation and management of dns

Current version: 0.0.1

Deployed to [DNS](http://dns.project.trevorism.com)

Uses a personal access token to authenticate. Create a property in secrets.properties
```properties
clientId=...
clientSecret=...
accessToken=<personal access token>
```