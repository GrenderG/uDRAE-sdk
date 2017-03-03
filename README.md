[![](https://jitpack.io/v/GrenderG/uDRAE-sdk.svg)](https://jitpack.io/#GrenderG/uDRAE-sdk)
# uDRAE-sdk
Con uDRAE-sdk podrás acceder fácilmente a la API del DRAE.

# Tabla de contenidos (en progreso)
1. [Qué es y para qué sirve uDRAE-sdk](https://github.com/GrenderG/uDRAE-sdk#qué-es-y-para-qué-sirve-udrae-sdk)
2. [Llamadas a la API y modelos de respuestas](https://github.com/GrenderG/uDRAE-sdk#llamadas-a-la-api-y-modelos-de-respuestas)
    1. [Anagrama](https://github.com/GrenderG/uDRAE-sdk#anagrama)
    2. [Comienza con](https://github.com/GrenderG/uDRAE-sdk#comienza-con)
    3. [Contiene](https://github.com/GrenderG/uDRAE-sdk#contiene)
    4. [Termina en](https://github.com/GrenderG/uDRAE-sdk#termina-en)
    5. [Búsqueda exacta](https://github.com/GrenderG/uDRAE-sdk#búsqueda-exacta)
    6. [Búsqueda definición por ID](https://github.com/GrenderG/uDRAE-sdk#búsqueda-definicion-por-id)
    7. [Búsqueda de palabras que contienen unos carácteres](https://github.com/GrenderG/uDRAE-sdk#búsqueda-de-palabras-que-contienen-unos-caracteres)
    8. [Palabra aleatoria](https://github.com/GrenderG/uDRAE-sdk#palabra-aleatoria)
    9. [Búsqueda de palabras](https://github.com/GrenderG/uDRAE-sdk#búsqueda-de-palabras)
    10. [Palabra del día](https://github.com/GrenderG/uDRAE-sdk#palabra-del-día)
3. [Uso del SDK](https://github.com/GrenderG/uDRAE-sdk#uso-del-sdk)
    1. [Obteniendo instancia de UDRAEInteractor](https://github.com/GrenderG/uDRAE-sdk#obteniendo-instancia-de-udraeinteractor)
    2. [Configurando UDRAEConfig](https://github.com/GrenderG/uDRAE-sdk#configurando-udrae-config)
    3. [Realizando una llamada a la API](https://github.com/GrenderG/uDRAE-sdk#realizando-una-llamada-a-la-api)
4. [Cómo usar uDRAE-SDK](https://github.com/GrenderG/uDRAE-sdk#cómo-usar-udrae-sdk)
    1. [Añadiendo repositorio de jitpack](https://github.com/GrenderG/uDRAE-sdk#añadiendo-repositorio-de-jitpack)
    2. [Añadiendo depencencia mediante gradle](https://github.com/GrenderG/uDRAE-sdk#añadiendo-dependencia-mediante-gradle)
5. [Información adicional](https://github.com/GrenderG/uDRAE-sdk#información-adicional)
    1. [Motivaciones](https://github.com/GrenderG/uDRAE-sdk#motivaciones)
    
------

# Qué es y para qué sirve uDRAE-sdk

---

# Llamadas a la API y modelos de respuestas

### Anagrama

### Comienza con

### Contiene

### Termina en

### Búsqueda exacta

### Buscar definición por ID

### Búsqueda de palabras que contienen unos carácteres

### Palabra aleatoria

### Búsqueda de palabras

### Palabra del día (WOTD)

---

# Uso del SDK

### Obteniendo instancia de UDRAEInteractor

### Configurando UDRAEConfig

### Realizando una llamada a la API

---

# Cómo usar uDRAE-SDK

### Añadiendo repositorio de jitpack
Añade lo siguiente al `build.gradle` ubicado en la raíz, **no** el del módulo.

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

### Añadiendo dependencia mediante gradle
Añade lo siguiente al `build.gradle` de tu módulo. (Asegúrate de que la versión sea la misma que la del distintivo de arriba)

```gradle
dependencies {
	...
	compile 'com.github.GrenderG:uDRAE-sdk:1.0.0'
}
```

---

# Información adicional

---
