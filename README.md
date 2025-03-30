# APPTareas - Aplicación móvil para agregar tareas  
**Autor: Santiago González Olarte**  

## Descripción de la Aplicación  
Esta aplicación móvil para Android permite a los usuarios personalizar la apariencia de la interfaz mediante la selección de diferentes temas de colores.  
Implementa una arquitectura modular basada en **XML layout, Jetpack Compose y StateFlow**, lo que permite actualizar dinámicamente los colores de la interfaz sin necesidad de reiniciar la aplicación.  

La aplicación cuenta con una pantalla principal y varias pantallas adicionales donde los usuarios pueden interactuar con los datos y cambiar la configuración del tema.  
Los cambios de color se almacenan de forma persistente en **SharedPreferences** para garantizar que la configuración se mantenga entre sesiones.  

---

## Características principales  

### Sistema de cambio de temas dinámico  
La aplicación permite cambiar entre **cuatro esquemas de colores predefinidos**:  

#### 🔆 Tema claro (Light Theme)  
<img src="https://github.com/user-attachments/assets/4363e0ad-b363-4939-997b-605771b0a785" width="130">

#### 🔵 Tema azul (Blue Theme)  
<img src="https://github.com/user-attachments/assets/ebe6c497-8d61-437f-9ad9-5164148e0787" width="130">

#### 🔥 Tema cálido (Warm Theme)  
<img src="https://github.com/user-attachments/assets/3102b38c-c536-4e2b-b264-ca9f2ecf1939" width="130">

---

#### ✅ 1. Estructura de Pantallas y Navegación
##### Pantalla de Inicio:

-Existe MainActivity con activity_main.xml, que contiene un NavHostFragment para manejar la navegación.

-Hay un botón en la pantalla de inicio (Go Details) que permite navegar a la pantalla de detalles. ✅

##### Pantalla de Detalles:

-DetailsScreen muestra información basada en un ViewModel (DetailsViewModel) y LiveData (detailsText). ✅

##### Pantalla de Configuración:

-SettingsScreen permite cambiar la apariencia de la UI globalmente (tema de colores). ✅

#####  Navegación con Navigation Component:

-La navegación entre las pantallas está gestionada con NavHostFragment. ✅

#### ✅ 2. Diseño de la UI
##### XML Layout en la pantalla de inicio:

-activity_main.xml está definido en XML. ✅

##### Jetpack Compose en la pantalla de detalles:

-SettingsScreenContent usa Compose para la UI. ✅

##### Diseño responsivo y accesible:

-Usa Column, Modifier.fillMaxSize(), y padding() en Compose.

-La UI parece adaptarse correctamente a cambios de color y tamaño de pantalla. ✅

#### ✅ 3. Gestión de Estado
##### ViewModel para la lógica:

-DetailsViewModel y SettingsViewModel manejan los datos de la app. ✅

##### LiveData para actualizaciones en tiempo real:

-detailsText.observe(viewLifecycleOwner, Observer { text -> ... }) en DetailsScreen. ✅

#### ✅ 4. Interactividad y UX
##### Cambio de color en la Pantalla de Configuración:

-SettingsScreenContent permite cambiar el color de fondo. ✅

##### Uso de SharedPreferences para guardar el color:

-AppPreferences guarda el índice del tema y ThemeManager lo recupera. ✅

### Tecnologías Utilizadas
Lenguaje: Kotlin

Frameworks y librerías:

-Jetpack Compose

-ViewModel y LiveData

-StateFlow y Flow

-Navigation Component

-SharedPreferences

---

## Capturas

---Home---

<img src="https://github.com/user-attachments/assets/3102b38c-c536-4e2b-b264-ca9f2ecf1939" width="200">

---Details---

<img src="https://github.com/user-attachments/assets/19394217-5e34-4886-b83c-512d48a2f486" width="200">
<img src="https://github.com/user-attachments/assets/93e938c8-56a6-4abb-a6d9-873918ca88c1" width="200">
<img src="https://github.com/user-attachments/assets/7b3354db-4e33-49db-b34b-a5b96eb2c767" width="200">

---Settings---

<img src="https://github.com/user-attachments/assets/f7ec277e-24a7-4ea1-a851-65b1c8563269" width="200">
<img src="https://github.com/user-attachments/assets/ab771cd2-2a94-4caf-a52c-b65b48737835" width="200">

---

## Ejecución
### Opción 1: Instalar el APK directamente

Descarga el APK desde el siguiente enlace:
📥 [Descargar APK](https://github.com/Shanti300/APPTareas/raw/main/app-debug.apk)

En tu dispositivo Android, activa la opción de Orígenes desconocidos en:

-Ajustes > Seguridad > Fuentes desconocidas (puede variar según el dispositivo).

Abre el archivo .apk y sigue las instrucciones para instalarlo.

### Opción 2: Ejecutar en Android Studio

Clonar el repositorio:

#### git clone https://github.com/Shanti300/APPTareas.git cd APPTareas

Abrir en Android Studio:

-Inicia Android Studio y abre la carpeta del proyecto.

-Configurar un dispositivo virtual o conectar un teléfono real:

Si usas un emulador, configúralo en AVD Manager.
Si usas un dispositivo real, activa la Depuración USB en las opciones de desarrollador.

-Ejecutar la aplicación:

Presiona el botón ▶️ en Android Studio o usa el comando: 
#### ./gradlew installDebug

