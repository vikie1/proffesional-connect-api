# What is proffesional-connect-api
Skillhub will be a medium for creators, professionals, artists and other form of individual talents
to join a pool of other similar or interdependent talents with aim of collaboration, sharing tools of
work, connecting interdependent projects and consequently showcasing their progress or final
products to a community of like-minded and interested individuals or parties before finally shipping
it to the market.<br>
Skillhub aims to be primarily focused on developing a platform that is explicitly designed with aim
of creating an environment that is favorable for projects, art, startups and other forms of creation
free of distraction from unrelated ‘internet noise’.

check more about it <a href="https://github.com/vikie1/proffesional-connect-api/doc/skillhub.pdf">here</a>

<strong>The project is not complete as it does not have a front-end yet</strong><br>
There are no current live versions

# Setting it up
## Requirements
<ul>
<li>Java 17 -> check system.properties or pom.xml for changes</li>
<li>Maven</li>
<li>PostGresQl database</li>
<li>An email and a mail server</li>
</ul>

Recommended:
<ul>
<li>IntellijIdea IDE</li>
</ul>

## Configuration
Follow the configuration format in the application.properties file under the src/main/resources/ directory to:<br>
=> provide the link, username and password of your postgresql database instance, my production details are hidden and will be injected during runtime after deployment.<br>
=> provide the configuration of your mail server. <br>
<strong>The application.properties file could contain sensitive files so you have to cross-check before making it public</strong>

## Installation, packaging and execution
We shall use maven to cary out the build task.

->for local tests, use: <br>
`$ mvn spring-boot:run` -> (you can relace mvn with the ./mvnw for *nix/*nix-like systems or .mvnw.cmd for ms-windows)<br>
->if that works then it's time to deploy<br>
`$ mvn clean package` -> this creates a project-api-{version-number}.jar file under the /target directory.<br>
`$ java -jar project-api-{version-number}.jar` -> to run locally<br>