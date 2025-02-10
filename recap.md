mvn spring-boot:run

1. Création du projet Spring Boot

Structure de base : Nous avons utilisé Spring Boot pour créer un projet Java, ce qui t’a permis d'utiliser le framework Spring et d'avoir un serveur intégré avec Tomcat.
Fichier pom.xml : Ce fichier contient les dépendances nécessaires à ton application, comme Spring Boot, Thymeleaf, et d'autres. On a vérifié qu'il contenait les bonnes dépendances pour Spring Boot.

2. Configuration de Spring Boot avec application.properties

Base de données : Nous avons configuré la connexion à la base de données MySQL en utilisant le fichier application.properties. Tu as spécifié l'URL, le nom d'utilisateur et le mot de passe de la base de données.
Port du serveur : Tu as défini le port 8081 pour l’application dans application.properties (server.port=8081).
JPA/Hibernate : On a configuré Hibernate pour qu'il mette à jour automatiquement le schéma de la base de données avec spring.jpa.hibernate.ddl-auto=update.

3. Création des classes Spring Boot

Classe principale (MonAppApplication.java) : Nous avons créé une classe principale avec l'annotation @SpringBootApplication, qui est le point d’entrée de l’application Spring Boot. Cette annotation active la configuration de Spring et lance l’application avec SpringApplication.run(MonAppApplication.class, args);.
Contrôleur (HelloController.java) : Nous avons créé un contrôleur pour gérer les requêtes HTTP. Ce contrôleur est annoté avec @RestController, ce qui signifie que ses méthodes retournent des réponses sous forme de données brutes (ici une chaîne de caractères). Nous avons défini une méthode avec l'annotation @GetMapping("/") pour répondre aux requêtes GET sur la racine (/), renvoyant la chaîne "Hello, Spring Boot!".

4. Lancement du serveur Spring Boot

Nous avons démarré l'application avec la commande mvn spring-boot:run, ce qui a permis de lancer le serveur intégré Tomcat sur le port 8081.
Vérification : Après avoir lancé l’application, tu pouvais accéder à l’URL http://localhost:8081/ pour voir la réponse "Hello, Spring Boot!" dans ton navigateur.

5. Configuration de la base de données MySQL via WAMP

Installation et démarrage de WAMP : Tu as installé et démarré WAMP pour utiliser MySQL et phpMyAdmin, qui sont nécessaires pour la gestion de la base de données.
Création de la base de données : Tu as créé une base de données dans MySQL en utilisant phpMyAdmin. C'est à partir de cette base de données que ton application va interagir via JPA.

6. Dépannage et résolution de problèmes

Problèmes de port : Si ton serveur ne démarrait pas correctement, nous avons vérifié le port configuré et l'avons ajusté si nécessaire.
Erreur 404 : Si l'application renvoyait une erreur 404, cela signifiait souvent un problème avec les mappings ou la configuration du contrôleur. On a vérifié l'URL et les annotations dans la classe du contrôleur.
Log et redémarrage : On a également consulté les logs de Spring Boot pour vérifier que le serveur démarrait correctement sans erreurs.
Explication de chaque composant :
@SpringBootApplication : Cette annotation est une combinaison de plusieurs annotations qui inclut @Configuration, @EnableAutoConfiguration, et @ComponentScan. Elle indique à Spring que c'est la classe principale de l'application et lui permet de configurer automatiquement les composants nécessaires.
@RestController : C'est un type de contrôleur dans Spring qui permet de traiter les requêtes HTTP et de renvoyer des données sous forme de JSON ou de texte.
@GetMapping : Cette annotation associe une méthode à une requête HTTP GET. Dans ton cas, on l'a utilisée pour dire que la méthode hello() doit répondre aux requêtes sur la racine /.
SpringApplication.run() : Cette ligne lance l'application Spring Boot et démarre le serveur intégré Tomcat.

Conclusion :

Tu as maintenant une application Spring Boot qui fonctionne, avec un contrôleur simple pour répondre aux requêtes HTTP. Tu as également configuré ta base de données et ton environnement pour interagir avec MySQL via Spring JPA, et tu as pu démarrer ton serveur localement. L'application répond à la racine avec "Hello, Spring Boot!", et tu peux l'étendre avec des fonctionnalités supplémentaires comme la gestion des utilisateurs, la connexion à la base de données, etc.
