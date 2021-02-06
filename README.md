# causal-priors-extractor ![build status](https://github.com/pathwayanddataanalysis/causal-priors-extractor/workflows/build/badge.svg)
This project extracts causal priors from Pathway Commons database to use in CausalPath.

##Inputs 

1. A BioPAX file downloaded from Pathway Commons. See https://www.pathwaycommons.org/archives/PC2/

2. A blacklist file that provides a classification for ubiquitous small molecules. This file appears in the name "blacklist.txt" in the Pathway Commons archives.

##Output

Causal priors as a SIF file.

##How to build with Maven
```
git pull https://github.com/PathwayAndDataAnalysis/causal-priors-extractor.git
cd causal-priors-extractor
mvn clean install
mvn assembly:single
```
The last command should create `cpe.jar` under `causal-priors-extractor/target` directory. Then you can run the code by
```
java -jar target/cpe.jar <biopax-filename> <blacklist-filename> <output-filename>
```
