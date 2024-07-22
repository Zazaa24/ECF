# Arcadia

L'application web Arcadia a été développé avec java 21 (Dernière version utilisable sur l'hébergeur Heroku) sous Spring boot MVC

## 1. Environnement

### 1.1. Installer une version de java supérieur ou égal à 21

### 1.2. Installer une version de maven récente

### 1.3. Installer PostgreSQL server 16 avec pg admin.

### 1.4. Créer une base de donnée se nommant ECF avec le port 5432, le username postgres et le mot de passe Sarpedon26

## 2. Getting started

### 2.1. Récupérer les sources

```
$ git clone git@github.com:Zazaa24/ECF.git
```

### 2.2. Mettre la configuration spring.sql.init.mode de l'application.properties à always 

### 2.3. Lancer l'application

```
$ mvn spring-boot:run
```


### 2.4. IHM

Il est possible de voir une utilisation de l'API au travers une IHM web accessible à l'adresse : http://localhost:8080/accueil.html
