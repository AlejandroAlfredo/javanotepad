## Bloc de notas hecho en JavaFX

Este bloc de nota está inspirado en el bloc de notas de Windows.

### Requisitos de desarrollo.

* Java 21
* Maven

### ¿Cómo probar la aplicación?

Abres el proyecto y ejecutas el siguiente comando en un nuevo terminal:

```
mvn clean javafx:run 
```

### ¿Cómo construir el proyecto?

**Para constuir el Runtime:**

```
mvn javafx:jlink
```

**Para construir los binarios:**

```
mvn package
```

___

### Screenshot
<p>
<img src="Screenshot/JavaNotepad.png" width="580" alt="JavaNotepad" />
</p>

<p>
<img src="Screenshot/FileDialog.png" width="580" alt="FileDialog"/>
</p>

<p>
<img src="Screenshot/DragAndDropAFile.png" width="580" alt="Drag and Drop File"/>
</p>
