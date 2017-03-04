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
4. [Cómo usar uDRAE-sdk](https://github.com/GrenderG/uDRAE-sdk#cómo-usar-udrae-sdk)
    1. [Añadiendo repositorio de jitpack](https://github.com/GrenderG/uDRAE-sdk#añadiendo-repositorio-de-jitpack)
    2. [Añadiendo depencencia mediante gradle](https://github.com/GrenderG/uDRAE-sdk#añadiendo-dependencia-mediante-gradle)
5. [Información adicional](https://github.com/GrenderG/uDRAE-sdk#información-adicional)
    1. [Motivaciones](https://github.com/GrenderG/uDRAE-sdk#motivaciones)
    
------

# Qué es y para qué sirve uDRAE-sdk

uDRAE-sdk es un conjunto de métodos que permite acceder a la API del DRAE. 

En sus entrañas se encuentra [Retrofit](http://square.github.io/retrofit/), por lo que si ya has trabajado con esta librería no tendrás ningún problema en entender el funcionamiento de uDRAE-sdk, puesto que utiliza sus [Callbacks](https://square.github.io/retrofit/2.x/retrofit/retrofit2/Callback.html).

---

# Llamadas a la API y modelos de respuestas

En este apartado se listan las llamadas realizadas a la API junto con su respuesta y el POJO utilizado en uDRAE-sdk. 

Si entráis en cada modelo podréis observar qué significa cada atributo.

### Anagrama

Llamada `GET`: `https://dle.rae.es/data/anagram?w={word}`

Respuesta `(word = amor)`: 
```json
{
  "approx":0,
  "res":[
    {"word":"Roma", "header":"Roma.", "id":"WdJDhRZ"},
    {"word":"amor", "header":"amor.", "id":"2PGmlay"},
    {"word":"armo", "header":"armar.", "id":"3aoPllh"},
    ...
  ]
}
```
Modelo usado: [BaseResponse](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/models/BaseResponse.java)

Método para realizar la llamada: [`getAnagrams(String word, Callback<BaseResponse> anagramResponseCallback)`](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L59-L61)

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

# Cómo usar uDRAE-sdk

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

### Motivaciones

---
