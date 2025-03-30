# APPTareas - Aplicación móvil para agregar tareas  
**Autor: Santiago González Olarte**  

## Descripción de la Aplicación  
Esta aplicación móvil para Android permite a los usuarios personalizar la apariencia de la interfaz mediante la selección de diferentes temas de colores.  
Implementa una arquitectura modular basada en **Fragments, Jetpack Compose y StateFlow**, lo que permite actualizar dinámicamente los colores de la interfaz sin necesidad de reiniciar la aplicación.  

La aplicación cuenta con una pantalla principal y varias pantallas adicionales donde los usuarios pueden interactuar con los datos y cambiar la configuración del tema.  
Los cambios de color se almacenan de forma persistente en **SharedPreferences** para garantizar que la configuración se mantenga entre sesiones.  

---

## Características principales  

### 🎨 Sistema de cambio de temas dinámico  
La aplicación permite cambiar entre **cuatro esquemas de colores predefinidos**:  

#### 🔆 Tema claro (Light Theme)  
<img src="https://github.com/user-attachments/assets/4363e0ad-b363-4939-997b-605771b0a785" width="300">

#### 🔵 Tema azul (Blue Theme)  
<img src="https://github.com/user-attachments/assets/ebe6c497-8d61-437f-9ad9-5164148e0787" width="300">

#### 🔥 Tema cálido (Warm Theme)  
<img src="https://github.com/user-attachments/assets/3102b38c-c536-4e2b-b264-ca9f2ecf1939" width="300">

---

### 🛠 Persistencia de configuración  
✔ Utiliza **SharedPreferences** para almacenar la preferencia de color seleccionada y restaurarla en futuras ejecuciones.  

### 🏗 Arquitectura basada en ViewModel y StateFlow  
✔ Los cambios en los colores se gestionan mediante un **ViewModel** y **StateFlow**, lo que permite una reactividad eficiente en la interfaz.  

### 📱 Interfaz combinada con Jetpack Compose y XML  
✔ Mientras que algunas pantallas usan **Jetpack Compose**, otras conservan la estructura **XML tradicional con ViewBinding**.  

### 🔀 Fragmentos y navegación  
✔ La aplicación utiliza **NavHostFragment** para gestionar la navegación entre diferentes pantallas.  

---

💡 **¡Personaliza tu experiencia con diferentes temas y mejora la usabilidad de la aplicación!** 🚀
