Simple PoC for GitHub Api.

1. Start:
    - mvn clean package
    - docker-compose up (please be patient it can take even one minute)

2. Endpoint: http://localhost:8080/users/<user> 
For example: http://localhost:8080/users/octocat

3. How to check if database counter works correct:
    - docker ps
    - docker exec -ti <mysql container id> bash
    - mysql -u user -p githubapidb
    - enter password:  password
    - select * from git_hub_user_entity
    
    
