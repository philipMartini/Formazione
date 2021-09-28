# Build
mvn clean package && docker build -t udemy.filippo/helloToDo .

# RUN

docker rm -f helloToDo || true && docker run -d -p 8080:8080 -p 4848:4848 --name helloToDo udemy.filippo/helloToDo 