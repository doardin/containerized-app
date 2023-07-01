# Definindo imagem base
FROM amazoncorretto:17-alpine-jdk

# Definindo diretório de trabalho
WORKDIR /app

# Copiando o diretório .mvn para dentro do diretório de trabalho
COPY .mvn/ .mvn/

# Copiando o arquivo mvnw e pom.xml para dentro do diretório de trabalho
COPY mvnw pom.xml ./

# Copiando o diretório src para dentro do diretório de trabalho
COPY src ./src

# Definindo que o container vai ouvir durante sua execução
EXPOSE 8080

# Definindo o comando de inicialização do container
ENTRYPOINT [ "./mvnw", "spring-boot:run" ]