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
    2. [¿Existe alguna alternativa en estos momentos a la aplicación oficial del DRAE?](https://github.com/GrenderG/uDRAE-sdk#)
    
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

**Descripción:** Esta llamada permite obtener una lista de palabras que son [anagramas](https://es.wikipedia.org/wiki/Anagrama) de la proporcionada.

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

**Descripción:** Esta llamada permite obtener una lista de palabras que comienzan con los caracteres proporcionados.

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

**Descripción:** Esta llamada permite obtener una lista de palabras que contienen los caracteres proporcionados.

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

**Descripción:** Esta llamada permite obtener una lista de palabras terminadas con los caracteres proporcionados.

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

**Descripción:** Esta llamada permite obtener la información de una palabra en concreto.

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

**Descripción:** Esta llamada permite obtener la definición de la palabra representada por la ID proporcionada.

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

**Llamada `GET`:** `https://dle.rae.es/data/header?id={id}`

**Descripción:** Esta llamada permite obtener la cabecera que hace referencia a la ID proporcionada.

**Respuesta `(id = NEeAr5C)`:**
```json
{ "header":"libertad."}
```

**Modelo usado:** [HeaderResponse](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/models/HeaderResponse.java)

**Método para realizar la llamada:** [`getHeaderById(String id, Callback<HeaderResponse> headerResponseCallback)`](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L84-L86)

## Búsqueda de IDs encontradas en la búsqueda de una palabra

**Llamada `GET`:** `https://dle.rae.es/data/ids?w={word}`

**Descripción:** Esta llamada permite obtener las IDs de las palabras que se encuentran cuando realizamos la búsqueda de una palabra.

**Respuesta `(word = hola)`:**
```json
{ "res" : ["KYtLWBc"] }
```

**Modelo usado:** [IdResponse](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/models/IdResponse.java)

**Método para realizar la llamada:** [`getIdsMatchingWord(String word, Callback<IdResponse> idResponseCallback)`](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L88-L90)

## Búsqueda de palabras que contienen unos carácteres

**Llamada `GET`:** `https://dle.rae.es/data/keys?q={query}&callback=jsonp123`

**Descripción:** Esta llamada permite obtener una lista de palabras que empiezan con los caracteres (query) introducidos. Es muy útil por ejemplo para crear una lista de palabras sugeridas mientras el usuario va introduciendo su búsqueda.

**Respuesta `(query = hol)`:**
```jsonp
jsonp123(["hola","holán","holanda","holandés","holandesa","holandeta","holandilla","holco","holding","holear"])
```

**Modelo usado:** [ArrayList\<String\>](https://developer.android.com/reference/java/util/ArrayList.html)

**Método para realizar la llamada:** [`getSomeMatchingWords(String word, Callback<ArrayList<String>> keysResponseCallback)`](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L104-L106)

## Palabra aleatoria

**Llamada `GET`:** `https://dle.rae.es/data/random`

**Descripción:** Esta llamada devuelve la definición de una palabra aleatoria.

**Respuesta:**
```html
<article id="NEeAr5C">
<header class="f">libertad.</header>
<p class="n2">Del <abbr title="latín">lat.</abbr> <em>libertas, -ātis.</em></p>
<p class="j" id="Jb6hv1z">1. <abbr class="d" title="nombre femenino">f.</abbr> <mark data-id="HTxyZDZ|HTy5CnJ">Facultad</mark> <mark>natural</mark> <mark>que</mark> <mark>tiene</mark> <mark>el</mark> <mark>hombre</mark> <mark data-id="BtDkacL|BtFYznp">de</mark> <mark>obrar</mark> <mark data-id="BtDkacL|BtFYznp">de</mark> <mark data-id="b67JJSq|b6hEWeB|b6iKApr">una</mark> <mark>manera</mark> <mark>o</mark> <mark data-id="BtDkacL|BtFYznp">de</mark> <mark data-id="RLQQxGn">otra</mark>, <mark>y</mark> <mark data-id="BtDkacL|BtFYznp">de</mark> <mark>no</mark> <mark>obrar</mark>, <mark>por</mark> <mark data-id="ESraxkH|NWnohQu|NWofhZh">lo</mark> <mark>que</mark> <mark data-id="EIVnk2C|Xe5Brrm">es</mark> <mark>responsable</mark> <mark data-id="BtDkacL|BtFYznp">de</mark> <mark>sus</mark> <mark>actos</mark>.</p>
<p class="j" id="Jb6kgMf">2. <abbr class="g" title="nombre femenino">f.</abbr> <mark data-id="GjqhajH|GnJiqdL">Estado</mark> <mark>o</mark> <mark>condición</mark> <mark data-id="BtDkacL|BtFYznp">de</mark> <mark>quien</mark> <mark>no</mark> <mark data-id="EIVnk2C|Xe5Brrm">es</mark> <mark>esclavo</mark>.</p>
...
```

**Modelo usado:** [String](https://developer.android.com/reference/java/lang/String.html) (devuelve el HTML con la definición)

**Método para realizar la llamada:** [`getRandomWord(Callback<String> htmlDefinitionCallback)`](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L92-L94)

## Búsqueda de palabras

**Llamada `GET`:** `https://dle.rae.es/data/search?w={word}`

**Descripción:** Esta llamada devuelve una lista de palabras que coinciden con la búsqueda que se ha hecho.

**Respuesta `(word = amo)`:**
```json
{
    "approx":0,
    "res":[
        {"header":"amar.", "id":"2E4Cede", "grp":0},
        {"header":"amo, ma.", "id":"2ND9BMI", "grp":1}
    ]
}
```
**Modelo usado:** [BaseResponse](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/models/BaseResponse.java)

**Método para realizar la llamada:** [`getWordSearchResults(String word, Callback<BaseResponse> wordSearchResultsCallback)`](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L96-L98)

## Palabra del día (WOTD)

**Llamada `GET`:** `https://dle.rae.es/data/wotd?callback=json`

**Descripción:** Esta llamada devuelve información sobre la palabra del día (gestionada por los servidores del DRAE).

**Respuesta:**
```jsonp
json({"header":"versus.","id":"bfyaXi1"})
```

**Modelo usado:** [WOTDResponse](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/models/WOTDResponse.java)

**Método para realizar la llamada:** [`getWordOfTheDay(Callback<WOTDResponse> wotdResponseCallback)`](https://github.com/GrenderG/uDRAE-sdk/blob/master/udrae-sdk/src/main/java/dmoral/es/udrae_sdk/api/UDRAEInteractor.java#L100-L102)

---

# Uso del SDK

## Obteniendo instancia de UDRAEInteractor
```java
UDRAEInteractor udraeInteractor = new UDRAEInteractor(MainActivity.this, UDRAEConfig.getDefaultUDRAEConfig());
```
## Configurando UDRAEConfig

Podemos utilizar la configuración por defecto de `UDRAEConfig` como se está haciendo en el ejemplo de arriba. La configuración por defecto presenta estos valores:

- Duración del cacheo de las llamadas: 30 días.
- Duración del cacheo (para casos en los que no hay internet): 180 días.
- Tamaño de la carpeta que almacenará el caché: 10_485_760 (10 MiB).
- Timeout de la conexión: 15 segundos.
- Nombre de la carpeta que almacenará el caché: udrae-cache

Si quieres personalizar la configuración, puedes hacerlo así:

```java
UDRAEConfig udraeConfig = new UDRAEConfig.Builder()
                .setCacheSize(20 * 1024 * 1024)
                .setCacheDuration(15)
                .setOfflineCacheDuration(360)
                .setCacheFolderName("custom-cache")
                .apply();
```

Y posteriormente pasarle esa instancia de `UDRAEConfig` al constructor de `UDRAEInteractor`.

## Realizando una llamada a la API

Por ejemplo, si queremos realizar una búsqueda exacta podemos hacerlo así:
```java
udraeInteractor.getExactWord("hola", new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d("It works!", response.body().getRes().get(0).getHeader());
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.e("It doesn't work. :(", t.getMessage());
            }
        });
```

En este ejemplo estamos obteniendo la ID del primer resultado que nos devuelve la búsqueda de la palabra *hola*. Después podemos usar esa ID para realizar la búsqueda de la definición por ID.

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
	compile 'com.github.GrenderG:uDRAE-sdk:1.0.2'
}
```

---

# Información adicional

## Motivaciones

Personalmente pienso que la información que proporciona el DRAE (propiedad de la RAE) debería ser de dominio público para que cualquiera pudiera hacer uso de ella de la forma que quisiera (recordemos que la institución se financia también con dinero público) sin tener que encontrarse con la cantidad de licencias restrictivas que poseen las obras de la RAE (tan restrictivas que siendo estrictos ni los buscadores podrían indexar su contenido sin estar infringiendo su propiedad intelectual).

Basándome en mi opinión sobre lo anteriormente expuesto, he considerado hacer pública y accesible la API que utiliza la aplicación de su diccionario para así permitir a todo el mundo tener el derecho de crear sus propias apps de diccionarios o que simplemente utilicen la información que proporciona el DRAE.

## ¿Existe alguna alternativa en estos momentos a la aplicación oficial del DRAE?
<table>
	<tr>
	<td><a href="https://freespanish.github.io/Diccionario/">Diccionario (por freespanish)</a></td>
	<td>Aunque este diccionario no utiliza la API del DRAE, es totalmente funcional y hace uso del contenido original de la RAE.</td>
	</tr>
</table>

¿Haces uso de la API o del DRAE y quieres aparecer aquí? Abre un `issue` o un `Pull Request` con tu aplicación añadida.
---
