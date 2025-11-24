# Sistema de Gestión de Restaurantes

Proyecto académico desarrollado para la asignatura de Programación.  
Este sistema modela la operación básica de un restaurante, incluyendo gestión de mesas, pedidos, inventario, facturación y reportes.

## 📁 Estructura del Proyecto
Sistema-Gestion-Restaurantes/
├── docs/ # Documentación del proyecto
│ └── uml/ # Diagramas UML (clases, casos de uso, etc.)
├── src/domain/ # Clases del dominio (según diagrama UML)
    └──utils/ # Clase principal (App.java), utilidades y scripts 
└── README.md # Este archivo


## ⚙️ Requisitos

- Java Development Kit (JDK) 11 o superior
- Entorno de desarrollo compatible con Java (opcional: VS Code, IntelliJ, Eclipse)

## ▶️ Ejecución

1. Compilar desde la raíz del proyecto:

```bash
javac -d out src/main/java/utp/Ac/Pa/sistema/domain/*.java utils/App.java
java -cp out utils.App

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
