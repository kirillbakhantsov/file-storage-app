# File Storage Application

## Описание решения

Это приложение для хранения файлов, разработанное с использованием Spring Boot и PostgreSQL. Приложение предоставляет API для создания, обновления, получения и удаления файлов. Файлы сохраняются в базе данных в формате Base64.

## Инструкция по запуску приложения

### Требования

- Java 21
- Maven
- PostgreSQL

### Шаги для запуска

1. Клонируйте репозиторий:
    ```bash
    git clone https://github.com/kirillbakhantsov/file-storage-app.git
    cd file-storage-app
    ```

2. Настройте базу данных PostgreSQL:
    - Создайте базу данных:
        ```sql
        CREATE DATABASE filestorage;
        ```

    - Настройте `application.properties` или `application.yml` файл в директории `src/main/resources`:
        ```properties
        spring.datasource.url=jdbc:postgresql://localhost:5432/filestorage
        spring.datasource.username=your-username
        spring.datasource.password=your-password
        spring.jpa.hibernate.ddl-auto=update
        ```

3. Соберите и запустите приложение:
    ```bash
    mvn clean install
    java -jar target/file-storage-0.0.1-SNAPSHOT.jar
    ```

### Примеры тестовых запросов

#### Создание файла

- URL: `POST http://localhost:8080/filestorage/create`
- Тело запроса (JSON):
    ```json
    {
      "title": "Sample File",
      "creationDate": "2024-07-25T12:00:00",
      "description": "This is a sample file.",
      "fileData": "VGhpcyBpcyBhIHRlc3QgZmlsZS4="
    }
    ```
- Пример ответа:
    ```json
    {
      "message": "File created with ID: 1"
    }
    ```

#### Получение файла по ID

- URL: `GET http://localhost:8080/filestorage/1`
- Пример ответа:
    ```json
    {
      "id": 1,
      "title": "Sample File",
      "creationDate": "2024-07-25T12:00:00",
      "description": "This is a sample file.",
      "fileData": "VGhpcyBpcyBhIHRlc3QgZmlsZS4="
    }
    ```

#### Обновление файла

- URL: `PUT http://localhost:8080/filestorage/1`
- Тело запроса (JSON):
    ```json
    {
      "title": "Updated File",
      "creationDate": "2024-07-26T12:00:00",
      "description": "This is an updated file.",
      "fileData": "VGhpcyBpcyBhbiB1cGRhdGVkIGZpbGUu"
    }
    ```
- Пример ответа:
    ```json
    {
      "message": "File updated with ID: 1"
    }
    ```

#### Получение всех файлов

- URL: `GET http://localhost:8080/filestorage`
- Пример ответа:
    ```json
    [
      {
        "id": 1,
        "title": "Sample File",
        "creationDate": "2024-07-25T12:00:00",
        "description": "This is a sample file.",
        "fileData": "VGhpcyBpcyBhIHRlc3QgZmlsZS4="
      },
      {
        "id": 2,
        "title": "Another File",
        "creationDate": "2024-07-26T12:00:00",
        "description": "This is another file.",
        "fileData": "VGhpcyBpcyBhbm90aGVyIHRlc3QgZmlsZS4="
      }
    ]
    ```

#### Удаление файла

- URL: `DELETE http://localhost:8080/filestorage/1`
- Пример ответа:
    ```json
    {
      "message": "File deleted with ID: 1"
    }
    ```

