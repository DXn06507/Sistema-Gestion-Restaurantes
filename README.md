# Sistema de Gestión de Restaurantes

Proyecto académico desarrollado para la asignatura de Programación.  
Este sistema modela la operación básica de un restaurante, incluyendo gestión de mesas, pedidos, inventario, facturación y reportes.

## 📁 Estructura del Proyecto
Sistema-Gestion-Restaurantes/
├── docs/ # Documentación del proyecto
│ └── uml/ # Diagramas UML 
├── src/domain/ # Clases del dominio 
         └──main/  #App.java
│  └── utils/   #IOUtils
└── README.md # Este archivo


## ⚙️ Requisitos

- Java Development Kit (JDK) 11 o superior
- Entorno de desarrollo compatible con Java (opcional: VS Code, IntelliJ, Eclipse)

## ▶️ Ejecución

## Compilación y ejecución

Abrir una terminal en la **carpeta raíz del proyecto** (`Sistema-Gestion-Restaurantes/`) y ejecutar los siguientes comandos:

```bash
# Compilar todo el código fuente
javac -d out -sourcepath src src/domain/*.java src/main/App.java src/utils/IOUtils.java

# Ejecutar la aplicación
java -cp out main.App

## 📄 Licencia
Sistema de Gestión de Restaurantes
Proyecto académico – Asignatura de Programación

Autores:
- David Escalona
- Julián Pérez
- Rafael Londoño
- Luis Martínez

Este proyecto se distribuye únicamente con fines educativos. 
Queda prohibida su utilización comercial, modificación con intención de lucro, 
o redistribución sin el consentimiento expreso de los autores.

© 2025 David Escalona, Julián Pérez, Rafael Londoño y Luis Martínez.
Todos los derechos reservados.
