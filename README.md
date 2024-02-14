TP1 - UML : UML et Principes de POO
===

## Staticus, statica, staticum
### Question 1.1

<!-- Classes | Interfaces -->

- `Device` : Interface, ne contient qu'une commande register().
- `Client` : Classe contenant un attribut de type ImagingDevice.
- `ImagingDevice` : Interface qui étend l'interface Device, ne contient qu'une requête capture() et par définition la commande register().
- `Camera` : Classe abstraite qui implémente l'interface ImagingDevice dont la classe abstraite ou ses sous-classes doivent implémenter les méthodes non implémentées des interfaces et classes héritées. Ces méthodes sont les suivants :
  * register() depuis l'interface Device
  * capture() depuis l'interface ImagingDevice
  * setResolution(int) depuis la classe abstraite elle-même

  La classe abstraite :
    *  peut contenir des méthodes concrètes non final qui seront redéfinies par la ou les sous-classes
    *  peut contenir des méthodes non concrètes
    *  n'est pas instanciable

- `Scanner` : Classe qui implémente l'interface ImagingDevice donc doit implémenter exactement toutes les méthodes non implémentées des interfaces (Device et ImagingDevice). La classe contient en plus la commande warmup(). 
- `DigitalCamera` : Classe qui étend la classe abstraite Camera donc doit implémenter les méthodes non implémentées et issues des interfaces des classes abtraites héritées. Elle contient en plus la méthode (commande) setFlash(bool).
- `WebCam` : Classe qui étend la classe abstraite WebCam donc doit implémenter les méthodes non implémentées issues des interfaces et des classes abtraites héritées. De plus elle doit définir la commande setContrast(float).

### Question 1.2

- L'association `0..1`, peut se traduire par
  ```
  ImagingDevice device = null;
  ```
  ou par
  ```
  ImagingDevice device = new DigitalCamera();  // DigitalCamera est de type ImagingDevice et est instanciable
  ```
  La cardinalité `0..1` signifie que le client à en sa possession un unique périphérique ou aucun périphérique.

  * La classe ``Client01`` représente ce cas (La classe se trouve dans le répertoire response).

- La cardinalité `0..*` signifie que le client peut avoir zéro ou plusieurs périphériques. Cela peut se traduire en Java de la manière suivante :
  ```
  List<ImagingDevice> devices = new ArrayList<ImagingDevice>(); // Par défaut une liste vide de périphériques
  ```
  * La classe ``Client0N`` représente ce cas.
  
Les deux cas représentent la relation d'association.

### Question 1.3

- Le `type statique` représente le type connu dès la compilation du fichier, il s'agit du type donné par le programmeur.

- Le `type dynamique` représente le type connu dès l'exécution du programme. Le type dynamique est souvent un sous-type d'un type statique. Il s'agit d'un type exact.

Voici quelques moyens pour reconnaître le genre de type d'une variable : (moyen mnémotechnique)
* Le type fixé par le programmeur peut être associé à d'autre type sans que cela pose d'erreurs de compilation, il s'agira d'un type dynamique.
* Le type fixé par le programmeur à un type unique, on dira alors qu'il s'agit d'un type statique.

### Question 1.4

- Concernant le `type statique` associant à la variable appareil :
 * ImagingDevice pour la classe Client01
 * List<ImagingDevice> pour la classe Client0N

- Concernant le `type dynamique`, nous avons :
    * La classe DigitalCamera
    * La classe WebCam
    * la classe Scanner
 
### Question 1.5

* Cas 01
***

```mermaid
graph TD;
    Client-->Scanner;
```

* Cas 0N
***

```mermaid
graph TD;
    Client-->Scanner1;
    Client-->Scanner2;
```

```mermaid
graph TD;
    Client-->DigitalCamera;
```

```mermaid
graph TD;
    Client-->WebCam;
```

* Dans les deux cas
***

```mermaid
graph TD;
    Client
```

### Question 1.6

A partir de la variable appareil, on peut accéder, quel que soit le type dynamique aux méthodes register() et capture().

Selon les classes issus des types dynamique, on aura en plus leurs méthodes.
Depuis la classe Scanner, on aura accès aux méthodes suivantes : register(), capture() et warmup().
Depuis la classe WebCam, on aura accès aux méthodes suivantes : register(), capture(), setResolution(int) et setContrast(float).
Depuis la classe DigitalCamera, on aura accès aux méthodes suivantes : register(), capture(), setResolution(int) et setFlash(bool).

***

## Principes de base

### Question 2.1

Le contenu du répertoire poly a été récupéré. L'import a été fait.

### Question 2.2

Les paquetages sont les suivantes :
  * polynome
  * test
  * wonderland.graphicPackageYoullNeverFind

Tous ces paquetages sont inclus dans le répertoire poly.

Les entités sont les suivants :
  * La classe Polynome se trouvant dans le paquetage polynome
  * La classe Test se trouvant dans le paquetage test
  * La classe WonderPlotCanvas (N'existe pas pour le moment) mais se trouverait dans le paquetage wonderland.

Les relations sont les suivantes :
  * L'association depuis la classe Test vers la classe Polynome
  * L'association depuis la classe Polynome vers la classe WonderPlotCanvas

#### Voici le diagramme UML

```mermaid
---
title: Diagramme de classe
---
classDiagram
    Polynome  <.. Test
    WonderPlotCanvas  <.. Polynome
    class Polynome {
        +getDegree() int
        +getCoefficient(int i) double
        +computeValue(double x) double
        +sum(Polynome p) Polynome
        +prod(Polynome p) Polynome
        +plot(double x1, double x2, double stepx, WonderPlotCanvas canvas)
        -coefficents : double
    }

   class Test

   class WonderPlotCanvas {
      +moveTo(double x, double y)
      +lineTo(double x, double y)
   }
```

### Question 2.3

Les principes suivent l'acronyme SOLID
  * S pour __`Single Responsability`__
    Cela correspond au fait qu'une classe doit avoir une seule et unique responsabilité
    Dans notre cas :
    - La classe Polynome réalise deux choses distinctes qui sont les choses suivantes :
      * Les opérations dédiées aux polynômes telles que l'addition, le produit
      * L'opération d'affichage du polynôme
    Elle a donc deux responsabilités.
    - La classe Test ne contenant que la fonction statique dénommée main est utilisée uniquement pour le test de la classe Polynôme.
    - La classe WonderPlotCanvas n'étant pas programmé, je ne peux donc que supposer. Cette dernière étant utilisé pour le rendu graphique d'un polŷnome et uniquement pour cela.
   On peut donc dire que les classes Test et WonderPlotCanvas respecte le principe SRP. Seule la classe Polynome ne respecte pas ce principe.

  * 0 pour __`Open/Close`__
    Lorsque qu'une classe est dite stable, cela signifie que les entités d'une classe doit être ouvert en cas d'extension mais en cas de modification doit être fermée. Lorsqu'on souhaite corriger alors réouverture en extension. Si l'on souhaite apporter plus de fonctionnalité, de nouveaux besoins alors il est préférable de réaliser une nouvelle classe qui étend la précédente. Selon moi, la classe Test peut être modifié à l'avenir donc susceptible de ne pas respecter le principe OC.

    --> Ce principe peut être enfreint car possibilité d'incompréhension et ou d'erreur humaine.

  * L pour __`Liskov Substitution`__
    Le sous-typage doit s'appliquer au TDA (Type de données abstraits), cela induit que n'importe quel sous classe d'une classe peut être interchangée avec cette dernière sans en altérer la compréhension. Par exemple dans l'exemple du cours, on sait qu'un carré est un rectangle mais théoriquement parlant un carré ne peut être un rectangle de part ses propriétés.
    Pour le moment nous n'avons pas de sous classes, mais pour respecter ce principe, la sous-classe ne doit pas alterer le fonctionnement de la super-classe.
    La formule est donc la suivante : Si S est une sous-classe de T, alors les objets de type T peuvent être remplacés par des objets de type S.

  * I pour __`Interface Segregation`__
  Plusieurs types de clients impliquent plusieurs interfaces ! Cela implique une analyse des responsabilités d'une classe afin de les séparer en plusieurs classes ou interfaces. Cela induit donc une différenciation des notions qui peut être utiliser par un simple client. Le couplage client et interfaces est donc plus accessible.
    - Admettons que WonderPlotCanvas est une classe (je dis depuis le début qu'il s'agit d'une classe mais nous ne le savons pas), nous saurons que cela ne respectent pas le principe ISP.
    - Admettons maintenant que WonderPlotCanvas est une interface, alors cela respecte ce principe.
    - Concernant la classe Polynome, elle ne respecte pas le principe de ISP, car les responsabilités ne sont pas séparer ainsi que le couplage client et classes se multiplient donc.

Un client représente ici un élément qui utilise une autre classe. Celui qui est à l'origine de l'utilisation de cette classe est donc le client.

  * D pour __`Dependency Inversion`__


### Question 2.4

Il s'agit d'une relation d'héritage entre les classes Polynome et Monome. Monome doit donc redéfinir certaines méthodes afin de correspondre à la notion d'un Monome.

### Question 2.5

Monome étendra donc la classe Polynome car elle est une sorte de Polynome. La où est attendue la classe Polynome, la classe Monome peut y être associée. Lors du constructeur on doit ajouter comme paramètre du constructeur de la super-classe qu'est Polynome : Le tableau représentant le monome. Par exemple ceci représenterait

  ```
    {0.0, 0.0, 1.0} ==> int degree = 2;
  ```

le monome qui suit `x²`.

Cela est correct, mais cela ne respecte pas les principes énoncées plus tôt. Il ne s'agit pas de nouvelles fonctionnalité donc ne respecte pas le principe de Open/Close. De plus la classe serait vide de méthode, ni de requêtes. Absence d'attributs. Cela montrerait une absence d'ajout de fonctionnalités. De plus il n'a pas besoin d'un tableau contenant que des 0 avec comme dernier élément un 1. 
Pour avoir cet impression de nouveauté, j'ajoute seulement un unique attribut privée qui représentera uniquement le degré du monome. Dans notre exemple le degre vaudra donc 2.

### Question 2.6

Je dois donc redéfinir les méthodes suivantes dans la classe Monome :
- getDegree
- getCoefficient
- computeValue
- sum

Car on ajoute deux attributs absent au départ :
- coefficient
- degree

***
***
*TODO* A faire
**Réaliser le diagramme UML de la nouvelle architecture**

***
***

### Question 2.7


***
***
*TODO* A faire
***
***


### Question 2.8


***
***
*TODO* A faire
***
***


### Question 2.9


***
***
*TODO* A faire
***
***

