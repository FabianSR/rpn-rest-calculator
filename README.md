# sanitas-calculator

##Introduccion:

Calculadora para realizar operaciones binarias  (con dos operandos) elementales (sumas, restas). Permite la composición de las mismas.
La entrada debe ser una expresión algebraica representada en notación polaca inversa o postfija (**rpn**) 

##Explicación funcional:


Usar SpringBoot para levantar la aplicación. 

    mvn spring-boot:run

Se expone un único _endpoint_ para una petición POST aunque no realice cambios en el servidor hace posible enviar en el cuerpo del mensaje un json con la expresión compleja en lugar de pasarla como parámetro usando el verbo GET; se debe separar cada término con un espacio en blanco, excepto si se trata del signo del operando.
Por ejemplo:

    curl --header "Content-Type: application/json"   --request POST   --data '{"expression": "3 2 6 - +"}'   http://localhost:8080/calculator/v1/evaluation

La evalución devolverá un json con la expresión evaluada:

    {
        "expression": "-1.0"
    }

Si la expresión de entrada tiene algún error de sintaxis se devolverá el siguiente mensaje dentro de una respuesta http con el código 400 (Bad request):

Si falta algún operando:
    
        EXPRESSION IS NOT COMPLETE
    
Si existe algún carácter no valido

        NON-NUMERIC OPERAND

Si después de las evaluaciones queda más de un operando en la pila se considerará que la expresión no está completa.

Si con todo, se produce alguna otra excepción se devolverá un código 500 (internal service error) con el mensaje 

        ERROR
## Arquitectura

# ![alt text](doc/classDiagram.png)

El _controller_ recibe una petición http POST con la expresion a evaluar como cadena, esta se pasa como entrada a la _bean_ del servicio (ambito singleton) para que la procese; primero la separa en subcadenas utilizando el espacio en blanco como carácter separador, estas subcadenas son usadas como parámetro en una factoría encargada de la construcción de las expresiones. Para ello se combinan el patrón template method y el patrón factory, el primero para simplificar las expresiones y el segundo para encapsularlas según el tipo numérico y poder reemplazarlas por las de otros tipos fácilmente.
Para las trazas y el manejo de excepciones se ha usado Spring AoP y la clase ExceptionsHandler espectivamente para mantener el código los más sencillo posible.

##Instalacion

Añadimos los jar proporcionados para las trazas al classplath del proyecto.
Ejecutamos el comando:

    mvn install:install-file
     -Dfile="%{FILE_PATH}\tracer-1.0.0.jar"
     -DgroupId=io.corp.calculator
     -DartifactId=tracer
     -Dversion=1.0.0
     -Dpackaging=jar

Esto incluirá los jar en la carpeta _.m2_ donde maven busca localmente las librerías que descarga.

Añadimos la dependencia maven al pom

     <dependency>
         <groupId>io.corp.calculator</groupId>
         <artifactId>tracer</artifactId>
         <version>1.0.0</version>
         <scope>compile</scope>
     </dependency>

Si se desea empaquetar el proyecto en un único jar de manera que incluya todas las dependencias añadimos al pom.xml

      <build>
            <plugins>
                <plugin>
                    <artifactId>maven-assembly-plugin</artifactId>
                    <configuration>
                        <archive>
                            <manifest>
                                <mainClass>fully.qualified.MainClass</mainClass>
                            </manifest>
                        </archive>
                        <descriptorRefs>
                            <descriptorRef>jar-with-dependencies</descriptorRef>
                        </descriptorRefs>
                    </configuration>
                </plugin>
            </plugins>
        </build>

y ejecutamos el comando

    mvn clean compile assembly:single

Esto generará en el directorio target el archivo sanitas-calculator-1.0-SNAPSHOT-jar-with-dependencies.jar con la aplicación completa.



