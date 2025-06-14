# Sistema de Citas
# 📅 Sistema de Citas Médicas

Un sistema de gestión de citas médicas desarrollado en Java que permite administrar pacientes, doctores y citas de manera eficiente.

## 🚀 Características

### Para Pacientes
- ✅ Registro de nuevos pacientes
- 📋 Consulta de historial médico
- 📅 Programación de citas
- 🔄 Modificación y cancelación de citas
- 📧 Notificaciones de recordatorio

### Para Doctores
- 👨‍⚕️ Gestión de horarios disponibles
- 📊 Visualización de agenda diaria/semanal
- 📝 Registro de consultas
- 👥 Administración de pacientes

### Para Administradores
- 🏥 Gestión completa de usuarios
- 📈 Reportes y estadísticas
- ⚙️ Configuración del sistema
- 💾 Respaldo de información

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java 8+
- **IDE:** NetBeans / IntelliJ IDEA
- **Base de Datos:** MySQL
- **Arquitectura:** MVC (Modelo-Vista-Controlador)
- **Build Tool:** Apache Ant

## 📋 Requisitos del Sistema

### Software Necesario
- Java JDK 8 o superior
- MySQL Server 5.7+
- NetBeans IDE 8.0+ o IntelliJ IDEA

### Requisitos Mínimos
- **RAM:** 4 GB mínimo, 8 GB recomendado
- **Almacenamiento:** 500 MB de espacio libre
- **Sistema Operativo:** Windows 7+, macOS 10.12+, Linux Ubuntu 16.04+

## 🔧 Instalación

### 1. Clonar el Repositorio
```bash
git clone https://github.com/FranciscoDominguez0/Sistema_citas.git
cd Sistema_citas
```

### 2. Configurar Base de Datos
```sql
-- Crear la base de datos
CREATE DATABASE sistema_citas;

-- Importar el esquema
mysql -u root -p sistema_citas < database/schema.sql

-- Importar datos de prueba (opcional)
mysql -u root -p sistema_citas < database/sample_data.sql
```

### 3. Configurar Conexión
Editar el archivo `src/config/DatabaseConfig.java`:
```java
public class DatabaseConfig {
    public static final String URL = "jdbc:mysql://localhost:3306/sistema_citas";
    public static final String USER = "tu_usuario";
    public static final String PASSWORD = "tu_contraseña";
}
```

### 4. Compilar y Ejecutar
```bash
# Compilar el proyecto
ant compile

# Ejecutar la aplicación
ant run
```

## 📖 Uso del Sistema

### Primer Acceso
1. **Usuario:** admin
2. **Contraseña:** admin123
3. Cambiar credenciales después del primer login

### Flujo Típico
1. **Registro de Paciente:** Ingresar datos personales y médicos
2. **Programar Cita:** Seleccionar doctor, fecha y hora disponible
3. **Confirmación:** El sistema envía confirmación automática
4. **Consulta:** El doctor registra la consulta realizada

## 🗂️ Estructura del Proyecto

```
Sistema_citas/
├── src/                          # Código fuente
│   ├── controllers/              # Controladores MVC
│   ├── models/                   # Modelos de datos
│   ├── views/                    # Interfaces gráficas
│   ├── utils/                    # Utilidades y helpers
│   └── config/                   # Configuraciones
├── database/                     # Scripts de base de datos
│   ├── schema.sql               # Esquema de la BD
│   └── sample_data.sql          # Datos de prueba
├── docs/                        # Documentación
│   └── reporte_bd.pdf           # Diseño de base de datos
├── lib/                         # Librerías externas
├── build.xml                    # Script de construcción Ant
└── README.md                    # Este archivo
```

## 📊 Base de Datos

### Tablas Principales
- **usuarios:** Información de usuarios del sistema
- **pacientes:** Datos personales y médicos
- **doctores:** Información de médicos y especialidades  
- **citas:** Registro de citas programadas
- **consultas:** Historial de consultas realizadas

Ver el diagrama completo en: `docs/reporte_bd.pdf`

## 🤝 Contribución

### Cómo Contribuir
1. Fork el proyecto
2. Crear una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -am 'Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Crear un Pull Request

### Estándares de Código
- Usar nomenclatura en español para variables de negocio
- Comentarios en español
- Seguir convenciones de Java (camelCase, etc.)
- Documentar métodos públicos con JavaDoc

## 🐛 Reporte de Errores

Si encuentras un bug, por favor:
1. Verificar que no esté ya reportado en [Issues](https://github.com/FranciscoDominguez0/Sistema_citas/issues)
2. Crear un nuevo issue con:
   - Descripción detallada del problema
   - Pasos para reproducir
   - Entorno (OS, Java version, etc.)
   - Screenshots si es necesario

## 📝 Changelog

### v1.0.0 (Actual)
- ✅ Sistema básico de gestión de citas
- ✅ Autenticación de usuarios
- ✅ CRUD completo para pacientes y doctores
- ✅ Interfaz gráfica con Swing
- ✅ Reportes básicos

### Próximas Versiones
- 🔄 v1.1.0: Notificaciones por email
- 🔄 v1.2.0: Interfaz web
- 🔄 v1.3.0: API REST

## 📞 Soporte

- **Email:** francisco.dominguez@email.com
- **Issues:** [GitHub Issues](https://github.com/FranciscoDominguez0/Sistema_citas/issues)
- **Documentación:** Ver carpeta `docs/`

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## 👨‍💻 Autor

**Francisco Domínguez**
- GitHub: [@FranciscoDominguez0](https://github.com/FranciscoDominguez0)
- Email: francisco.dominguez@email.com

---

⭐ Si este proyecto te fue útil, ¡no olvides darle una estrella!

📚 **Proyecto desarrollado como parte del curso de Ingeniería de Software**
