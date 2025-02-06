# Java REST API with Light-4j and MongoDB

A lightweight Java web service implementing REST endpoints for user management, using Light-4j framework and MongoDB for data storage.

## Features

- RESTful endpoints for user management
- Automatic data loading from JSONPlaceholder on startup
- MongoDB integration for data persistence
- Proper HTTP status codes and error handling
- JSON request/response format

## Endpoints

| HTTP Method | Endpoint          | Description                                  |
|-------------|-------------------|----------------------------------------------|
| GET         | /load             | Load initial users (auto-runs on startup)    |
| DELETE      | /users            | Delete all users                             |
| DELETE      | /users/{userId}   | Delete specific user                         |
| GET         | /users/{userId}   | Get user details                             |
| PUT         | /users            | Create new user                              |
| POST        | /users/{userId}   | Update existing user                         |

## Prerequisites

- Java 8+
- Apache Maven 3.6+
- MongoDB 4.4+
- Light-4j framework (managed by Maven)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/java-rest-api.git
   cd java-rest-api