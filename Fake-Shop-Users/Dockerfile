# Define a imagem base a ser utilizada
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho da aplicação
WORKDIR /app

# Copia os arquivos de build para o container
COPY build/libs/fake-shop-users-0.0.1-SNAPSHOT.jar /app/fake-shop-users.jar

# Expõe a porta utilizada pela aplicação
EXPOSE 8080

# Define o comando a ser executado quando o container iniciar
CMD ["java", "-jar", "fake-shop-users.jar"]