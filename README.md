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
    7. [Búsqueda de cabecera por ID](https://github.com/GrenderG/uDRAE-sdk#búsqueda-de-cabecera-por-id)
    8. [Búsqueda de IDs encontradas en la búsqueda de una palabra](https://github.com/GrenderG/uDRAE-sdk#búsqueda-de-ids-encontradas-en-la-búsqueda-de-una-palabra)
    9. [Búsqueda de palabras que contienen unos carácteres](https://github.com/GrenderG/uDRAE-sdk#búsqueda-de-palabras-que-contienen-unos-caracteres)
    10. [Palabra aleatoria](https://github.com/GrenderG/uDRAE-sdk#palabra-aleatoria)
    11. [Búsqueda de palabras](https://github.com/GrenderG/uDRAE-sdk#búsqueda-de-palabras)
    12. [Palabra del día](https://github.com/GrenderG/uDRAE-sdk#palabra-del-día)
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

## Anagrama

**Llamada `GET`:** `https://dle.rae.es/data/anagram?w={word}`

**Descripción:** Esta llamada nos permite obtener una lista de palabras que son [anagramas](https://es.wikipedia.org/wiki/Anagrama) de la proporcionada.

**Respuesta `(word = amor)`:** 
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
**Modelo usado:** [AnagramResponse](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/models/AnagramResponse.java)

**Método para realizar la llamada:** [`getAnagrams(String word, Callback<AnagramResponse> anagramResponseCallback)`](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L60-L62)

## Comienza con

**Llamada `GET`:** `https://dle.rae.es/data/search?w={wordFragment}&m=31&f=1&t=200`

**Descripción:** Esta llamada nos permite obtener una lista de palabras que comienzan con los caracteres proporcionados.

**Respuesta `(wordFragment = hol)`:**
```json
{
    "approx":0,
    "res":[
        {"header":"hola.", "id":"KYtLWBc", "grp":0},
        {"header":"holán.", "id":"KYujRuK", "grp":1},
        {"header":"holanda.", "id":"KYwHQ7M", "grp":2},
        {"header":"holandés, sa.", "id":"KYwyn6b", "grp":3},
        ...
    ]
}
```

**Modelo usado:** [BaseResponse](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/models/BaseResponse.java)

**Método para realizar la llamada:** [`getWordsStartingWith(String wordFragment, Callback<BaseResponse> startsWithResponseCallback)`](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L64-L66)

## Contiene

**Llamada `GET`:** `https://dle.rae.es/data/search?w={wordFragment}&m=33&f=1&t=200`

**Descripción:** Esta llamada nos permite obtener una lista de palabras que contienen los caracteres proporcionados.

**Respuesta `(wordFragment = aro)`:**
```json
{
    "approx":0,
    "res":[
        {"header":"ácaro.", "id":"0IxSVOR", "grp":0},
        {"header":"acaronar.", "id":"0IyzEHW", "grp":1},
        {"header":"acharolado, da.", "id":"0QBXF9L", "grp":2},
        {"header":"acharolar.", "id":"0QC3gFz", "grp":3},
        {"header":"aerofaro.", "id":"0tpHjYd", "grp":4},
        {"header":"afarolado, da.", "id":"0vj7Xt1", "grp":5},
        ...
    ]
}
```

**Modelo usado:** [BaseResponse](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/models/BaseResponse.java)

**Método para realizar la llamada:** [getWordsContaining(`String wordFragment, Callback<BaseResponse> containsResponseCallback`)](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L67-L69)

## Termina en

**Llamada `GET`:** `https://dle.rae.es/data/search?w={wordFragment}&m=32&f=1&t=200`

**Descripción:** Esta llamada nos permite obtener una lista de palabras terminadas con los caracteres proporcionados.

**Respuesta `(wordFragment = otor)`:**
```json
{
    "approx":0,
    "res":[
        {"header":"aeromotor.", "id":"0uNgCWY", "grp":0},
        {"header":"automotor, ra.", "id":"4TjvnOL", "grp":1},
        {"header":"bimotor.", "id":"5XG64Xm", "grp":2},
        {"header":"botor.", "id":"5zsvMD4", "grp":3},
        ...
    ]
}                                                                        
```

**Modelo usado:** [BaseResponse](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/models/BaseResponse.java)

**Método para realizar la llamada:** [`getWordsEndingWith(String wordFragment, Callback<BaseResponse> endsWithResponseCallback)`](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L71-L73)

## Búsqueda exacta

**Llamada `GET`:** `https://dle.rae.es/data/search?w={word}&m=30`

**Descripción:** 

**Respuesta `(word = libertad)`:**
```json
{
    "approx":0,
    "res":[
        {"header":"libertad.", "id":"NEeAr5C", "grp":0}
    ]
}
```

**Modelo usado:** [BaseResponse](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/models/BaseResponse.java)

**Método para realizar la llamada:** [`getExactWord(String word, Callback<BaseResponse> exactResponseCallback)`](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L75-L77)

## Buscar definición por ID

**Llamada `GET`:** `https://dle.rae.es/data/fetch?id={id}`

**Descripción:** 

**Respuesta `(id = NEeAr5C)`:**
```html
<article id="NEeAr5C">
<header class="f">libertad.</header>
<p class="n2">Del <abbr title="latín">lat.</abbr> <em>libertas, -ātis.</em></p>
<p class="j" id="Jb6hv1z">1. <abbr class="d" title="nombre femenino">f.</abbr> <mark data-id="HTxyZDZ|HTy5CnJ">Facultad</mark> <mark>natural</mark> <mark>que</mark> <mark>tiene</mark> <mark>el</mark> <mark>hombre</mark> <mark data-id="BtDkacL|BtFYznp">de</mark> <mark>obrar</mark> <mark data-id="BtDkacL|BtFYznp">de</mark> <mark data-id="b67JJSq|b6hEWeB|b6iKApr">una</mark> <mark>manera</mark> <mark>o</mark> <mark data-id="BtDkacL|BtFYznp">de</mark> <mark data-id="RLQQxGn">otra</mark>, <mark>y</mark> <mark data-id="BtDkacL|BtFYznp">de</mark> <mark>no</mark> <mark>obrar</mark>, <mark>por</mark> <mark data-id="ESraxkH|NWnohQu|NWofhZh">lo</mark> <mark>que</mark> <mark data-id="EIVnk2C|Xe5Brrm">es</mark> <mark>responsable</mark> <mark data-id="BtDkacL|BtFYznp">de</mark> <mark>sus</mark> <mark>actos</mark>.</p>
<p class="j" id="Jb6kgMf">2. <abbr class="g" title="nombre femenino">f.</abbr> <mark data-id="GjqhajH|GnJiqdL">Estado</mark> <mark>o</mark> <mark>condición</mark> <mark data-id="BtDkacL|BtFYznp">de</mark> <mark>quien</mark> <mark>no</mark> <mark data-id="EIVnk2C|Xe5Brrm">es</mark> <mark>esclavo</mark>.</p>
...
```

**Modelo usado:** [String](https://developer.android.com/reference/java/lang/String.html) (devuelve el HTML con la definición)

**Método para realizar la llamada:** [`getDefinitionById(String id, Callback<String> htmlDefinitionCallback)`](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L79-L81)

## Búsqueda de cabecera por ID

## Búsqueda de IDs encontradas en la búsqueda de una palabra

## Búsqueda de palabras que contienen unos carácteres

## Palabra aleatoria

## Búsqueda de palabras

## Palabra del día (WOTD)

---

# Uso del SDK

## Obteniendo instancia de UDRAEInteractor

## Configurando UDRAEConfig

## Realizando una llamada a la API

---

# Cómo usar uDRAE-sdk

## Añadiendo repositorio de jitpack
Añade lo siguiente al `build.gradle` ubicado en la raíz, **no** el del módulo.

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Añadiendo dependencia mediante gradle
Añade lo siguiente al `build.gradle` de tu módulo. (Asegúrate de que la versión sea la misma que la del distintivo de arriba)

```gradle
dependencies {
	...
	compile 'com.github.GrenderG:uDRAE-sdk:1.0.1'
}
```

---

# Información adicional

## Motivaciones

---
